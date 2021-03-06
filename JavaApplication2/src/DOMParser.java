/**
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.*;

public class DOMParser {

    Document doc;
    Grafo g = new Grafo(true);
    Direccion direccion;
    HashMap<String, ArrayList<Nodo>>grafo;
    public Grafo getGrafo(){
        return g;
    }

    public  void main() throws IOException {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            File file = new File("docXml.xml");
            doc = docBuilder.parse(file);

        }catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public  void agregarVert() throws IOException{

        grafo =g.getGrafo();

        main();
        NodeList lista = doc.getElementsByTagName("vertice");

        for (int i = 0; i < lista.getLength(); i++) {
            Element elemento = (Element)lista.item(i);
            String nodoNombre = elemento.getNodeName();
            if (nodoNombre.equals("vertice")) {
                String vertice=elemento.getChildNodes().item(0).getNodeValue();
                g.agregarVertice(vertice);

            } 
        }
        agregarArisVert();

    }

    private void retornarDirecciones ()throws IOException {
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("pedidos.txt"));
        Pedido d=new Pedido();
        try {
            do{
                d = (Pedido)ser.readObject();
                direccion=d.getDireccion();
            }
            while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }

    } 

    public   void agregarArisVert()throws IOException{
        main();
        NodeList lista = doc.getElementsByTagName("*");

        String vo="",vd="",costo="";
        for (int i = 0; i < lista.getLength(); i++) {

            Element elemento = (Element)lista.item(i);
            String nodoNombre = elemento.getNodeName();

            if (nodoNombre.equals("vo")) {
                vo=elemento.getChildNodes().item(0).getNodeValue();

            } 
            if (nodoNombre.equals("vd") ){
                vd=elemento.getChildNodes().item(0).getNodeValue();
            }
            if (nodoNombre.equals("costo")) {

                costo=elemento.getChildNodes().item(0).getNodeValue();

                g.agregarArista(vo,vd,costo);

            }
            System.out.println(vo+vd+costo);
        }

    }

    public ArrayList<String> principal1()throws IOException{
        agregarVert();
        ArrayList<String>vertices=new ArrayList<>();
        
        for(String key :grafo.keySet()){
            vertices.add(key);
        }

        String vertice="";
        retornarDirecciones ();
        String calleP=direccion.getCalleP();
        String calleI=direccion.getCalleI();
        String verticeCom=encontrarVertComun(calleP,calleI,0, vertice,vertices);
        int nc=direccion.getNumCasa();
        ArrayList<String>camino= EncontrarVertices(verticeCom,calleP,nc);
        return camino;

    }
    public String principal()throws IOException{
        agregarVert();
        ArrayList<String>vertices=new ArrayList<>();
        
        for(String key :grafo.keySet()){
            vertices.add(key);
        }

        String vertice="";
        retornarDirecciones ();
        String calleP=direccion.getCalleP();
        String calleI=direccion.getCalleI();
        String verticeCom=encontrarVertComun(calleP,calleI,0, vertice,vertices);
        int nc=direccion.getNumCasa();
        ArrayList<String>camino= EncontrarVertices(verticeCom,calleP,nc);
        return verticeCom;

    }
    
    public String encontrarVertComun(String calleP,String calleI,int pos,String vertice, ArrayList<String>vertices){// devolver vertice final{
        //Direccion d=p.getDireccion();
        //String calleP=d.getCalleP();
        //String calleI=d.getCalleI();

        boolean bb=false;
        int numVertices=vertices.size();

        for(int i=0;i<numVertices&&!bb;i++){
            String vert=vertices.get(i);
            if(vert!=null){
                ArrayList<Nodo>vecinos=grafo.get(vert);
                if(vecinos!=null){
                    for(Nodo n:vecinos){
                        String calle= n.getCosto();

                        if(calle.equals(calleP)){
                            if(pos==0){
                                vertice=vertices.get(i);
                                pos=pos+1;
                                vertice=encontrarVertComun( calleI,calleP,pos,vertice,vertices);

                            }else{
                                if(pos==1){
                                    String v=n.getVertice();
                                    if(vertice.equals(v)){
                                        bb=true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return  vertice;
    }
    //ArrayList<Nodo>vecinosVer=grafo.get(vertice);
    // for(Nodo nodo:vecinosVer){
    //String calleIn=nodo.getVertice();
    //if(calleIn.equals(calleI)){
    /// verticeCom=nodo.getVertice();
    //}
    public  ArrayList<String>  EncontrarVertices(String verticeCom,String calleP,int nc){
        Nodo vertO=new Nodo("M","HEROINAS");
        Nodo vertD=new Nodo(verticeCom,calleP);

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
        if( caminoCorto!=null){
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
         tts.speak(""+nc);
        //if (nodoNombre.equals("costo"){

        //  String costo=elemento.getChildNodes().item(0).getNodeValue());
        //if(costo.equals(calle)){
        //    tts.speak("");

        // }
        //}
        return caminoCorto;
    }

    
}
