package fr.univavignon.pokedex.api;

/**
 * Un fournisseur de métadonnées pour les Pokémon.
 * Cette interface fournit des métadonnées pour un Pokémon identifié par un index donné.
 *
 * @author fv
 */
public interface IPokemonMetadataProvider {

	/**
	 * Récupère et retourne les métadonnées du Pokémon identifié par l'index donné.
	 *
	 * @param index L'index du Pokémon pour lequel récupérer les métadonnées.
	 * @return Les métadonnées du Pokémon.
	 * @throws PokedexException Si l'index fourni n'est pas valide.
	 */
	PokemonMetadata getPokemonMetadata(int index) throws PokedexException;

}
