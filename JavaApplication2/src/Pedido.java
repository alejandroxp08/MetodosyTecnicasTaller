import java.util.ArrayList;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido{
    private String nomCliente;
    private Direccion direccion;
    private ArrayList<Solicitud> solicitudes;
    private String observaciones;
    public Pedido(){

    }
    
    public Pedido(String nc,Direccion d,String ob){
        nomCliente=nc;
        direccion=d;
        solicitudes=new ArrayList<>();
        observaciones=ob;
    }

    public void setNom(String nc){
        nomCliente=nc;
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
}
