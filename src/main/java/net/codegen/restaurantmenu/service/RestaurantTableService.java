package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.RestaurantTable;
import net.codegen.restaurantmenu.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

@Service
public class RestaurantTableService {

    @Autowired
    RestaurantTableRepository restaurantTableRepository;

    public List<RestaurantTable> getAllRestaurantTables() {
        List<RestaurantTable> restaurantTables = new ArrayList<>();
        restaurantTableRepository.findAll().forEach(restaurantTables::add);
        return restaurantTables;
    }
}
