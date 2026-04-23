package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.User;

import java.util.List;

// Agora ela herda de ICrudService!
public interface IOrderService extends ICrudService<Order, Long> {

    List<Order> findByUser(User user);

}