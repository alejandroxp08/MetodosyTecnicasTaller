import java.io.*;
/**
 *
 * @author Boris
 */
public class Direccion implements Serializable {
    String callePrincipal;
    String calleInterseccion;
   
    int numeroCasa;
    String referencia;
    public Direccion(String cP,String cI,String referencia,int nC){

        callePrincipal=cP;
        calleInterseccion=cI;
        numeroCasa=nC;
        this.referencia=referencia;
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

  

    public String referencia(){
        return referencia;
    }

}
