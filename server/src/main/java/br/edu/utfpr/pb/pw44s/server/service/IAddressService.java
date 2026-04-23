package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Address;

import java.util.List;

public interface IAddressService extends ICrudService<Address, Long> {

    // Método para a rota segura com JWT
    List<Address> findByUsername(String username);

    // Método para buscar os endereços ativos
    List<Address> findActiveByUserId(Long userId);

}