package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Order;
import br.edu.utfpr.pb.pw44s.server.model.OrderItem;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.OrderRepository;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.IOrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository; // Necessário para consultar os preços reais!

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

    // --- A MÁGICA DA SEGURANÇA E DO PREÇO CONGELADO ---
    @Override
    public Order save(Order order) {

        if (order.getItems() != null && !order.getItems().isEmpty()) {
            for (OrderItem item : order.getItems()) {
                // 1. Busca o produto verdadeiro no banco de dados usando o ID
                Product realProduct = productRepository.findById(item.getProduct().getId())
                        .orElseThrow(() -> new RuntimeException("Produto ID " + item.getProduct().getId() + " não encontrado!"));

                // 2. Congela o preço exato no momento da compra (Blindagem contra fraudes)
                item.setPriceAtPurchase(realProduct.getPrice());

                // 3. Garante que o item tem a referência completa e atualizada do produto
                item.setProduct(realProduct);
            }
        }

        // 4. Agora que os itens têm o preço correto, mandamos a classe calcular o Total da fatura
        order.calculateTotal();

        // 5. Salva a encomenda (e o CascadeType.ALL salva os Itens automaticamente)
        return super.save(order);
    }
}