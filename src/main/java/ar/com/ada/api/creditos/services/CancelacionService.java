package ar.com.ada.api.creditos.services;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cancelacion;
import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.entities.Prestamo;
@Service
public class CancelacionService {

    @Autowired
    ClienteService clienteService;

    public Cancelacion cancelarCuota(Integer prestamoId, BigDecimal importe, Date fechaCancelacion) {
        
        
        
        
        //List<Prestamo> prestamos = cliente.getPrestamos();

        return Cancelacion;

       
    }
    
}
