package com.example.springboot.PreProject312Boot.dao;


import com.example.springboot.PreProject312Boot.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> allUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }


    @Override
    public void saveUser(User user) {
        User newUser = entityManager.merge(user);
        user.setId(newUser.getId());
    }

    @Override
    public User getUser(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


    @Override
    public User getById(int id) {
        return entityManager.getReference(User.class, id);

    }


}
