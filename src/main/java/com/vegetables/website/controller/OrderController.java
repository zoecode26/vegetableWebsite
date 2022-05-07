package com.vegetables.website.controller;

import com.vegetables.website.dao.OrderDAO;
import com.vegetables.website.dao.OrderItemsDAO;
import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.Order;
import com.vegetables.website.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders", method = { RequestMethod.GET, RequestMethod.POST })
public class OrderController {
    private final OrderItemsDAO orderItemsDAO;
    private final OrderDAO orderDAO;

    public OrderController(OrderItemsDAO orderItemsDAO, OrderDAO orderDAO) {
        this.orderItemsDAO = orderItemsDAO;
        this.orderDAO = orderDAO;
    }

    @GetMapping("/users/{user_id}")
    public List<Order> getUser(@PathVariable(value = "user_id") Long user_id) {
        return orderDAO.findByWebUserId(user_id);
    }

    @GetMapping("/{order_id}")
    public Optional<Order> getOrder(@PathVariable(value = "order_id") Long order_id) {
        return orderDAO.findById(order_id);
    }

    @GetMapping("/items/{order_id}")
    public List<OrderItem> getOrderItems(@PathVariable(value = "order_id") Long order_id) {
        return orderItemsDAO.findByOrderId(order_id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/new")
    public ResponseEntity<?> saveOrder(@RequestBody Order order) throws Exception {
        System.out.println(order);
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
