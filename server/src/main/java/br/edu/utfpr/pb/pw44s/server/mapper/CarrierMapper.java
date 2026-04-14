package br.edu.utfpr.pb.pw44s.server.mapper;

import br.edu.utfpr.pb.pw44s.server.dto.CarrierDTO;
import br.edu.utfpr.pb.pw44s.server.model.Carrier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarrierMapper {

    Carrier toEntity(CarrierDTO dto);

    CarrierDTO toDto(Carrier entity);
}