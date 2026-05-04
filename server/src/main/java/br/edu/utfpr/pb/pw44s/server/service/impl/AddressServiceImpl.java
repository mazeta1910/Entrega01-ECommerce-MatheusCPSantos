package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.repository.UserRepository;
import br.edu.utfpr.pb.pw44s.server.service.IAddressService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, Long> implements IAddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository; // Adicionado para buscar o dono

    // Atualizamos o construtor para receber o UserRepository
    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    // --- SOBRESCRITA DO MÉTODO SAVE PARA VINCULAR O USUÁRIO ---
    @Override
    public Address save(Address address) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User loggedUser = userRepository.findUserByUsername(username);

        if (loggedUser == null) {
            throw new IllegalArgumentException("Usuário logado não encontrado.");
        }

        address.setUser(loggedUser);

        return super.save(address);
    }


    @Override
    public List<Address> findByUsername(String username) {
        return addressRepository.findByUserUsername(username);
    }

    @Override
    public List<Address> findActiveByUserId(Long userId) {
        return addressRepository.findByUserIdAndIsActiveTrue(userId);
    }

    @Override
    public java.util.List<Address> findAll() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return addressRepository.findByUserUsername(username);
    }


    @Override
    public void deleteById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        address.setIsActive(false);
        addressRepository.save(address);
    }
}