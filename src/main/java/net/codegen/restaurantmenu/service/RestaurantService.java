package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return restaurants;
    }

    public Restaurant getRestaurantByUname(String restaurantUname) {
        return restaurantRepository.findByRestaurantUname(restaurantUname);
    }
}
