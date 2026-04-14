package br.edu.utfpr.pb.pw44s.server.model;

import br.edu.utfpr.pb.pw44s.server.model.enums.DiscountType;
import br.edu.utfpr.pb.pw44s.server.model.enums.TargetType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_coupon")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 50, unique = true)
    private String code;

    @NotNull
    @Column(precision = 10, scale = 2, name = "discount_value")
    private BigDecimal discountValue;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type")
    private DiscountType type; // FIXED ou PERCENTAGE

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date")
    private LocalDate endDate; // Substitui o antigo 'validity' para o agendamento

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "target_type")
    private TargetType targetType; // ALL, CATEGORY, PRODUCT

    @Column(name = "target_id")
    private Long targetId; // ID da categoria ou produto alvo

    @Column(name = "min_purchase_value", precision = 10, scale = 2)
    private BigDecimal minPurchaseValue;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "first_purchase_only")
    private Boolean firstPurchaseOnly = false;
}