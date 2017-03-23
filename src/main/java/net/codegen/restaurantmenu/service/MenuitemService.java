package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.core.MenuitemPK;
import net.codegen.restaurantmenu.model.Menuitem;
import net.codegen.restaurantmenu.model.RestaurantTable;
import net.codegen.restaurantmenu.repository.MenuitemRepository;
import net.codegen.restaurantmenu.repository.RestaurantAdminRepository;
import net.codegen.restaurantmenu.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@Service
public class MenuitemService {
    @Autowired
    MenuitemRepository menuitemRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    public List<Menuitem> getAllMenuitems() {
        List<Menuitem> menuitems = new ArrayList<>();
        menuitemRepository.findAll().forEach(menuitems::add);
        return menuitems;
    }

    public List<Menuitem> getMenuitemsByResturantId(int restaurantId) {
        List<Menuitem> menuitems = new ArrayList<>();
        menuitemRepository.findAllMenuItemsFromRestaurantId(restaurantId).forEach(menuitems::add);
        return menuitems;
    }
}
