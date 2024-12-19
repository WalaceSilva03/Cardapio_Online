package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import com.example.cardapio.food.foodRepository;
import com.example.cardapio.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Diz que é um controle da aplicação
@RequestMapping("food")
public class FoodController {

    @Autowired
    private foodRepository repository;

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        //Resquest Body indica para a aplicação que ela vai receber injetar os dados enviados pelo body.
        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO:: new).toList();
        return foodList;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> update(@PathVariable Long id, @RequestBody Food obj){
        obj = foodService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
