package com.muviteam.muviapp.model;

import java.util.List;

public class Credits {

    private Integer id;
    private List<Famoso> cast;
    private List<Famoso> crew;

    public Credits() {
        super();
        this.id = id;
        this.cast = cast;
        this.crew = crew;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Famoso> getCast() {
        return cast;
    }
    public List<Famoso> getCrew() {return crew;}

}
