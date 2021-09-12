package ar.com.ada.api.creditos.excepciones;

import ar.com.ada.api.creditos.entities.Cliente;

public class ClienteEdadException extends ClienteInfoException {

    public ClienteEdadException(Cliente cliente, String mensaje) {
        super(cliente, mensaje);
    }
    
}
