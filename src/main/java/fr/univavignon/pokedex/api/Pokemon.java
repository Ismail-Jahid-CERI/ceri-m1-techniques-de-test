package fr.univavignon.pokedex.api;

/**
 * Représente un Pokémon avec ses caractéristiques détaillées.
 * Cette classe hérite de {@link PokemonMetadata} et ajoute des propriétés supplémentaires
 * telles que les points de combat (CP), les points de vie (HP), et le pourcentage de perfection IV.
 *
 * @author fv
 */
public final class Pokemon extends PokemonMetadata {

	/** Points de combat (CP) du Pokémon. */
	private final int cp;

	/** Points de vie (HP) du Pokémon. */
	private final int hp;

	/** Quantité de poussière d'étoile requise pour améliorer ce Pokémon. */
	private final int dust;

	/** Quantité de bonbons requise pour améliorer ce Pokémon. */
	private final int candy;

	/** Pourcentage de perfection IV. */
	private final double iv;

	/**
	 * Constructeur par défaut.
	 *
	 * @param index L'index du Pokémon.
	 * @param name Le nom du Pokémon.
	 * @param attack Le niveau d'attaque du Pokémon.
	 * @param defense Le niveau de défense du Pokémon.
	 * @param stamina Le niveau d'endurance du Pokémon.
	 * @param cp Les points de combat (CP) du Pokémon.
	 * @param hp Les points de vie (HP) du Pokémon.
	 * @param dust La quantité de poussière d'étoile requise pour l'amélioration.
	 * @param candy La quantité de bonbons requise pour l'amélioration.
	 * @param iv Le pourcentage de perfection IV.
	 */
	public Pokemon(
			final int index,
			final String name,
			final int attack,
			final int defense,
			final int stamina,
			final int cp,
			final int hp,
			final int dust,
			final int candy,
			final double iv) {
		super(index, name, attack, defense, stamina);
		this.cp = cp;
		this.hp = hp;
		this.dust = dust;
		this.candy = candy;
		this.iv = iv;
	}

	/**
	 * Retourne les points de combat (CP) du Pokémon.
	 *
	 * @return Les points de combat (CP).
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Retourne les points de vie (HP) du Pokémon.
	 *
	 * @return Les points de vie (HP).
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Retourne la quantité de poussière d'étoile requise pour améliorer ce Pokémon.
	 *
	 * @return La quantité de poussière d'étoile.
	 */
	public int getDust() {
		return dust;
	}

	/**
	 * Retourne la quantité de bonbons requise pour améliorer ce Pokémon.
	 *
	 * @return La quantité de bonbons.
	 */
	public int getCandy() {
		return candy;
	}

	/**
	 * Retourne le pourcentage de perfection IV du Pokémon.
	 *
	 * @return Le pourcentage de perfection IV.
	 */
	public double getIv() {
		return iv;
	}

}
