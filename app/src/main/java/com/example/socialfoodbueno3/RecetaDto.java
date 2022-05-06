package com.example.socialfoodbueno3;

import org.json.JSONException;
import org.json.JSONObject;

public class RecetaDto {

    public String titulo, descripcion, ingredientes, nacionalidad, latitud, longitud;

    public RecetaDto(String titulo, String descripcion, String ingredientes, String nacionalidad, String latitud, String longitud) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
        this.nacionalidad = nacionalidad;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public RecetaDto(JSONObject json) {
        try {
            this.titulo = json.getString("Tortilla");
            this.descripcion = json.getString("Plato típico de España.");
            this.ingredientes = json.getString("Patatas, huevos, aceite y jamón");
            this.nacionalidad = json.getString("España");
            this.latitud = json.getString("111");
            this.longitud = json.getString("222");
        } catch (JSONException error) {
            error.printStackTrace();
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
