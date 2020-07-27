import java.util.*;
import java.io.*;
/**
 * Write a description of class Solicitud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solicitud implements Serializable{
    Producto producto;
    Integer cantidadP;
    public Solicitud(){}

    public Solicitud(Producto p,Integer cant){
        producto=p;
        cantidadP=cant;
    }

    public void setProduc(Producto p){
        producto=p;
    }

    public void setCant(int cant){
        cantidadP=cant;
    }

    public Producto getProduc(){
        return producto;
    }

    public int getCant(){
        return cantidadP;
    }

    public void mostrarse(){
        System.out.println("Nombre Producto: "+producto.getNom()+" Codigo de producto: "+producto.getCodigo()+ " Cantidad: "+cantidadP);
    }

}
