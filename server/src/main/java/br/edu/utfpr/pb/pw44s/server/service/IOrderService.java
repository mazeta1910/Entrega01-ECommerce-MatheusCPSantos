package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Order;

import java.util.List;

public interface IOrderService {

    List<Order> findAll();

    Order findById(Long id);

    Order save(Order order);

    void delete(Long id);
}