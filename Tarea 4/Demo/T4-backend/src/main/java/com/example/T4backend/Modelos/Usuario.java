package com.example.T4backend.Modelos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Usuario")
public class Usuario implements Serializable {
    @Id
    @NotNull
    private String id;

    private String contrasena;

    private String correo;

    private String nombre;

    //Metodos 

    public  Usuario(String nombre,String correo){
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

    void modificarUsuario(String contrasena, String correo, String nombre,
                            String id)
    {

    }

    boolean validarRol(String usuario, String contrasena)
    {
        return true;
    }

    boolean validarUsuario(String usuario, String contrasena)
    {
       return true;
    }

    void descargarPropuesta(String URL)
    {

    }

}