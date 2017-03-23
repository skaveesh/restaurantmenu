package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.OrderItem;
import net.codegen.restaurantmenu.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/17/2017.
 */

@RestController
@RequestMapping("orderitem")
public class OrderItemController {

//    @Autowired
//    OrderItemService orderItemService;
//
//    @RequestMapping("getall")
//    public List<OrderItem> getAllOrderItems(){
//        return orderItemService.getAllOrderItems();
//    }
}
