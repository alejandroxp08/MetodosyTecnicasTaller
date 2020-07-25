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
public class FondoMapa extends Frame
{
    BufferedImage mapa;
    public FondoMapa(){
        try{
            this.mapa = ImageIO.read(new File("C:\\Users\\Boris\\Pictures\\ejemplomapa.png"));
        }catch(IOException e){

        }
    }
    public void myFrame(){
        setSize(1231,535);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(mapa,0,0,getWidth(),getHeight(),null);
    }
    
    public static void main(String args[]){
        new FondoMapa().myFrame();
    }
}
