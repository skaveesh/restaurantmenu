package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.core.MenuitemPK;
import net.codegen.restaurantmenu.model.Menuitem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

public interface MenuitemRepository extends CrudRepository<Menuitem,MenuitemPK>{
    List<Menuitem> findByRestaurantId(int restaurantId);
}
