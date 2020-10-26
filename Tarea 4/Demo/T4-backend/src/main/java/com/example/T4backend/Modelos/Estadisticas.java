package com.example.T4backend.Modelos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;

@Document(collection = "Estadisticas")
public class Estadisticas implements Serializable {
    @Id
    @NotNull
    private String id;

    private String fechaStar;

    private int tiempo;

    private String estado;

    private String fechaEnd;

    private ArrayList<String> fechasPagos;

    private float calificacion;

    private String notas;

    //Getters 

    public String getId() {
        return id;
    }

    public String getFechaStar() {
        return fechaStar;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getEstado() {
        return estado;
    }

    public String getFechaEnd() {
        return fechaEnd;
    }

    public ArrayList<String>  getFechasPagos() {
        return fechasPagos;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public String getNotas() {
        return notas;
    }
    

    //Métodos 

    public Estadisticas(String fechaStar,int  tiempo, String estado, float calificacion){
        this.fechaStar= fechaStar;
        this.tiempo= tiempo;
        this.estado = estado;
        this.calificacion = calificacion;
    }
}