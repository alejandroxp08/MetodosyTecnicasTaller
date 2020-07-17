import java.io.*;
import java.io.*;
/**
 * Write a description of class Serializacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Serializacion{

    private FileOutputStream  archivosalida;
    private FileInputStream  archivoentrada;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public Producto leer() throws IOException, ClassNotFoundException {
        Producto d=null;

        if (entrada!=null) {
            // Lee y convierte al formato requerido
            d = (Producto) entrada.readObject();
        }
        return d;
    }

    public void abrirsalida() throws IOException {
        archivosalida = new FileOutputStream("productos.txt");
        salida = new ObjectOutputStream(archivosalida);
    }

    public void abrirentrada() throws IOException {
        archivoentrada = new FileInputStream("productos.txt");
        entrada = new ObjectInputStream(archivoentrada);
    }

    public void cerrarsalida() throws IOException {
        if (salida!=null) salida.close();
    }

    public void cerrarentrada() throws IOException {
        if (entrada!=null) entrada.close();
    }

    public void escribir (Producto d) throws IOException {
        if (salida!=null) salida.writeObject(d);
    }

    public void insertarBD(Producto dato)throws IOException{
        abrirsalida();
        escribir(dato);
        cerrarsalida();
    }
}
