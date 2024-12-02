package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory trainerFactory;

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokedex pokedex;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateTrainer() {

        PokemonTrainer ash = new PokemonTrainer("Ash", Team.VALOR, pokedex);


        Mockito.when(pokedexFactory.createPokedex(Mockito.any(), Mockito.any())).thenReturn(pokedex);


        Mockito.when(trainerFactory.createTrainer(
                        Mockito.eq("Ash"),
                        Mockito.eq(Team.VALOR),
                        Mockito.any(IPokedexFactory.class)))
                .thenReturn(ash);


        PokemonTrainer result = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        assertNotNull(result);
        assertEquals("Ash", result.getName());
        assertEquals(Team.VALOR, result.getTeam());
        assertEquals(pokedex, result.getPokedex());

    }
}