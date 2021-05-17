package informatica.esercizio30;

public class Frigorifero 
        extends ProdottoMateriale
        implements IProdottoElettronico, IElettrodomestico{

    private int potenza;
    private int frequenzaCorrente;
    private String categoriaEnergetica;
    
    @Override
    public int getPotenza() {
        return potenza;
    }

    @Override
    public int getFrequenzaCorrente() {
        return frequenzaCorrente;
    }

    @Override
    public String getCategoriaEnergetica() {
        return categoriaEnergetica;
    }

    @Override
    public boolean daIncasso() {
        return super.ricavo() > 0;
    }

    public void setPotenza(int potenza) {
        this.potenza = potenza;
    }

    public void setFrequenzaCorrente(int frequenzaCorrente) {
        this.frequenzaCorrente = frequenzaCorrente;
    }

    public void setCategoriaEnergetica(String categoriaEnergetica) {
        this.categoriaEnergetica = categoriaEnergetica;
    }
    
}
