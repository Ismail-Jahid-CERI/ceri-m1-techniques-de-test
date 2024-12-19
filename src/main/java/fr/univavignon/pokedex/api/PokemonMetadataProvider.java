package fr.univavignon.pokedex.api;

import java.util.Map;

/**
 * Fournisseur de métadonnées pour les Pokémon.
 * Cette classe implémente l'interface linIPokemonMetadataProvider et permet de récupérer
 * les métadonnées des Pokémon à partir d'une map préconfigurée.
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    /**
     * Map contenant les métadonnées des Pokémon, indexées par leur identifiant.
     */
    private final Map<Integer, PokemonMetadata> metadataMap;

    /**
     * Construit un fournisseur de métadonnées Pokémon avec une map prédéfinie.
     *
     * @param metadataMap Une map contenant les métadonnées des Pokémon indexées par identifiant.
     */
    public PokemonMetadataProvider(Map<Integer, PokemonMetadata> metadataMap) {
        this.metadataMap = metadataMap;
    }

    /**
     * Récupère les métadonnées d'un Pokémon à partir de son identifiant.
     *
     * @param index L'identifiant du Pokémon.
     * @return Les métadonnées du Pokémon correspondant.
     * @throws PokedexException Si l'identifiant est invalide ou inexistant dans la map.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!metadataMap.containsKey(index)) {
            throw new PokedexException("Index de Pokémon invalide : " + index);
        }

        return metadataMap.get(index);
    }
}


