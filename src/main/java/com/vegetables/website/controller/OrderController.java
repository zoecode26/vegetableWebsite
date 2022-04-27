package com.vegetables.website.controller;

import com.vegetables.website.dao.OrderDAO;
import com.vegetables.website.dao.OrderItemsDAO;
import com.vegetables.website.model.Order;
import com.vegetables.website.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {
    private final OrderItemsDAO orderItemsDAO;
    private final OrderDAO orderDAO;

    public OrderController(OrderItemsDAO orderItemsDAO, OrderDAO orderDAO) {
        this.orderItemsDAO = orderItemsDAO;
        this.orderDAO = orderDAO;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/order")
    public ResponseEntity<?> saveOrder(@RequestBody Order order) throws Exception {
        Order savedOrder = orderDAO.save(order);
        return ResponseEntity.ok(savedOrder.getId());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/orderitems")
    public ResponseEntity<?> saveOrderItems(@RequestBody OrderItem item) {
        orderItemsDAO.save(item);
        return ResponseEntity.ok().build();
    }
}
