package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.CarrierDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.CarrierMapper;
import br.edu.utfpr.pb.pw44s.server.model.Carrier;
import br.edu.utfpr.pb.pw44s.server.service.ICarrierService;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carriers")
public class CarrierController extends CrudController<Carrier, CarrierDTO, Long> {

    private final ICarrierService carrierService;
    private final CarrierMapper carrierMapper;

    public CarrierController(ICarrierService carrierService, CarrierMapper carrierMapper) {
        this.carrierService = carrierService;
        this.carrierMapper = carrierMapper;
    }

    @Override
    protected ICrudService<Carrier, Long> getService() {
        return carrierService;
    }

    @Override
    protected CarrierDTO toDto(Carrier entity) {
        return carrierMapper.toDto(entity);
    }

    @Override
    protected Carrier toEntity(CarrierDTO dto) {
        return carrierMapper.toEntity(dto);
    }
}