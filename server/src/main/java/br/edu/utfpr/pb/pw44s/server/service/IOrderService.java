package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.model.User;

public interface IOrderService {
    void validatePurchase(User user, Product product);
    // futuramente terá métodos como: void checkout(Cart cart);
}