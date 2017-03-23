package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.RestaurantTable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, Integer> {
    RestaurantTable findByTableId(int tableId);

    @Query("select t FROM RestaurantTable AS t where t.restaurant.restaurantId = :id")
    List<RestaurantTable> findAllTablesFromRestaurantId(@Param("id") int id);
}
