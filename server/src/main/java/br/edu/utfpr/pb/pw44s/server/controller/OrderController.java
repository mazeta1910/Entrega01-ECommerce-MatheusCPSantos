package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.OrderDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.OrderMapper;
import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class OrderController extends CrudController<Order, OrderDTO, Long> {

    private final IOrderService orderService;
    private final OrderMapper orderMapper; // Injetamos o Mapper aqui

    public OrderController(IOrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @Override
    protected ICrudService<Order, Long> getService() {
        return orderService;
    }

    @Override
    protected OrderDTO toDto(Order entity) {
        return orderMapper.toDto(entity);
    }

    @Override
    protected Order toEntity(OrderDTO dto) {
        return orderMapper.toEntity(dto);
    }

    //Listar pedidos apenas do usuário autenticado
    @GetMapping("me")
    public ResponseEntity<List<OrderDTO>> findMyOrders(@AuthenticationPrincipal User user) {
        List<Order> orders = orderService.findByUser(user);
        return ResponseEntity.ok(
                orders.stream()
                        .map(this::toDto) // Usa o método que acabamos de implementar acima
                        .collect(Collectors.toList())
        );
    }

    //Finalizar compra (vincular o pedido ao usuário do Token).
    @PostMapping("checkout")
    public ResponseEntity<OrderDTO> finalizePurchase(@RequestBody OrderDTO orderDto,
                                                     @AuthenticationPrincipal User user) {
        Order order = this.toEntity(orderDto); // Converte usando o nosso método
        order.setUser(user); // Amarra ao usuário logado

        return ResponseEntity.ok(this.toDto(orderService.save(order)));
    }
}