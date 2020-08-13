package com.techdev.nwsconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NovoMaterial extends Funcoes{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novomaterial);

        Spinner spinnermaterial = findViewById(R.id.spinner);
        final EditText tamanho = findViewById(R.id.tamanho);
        final EditText tipo = findViewById(R.id.tipo);

        final List<String> materialList = new ArrayList<>(Arrays.asList(material));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.item_spinner,materialList);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.item_spinner);
        spinnermaterial.setAdapter(spinnerArrayAdapter);

        spinnermaterial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if("Chuteira" == (String) parent.getItemAtPosition(position)){
                    tamanho.setVisibility(View.GONE);
                    tipo.setVisibility(View.GONE);

                }
                else{
                    tipo.setVisibility(View.VISIBLE);
                    tamanho.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
