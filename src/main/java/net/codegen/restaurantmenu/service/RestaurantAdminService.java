package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.RestaurantAdmin;
import net.codegen.restaurantmenu.repository.RestaurantAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by samintha on 3/14/2017.
 */

@Service
public class RestaurantAdminService {
    @Autowired
    RestaurantAdminRepository restaurantAdminRepository;

    public RestaurantAdmin getRestaurantAdminByFirebaseUserUid(String firebaseUserUid){
        return restaurantAdminRepository.findByFirebaseUserUid(firebaseUserUid);
    }

    public RestaurantAdmin getRestaurantAdminByEmail(String email){
        return restaurantAdminRepository.findByEmail(email);
    }
}
