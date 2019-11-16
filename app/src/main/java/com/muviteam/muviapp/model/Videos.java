package com.muviteam.muviapp.model;

import java.util.List;

public class Videos {

    private Integer id;
    private List<Pelicula> results;

    public Videos() {
        super();
        this.id = id;
        this.results = results;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Pelicula> getResults() {
        return results;
    }

    public void setResults(List<Pelicula> results) {
        this.results = results;
    }
}
