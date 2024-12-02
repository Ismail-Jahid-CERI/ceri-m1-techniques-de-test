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
    public void testCreatePokedexMock() {

        IPokedex pokedex = Mockito.mock(IPokedex.class);


        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);


        IPokedex result = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(result);
    }

    @Test
    public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);

        PokedexFactory pokedexFactory = new PokedexFactory();

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertTrue(pokedex instanceof Pokedex);

        try {
            pokedex.getPokemonMetadata(0); // Appelle la méthode pour s'assurer que metadataProvider est utilisé
            verify(metadataProvider, times(1)).getPokemonMetadata(0);
        } catch (Exception e) {
        }
    }
}
