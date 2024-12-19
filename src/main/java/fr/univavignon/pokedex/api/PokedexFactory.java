package fr.univavignon.pokedex.api;

/**
 * Fabrique de Pokédex qui permet de créer une instance de IPokedex.
 * Cette classe fournit une méthode pour initialiser un Pokédex avec un fournisseur de métadonnées
 * et une fabrique de Pokémon.
 */
public class PokedexFactory implements IPokedexFactory {

    /**
     * Crée une instance de IPokedex en utilisant les éléments fournis.
     *
     * @param metadataProvider Le fournisseur de métadonnées pour les Pokémon.
     * @param pokemonFactory La fabrique pour créer des instances de Pokémon.
     * @return Une instance de IPokedex initialisée.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}


