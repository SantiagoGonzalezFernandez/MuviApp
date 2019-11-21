package com.muviteam.muviapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.muviteam.muviapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGeneros extends Fragment {

    private ImageView accion,aventura,animacion,cienciaFiccion,comedia,crimen,documental,drama,familia,fantasia,guerra,historia,horror,misterio,musica,peliculasdetv,romance,western;
    private View view;


    public FragmentGeneros() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generos, container, false);
    }

    public void encontrarVariables(){

        accion = view.findViewById(R.id.boton_genero1);

        aventura = view.findViewById(R.id.boton_genero2);

        animacion = view.findViewById(R.id.boton_genero3);

        cienciaFiccion = view.findViewById(R.id.boton_genero4);

        comedia = view.findViewById(R.id.boton_genero5);

        crimen = view.findViewById(R.id.boton_genero6);

        documental = view.findViewById(R.id.boton_genero7);

        drama = view.findViewById(R.id.boton_genero8);

        familia = view.findViewById(R.id.boton_genero9);

        fantasia = view.findViewById(R.id.boton_genero10);

        guerra = view.findViewById(R.id.boton_genero11);

        historia = view.findViewById(R.id.boton_genero12);

        horror = view.findViewById(R.id.boton_genero13);

        misterio = view.findViewById(R.id.boton_genero14);

        musica = view.findViewById(R.id.boton_genero15);

        peliculasdetv = view.findViewById(R.id.boton_genero16);

        romance = view.findViewById(R.id.boton_genero17);

        western = view.findViewById(R.id.boton_genero18);


    }




}
