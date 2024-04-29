package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.Candy;
import com.example.demo_data_rest.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "order")
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Candy> findByNameContainingIgnoreCase(String name);
}
