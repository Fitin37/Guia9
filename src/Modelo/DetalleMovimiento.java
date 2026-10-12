
package Modelo;

/**
 *
 * @author poo115
 */
public class DetalleMovimiento {

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
      private Producto producto;
    private int cantidad;
    private double precioUnitario;
    
    
    public DetalleMovimiento(Producto producto, int cantidad, double precioUnitario) {
        if (producto == null) {
            throw new IllegalArgumentException("El detalle debe tener un producto");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
}

    
