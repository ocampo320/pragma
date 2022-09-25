package com.pragma.pragma.services;

import com.pragma.pragma.models.UserDb;
import com.pragma.pragma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    final UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable finAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserDb> findByID(Integer id) {
        return userRepository.findById(id);
    }


    @Override
    public UserDb save(UserDb entity) {
        UserDb userDb = UserDb.builder()
                .address(entity.getName())
                .email(entity.getEmail())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .password(entity.getPassword())
                .build();
        return userRepository.save(userDb);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);

    }
}
