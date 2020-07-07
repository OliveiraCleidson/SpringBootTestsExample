package com.example.test.demotest.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String name;
    @Length(min = 4)
    @NotNull
    @Column(nullable = false)
    private String loginName;
    @Min(6)
    @NotNull
    @Column(nullable = false)
    private String hashPassword;
    @NotNull
    @Column(nullable = false)
    @Email
    private String email;

    protected User() {}

    public User(Long id, @NotNull String name, @Min(4) @NotNull String loginName, @Min(6) @NotNull String hashPassword, @NotNull @Email String email) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.hashPassword = hashPassword;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
