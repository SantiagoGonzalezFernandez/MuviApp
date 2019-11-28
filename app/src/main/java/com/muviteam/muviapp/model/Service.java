package com.muviteam.muviapp.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/top_rated")
    Call<ContainerPelicula> traerPelicula(@Query("api_key") String apiKey,
                                          @Query("language") String lenguaje);

    @GET("movie/{movie_id}/credits")
    Call<Credits> traerCredits(@Path("movie_id") Integer movieId,
                               @Query("api_key") String apiKey);

    @GET("movie/{movie_id}/videos")
    Call<Videos> traerVideos(@Path("movie_id") Integer movieId,
                             @Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<ContainerPelicula> traerUpcoming(@Query("api_key") String apiKey,
                                          @Query("language") String lenguaje);

    @GET("person/popular")
    Call<ContainerFamoso> traerPersona(@Query("api_key") String apiKey);

    @GET("discover/movie")
    Call<ContainerPelicula> traerPeliculasDeFamoso(@Query("with_people") Integer famosoId,
                                                   @Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<ContainerPelicula> traerPeliculaViewPager(@Query("api_key") String apiKey,
                                                   @Query("language") String lenguaje);

    @GET("movie/popular")
    Call<ContainerPelicula> traerPeliculasPopulares(@Query("api_key") String apiKey,
                                                    @Query("language") String lenguaje);

    @GET("movie/{movie_id}/similar")
    Call<ContainerPelicula> traerSimilares(@Path("movie_id") Integer movieId,
                                           @Query("api_key") String apiKey);

    @GET("search/movie")
    Call<ContainerPelicula> traerPeliculaPorBusqueda(@Query("movie") String movieBusqueda,
                                                     @Query("api_key") String apiKey);

}
