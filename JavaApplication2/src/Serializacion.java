import java.io.*;

public class Serializacion {

    private FileOutputStream  archivosalida;
    private FileInputStream  archivoentrada;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public Datos leer() throws IOException, ClassNotFoundException {
        Datos d=null;

        if (entrada!=null) {
            // Lee y convierte al formato requerido
            d = (Datos) entrada.readObject();
        }
        return d;
    }

    public void abrirsalida() 
    throws IOException {
        archivosalida = new FileOutputStream("productos1.txt");
        salida = new ObjectOutputStream(archivosalida);
    }

    public void abrirentrada() throws IOException {
        archivoentrada = new FileInputStream("productos1.txt");
        entrada = new ObjectInputStream(archivoentrada);
    }

    public void cerrarsalida() throws IOException {
        if (salida!=null) salida.close();
    }

    public void cerrarentrada() throws IOException {
        if (entrada!=null) entrada.close();
    }

    public void escribir (Datos d) throws IOException {
        if (salida!=null) salida.writeObject(d);
    }

    public void insertarBD(Datos dato)throws IOException{
        abrirsalida();
        escribir(dato);
        cerrarsalida();
       

    }

    public int generarcodigo(){ 

     
        int numero = (int) (Math.random() * 12365) + 1;
         return numero;
    }
}