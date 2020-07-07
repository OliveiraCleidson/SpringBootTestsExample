package com.example.test.demotest.services;

import com.example.test.demotest.models.User;
import com.example.test.demotest.repository.UserRepository;
import com.example.test.demotest.services.exceptions.ResourceNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository repository;

    User user;

    @BeforeEach
    public void newUser(){
        this.user = new User(null, "Paulo",
                "paulo10", "487234879",
                "paulo@hotmail.com");
        this.repository.deleteAll();
    }

    @Test
    @DisplayName("Create User with user service")
    public void createUser(){
        assertThat(userService.createUser(this.user)).isEqualTo(this.user);
    }

    @Test
    @DisplayName("Find by name")
    public void findByName(){
        userService.createUser(this.user);
        assertThat(this.userService.findByName(this.user.getName()).getName()).isEqualTo(this.user.getName());
    }

    @Test
    @DisplayName("Find by name, resource not found exception")
    public void findByNameNotFound(){
        assertThatThrownBy( () -> this.userService.findByName(this.user.getName()))
                .isInstanceOf(ResourceNotFound.class).hasMessageContaining("Name");
    }

    @Test
    @DisplayName("Find by id, resource not found exception")
    public void findByIdNotFound(){
        assertThatThrownBy( () -> this.userService.findById(879L))
                .isInstanceOf(ResourceNotFound.class).hasMessageContaining("Id");
    }

}