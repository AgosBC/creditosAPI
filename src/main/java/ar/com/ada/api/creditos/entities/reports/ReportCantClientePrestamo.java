package ar.com.ada.api.creditos.entities.reports;

import javax.persistence.*;

@Entity
public class ReportCantClientePrestamo {

    @Id
    @Column(name="cant_clientes")
    public int cantClientes;

    @Column(name="cant_prestamos")
    public int cantPrestamos;

    
    
}
