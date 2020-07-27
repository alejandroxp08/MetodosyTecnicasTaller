import java.util.*;
import java.io.*;
/**
 * Write a description of class ColaPrioridad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColaPrioridad{
    private Queue<Solicitud>[]colas;
    private ArrayList<Solicitud> solicitudes;
    private  int numPrioridades =3;
    
    public ColaPrioridad(){
        solicitudes=new ArrayList<>();
        colas=new PriorityQueue[numPrioridades]; 
    }

    private void retornarSolicitudes () throws IOException{
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("pedidos.txt"));
        Pedido d=new Pedido();
        try {
            do{
                d = (Pedido)ser.readObject();
                solicitudes=d.getSoli();
            }
            while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    } 

    private void añadirColaPrioridad ( Solicitud s){
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
        retornarSolicitudes();
        //aqui te falta poner algo  xd
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

