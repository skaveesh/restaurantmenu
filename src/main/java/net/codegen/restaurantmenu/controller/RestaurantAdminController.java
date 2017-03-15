package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.RestaurantAdmin;
import net.codegen.restaurantmenu.service.RestaurantAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by samintha on 3/14/2017.
 */

@RestController
@RequestMapping("restaurantadmin")
public class RestaurantAdminController {
    @Autowired
    RestaurantAdminService restaurantAdminService;

    @RequestMapping("email/{email}")
    public RestaurantAdmin getRestaurantAdminByEmail(@PathVariable String email){
        return restaurantAdminService.getRestaurantAdminByEmail(email);
    }

    @RequestMapping("uid/{firebaseuid}")
    public RestaurantAdmin getRestaurantAdminByFirebaseUserUid(@PathVariable String firebaseuid){
        return restaurantAdminService.getRestaurantAdminByFirebaseUserUid(firebaseuid);
    }
}
