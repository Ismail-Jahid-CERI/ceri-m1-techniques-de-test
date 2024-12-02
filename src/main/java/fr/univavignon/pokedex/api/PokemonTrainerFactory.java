package fr.univavignon.pokedex.api;

import java.util.Map;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    private final Map<Integer, PokemonMetadata> metadataMap;

    public PokemonTrainerFactory(Map<Integer, PokemonMetadata> metadataMap) {
        this.metadataMap = metadataMap;
    }

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(metadataMap);
        IPokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}



