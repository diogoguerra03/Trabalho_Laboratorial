package pt.ipleiria.estg.dei.ei.p2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DetalhesAulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_aula);
    }

    public static Intent createIntent(Context context, int indiceAula){
        /*
        Intent intent = new Intent(context, DetalhesAulaActivity.class);
        intent.putExtra("INDICE_AULA", indiceAula);
        return intent;
         */
        return new Intent(context, DetalhesAulaActivity.class).putExtra("INDICE_AULA", indiceAula);
    }
}