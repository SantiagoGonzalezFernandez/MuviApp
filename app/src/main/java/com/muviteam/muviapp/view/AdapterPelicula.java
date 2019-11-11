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
import com.muviteam.muviapp.controller.ControllerPelicula;
import com.muviteam.muviapp.model.Credits;
import com.muviteam.muviapp.model.Pelicula;
import com.muviteam.muviapp.utils.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class AdapterPelicula extends RecyclerView.Adapter<AdapterPelicula.ViewHolderPeliculas> {

    private List<Pelicula> peliculaList;
    private ListenerDelAdapter listenerDelAdapter;

    public AdapterPelicula(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    public AdapterPelicula(ListenerDelAdapter listenerDelAdapter) {
        peliculaList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = inflater.inflate(R.layout.celda_pelicula, parent, false);
        return new ViewHolderPeliculas(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeliculas holder, int position) {
        Pelicula peliculaMostrada = peliculaList.get(position);
        holder.cargarPelicula(peliculaMostrada);
    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    public class ViewHolderPeliculas extends RecyclerView.ViewHolder {
        private TextView textViewTitulo;
        private TextView textViewDirector;
        private TextView textViewPuntaje;
        private ImageView imageViewImagenDePelicula;
        private String puntaje;
        private String director;

        public ViewHolderPeliculas(@NonNull View itemView) {
            super(itemView);
            imageViewImagenDePelicula = itemView.findViewById(R.id.CeldaPelicula_ImageView_ImagenPelicula);
            textViewTitulo = itemView.findViewById(R.id.CeldaPelicula_TextView_NombrePelicula);
            textViewPuntaje = itemView.findViewById(R.id.CeldaPelicula_TextView_RatingPelicula);
            // textViewDirector = itemView.findViewById(R.id.MovieCard_TextView_DirectorPelicula);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pelicula peliculaSeleccionada = peliculaList.get(getAdapterPosition());
                    listenerDelAdapter.informarPelicula(peliculaSeleccionada);
                }
            });
        }

        public void cargarPelicula(Pelicula pelicula) {
            Glide.with(imageViewImagenDePelicula.getContext()).load(pelicula.generaURLImagen()).placeholder(R.drawable.load)
                    .error(R.drawable.logomuvi).into(imageViewImagenDePelicula);
            textViewTitulo.setText(pelicula.getTitulo());
            textViewDirector.setText("");
            puntaje = Double.toString(pelicula.getPopularity());
            textViewPuntaje.setText(puntaje);
            ControllerPelicula controllerPelicula = new ControllerPelicula();
            controllerPelicula.traerCredits(new ResultListener<Credits>() {
                @Override
                public void finish(Credits result) {
                    if (result != null) {
                        director = result.getCrew().get(0).getNombre();
                    } else {
                        director = "Unknown";
                    }
                    textViewDirector.setText(director);
                }
            }, pelicula.getId());

        }
    }

    public interface ListenerDelAdapter {
        public void informarPelicula(Pelicula pelicula);
    }
}
