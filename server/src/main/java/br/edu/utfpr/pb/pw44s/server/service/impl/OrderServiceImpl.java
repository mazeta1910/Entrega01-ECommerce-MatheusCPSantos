package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.model.User;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class OrderServiceImpl implements IOrderService {

    @Override
    public void validatePurchase(User user, Product product) {
        int userAge = java.time.Period.between(user.getBirthDate(), LocalDate.now()).getYears();

        if (product.getAdultOnly() != null && product.getAdultOnly() && userAge < 18) {
            throw new RuntimeException("Acesso negado: Este produto é restrito para maiores de 18 anos, conforme ECA Digital.");
        }
    }
}