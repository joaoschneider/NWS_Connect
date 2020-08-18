package com.techdev.nwsconnect;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Funcoes extends AppCompatActivity {
    static List<String> mAtletas;
    private final String DEBUG_TAG = "NWSConnect";

    // Initializing a String Array
    String[] material = new String[]{
            "Chuteira",
            "Luva"
    };

    String[] tipos = new String[]{
                "Mista",
                "Primeira linha",
                "Segunda linha",
                "Society"
    };

    protected void setSpinner (Spinner spinnermaterial, String[] stringarray){
        final List<String> materialList = new ArrayList<>(Arrays.asList(stringarray));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.item_spinner,materialList);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.item_spinner);
        spinnermaterial.setAdapter(spinnerArrayAdapter);

        spinnermaterial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void vaientregamaterial (View view){
        Intent entregamaterial = new Intent(this, EntregarMaterial.class);
        startActivity(entregamaterial);
    }

    public void vainovomaterial (View view){
        Intent novomaterial = new Intent(this, NovoMaterial.class);
        startActivity(novomaterial);
    }

    protected void buscarAtletas(){
        final List<String> atletas = new ArrayList<>();
        FirebaseFirestore.getInstance().collection("atletas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot doc : task.getResult().getDocuments()){
                                atletas.add((String) doc.get("nome"));
                            }
                            setAtletas(atletas);
                        }else{
                            Log.e(DEBUG_TAG, "Erro: " + task.getException().toString());
                            Toast.makeText(Funcoes.this, "Verifique sua conexão. Não conseguimos conectar ao banco de dados...", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void setAtletas(List<String> atletas){
        mAtletas = atletas;
        Log.d(DEBUG_TAG, Arrays.toString(mAtletas.toArray()));
    }

    public void vairecibos(View view) {
        Intent recibos = new Intent(this, Recibos.class);
        startActivity(recibos);
    }
}
