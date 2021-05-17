package informatica.esercizio30;

public class LibroCartaceo extends ProdottoMateriale implements ILibro{

    private String titolo;
    private Autore autore;
    private int pagine;
    private String casaEditrice;
    private String genere;

    public LibroCartaceo(String titolo, Autore autore, int pagine, String casaEditrice, String genere, float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto) {
        super(larghezza, altezza, profondita, peso, prezzoAcquisto);
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
    }

    public LibroCartaceo(String titolo, Autore autore, int pagine, String casaEditrice, String genere, float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto, float prezzoVendita) {
        super(larghezza, altezza, profondita, peso, prezzoAcquisto, prezzoVendita);
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
    }

    public LibroCartaceo(String titolo, Autore autore, int pagine, String casaEditrice, String genere, float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto, float prezzoVendita, float iva, String descrizione, float sconto) {
        super(larghezza, altezza, profondita, peso, prezzoAcquisto, prezzoVendita, iva, descrizione, sconto);
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
    }

    public LibroCartaceo(LibroCartaceo lc) {
        super(lc);
        this.titolo = lc.titolo;
        this.autore = lc.autore;
        this.pagine = lc.pagine;
        this.casaEditrice = lc.casaEditrice;
        this.genere = lc.genere;
    }

    public LibroCartaceo() {
        super();
        this.titolo = "Null";
        this.autore = new Autore("Null", "Null");
        this.pagine = 0;
        this.casaEditrice = "Null";
        this.genere = "Null";
    }
    
    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public Autore getAutore() {
        return autore;
    }

    @Override
    public int getPagine() {
        return pagine;
    }

    @Override
    public String getCasaEditrice() {
        return casaEditrice;
    }

    @Override
    public String getGenere() {
        return genere;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public void setPagine(int pagine) {
        this.pagine = pagine;
    }

    public void setCasaEditrice(String casaEditrice) {
        this.casaEditrice = casaEditrice;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
    
}
