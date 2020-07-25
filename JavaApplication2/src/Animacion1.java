
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Frame;

public class Animacion1 extends JPanel {
    int X_moto;
    int Y_moto;
    int X_direecion;
    int Y_direecion;
    BufferedImage mapa;
    public Animacion1(Repartidor1 r,Direccion1 d){
        this.X_moto=r.getPosX();
        this.Y_moto=r.getPosY();
        this.X_direecion=d.getPosX();
        this.Y_direecion=d.getPosY();
        try{
            this.mapa = ImageIO.read(new File("C:\\Users\\Boris\\Pictures\\ejemplomapa.png"));
        }catch(IOException e){

        }
        
    }

    private void recorrerX(){
        this.X_moto=X_moto +1;        
    }

    private void recorrerY(){
        this.Y_moto=Y_moto +1;
    }

    public int getPosMotoX(){
        return this.X_moto;
    }

    public int getPosMotoY(){
        return this.Y_moto;
    }

    public int getPosDireccionX(){
        return this.X_direecion;
    }

    public int getPosDireccionY(){
        return this.Y_direecion;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        g.drawImage(this.mapa,0,0,getWidth(),getHeight(),null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
        g2d.fillOval(X_moto,Y_moto, 30, 30);
        g2d.setColor(Color.red);
        g2d.fillOval(X_direecion,Y_direecion, 30, 30);
        
    }   

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Prueba de Animación");
        Repartidor1 r=new Repartidor1(20, 20);
        Direccion1 d=new Direccion1("Ayacucho", 100, 200);
        Animacion1 m = new Animacion1(r,d);
        frame.add(m);
        frame.setSize(1231,535);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        boolean llego=false;
        while (llego==false) {
            if(m.getPosMotoX()!=m.getPosDireccionX()){
                m.recorrerX();
                m.repaint();
            }
            if(m.getPosMotoY()!=m.getPosDireccionY()){
                m.recorrerY();
                m.repaint();
            }
            Thread.sleep(50);
            if(m.getPosMotoX()==m.getPosDireccionX() && m.getPosMotoY()==m.getPosDireccionY()){
                llego=true;
            }
        }

    }

    
}
