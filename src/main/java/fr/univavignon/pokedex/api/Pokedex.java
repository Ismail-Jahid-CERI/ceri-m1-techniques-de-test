package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implémentation de l'interface IPokedex, qui agit comme un gestionnaire de données Pokémon.
 * Cette classe permet le stockage, la récupération et la gestion des Pokémon et de leurs métadonnées.
 */
public class Pokedex implements IPokedex {

    /**
     * Liste de tous les Pokémon stockés dans le Pokédex.
     */
    private final List<Pokemon> pokemons;

    /**
     * Fournisseur de métadonnées pour les Pokémon.
     */
    private final IPokemonMetadataProvider metadataProvider;

    /**
     * Fabrique pour créer des instances de Pokémon.
     */
    private final IPokemonFactory pokemonFactory;

    /**
     * Construit une nouvelle instance de Pokedex.
     *
     * @param metadataProvider Le fournisseur de métadonnées pour les Pokémon.
     * @param pokemonFactory La fabrique pour créer des instances de Pokémon.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    /**
     * Retourne le nombre de Pokémon stockés dans le Pokédex.
     *
     * @return Le nombre de Pokémon.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Ajoute un Pokémon au Pokédex.
     *
     * @param pokemon Le Pokémon à ajouter.
     * @return L'index auquel le Pokémon a été ajouté.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /**
     * Récupère un Pokémon par son index.
     *
     * @param id L'index du Pokémon à récupérer.
     * @return Le Pokémon à l'index spécifié.
     * @throws PokedexException Si l'index est invalide.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Index de Pokémon invalide : " + id);
        }
        return pokemons.get(id);
    }

    /**
     * Récupère une liste non modifiable de tous les Pokémon du Pokédex.
     *
     * @return Une liste non modifiable de Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    /**
     * Récupère une liste triée de tous les Pokémon du Pokédex.
     *
     * @param order Le comparateur à utiliser pour le tri.
     * @return Une liste triée non modifiable de Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);
        return Collections.unmodifiableList(sortedList);
    }

    /**
     * Récupère les métadonnées d'un Pokémon par son index.
     *
     * @param index L'index du Pokémon.
     * @return Les métadonnées du Pokémon.
     * @throws PokedexException Si l'index est invalide.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    /**
     * Crée une nouvelle instance de Pokémon avec les attributs spécifiés.
     *
     * @param index L'index de l'espèce de Pokémon.
     * @param cp La puissance de combat du Pokémon.
     * @param hp Les points de vie du Pokémon.
     * @param dust La quantité de poussière d'étoile nécessaire pour améliorer.
     * @param candy La quantité de bonbons nécessaire pour améliorer.
     * @return L'instance de Pokémon créée.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
