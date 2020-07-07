package com.example.test.demotest.repository;


import com.example.test.demotest.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
    Optional<User> findByName(String name);
}
