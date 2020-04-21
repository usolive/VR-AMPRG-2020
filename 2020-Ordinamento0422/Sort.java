
/**
 * Algoritmi di ordinamento:
 * - Selection Sort
 * - Insertion Sort
 * - Bubble Sort (esercizio)
 * - Merge Sort
 * 
 * Nella documentazione che segue, se s è una sequenza 
 * s[i] indica l'elemento in posizione i,
 * s[h..k] è la sottosequenza degli elementi dalla posizione h alla posizione k
 * n è generalmente la dimensione effettiva della sequenza.
 * 
 * Inoltre, salvo diverso avviso, la posizione di un elemento
 * fa riferimento alle convenzioni della classe delle sequenze
 * e non degli array.
 * 
 * @author (AMPRG-2020) 
 * @version (2020-22 draft)
 */
public class Sort
{   
    /**
     * Selection Sort: procedura posMinimo 
     *
     * @param  s  sequenza (array) definita
     * @param  h  estremo inferiore per la ricerca del minimo
     * @return    p tale che s[p] = min(s[h..n])
     */
    private static int posMinimo(ISequenza s, int h)
    {
        int p = h;
        int n = s.dim();
        // s[p] = min(s[h..h]) proprietà banale
        for (int k=h+1; k<=n; k++){
            // s[p] = min(s[h..k-1]) proprietà invariante 
            if (s.get(k) < s.get(h)) p = k;
            // s[p] = min(s[h..k]) proprietà invariante        
        }
        // s[p] = min(s[h..n]) proprietà         
        return p;
    }
    
    
    /**
     * Selection Sort: procedura selectionSort
     * 
     * @param  s  sequenza (array) definita
     * @return -- effetto collaterale: s ordinata
     */
    public static void selectionSort(ISequenza s)
    {
        int n = s.dim();
        /* 
         * pre-condizione: nessuna
         * ovvero s[1..0] (sequenza vuota!) ordinata
         */
        for (int i=1; i<=n; i++){
            /*
             * s[1..i-1] ordinata <= s[i..n]
             * in altre parole, la sequenza iniziale s[1..i-1] è ordinata
             * e tutti i suoi elementi sono minori o uguali 
             * a tutti gli elementi di s[i..n]
             */
            int j = posMinimo(s,i);
            // s[j] <= s[i..n]
            s.swap(i,j);
            /*
             * s[1..i] ordinata <= s[i+1..n]
             */
        }
        /*
         * s[1..n] ordinata (<= s[n+1..n] vuota!)
         */
        return;
    }
    
    

    /**
     * Insertion Sort: procedura di inserimento ordinato 
     * 
     * @param  s  sequenza (array) definita
     *            s[1] <= s[2] <= ... <= s[h-1]
     * @param  h  posizione dell'elemento "da inserire"
     * @return -- effetto collaterale:
     *            s[1] <= s[2] <= ... <= s[h]
     */
    private static void insert(ISequenza s, int h)
    {
        // se h0 è il valore iniziale di h ...
        while ((h>1)&&(s.get(h)<s.get(h-1))){
            /*
             * proprietà invariante:
             * s[0] <= s[1] <= ... <= s[h-1]
             * e s[h] <= s[h+1] <= ... <= s[h0]
             */
            s.swap(h,h-1);
            /*
             * proprietà invariante:
             * s[0] <= s[1] <= ... <= s[h-2]
             * e s[h-1] <= s[h] <= s[h+1] <= ... <= s[h0]
             */
            h--;
            /*
             * proprietà invariante:
             * s[0] <= s[1] <= ... <= s[h-1]
             * e s[h] <= s[h+1] <= ... <= s[h0]
             */
        }
        /*
         * proprietà:
         * s[0] <= s[1] <= ... <= s[h0]
         */
        return;
    }
    
    /**
     * Insertion Sort: procedura insertionSort
     * 
     * @param  s  sequenza (array) definita
     * @return -- effetto collaterale:
     *            s[1] <= s[2] <= ... <= s[n]
     */
    public static void insertionSort(ISequenza s)
    {
        int n = s.dim();
        // s[1..1] ordinata
        for (int i=2; i<=n; i++){
            // s[1..i-1] ordinata
            insert(s,i);
            // s[1..i] ordinata
        }
        // s[1..n] ordinata
        return;
    }
    
    /**
     * bubble Sort: procedura 
     * versione ingenua, assai migliorabile
     * 
     * @param  s  sequenza (array) definita
     * @return -- effetto collaterale:
     *            s[1] <= s[2] <= ... <= s[n]
     */
    public static void bubbleSort(ISequenza s)
    {
        int n = s.dim();
        for (int h=1; h<n; h++){
            for (int i=1; i<n; i++){
                if (s.get(i+1) < s.get(i))
                    s.swap(i,i+1);
            }
            // s[1]...s[n-h] <= s[n-h+1]<=...<=s[n]
        }
        // s[1..n] ordinata
        return;
    }
    
    /*
     * Area di Lavoro
     * definita qui per "vicinanza" con gli algoritmi che la adoperano
     */

    static int[] workArea;
    
    /**
     * procedura MergeSort:
     * "bootstrap" dell'ordinamento per fusione
     */
    public static void mergeSort(ISequenza s)
    {
        int dim = s.dim();
        workArea = new int[dim];    // creazione dell'area di lavoro
        mergeSort(s, 1, dim);       // invocazione dell'ordinamento vero 
       return;
    }
    
    /**
     * procedura MergeSort
     */
    public static void mergeSort(ISequenza s, int sx, int dx)
    {
        if ((dx-sx)>0){
            int mx = (sx+dx)/2;
            mergeSort(s, sx, mx);
            mergeSort(s, mx+1, dx);
            merge(s, sx, mx, dx);
        }
        return;
    }

    /**
     * procedura Merge 
     */
    public static void merge(ISequenza s, int sx, int mx, int dx)
    {
        int h = sx;
        int k = mx+1;
        int i = 0;
        int a, b;
        while ((h<=mx) && (k<=dx)){
            a = s.get(h);
            b = s.get(k);
            if (a<b) {
                workArea[i]=a;
                h++;
            }
            else {
                workArea[i]=b;
                k++;
            }
            i++;
        }
        while (h<=mx){
            workArea[i]=s.get(h);
            h++; i++;
        }
        while (k<=dx){
            workArea[i]=s.get(k);
            k++; i++;
        }
        for (i = 0; i<dx-sx+1; i++){
            s.set(sx+i, workArea[i]);
        }
        return;
    }

}
