import java.io.*;
import java.util.*;
public class Principal {
    public static ArrayList<Datos> main (String[] args) {
        Serializacion ser= new Serializacion();
        ArrayList<Datos> datos=new ArrayList<>();
        try {
            //Permite escribir información en el archivo
            Datos dato = new Datos("cafe","nescafe",20,3,ser.generarcodigo());
            Datos dato1 = new Datos("Doritos","frito-lay",10,3,ser.generarcodigo());
            Datos dato2 = new Datos("helado","delicia",15,1,ser.generarcodigo());
            Datos dato3 = new Datos("labandina","cloro",10,3,ser.generarcodigo());
            Datos dato4 = new Datos("pan","panaderia",0.50,2,ser.generarcodigo());
            Datos dato5 = new Datos("lecheNatural","pil",5,1,ser.generarcodigo());
            Datos dato6= new Datos("galletas","Salvado",20,3,ser.generarcodigo());
            Datos dato7 = new Datos("aspirima","vita",1,1,ser.generarcodigo());
            ser.abrirsalida();
            ser.escribir(dato);
            ser.escribir(dato1);
            ser.escribir(dato2);
            ser.escribir(dato3);
            ser.escribir(dato4);
            ser.escribir(dato5);
            ser.escribir(dato6);
            ser.escribir(dato7);
            ser.cerrarsalida();
            // System.out.println("Dos registros escritos en la BD\n");

            // Leer los registros del Archivo
            ser.abrirentrada();
            Datos d;
            do {
                d = ser.leer();
                datos.add(d);
                System.out.println("Dato Leido: ");
                System.out.println(d.nombre+"\n");

            } while(d!=null);
            ser.cerrarentrada();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return datos;
    }
}