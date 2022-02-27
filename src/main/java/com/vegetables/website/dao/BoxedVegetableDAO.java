package com.vegetables.website.dao;

import com.vegetables.website.model.BoxedVegetable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoxedVegetableDAO extends CrudRepository<BoxedVegetable, Long> {
//    @Query(
//            value = "SELECT \n" +
//                    "    bv.box_id, \n" +
//                    "    v.id \n" +
//                    "FROM \n" +
//                    "    boxed_vegetables bv \n" +
//                    "INNER JOIN\n" +
//                    "    vegetables v ON bv.vegetable_id = v.id \n" +
//                    "INNER JOIN\n" +
//                    "    boxes b ON bv.box_id = b.id ",
//            nativeQuery = true)
//    List<BoxedVegetable> findAllDisplayBoxes();
}
