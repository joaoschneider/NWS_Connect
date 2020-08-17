package com.techdev.nwsconnect;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RVAdapter_Recibos extends RecyclerView.Adapter<RVAdapter_Recibos.MyViewHolder> {

    List<FeedRecibos> recibosList;
    RVAdapter_Recibos(List<FeedRecibos> recibos) {this.recibosList = recibos;}

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        MyViewHolder myvh = new MyViewHolder(v);
        return myvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter_Recibos.MyViewHolder holder, int position) {
        holder.Atleta.setText(recibosList.get(position).atleta);
        holder.Data.setText(recibosList.get(position).data);
        holder.Material.setText(recibosList.get(position).material);
        holder.Quantidade.setText(recibosList.get(position).qtd);
        Log.d("Debug","nomea" + recibosList .get(position).atleta);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() { return recibosList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Atleta;
        TextView Data;
        TextView Material;
        TextView Quantidade;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Atleta = itemView.findViewById(R.id.atleta);
            Data = itemView.findViewById(R.id.data);
            Material = itemView.findViewById(R.id.material);
            Quantidade = itemView.findViewById(R.id.quantidade);
        }
    }

}
