package cl.inacap.pokedexljeria.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.inacap.pokedexljeria.R;
import cl.inacap.pokedexljeria.dto.Pokemon;

public class PokemonesListAdapter extends ArrayAdapter<Pokemon>{

    private List<Pokemon> pokemones;
    private Activity activity;
    private final static int[] imgIconos={R.drawable.ic_lightning,R.drawable.ic_fire,R.drawable.ic_water_drops,R.drawable.ic_leaf};

    public PokemonesListAdapter(@NonNull Activity context, int resource, @NonNull List<Pokemon> objects) {
        super(context, resource, objects);
        this.pokemones = objects;
        this.activity = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = this.activity.getLayoutInflater();
        View fila = inflater.inflate(R.layout.pokemones_list, null, true);

        TextView nombreTv = fila.findViewById(R.id.nombre_poke_pl);
        TextView tipoTv = fila.findViewById(R.id.tipo_poke_pl);
        ImageView imgTv = fila.findViewById(R.id.img_poke_lv);
        Pokemon actual = pokemones.get(position);
        nombreTv.setText(actual.getNombre());
        tipoTv.setText(actual.getTipo());
        imgTv.setImageResource(imgIconos[actual.getIcono()]);

        return fila;
    }
}
