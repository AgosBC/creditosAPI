package ar.com.ada.api.creditos.entities;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.*;

import org.hibernate.annotations.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id 
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clienteId;

    private String nombre; 

    @NaturalId
    private int dni;

    private String direccion;

    
    @Column(name = "direccion_alternativa")
    private String direccionAlt;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Prestamo> prestamos = new ArrayList<>();

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionAlt() {
        return direccionAlt;
    }

    public void setDireccionAlt(String direccionAlt) {
        this.direccionAlt = direccionAlt;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }


    
}
