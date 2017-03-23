package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.OrderItem;
import net.codegen.restaurantmenu.model.Orders;
import net.codegen.restaurantmenu.model.Restaurant;
import net.codegen.restaurantmenu.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 3/17/2017.
 */

@Service
public class OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrderItemsByOrder(Orders orders){
        List<OrderItem> orderItems = new ArrayList<>();
        orderItemRepository.findByOrders(orders).forEach(orderItems::add);
        return orderItems;
    }

    public List<OrderItem> findAllOrderItemsByRestaurantAndTableId(Restaurant restaurant, int tableId){
        List<OrderItem> orderItems = new ArrayList<>();
        orderItemRepository.findAllOrderItemsByRestaurantAndTableId(restaurant, tableId).forEach(orderItems::add);
        return orderItems;
    }
}
