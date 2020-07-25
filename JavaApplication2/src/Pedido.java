import java.util.*;
/**
 * Write a description of class as here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido{
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
}