package net.codegen.restaurantmenu.controller;

import net.codegen.restaurantmenu.model.Staff;
import net.codegen.restaurantmenu.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Created by samintha on 3/16/2017.
 */

@RestController
@RequestMapping("staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public Object getStaffByUsernameAndPassword(@RequestParam String username, String password){
        if(staffService.getStaffByUsernameAndPassword(username, password) != null)
            return staffService.getStaffByUsernameAndPassword(username, password);
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }


}
