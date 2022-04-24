package com.vegetables.website.controller;

import com.vegetables.website.dao.OrderDAO;
import com.vegetables.website.dao.OrderItemsDAO;
import com.vegetables.website.model.Order;
import com.vegetables.website.model.OrderItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public void saveOrderItems(@RequestBody List<OrderItem> orderItems) throws Exception {
        for (OrderItem item: orderItems) {
            orderItemsDAO.save(item);
        }
    }
}
