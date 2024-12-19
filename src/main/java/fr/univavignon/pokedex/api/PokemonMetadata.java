package fr.univavignon.pokedex.api;

/**
 * Métadonnées d'un Pokémon.
 * Cette classe contient les caractéristiques de base d'un Pokémon telles que l'index, le nom,
 * le niveau d'attaque, de défense, et d'endurance.
 *
 * @author fv
 */
public class PokemonMetadata {

	/** Index du Pokémon. */
	private final int index;

	/** Nom du Pokémon. */
	private final String name;

	/** Niveau d'attaque du Pokémon. */
	private final int attack;

	/** Niveau de défense du Pokémon. */
	private final int defense;

	/** Niveau d'endurance du Pokémon. */
	private final int stamina;

	/**
	 * Constructeur par défaut.
	 *
	 * @param index L'index du Pokémon.
	 * @param name Le nom du Pokémon.
	 * @param attack Le niveau d'attaque du Pokémon.
	 * @param defense Le niveau de défense du Pokémon.
	 * @param stamina Le niveau d'endurance du Pokémon.
	 */
	public PokemonMetadata(final int index, final String name, final int attack,
						   final int defense, final int stamina) {
		this.index = index;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.stamina = stamina;
	}

	/**
	 * Retourne l'index du Pokémon.
	 *
	 * @return L'index du Pokémon.
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Retourne le nom du Pokémon.
	 *
	 * @return Le nom du Pokémon.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne le niveau d'attaque du Pokémon.
	 *
	 * @return Le niveau d'attaque.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Retourne le niveau de défense du Pokémon.
	 *
	 * @return Le niveau de défense.
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Retourne le niveau d'endurance du Pokémon.
	 *
	 * @return Le niveau d'endurance.
	 */
	public int getStamina() {
		return stamina;
	}
}
