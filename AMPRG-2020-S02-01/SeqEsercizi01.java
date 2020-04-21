
/**
 * Introduzione all'analisi degli algoritmi
 * con alcuni esercizi su sequenze (di interi)
 * realizzate direttamente con array
 *
 * @author (AMPRG-2020)
 * @version (09-03-2020)
 */
public class SeqEsercizi01 
{
    /**
     * Ricerca semplice (funzione)
     * 
     * ### Esercizio. 
     * Scrivere le specifiche.
     */
    public static int ricerca(int e, int[] a)
    {
        int l = a.length;   // dimensione fisica dell'array
        int n = -1;         // posizione dell'elemento cercato
        int i = 0;          // indice di scorrimento
        while ((i<l) & (n<0)){
            if (a[i]==e) {  // trovato!
                n = i;
            } else {        // non trovato, ancora ...
                i++;
            }
        }
        return n;
    }
    
    /**
     * Ricerca con sentinella
     * 
     * ### Esercizio. 
     * Scrivere le specifiche tenendo conto che la posizione 0 
     * non è da considerarsi parte propria della sequenza 
     */
    public static int ricercaS(int e, int[] a)
    {
        a[0] = e;
        int n = a.length; // posizione ipotetica dell'elemento
        while (a[n]==e){
            n--;
        }
        return n;
    }
}
