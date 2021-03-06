package ar.com.ada.api.creditos.entities;


import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    private BigDecimal importe;
    private int cuotas;

    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    @Column(name = "fecha_alta")
    private Date fechaAlta; 

    @Column(name = "estado_id")
    private int estadoId;

    @ManyToOne // este tiene una relacion many to one (muchos prestamos a un cliente) 
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id") // es un join columns va donde va la FK
    Cliente cliente;


    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cancelacion> cancelaciones = new ArrayList<>();

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.agregarPrestamo(this);
    }

    public EstadoPrestamoEnum getEstadoId(){

        return EstadoPrestamoEnum.parse(this.estadoId);
    }

    public void setEstadoId(EstadoPrestamoEnum estadoId) {
        this.estadoId = estadoId.getValue();
    }

    public void agregarCancelacion(Cancelacion cancelacion) {
        this.cancelaciones.add(cancelacion);
    }   

    public enum EstadoPrestamoEnum{

        SOLICITADO(1),
        RECHAZADO(2),
        PENDIENTE_APROBACION(3),
        APROBADO(4),
        INCOBRABLE(5),
        CANCELADO(6),
        PREAPROBADO(7);

        private final int value;

        
        private EstadoPrestamoEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static EstadoPrestamoEnum parse(int id) {
            EstadoPrestamoEnum status = null; 
            for (EstadoPrestamoEnum item : EstadoPrestamoEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }

    }

    
    
}
