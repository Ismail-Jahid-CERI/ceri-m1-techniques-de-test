package fr.univavignon.pokedex.api;

import java.util.Map;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> metadataMap;


    public PokemonMetadataProvider(Map<Integer, PokemonMetadata> metadataMap) {
        this.metadataMap = metadataMap;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Vérifie si l'index existe dans la map
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Invalid Pokémon index: " + index);
        }

        // Retourne les métadonnées associées
        return metadataMap.get(index);
    }
}

