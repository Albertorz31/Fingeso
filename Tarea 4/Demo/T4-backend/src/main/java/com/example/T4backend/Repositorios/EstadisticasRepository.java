package com.example.T4backend.Repositorios;

import com.example.T4backend.Modelos.Estadisticas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface EstadisticasRepository extends MongoRepository<Estadisticas, Long >{
	public Estadisticas findById(String id);
}