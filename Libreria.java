package informatica.esercizio30;
import java.util.ArrayList;

public class Libreria{
    
    ArrayList<ILibro> elencoLibri;

    public Libreria() {
        elencoLibri = new ArrayList<>();
    }

    public Libreria(ArrayList<ILibro> elencoLibri) {
        this.elencoLibri = elencoLibri;
    }
    
    public boolean addLibro(ILibro l){
        if (l == null) return false;
        return elencoLibri.add(l);
    }
    
    private int cercaLibro(String titolo){
        for (int i = 0; i < elencoLibri.size(); i++) {
            if(elencoLibri.get(i).getTitolo().equals(titolo))return i;
        }
        return -1;
    }
    
    public ILibro removeLibro(String titolo){
        if(titolo == null || titolo.equals("Null")) return null;
        return elencoLibri.remove(cercaLibro(titolo));
    }

    @Override
    public String toString() {
        String s = "Libreria:\n";
        for (ILibro l : elencoLibri) {
            s += "\n" + l.toString() + "\n";
        }
        return s;
    }
    
}
