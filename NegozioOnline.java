package informatica.esercizio30;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class NegozioOnline {
    
    private String nome;
    private String indirizzo;
    private int numeroDipendenti;
    
    private ArrayList<ProdottoGenerico> prodotti;

    public NegozioOnline(String nome, String indirizzo, int numeroDipendenti, ArrayList<ProdottoGenerico> prodotti) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numeroDipendenti = numeroDipendenti;
        this.prodotti = prodotti;
    }
    public NegozioOnline(String nome, String indirizzo, int numeroDipendenti) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numeroDipendenti = numeroDipendenti;
        this.prodotti = new ArrayList<>();
    }
    public NegozioOnline() {
        this.nome = "Null";
        this.indirizzo = "Null";
        this.numeroDipendenti = 0;
        this.prodotti = new ArrayList<>();
    }
    public NegozioOnline(NegozioOnline no) {
        this.nome = no.nome;
        this.indirizzo = no.indirizzo;
        this.numeroDipendenti = no.numeroDipendenti;
        this.prodotti = (ArrayList<ProdottoGenerico>)no.prodotti.clone();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public int getNumeroDipendenti() {
        return numeroDipendenti;
    }
    public void setNumeroDipendenti(int numeroDipendenti) {
        this.numeroDipendenti = numeroDipendenti;
    }
    public ArrayList<ProdottoGenerico> getProdotti() {
        return prodotti;
    }
    public void setProdotti(ArrayList<ProdottoGenerico> prodotti) {
        this.prodotti = prodotti;
    }
    
    //...addProdotto(...) - metodo che aggiunge un prodotto al contenitore “prodotti”
    public boolean addProdotto(ProdottoGenerico pg){
        if(pg == null) return false;
        return prodotti.add(pg);
    }
    
    //...removeProdotto(...) metodo che riceve in input il codice di un prodotto e lo rimuove dal contenitore “prodotti”
    public ProdottoGenerico removeProdotto(int codice){
        int pos = cercaProdotto(codice);
        if(pos == -1) return null;
        return prodotti.remove(pos);
    }
    
    private int cercaProdotto(int codice){
        for (int i = 0; i < prodotti.size(); i++) {
            if(prodotti.get(i).getCodiceProdotto() == codice) return i;
        }
        return -1;
    }
    
    //...quantitaLibri(...) metodo che restituisce la quantità di libri senza fare distinzione tra eBook e libri cartacei
    public int quantitaLibri(){
        int conta = 0;
        for (ProdottoGenerico pg : prodotti) {
            if(pg instanceof ILibro) conta++;
        }
        return conta;
    }
    
    //...quantitaLibriDigitali(...) metodo che restituisce la quantità di libri digitali
    public int quantitaLibriDigitali(){
        int conta = 0;
        for (ProdottoGenerico pg : prodotti) {
            if(pg instanceof ILibro && pg instanceof ProdottoDigitale) conta++;
        }
        return conta;
    }
    
    //...quantitaLibriCartacei(...) metodo che restituisce la quantità di libri cartacei
    public int quantitaLibriCartacei(){
        int conta = 0;
        for (ProdottoGenerico pg : prodotti) {
            if(pg instanceof ILibro && pg instanceof ProdottoMateriale) conta++;
        }
        return conta;
    }
    
    //...quantitàPerCasaEditrice(...) metodo che restituisce la quantità di libri della sola casa editrice del libro passato in input 
    // (sia eBook che cartaceo)
    public int quantitàPerCasaEditrice(ILibro il){
        int conta = 0;
        for (ProdottoGenerico pg : prodotti) {
            if(pg instanceof ILibro){
                if(((ILibro) pg).getCasaEditrice().equals(il.getCasaEditrice())){
                    conta++;
                }
            }   
        }
        return conta;
    }
    
    //...quantitaProdottiTipo(...) metodo che restituisce il numero di prodotti dello stesso tipo di 
    // un oggetto passato in input contenuti nella struttura dati.
    public int quantitaProdottiTipo(Class<?> c){
        int conta = 0;
        for (ProdottoGenerico pg : prodotti) {
            if(pg.getClass() == c) conta++;
        }
        return conta;
    }
    
    //...quantitaElettrodomestici(...) metodo che restituisce il numero di elettrodomestici contenuti nella struttura dati
    public int quantitaElettrodomestici(){
        return quantitaProdottiTipo(IElettrodomestico.class);
    }
    
    //...prodottiPiuRemunerativi(...) metodo che restituisce il prodotto o i prodotti 
    // (se sono più di uno) che forniscono un ricavo maggiore (senza sconto).
    public ArrayList<ProdottoGenerico> prodottiPiuRemunerativi(){
        ArrayList<ProdottoGenerico> lista = new ArrayList<>();
        
        if(prodotti.isEmpty()) return null;
        
        lista.add(prodotti.get(0));
        for (ProdottoGenerico p : lista) {
            
            if(p.ricavo() == lista.get(0).ricavo()){
                lista.add(p);
            }else if(p.ricavo() > lista.get(0).ricavo()){
                lista.clear();
                lista.add(p);
            }
        }
        return lista;
    }
    
    //...stampaProdottiPerPrezzo(...) - metodo che stampa a schermo i dettagli dei prodotti
    //ordinati per prezzo crescente o decrescente in base ad un valore di tipo booleano ricevuto in
    //input al metodo.
    public void stampaProdottiPerPrezzo(boolean crescente){
        Collections.sort(prodotti);
        if(!crescente) Collections.reverse(prodotti);
        
        System.out.println("Lista Prodotti:\n");
        
        for (ProdottoGenerico p : prodotti) {
            System.out.println("\n" + p.toString() + "\n");
        }
    }
    
    //...stampaProdottiDigitaliPerPrezzo(...) - metodo che stampa a schermo i dettagli dei prodotti
    //digitali ordinati per prezzo crescente o decrescente in base ad un valore di tipo booleano
    //ricevuto in input al metodo.
    public void stampaProdottiDigitaliPerPrezzo(boolean crescente){
        Collections.sort(prodotti);
        if(!crescente) Collections.reverse(prodotti);
        
        System.out.println("Lista Prodotti digitali:\n");
        
        for (ProdottoGenerico p: prodotti) {
            if(p instanceof ProdottoDigitale)System.out.println("\n" + p.toString() + "\n");
        }
    }
    
    //...stampaLibriPerTitolo(...) - metodo che stampa a schermo i dettagli dei libri ordinati per
    //titolo crescente o decrescente in base ad un valore di tipo booleano ricevuto in input al
    //metodo.
    public void stampaLibriPerTitolo(boolean crescente){
        ArrayList<ILibro> lista = listaDiLibri();
        lista.sort(new comparaTitoli());
        
        if(!crescente) Collections.reverse(lista);
        
        for (ILibro l : lista) {
            System.out.println("\n" + l.toString() + "\n");
        }
    }
    
    private ArrayList<ILibro> listaDiLibri(){
        ArrayList<ILibro> lista = new ArrayList<>();
        
        for (ProdottoGenerico p : prodotti) {
            if(p instanceof ILibro) lista.add((ILibro) p);
        }
        
        return lista;
    }
    
    private class comparaTitoli implements Comparator<ILibro>{
        @Override
        public int compare(ILibro o1, ILibro o2) {
            return o1.getTitolo().compareTo(o2.getTitolo());
        }
    }
}
