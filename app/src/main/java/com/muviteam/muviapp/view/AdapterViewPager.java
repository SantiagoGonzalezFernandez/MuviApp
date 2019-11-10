package com.muviteam.muviapp.view;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.List;

public class AdapterViewPager extends FragmentPagerAdapter {

    private List<Fragment> listaDeFragments;

    public List<Fragment> getListaDeFragments() {
        return listaDeFragments;
    }

    public AdapterViewPager(@NonNull FragmentManager fm, List<Fragment> fragmentAMostrar) {
        super(fm);
        listaDeFragments = fragmentAMostrar;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listaDeFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaDeFragments.size();
    }

    public void actuslizarListaFragment(List<Fragment> listaDeFragments) {
        this.listaDeFragments = listaDeFragments;
        notifyDataSetChanged();
    }

}
