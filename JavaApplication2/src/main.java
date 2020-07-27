import java.util.*;
/**
 * Write a description of class z here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main
{
    public static  void main(){
        Grafo g = new Grafo(true);
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
        g.agregarArista("D","A","ECUADOR");
        g.agregarArista("B","A","TUMUSLA");
        g.agregarArista("B","E","COLOMBIA");
        g.agregarArista("E","D","JUNIN");
        g.agregarArista("C","F","HEROINAS");
        g.agregarArista("F","E","HAMIRAYA");
        g.agregarArista("F","C","HEROINAS");
        //g.agregarArista("C","B",12);
        //g.agregarArista("C","f",2);
        //g.agregarArista("C","i",5);
        //g.agregarArista("C","g",4);        
        //g.agregarArista("e","A",2);
        //g.agregarArista("f","A",10);
        //g.agregarArista("g","j",6);
        //g.agregarArista("h","C",5);
        //g.agregarArista("h","e",1);
        //Nodo vo=new Nodo("C","HEROINAS");
       // Nodo vd=new Nodo("D","JUNIN");
        ArrayList<ArrayList<>> caminos=g.caminos( "C", "D");
         TextoAudio tts=new TextoAudio();
        for(ArrayList<Nodo> camino:caminos){
            for(Nodo n:camino){
                String calle=n.getCosto();
                tts.speak(calle);
            }
        }

    }
}
