package com.vegetables.website.dao;

import com.vegetables.website.model.Order;
import com.vegetables.website.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemsDAO extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(long orderId);
}
