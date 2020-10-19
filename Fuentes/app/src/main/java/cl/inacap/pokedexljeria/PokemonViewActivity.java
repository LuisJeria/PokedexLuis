package cl.inacap.pokedexljeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cl.inacap.pokedexljeria.dto.Pokemon;

public class PokemonViewActivity extends AppCompatActivity {
    Pokemon pokemon;
    private final static int[] imgIconos={R.drawable.ic_lightning,R.drawable.ic_fire,R.drawable.ic_water_drops,R.drawable.ic_leaf};
    TextView nombrePokeTv;
    ImageView iconoPokeTv;
    ImageView fotoPokeTv;
    TextView descripocionPokeTv;
    int contador=1;
    Toolbar poketoolbar;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_view);
        this.poketoolbar= findViewById(R.id.poketoolbar);
        this.setSupportActionBar(this.poketoolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(true);

        this.nombrePokeTv = findViewById(R.id.nombre_poke_view);
        this.iconoPokeTv = findViewById(R.id.img_poke_view);
        this.fotoPokeTv = findViewById(R.id.foto_poke_view);
        this.descripocionPokeTv = findViewById(R.id.desc_poke_view);
        if(getIntent().getExtras() != null){
            this.pokemon = (Pokemon)getIntent().getSerializableExtra("pokemon");
            contador += this.pokemon.getIcono();
            this.nombrePokeTv.setText(contador +". "+this.pokemon.getNombre());
            this.iconoPokeTv.setImageResource(imgIconos[pokemon.getIcono()]);
            Picasso.get().load(this.pokemon.getFoto()).resize(300,300).centerCrop().into(this.fotoPokeTv);
            this.descripocionPokeTv.setText(this.pokemon.getDescripcion());
        }
    }


}