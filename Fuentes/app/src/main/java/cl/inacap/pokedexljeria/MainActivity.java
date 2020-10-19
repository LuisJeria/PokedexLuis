package cl.inacap.pokedexljeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        this.pokemonesLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon pokemon = pokemones.get(i);

                Intent intent = new Intent(MainActivity.this,PokemonViewActivity.class);
                intent.putExtra("pokemon",pokemon);
                startActivity(intent);
            }
        });
    }
}