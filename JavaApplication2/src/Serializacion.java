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
    //no ejecutar de nuevo este main
    public static void main (String[] args) {
    	Serializacion ser= new Serializacion();
    	try {
           //Permite escribir información en el archivo
           Producto dato = new Producto("cafe","nescafe",20,3,"00000");
           Producto dato1 = new Producto("Doritos","frito-lay",10,3,"00001");
           Producto dato2 = new Producto("helado","delicia",15,1,"00002");
           Producto dato3 = new Producto("labandina","clorox",10,3,"00003");
           Producto dato4 = new Producto("pan","panaderia",0.50,2,"00004");
           Producto dato5 = new Producto("lecheNatural","pil",5,1,"00005");
           Producto dato6= new Producto("galletas","Salvado",20,3,"00006");
           Producto dato7 = new Producto("aspirima","vita",1,1,"000007");
           ser.abrirsalida();
           ser.escribir(dato);
           ser.escribir(dato1);
           ser.cerrarsalida();
           System.out.println("Dos registros escritos en la BD\n");
        
           // Leer los registros del Archivo
           ser.abrirentrada();
           Producto d;
           ser.cerrarentrada();
    	} catch (IOException e) {
    	}
    }
}
