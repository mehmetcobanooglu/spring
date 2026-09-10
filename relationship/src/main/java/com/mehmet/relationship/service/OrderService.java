package com.mehmet.relationship.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehmet.relationship.entity.Customer;
import com.mehmet.relationship.entity.Order;
import com.mehmet.relationship.repository.OrderRepository;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerService customerService;

    public OrderService(OrderRepository orderRepository, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
    }

    public Order addOrder(Order order, Long customerId) {

        Customer customer = customerService.getCustomerById(customerId);
        order.setCustomer(customer);
        return orderRepository.save(order);

    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
