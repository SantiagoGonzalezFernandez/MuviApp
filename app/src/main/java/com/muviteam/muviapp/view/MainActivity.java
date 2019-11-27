package com.muviteam.muviapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.muviteam.muviapp.R;
import com.muviteam.muviapp.model.Famoso;
import com.muviteam.muviapp.model.Pelicula;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        ,FragmentHome.ListenerDeFragment, FragmentViewPager.ListenerDeFragment,FragmentDetallePelicula.ListenerDeFragment{

    private Toolbar myToolbar;
    private ArrayAdapter<String> myArrayAdapterString;
    private DrawerLayout myDrawerLayout;
    private NavigationView myNavigationView;
    private ToolbarFragment toolbarFragment;
    private Fragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encuentroVariablesPorId();
        creoElAppBar();
        toolbarFragment = new ToolbarFragment();
        pegarFragment(toolbarFragment);

    }

    private void encuentroVariablesPorId(){
        myDrawerLayout = findViewById(R.id.MainActivity_DrawerLayout_Contenedor);
        myNavigationView = findViewById(R.id.MainActivity_NavigationView);
        myToolbar = findViewById(R.id.MainActivity_Include_Toolbar);
    }


    private void creoElAppBar(){
        setSupportActionBar(myToolbar);

        myArrayAdapterString = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.peliculas_array));

        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(this,
                        myDrawerLayout,
                        myToolbar,
                        R.string.open_drawer,
                        R.string.close_drawer);

        myDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //le seteo el on click le digo this por que la main activity implementa el listener
        myNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem myMenuItemSearch = menu.findItem(R.id.ToolBarMenu_Item_action_search);
        MenuItem myMenuItemProfile = menu.findItem(R.id.ToolBarMenu_Item_perfilUser);


        SearchView mySearchView = (SearchView) myMenuItemSearch.getActionView();
        mySearchView.setQueryHint("Busqueda por Actor o Pelicula");

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myArrayAdapterString.getFilter().filter(newText);
                return true;
            }
        });

        /*View vista = myMenuItemProfile.getActionView();

        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Acceso al Perfil del Usuario", Toast.LENGTH_LONG).show();
            }
        });*/

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Integer integerId = menuItem.getItemId();
        switch (integerId) {
            case R.id.MenuPrincipal_Item_Home:
                Toast.makeText(this, "Volviendo al Home", Toast.LENGTH_LONG).show();
                if(currentFragment != null){
                getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            }

                break;
            case R.id.MenuPrincipal_Item_Configuracion:
                Toast.makeText(this, "Entrando a configuracion", Toast.LENGTH_LONG).show();
                break;
            case R.id.MenuPrincipal_Item_CerrarSesion:
                Toast.makeText(this, "Hasta Luego (Cerrar sesion)", Toast.LENGTH_LONG).show();
                break;
        }
        myDrawerLayout.closeDrawers();
        return true;
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.MainActivity_FrameLayout_ContenedorDeFragments,fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void recibirPelicula(Pelicula pelicula) {
        Toast.makeText(this, pelicula.getTitulo(), Toast.LENGTH_SHORT).show();
        FragmentDetallePelicula fragment_detallePelicula = new FragmentDetallePelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragment_detallePelicula.CLAVE_PELICULA, pelicula);
        fragment_detallePelicula.setArguments(bundle);
        currentFragment = fragment_detallePelicula;
        pegarFragment(fragment_detallePelicula);

    }

    @Override
    public void recibirFamoso(Famoso famoso) {

    }

    public void showHideFragment(final Fragment fragment){
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.setCustomAnimations(android.R.animator.fade_in,
                android.R.animator.fade_out);
        if (fragment.isHidden()) {
            fragTransaction.show(fragment);
        } else {
            fragTransaction.hide(fragment);

        }
        fragTransaction.commit();
    }

    @Override
    public void informarFamoso(Famoso famoso) {

    }

    @Override
    public void informarPelicula(Pelicula pelicula) {
        Toast.makeText(this, pelicula.getTitulo(), Toast.LENGTH_SHORT).show();
        FragmentDetallePelicula fragment_detallePelicula = new FragmentDetallePelicula();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragment_detallePelicula.CLAVE_PELICULA, pelicula);
        fragment_detallePelicula.setArguments(bundle);
        currentFragment = fragment_detallePelicula;
        pegarFragment(fragment_detallePelicula);

    }
}
