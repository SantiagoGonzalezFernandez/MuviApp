package com.muviteam.muviapp.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.muviteam.muviapp.R;
import com.muviteam.muviapp.controller.ControllerPelicula;
import com.muviteam.muviapp.model.Famoso;
import com.muviteam.muviapp.model.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleFamoso extends Fragment implements AdapterFamoso.ListenerDelAdapter,
        AdapterPelicula.ListenerDelAdapter {

    public static final String CLAVE_FAMOSO = "claveFamoso";

    private TextView textViewNombreFamoso, textViewEdadFamoso, textViewBioFamoso;
    private ImageView imagenFamoso;
    private AdapterFamoso adapterFamoso;
    private View view;
    private Famoso famosoSeleccionado;
    private ControllerPelicula peliculaController;
    private ListenerDeFragment listenerDelFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle_famoso, container, false);
        encontrarVariables();
        famosoSeleccionado = (Famoso) getArguments().getSerializable(CLAVE_FAMOSO);
        adapterFamoso = new AdapterFamoso(this);
        peliculaController = new ControllerPelicula();
        cargarVariables();
        return view;
    }


    public void encontrarVariables() {
        textViewNombreFamoso = view.findViewById(R.id.Fragment_TextView_NombreFamoso);
        textViewEdadFamoso = view.findViewById(R.id.Fragment_TextView_EdadFamoso);
        imagenFamoso = view.findViewById(R.id.Fragment_ImageView_Famoso);
    }

    public void cargarVariables() {
        Glide.with(this).load(famosoSeleccionado.generaURLImagen()).placeholder(R.drawable.load)
                .error(R.drawable.logomuvi).into(imagenFamoso);
        textViewNombreFamoso.setText(famosoSeleccionado.getNombre());
        textViewEdadFamoso.setText(famosoSeleccionado.getNacimiento());

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDelFragment = (ListenerDeFragment) context;
    }

    public interface ListenerDeFragment {
        public void informarFamoso(Famoso famoso);

        public void informarPelicula(Pelicula pelicula);
    }

    @Override
    public void informarFamoso(Famoso famoso) {
        listenerDelFragment.informarFamoso(famoso);
    }

    @Override
    public void informarPelicula(Pelicula pelicula) {
        listenerDelFragment.informarPelicula(pelicula);
    }
}
