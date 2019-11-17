package com.muviteam.muviapp.model;

import java.util.ArrayList;
import java.util.List;

public class Videos {

        private String id;
        private List<Pelicula> results;


    public Videos() {
    }

    public Videos(String id, List<Pelicula> results) {
        this.id = id;
        this.results = results;
    }

    public String getId() {
        return id;
    }


    public List<Pelicula> getResults() {
        return results;
    }
}
