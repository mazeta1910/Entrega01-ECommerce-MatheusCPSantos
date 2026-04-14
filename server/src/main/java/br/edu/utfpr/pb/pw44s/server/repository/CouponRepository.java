package br.edu.utfpr.pb.pw44s.server.repository;

import br.edu.utfpr.pb.pw44s.server.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    // Busca um cupom ativo pelo código (usado no checkout)
    Optional<Coupon> findByCodeAndActiveTrue(String code);
}