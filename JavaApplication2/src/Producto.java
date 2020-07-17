
/**
 * Write a description of class Producto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Producto{
    private String nombre;
    private double precio;
    private int prioridad;
    private String fabricante;
    public Producto(String n,String f,double p,int pr){
        nombre=n;
        precio=p;
        prioridad=pr;
        fabricante=f;
    }

    public String getNom(){
        return nombre;
    }


}
