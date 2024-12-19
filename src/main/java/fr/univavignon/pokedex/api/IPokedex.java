package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

/**
 * Interface IPokedex. Un IPokedex vise à stocker toutes les informations sur
 * les Pokémon capturés, ainsi que leurs métadonnées par défaut.
 *
 * @author fv
 */
public interface IPokedex extends IPokemonMetadataProvider, IPokemonFactory {

	/**
	 * Retourne le nombre de Pokémon que contient ce Pokédex.
	 *
	 * @return Nombre de Pokémon dans ce Pokédex.
	 */
	int size();


	/**
	 * Ajoute le Pokémon donné à ce Pokédex et retourne son index unique.
	 *
	 * @param pokemon Le Pokémon à ajouter à ce Pokédex.
	 * @return Index de ce Pokémon par rapport à ce Pokédex.
	 */
	int addPokemon(Pokemon pokemon);

	/**
	 * Localise le Pokémon identifié par l'identifiant donné.
	 *
	 * @param id Identifiant unique relatif au Pokédex.
	 * @return Pokémon désigné par l'identifiant donné.
	 * @throws PokedexException Si l'index donné n'est pas valide.
	 */
	Pokemon getPokemon(int id) throws PokedexException;

	/**
	 * Retourne une liste non modifiable de tous les Pokémon que contient ce Pokédex.
	 *
	 * @return Liste non modifiable de tous les Pokémon.
	 */
	List<Pokemon> getPokemons();

	/**
	 * Retourne une liste non modifiable de tous les Pokémon que contient ce Pokédex.
	 * La vue de la liste sera triée en utilisant l'ordre donné.
	 *
	 * @param order Instance de comparateur utilisée pour trier la vue créée.
	 * @return Liste triée et non modifiable de tous les Pokémon.
	 */
	List<Pokemon> getPokemons(Comparator<Pokemon> order);

}
