package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Menuitem;
import net.codegen.restaurantmenu.service.MenuitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@RestController
@RequestMapping("menuitem")
public class MenuitemController {
    @Autowired
    MenuitemService menuitemService;

}
