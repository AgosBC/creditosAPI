package ar.com.ada.api.creditos.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.creditos.entities.Cliente;
import ar.com.ada.api.creditos.entities.Prestamo;
import ar.com.ada.api.creditos.entities.Prestamo.EstadoPrestamoEnum;
import ar.com.ada.api.creditos.repos.PrestamoRepository;

@Service
public class PrestamoService {

    @Autowired
    PrestamoRepository repo;

    @Autowired
    ClienteService clienteService;

    public Prestamo emitirPrestamo(Integer clienteId, BigDecimal importe, Integer cuotas, Date fechaPrestamo) {

        Cliente cliente = clienteService.buscarPorId(clienteId);

        Prestamo prestamo = new Prestamo();
        prestamo.setImporte(importe);
        prestamo.setCuotas(cuotas);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaAlta(new Date());
        prestamo.setEstadoId(EstadoPrestamoEnum.SOLICITADO);

        cliente.agregarPrestamo(prestamo);

        return repo.save(prestamo);

    }

    public Prestamo buscarPrestamoPorId(Integer prestamoId) {
        return repo.findByPrestamoId(prestamoId);
    }

    public List<Prestamo> traerPrestamos() {
        return repo.findAll();
    }

    public void actualizar(Prestamo prestamo) {

        repo.save(prestamo);
    }

}
