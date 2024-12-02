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

        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);


        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);


        int index = pokedex.addPokemon(bulbizarre);
        assertEquals(0, index);


        Pokemon result = pokedex.getPokemon(0);
        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test
    public void testGetPokemonsMock() {

        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        List<Pokemon> mockPokemonList = new ArrayList<>();
        mockPokemonList.add(bulbizarre);
        mockPokemonList.add(aquali);

        Mockito.when(pokedex.getPokemons()).thenReturn(mockPokemonList);

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


    @Test
    public void testAddAndGetPokemon2() throws PokedexException {
        // Mock des dépendances
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Initialisation du Pokédex
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Création des Pokémon
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 500, 100, 4000, 3, 80.0);
        Pokemon aquali = new Pokemon(1, "Aquali", 186, 168, 260, 1500, 200, 8000, 4, 95.0);

        // Ajout des Pokémon
        int index1 = pokedex.addPokemon(bulbizarre);
        int index2 = pokedex.addPokemon(aquali);

        // Vérifications sur l'ajout
        assertEquals(0, index1);
        assertEquals(1, index2);
        assertEquals(2, pokedex.size());

        // Récupération et vérification des Pokémon
        Pokemon result1 = pokedex.getPokemon(0);
        Pokemon result2 = pokedex.getPokemon(1);

        assertEquals(bulbizarre, result1);
        assertEquals(aquali, result2);
    }

    @Test
    public void testGetPokemonWithInvalidIndex() {
        // Mock des dépendances
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Initialisation du Pokédex
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Test des indices invalides
        try {
            pokedex.getPokemon(-1);
            fail("Expected PokedexException for negative index.");
        } catch (PokedexException e) {
            assertEquals("Invalid Pokémon index: -1", e.getMessage());
        }

        try {
            pokedex.getPokemon(100);
            fail("Expected PokedexException for out-of-bound index.");
        } catch (PokedexException e) {
            assertEquals("Invalid Pokémon index: 100", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonsSorted() {
        // Mock des dépendances
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        // Initialisation du Pokédex
        Pokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Ajout des Pokémon
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 500, 100, 4000, 3, 80.0);
        Pokemon aquali = new Pokemon(1, "Aquali", 186, 168, 260, 1500, 200, 8000, 4, 95.0);

        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        // Tri par nom
        List<Pokemon> sortedByName = pokedex.getPokemons(PokemonComparators.NAME);
        assertEquals(aquali, sortedByName.get(0));
        assertEquals(bulbizarre, sortedByName.get(1));

        // Tri par CP
        List<Pokemon> sortedByCP = pokedex.getPokemons(PokemonComparators.CP);
        assertEquals(aquali, sortedByCP.get(0));
        assertEquals(bulbizarre, sortedByCP.get(1));
    }

}