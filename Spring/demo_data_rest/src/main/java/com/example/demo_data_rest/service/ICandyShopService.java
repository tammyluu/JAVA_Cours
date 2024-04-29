package com.example.demo_data_rest.service;

import com.example.demo_data_rest.entity.Candy;

import java.util.List;

public interface ICandyShopService <T>{
    Boolean createCandy (T element);
    List<T> findAllCandy();
    T findCandyById(Long id);
    List<T> searchCandy(String search);
    T updateCandy(Long id, Candy candy);
    void deleteCandyById(Long id);
}
