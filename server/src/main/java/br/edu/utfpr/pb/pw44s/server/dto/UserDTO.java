package br.edu.utfpr.pb.pw44s.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @NotNull
    @Size(min = 4, max = 50)
    private String displayName;

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

    @NotNull(message = "O e-mail é obrigatório.")
    @Email(message = "O formato do e-mail é inválido.")
    private String email;

    @NotNull(message = "O CPF é obrigatório.")
    @Size(min = 11, max = 14, message = "O CPF deve conter entre 11 e 14 caracteres.")
    private String cpf;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "^[0-9]{10,11}$",
            message = "O telefone deve conter apenas números, com DDD (10 ou 11 dígitos).")
    private String phone;


}