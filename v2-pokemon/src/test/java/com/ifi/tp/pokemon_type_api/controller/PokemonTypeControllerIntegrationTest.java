package com.ifi.tp.pokemon_type_api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PokemonTypeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PokemonTypeController controller;

    @Test
    void pokemonTypeController_shouldBeInstanciated(){
        assertNotNull(controller);
    }

    @Test
    void getPokemon_withId25_ShouldReturnPikachu() throws Exception {
        var url = "http://localhost:" + port + "/pokemon-types/25";

        var pikachu = this.restTemplate.getForObject(url, PokemonType.class);

        assertNotNull(pikachu);
        assertEquals(25, pikachu.getId());
        assertEquals("pikachu", pikachu.getName());
        assertEquals(4, pikachu.getHeight());
    }

    @Test
    void getPokemon_withNamePikachu_ShouldReturnPikachu() throws Exception {
        /** http://localhost:8080/pokemon-types/?name=pikachu */
        var url = "http://localhost:" + port + "/pokemon-types/?name=pikachu";

        var pikachu = this.restTemplate.getForObject(url, PokemonType.class);

        assertNotNull(pikachu);
        assertEquals(25, pikachu.getId());
        assertEquals("pikachu", pikachu.getName());
        assertEquals(4, pikachu.getHeight());
    }

    @Test
    void getPokemon_withNameMew_ShouldReturnMew() throws Exception {
        /** http://localhost:8080/pokemon-types/?name=mew */
        var url = "http://localhost:" + port + "/pokemon-types/?name=mew";

        var mew = this.restTemplate.getForObject(url, PokemonType.class);

        assertNotNull(mew);
        assertEquals(151, mew.getId());
        assertEquals("mew", mew.getName());
        assertEquals(4, mew.getHeight());
    }

    @Test
    void getPokemon_withTypeElectric_ShouldReturnListElectric() throws Exception {
        /** http://localhost:8080/pokemon-types/?types=electric */
        var url = "http://localhost:" + port + "/pokemon-types/?types=electric";

        var result = this.restTemplate.getForObject(url, List.class);

        assertNotNull(result);
        List<PokemonType> listPokemons = new ObjectMapper().convertValue(result,new TypeReference<List<PokemonType>>(){});
        assertEquals(9, listPokemons.size());
        var pokemon = listPokemons.get(0);
        assertTrue(pokemon instanceof PokemonType);
        assertTrue(((PokemonType) pokemon).getTypes().contains("electric"));
    }

    @Test
    void getPokemon_withTypeElectric_ShouldReturnListBugPoison() throws Exception {
        /** http://localhost:8080/pokemon-types/?types=electric */
        var url = "http://localhost:" + port + "/pokemon-types/?types=bug,poison";

        var result = this.restTemplate.getForObject(url, List.class);

        assertNotNull(result);
        List<PokemonType> listPokemons = new ObjectMapper().convertValue(result,new TypeReference<List<PokemonType>>(){});
        assertEquals(5, listPokemons.size());
        var pokemon = listPokemons.get(0);
        assertTrue(pokemon instanceof PokemonType);
        assertTrue(((PokemonType) pokemon).getTypes().contains("bug"));
        assertTrue(((PokemonType) pokemon).getTypes().contains("poison"));
    }
}