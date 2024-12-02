package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokemonMetadataProvider metadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    @Test
    public void testCreatePokedex() {

        IPokedex pokedex = Mockito.mock(IPokedex.class);


        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);


        IPokedex result = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(result);
    }
}
