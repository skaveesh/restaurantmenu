package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.Orders;
import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.model.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samintha on 3/16/2017.
 */

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    Orders findByRestaurantAndRestaurantTableAndTokenAndActiveStatus(Restaurant restaurant, RestaurantTable restaurantTable, String token, boolean activeStatus);
}
