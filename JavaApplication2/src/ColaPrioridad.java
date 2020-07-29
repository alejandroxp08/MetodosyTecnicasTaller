import java.util.*;
import java.io.*;
/**
 * Write a description of class ColaPrioridad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColaPrioridad{
    private Queue<Pedido>[]colas;
    private ArrayList<Pedido> pedidos;
    private  int numPrioridades =3;

    public ColaPrioridad(){
        //solicitudes=new ArrayList<>();
        colas=new PriorityQueue[numPrioridades]; 
    }

    private void retornarPedidos () throws IOException{
        ArrayList<Pedido> res=new ArrayList<>();
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("pedidos.txt"));
        Pedido d=new Pedido();
        try {
            do{
                d = (Pedido)ser.readObject();
<<<<<<< HEAD
                Pedido p=d;
                pedidos.add(p);

=======
                res.add(d);
>>>>>>> 268bf21b23c39494f71f2dfd321e90bf6a588084
            }
            while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        pedidos=res;
    } 

    private void añadirColaPrioridad ( Pedido p){
        ArrayList<Integer> prioridades=new ArrayList();
        ArrayList<Solicitud> solicitudes=p.getSoli();
        for(Solicitud s:solicitudes){
            Producto pro=s.getProduc();
            int prioridad= pro.getPrioridad();
            if(prioridades.contains(prioridad)){
                Queue<Pedido> cola=colas[prioridad-1];
                cola.add(p);
            }else{
                Queue<Pedido> cola1 = new PriorityQueue<Pedido>(); 

                colas[prioridad-1]=cola1;
                if(p instanceof Pedido){
                    cola1.add(p);
                }
                prioridades.add(prioridad);
            }
        }
    }

    private Queue<Pedido>[] getColas(){
        return colas;
    }

    public   void main() throws IOException{
        llenar();

        for(int i=0;i<colas.length;i++){
            Queue<Pedido> cola=colas[i];
            if(cola!=null){
                imprimir(cola);
            }
        }
    }

    private void imprimir( Queue<Pedido> cola){
        for(Pedido pedi : cola) {
            ArrayList<Solicitud> solicitudes=pedi.getSoli();
            for(Solicitud s:solicitudes){

                Producto p=s.getProduc();
                System.out.println(p.getNom()+ " --> " + s.getCant() + "  -- [ " + p.getPrioridad() + "]");
                System.out.println(pedi.getNomCliente()+ " --> " + pedi.getDireccion().getCalleP() );
            }
        }
    }

    private   void llenar()throws IOException {
        retornarPedidos();
        for(Pedido p:pedidos){
            añadirColaPrioridad (p);

        }
    }
}

