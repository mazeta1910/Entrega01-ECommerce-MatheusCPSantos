package br.edu.utfpr.pb.pw44s.server.dto;

import br.edu.utfpr.pb.pw44s.server.model.enums.DiscountType;
import br.edu.utfpr.pb.pw44s.server.model.enums.TargetType;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CouponDTO {
    private Long id;

    @NotBlank(message = "O código do cupom é obrigatório.")
    private String code;

    @NotNull(message = "O valor de desconto é obrigatório.")
    @Positive(message = "O desconto deve ser positivo.")
    private BigDecimal discountValue;

    @NotNull(message = "O tipo de desconto é obrigatório.")
    private DiscountType type;

    @NotNull(message = "A data de início é obrigatória.")
    private LocalDate startDate;

    @NotNull(message = "A data de término é obrigatória.")
    private LocalDate endDate;

    @NotNull(message = "O alvo do cupom é obrigatório.")
    private TargetType targetType;

    private Long targetId;
    private BigDecimal minPurchaseValue;
    private Boolean active;
    private Boolean firstPurchaseOnly;
    private String discountTypeDescription;
    private String targetTypeDescription;
}