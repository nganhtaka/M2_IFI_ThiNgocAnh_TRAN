package com.ifi.tp.pokemon_type_api.controller;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {
    @Autowired
    private PokemonTypeService pokemonTypeService;

    public PokemonTypeController(PokemonTypeService service) {
        this.pokemonTypeService = service;
    }

    @GetMapping("/{id}")
    public PokemonType getPokemonTypeFromId(@PathVariable int id){
        return this.pokemonTypeService.getPokemonType(id);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.pokemonTypeService.getAllPokemonTypes();
    }

    @RequestMapping(value = "/", params = "name")
    public PokemonType getPokemonTypeFromName(@RequestParam String name){
        return this.pokemonTypeService.getPokemonTypeByName(name);
    }

    @RequestMapping(value = "/", params = "types")
    public List<PokemonType> getAllPokemonTypesByType(@RequestParam String types){
        return this.pokemonTypeService.findAllPokemonByType(types);
    }
}