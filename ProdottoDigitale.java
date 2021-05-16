package informatica.esercizio30;


public abstract class ProdottoDigitale extends ProdottoGenerico{
    
    private double dimensione; //dimensione in byte del file
    private String processore;
    private double ram;

    //constructors
    public ProdottoDigitale(float prezzoAcquisto, double dimensione, String processore, double ram) {
        super(prezzoAcquisto);
        this.dimensione = dimensione;
        this.processore = processore;
        this.ram = ram;
    }
    public ProdottoDigitale(float prezzoAcquisto, float prezzoVendita, double dimensione, String processore, double ram) {
        super(prezzoAcquisto, prezzoVendita);
        this.dimensione = dimensione;
        this.processore = processore;
        this.ram = ram;
    }
    public ProdottoDigitale(float prezzoAcquisto, float prezzoVendita, float iva, String descrizione, float sconto, double dimensione, String processore, double ram) {
        super(prezzoAcquisto, prezzoVendita, iva, descrizione, sconto);
        this.dimensione = dimensione;
        this.processore = processore;
        this.ram = ram;
    }
    public ProdottoDigitale(ProdottoDigitale pd) {
        super(pd);
        this.dimensione = pd.dimensione;
        this.processore = pd.processore;
        this.ram = pd.ram;
    }
    public ProdottoDigitale() {
        super();
        this.dimensione = 0;
        this.processore = "Null";
        this.ram = 0;
    }

    //getters & setters
    public double getDimensione() {
        return dimensione;
    }
    public void setDimensione(double dimensione) {
        this.dimensione = dimensione;
    }
    public String getProcessore() {
        return processore;
    }
    public void setProcessore(String processore) {
        this.processore = processore;
    }
    public double getRam() {
        return ram;
    }
    public void setRam(double ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Prodotto: prodotto digitale\n" 
                + super.toStringInfo();
    }
    
}
