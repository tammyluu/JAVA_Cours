package com.example.demo_data_rest.service;

import com.example.demo_data_rest.entity.Candy;
import com.example.demo_data_rest.repository.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandyServiceImpl implements ICandyShopService<Candy> {
    private CandyRepository candyRepository;
    @Autowired
    public CandyServiceImpl(CandyRepository candyRepository) {
        this.candyRepository = candyRepository;
    }

    @Override
    public Boolean createCandy(Candy candy) {
        candyRepository.save(candy);
        System.out.println("Candies created!!!");
        return true;
    }

    @Override
    public List<Candy> findAllCandy() {
        return (List<Candy>) candyRepository.findAll();
    }

    @Override
    public Candy findCandyById(Long id) {
        return candyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candy not found with ID: " + id));
    }

    @Override
    public List<Candy> searchCandy(String search) {
        return candyRepository.findCandiesByNameContainingIgnoreCase(search);
    }

    @Override
    public Candy updateCandy(Long id, Candy candy) {
        Candy newArrival = candyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Candy not found with ID: " + id));

        newArrival.setName(candy.getName());
        newArrival.setDescription(candy.getDescription());
        newArrival.setEffectMagic(candy.getEffectMagic());
        newArrival.setQuantity(candy.getQuantity());
        newArrival.setPrice(candy.getPrice());

        return candyRepository.save(candy);
    }

    @Override
    public void deleteCandyById(Long id) {

    }
}
