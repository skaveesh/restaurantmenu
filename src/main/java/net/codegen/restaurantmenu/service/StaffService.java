package net.codegen.restaurantmenu.service;

import net.codegen.restaurantmenu.model.Staff;
import net.codegen.restaurantmenu.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * Created by samintha on 3/16/2017.
 */

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public Staff getStaffByUsernameAndPassword(String username, String password){
        if(BCrypt.checkpw(password, staffRepository.findByUsername(username).getPassword())){
            return staffRepository.findByUsername(username);
        }else
            return null;
    }
}
