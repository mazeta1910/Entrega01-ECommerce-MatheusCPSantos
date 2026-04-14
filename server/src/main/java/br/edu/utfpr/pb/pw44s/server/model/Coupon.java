package br.edu.utfpr.pb.pw44s.server.model;

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
    private LocalDate validity;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "first_purchase_only")
    private Boolean firstPurchaseOnly;
}