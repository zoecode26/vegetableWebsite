package com.vegetables.website.dao;

import com.vegetables.website.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemsDAO extends CrudRepository<OrderItem, Long> {

}
