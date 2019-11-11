package com.muviteam.muviapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Famoso implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("name")
    private String StringNombre;
    @SerializedName("popularity")
    private String StringNacimiento;
    @SerializedName("profile_path")
    private String StringImagenDeFamoso;
    private Integer IntegerCast_id;
    private Integer StringId;

    public Famoso(String nombre, String nacimiento, String imagenDeFamoso, Integer id){
        this.StringNombre = nombre;
        this.StringNacimiento = nacimiento;
        this.StringImagenDeFamoso = imagenDeFamoso;
        this.StringId = id;
    }

    public Famoso() {

    }

    public Integer getCast_id() {return IntegerCast_id; }

    public void setNacimiento(String nacimiento) {
        this.StringNacimiento = nacimiento;
    }

    public Integer getId() {
        return StringId;
    }

    public String getNombre() {
        return StringNombre;
    }

    public void setNombre(String nombre) {
        this.StringNombre = nombre;
    }

    public void setImagenDeFamoso(String imagenDeFamoso) {
        this.StringImagenDeFamoso = imagenDeFamoso;
    }

    public String getNacimiento() {
        return StringNacimiento;
    }


    public String getImagenDePelicula() {
        return StringImagenDeFamoso;
    }

    public String generaURLImagen(){
        return BASE_URL + StringImagenDeFamoso;
    }
}
