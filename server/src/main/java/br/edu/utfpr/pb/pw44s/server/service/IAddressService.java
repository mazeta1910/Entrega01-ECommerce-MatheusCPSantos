package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import java.util.List;

public interface IAddressService extends ICrudService<Address, Long> {

    // Assinatura do novo método
    List<Address> findActiveByUserId(Long userId);

}