package com.example.T4backend.Modelos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Document(collection = "Cliente")
public class Cliente implements Serializable {
    @Id
    @NotNull
    private String id;

    //Esta podria ser el nombre de la persona o empresa
    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Size(max= 200)
    private String correo;

    @NotBlank
    @Size(max= 20)
    private String rut;

    private String telefono;
    private  String direccion;

    private Date date = new Date();

    //Constructor
    //Se ingresa los datos mas importantes del cliente
    public Cliente(String nombre,String correo, String telefono,String direccion){
        this.nombre=nombre;
        this.correo=correo;
        this.telefono=telefono;
        this.direccion=direccion;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public Date getDate() {
        return date;
    }

    void modificarCliente(String id, String nombre, String rut, String correo,
                         String telefono, String direccion)
    {

    }
}
