
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author poo115
 */
public class Salida extends Movimiento {

    public int getNumRequisicion() {
        return numRequisicion;
    }

    public void setNumRequisicion(int numRequisicion) {
        this.numRequisicion = numRequisicion;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
     private int numRequisicion;
    private String solicitante;

    public Salida(LocalDate fecha, int numRequisicion, String solicitante) {
        super(fecha, TipoMovimiento.SALIDA);
        if (numRequisicion <= 0) {
            throw new IllegalArgumentException("El número de requisición debe ser mayor que 0");
        }
        if (solicitante == null || solicitante.isBlank()) {
            throw new IllegalArgumentException("El solicitante es obligatorio");
        }
        this.numRequisicion = numRequisicion;
        this.solicitante = solicitante;
    }

   
}

