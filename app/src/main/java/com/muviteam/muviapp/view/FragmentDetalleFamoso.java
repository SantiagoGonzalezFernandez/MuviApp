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
import com.muviteam.muviapp.model.Famoso;

/**
 * A simple {@link Fragment} subclass.
 */
    public class FragmentDetalleFamoso extends Fragment {


    public static final String CLAVE_FAMOSO = "claveFamoso";

    private TextView textViewNombreFamoso, textViewApellidoFamoso, textViewEdadFamoso, textViewBioFamoso;
    private ImageView imagenFamoso;
    private AdapterFamoso adapterFamoso;
    private View view;
    private Famoso famosoSeleccionado;


    public FragmentDetalleFamoso() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle_famoso, container, false);
        encontrarVariables();
        adapterFamoso = new AdapterFamoso((AdapterFamoso.ListenerDelAdapter) this);
        cargarVariables();
        famosoSeleccionado = (Famoso) getArguments().getSerializable(CLAVE_FAMOSO);
        return view;
    }



    public void encontrarVariables(){
        textViewNombreFamoso = view.findViewById(R.id.Fragment_TextView_NombreFamoso);
        textViewApellidoFamoso = view.findViewById(R.id.Fragment_TextView_ApellidoFamoso);
        textViewEdadFamoso = view.findViewById(R.id.Fragment_TextView_EdadFamoso);
        imagenFamoso = view.findViewById(R.id.Fragment_ImageView_Famoso);
    }

    public void cargarVariables(){

        Glide.with(this).load(famosoSeleccionado.generaURLImagen()).placeholder(R.drawable.load)
                .error(R.drawable.logomuvi).into(imagenFamoso);
        textViewNombreFamoso.setText(famosoSeleccionado.getNombre());
        textViewEdadFamoso.setText(famosoSeleccionado.getNacimiento());

    }

}
