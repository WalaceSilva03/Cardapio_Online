package com.example.cardapio.food;

import org.springframework.data.jpa.repository.JpaRepository;

public interface foodRepository  extends JpaRepository<Food, Long> {
}
