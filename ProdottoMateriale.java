package informatica.esercizio30;


public abstract class ProdottoMateriale extends ProdottoGenerico{
    
    private float larghezza;
    private float altezza;
    private float profondita;
    private float peso;

    //Constructors
    public ProdottoMateriale(float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto) {
        super(prezzoAcquisto);
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.profondita = profondita;
        this.peso = peso;
    }
    public ProdottoMateriale(float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto, float prezzoVendita) {
        super(prezzoAcquisto, prezzoVendita);
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.profondita = profondita;
        this.peso = peso;
    }
    public ProdottoMateriale(float larghezza, float altezza, float profondita, float peso, float prezzoAcquisto, float prezzoVendita, float iva, String descrizione, float sconto) {
        super(prezzoAcquisto, prezzoVendita, iva, descrizione, sconto);
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.profondita = profondita;
        this.peso = peso;
    }
    public ProdottoMateriale(float larghezza, float altezza, float profondita, float peso, ProdottoMateriale pm) {
        super(pm);
        this.larghezza = pm.larghezza;
        this.altezza = pm.altezza;
        this.profondita = pm.profondita;
        this.peso = pm.peso;
    }
    public ProdottoMateriale() {
        super();
        this.larghezza = 0;
        this.altezza = 0;
        this.profondita = 0;
        this.peso = 0;
    }
    
    //getters & setters

    public float getLarghezza() {
        return larghezza;
    }
    public void setLarghezza(float larghezza) {
        this.larghezza = larghezza;
    }
    public float getAltezza() {
        return altezza;
    }
    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }
    public float getProfondita() {
        return profondita;
    }
    public void setProfondita(float profondita) {
        this.profondita = profondita;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    public float volume(){
        return larghezza * altezza * profondita;
    }
    
    public float superficieCmq(){
        return altezza * larghezza * 6; //la calcolo come se fosse un cubo
    }

    @Override
    public String toString() {
        return "Prodotto: prodotto materiale\n" 
                + super.toStringInfo();
    }
    
}
