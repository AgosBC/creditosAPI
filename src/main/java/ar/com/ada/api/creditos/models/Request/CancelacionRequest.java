package ar.com.ada.api.creditos.models.Request;

import java.math.BigDecimal;
import java.util.Date;

public class CancelacionRequest {

    public Integer prestamoId;

    public BigDecimal importe;

    public int numeroCuota;

    public Date fechaCancelacion;
    
}
