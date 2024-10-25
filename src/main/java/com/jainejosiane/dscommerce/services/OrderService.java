package com.jainejosiane.dscommerce.services;

import com.jainejosiane.dscommerce.dto.OrderDTO;
import com.jainejosiane.dscommerce.entities.*;
import com.jainejosiane.dscommerce.repositories.OrderItemRepository;
import com.jainejosiane.dscommerce.repositories.OrderRepository;
import com.jainejosiane.dscommerce.repositories.ProductRepository;
import com.jainejosiane.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        return new OrderDTO(order);
    }
}