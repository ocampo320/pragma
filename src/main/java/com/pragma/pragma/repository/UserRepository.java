package com.pragma.pragma.repository;

import com.pragma.pragma.models.UserDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<UserDb, Integer> {

}
