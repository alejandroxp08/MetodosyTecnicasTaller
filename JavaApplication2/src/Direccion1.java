
public class Direccion1 {
    String direccion;
    int posX;
    int posY;
    public Direccion1(String direccion,int x,int y){
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
}
