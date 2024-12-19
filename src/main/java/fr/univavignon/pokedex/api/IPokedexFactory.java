package fr.univavignon.pokedex.api;

/**
 * Interface de fabrique pour la création d'instances de IPokedex.
 * Cette interface définit une méthode permettant de créer un Pokédex en utilisant
 * un fournisseur de métadonnées et une fabrique de Pokémon.
 *
 * @author fv
 */
public interface IPokedexFactory {

	/**
	 * Crée une nouvelle instance de {@link IPokedex} en utilisant les éléments fournis.
	 *
	 * @param metadataProvider Le fournisseur de métadonnées utilisé par le Pokédex créé.
	 * @param pokemonFactory La fabrique de Pokémon utilisée par le Pokédex créé.
	 * @return Une instance initialisée de IPokedex.
	 */
	IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory);

}
