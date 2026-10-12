
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author poo115
 */
public class Movimiento {

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public boolean isAplicado() {
        return aplicado;
    }

    public void setAplicado(boolean aplicado) {
        this.aplicado = aplicado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<DetalleMovimiento> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleMovimiento> detalles) {
        this.detalles = detalles;
    }
      private LocalDate fecha;
    private TipoMovimiento tipo;
    private boolean aplicado = false;
    private double total;
    private List<DetalleMovimiento> detalles = new ArrayList<>();
    
    
        public Movimiento(LocalDate fecha, TipoMovimiento tipo) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha es obligatoria");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de movimiento es obligatorio");
        }
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public void agregarDetalle(DetalleMovimiento detalle) {
        if (detalle == null) {
            throw new IllegalArgumentException("El detalle no puede ser nulo");
        }
        detalles.add(detalle);
    }
    
    
        public void aplicar() {
        if (detalles.isEmpty()) {
            throw new IllegalStateException("El movimiento debe tener al menos un detalle");
        }

        // 1) Validar TODAS las precondiciones antes de cambiar nada
        for (DetalleMovimiento d : detalles) {
            if (d.getCantidad() <= 0) {
                throw new IllegalStateException("La cantidad del detalle debe ser mayor que 0");
            }
            if (tipo == TipoMovimiento.INGRESO && d.getPrecioUnitario() <= 0) {
                throw new IllegalStateException("En un ingreso el precio unitario debe ser mayor que 0");
            }
            if (tipo == TipoMovimiento.SALIDA && d.getCantidad() > d.getProducto().getExistencia()) {
                throw new IllegalStateException("La cantidad supera la existencia de "
                        + d.getProducto().getNombre());
            }
        }

        // 2) Aplicar los cambios
        total = 0;
        for (DetalleMovimiento d : detalles) {
            Producto p = d.getProducto();
            if (tipo == TipoMovimiento.INGRESO) {
                p.setExistencia(p.getExistencia() + d.getCantidad());
            } else {
                p.setExistencia(p.getExistencia() - d.getCantidad());
            }
            total += d.getCantidad() * d.getPrecioUnitario();
        }
        aplicado = true;
    }
}
