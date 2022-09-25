package com.pragma.pragma.controller;

import com.pragma.pragma.models.UserDb;
import com.pragma.pragma.repository.UserRepository;
import com.pragma.pragma.services.UserServicesImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UserControllerTest {
    @InjectMocks
    UserServicesImpl userServices;


    @Mock
    UserRepository userRepository;


    @Test
    void saveUSer() {
        UserDb userDb =  UserDb.builder()
                .name("deivi")
                .lastName("lopez")
                .password("222222")
                .phoneNumber("22222")
                .address("cr 3 este")
                .email("d@d.com")
                .build();
        when(userRepository.save(any(UserDb.class))).thenReturn(userDb);

        UserDb u = userServices.save(userDb);

        Assertions.assertNotNull(u);
        assertEquals(userDb.getName(), u.getName());
        verify(userRepository, times(1)).save(any(UserDb.class));
        verifyNoMoreInteractions(userRepository);


    }
}
