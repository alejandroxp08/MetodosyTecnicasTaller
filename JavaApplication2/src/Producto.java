
import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID= 1L;
    private int prioridad;
    private double precio;
    private String fabricante;
    private String nombre;
    private int codigo; 
    public Producto(){}

    public Producto(String nombre, String fabricante, double precio, int prioridad, int codigo) {
        this.nombre = nombre;
        this.fabricante=fabricante;
        this.precio=precio;
        this.prioridad=prioridad;
        this.codigo=codigo;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getNom(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public int getPrioridad(){
        return prioridad;
    }
}