package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Filter;
import net.codegen.restaurantmenu.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@RestController
@RequestMapping("filter")
public class FilterController {
    @Autowired
    FilterService filterService;

    @RequestMapping("filters/getall")
    public List<Filter> getAllFilters(){
        return filterService.getAllFilters();
    }
}
