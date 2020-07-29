
public class Nodo{  
    private String vertice;
    private String  costo;
    
    
    public Nodo(String ver, String costo){
        vertice = ver;
        this.costo = costo;
        
    }

    public String getVertice(){
        return vertice;
    }

    public String getCosto(){
        return costo;
    }

    //public int getPosX(){return x;}
