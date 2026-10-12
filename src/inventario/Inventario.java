
package inventario;
import Modelo.*;
import java.time.LocalDate;
/**
 *
 * @author poo115
 */
public class Inventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Producto p1= new Producto("POO1", "Producto 1", 4.00, 100);
            Producto p2= new Producto("POO2", "Producto 2", 3.50, 220);
            
            //ingresar
            Ingreso ingreso = new Ingreso(LocalDate.now(), 1001, "Fitin 67");
            ingreso.agregarDetalle(new DetalleMovimiento(p1,50,3.25));
            ingreso.agregarDetalle(new DetalleMovimiento(p2,70,4.25));
            ingreso.aplicar();
            
            //Salida
            Salida salida = new Salida(LocalDate.now(), 2001, "Juan Pérez");
            salida.agregarDetalle(new DetalleMovimiento(p1, 35, p1.getPrecioUnitario()));
            salida.aplicar();

           System.out.println("=== Después de la SALIDA ===");
           p1.imprimir();
            
        } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
        }
    }
    
}
