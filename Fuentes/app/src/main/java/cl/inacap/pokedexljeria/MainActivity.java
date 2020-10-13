package cl.inacap.pokedexljeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import cl.inacap.pokedexljeria.adapters.PokemonesListAdapter;
import cl.inacap.pokedexljeria.dao.PokemonesDAO;
import cl.inacap.pokedexljeria.dao.PokemonesDAOLista;
import cl.inacap.pokedexljeria.dto.Pokemon;

public class MainActivity extends AppCompatActivity {

    private List<Pokemon> pokemones;
    private PokemonesDAO pokeDAO = PokemonesDAOLista.getInstance();
    private ListView pokemonesLv;
    private PokemonesListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setSupportActionBar((Toolbar) findViewById(R.id.poketoolbar));
        this.pokemones = this.pokeDAO.getAll();
        this.pokemonesLv = findViewById(R.id.pokemones_lv);
        this.adapter = new PokemonesListAdapter(this, R.layout.pokemones_list, this.pokemones);
        this.pokemonesLv.setAdapter(this.adapter);
    }
}