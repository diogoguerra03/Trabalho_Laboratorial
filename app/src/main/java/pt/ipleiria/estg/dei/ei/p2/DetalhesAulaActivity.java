package pt.ipleiria.estg.dei.ei.p2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

import pt.ipleiria.estg.dei.ei.p2.databinding.ActivityDetalhesAulaBinding;
import pt.ipleiria.estg.dei.ei.p2.modelo.Aluno;
import pt.ipleiria.estg.dei.ei.p2.modelo.Aula;
import pt.ipleiria.estg.dei.ei.p2.modelo.GestorSemanaAulas;

public class DetalhesAulaActivity extends AppCompatActivity {

    private static final String INDICE_AULA = "INDICE_AULA";
    private ActivityDetalhesAulaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detalhes_aula);
        binding = ActivityDetalhesAulaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);
        Aula aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);

        binding.textViewNome.setText(aula.getNome());
        binding.textViewNumero.setText(Long.toString(aula.getNumero()));
        binding.textViewDiaSemana.setText(aula.getHorario().toString());
        binding.textViewSala.setText(aula.getSala().getNome());
        binding.textViewProfessor.setText(aula.getProfessor().getNome());

        ListView listViewAlunos = binding.listViewAlunos;

        LinkedList<Aluno> alunos = aula.getAlunos();

        ListAdapter listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos);

        listViewAlunos.setAdapter(listAdapter);


    }

    public static Intent createIntent(Context context, int indiceAula){
        /*
        Intent intent = new Intent(context, DetalhesAulaActivity.class);
        intent.putExtra(INDICE_AULA, indiceAula);
        return intent;
         */
        return new Intent(context, DetalhesAulaActivity.class).putExtra(INDICE_AULA, indiceAula);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes_aula, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemAdicionarAluno){
            onItemAdicionarSelected();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void onItemAdicionarSelected() {
        Toast.makeText(this, "Aqui deveria adicionar um aluno", Toast.LENGTH_LONG).show();
    }
}