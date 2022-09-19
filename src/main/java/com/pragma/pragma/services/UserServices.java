package com.pragma.pragma.services;


import com.pragma.pragma.models.UserDb;

import java.util.Optional;


public interface UserServices{
    public Iterable<UserDb> finAll();
    public Optional<UserDb> findByID(Integer id);
    public UserDb save(UserDb entity);
    public void deleteById(Integer id);

}