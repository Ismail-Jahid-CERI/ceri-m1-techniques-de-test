package fr.univavignon.pokedex.api;

import java.util.Map;

/**
 * Fabrique de dresseurs de Pokémon, permettant de créer des instances de PokemonTrainer.
 * Cette classe utilise une map de métadonnées pour initialiser les Pokédex des dresseurs.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Map contenant les métadonnées des Pokémon, indexées par leur identifiant.
     */
    private final Map<Integer, PokemonMetadata> metadataMap;

    /**
     * Construit une fabrique de dresseurs avec une map de métadonnées prédéfinie.
     *
     * @param metadataMap Une map contenant les métadonnées des Pokémon indexées par identifiant.
     */
    public PokemonTrainerFactory(Map<Integer, PokemonMetadata> metadataMap) {
        this.metadataMap = metadataMap;
    }

    /**
     * Crée une instance de PokemonTrainer avec un nom, une équipe et un Pokédex initialisé.
     *
     * @param name Le nom du dresseur.
     * @param team L'équipe du dresseur (VALOR, MYSTIC, ou INSTINCT).
     * @param pokedexFactory La fabrique utilisée pour créer le Pokédex.
     * @return Une instance de PokemonTrainer initialisée.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(metadataMap);
        IPokemonFactory pokemonFactory = new PokemonFactory();
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
        return new PokemonTrainer(name, team, pokedex);
    }
}




