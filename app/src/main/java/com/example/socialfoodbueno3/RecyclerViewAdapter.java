package com.example.socialfoodbueno3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<RecetaDto> recetaLista;
    private LayoutInflater recetaInflater;
    private Context context;

    public RecyclerViewAdapter(List<RecetaDto> elementoLista, Context context) {
        this.recetaLista = elementoLista;
        this.recetaInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = recetaInflater.inflate(R.layout.view_holder, null);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.bindData(recetaLista.get(position));
    }

    @Override
    public int getItemCount() {
        return recetaLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tituloTextView, ingredientesTextView, descripcionTextView, nacionalidadTextView, latitudTextView, longitudTextView;

        ViewHolder(View itemView) {
            super(itemView);
            tituloTextView = itemView.findViewById(R.id.viewTitulo);
            ingredientesTextView = itemView.findViewById(R.id.viewIngredientes);
            descripcionTextView = itemView.findViewById(R.id.viewDescripcion);
            nacionalidadTextView = itemView.findViewById(R.id.viewNacionalidad);
            latitudTextView = itemView.findViewById(R.id.viewLatitud);
            longitudTextView = itemView.findViewById(R.id.viewLongitud);
        }

        void bindData(final RecetaDto elemento) {
            tituloTextView.setText(elemento.getTitulo());
            ingredientesTextView.setText(elemento.getIngredientes());
            descripcionTextView.setText(elemento.getDescripcion());
            nacionalidadTextView.setText(elemento.getNacionalidad());
            latitudTextView.setText(elemento.getLatitud());
            longitudTextView.setText(elemento.getLongitud());
        }

    }

}
