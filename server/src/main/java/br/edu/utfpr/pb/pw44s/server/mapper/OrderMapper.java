package br.edu.utfpr.pb.pw44s.server.mapper;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AddressMapper.class, ProductMapper.class})
public interface OrderMapper {
    OrderDTO toDto(Order entity);

    Order toEntity(OrderDTO dto);
}