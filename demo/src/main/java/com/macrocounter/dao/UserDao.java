package com.macrocounter.dao;

import com.macrocounter.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    boolean create(String username, String firstName, String lastName, String email, String password, String role);

}
