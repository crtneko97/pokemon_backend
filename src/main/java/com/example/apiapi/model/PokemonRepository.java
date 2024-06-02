package com.example.apiapi.model;


import com.example.apiapi.model.Pokemon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);
    List<Pokemon> findAll(); // Method to fetch all Pokémon entities
}