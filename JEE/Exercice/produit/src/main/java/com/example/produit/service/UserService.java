package com.example.produit.service;

import com.example.produit.dao.Repository;
import com.example.produit.entities.Produit;
import com.example.produit.entities.User;

import java.util.List;

public class UserService  extends  BaseService implements Repository {
    @Override
    public boolean create(Object o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Object o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Object o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Object findById(int id) {
       User user = null;
        session = sessionFactory.openSession();
       user = (User) session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public List findAll() {
        return null;
    }
}
