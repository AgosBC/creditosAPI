package ar.com.ada.api.creditos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    ClienteService service;
    @PostMapping
    public ResponseEntity<GenericResponse> crearCliente(@RequestBody Cliente cliente){

        GenericResponse r = new GenericResponse();

        service.grabar(cliente);

        r.isOk = true;
        r.id = cliente.getClienteId();
        r.mensaje = "el cliente fue creado con exito";


        return ResponseEntity.ok(r);

        

    }
    
}
