
import java.util.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMParserOraciones {

    Document doc;

    public  void main()  {
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

    public  void agregarVert(){
        Grafo g = new Grafo(true);
        HashMap<String, ArrayList<Nodo>> grafo = g.getGrafo();

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
        agregarArisVert(grafo,g);

    }
   
    public   void agregarArisVert(HashMap<String, ArrayList<Nodo>>grafo,Grafo g){
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
        main2(grafo,g);

    }

    public void main2( HashMap<String, ArrayList<Nodo>>grafo, Grafo g){
       
        ArrayList<String>vertices=new ArrayList<>();
        for(String key :grafo.keySet()){
            vertices.add(key);
        }
       
        Direccion di=new Direccion("ECUADOR","HAMIRAYA");
        Pedido p=new Pedido("",di,"");
        String vertice="";
        String verticeCom=encontararVertComun("ECUADOR","HAMIRAYA",0,grafo, vertice,vertices);
        EncontrarVertices(verticeCom,g,grafo);
    }

    public String encontararVertComun(String calleP,String calleI,int pos,  HashMap<String, ArrayList<Nodo>>grafo,String vertice, ArrayList<String>vertices){// devolver vertice final{
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
                                vertice=encontararVertComun( calleI,calleP,pos,grafo,vertice,vertices);

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
        //if (nodoNombre.equals("costo"){

        //  String costo=elemento.getChildNodes().item(0).getNodeValue());
        //if(costo.equals(calle)){
        //    tts.speak("");

        // }
        //}
    }
}

