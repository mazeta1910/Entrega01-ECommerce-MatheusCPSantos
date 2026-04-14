package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.dto.FreightResponseDTO;
import br.edu.utfpr.pb.pw44s.server.model.Carrier;
import br.edu.utfpr.pb.pw44s.server.repository.CarrierRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FreightService {

    private final CarrierRepository carrierRepository;

    public FreightService(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }

    public List<FreightResponseDTO> calculateFreight(String zipCode) {
        String cleanZipCode = zipCode.replaceAll("\\D", "");

        BigDecimal regionTax;
        int extraDays;

        if (cleanZipCode.startsWith("85")) {
            // Entrega local (Sudoeste PR)
            regionTax = BigDecimal.ZERO;
            extraDays = 0;
        } else if (cleanZipCode.startsWith("8") || cleanZipCode.startsWith("9")) {
            // Restante da Região Sul
            regionTax = new BigDecimal("12.00");
            extraDays = 2;
        } else if (cleanZipCode.startsWith("0") || cleanZipCode.startsWith("1")) {
            // Região Sudeste
            regionTax = new BigDecimal("25.00");
            extraDays = 4;
        } else {
            // Resto do Brasil
            regionTax = new BigDecimal("45.00");
            extraDays = 7;
        }

        List<Carrier> activeCarriers = carrierRepository.findAll().stream()
                .filter(Carrier::getIsActive)
                .toList();

        List<FreightResponseDTO> options = new ArrayList<>();

        for (Carrier carrier : activeCarriers) {
            options.add(FreightResponseDTO.builder()
                    .carrierId(carrier.getId())
                    .carrierName(carrier.getName())
                    .price(carrier.getBaseRate().add(regionTax))
                    .estimatedDays(carrier.getEstimatedDeliveryDays() + extraDays)
                    .build());
        }

        return options;
    }
}