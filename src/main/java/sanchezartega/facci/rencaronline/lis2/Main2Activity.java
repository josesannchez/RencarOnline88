package sanchezartega.facci.rencaronline.lis2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import sanchezartega.facci.rencaronline.R;

public class Main2Activity extends AppCompatActivity {
    private RecyclerView rvMusicas;
    private GridLayoutManager glm;
    private AdaptadorAuto adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carlista);
        rvMusicas = (RecyclerView) findViewById(R.id.lisauto);

        glm = new GridLayoutManager(this, 1);
        rvMusicas.setLayoutManager(glm);
        adapter = new AdaptadorAuto(dataSet());
        rvMusicas.setAdapter(adapter);

    }

    private ArrayList<Auto> dataSet() {
        ArrayList<Auto> data = new ArrayList<>();
        data.add(new Auto("Radioactive", "Imagine Dragons","Imagine Dragons","Imagine Dragons", R.drawable.ki));
        data.add(new Auto("Radioactive", "Imagine Dragons","Imagine Dragons","Imagine Dragons", R.drawable.auto));
        data.add(new Auto("Radioactive", "Imagine Dragons","Imagine Dragons","Imagine Dragons", R.drawable.autogrande));
        data.add(new Auto("Radioactive", "Imagine Dragons","Imagine Dragons","Imagine Dragons", R.drawable.autoss));
        data.add(new Auto("Radioactive", "Imagine Dragons","Imagine Dragons","Imagine Dragons", R.drawable.auto));
        data.add(new Auto("Radioactive", "Imagine Dragons","Imagine Dragons","Imagine Dragons", R.drawable.autogrande));
        return data;
    }

    
}
