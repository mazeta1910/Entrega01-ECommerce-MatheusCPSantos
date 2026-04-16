package br.edu.utfpr.pb.pw44s.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    @NotBlank(message = "O nome de usuário é obrigatório.")
    @Size(min = 4, max = 50)
    private String username;

    @NotBlank(message = "O nome de exibição é obrigatório.")
    @Size(min = 4, max = 50)
    private String displayName;

    @NotBlank(message = "O nome completo é obrigatório.")
    @Size(min = 5, max = 150, message = "Insira seu nome completo.")
    private String fullName;

    @NotNull(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#]).*$",
            message = "A senha deve conter pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial."
    )
    private String password;

    @NotBlank(message = "A confirmação de senha é obrigatória.")
    private String confirmPassword;

    @JsonIgnore
    @AssertTrue(message = "As senhas informadas não coincidem.")
    public boolean isPasswordsMatch() {
        if (password == null || confirmPassword == null) {
            return true;
        }
        return password.equals(confirmPassword);
    }

    // --- NOVOS CAMPOS NEXUS ---

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento deve estar no passado.")
    private LocalDate birthDate;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "O formato do e-mail é inválido.")
    private String email;

    @NotBlank(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 14, message = "O CPF deve conter entre 11 e 14 caracteres.")
    private String cpf;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "^[0-9]{10,11}$",
            message = "O telefone deve conter apenas números, com DDD (10 ou 11 dígitos).")
    private String phone;

    private Boolean newsletterSubscription;

    private Long parentId;

     /**
     * Validação do ECA Digital (2026):
     */
    @JsonIgnore
    @AssertTrue(message = "Idade inválida para cadastro ou falta de vínculo parental.")
    public boolean isValidAgePolicy() {
        if (birthDate == null) return true;

        int age = java.time.Period.between(birthDate, LocalDate.now()).getYears();

        // 1. Bloqueio total abaixo de 12 anos
        if (age < 12) return false;

        // 2. Exigência de supervisor para menores de 16 anos
        if (age < 16 && parentId == null) return false;

        return true;
    }

     /*
     * Método utilitário para verificar se é maior de idade.
     */

    @JsonIgnore
    public boolean isAdult() {
        if (birthDate == null) {
            return false;
        }
        int age = java.time.Period.between(birthDate, LocalDate.now()).getYears();
        return age >= 18;
    }
}