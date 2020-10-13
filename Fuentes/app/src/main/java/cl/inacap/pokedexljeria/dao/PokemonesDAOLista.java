package cl.inacap.pokedexljeria.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.pokedexljeria.dto.Pokemon;

public class PokemonesDAOLista implements PokemonesDAO {

    private static List<Pokemon> pokemones = new ArrayList<>();
    private static PokemonesDAOLista instancia;

    public static PokemonesDAOLista getInstance(){
        if(instancia == null){
            instancia = new PokemonesDAOLista();
        }
        return instancia;
    }
    private PokemonesDAOLista(){
        Pokemon p = new Pokemon();
        p.setNombre("Pikachu");
        p.setTipo("Electrico");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        p.setFoto("https://i.pinimg.com/474x/ab/a7/40/aba74081bbb7d256c43a80eaac88ba7a.jpg");
        p.setIcono(0);
        pokemones.add(p);

        p = new Pokemon();
        p.setNombre("Charmander");
        p.setTipo("Fuego");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        p.setFoto("https://pm1.narvii.com/6375/b6914ab388480df3db5a4ee455a5fb780bc762ec_hq.jpg");
        p.setIcono(1);
        pokemones.add(p);

        p = new Pokemon();
        p.setNombre("Squirtle");
        p.setTipo("Agua");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        p.setFoto("https://easydrawingart.com/wp-content/uploads/2019/08/How-to-draw-Squirtle.jpg");
        p.setIcono(2);
        pokemones.add(p);

        p = new Pokemon();
        p.setNombre("Bulbasaur");
        p.setTipo("Planta");
        p.setDescripcion("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        p.setFoto("https://i.pinimg.com/originals/eb/8a/a7/eb8aa77a9d30d043b99d94be550ef2de.jpg");
        p.setIcono(3);
        pokemones.add(p);






    }
    @Override
    public Pokemon save(Pokemon p) {
        pokemones.add(p);
        return p;
    }

    @Override
    public List<Pokemon> getAll() {
        return pokemones;
    }
}
