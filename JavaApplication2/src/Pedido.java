import java.util.*;
import java.io.*;
/**
 * Write a description of class as here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido implements Serializable{
    private String nomCliente;
    private Direccion direccion;
    private ArrayList<Solicitud> solicitudes;
    private String observaciones;
    private double precioTotal;
    public Pedido(){
        solicitudes=new ArrayList<>();

    }

    public Pedido(String nc,Direccion d,String ob){
        nomCliente=nc;
        direccion=d;
        solicitudes=new ArrayList<>();
        observaciones=ob;
        precioTotal=0;
    }

<<<<<<< HEAD
    public String getNomCliente(){
        return nomCliente;
    }

=======
>>>>>>> 43e95b28c2d4c8b58ec14fbc227d6b6c5b1c0351
    public Direccion getDireccion(){
        return direccion;
    }

<<<<<<< HEAD
    public String getObservaciones(){
        return observaciones;
    }

=======
>>>>>>> 43e95b28c2d4c8b58ec14fbc227d6b6c5b1c0351
    public void setNom(String nc){
        nomCliente=nc;
    }

    public void aumen(Solicitud s){
        solicitudes.add(s);
    }

    public void setDireccion(Direccion d){
        direccion=d;
    }

    public void setSoli(ArrayList<Solicitud> s){
        solicitudes=s;
    }

    public void setObs(String o){
        observaciones=o;
    }

    public ArrayList<Solicitud> getSoli(){
        return solicitudes;
    }

    public double precioTotal(){
        double res=0;
        for(int i=0;i<solicitudes.size();i++){
            res=res+(solicitudes.get(i).getProduc().getPrecio()*solicitudes.get(i).getCant());
        }
        return res;
    }

<<<<<<< HEAD
=======

>>>>>>> 43e95b28c2d4c8b58ec14fbc227d6b6c5b1c0351
}