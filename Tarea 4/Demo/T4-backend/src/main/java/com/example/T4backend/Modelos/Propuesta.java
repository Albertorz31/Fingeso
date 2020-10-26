package com.example.T4backend.Modelos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Propuesta")
public class Propuesta implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotBlank
    @Size(max=100)
    private String titulo;

    @NotBlank
    @Size(max = 1000)
    private String descripcion;

    private String clienteAsignado;

    private String propuestaTecnica;

    private String propuestaEconomica;

    private Estadisticas stats;

    // Representa una instancia de tiempo, con milisegundos de precision
    private Date date = new Date();

    // Contructor
    // La propuesta es que cuando se cree un nuevo objeto propuesta, ya se ingrese
    // un titulo
    // una descripcion y quien la subió
    public Propuesta(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getDate() {
        return date;
    }

}
