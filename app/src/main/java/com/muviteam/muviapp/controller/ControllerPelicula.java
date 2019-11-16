package com.muviteam.muviapp.controller;

import com.muviteam.muviapp.model.Credits;
import com.muviteam.muviapp.model.FamosoDao;
import com.muviteam.muviapp.model.Pelicula;
import com.muviteam.muviapp.model.PeliculaDao;
import com.muviteam.muviapp.model.Videos;
import com.muviteam.muviapp.utils.ResultListener;

import java.util.List;

public class ControllerPelicula {

    private PeliculaDao peliculaDAO;

    public ControllerPelicula() {
        this.peliculaDAO = new PeliculaDao();
    }

    public void traePelicula(final ResultListener<List<Pelicula>> listenerDeLaVista) {
        peliculaDAO.traerPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(final List<Pelicula> resultPelicula) {
                listenerDeLaVista.finish(resultPelicula);
            }
        });
    }

    public void traeUpcoming(final ResultListener<List<Pelicula>> listenerDeLaVista) {
        peliculaDAO.traerUpcoming(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(final List<Pelicula> resultPelicula) {
                listenerDeLaVista.finish(resultPelicula);
            }

        });
    }

    public void traePopulares(final ResultListener<List<Pelicula>> listenerDeLaVista) {
        peliculaDAO.traerPopulares(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(final List<Pelicula> resultPelicula) {
                listenerDeLaVista.finish(resultPelicula);
            }
        });
    }

    public void traeListaFamosos(Integer movieId, final ResultListener<Credits> listenerDeLaVistaFamoso) {
        final FamosoDao famososDAO = new FamosoDao();
        famososDAO.traerFamososDeLaPelicula(movieId, new ResultListener<Credits>() {
            @Override
            public void finish(Credits resultadoFamoso) {
                listenerDeLaVistaFamoso.finish(resultadoFamoso);
            }
        });
    }

    public void traerListaPeliculas(final ResultListener<List<Pelicula>> listenerDeLaVista) {
        peliculaDAO.traerListaDeViewPager(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> peliculas) {
                listenerDeLaVista.finish(peliculas);
            }
        });
    }

    public void traerCredits(final ResultListener<Credits> listenerDeLaVista,Integer movieId) {
        peliculaDAO.traerCredits(new ResultListener<Credits>() {
            @Override
            public void finish(Credits resultPelicula) {
                listenerDeLaVista.finish(resultPelicula);
            }
        }, movieId);

    }

    public void traerTrailer(final ResultListener<Videos> listenerDeLaVista, Integer movieId) {
        peliculaDAO.traerTrailer(new ResultListener<Videos>() {
            @Override
            public void finish(Videos result) {
                listenerDeLaVista.finish(result);
            }
        }, movieId);
    }

}
