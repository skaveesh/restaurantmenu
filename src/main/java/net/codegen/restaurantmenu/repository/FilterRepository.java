package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.Filter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

public interface FilterRepository extends CrudRepository<Filter, Integer> {
//    Filter findByRestaurantId(int restaurantId);
}
