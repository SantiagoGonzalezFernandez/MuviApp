package com.muviteam.muviapp.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.muviteam.muviapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGeneros extends Fragment {

    private ImageView accion, aventura, animacion, cienciaFiccion, comedia, crimen, documental, drama, familia, fantasia, guerra, historia, horror, misterio, musica, peliculasdetv, romance, western;
    private View view;


    public FragmentGeneros() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_generos, container, false);

        encontrarVariables();

        return view;
    }

    public void encontrarVariables() {

        accion = view.findViewById(R.id.boton_genero1);
        accion.setOnClickListener(new OnClickDeLosBotones());

        aventura = view.findViewById(R.id.boton_genero2);
        aventura.setOnClickListener(new OnClickDeLosBotones());

        animacion = view.findViewById(R.id.boton_genero3);
        animacion.setOnClickListener(new OnClickDeLosBotones());

        cienciaFiccion = view.findViewById(R.id.boton_genero4);
        cienciaFiccion.setOnClickListener(new OnClickDeLosBotones());


        comedia = view.findViewById(R.id.boton_genero5);
        comedia.setOnClickListener(new OnClickDeLosBotones());


        crimen = view.findViewById(R.id.boton_genero6);
        crimen.setOnClickListener(new OnClickDeLosBotones());


        documental = view.findViewById(R.id.boton_genero7);
        documental.setOnClickListener(new OnClickDeLosBotones());


        drama = view.findViewById(R.id.boton_genero8);
        drama.setOnClickListener(new OnClickDeLosBotones());


        familia = view.findViewById(R.id.boton_genero9);
        familia.setOnClickListener(new OnClickDeLosBotones());


        fantasia = view.findViewById(R.id.boton_genero10);
        fantasia.setOnClickListener(new OnClickDeLosBotones());


        guerra = view.findViewById(R.id.boton_genero11);
        guerra.setOnClickListener(new OnClickDeLosBotones());


        historia = view.findViewById(R.id.boton_genero12);
        historia.setOnClickListener(new OnClickDeLosBotones());


        horror = view.findViewById(R.id.boton_genero13);
        horror.setOnClickListener(new OnClickDeLosBotones());


        misterio = view.findViewById(R.id.boton_genero14);
        misterio.setOnClickListener(new OnClickDeLosBotones());


        musica = view.findViewById(R.id.boton_genero15);
        musica.setOnClickListener(new OnClickDeLosBotones());


        peliculasdetv = view.findViewById(R.id.boton_genero16);
        peliculasdetv.setOnClickListener(new OnClickDeLosBotones());


        romance = view.findViewById(R.id.boton_genero17);
        romance.setOnClickListener(new OnClickDeLosBotones());


        western = view.findViewById(R.id.boton_genero18);
        western.setOnClickListener(new OnClickDeLosBotones());



    }

    private class OnClickDeLosBotones implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.boton_genero1:
                    Toast.makeText(getContext(), "Peliculas de accion", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero2:
                    Toast.makeText(getContext(), "Peliculas de aventura", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero3:
                    Toast.makeText(getContext(), "Peliculas de animacion", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero4:
                    Toast.makeText(getContext(), "Peliculas de ciencia ficcion", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero5:
                    Toast.makeText(getContext(), "Peliculas de comedia", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero6:
                    Toast.makeText(getContext(), "Peliculas de crimen", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero7:
                    Toast.makeText(getContext(), "Peliculas de documental", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero8:
                    Toast.makeText(getContext(), "Peliculas de drama", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero9:
                    Toast.makeText(getContext(), "Peliculas de familia", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero10:
                    Toast.makeText(getContext(), "Peliculas de fantasia", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero11:
                    Toast.makeText(getContext(), "Peliculas de guerra", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero12:
                    Toast.makeText(getContext(), "Peliculas de historia", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero13:
                    Toast.makeText(getContext(), "Peliculas de horror", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero14:
                    Toast.makeText(getContext(), "Peliculas de misterio", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero15:
                    Toast.makeText(getContext(), "Peliculas de musica", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero16:
                    Toast.makeText(getContext(), "Peliculas de tv", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero17:
                    Toast.makeText(getContext(), "Peliculas de romance", Toast.LENGTH_SHORT).show();

                    break;
                case R.id.boton_genero18:
                    Toast.makeText(getContext(), "Peliculas de western", Toast.LENGTH_SHORT).show();

                    break;

            }
        }
    }


}
