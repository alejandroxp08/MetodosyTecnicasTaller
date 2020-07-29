import java.io.*;
import java.util.*;
/**
 * Write a description of class Reporte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reporte implements Serializable{
    private Pedido pedido;
    private ObjectInputStream ser;
    public Reporte(Pedido p) throws IOException{
        pedido=p;
        ser = new ObjectInputStream(new FileInputStream("reportes.txt"));
    }

    public Pedido getPedido(){
        return pedido;
    }

    public void generarReporte(Reporte r) throws IOException{
        Serializacion ser=new Serializacion();
        try{
            ser.abrirsalida3();
            ser.escribir3(r);
            ser.cerrarsalida2();
        }catch(IOException e){
        }
    }

    public void listarReportes()throws IOException{
        try {
            Reporte d;
            do{
                d =(Reporte)ser.readObject();
                mostrarse(d);
            } while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }

    private void mostrarse(Reporte r){
        Pedido d=r.getPedido();
        System.out.println("======Reporte=====\n"+"Nombre Cliente: "+d.getNomCliente()+" \nDireccion: "+d.getDireccion().direccion);
        mostrarSolicitudes(d.getSoli());
        System.out.println("Observaciones: "+d.getObservaciones());
        System.out.println("Precio Total: "+d.precioTotal());
        System.out.println("=======FIN========");
    }

    private void mostrarSolicitudes(ArrayList<Solicitud> soli){
        for(int i=0;i<soli.size();i++){
            Solicitud aux=soli.get(i);
            System.out.println("Producto: "+aux.getProduc().getNom()+"Cantidad: "+aux.getCant());
        }
    }

    public void modaProductos() throws IOException{
        HashMap<String,Integer> modas=llenarProductos();
        String may="";
        int max=0;
        try {
            Reporte d;
            do{
                d =(Reporte)ser.readObject();
                ArrayList<Solicitud> soli=d.getPedido().getSoli();
                for(int i=0;i<soli.size();i++){
                    String aux=soli.get(i).getProduc().getNom();
                    int cant=soli.get(i).getCant();
                    if(modas.containsKey(aux)){
                        modas.put(aux,modas.get(aux)+cant);
                    }
                    if(modas.get(aux)>max){
                        may=aux;
                    }
                }
            } while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        System.out.println("El producto mas requerido es: "+modas.get(may));
    }

    private HashMap<String,Integer> llenarProductos()throws IOException{
        HashMap<String,Integer> res=new HashMap<>();
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("productos2.txt"));
        try {
            Producto d;
            do{
                d =(Producto)ser.readObject();
                String aux=d.getNom();
                if(!res.containsKey(aux)){
                    res.put(aux,0);
                }
            } while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        return res;
    }

}
