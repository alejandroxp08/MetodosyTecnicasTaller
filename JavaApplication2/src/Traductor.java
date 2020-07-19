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
    private String [] mensajeDividido;
    public Traductor(){
        mensaje=null;
    }

    public void recibirMensaje()throws IOException{
        Scanner sc=new Scanner(System.in);
        mensaje=sc.nextLine();
        mensajeDividido=mensaje.split(" |\\,");
        System.out.println("Mensaje traducido");
        traducirMensaje();
    }

    private void traducirMensaje()throws IOException{
        devolverNombre();
        devolverDireccion();
        devolverSolicitudes();
        devolverObservaciones();
    }

    private void devolverNombre(){
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
        while(!linea.equals(",")&&!linea.equals("mi")&&!linea.equals("y")&&!linea.equals("quiero")&&!linea.equals("vivo")&&cont+1<mensajeDividido.length-1&&!isNumeric(linea)){
            nom=nom+" "+linea;
            cont++;
            linea=mensajeDividido[cont+1];
        }
        System.out.println("Nombre: "+ nom);

    }

    private void devolverDireccion(){
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
        System.out.println("Direccion: "+ direc);
    }

    public ArrayList<Producto> devolverSolicitudes()throws IOException{
        ArrayList <Solicitud> res=new ArrayList<>();
        ArrayList <Producto> productos=new ArrayList<>();
        Serializacion ser= new Serializacion();
        ser.insertarBD();
        try {
            ser.abrirentrada();
            Producto d;
            do{
                d = ser.leer();
                productos.add(d);
            } while(d!=null);
            ser.cerrarentrada();
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return productos;
    }

    private void devolverObservaciones(){
        String res="";
        boolean bb=true;
        int pos=0;
        for(int i=0;i<mensajeDividido.length&&bb;i++){
            String menDivi=mensajeDividido[i];
            if(menDivi.equals("mediano")||menDivi.equals("grande")||menDivi.equals("peque�o")){
                res=menDivi+" ";
                if(!isNumeric(mensajeDividido[i+1])){res=res+mensajeDividido[i+1];}
                bb=false;
                pos=i+2;
            }
        }
        System.out.println("Observaciones: "+ res);
    }

    private boolean isNumeric(String cadena) {
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
