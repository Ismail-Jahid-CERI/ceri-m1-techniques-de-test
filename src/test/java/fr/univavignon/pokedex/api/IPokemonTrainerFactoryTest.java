package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

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
    public void testCreateTrainerMock() {

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

    @Test
    public void testCreateTrainer() {
        // Crée des métadonnées fictives
        Map<Integer, PokemonMetadata> metadataMap = new HashMap<>();
        metadataMap.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        metadataMap.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));

        // Initialise la factory avec la Map
        PokemonTrainerFactory trainerFactory = new PokemonTrainerFactory(metadataMap);

        // Mock du PokedexFactory et du Pokedex
        IPokedexFactory pokedexFactory = mock(IPokedexFactory.class);
        IPokedex pokedex = mock(IPokedex.class);

        when(pokedexFactory.createPokedex(any(), any())).thenReturn(pokedex);

        // Création du trainer
        PokemonTrainer trainer = trainerFactory.createTrainer("Ash", Team.VALOR, pokedexFactory);

        // Assertions
        assertNotNull(trainer);
        assertEquals("Ash", trainer.getName());
        assertEquals(Team.VALOR, trainer.getTeam());
        assertEquals(pokedex, trainer.getPokedex());
    }
}