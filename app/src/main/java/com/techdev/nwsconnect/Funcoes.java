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
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Funcoes extends AppCompatActivity {
    static List<String> mAtletas;
    static List<FeedRecibos> mRecibos;
    private final String DEBUG_TAG = "NWSConnect";

    // Initializing a String Array
    List<String> material = Arrays.asList(new String[]{
            "Chuteira",
            "Luva"
    });

    List<String> tipos = Arrays.asList(new String[]{
            "Mista",
            "Primeira linha",
            "Segunda linha",
            "Society"
    });

    protected void setSpinner (Spinner spinnermaterial, List<String> stringarray){
        final List<String> materialList = stringarray;

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
        Log.d(DEBUG_TAG,"teste");
        FirebaseFirestore.getInstance().collection("atletas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot doc : task.getResult().getDocuments()){
                                atletas.add((String) doc.get("nome"));
                                Log.d(DEBUG_TAG,"info" + doc.get("nome"));
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

    protected void buscarTransacoes(){
        final List<FeedRecibos> recibos = new ArrayList<>();
        Log.d(DEBUG_TAG,"teste");
        FirebaseFirestore.getInstance().collection("transacoes")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot doc : task.getResult().getDocuments()){
                                recibos.add(new FeedRecibos((String) doc.get("atleta"), (Timestamp) doc.get("data"), (String) doc.get("material"), (Long) doc.get("qtd")));
                                Log.d(DEBUG_TAG,"recibo:" + doc.get("atleta"));
                            }
                            Log.d(DEBUG_TAG,"teste");
                            setTransacoes(recibos);
                        }else{
                            Log.e(DEBUG_TAG, "Erro: " + task.getException().toString());
                            Toast.makeText(Funcoes.this, "Verifique sua conexão. Não conseguimos conectar ao banco de dados...", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void setTransacoes(List<FeedRecibos> recibos){
        mRecibos = recibos;
        Log.d(DEBUG_TAG, Arrays.toString(mRecibos.toArray()));
    }}

