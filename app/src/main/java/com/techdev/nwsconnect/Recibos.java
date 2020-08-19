package com.techdev.nwsconnect;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recibos extends Funcoes {

    ViewGroup mLayout_menu;
    RecyclerView rv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telarecibo);


        mLayout_menu = (ViewGroup) getLayoutInflater().inflate(R.layout.telarecibo, null);

        rv = mLayout_menu.findViewById(R.id.rv_recibo);
        RVAdapter_Recibos adapter = new RVAdapter_Recibos(mRecibos);
        GridLayoutManager llm = new GridLayoutManager(this,1);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        setContentView(mLayout_menu);


    }


}
