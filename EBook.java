package informatica.esercizio30;


public class EBook extends ProdottoDigitale implements ILibro{

    private String titolo;
    private Autore autore;
    private int pagine;
    private String casaEditrice;
    private String genere;

    public EBook(String titolo, Autore autore, int pagine, String casaEditrice, String genere, float prezzoAcquisto, double dimensione, String processore, double ram) {
        super(prezzoAcquisto, dimensione, processore, ram);
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
    }

    public EBook(String titolo, Autore autore, int pagine, String casaEditrice, String genere, float prezzoAcquisto, float prezzoVendita, double dimensione, String processore, double ram) {
        super(prezzoAcquisto, prezzoVendita, dimensione, processore, ram);
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
    }

    public EBook(String titolo, Autore autore, int pagine, String casaEditrice, String genere, float prezzoAcquisto, float prezzoVendita, float iva, String descrizione, float sconto, double dimensione, String processore, double ram) {
        super(prezzoAcquisto, prezzoVendita, iva, descrizione, sconto, dimensione, processore, ram);
        this.titolo = titolo;
        this.autore = autore;
        this.pagine = pagine;
        this.casaEditrice = casaEditrice;
        this.genere = genere;
    }

    public EBook(EBook eb) {
        super(eb);
        this.titolo = eb.titolo;
        this.autore = eb.autore;
        this.pagine = eb.pagine;
        this.casaEditrice = eb.casaEditrice;
        this.genere = eb.genere;
    }

    public EBook() {
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
