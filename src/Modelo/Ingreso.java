
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author poo115
 */
public class Ingreso extends Movimiento {

    public int getNumOrdenCompra() {
        return numOrdenCompra;
    }

    public void setNumOrdenCompra(int numOrdenCompra) {
        this.numOrdenCompra = numOrdenCompra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
      private int numOrdenCompra;
    private String proveedor;

    public Ingreso(LocalDate fecha, int numOrdenCompra, String proveedor) {
        super(fecha, TipoMovimiento.INGRESO);
        if (numOrdenCompra <= 0) {
            throw new IllegalArgumentException("El número de orden de compra debe ser mayor que 0");
        }
        if (proveedor == null || proveedor.isBlank()) {
            throw new IllegalArgumentException("El proveedor es obligatorio");
        }
        this.numOrdenCompra = numOrdenCompra;
        this.proveedor = proveedor;
    }
    
        @Override
    public void aplicar() {
        super.aplicar();   // existencia, total y aplicado=true (lo hace el padre)

        for (DetalleMovimiento d : getDetalles()) {
            Producto p = d.getProducto();
            double nuevoPrecio = (p.getPrecioUnitario() + d.getPrecioUnitario()) / 2;
            p.setPrecioUnitario(nuevoPrecio);
        }
    }
}
