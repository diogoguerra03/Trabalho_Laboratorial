package pt.ipleiria.estg.dei.ei.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

import pt.ipleiria.estg.dei.ei.p2.databinding.ActivityMainBinding;
import pt.ipleiria.estg.dei.ei.p2.modelo.Aula;
import pt.ipleiria.estg.dei.ei.p2.modelo.GestorSemanaAulas;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //ListView listViewAulas = findViewById(R.id.listViewAulas);
        ListView listViewAulas = binding.listViewAulas;

        LinkedList<Aula> aulas = GestorSemanaAulas.INSTANCIA.getAulas();

        ListAdapter listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                aulas);

        listViewAulas.setAdapter(listAdapter);

        listViewAulas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"Posição Selecionada: " + position,Toast.LENGTH_SHORT).show();
                startActivity(DetalhesAulaActivity.createIntent(getApplicationContext(),position));
            }
        });

    }
}