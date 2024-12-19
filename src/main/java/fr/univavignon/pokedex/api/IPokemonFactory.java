package fr.univavignon.pokedex.api;

/**
 * Interface de fabrique pour la création d'instances de Pokemon.
 * Cette interface définit une méthode permettant de créer un Pokémon en calculant ses IVs.
 *
 * @author fv
 */
public interface IPokemonFactory {

	/**
	 * Crée une instance de Pokemon en calculant ses IVs.
	 *
	 * @param index L'index du Pokémon.
	 * @param cp Les points de combat (CP) du Pokémon.
	 * @param hp Les points de vie (HP) du Pokémon.
	 * @param dust La quantité de poussière d'étoile requise pour améliorer le Pokémon.
	 * @param candy La quantité de bonbons requise pour améliorer le Pokémon.
	 * @return Une instance de Pokemon initialisée.
	 */
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy);

}
