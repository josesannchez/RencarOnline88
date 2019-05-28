package sanchezartega.facci.rencaronline.listasimple;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import sanchezartega.facci.rencaronline.R;


public class adaptador extends BaseAdapter {
    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;

    public adaptador(Context conexto, String[][] datos, int[] imagenes)
    {
        this.contexto = conexto;
        this.datos = datos;//
        this.datosImg = imagenes;

        inflater = (LayoutInflater)conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista2 = inflater.inflate(R.layout.carvi, null);
        TextView titulo = (TextView) vista2.findViewById(R.id.tvNombre2);
        TextView duracion = (TextView) vista2.findViewById(R.id.tvPrecio2);
        ImageView imagen = (ImageView) vista2.findViewById(R.id.ivImagen2);


        titulo.setText(datos[i][0]);
        duracion.setText("Alquilar " + datos[i][2]);
        imagen.setImageResource(datosImg[i]);


        imagen.setTag(i);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vist2 = new Intent(contexto, vist2.class);
                vist2.putExtra("IMG", datosImg[(Integer)v.getTag()]);
                contexto.startActivity(vist2);
            }
        });


        return vista2;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
