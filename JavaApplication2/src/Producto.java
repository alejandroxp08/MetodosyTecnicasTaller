
import java.io.*;

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

    public String getFabricante(){
        return fabricante;
    }

    public static String nombreFabricante(String producto) throws IOException{
        String res="";
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("productos2.txt"));
        try {
            Producto d;
            int cant=0;
            do{
                d = (Producto)ser.readObject();
                if(d.getNom().equals(producto)){
                    res=d.getFabricante();
                }
            } while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return res;
    }
}