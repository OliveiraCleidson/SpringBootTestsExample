package com.example.test.demotest.services;

import com.example.test.demotest.models.User;
import com.example.test.demotest.repository.UserRepository;
import com.example.test.demotest.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User newUser) throws IllegalArgumentException, ConstraintViolationException{
        return userRepository.save(newUser);
    }

    public User findById(Long id) throws IllegalArgumentException, ResourceNotFound{
         return userRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFound("Id: " + id.toString()));
    }

    public User findByName(String name){
        return userRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFound("Name: " + name) );
    }
}
