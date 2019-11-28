package com.muviteam.muviapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Famoso implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("name")
    private String StringNombre;
    @SerializedName("biography")
    private String biografia;
    @SerializedName("profile_path")
    private String StringImagenDeFamoso;
    @SerializedName("id")
    private Integer StringId;

    public Famoso(String nombre, String biografia, String imagenDeFamoso, Integer id){
        this.StringNombre = nombre;
        this.biografia = biografia;
        this.StringImagenDeFamoso = imagenDeFamoso;
        this.StringId = id;
    }

    public Famoso(){

    }

    public Integer getId() {
        return StringId;
    }

    public String getNombre() {
        return StringNombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public String generaURLImagen(){
        return BASE_URL + StringImagenDeFamoso;
    }
}
