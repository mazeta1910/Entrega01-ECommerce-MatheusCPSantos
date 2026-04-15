package br.edu.utfpr.pb.pw44s.server.mapper;

import br.edu.utfpr.pb.pw44s.server.dto.CouponDTO;
import br.edu.utfpr.pb.pw44s.server.model.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CouponMapper {

    Coupon toEntity(CouponDTO dto);

    @Mapping(source = "type.description", target = "discountTypeDescription")
    @Mapping(source = "targetType.description", target = "targetTypeDescription")
    CouponDTO toDto(Coupon entity);
}