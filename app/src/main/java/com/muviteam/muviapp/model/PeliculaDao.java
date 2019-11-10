package com.muviteam.muviapp.model;

import android.util.Log;

import com.muviteam.muviapp.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PeliculaDao extends PeliculaRetrofitDao {

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "41c70e6b99d8ae34c17c9c34fd81e344";

    public PeliculaDao() {
        super(BASE_URL);
    }

    public void traerPeliculas(final ResultListener<List<Pelicula>> listenerDelControler){
        Call<ContainerPelicula> call = peliculasService.traerPelicula(API_KEY);
        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }
            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {
                Log.d("ewfwq","dwsfaw");
            }
        });
    }

    public void traerUpcoming(final ResultListener<List<Pelicula>> listenerDelControler){
        Call<ContainerPelicula> call = peliculasService.traerUpcoming(API_KEY);
        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }
            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {
                Log.d("ewfwq","dwsfaw");
            }
        });
    }

    public  void traerCredits(final ResultListener<Credits> resultListenerController,Integer movieId){
        Call<Credits> creditsCall = peliculasService.traerCredits(movieId,API_KEY);
        creditsCall.enqueue(new Callback<Credits>() {
            @Override
            public void onResponse(Call<Credits> call, Response<Credits> response) {
                Credits resultsCredit = response.body();
                resultListenerController.finish(resultsCredit);
            }
            @Override
            public void onFailure(Call<Credits> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void traerListaDeViewPager(final ResultListener<List<Pelicula>> listenerDelControler){
        Call<ContainerPelicula> call = peliculasService.traerPeliculaViewPager(API_KEY);
        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }
            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {
                Log.d("ewfwq","dwsfaw");
            }
        });
    }

    public void traerPopulares(final ResultListener<List<Pelicula>> listenerDelControler){
        Call<ContainerPelicula> call = peliculasService.traerPeliculasPopulares(API_KEY);
        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }
            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {
                Log.d("ewfwq","dwsfaw");
            }
        });
    }
}
