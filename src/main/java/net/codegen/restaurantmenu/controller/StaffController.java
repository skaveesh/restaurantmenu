package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.auth.JwtToken;
import net.codegen.restaurantmenu.model.*;
import net.codegen.restaurantmenu.service.OrderItemService;
import net.codegen.restaurantmenu.service.OrdersService;
import net.codegen.restaurantmenu.service.RestaurantTableService;
import net.codegen.restaurantmenu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.awt.geom.RectangularShape;
import java.util.List;
import java.util.Objects;

/**
 * Created by samintha on 3/16/2017.
 */

@RestController
@RequestMapping("staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @Autowired
    RestaurantTableService restaurantTableService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrdersService ordersService;

    private JwtToken jwtToken;

    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAuthTokenByUsernameAndPassword(@RequestParam String username, String password) {
        if (staffService.getTokenByUsernameAndPassword(username, password) != null) {
            jwtToken = new JwtToken(username);
            return jwtToken.getToken();
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }


    @RequestMapping(value = "auth", method = RequestMethod.GET)
    public Object getStaffByAuthentication(@RequestHeader("Authorization") String token) {
        jwtToken = new JwtToken(token, true);
        if (jwtToken.isAuthenticated()) {
            return staffService.getStaffByUsername(jwtToken.getUsername());
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @RequestMapping(value = "gettables", method = RequestMethod.GET)
    public Object getTablesByAuthenticatingStaff(@RequestHeader("Authorization") String token) {
        jwtToken = new JwtToken(token, true);
        if (jwtToken.isAuthenticated()) {
            int restaurantId = staffService.getStaffByUsername(jwtToken.getUsername()).getRestaurant().getRestaurantId();
            return restaurantTableService.findAllTablesFromRestaurantId(restaurantId);
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @RequestMapping(value = "orderoftable", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object getOrderItemsByAuthenticatingStaffAndTableId(@RequestHeader("Authorization") String token, @RequestParam int tableId) {
        jwtToken = new JwtToken(token, true);
        if (jwtToken.isAuthenticated()) {
            Restaurant restaurant = staffService.getStaffByUsername(jwtToken.getUsername()).getRestaurant();

            if(ordersService.getOrderCountByRestaurantAndTableIdAndActiveStatus(restaurant, tableId, true) < 1)
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null); //If the orderItems waiter asked for is available but the status of that order is not active, return forbidden. this is because waiter may have asked for a order which is already processed
            else
                return orderItemService.getAllOrderItemsByOrder(ordersService.getOrderByRestaurantAndTableIdAndActiveStatus(restaurant, tableId, true));
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }


    @RequestMapping(value = "finishorder", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object putOrderItemsByAuthenticatingStaffAndTableId(@RequestHeader("Authorization") String token, @RequestParam int tableId, String discountDetails, int discountPercentage, String otherDetails, boolean paid) {
        jwtToken = new JwtToken(token, true);
        if (jwtToken.isAuthenticated()) {
            Restaurant restaurant = staffService.getStaffByUsername(jwtToken.getUsername()).getRestaurant();

            if(ordersService.getOrderCountByRestaurantAndTableIdAndActiveStatus(restaurant, tableId, true) < 1)
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
            else {
                //TODO:save order to database
                try {
                    return null;
                }catch (Exception e){
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                }
            }
        } else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

}
