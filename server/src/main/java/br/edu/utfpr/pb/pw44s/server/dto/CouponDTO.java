package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponDTO {

    private Long id;

    @NotBlank(message = "O código do cupom é obrigatório.")
    private String code;

    @NotNull(message = "O valor de desconto é obrigatório.")
    @Positive(message = "O desconto deve ser maior que zero.")
    private BigDecimal discountValue;

    @NotNull(message = "A data de validade é obrigatória.")
    @FutureOrPresent(message = "A data de validade não pode estar no passado.")
    private LocalDate validity;

    private Boolean isActive;
    private Boolean firstPurchaseOnly;
}