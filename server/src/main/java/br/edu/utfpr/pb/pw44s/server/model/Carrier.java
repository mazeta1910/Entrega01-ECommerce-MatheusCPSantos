package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_carrier")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 100, unique = true)
    private String name;

    @NotNull
    @Column(precision = 10, scale = 2, name = "base_rate")
    private BigDecimal baseRate;

    @NotNull
    @Column(name = "estimated_delivery_days")
    private Integer estimatedDeliveryDays;

    @Column(name = "is_active")
    private Boolean isActive;
}