
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
    private String codigo;
    public Producto(String n,String f,double p,int pr,String codigo){
        nombre=n;
        precio=p;
        prioridad=pr;
        fabricante=f;
        this.codigo=codigo;
    }

    public String getNom(){
        return nombre;
    }

    public String getCodigo(){
        return codigo;
    }
}
