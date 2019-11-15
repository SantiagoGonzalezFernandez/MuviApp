package com.muviteam.muviapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.muviteam.muviapp.R;
import com.muviteam.muviapp.controller.ControllerPelicula;
import com.muviteam.muviapp.model.Credits;
import com.muviteam.muviapp.model.Pelicula;
import com.muviteam.muviapp.utils.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentViewPager extends Fragment {

    public static final String CLAVE_PELICULA = "clavePelicula";

    private TextView titulo, director;
    private ImageView imagenFondo, imagenPoster;
    private View view;
    private Pelicula pelicula;
    private String direc;

    public static FragmentViewPager dameUnFragment(Pelicula pelicula){
        FragmentViewPager fragmentViewPager = new FragmentViewPager();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLAVE_PELICULA,pelicula);
        fragmentViewPager.setArguments(bundle);
        return fragmentViewPager;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        buscarVariables();
        Bundle bundle = getArguments();
        pelicula = (Pelicula) bundle.getSerializable(CLAVE_PELICULA);
        cargarPelicula();
        return view;
    }

    public void buscarVariables(){
        titulo = view.findViewById(R.id.FragmentViewPager_TextView_NombrePelicula);
        imagenFondo = view.findViewById(R.id.FragmentViewPager_ImageView_FondoPelicula);
        imagenPoster = view.findViewById(R.id.FragmentViewPager_ImageView_PosterPelicula);
        director = view.findViewById(R.id.FragmentViewPager_TextView_Director);
    }

    public void cargarPelicula(){
        titulo.setText(pelicula.getTitulo());
        Glide.with(getContext())
                .load(pelicula.generaURLImagencelda())
                .placeholder(R.drawable.load)
                .error(R.drawable.logomuvi)
                .into(imagenFondo);
        Glide.with(getContext())
                .load(pelicula.generaURLImagen())
                .placeholder(R.drawable.load)
                .error(R.drawable.logomuvi)
                .into(imagenPoster);
        ControllerPelicula controllerPelicula = new ControllerPelicula();
        controllerPelicula.traerCredits(new ResultListener<Credits>() {
            @Override
            public void finish(Credits result) {
                if (result != null) {
                    direc = result.getCrew().get(0).getNombre();
                } else {
                    direc = "Unknown";
                }
                director.setText(direc);
            }
        }, pelicula.getId());
    }
}
