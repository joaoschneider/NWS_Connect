package com.techdev.nwsconnect;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NovoMaterial extends Funcoes{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novomaterial);

        Spinner spinnermaterial = findViewById(R.id.spinner);
        Spinner spinnertrava = findViewById(R.id.tipotravaspinner);

        materialSpinner(spinnermaterial, spinnertrava);

        setSpinner(spinnertrava, tipos);

    }



    public void materialSpinner(Spinner spinnermaterial, final Spinner tipo){
        final List<String> materialList = new ArrayList<>(Arrays.asList(material));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,R.layout.item_spinner,materialList);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.item_spinner);
        spinnermaterial.setAdapter(spinnerArrayAdapter);

        spinnermaterial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if("Luva" == (String) parent.getItemAtPosition(position)){
                    tipo.setVisibility(View.GONE);

                }
                else{
                    tipo.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
