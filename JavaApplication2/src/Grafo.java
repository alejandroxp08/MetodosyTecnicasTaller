
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;
public class Grafo{
    private HashMap<String, ArrayList<Nodo>> grafo;
    private boolean dirigido;
    ArrayList<ArrayList<String>> caminos;
    private ArrayList <Integer>tamaños;
    public Grafo(boolean dir){
        grafo = new HashMap<String, ArrayList<Nodo>>();
        dirigido = dir;
        caminos = new ArrayList<>();
        tamaños=new ArrayList<>();
    }
    
    public HashMap<String, ArrayList<Nodo>> getGrafo(){
        return grafo;
    }
    
    public void agregarArista(String orig, String dest, String costo){
        crearArista(orig,dest, costo);
        if(!dirigido){
            crearArista(dest,orig, costo);
        }
    }

    private void crearArista(String ori, String dest, String costo){
        if(!grafo.containsKey(ori)){
            grafo.put(ori, new ArrayList<Nodo>());
        }
        grafo.get(ori).add(new Nodo(dest,costo));
    }

    public void eliminarArista(String ori, String dest){
        elimArista(ori,dest);
        if(!dirigido){
            elimArista(dest,ori);
        }
    }

    public void elimArista(String ori, String dest){
        ArrayList<Nodo> lista= grafo.get(ori);
        boolean bb = false;
        if(lista != null){
            for(int i=0; i<lista.size() && !bb; i++){
                Nodo ac = lista.get(i);
                if(ac.getVertice().equals(dest)){
                    lista.remove(i);
                    bb = true;
                }
            }
        }
    }

    public void eliminarVertice(String v){
        ArrayList<Nodo> lista = grafo.get(v);
        ArrayList<String> destinos = new ArrayList<>();
        for(Nodo n : lista){
            destinos.add(n.getVertice());
        }
        grafo.remove(v);
        for(String s : destinos){
            eliminarArista(s, v);
        }
    }

    public void agregarVertice(String v){
        grafo.put(v, new ArrayList<Nodo>());
    }

    public void caminos(String vo, String vd){

        ArrayList<String> camino = new ArrayList<>();
        camino.add(vo);
        ArrayList<Nodo> vecinos = grafo.get(vo);
        for(Nodo n : vecinos){
            String act = n.getVertice();
            ArrayList<String> copia = (ArrayList<String>)camino.clone();
            copia.add(act);
            caminos(act, vd, copia, caminos);
        }

    }

    private void caminos(String vo, String vd, ArrayList<String> camino, ArrayList<ArrayList<String>> res){
        if(vo.equals(vd)){
            res.add(camino);
        }else{
            ArrayList<Nodo> vecinos = grafo.get(vo);
            if(vecinos!=null){
                for(Nodo n : vecinos){
                    String act = n.getVertice();
                    ArrayList<String> copia = (ArrayList<String>)camino.clone();
                    if(!copia.contains(act)){
                        copia.add(act);
                        caminos(act, vd, copia, res);
                    }
                }
            }

        }
    }

    public ArrayList<String> caminoMenorTam(String vo, String vd){
        caminos(vo,vd);
        getTamños();
        int menor = tamaños.get(0);
        int index=0;
        for (int i = 0; i <tamaños.size(); i++) {
            if (tamaños.get(i) < menor) {
                menor =tamaños.get(i);
                index=i;

            }
        }
        ArrayList<String> caminoCorto= caminos.get(index);

        return caminoCorto;
    }

    public void getTamños(){//princi

        for(int i=0; i<caminos.size() ; i++){
            ArrayList<String> camino =caminos.get(i);
            int tam=caminos.size();
            tamaños.add(tam);
        }

    }

    // public ArrayList<String> nombrarCalles(){
    //  ArrayList<String> caminoCorto=caminoMenorTam();
    //ArrayList<String>res=new ArrayList<>();
    //for(int i=0; i<caminoCorto.size() ; i++){
    //    Nodo n=caminoCorto.get(i);
    // String costo=n.getCosto();
    // res.add(costo);//retorna calles

    // }
    //  return res;
    //}

    public void getTamños(String vo, String vd){//princi
        caminos(vo,vd);
        for(int i=0; i<caminos.size() ; i++){
            ArrayList<String> camino =caminos.get(i);
            int tam=caminos.size();
            tamaños.add(tam);
        }

    }

    public int getTamMin(){//todavia no
        getTamños();
        int mayor = tamaños.get(0);
        for (int i = 1; i <tamaños.size(); i++) {
            if (tamaños.get(i) > mayor) {
                mayor = tamaños.get(i);

            }
        }
        return mayor;
    }
}

