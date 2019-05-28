package sanchezartega.facci.rencaronline.listasimple;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import sanchezartega.facci.rencaronline.R;



public class Servicios extends AppCompatActivity {
    Button modelo;
//Creamos la lista
    ListView lista;
    String[][] datos = { // creamos un  array que tendra las imagens
            {"Auto pequeño", "", "", "", ""},
            {"Auto mediano", "", "", "", ""},
            {"Auto Grande", "", "", "", ""}

    };
    //la img tiene que tener el mismo nombre que en array
    int[] datosImg = {R.drawable.ki, R.drawable.camioneta, R.drawable.furgoneta};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        lista = (ListView) findViewById(R.id.lvLista);// llamamos a la lista y al apdatador
        lista.setAdapter(new adaptador(this, datos, datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalles = new Intent(view.getContext(), RedFrA.class);
                startActivity(detalles);
                finish();


            }
        });
        fileList();


    }

    }








