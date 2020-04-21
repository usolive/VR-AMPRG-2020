// import java.lang.Math;
import java.util.Scanner;

/**
 * Write a description of class MainTest here.
 * 
 * Classe di test per gli algoritmi di ordinamento
 *
 * @author (AMPRG-2020)
 * @version (2020-03-30)
 */
public class MainTest
{
    static Scanner keyboard = new Scanner(System.in); 
    final static int DIM = 15; // dimensione della standard della sequenza
    final static int MIN = -100, MAX = 100; // estremi per la generazione di valori casuali
    
    static void print(String s){
        System.out.println(s);
    }
    
    /**
     * Testing.
     * 
     * Essenzialmente:
     * - generazione di una sequenza casuale (e visualizzazione)
     * - ordinamento (da definire)
     * - visualizzazione e controllo del risultato
     * 
     * @param  -  nulla
     * @return    nulla
     */
    public static void main()  // Ho omesso String[] args! Che succederà ...
    {
        
        // generazione di una sequenza casuale (e visualizzazione)
        ISequenza s = new ISequenza(DIM);
        s.randomize();
        print(s.toString());
        // ordinamento (da definire)
        Sort.mergeSort(s);
        // visualizzazione e controllo del risultato
        print(s.toString());
        if (true) print("ordinata");
        return;
    }
}
