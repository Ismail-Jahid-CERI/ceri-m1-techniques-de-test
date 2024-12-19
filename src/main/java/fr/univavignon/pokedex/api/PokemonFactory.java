package fr.univavignon.pokedex.api;

/**
 * Fabrique de Pokémon permettant de créer des instances de Pokémon avec des attributs spécifiques.
 * Cette classe implémente l'interface IPokemonFactory et génère des Pokémon avec un IV aléatoire.
 */
public class PokemonFactory implements IPokemonFactory {

    /**
     * Crée une instance de Pokemon avec les caractéristiques spécifiées.
     *
     * @param index L'index du Pokémon.
     * @param cp La puissance de combat (CP) du Pokémon.
     * @param hp Les points de vie (HP) du Pokémon.
     * @param dust La quantité de poussière d'étoile nécessaire pour améliorer le Pokémon.
     * @param candy La quantité de bonbons nécessaire pour améliorer le Pokémon.
     * @return Une instance de {@link Pokemon} initialisée avec les attributs spécifiés et un IV aléatoire.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        double iv = Math.random() * 100; // IV entre 0 et 100
        return new Pokemon(index, "Example", 100, 100, 100, cp, hp, dust, candy, iv);
    }
}


