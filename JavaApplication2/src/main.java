
import java.util.*;
/**
 * Write a description of class z here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    public  void main(){
        Direccion di=new Direccion("ECUADOR","HAMIRAYA");
        Pedido p=new Pedido("",di,"");
        Grafo g = new Grafo(true);
        HashMap<String, ArrayList<Nodo>>grafo =g.getGrafo();
        ArrayList <String> vertices=new ArrayList();

        vertices.add("A");
        vertices.add("B");
        vertices.add("C");
        vertices.add("D");
        vertices.add("E");
        vertices.add("F");

        g.agregarVertice("A");
        g.agregarVertice("B");
        g.agregarVertice("C");
        g.agregarVertice("D");
        g.agregarVertice("E");
        g.agregarVertice("F");
        //g.agregarVertice("g");
        //g.agregarVertice("g");
        //g.agregarVertice("i");
        //g.agregarVertice("j");
        //g.agregarArista("C","B",12);
        //g.agregarArista("C","f",2);
        //g.agregarArista("C","i",5);
        //g.agregarArista("C","g",4);        
        //g.agregarArista("e","A",2);
        //g.agregarArista("f","A",10);
        //g.agregarArista("g","j",6);
        //g.agregarArista("h","C",5);
        //g.agregarArista("h","e",1);
        g.agregarArista("D","A","ECUADOR");
        g.agregarArista("B","A","TUMUSLA");
        g.agregarArista("B","E","COLOMBIA");
        g.agregarArista("E","D","HAMIRAYA");
        g.agregarArista("C","F","HEROINAS");
        g.agregarArista("F","E","HAMIRAYA");
        g.agregarArista("F","C","HEROINAS");
        String vertice="";
         String verticeCom=encontararVertComun("ECUADOR","HAMIRAYA",0,vertices,grafo, vertice);
        
        EncontrarVertices(verticeCom,g,grafo);
    }

    public String encontararVertComun(String calleP,String calleI,int pos, ArrayList <String> vertices, HashMap<String, ArrayList<Nodo>>grafo,String vertice){
        //Direccion d=p.getDireccion();
        //String calleP=d.getCalleP();
        //String calleI=d.getCalleI();
        int numVertices=6;
        String verticeCom="";

        for(int i=0;i<numVertices;i++){
            String vert=vertices.get(i);
            ArrayList<Nodo>vecinos=grafo.get(vert);
            if(vecinos!=null){
                for(Nodo n:vecinos){
                    String calle= n.getCosto();

                    if(calle.equals(calleP)){
                        if(pos==0){
                            vertice=vertices.get(i);

                            vertice=encontararVertComun( calleI,calleP,pos+1,vertices,grafo,vertice);

                        }else{
                            if(pos==1){
                                String v=n.getVertice();
                                if(vertice.equals(v)){
                                    verticeCom=v;
                                }
                            }
                        }
                    }
                }
            }
        }
        return vertice;
    }
    //ArrayList<Nodo>vecinosVer=grafo.get(vertice);
    // for(Nodo nodo:vecinosVer){
    //String calleIn=nodo.getVertice();
    //if(calleIn.equals(calleI)){
    /// verticeCom=nodo.getVertice();
    //}
    public void  EncontrarVertices(String verticeCom,Grafo g,HashMap<String, ArrayList<Nodo>>grafo){
        Nodo vertO=new Nodo("C","HEROINAS");
        Nodo vertD=new Nodo(verticeCom,"JUNIN");

        TextoAudio tts=new TextoAudio();
        ArrayList<String> caminoCorto=g.caminoMenorTam( vertO.getVertice(), vertD.getVertice());

        //for(int i=0;i<caminoCorto.size()-1;i++){
        // String vo=caminoCorto.get(i)
        // String vd=caminoCoerto(i+1);
        // for(Arista a:aristas){
        //  if(a.getVo()==vo&& vd==getVd()){
        //String calle=a.getCosto();
        // ArrayList<String> calles=calles.add(calle);
        //  }

        //}

        //  }
        for(int j=0;j<caminoCorto.size()-1;j++){
            String vo=caminoCorto.get(j+1);
            String vertice=caminoCorto.get(j);
            ArrayList<Nodo>vecinosV=grafo.get(vertice );
            for(Nodo n:vecinosV){
                String v=n.getVertice();

                if(v.equals(vo)){
                    String calle=n.getCosto();
                    tts.speak(calle);

                }

            }

        }

    }
}


