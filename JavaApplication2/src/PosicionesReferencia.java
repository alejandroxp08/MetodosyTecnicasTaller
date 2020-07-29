
import java.util.HashMap;
public class PosicionesReferencia
{
    HashMap<String,Posicion> posRef;
    public PosicionesReferencia(){
        this.posRef=new HashMap<>();
        posRef.put("m",new Posicion(650,280));
        posRef.put("X",new Posicion(675,460));
        posRef.put("J",new Posicion(605,80));
        posRef.put("N",new Posicion(700,70));
        posRef.put("A1",new Posicion(805,50));
        posRef.put("O",new Posicion(660,370));
        posRef.put("K",new Posicion(625,170));
        posRef.put("A1",new Posicion(805,50));
        posRef.put("T",new Posicion(830,145));
        posRef.put("U",new Posicion(840,245));
        posRef.put("W",new Posicion(860,345));
        posRef.put("Z",new Posicion(880,435));
        posRef.put("Q",new Posicion(780,445));
        posRef.put("P",new Posicion(760,355));
        //posRef.put("O",new Posicion(740,255));
        posRef.put("Ñ",new Posicion(720,155));
        posRef.put("G",new Posicion(507,93));
        posRef.put("D",new Posicion(407,110));
        posRef.put("A",new Posicion(315,125));
        posRef.put("G7",new Posicion(215,140));
        posRef.put("F6",new Posicion(235,240));
        posRef.put("B",new Posicion(335,220));
        posRef.put("E",new Posicion(425,210));
        posRef.put("h",new Posicion(530,190));
        posRef.put("i",new Posicion(550,300));
        posRef.put("F",new Posicion(440,310));
        posRef.put("C",new Posicion(350,330));
        posRef.put("S",new Posicion(360,420));
        posRef.put("R",new Posicion(460,400));
        posRef.put("Y",new Posicion(560,390));
        posRef.put("D4",new Posicion(580,480));
        posRef.put("C3",new Posicion(480,500));
        posRef.put("B2",new Posicion(380,520));
        
    }
    
    public HashMap getPosicionesReferencia(){
        return this.posRef;
    }
}
