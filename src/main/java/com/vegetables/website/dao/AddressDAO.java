package com.vegetables.website.dao;

import com.vegetables.website.model.Address;
import com.vegetables.website.model.BoxedVegetable;
import com.vegetables.website.model.DisplayBox;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressDAO extends CrudRepository<Address, Long> { }
