package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.Filter;
import net.codegen.restaurantmenu.repository.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samintha on 3/14/2017.
 */

@Service
public class FilterService {
    @Autowired
    FilterRepository filterRepository;

    public List<Filter> getAllFilters(){
        List<Filter> filters = new ArrayList<>();
        filterRepository.findAll().forEach(filters :: add);
        return filters;
    }
}
