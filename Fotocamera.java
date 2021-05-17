package informatica.esercizio30;


public class Fotocamera 
        extends ProdottoMateriale 
        implements IProdottoElettronico{

    private int potenza;
    private int frequenzaCorrente;

    public Fotocamera(int potenza, int frequenzaCorrente, float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto) {
        super(larghezza, altezza, profondita, peso, prezzoAcquisto);
        this.potenza = potenza;
        this.frequenzaCorrente = frequenzaCorrente;
    }

    public Fotocamera(int potenza, int frequenzaCorrente, float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto, float prezzoVendita) {
        super(larghezza, altezza, profondita, peso, prezzoAcquisto, prezzoVendita);
        this.potenza = potenza;
        this.frequenzaCorrente = frequenzaCorrente;
    }

    public Fotocamera(int potenza, int frequenzaCorrente, float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto, float prezzoVendita, float iva, String descrizione, float sconto) {
        super(larghezza, altezza, profondita, peso, prezzoAcquisto, prezzoVendita, iva, descrizione, sconto);
        this.potenza = potenza;
        this.frequenzaCorrente = frequenzaCorrente;
    }

    public Fotocamera(Fotocamera f) {
        super(f);
        this.potenza = f.potenza;
        this.frequenzaCorrente = f.frequenzaCorrente;
    }

    public Fotocamera() {
        super();
        this.potenza = 0;
        this.frequenzaCorrente = 0;
    }
    
    @Override
    public int getPotenza() {
        return potenza;
    }

    @Override
    public int getFrequenzaCorrente() {
        return frequenzaCorrente;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public void setFrequenzaCorrente(int frequenzaCorrente) {
        this.frequenzaCorrente = frequenzaCorrente;
    }
}
