package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, Long> implements IAddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    // --- MÉTODOS OBRIGATÓRIOS DA INTERFACE ---

    @Override
    public List<Address> findByUsername(String username) {
        return addressRepository.findByUserUsername(username);
    }

    @Override
    public List<Address> findActiveByUserId(Long userId) {
        return addressRepository.findByUserIdAndIsActiveTrue(userId);
    }

    // --- SOBRESCRITA DO MÉTODO DELETE (Soft Delete) ---

    @Override
    public void deleteById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        address.setIsActive(false);
        addressRepository.save(address);
    }
}