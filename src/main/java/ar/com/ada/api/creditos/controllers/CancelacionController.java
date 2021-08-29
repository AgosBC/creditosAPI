package ar.com.ada.api.creditos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.creditos.entities.Cancelacion;
import ar.com.ada.api.creditos.models.Request.CancelacionRequest;
import ar.com.ada.api.creditos.services.CancelacionService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CancelacionController {
    @Autowired
    CancelacionService service;

    @PostMapping(value="/cancelaciones")
    public ResponseEntity<?> cancelarCuota(@RequestBody CancelacionRequest request) {

        Cancelacion cuota = service.cancelarCuota(request.prestamoId, request.importe, request.fechaCancelacion);

    }
    
    
}
