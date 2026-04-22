package br.edu.utfpr.pb.pw44s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(length = 1024)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "is_adult_only")
    private Boolean adultOnly = false;

    // Lógica de conferência no Checkout ou Carrinho
    public void validatePurchase(User user, Product product) {
        int userAge = java.time.Period.between(user.getBirthDate(), LocalDate.now()).getYears();

        if (product.getAdultOnly() && userAge < 18) {
            throw new RuntimeException("Este produto é restrito para maiores de 18 anos.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
