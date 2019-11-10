package com.muviteam.muviapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Famoso implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("name")
    private String nombre;
    @SerializedName("popularity")
    private String nacimiento;
    @SerializedName("profile_path")
    private String imagenDeFamoso;
    private Integer cast_id;
    private Integer id;

    public Famoso(String nombre, String nacimiento, String imagenDeFamoso, Integer id){
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.imagenDeFamoso = imagenDeFamoso;
        this.id = id;
    }

    public Famoso() {

    }

    public Integer getCast_id() {return cast_id; }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagenDeFamoso(String imagenDeFamoso) {
        this.imagenDeFamoso = imagenDeFamoso;
    }

    public String getNacimiento() {
        return nacimiento;
    }


    public String getImagenDePelicula() {
        return imagenDeFamoso;
    }

    public String generaURLImagen(){
        return BASE_URL + imagenDeFamoso;
    }
}
