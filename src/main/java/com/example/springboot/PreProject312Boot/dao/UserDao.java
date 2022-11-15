package com.example.springboot.PreProject312Boot.dao;



import com.example.springboot.PreProject312Boot.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    User getById(int id);

    void saveUser(User user);

    User getUser(Integer id);


}