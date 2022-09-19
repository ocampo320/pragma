package com.pragma.pragma.services;

import com.pragma.pragma.models.UserDb;
import com.pragma.pragma.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServicesImpl implements UserServices {

    final
    UserRepository userRepository;

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
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);

    }


}
