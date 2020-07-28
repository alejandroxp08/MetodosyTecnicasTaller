import java.io.*;
/**
 *
 * @author Boris
 */
public class Direccion implements Serializable {
    String callePrincipal;
    String calleInterseccion;
    int posX;
    int posY;
    int numeroCasa;
    String referencia;
    public Direccion(String cP,String cI){//,String referencia,int x,int y,int nC){

       // this.posX=x;
       // this.posY=y;
        callePrincipal=cP;
        calleInterseccion=cI;
       // numeroCasa=nC;
        //this.referencia=referencia;
    }

    public String getCalleP(){
        return callePrincipal;

    }

    public String getCalleI(){
        return calleInterseccion;
    }

    public int getNumCasa(){
        return numeroCasa;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public String referencia(){
        return referencia;
    }

}
