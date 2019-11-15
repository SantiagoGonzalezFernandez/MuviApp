package com.muviteam.muviapp.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.muviteam.muviapp.R;
import com.muviteam.muviapp.model.Famoso;
import com.muviteam.muviapp.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolbarFragment extends Fragment implements FragmentHome.ListenerDeFragment{

    ViewPager myViewPager;
    AdapterViewPagerToolBar myAdapter;
    TabLayout myTabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        encotrarVariablesId(view);

        myAdapter = new AdapterViewPagerToolBar(getActivity().getSupportFragmentManager());

        myViewPager.setAdapter(myAdapter);
        myTabLayout.setupWithViewPager(myViewPager);
        myViewPager.setCurrentItem(1);
        return view;
    }

    private void encotrarVariablesId(View view){
        myViewPager = view.findViewById(R.id.FragmentToolbar_ViewPager_ContenedorDeFragments);
        myTabLayout = view.findViewById(R.id.FragmentToolbar_TabLayout);
    }


    @Override
    public void recibirPelicula(final Pelicula pelicula) {
        Toast.makeText(getContext(), pelicula.getTitulo(), Toast.LENGTH_SHORT).show();
        FragmentDetallePelicula fragment_detallePelicula = new FragmentDetallePelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragment_detallePelicula.CLAVE_PELICULA, pelicula);
        fragment_detallePelicula.setArguments(bundle);
        pegarFragment(fragment_detallePelicula);
    }

    @Override
    public void recibirFamoso(Famoso famoso) {

    }

    private void pegarFragment(Fragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.MainActivity_FrameLayout_ContenedorDeFragments,fragment)
                .addToBackStack(null)
                .commit();
    }
}
