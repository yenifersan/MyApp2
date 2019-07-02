package com.example.myapp.activities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.activities.models.Compra;

import java.util.ArrayList;
import java.util.List;

public class ComprasAdapter extends RecyclerView.Adapter<ComprasAdapter.ViewHolder> {

    private List<Compra> compras;

    public ComprasAdapter(){
        this.compras = new ArrayList<>();
    }

    public void setCompras(List<Compra> compras){
        this.compras = compras;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView cliente;
        public TextView anumordcom;
        public TextView afecordcom;


        public ViewHolder(View itemView) {
            super(itemView);
            cliente = itemView.findViewById(R.id.txt_cliente);
            anumordcom = itemView.findViewById(R.id.txt_anumordcom);
            afecordcom = itemView.findViewById(R.id.txt_afecordcom);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_compra, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Compra compra = this.compras.get(position);

        viewHolder.cliente.setText(compra.getCliente());
        viewHolder.anumordcom.setText(compra.getAnumordcom());
        viewHolder.afecordcom.setText(compra.getAfecordcom());
    }

    @Override
    public int getItemCount() {
        return this.compras.size();
    }

}
