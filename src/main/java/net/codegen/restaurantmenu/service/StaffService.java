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

    public Staff getTokenByUsernameAndPassword(String username, String password) {
        Staff tempStaff = staffRepository.findByUsernameAndSuspendStatus(username, false);

        if (tempStaff != null && BCrypt.checkpw(password, tempStaff.getPassword())) {
            return tempStaff;
        } else
            return null;
    }

    public Staff getStaffByUsername(String username) {
        return staffRepository.findByUsernameAndSuspendStatus(username, false);
    }
}
