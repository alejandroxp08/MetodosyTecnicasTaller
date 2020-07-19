
import java.io.Serializable;

public class Datos implements Serializable {
    int prioridad;
    double precio;
    String fabricante;
    String nombre;
    int codigo;

    public Datos(String nombre, String fabricante, double precio, int prioridad, int codigo) {
        this.nombre = nombre;
        this.fabricante=fabricante;
        this.precio=precio;
        this.prioridad=prioridad;
        this.codigo=codigo;
    }

    public int getCodigo(){
        return codigo;
    }
}