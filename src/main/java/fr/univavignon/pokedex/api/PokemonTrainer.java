package fr.univavignon.pokedex.api;

/**
 * Représente un dresseur de Pokémon.
 * Cette classe contient les informations principales sur un dresseur,
 * notamment son nom, son équipe, et son Pokédex associé.
 *
 * @author fv
 */
public class PokemonTrainer {

	/** Nom du dresseur. */
	private final String name;

	/** Équipe du dresseur. */
	private final Team team;

	/** Pokédex du dresseur. */
	private final IPokedex pokedex;

	/**
	 * Constructeur par défaut.
	 *
	 * @param name Le nom du dresseur.
	 * @param team L'équipe du dresseur.
	 * @param pokedex Le Pokédex du dresseur.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}

	/**
	 * Retourne le nom du dresseur.
	 *
	 * @return Le nom du dresseur.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne l'équipe du dresseur.
	 *
	 * @return L'équipe du dresseur.
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Retourne le Pokédex du dresseur.
	 *
	 * @return Le Pokédex du dresseur.
	 */
	public IPokedex getPokedex() {
		return pokedex;
	}

}
