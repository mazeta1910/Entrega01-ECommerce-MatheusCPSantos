package br.edu.utfpr.pb.pw44s.server.mapper;

import br.edu.utfpr.pb.pw44s.server.dto.CouponDTO;
import br.edu.utfpr.pb.pw44s.server.model.Coupon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CouponMapper {

    Coupon toEntity(CouponDTO dto);

    CouponDTO toDto(Coupon entity);
}