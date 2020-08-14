package com.techdev.nwsconnect;

import android.os.Bundle;

import android.widget.Spinner;


public class EntregarMaterial extends Funcoes{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entregarmaterial);

        Spinner spinnermaterial = findViewById(R.id.spinner);
        setSpinner(spinnermaterial, material);




    }


}

