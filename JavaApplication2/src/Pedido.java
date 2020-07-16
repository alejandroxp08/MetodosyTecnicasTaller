import java.util.ArrayList;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido{
    private String nomCliente;
    Direccion direccion;
    ArrayList<Solicitud> solicitudes;
    public Pedido(String nc,Direccion d){
        nomCliente=nc;
        direccion=d;
        solicitudes=new ArrayList<>();
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
}
