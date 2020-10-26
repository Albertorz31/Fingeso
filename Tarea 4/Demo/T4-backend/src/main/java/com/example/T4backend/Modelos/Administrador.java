package com.example.T4backend.Modelos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

//Documentos son iguales a los registros de SQL estos pertenecen a una coleccion que son iguales a las tablas en SQL
//Los documentos son una descripcion de una entidad
@Document(collection = "Administrador")
public class Administrador implements Serializable {
    @Id
    @NotNull
    private String id;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Size(max= 200)
    private String correo;

    private String telefono;
    private String celular;
    private String facebook;
    private  String linkedIn;

    //Representa una instancia de tiempo, con milisegundos de precision
    private Date date = new Date();

    public Administrador(){
        super();
    }

    public  Administrador(String nombre,String correo){
        this.nombre=nombre;
        this.correo=correo;
    }

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public Date getDate() {
        return date;
    }
}
