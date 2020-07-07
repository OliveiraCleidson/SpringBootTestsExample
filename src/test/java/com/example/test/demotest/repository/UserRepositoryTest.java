package com.example.test.demotest.repository;


import com.example.test.demotest.models.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.*;

import javax.validation.ConstraintViolationException;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Test findByName")
    public void findByName() throws IllegalArgumentException{
        this.entityManager.persist(new User(null, "Paulo", "paulo10", "487234879", "paulo@hotmail.com"));
        User savedUser = userRepository.findByName("Paulo").get();
        assertThat(savedUser.getName()).isEqualTo("Paulo");
    }

    @Test
    @DisplayName("Name not can be null")
    public void saveUserNull() throws ConstraintViolationException {
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(ConstraintViolationException.class, () -> {
            User user = new User(null, null, "paulo10", "487234879", "paulo@hotmail.com");
            userRepository.save(user);
        });
    }

    @Test
    @DisplayName("Find By Id")
    public void findById(){
        User user = new User(null, "Paulo", "paulo10", "487234879", "paulo@hotmail.com");
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isEqualTo(userRepository.findById(savedUser.getId()).get());
    }

}

