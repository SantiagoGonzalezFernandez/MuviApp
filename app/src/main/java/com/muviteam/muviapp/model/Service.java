package com.muviteam.muviapp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/top_rated")
    Call<ContainerPelicula> traerPelicula(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}/credits")
    Call<Credits> traerCredits(@Path("movie_id") Integer movieId, @Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<ContainerPelicula> traerUpcoming(@Query("api_key") String apiKey);

    @GET("person/popular")
    Call<ContainerFamoso> traerPersona(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<ContainerPelicula> traerPeliculaViewPager(@Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<ContainerPelicula> traerPeliculasPopulares(@Query("api_key") String apiKey);
}
