package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.Orders;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samintha on 3/16/2017.
 */

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
}
