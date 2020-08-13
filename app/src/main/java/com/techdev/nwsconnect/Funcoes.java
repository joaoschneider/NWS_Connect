package com.techdev.nwsconnect;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Funcoes extends AppCompatActivity {

    // Initializing a String Array
    String[] material = new String[]{
            "Chuteira",
            "Luva"
    };

    public void setSpinner (Spinner spinnermaterial){
        final List<String> materialList = new ArrayList<>(Arrays.asList(material));

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
}
