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
    private Queue<Solicitud>[]colas;
    private  int numPrioridades =3;
    public Pedido(){
        solicitudes=new ArrayList<>();
        colas=new PriorityQueue[numPrioridades ];
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

    private void retornarSolicitudes () throws IOException{

        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("pedidos.txt"));
        try {
            Pedido d;
            int cant=0;
            do{
                d = (Pedido)ser.readObject();
                solicitudes=d.getSoli();
            }
            while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }finally{
            File fichero=new File("pedidos.txt");
            fichero.delete();
        }
    } 

    public void llenar()throws IOException {
        try {
            retornarSolicitudes();
            for(Solicitud s:solicitudes){
                aņadirColaPrioridad (s);

            }

        }
        catch (IOException e) {
        }
        }
    

    private void aņadirColaPrioridad ( Solicitud s){
        ArrayList<Integer> prioridades=new ArrayList();
        Producto p=s.getProduc();
        int prioridad= p.getPrioridad();
        if(prioridades.contains(prioridad)){
            Queue<Solicitud> cola=colas[prioridad-1];
            cola.add(s);
        }else{
            Queue<Solicitud> cola1 = new PriorityQueue<Solicitud>(); 
            colas[prioridad-1]=cola1;
            cola1.add(s);
            prioridades.add(prioridad);
        }
    }

    public Queue<Solicitud>[] getColas(){
        return colas;
    }

    public void mostrarLista() throws IOException{

        for(int i=0;i<colas.length;i++){
            Queue<Solicitud> cola=colas[i];
            imprimir(cola);
        }
    }

    public static void imprimir( Queue<Solicitud> cola){
        for(Solicitud s : cola) {
            Producto p=s.getProduc();
            System.out.println(p.getNom()+ " --> " + s.getCant() + "  -- [ " + p.getPrioridad() + "]");
        }
    }

}