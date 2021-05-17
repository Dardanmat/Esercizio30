package informatica.esercizio30;


public abstract class ProdottoGenerico implements Comparable<ProdottoGenerico>{
    
    private float prezzoAcquisto;
    private float prezzoVendita;
    private float iva;
    private String descrizione;
    private float sconto;
    private int codiceProdotto;
    
    private static int contaProdotti = 0;

    //Costruttori
    public ProdottoGenerico(float prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = -1;
        this.iva = -1;
        this.descrizione = "Null";
        this.sconto = 0;
        this.codiceProdotto = generaCodiceProdotto();
    }
    public ProdottoGenerico(float prezzoAcquisto, float prezzoVendita) {
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.iva = -1;
        this.descrizione = "Null";
        this.sconto = 0;
        this.codiceProdotto = generaCodiceProdotto();
    }
    public ProdottoGenerico(float prezzoAcquisto, float prezzoVendita, float iva, String descrizione, float sconto) {
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.iva = iva;
        this.descrizione = descrizione;
        this.sconto = sconto;
        this.codiceProdotto = generaCodiceProdotto();
    }
    public ProdottoGenerico(ProdottoGenerico pg) {
        this.prezzoAcquisto = pg.prezzoAcquisto;
        this.prezzoVendita = pg.prezzoVendita;
        this.iva = pg.iva;
        this.descrizione = pg.descrizione;
        this.sconto = pg.sconto; 
        this.codiceProdotto = generaCodiceProdotto();
    }
    public ProdottoGenerico() {
        this.prezzoAcquisto = -1;
        this.prezzoVendita = -1;
        this.iva = -1;
        this.descrizione = "Null";
        this.sconto = 0;
        this.codiceProdotto = generaCodiceProdotto();
    }

    private static int generaCodiceProdotto(){
        contaProdotti++;
        return contaProdotti;
    }
    
    //getters and setters
    public float getPrezzoAcquisto() {
        return prezzoAcquisto;
    }
    public void setPrezzoAcquisto(float pezzoAcquisto) {
        this.prezzoAcquisto = pezzoAcquisto;
    }
    public float getPrezzoVendita() {
        return prezzoVendita;
    }
    public void setPrezzoVendita(float pezzoVendita) {
        this.prezzoVendita = pezzoVendita;
    }
    public float getIva() {
        return iva;
    }
    public void setIva(float iva) {
        this.iva = iva;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public float getSconto() {
        return sconto;
    }
    public void setSconto(float sconto) {
        this.sconto = sconto;
    }
    public int getCodiceProdotto() {
        return codiceProdotto;
    }
    public void setCodiceProdotto(int codiceProdotto) {
        this.codiceProdotto = codiceProdotto;
    }
    
    
    private float calcolaIVA(float somma){
        return somma * iva/100;
    }
    
    private float calcolaSconto(float somma, float sconto){
        return somma * sconto/100;
    }
    
    //metodo che restituisce la cifra incassata lorda (quindi iva compresa)
    public float incasso(){
        return prezzoVendita + calcolaIVA(prezzoVendita);
    }
    
    //metodo che restituisce la cifra incassata lorda (quindi iva compresa) meno lo sconto
    public float incasso(float sconto){
        float tot = calcolaSconto(prezzoVendita, sconto);
        return tot + calcolaIVA(tot);
    }
    
    //metodo che restituisce il valore ricavato dalla vendita del prodotto al netto dell’iva
    public float ricavo(){
        return prezzoVendita-prezzoAcquisto;
    }
    
    //metodo che restituisce il valore ricavato dalla vendita del prodotto al netto dell’iva e dello sconto applicato alla vendita
    public float ricavo(float sconto){
        return prezzoVendita - calcolaSconto(prezzoVendita, sconto) - prezzoAcquisto;
    }

    public String toStringInfo(){
        return "Prezzo d'acquisto: " + prezzoAcquisto + "€ + " + calcolaIVA(prezzoAcquisto) + " di iva al " + iva + "%"
                + "\nPrezzo di vendita: " + prezzoVendita + "€ + " + calcolaIVA(prezzoVendita) + " di iva al " + iva + "%"
                + "\nSconto applicato alla vendita: " + sconto + "%"
                + "\nIncasso: " + (ricavo()+calcolaIVA(ricavo())) + " di cui " + calcolaIVA(ricavo()) + " a debito iva."
                + "\nRicavo netto: " + ricavo(sconto);
    }
    
    @Override
    public String toString() {
        return "Prodotto: prodotto generico"
                + "\n" + toStringInfo();
    }

    @Override
    public int compareTo(ProdottoGenerico o) {
        if(this.prezzoVendita > o.prezzoVendita) return 1;
        if(this.prezzoVendita < o.prezzoVendita) return -1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ProdottoGenerico){
            return ((ProdottoGenerico) obj).codiceProdotto == this.codiceProdotto;
        }
        return false;
    }
    
}
