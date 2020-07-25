
public interface SujetoObservable
{
    public void notificar();
    public void addObservador(Observador o);
    public void deleteObservador(Observador o);
    public int countObservadores();
}
