package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.RestaurantAdmin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samintha on 3/14/2017.
 */
public interface RestaurantAdminRepository extends CrudRepository<RestaurantAdmin,Integer> {
    RestaurantAdmin findByFirebaseUserUid(String firebaseUserUid);
    RestaurantAdmin findByEmail(String email);
}
