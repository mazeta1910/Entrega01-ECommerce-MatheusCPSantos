package br.edu.utfpr.pb.pw44s.server.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarrierDTO {

    private Long id;

    @NotBlank(message = "O nome da transportadora é obrigatório.")
    private String name;

    @NotNull(message = "A taxa base de frete é obrigatória.")
    @PositiveOrZero(message = "A taxa base não pode ser negativa.")
    private BigDecimal baseRate;

    @NotNull(message = "O prazo estimado de entrega é obrigatório.")
    @PositiveOrZero(message = "O prazo estimado não pode ser negativo.")
    private Integer estimatedDeliveryDays;

    private Boolean isActive;
}