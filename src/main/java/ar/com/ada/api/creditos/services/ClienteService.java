package ar.com.ada.api.creditos.services;

import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.repos.ClienteRepository;

@Service
public class ClienteService {

    ClienteRepository repo;

    public void grabar(Cliente cliente) {
        
        repo.save(cliente);
    
    }
    
}
