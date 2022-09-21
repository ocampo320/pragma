package com.pragma.pragma.controller;


import com.pragma.pragma.models.UserDb;
import com.pragma.pragma.services.UserServicesImpl;
import com.pragma.pragma.utils.Validates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pragma")
@CrossOrigin(origins = "*")

public class UserController {
    @Autowired
    UserServicesImpl userServices;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDb userDb) {

        try {

            if (!Validates.validatePassword(userDb.getPassword())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error la password");
            }
            if (!Validates.validateEmail(userDb.getEmail())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error en el correo");
            }


            UserDb userDb1 = userServices.save(userDb);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDb1);


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
