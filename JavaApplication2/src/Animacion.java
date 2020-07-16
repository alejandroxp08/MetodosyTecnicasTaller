
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Boris
 */
public class Animacion extends JPanel {
    int X_moto;
    int Y_moto;
    int X_direecion;
    int Y_direecion;
    public Animacion(Repartidor r,Direccion d){
        this.X_moto=r.getPosX();
        this.Y_moto=r.getPosY();
        this.X_direecion=d.getPosX();
        this.Y_direecion=d.getPosY();}
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
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.black);
	g2d.fillOval(X_moto,Y_moto, 30, 30);
        g2d.setColor(Color.red);
	g2d.fillOval(X_direecion,Y_direecion, 30, 30);
        
    }
    
    public void paintDirection(Graphics g) {
	super.paint(g);
	Graphics2D lugar = (Graphics2D) g;
	lugar.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        lugar.setColor(Color.red);
	lugar.fillOval(X_direecion,Y_direecion, 30, 30);
        
    }
    public static void main(String[] args) throws InterruptedException {
	JFrame frame = new JFrame("Prueba de Animación");
        Repartidor r=new Repartidor(20, 20);
        Direccion d=new Direccion("Ayacucho", 100, 200);
	Animacion m = new Animacion(r,d);
	frame.add(m);
	frame.setSize(800, 600);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//boolean llegoX=false;
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
