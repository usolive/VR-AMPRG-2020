
/**
 * Il Merge Sort, documentato appena un po'
 * 
 * @author (AMPRG2020) 
 * @version (2020-04 draft)
 */
public class MergeSort_doc
{

    static int[] workArea;  // Area di Lavoro
    
    /**
     * procedura MergeSort:
     * "bootstrap" dell'ordinamento per fusione
     * 
     * @param  s    una sequenza di interi completamente definita
     * @return     (nulla) la sequenza S è alla fine riordinata
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
     * 
     * @param  S    una sequenza di interi completamente definita
     * @param  sx   limite sinistro della sottosequenza da riordinare, sx>=1 
     * @param  dx   limite destro della sottosequenza da riordinare,   sx<=dx<S.dimensione
     * @return     (nulla) la sequenza S[sx..dx] è alla fine riordinata
     */
    public static void mergeSort(ISequenza s, int sx, int dx)
    {
        /* 
         * Si tratta di una procedura ricorsiva:
         * quali sono e come si trattano i casi limite?
         */
        if ((dx-sx)>0){
            int mx = (sx+dx)/2;
            mergeSort(s, sx, mx);
            mergeSort(s, mx+1, dx);
            merge(s, sx, mx, dx);
        }
        return;
    }
    

    /**
     * procedura Merge </br>
     * precondizioni: s[sx .. mx], s[mx+1 .. dx] ordinate
     * 
     * @param  s    una sequenza di interi completamente definita
     * @param  sx   limite sinistro della sottosequenza ordinata di sinistra   
     * @param  mx   limite destro della sottosequenza ordinata di sinistra
     * @param  dx   limite destro della sottosequenza ordinata di destra
     * @return     (nulla) la sequenza s[sx..dx] è alla fine riordinata
     * sx<=mx<dx
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
