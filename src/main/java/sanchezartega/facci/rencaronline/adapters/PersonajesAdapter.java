package sanchezartega.facci.rencaronline.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sanchezartega.facci.rencaronline.R;
import sanchezartega.facci.rencaronline.clases.PersonajeVo;


/**
 * Created by CHENAO on 13/07/2017.
 */

public class PersonajesAdapter extends RecyclerView.Adapter<PersonajesAdapter.PersonajeViewHolder>{

    ArrayList<PersonajeVo> listaPersonaje;

    public PersonajesAdapter(ArrayList<PersonajeVo> listaPersonaje) {
        this.listaPersonaje=listaPersonaje;
    }

    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        return new PersonajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        holder.txtNombre.setText(listaPersonaje.get(position).getNombre());
        holder.txtInformacion.setText(listaPersonaje.get(position).getInfo());
        holder.foto.setImageResource(listaPersonaje.get(position).getImagenId());
    }

    @Override
    public int getItemCount() {
        return listaPersonaje.size();
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtInformacion;
        ImageView foto;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            txtNombre= (TextView) itemView.findViewById(R.id.idNombre);
            txtInformacion= (TextView) itemView.findViewById(R.id.idInfo);
            foto= (ImageView) itemView.findViewById(R.id.idImagen);
        }
    }
}
