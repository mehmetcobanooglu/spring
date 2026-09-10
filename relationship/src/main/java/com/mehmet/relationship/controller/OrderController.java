package com.mehmet.relationship.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.relationship.entity.Customer;
import com.mehmet.relationship.entity.Order;
import com.mehmet.relationship.repository.CustomerRepository;
import com.mehmet.relationship.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderController(
            OrderRepository orderRepository,
            CustomerRepository customerRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    // Tüm siparişleri getir
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // ID'ye göre sipariş getir
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    // Yeni sipariş oluştur
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Bir müşteriye sipariş ekle
    @PostMapping("/customer/{customerId}")
    public Order createOrderForCustomer(
            @PathVariable Long customerId,
            @RequestBody Order order) {

        Customer customer = customerRepository
                .findById(customerId)
                .orElse(null);

        if (customer == null) {
            return null;
        }

        order.setCustomer(customer);

        return orderRepository.save(order);
    }

    // Sipariş sil
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

}
