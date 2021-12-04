package org.example.service;

import org.example.entity.Orders;
import org.example.repos.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    private final OrdersRepository repository;

    @Autowired
    public OrdersService(OrdersRepository repository) { this.repository = repository; }

    public void save(Orders orders) {repository.save(orders);}
}
