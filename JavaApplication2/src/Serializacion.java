import java.io.*;

public class Serializacion {

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

    public void abrirsalida() 
    throws IOException {
        archivosalida = new FileOutputStream("productos2.txt");
        salida = new ObjectOutputStream(archivosalida);
    }

    public void abrirentrada() throws IOException {
        archivoentrada = new FileInputStream("productos2.txt");
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

    public void insertarBD()throws IOException{
        try {

            Producto dato = new Producto("cafe","nescafe",20,3,generarcodigo());
            Producto dato1 = new Producto("Doritos","frito-lay",10,3,generarcodigo());
            Producto dato2 = new Producto("helado","delicia",15,1,generarcodigo());
            Producto dato3 = new Producto("labandina","cloro",10,3,generarcodigo());
            Producto dato4 = new Producto("pan","panaderia",0.50,2,generarcodigo());
            Producto dato5 = new Producto("lecheNatural","pil",5,1,generarcodigo());
            Producto dato6= new Producto("galletas","Salvado",20,3,generarcodigo());
            Producto dato7 = new Producto("aspirima","vita",1,1,generarcodigo());
            abrirsalida();
            escribir(dato);
            escribir(dato1);
            escribir(dato2);
            escribir(dato3);
            escribir(dato4);
            escribir(dato5);
            escribir(dato6);
            escribir(dato7);
            cerrarsalida();

        } catch (IOException e) {

        }
    }
  
    public int generarcodigo(){ 
        int numero = (int) (Math.random() * 12365) + 1;
        return numero;
    }
}