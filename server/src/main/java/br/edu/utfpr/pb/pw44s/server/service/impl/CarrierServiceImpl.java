package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Carrier;
import br.edu.utfpr.pb.pw44s.server.repository.CarrierRepository;
import br.edu.utfpr.pb.pw44s.server.service.ICarrierService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrierServiceImpl extends CrudServiceImpl<Carrier, Long> implements ICarrierService {

    private final CarrierRepository carrierRepository;

    public CarrierServiceImpl(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    @Override
    protected JpaRepository<Carrier, Long> getRepository() {
        return carrierRepository;
    }
}