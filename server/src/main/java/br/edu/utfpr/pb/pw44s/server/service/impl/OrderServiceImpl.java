package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository; // 1. Injetamos o repositório de Produtos

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    @Override
    protected JpaRepository<Order, Long> getRepository() {
        return orderRepository;
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderRepository.findByUserUsername(username);
    }

    @Override
    public Order save(Order order) {
        java.math.BigDecimal totalCalculado = java.math.BigDecimal.ZERO;

        if (order.getProducts() != null) {
            for (Product productRef : order.getProducts()) {

                Product realProduct = productRepository.findById(productRef.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado no catálogo. ID: " + productRef.getId()));

                if (realProduct.getPrice() != null) {
                    totalCalculado = totalCalculado.add(realProduct.getPrice());
                }
            }
        }

        order.setTotal(totalCalculado);

        return super.save(order);
    }
}