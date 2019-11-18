package com.ifi.tp.pokemon_type_api.service;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.repository.PokemonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService{

    @Autowired
    public PokemonTypeRepository pokemonTypeRepository;

    public PokemonTypeServiceImpl(){ // TODO

    }

    public PokemonTypeServiceImpl(PokemonTypeRepository ptr) {
        this.pokemonTypeRepository = ptr;
    }

    public PokemonTypeRepository getPokemonTypeRepository() {
        return pokemonTypeRepository;
    }

    @Override
    public PokemonType getPokemonType(int id) {
        return this.pokemonTypeRepository.findPokemonTypeById(id);
    }

    @Override
    public List<PokemonType> getAllPokemonTypes(){
        return this.pokemonTypeRepository.findAllPokemonType();
    }

    @Override
    public PokemonType getPokemonTypeByName(String name) {
        return this.pokemonTypeRepository.findPokemonTypeByName(name);
    }

    @Override
    public List<PokemonType> findAllPokemonByType(String type) {
        return this.pokemonTypeRepository.findAllPokemonByType(type);
    }
}