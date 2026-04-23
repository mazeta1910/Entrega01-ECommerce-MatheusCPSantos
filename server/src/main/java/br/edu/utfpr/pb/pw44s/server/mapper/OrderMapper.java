package br.edu.utfpr.pb.pw44s.server.mapper;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.dto.OrderItemDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

// unmappedTargetPolicy = ReportingPolicy.IGNORE cala os avisos de campos como o 'confirmPassword'
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderDTO toDto(Order entity);

    Order toEntity(OrderDTO dto);

    // Na ida para a Entidade, ignoramos o order pois o campo EXISTE na entidade OrderItem
    @Mapping(target = "order", ignore = true)
    OrderItem toOrderItem(OrderItemDTO dto);

    // Na volta para o DTO, deixamos limpo, pois o campo não existe no OrderItemDTO
    OrderItemDTO toOrderItemDto(OrderItem entity);
}