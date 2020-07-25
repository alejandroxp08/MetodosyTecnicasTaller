import java.util.ArrayList;
import java.io.File;

public class Mapa implements SujetoObservable
{
    ArrayList<Observador> observadores;
    int X_moto;
    int Y_moto;
    public Mapa(Repartidor r){
        observadores = new ArrayList<>();
        this.X_moto=r.getPosX();
        this.Y_moto=r.getPosY();               
    }
    
    @Override
    public void addObservador(Observador o){
        if(o instanceof Repartidor){
            observadores.add(o);
        }
    }
    
    @Override
    public void deleteObservador(Observador o){
        if(o instanceof Repartidor){
            observadores.remove(o);
        }
    }
    
    @Override
    public int countObservadores(){
        return this.observadores.size();
    }
    
    public void mostrarMapa(){
        notificar();
    }
    
    @Override
    public void notificar(){
        for(Observador o : observadores){
            o.update();
        }
    }
        
}
