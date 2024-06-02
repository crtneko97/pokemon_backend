package com.example.apiapi.Controller;

import com.example.apiapi.model.Pokemon;
import com.example.apiapi.Service.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{name}")
    public Pokemon getPokemon(@PathVariable String name) {
        return pokemonService.getPokemonData(name);
    }
}
