package ar.com.ada.api.creditos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.repos.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repo;

    public void grabar(Cliente cliente) {
        
        repo.save(cliente);
    
    }

    public Cliente buscarPorId(Integer id){
       return repo.findByClienteId(id);
    }
    
    public List<Cliente> traerTodos() {
        return repo.findAll();
     }
}
