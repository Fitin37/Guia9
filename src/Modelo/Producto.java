
package Modelo;

/**
 *
 * @author poo115
 */
public class Producto {

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
     private String codigo;
    private String nombre;
    private double precioUnitario;
    private int existencia;
    
    
    //validaciones 
    public Producto(String codigo,String nombre,double precioUnitario,int existencia){
    if(codigo == null || codigo.isBlank()){
    throw  new IllegalArgumentException("EL codigo del producto es obligatorio");
    }
    if(nombre == null || nombre.isBlank()){
    throw new IllegalArgumentException("El nombre del prodcuto es obligatorio");
    }
    if(precioUnitario < 0){
    throw  new IllegalArgumentException("EL precio unitario no puede ser negativo");
    }
    if(existencia < 0){
    throw new IllegalArgumentException("La existencia no puede ser negativa");
    }
    
    this.codigo= codigo;
    this.nombre = nombre;
    this.precioUnitario = precioUnitario;
    this.existencia = existencia;
    }
    
    public void imprimir(){
 System.out.println("Código: " + codigo);
  System.out.println("Nombre: " + nombre);
   System.out.println("Existencia: " + existencia);
    System.out.println("Precio Unitario: " + precioUnitario);
}
}



