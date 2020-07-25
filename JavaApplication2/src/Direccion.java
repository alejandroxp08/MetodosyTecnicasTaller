
/**
 *
 * @author Boris
 */
public class Direccion {
    String direccion;
    int posX;
    int posY;
    public Direccion(String direccion,int x,int y){
        this.direccion=direccion;
        this.posX=x;
        this.posY=y;
    }

    public String getDireccionNombre(){
        return this.direccion;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public void setDireccion(String d){
        direccion=d;
    }
}
