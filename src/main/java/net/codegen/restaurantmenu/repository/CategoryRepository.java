package net.codegen.restaurantmenu.repository;

import org.springframework.data.repository.CrudRepository;
import net.codegen.restaurantmenu.model.Category;

/**
 * Created by samintha on 3/14/2017.
// */
public interface CategoryRepository extends CrudRepository<Category,Integer> {
}
