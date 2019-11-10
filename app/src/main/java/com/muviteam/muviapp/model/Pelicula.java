package com.muviteam.muviapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pelicula implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("title")
    private String titulo;
    private Integer id;
    private String director;
    @SerializedName("release_date")
    private String fechaDeEstreno;
    @SerializedName("poster_path")
    private String imagenurl;
    @SerializedName("backdrop_path")
    private String imagenurlcelda;
    @SerializedName("overview")
    private String sinopsis;
    private Double popularity;

    public Double getPopularity() {
        return popularity;
    }

    public Pelicula(String titulo, String imagenurl, String imagenurlcelda) {
        this.titulo = titulo;
        this.id = id;
        this.director = director;
        this.fechaDeEstreno = fechaDeEstreno;
        this.imagenurl = imagenurl;
        this.imagenurlcelda = imagenurlcelda;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public void setFechaDeEstreno(String fechaDeEstreno) {
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        sinopsis = sinopsis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String generaURLImagen(){
        return BASE_URL + imagenurl;
    }

    public String generaURLImagencelda(){
        return BASE_URL + imagenurlcelda;
    }

    public String getImagenurlcelda() {
        return imagenurlcelda;
    }

    public void setImagenurlcelda(String imagenurlcelda) {
        this.imagenurlcelda = imagenurlcelda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id.equals(pelicula.id);
    }

}
