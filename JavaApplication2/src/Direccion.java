
<<<<<<< HEAD
public class Direccion
{
=======
<<<<<<< HEAD
public class Direccion
{
    String direccion;
    int posX;
    int posY;
    Posicion p;
    public Direccion(String direccion,Posicion p){
        this.direccion=direccion;
        this.p=p;
    }
    public String getDireccionNombre(){
        return this.direccion;
    }
    public int getPosX(){
        return this.p.getX();
    }
    public int getPosY(){
        return this.p.getY();
=======
/**
 *
 * @author Boris
 */
public class Direccion {
>>>>>>> master
    String direccion;
    int posX;
    int posY;
    Posicion p;
    public Direccion(String direccion,Posicion p){
        this.direccion=direccion;
        this.p=p;
    }
    public String getDireccionNombre(){
        return this.direccion;
    }
    public int getPosX(){
        return this.p.getX();
    }
    public int getPosY(){
<<<<<<< HEAD
        return this.p.getY();
=======
        return this.posY;
    }

    public void setDireccion(String d){
        direccion=d;
>>>>>>> 1db7ec70a9985865026bbfab9b16ec49edb4687f
>>>>>>> master
    }
}
