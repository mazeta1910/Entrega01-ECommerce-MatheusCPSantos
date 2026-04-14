package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Coupon;
import br.edu.utfpr.pb.pw44s.server.repository.CouponRepository;
import br.edu.utfpr.pb.pw44s.server.service.ICouponService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl extends CrudServiceImpl<Coupon, Long> implements ICouponService {

    private final CouponRepository couponRepository;

    public CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    protected JpaRepository<Coupon, Long> getRepository() {
        return couponRepository;
    }

    @Override
    public Coupon findByCode(String code) {
        return couponRepository.findByCode(code).orElse(null);
    }
}