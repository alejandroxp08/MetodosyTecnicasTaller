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
        mensajeTrad=new Pedido();
        mensajeDividido=mensaje.split(" |\\,");
    }

    public void traducirMensaje(){
        mensajeTrad.setNom(devolverNombre());
        mensajeTrad.setDireccion(devolverDireccion());
        mensajeTrad.setSoli(devolverSolicitudes());
    }

    public String devolverNombre(){
        String nom="";
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
        System.out.println("Nombre: "+ nom);
        return nom;
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
        Serializacion ser= new Serializacion();
        try {
            ser.abrirentrada();
            Producto d;
            int cant=0;
            do {
                d = ser.leer();
                for(int i=0;i<mensajeDividido.length-1;i++){
                    String aux=mensajeDividido[i];
                    if(d.getNom().equals(aux)){
                        if(isNumeric(mensajeDividido[i+1])){
                            cant=Integer.parseInt(mensajeDividido[i+1]);
                        }
                        else{
                            cant=Integer.parseInt(mensajeDividido[i-1]);
                        }
                        Solicitud soli=new Solicitud(d,cant);
                        soli.mostrarse();
                        res.add(soli);
                    }
                }
            } while(d!=null);
            ser.cerrarentrada();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return res;
    }

    private static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

}
