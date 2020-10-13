package cl.inacap.pokedexljeria.dao;

import java.util.List;

import cl.inacap.pokedexljeria.dto.Pokemon;

public interface PokemonesDAO {

    Pokemon save(Pokemon p);
    List<Pokemon> getAll();
}
