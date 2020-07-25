import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
public class Animacion extends JPanel
{
    BufferedImage mapa;
    Repartidor r;
    Direccion d;
    int X_moto;
    int Y_moto;
    public Animacion(Repartidor r) throws InterruptedException{
        this.r=r;
        this.d=r.getDireccion();
        try{
            this.mapa = ImageIO.read(new File("C:\\Users\\Boris\\Documents\\Proyecto\\MetodosyTecnicasTaller\\JavaApplication2\\src\\mapa.png"));;
        }catch(IOException e){
            System.out.println (e.toString());
            System.out.println("No se pudo encontrar el archivo " + this.mapa);
        }
        this.X_moto=r.getPosX();
        this.Y_moto=r.getPosY();      
        JFrame frame = new JFrame("Mapa");                              
        frame.add(this);
        frame.setSize(mapa.getWidth(),mapa.getHeight());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        boolean llego=false;
        while (llego==false) {
            if(this.X_moto!=d.getPosX()){
                recorrerX();
                repaint();
            }
            if(this.Y_moto!=d.getPosY()){
                recorrerY();
                repaint();
            }
            Thread.sleep(50);
            if(this.X_moto==d.getPosX() && this.Y_moto==d.getPosY()){
                llego=true;
            }
        }
        
    }
    
    public void recorrerX(){
        this.X_moto=X_moto+ 1;
        r.setPosX(this.X_moto);
    }

    public void recorrerY(){
        this.Y_moto=Y_moto+ 1;
        r.setPosY(this.Y_moto);
    }
    
    public int getPosMotoX(){
        return this.X_moto;
    }

    public int getPosMotoY(){
        return this.Y_moto;
    }
       
    @Override
    public void paint(Graphics g) {
        super.paint(g);       
        g.drawImage(this.mapa,0,0,getWidth(),getHeight(),null);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.red);
        g2d.fillOval(d.getPosX(),d.getPosY(), 30, 30);
        g2d.setColor(Color.black);
        g2d.fillOval(r.getPosX(),r.getPosY(), 15, 15);
        
    }
    
}
