package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        Map<Integer, PokemonMetadata> metadataMap = new HashMap<>();
        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadataProvider provider = new PokemonMetadataProvider(metadataMap);
        PokemonMetadata metadata = provider.getPokemonMetadata(0);

        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex() {
        PokemonMetadataProvider provider = new PokemonMetadataProvider(new HashMap<>());

        try {
            provider.getPokemonMetadata(999);
            fail("Expected a PokedexException to be thrown");
        } catch (PokedexException e) {
            assertEquals("Invalid Pokémon index: 999", e.getMessage());
        }
    }


}