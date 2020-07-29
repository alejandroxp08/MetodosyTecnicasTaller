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
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.FileInputStream;
public class Animacion extends JPanel
{
    BufferedImage mapa;
    Repartidor r;
    Direccion direccion;
    String clave;
    int X_moto;
    int Y_moto;    
    //ArrayList<String> camino;
    DOMParser dir;
    HashMap<String,Posicion> ref;
    public Animacion(Repartidor r) throws InterruptedException{
        this.r=r;

        try{
            this.mapa = ImageIO.read(new File("mapa.png"));    

        }catch(IOException e){
            System.out.println (e.toString());
            System.out.println("No se pudo encontrar el archivo " + this.mapa);
        }
        /*try{
        getCamino();

        }catch(IOException e){

        }*/
        this.X_moto=r.getPosX();
        this.Y_moto=r.getPosY();      
        JFrame frame = new JFrame("Mapa");                              
        frame.add(this);
        frame.setSize(mapa.getWidth(),mapa.getHeight());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        boolean llego=false;
        /*while (llego==false) {
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
        }*/

        dir=new DOMParser();
        try{
            clave=dir.principal();  

        }catch(IOException e){

        }

        PosicionesReferencia posRef =new PosicionesReferencia();
        ref=posRef.getPosicionesReferencia();

        while(llego==false){
            if(ref.containsKey(clave)){
                if(this.X_moto > ref.get(clave).getX()){
                    if(this.X_moto!=ref.get(clave).getX()){
                        recorrerX(true);
                        repaint();
                    }
                }else{
                    if(this.X_moto!=ref.get(clave).getX()){
                        recorrerX(false);
                        repaint();
                    }
                }
                if(this.Y_moto > ref.get(clave).getY()){
                    if(this.Y_moto!=ref.get(clave).getY()){
                        recorrerY(true);
                        repaint();
                    }
                }else{
                    if(this.Y_moto!=ref.get(clave).getY()){
                        recorrerY(false);
                        repaint();
                    }
                }
                Thread.sleep(50);
                if(this.X_moto==ref.get(clave).getX() && this.Y_moto==ref.get(clave).getY()){
                    llego=true;
                }
            }
        }
        llego=false;

    }

    public void recorrerX(boolean cond){
        if(cond){
            this.X_moto=X_moto- 1;
            r.setPosX(this.X_moto);
        }else{
            this.X_moto=X_moto+ 1;
            r.setPosX(this.X_moto);
        }
    }

    public void recorrerY(boolean cond){
        if(cond){
            this.Y_moto=Y_moto- 1;
            r.setPosY(this.Y_moto);
        }else{
            this.Y_moto=Y_moto+ 1;
            r.setPosY(this.Y_moto);
        }

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
        ///for(int i=0;i<camino.size();i++){
        g2d.setColor(Color.red);
        g2d.fillOval(ref.get(clave).getX(),ref.get(clave).getY(), 15, 15);

        g2d.setColor(Color.black);
        g2d.fillOval(r.getPosX(),r.getPosY(), 15, 15);

    }

    private void retornarDirecciones ()throws IOException {
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream("pedidos.txt"));
        Pedido d=new Pedido();
        try {
            do{
                d = (Pedido)ser.readObject();
                direccion=d.getDireccion();
            }
            while(d!=null);
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }

    } 

    /*public static void mostrarMapa() throws InterruptedException {
    JFrame frame = new JFrame("Mapa");    
    Posicion pr = new Posicion(20,20);
    Posicion pd = new Posicion(800,500);
    Direccion d=new Direccion("Ayacucho", pd);
    Repartidor r=new Repartidor(pr,d);
    Animacion m = new Animacion(r);       
    frame.add(m);
    frame.setSize(1365 , 657);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    boolean llego=false;
    while (llego==false) {
    if(m.getPosMotoX()!=d.getPosX()){
    m.recorrerX();
    m.repaint();
    }
    if(m.getPosMotoY()!=d.getPosY()){
    m.recorrerY();
    m.repaint();
    }
    Thread.sleep(50);
    if(m.getPosMotoX()==d.getPosX() && m.getPosMotoY()==d.getPosY()){
    llego=true;
    }
    }

    }*/
}
