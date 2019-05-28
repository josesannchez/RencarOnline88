package sanchezartega.facci.rencaronline.listasimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import sanchezartega.facci.rencaronline.MainActivity;
import sanchezartega.facci.rencaronline.R;

public class RedFrA extends AppCompatActivity {

    Button registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redfat);
        registro = (Button) findViewById(R.id.btnAlquila);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // se genera la navegabilidad entre la actividad principal y la actividad de login
                Intent intent = new Intent(RedFrA.this, MainActivity.class);
                startActivity(intent);
                finishAfterTransition();

finish();
            }
        });
    }}

