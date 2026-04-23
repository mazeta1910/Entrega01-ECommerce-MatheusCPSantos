package br.edu.utfpr.pb.pw44s.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private Long id;
    private BigDecimal total;
    private LocalDateTime orderDate;
    private UserDTO user;

    // A lista antiga de "products" DEVE sair, e a nova entra:
    private List<OrderItemDTO> items;

    private AddressDTO deliveryAddress;
}