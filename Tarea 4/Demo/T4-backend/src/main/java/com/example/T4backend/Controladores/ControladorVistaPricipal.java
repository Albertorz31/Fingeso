package com.example.T4backend.Controladores;

import com.example.T4backend.Modelos.Cliente;
import com.example.T4backend.Modelos.Estadisticas;
import com.example.T4backend.Modelos.Propuesta;
import com.example.T4backend.Modelos.Usuario;
import com.example.T4backend.Repositorios.ClienteRepository;
import com.example.T4backend.Repositorios.EstadisticasRepository;
import com.example.T4backend.Repositorios.PropuestaRepository;
import com.example.T4backend.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorVistaPricipal {

    @Autowired
    PropuestaRepository propuestaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EstadisticasRepository estadisticasRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    //Post se usa para agregar nueva propuesta a la BD a traves del repository
    @PostMapping("/propuestas")
    public Propuesta publicarPropuesta(@Valid @RequestBody Propuesta propuesta){
        Propuesta nuevaPropuesta = new Propuesta(propuesta.getTitulo(),propuesta.getDescripcion());
        return propuestaRepository.save(nuevaPropuesta);
    };

    @GetMapping("/propuestas")
    public List<Propuesta> listarPropuestas(){
        List<Propuesta> propuestas = new ArrayList<>();
        Sort ordenPorFecha = new Sort(Sort.Direction.ASC,"date");
        propuestaRepository.findAll(ordenPorFecha).forEach(propuestas::add);
        return  propuestas;
    };

    @GetMapping("/propuesta/{id}")
    public Propuesta obtenerPropuesta(@PathVariable String id){
        return propuestaRepository.findById(id);
    }

    @DeleteMapping("/propuesta/{id}")
    public void deleteCustomer(@PathVariable("id") String id) {
        propuestaRepository.deleteById(id);
        return;
    }

    @PostMapping("/clientes")
    public Cliente publicarCliente(@Valid @RequestBody Cliente cliente){
        Cliente nuevoCliente = new Cliente(cliente.getNombre(), cliente.getCorreo(), cliente.getTelefono(), cliente.getDireccion());
        return clienteRepository.save(nuevoCliente);
    }

    @GetMapping("/clientes")
    public  List<Cliente>  listarClientes(){
        Sort ordenPorFecha = new Sort(Sort.Direction.ASC,"date");
        return  clienteRepository.findAll(ordenPorFecha);
    }

    @GetMapping("/cliente/{id}")
    public Cliente obtenerCliente(@PathVariable String id){
        return clienteRepository.findById(id);
    }

    @GetMapping("/propuesta/{id}/estadisticas")
    public Estadisticas obtenerEstadisticas(@PathVariable String id){
        return estadisticasRepository.findById(id);
    }

    @PostMapping("/propuesta/{id}/estadisticas")
    public Estadisticas publicarEstadisticas(@Valid @RequestBody Estadisticas est){
        Estadisticas nuevaEstadistica = new Estadisticas( est.getFechaStar(), est.getTiempo(), est.getEstado(), est.getCalificacion());
        return estadisticasRepository.save(nuevaEstadistica);
    }

    @PostMapping("/usuarios")
    public Usuario publicarUsuario(@Valid @RequestBody Usuario usuario){
        Usuario nuevoUsuario = new Usuario(usuario.getNombre(),usuario.getCorreo());
        return usuarioRepository.save(nuevoUsuario);
    };

    @GetMapping("/usuarios")
    public  List<Usuario>  listarUsuarios(){
        Sort ordenPorFecha = new Sort(Sort.Direction.ASC,"date");
        return  usuarioRepository.findAll(ordenPorFecha);
    }
}
