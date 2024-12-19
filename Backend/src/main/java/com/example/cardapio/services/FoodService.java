package com.example.cardapio.services;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.foodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    @Autowired
    private foodRepository repository;

    public Food update(Long id, Food obj){
        Food entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Food entity, Food obj){
        entity.setTitle(obj.getTitle());
        entity.setImage(obj.getImage());
        entity.setPrice(obj.getPrice());
    }
}
