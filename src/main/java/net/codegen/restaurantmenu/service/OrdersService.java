package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.Orders;
import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.model.RestaurantTable;
import net.codegen.restaurantmenu.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        ordersRepository.findAll().forEach(orders::add);
        return orders;
    }

    public Orders getOrderByToken(Restaurant restaurant, RestaurantTable restaurantTable, String token, boolean activeStatus){
        return ordersRepository.findByRestaurantAndRestaurantTableAndTokenAndActiveStatus(restaurant, restaurantTable, token, activeStatus);
    }
}
