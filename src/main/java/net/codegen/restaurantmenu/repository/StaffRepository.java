package net.codegen.restaurantmenu.repository;

import net.codegen.restaurantmenu.model.Staff;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by samintha on 3/16/2017.
 */
public interface StaffRepository extends CrudRepository<Staff, Integer> {
    Staff findByUsername(String username);
}
