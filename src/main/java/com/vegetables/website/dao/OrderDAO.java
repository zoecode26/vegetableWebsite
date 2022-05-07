package com.vegetables.website.dao;

import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDAO extends CrudRepository<Order, Long> {
    List<Order> findByWebUserId(long webUserId);
}
