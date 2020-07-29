import java.awt.image.BufferedImage;
public class Repartidor implements Observador
{
    int posX;
    int posY;
    Direccion dir;
    public Repartidor(){
        this.posX=650;
        this.posY=280;
        this.dir=dir;
    }

    public void setPosX(int x){
        this.posX=x;
    }

    public void setPosY(int y){
        this.posY=y;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public Direccion getDireccion(){
        return this.dir;
    }

    @Override
    public void update(){
        try{
            new Animacion(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    

}

    


