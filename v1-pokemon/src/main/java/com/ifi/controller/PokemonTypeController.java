package com.ifi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.bo.PokemonType;
import com.ifi.repository.PokemonTypeRepository;
import com.ifi.servlet.Controller;
import com.ifi.servlet.RequestMapping;

import java.util.Map;

@Controller
public class PokemonTypeController {
    private PokemonTypeRepository repository = new PokemonTypeRepository();

    @RequestMapping(uri="/pokemon")
    public String getPokemon(Map<String,String[]> parameters) throws Exception {
        /*  http://localhost:8080/pokemons?id=25
            http://localhost:8080/pokemons?id=145
            http://localhost:8080/pokemons?name=pikachu
            http://localhost:8080/pokemons?name=zapdos */

        if (parameters != null) {
            for (String keyElem : parameters.keySet()) {
                if (parameters.get(keyElem) == null || parameters.get(keyElem).length == 0 ) {
                    throw new IllegalArgumentException("parameters should not be empty");
                }
                if ("id".equals(keyElem)) {
                    return new ObjectMapper().writeValueAsString(repository.findPokemonById(Integer.parseInt(parameters.get(keyElem)[0])));
                } else if ("name".equals(keyElem)) {
                    return new ObjectMapper().writeValueAsString(repository.findPokemonByName(parameters.get(keyElem)[0]));
                } else {
                    throw new IllegalArgumentException("unknown parameter");
                }
            }
        }
        throw new IllegalArgumentException("parameters should not be empty");
    }
}