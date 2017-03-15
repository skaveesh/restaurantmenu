package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.Menuitem;
import net.codegen.restaurantmenu.repository.MenuitemRepository;
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

}
