package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Menuitem;
import net.codegen.restaurantmenu.model.Orders;
import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.model.RestaurantTable;
import net.codegen.restaurantmenu.service.MenuitemService;
import net.codegen.restaurantmenu.service.OrdersService;
import net.codegen.restaurantmenu.service.RestaurantService;
import net.codegen.restaurantmenu.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@RestController
@RequestMapping("menuitem")
@CrossOrigin("*")
public class MenuitemController {

    @Autowired
    MenuitemService menuitemService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestaurantTableService restaurantTableService;

    @Autowired
    OrdersService ordersService;

    @RequestMapping("{restaurantuname}/{restauranttableid}/{token}")
    public Object getMenuItemsByToken(@PathVariable String restaurantuname, @PathVariable int restauranttableid, @PathVariable String token) {
        Restaurant tempRestaurant = restaurantService.getRestaurantByUname(restaurantuname);
        if(tempRestaurant == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        int tempRestaurantId = tempRestaurant.getRestaurantId();
        RestaurantTable tempRestaurantTable = restaurantTableService.getTableByTableId(restauranttableid);

        if (ordersService.getOrderByToken(tempRestaurant, tempRestaurantTable, token, true) != null) {
            return menuitemService.getMenuitemsByResturantId(tempRestaurantId);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
