package pt.ipleiria.estg.dei.ei.p2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import pt.ipleiria.estg.dei.ei.p2.databinding.ActivityAdicionarAlunoBinding;
import pt.ipleiria.estg.dei.ei.p2.databinding.ActivityDetalhesAulaBinding;
import pt.ipleiria.estg.dei.ei.p2.modelo.Aluno;
import pt.ipleiria.estg.dei.ei.p2.modelo.Aula;
import pt.ipleiria.estg.dei.ei.p2.modelo.GestorSemanaAulas;

public class AdicionarAlunoActivity extends AppCompatActivity {

    private static final String INDICE_AULA = "INDICE_AULA";

    private ActivityAdicionarAlunoBinding binding;
    private Aula aula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_adicionar_aluno);
        binding = ActivityAdicionarAlunoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);

        aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);

    }

    public static Intent createIntent(Context context, int indiceAula){
        Intent intent = new Intent(context, AdicionarAlunoActivity.class);

        intent.putExtra(INDICE_AULA, indiceAula);

        return  intent;
    }

    public void onAdicionarClick(View view) {
        String nome = binding.editTextNome.getText().toString().trim();
        String numeroString =binding.editTextNumero.getText().toString().trim();
        boolean haErros = false;

        if (nome.isEmpty()) {
            binding.editTextNome.setError("Nome inválido");
            haErros = true;
        }
        if (numeroString.isEmpty()){
            binding.editTextNumero.setError("Numero inválido");
            haErros = true;
        }
        if (haErros){
            return;
        }

        long numero = Long.valueOf(numeroString);
        Aluno aluno = new Aluno(nome, numero);
        // Adicionar o aluno à aula
        aula.adicionar(aluno);
        //devolver o resultado
        setResult(RESULT_OK);
        // terminar a atividade
        finish();
    }
}