package com.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        for (PokemonType pt : pokemons) {
            if (pt.getId() == id) return pt;
        }
        return null;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        for (PokemonType pt : pokemons) {
            if (pt.getName().equals(name)) return pt;
        }
        return null;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return pokemons;
    }

    @Override
    public List<PokemonType> findAllPokemonByType(String types) {
        List<PokemonType> listPokemons = new ArrayList<>();

        if (types != null) {
            for (PokemonType pt : pokemons) {
                if (pt.getTypes() != null) {
                    if (pt.getTypes().containsAll(Arrays.asList(types.split(",")))) listPokemons.add(pt);
                }
            }
        }

        return listPokemons;
    }
}