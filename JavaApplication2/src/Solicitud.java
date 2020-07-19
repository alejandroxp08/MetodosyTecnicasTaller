
/**
 * Write a description of class Solicitud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solicitud{
    Producto producto;
    Integer cantidadP;
    public Solicitud(Producto p,Integer cant){
        producto=p;
        cantidadP=cant;
    }

    public void mostrarse(){
        System.out.println("Codigo de producto: "+producto.getCodigo()+ " Cantidad: "+cantidadP);
    }
}
