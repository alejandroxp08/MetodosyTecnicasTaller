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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
>>>>>>> 7e383b1a900186cedeb10d810449ae689ad127e8
    }
}
