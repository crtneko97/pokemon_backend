package com.example.apiapi.Service;

import com.example.apiapi.model.Pokemon;
import com.example.apiapi.model.PokemonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    private final RestTemplate restTemplate;
    private final PokemonRepository pokemonRepository;

    public PokemonService(RestTemplate restTemplate, PokemonRepository pokemonRepository) {
        this.restTemplate = restTemplate;
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemonData(String pokemonName) {
        Pokemon pokemon = pokemonRepository.findByName(pokemonName);
        if (pokemon == null) {
            String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
            pokemon = restTemplate.getForObject(url, Pokemon.class);
            if (pokemon != null) {
                pokemonRepository.save(pokemon);
            }
        }
        return pokemon;
    }
}
