package com.muviteam.muviapp.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.muviteam.muviapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar myToolbar;
    private ArrayAdapter<String> myArrayAdapterString;
    private DrawerLayout myDrawerLayout;
    private NavigationView myNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encuentroVariablesPorId();
        creoElAppBar();

        pegarFragment(new ToolbarFragment());

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

        SearchView mySearchView = (SearchView) myMenuItemSearch.getActionView();
        mySearchView.setQueryHint("Search");

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

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //menuitem es el elemento seleccionado
        Integer integerId = menuItem.getItemId();
        //uso un switch para ponerle un comportamiento distinto a cada boton
        switch (integerId) {
            case R.id.MenuPrincipal_Item_Perfil:
                Toast.makeText(this, "Entrado al perfil del usuario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuPrincipal_Item_Configuracion:
                Toast.makeText(this, "Entrando a configuracion", Toast.LENGTH_SHORT).show();
                break;
            case R.id.MenuPrincipal_Item_CerrarSesion:
                Toast.makeText(this, "Hasta Luego (Cerrar sesion)", Toast.LENGTH_SHORT).show();
                break;
        }
        myDrawerLayout.closeDrawers();
        return true;
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.MainActivity_FrameLayout_ContenedorDeFragments,fragment)
                .addToBackStack(null)
                .commit();
    }
}
