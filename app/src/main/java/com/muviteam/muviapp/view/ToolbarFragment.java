package com.muviteam.muviapp.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.muviteam.muviapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToolbarFragment extends Fragment {

    private TabLayout myTabLayout;
    private ViewPager myViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        encuentroVariablesId(view);

        configuroYAgregoElToolbar();

        return view;
    }


    private void encuentroVariablesId(View view){
        myTabLayout = view.findViewById(R.id.FragmentToolbar_TabLayout);
        myViewPager = view.findViewById(R.id.FragmentToolbar_ViewPager_ContenedorDeFragments);
    }

    private void configuroYAgregoElToolbar(){
        myTabLayout.setupWithViewPager(myViewPager);

        myTabLayout.getTabAt(0).setIcon(R.drawable.ic_star_black_24dp);
        myTabLayout.getTabAt(1).setIcon(R.drawable.ic_star_black_24dp);
    }

}
