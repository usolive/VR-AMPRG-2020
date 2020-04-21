
/**
 * <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 * La classe intSequenza:
 *  <p>
 *  Per semplicità in questa documentazione una sequenza S di numeri interi 
 *  &egrave; rappresentata da
 *  <ul> 
 *     <li> < s1 s2 s3 ... sn > </li>
 *  </ul>
 *  dove n &egrave; la dimensione della sequenza.
 *  </p>
 *  
 * 
 * @author AMPRG2009 (U. SOLITRO) 
 * @version (03-2020)
 */
public class ISequenza // implements ... ADT Sequenza di interi
{
    private static final int MAXDIM = 100;  // componente di classe: dimensione di default della struttura di supporto
    private static final int EXT = 10;      // componente di classe: dimensione di default della struttura di supporto
    private static final int MIN = 0, MAX = 1000;  // comp.i di classe: estremi dell'intervallo dei valori
    private int[] elementi;                 // componente di istanza (attributo): la sequenza degli elementi realizzata con un array
    private int dimensione;                 // componente di istanza (attributo): numero (<= length) degli elementi effettivamente presenti nella sequenza
    
    /* costruttore: sovrascrive quello di default */
    public ISequenza(){
        elementi = new int[MAXDIM];  // default = null;
        dimensione = 0;
    }
    
    /**
     * costruttore per una sequenza con nessun elemento!!!
     */
    public ISequenza(int size){
        elementi = new int[size];
        dimensione = 0;
    }
    
    /** 
     * Metodi di istanza:
     * le operazioni per gestire le sequenze orientata a oggetti
     */

     /**
     * Procedura di istanza: inizializza una sequenza gia' creata con valori causali.
     *
     * @param    S  sequenza gia' creata
     * @param  min  limite inferiore dell'intervallo di valori
     * @param  max  limite superiore dell'intervallo di valori
     * 
     * @return      (nulla) la sequenza viene inizializzata passato viene inizializzato
     */
    public void randomize(int min, int max)
    {
        /* variabili di lavoro */
        double rnd; // valore casuale
        double newrnd; // valore casuale traslato  ...
        int n;    // valore intero casuale
        /* inizializzazione */
        for (int i = 0; i <elementi.length; i++){ 
            rnd = Math.random();
            newrnd = ((max - min)*rnd) + min;
            elementi[i] = (int) newrnd;
        }
        dimensione = elementi.length;
        return;
    }    
    
    public void randomize()
    {
        randomize(MIN, MAX);
        return;
    }


    public int dim(){
        return dimensione;
    }

    public int get(int i){
        return elementi[i-1];
    }

    public void set(int i, int e){
        elementi[i-1] = e;
        return;
    }
    
    /**
     * toString
     *
     * @param   (this)  
     * @return    stringa che rappresenta la sequenza
     */
    public String toString()
    {
        int n = dim();
        String s = "< ";
        for (int i=0; i<n-1; i++){
            s += elementi[i]+", ";
        }
        if (n>0) s += elementi[n-1];
        s += " >";
        return s;
    }


    public void swap(int i, int j){
        int tmp = elementi[i-1];
        elementi[i-1] = elementi[j-1];
        elementi[j-1] = tmp;
        return;
    }

    /**
     * inflate: procedura, 
     * che espande lo spazio disponibile per la sequenza.
     * Come può essere migliorata?
     *
     * @param  -- (this) agisce sull'oggetto sequenza corrente
     * @return -- (effetto collaterale) espande l'arrau degli elementi
     */
    private void inflate(int k)
    {
        int n = elementi.length;
        int[] s = new int[n+k];
        for (int i=0; i<n; i++){
            s[i] = elementi[i];
        }
        elementi = s; // aggiornamento della struttura
        return;
    }

    
    /**
     * Procedura:
     * aggiunge un nuovo elemento in coda alla sequenza.
     * <p>
     * Trattandosi di una procedura non viene restituito alcun valore, 
     * ma la struttura viene comunque modificata (side-effect) 
     * </p>
     * 
     * @param (this) = <s1 s2 s3 ... sn>, una sequenza definita 
     * @param  e    elemento da aggiungere
     * @return      nulla
     *              (side-effect: S = < s1 s2 s3 ... sn e >, sequenza estesa)
     */
    public void add(int e)
    {
        if (elementi.length <= dimensione) inflate(EXT);
        elementi[dimensione] = e;
        dimensione = dimensione +1;
        return;
    }
    
    /**
     * sorted test: funzione
     * 
     * @param  s  sequenza (array) definita
     * @return true se:
     *            s[1] <= s[2] <= ... <= s[n]
     */
    public boolean sorted()
    {  
        boolean sorted = true; // ipotesi ottimistica
        for (int h=1; h<dimensione; h++){
            if (elementi[h-1]>elementi[h]) sorted = false;
        }
        return sorted;
    }
}