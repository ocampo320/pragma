package com.pragma.pragma.controller;

import com.pragma.pragma.models.UserDb;
import com.pragma.pragma.repository.UserRepository;
import com.pragma.pragma.services.UserServicesImpl;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

@Mock
UserRepository userRepository;

@Mock
UserServicesImpl userServices;

@InjectMocks
UserController userController;
    @Test
    void saveUSer(){


        //Give
        UserDb userDb= new UserDb();
        userDb.setName("deivi");
        userDb.setLastName("lopez");
        userDb.setPassword("222222");
        userDb.setAddress("cr 3 este");
        userDb.setEmail("d@d.com");



        //When
        when(userRepository.save(any(UserDb.class)));

        UserDb u=userServices.save(userDb);

        //Then
        Assertions.assertNotNull(userDb);


    }
}
