import java.util.*;
import java.io.*;
/**
 * Write a description of class Traductor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Traductor{
    private String mensaje;
    private Pedido mensajeTrad;
    private String [] mensajeDividido;
    public Traductor(String mensaje){
        this.mensaje=mensaje;
        mensajeTrad=null;
        mensajeDividido=mensaje.split(" |\\,");
    }

    public void traducirMensaje(){
        mensajeTrad.setNom(devolverNombre());
        mensajeTrad.setDireccion(devolverDireccion());
        mensajeTrad.setSoli(devolverSolicitudes());
        
    }

    public String devolverNombre(){
        String res=null;
        String nom=null;
        boolean bb=true;
        int pos=0;
        for(int i=0;i<mensajeDividido.length&&bb;i++){
            String menDivi=mensajeDividido[i];
            if(menDivi.equals("nombre")){
                nom=mensajeDividido[i+2]+" ";
                bb=false;
                pos=i+2;
            }else if(menDivi.equals("llamo")){
                nom=mensajeDividido[i+1];
                bb=false;
                pos=i+1;
            }
        }
        String linea=mensajeDividido[pos+1];
        int cont=pos+1;
        while(!linea.equals(",")&&!linea.equals("mi")&&!linea.equals("y")&&!linea.equals("quiero")&&!linea.equals("vivo")&&cont+1<mensajeDividido.length-1){
            nom=nom+" "+linea;
            cont++;
            linea=mensajeDividido[cont+1];
        }
        res=nom;
        System.out.println("Nombre: "+ nom);
        return res;
    }

    public Direccion devolverDireccion(){
        Direccion res=new Direccion(null,0,0);
        String direc=null;
        boolean bb=true;
        int pos=0;
        for(int i=0;i<mensajeDividido.length&&bb;i++){
            String menDivi=mensajeDividido[i];
            if(menDivi.equals("direccion")||menDivi.equals("vivo")){
                direc=mensajeDividido[i+2]+" ";
                bb=false;
                pos=i+2;
            }
        }
        direc=direc+mensajeDividido[pos+1];
        String linea=mensajeDividido[pos+2];
        int cont=pos+1;
        while(!linea.equals(",")&&!linea.equals("mi")&&!linea.equals("y")&&!linea.equals("quiero")&&cont+1<mensajeDividido.length-1){
            direc=direc+" "+linea;
            cont++;
            linea=mensajeDividido[cont+1];
        }
        res.setDireccion(direc);
        System.out.println("Direccion: "+ direc);
        return res;
    }

    public ArrayList<Solicitud> devolverSolicitudes(){
        ArrayList<Solicitud> res=new ArrayList<>();
        
        return res;
    }

}
