package com.example.demo_data_rest.repository;

import com.example.demo_data_rest.entity.Candy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "candy")
public interface CandyRepository extends CrudRepository<Candy,Long> {
    List<Candy> findCandiesByNameContainingIgnoreCase(@Param("name") String name);
    List<Candy> findAllByName (String name);
    List<Candy> findAllByMagicEffect(String effectMagic);
    List<Candy> findAllByPriceBetween(double minPrice, double maxPrice);
    List<Candy> searchCandiesByName(String name);

}
