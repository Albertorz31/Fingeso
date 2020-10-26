package com.example.T4backend.Repositorios;

import com.example.T4backend.Modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.Serializable;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UsuarioRepository extends MongoRepository<Usuario, Serializable> {
    public Usuario findById(String id);
}
