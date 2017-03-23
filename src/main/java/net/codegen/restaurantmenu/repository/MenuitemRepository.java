package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.core.MenuitemPK;
import net.codegen.restaurantmenu.model.Menuitem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

public interface MenuitemRepository extends CrudRepository<Menuitem,MenuitemPK>{

    @Query("select t FROM Menuitem AS t where t.menuitemPK.restaurantId = :id")
    List<Menuitem> findAllMenuItemsFromRestaurantId(@Param("id") int id);
}
