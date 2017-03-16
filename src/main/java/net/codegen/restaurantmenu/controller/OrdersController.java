package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Orders;
import net.codegen.restaurantmenu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/16/2017.
 */

@RestController
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("orders/getall")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }
}
