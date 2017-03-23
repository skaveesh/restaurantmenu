package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */


@RestController
@RequestMapping("restaurant")
@CrossOrigin("*")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping("/restaurants/getall")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping("/{restaurantUname}")
    public Restaurant getRestaurantByUname(@PathVariable String restaurantUname){
        return restaurantService.getRestaurantByUname(restaurantUname);
    }
}
