package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {

        double iv = Math.random() * 100; // IV entre 0 et 100
        return new Pokemon(index, "Example", 100, 100, 100, cp, hp, dust, candy, iv);
    }
}

