package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samintha on 3/14/2017.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
    Restaurant findByRestaurantUname(String restaurantUname);
    Restaurant findByRestaurantId(int restaurantId);
}
