package sanchezartega.facci.rencaronline.lis2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sanchezartega.facci.rencaronline.R;

public class AdaptadorAuto extends RecyclerView.Adapter<AdaptadorAuto.ApdatadorViewHolder> {
    public AdaptadorAuto(ArrayList<Auto> data) {
        this.data = data;
    }


    private ArrayList<Auto> data;


    @Override
    public ApdatadorViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        return new ApdatadorViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false));
    }

    @Override
    public void onBindViewHolder( ApdatadorViewHolder holder, int position) {
        Auto  auto = data.get(position);
        holder.imgMusica.setImageResource(auto.getImg());
        holder.tvNombre.setText(auto.getNombre());
        holder.tvmodelo.setText(auto.getModelo());
        holder.tvprecio.setText(auto.getPrecio());
        holder.tvpropietario.setText(auto.getPropietario());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ApdatadorViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMusica;
        TextView tvNombre;
        TextView tvArtista;
        TextView tvmodelo;
        TextView tvprecio;
        TextView tvpropietario;

        public ApdatadorViewHolder(@NonNull View itemView) {
            super(itemView);
               // imgMusica = (ImageView) itemView.findViewById(R.id.img_musica);
                //tvNombre = (TextView) itemView.findViewById(R.id.tv_nombre);
                tvmodelo = (TextView) itemView.findViewById(R.id.tv_modelo);
                tvprecio = (TextView) itemView.findViewById(R.id.tv_precio);
                tvpropietario = (TextView) itemView.findViewById(R.id.tv_propietario);

            }
    }
}





