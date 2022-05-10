package com.vegetables.website.dao;

import com.vegetables.website.model.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order, Long> {
    List<Order> findByWebUserId(long webUserId);
}
