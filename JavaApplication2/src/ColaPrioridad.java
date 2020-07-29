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
    private ArrayList<Pedido> pedidos;
    private  int numPrioridades =3;

    public ColaPrioridad(){
        //solicitudes=new ArrayList<>();
        colas=new PriorityQueue[numPrioridades]; 
    }

    private void retornarPedidos () throws IOException{
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("pedidos.txt"));
        Pedido d=new Pedido();
        try {
            do{
                d = (Pedido)ser.readObject();

            }
            while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    } 

    private void añadirColaPrioridad ( Pedido p){
        ArrayList<Integer> prioridades=new ArrayList();
        ArrayList<Solicitud> solicitudes=p.getSoli();
        for(Solicitud s:solicitudes){
            Producto pro=s.getProduc();
            int prioridad= pro.getPrioridad();
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
    }

    private Queue<Solicitud>[] getColas(){
        return colas;
    }


    public   void main() throws IOException{
        llenar();

        for(int i=0;i<colas.length;i++){
            Queue<Solicitud> cola=colas[i];
            if(cola!=null){
                imprimir(cola);
            }
        }
    }

    private void imprimir( Queue<Solicitud> cola){
        for(Solicitud s : cola) {
            Producto p=s.getProduc();
            System.out.println(p.getNom()+ " --> " + s.getCant() + "  -- [ " + p.getPrioridad() + "]");
        }
    }

    private   void llenar()throws IOException {
        try {
            retornarPedidos();
            for(Pedido p:pedidos){
                añadirColaPrioridad (p);

            }

        }
        catch (IOException e) {
        }
    }
}

