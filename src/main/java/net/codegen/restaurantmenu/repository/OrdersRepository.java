package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.Orders;
import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.model.RestaurantTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by samintha on 3/16/2017.
 */

public interface OrdersRepository extends CrudRepository<Orders, Integer> {
    Orders findByRestaurantAndRestaurantTableAndTokenAndActiveStatus(Restaurant restaurant, RestaurantTable restaurantTable, String token, boolean activeStatus);
    Orders findByRestaurantAndRestaurantTableAndActiveStatus(Restaurant restaurant, RestaurantTable restaurantTable, boolean activeStatus);

    @Query("select count(o) FROM Orders AS o where o.restaurant = :restaurant and o.restaurantTable.tableId = :tableId and o.activeStatus = :activeStatus")
    int findOrderCountByRestaurantAndTableIdAndActiveStatus(@Param("restaurant") Restaurant restaurant, @Param("tableId") int tableId, @Param("activeStatus") boolean activeStatus);

    @Query("select o FROM Orders AS o where o.restaurant = :restaurant and o.restaurantTable.tableId = :tableId and o.activeStatus = :activeStatus")
    Orders findOrderByRestaurantAndTableIdAndActiveStatus(@Param("restaurant") Restaurant restaurant, @Param("tableId") int tableId, @Param("activeStatus") boolean activeStatus);
}
