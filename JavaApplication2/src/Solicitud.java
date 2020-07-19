
/**
 * Write a description of class Solicitud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solicitud{
    Datos producto;
    Integer cantidadP;
    public Solicitud(Datos p,Integer cant){
        producto=p;
        cantidadP=cant;
    }

    public void mostrarse(){
        System.out.println("Codigo de producto: "+producto.getCodigo()+ " Cantidad: "+cantidadP);
    }
}
