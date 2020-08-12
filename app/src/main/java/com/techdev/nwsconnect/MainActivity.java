package com.techdev.nwsconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_after_login);




    }

    public void vaientregamaterial (View view){
        Intent entregamaterial = new Intent(this, entregarMaterial.class);
        startActivity(entregamaterial);

    }
}