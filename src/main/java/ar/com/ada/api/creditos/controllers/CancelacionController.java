package ar.com.ada.api.creditos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.creditos.entities.Cancelacion;
import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.models.Request.CancelacionRequest;
import ar.com.ada.api.creditos.models.response.GenericResponse;
import ar.com.ada.api.creditos.services.CancelacionService;
import ar.com.ada.api.creditos.services.PrestamoService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CancelacionController {
    @Autowired
    CancelacionService service;

    @Autowired
    PrestamoService prestamoService;

    @PostMapping("/cancelaciones")
    public ResponseEntity<?> crear(@RequestBody CancelacionRequest request) {

        GenericResponse respuesta = new GenericResponse();
        Cancelacion cancelacion = new Cancelacion(request.importe, request.numeroCuota, request.fechaCancelacion);
        Prestamo prestamo = prestamoService.buscarPrestamoPorId(request.prestamoId);
        cancelacion.setPrestamo(prestamo);

        service.crear(cancelacion);
        respuesta.isOk = true;
        respuesta.id = cancelacion.getCancelacionId();
        respuesta.mensaje = "La cancelación ha sido creada con éxito";

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/cancelaciones")
    public ResponseEntity<List<Cancelacion>> traerTodasLasCancelaciones() {
        return ResponseEntity.ok(service.traerTodasLasCancelaciones());

    }
    
}
