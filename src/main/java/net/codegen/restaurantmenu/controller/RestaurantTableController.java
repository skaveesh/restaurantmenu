package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.RestaurantTable;
import net.codegen.restaurantmenu.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

@RestController
@RequestMapping("restauranttable")
public class RestaurantTableController {

    @Autowired
    RestaurantTableService restaurantTableService;

    @RequestMapping("restauranttables/getall")
    public List<RestaurantTable> getAllRestaurantTables(){
        return restaurantTableService.getAllRestaurantTables();
    }
}
