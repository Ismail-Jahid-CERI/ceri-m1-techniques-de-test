package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreatePokemon() {

        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);


        Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);


        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);


        assertEquals("Bulbizarre", result.getName());
        assertEquals(613, result.getCp());
        assertEquals(56.0, result.getIv(), 0.001);
    }

    @Test
    public void testCreatePokemon2() {
        PokemonFactory factory = new PokemonFactory();

        Pokemon pokemon = factory.createPokemon(1, 500, 100, 4000, 3);

        assertNotNull(pokemon);
        assertEquals(1, pokemon.getIndex());
        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
    }

    @Test
    public void testCreateRocketPokemon3() {
        RocketPokemonFactory factory = new RocketPokemonFactory();

        Pokemon pokemon = factory.createPokemon(1, 500, 100, 4000, 3);

        assertNotNull(pokemon);
        assertEquals(1, pokemon.getIndex());
        assertEquals(500, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(3, pokemon.getCandy());
        assertTrue(pokemon.getIv() >= 0 && pokemon.getIv() <= 100);
    }
}