package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokedexTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private IPokedex pokedex;

    @Test
    public void testAddAndGetPokemonMock() throws PokedexException {
        // Mock d'un Pokémon
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);

        // Configuration du comportement attendu
        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);

        // Test de l'ajout
        int index = pokedex.addPokemon(bulbizarre);
        assertEquals(0, index);

        // Test de la récupération
        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test
    public void testGetPokemonsMock() {
        // Mock d'une liste de Pokémon
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        List<Pokemon> mockPokemonList = new ArrayList<>();
        mockPokemonList.add(bulbizarre);
        mockPokemonList.add(aquali);

        Mockito.when(pokedex.getPokemons()).thenReturn(mockPokemonList);
        // Test de la récupération de tous les Pokémon
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals("Bulbizarre", pokemons.get(0).getName());
        assertEquals("Aquali", pokemons.get(1).getName());
    }

    @Test
    public void testAddAndGetPokemon() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
        Pokemon pokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 500, 100, 4000, 3, 80.0);

        int index = pokedex.addPokemon(pokemon);

        assertEquals(0, index);
        assertEquals(pokemon, pokedex.getPokemon(index));
    }

    @Test
    public void testGetPokemons() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 500, 100, 4000, 3, 80.0);
        Pokemon aquali = new Pokemon(1, "Aquali", 186, 168, 260, 1500, 200, 8000, 4, 95.0);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertTrue(pokemons.contains(bulbizarre));
        assertTrue(pokemons.contains(aquali));
    }




}