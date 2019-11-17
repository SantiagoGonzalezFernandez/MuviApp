package com.muviteam.muviapp.view;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.muviteam.muviapp.R;
import com.muviteam.muviapp.controller.ControllerPelicula;
import com.muviteam.muviapp.model.Credits;
import com.muviteam.muviapp.model.Famoso;
import com.muviteam.muviapp.model.Pelicula;
import com.muviteam.muviapp.model.Videos;
import com.muviteam.muviapp.utils.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePelicula extends Fragment implements AdapterFamoso.ListenerDelAdapter{

    public static final String CLAVE_PELICULA = "clavePelicula";

    private RecyclerView recyclerView;
    private TextView textViewTitulo, textViewSinopsis;
    private Button botonTrailer;
    private ImageView imagenPelicula, posterPelicula;
    private AdapterFamoso adapterFamoso;
    private ListenerDeFragment listenerDelFragment;
    private Pelicula peliculaSeleccionada;
    private View view;
    private String key;
    private ControllerPelicula peliculaController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle_pelicula, container, false);
        encontrarVariables();
        peliculaSeleccionada = (Pelicula) getArguments().getSerializable(CLAVE_PELICULA);
        adapterFamoso = new AdapterFamoso(this);
        peliculaController = new ControllerPelicula();
        cargarVariables();
        traerLaLista();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),recyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapterFamoso);
        return view;
    }

    @Override
    public void informarFamoso(Famoso famoso) {
        listenerDelFragment.informarFamoso(famoso);
    }


    public void encontrarVariables(){
        textViewTitulo = view.findViewById(R.id.fragment_detalle_TituloPelicula);
        textViewSinopsis = view.findViewById(R.id.fragment_detalle_DescripcionPelicula);
        imagenPelicula = view.findViewById(R.id.detalle_peliculas_imageview);
        botonTrailer = view.findViewById(R.id.detalle_peliculas_boton_trailer);
        posterPelicula = view.findViewById(R.id.poster_detalle_pelicula);
        recyclerView = view.findViewById(R.id.fragment_famoso_recycler);
    }

    public void cargarVariables(){
        Glide.with(this).load(peliculaSeleccionada.generaURLImagencelda()).placeholder(R.drawable.load)
                .error(R.drawable.logomuvi).into(imagenPelicula);
        Glide.with(this).load(peliculaSeleccionada.generaURLImagen()).placeholder(R.drawable.load)
                .error(R.drawable.logomuvi).into(posterPelicula);
        textViewTitulo.setText(peliculaSeleccionada.getTitulo());
        textViewSinopsis.setText(peliculaSeleccionada.getSinopsis());
        botonTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peliculaController.traerTrailer(new ResultListener<Videos>() {
                    @Override
                    public void finish(Videos result) {
                        key = result.getResults().get(0).getLlave();
                        cambiarDeActivity();
                    }
                },peliculaSeleccionada.getId());
            }
        });

    }

    public void traerLaLista(){
        peliculaController.traeListaFamosos(peliculaSeleccionada.getId(), new ResultListener<Credits>() {
            @Override
            public void finish(Credits result) {
                adapterFamoso.setFamosoList(result.getCast());
            }
        });
    }

    public interface ListenerDeFragment{
        public void informarFamoso(Famoso famoso);
    }

    private void cambiarDeActivity(){
        Intent intent = new Intent(getContext(),YoutubeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(YoutubeActivity.CLAVE_KEY,key);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
