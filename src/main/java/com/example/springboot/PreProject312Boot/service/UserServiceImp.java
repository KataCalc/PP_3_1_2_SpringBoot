package com.example.springboot.PreProject312Boot.service;

import com.example.springboot.PreProject312Boot.dao.UserDao;
import com.example.springboot.PreProject312Boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }


    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }


    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void updateUserEndSave(int id, User user) {
        User userToByUpdate = getUser(id);
        userToByUpdate.setName(user.getName());
        userToByUpdate.setAge(user.getAge());
        userToByUpdate.setEmail(user.getEmail());
        userDao.saveUser(userToByUpdate);
    }
}
