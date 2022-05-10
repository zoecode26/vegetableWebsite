package com.vegetables.website.dao;

import com.vegetables.website.model.OrderItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsDAO extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(long orderId);
}
