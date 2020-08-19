package com.techdev.nwsconnect;

import com.google.firebase.Timestamp;

public class FeedRecibos {
    public String atleta;
    public Timestamp data;
    public String material;
    public Long qtd;

    FeedRecibos(String atleta, Timestamp data, String material, Long qtd){
        this.atleta = atleta;
        this.data = data;
        this.material = material;
        this.qtd = qtd;
    }
}
