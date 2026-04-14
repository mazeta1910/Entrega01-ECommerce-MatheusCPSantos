package br.edu.utfpr.pb.pw44s.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreightResponseDTO {
    private Long carrierId;
    private String carrierName;
    private BigDecimal price;
    private Integer estimatedDays;
}