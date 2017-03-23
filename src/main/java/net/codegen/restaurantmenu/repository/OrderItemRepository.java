package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import java.util.List;

/**
 * Created by samintha on 3/17/2017.
 */

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

    List<OrderItem> findByOrders(Orders orders);

    @Query("select o FROM OrderItem AS o where o.orders.restaurant = :restaurant and o.orders.restaurantTable.tableId = :tableId")
    List<OrderItem> findAllOrderItemsByRestaurantAndTableId(@Param("restaurant") Restaurant restaurant, @Param("tableId") int tableId);
}
