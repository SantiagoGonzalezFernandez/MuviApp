package com.muviteam.muviapp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.muviteam.muviapp.R;
import com.muviteam.muviapp.model.Famoso;

import java.util.ArrayList;
import java.util.List;

public class AdapterFamoso extends RecyclerView.Adapter<AdapterFamoso.ViewHolderFamoso> {

    private List<Famoso> famosoList;
    private ListenerDelAdapter listenerDelAdapter;


    public AdapterFamoso(ListenerDelAdapter listenerDelAdapter){
        famosoList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    public void setFamosoList(List<Famoso> famosoList) {
        this.famosoList = famosoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterFamoso.ViewHolderFamoso onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = inflater.inflate(R.layout.celda_famoso,parent,false);
        return new AdapterFamoso.ViewHolderFamoso(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFamoso holder, int position) {
        Famoso famosoAMostrar = famosoList.get(position);
        holder.cargarFamoso(famosoAMostrar);
    }

    @Override
    public int getItemCount() {
        return famosoList.size();}

    public class ViewHolderFamoso extends RecyclerView.ViewHolder{
        private TextView textViewNombre;
        private ImageView imageViewImagenFamoso;
        public ViewHolderFamoso(@NonNull View itemView) {
            super(itemView);
            imageViewImagenFamoso = itemView.findViewById(R.id.CeldaFamoso_ImageView_ImagenFamoso);
            textViewNombre = itemView.findViewById(R.id.CeldaFamoso_TextView_NombreFamoso);

        }
        public void cargarFamoso(Famoso famoso){
            Glide.with(imageViewImagenFamoso.getContext()).load(famoso.generaURLImagen()).placeholder(R.drawable.loading)
                    .error(R.drawable.logomuvi).into(imageViewImagenFamoso);
            textViewNombre.setText(famoso.getNombre());
        }
    }

    public interface ListenerDelAdapter {
        public void informarFamoso(Famoso famoso);
    }
}
