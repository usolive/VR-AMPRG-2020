
/**
 * Introduzione all'analisi degli algoritmi
 * 
 * Alcuni esercizi sulle funzioni intere
 *
 * @author (AMPRG-2020)
 * @version (09-03-2020)
 */
public class IntEsercizi01 
{
    /**
     * Calcolo dell'ennesimo numero triangolare.
     * 
     * ### Esercizi.
     * 
     * 1. Scrivere le specifiche concrete.
     * 2. Il costo computazionale è determinato da
     * T(n) <= (c_0 + c_1 + 3) + 8*k
     *       =  c + 10*n ... = c +b*n  (c>0, b>0)
     * (verificare)      
     * 
     * Il costo ipotizzato delle operazioni 
     * è annotato nel commento associato alla linea
     * ed è espresso come il numero di istruzioni elementari
     * che ipoteticamente costituiscono il byte code
     * della macchina astratta/virtuale Java
     */
    public static int numTriangle(int n)  // c_0
    {
        int z = 0;         // 1
        while (n>0){       // 3
            z = z+n;       // 4
            n--;           // 1
        }
        return z;          // 2 + c_1
    }

    /**
     * Calcolo del fattoriale di n
     * 
     * ### Esercizi.
     * 
     * 1. Scrivere le specifiche concrete.
     * 2. Stimare il costo computazionale in tempo.
     */
    public static int fact(int n)
    {
        int z = 1;
        while (n>1){
            z = z*n;
            n--;
        }
        return z;
    }
    
    /**
     * Calcolo di Fibonacci, 
     * n-mo valore definito da 
     * 
     * - f_0 = 0, f_1 = 1,
     * - f_n+2 = f_n + f_n+1
     * 
     * ### Esercizi.
     * 
     * 1. Scrivere le specifiche concrete.
     * 2. Stimare il costo computazionale in tempo.
     */
    public static int fib(int n)
    {
        int u = 1, p = 0;
        int f = n;
        if (n>1) {
            while (n>1){
                f = u+p;
                p = u;
                u = f;
                n--;
            }
        }
        return f;
    }
    
    /**
     * Calcolo n-mo numero triangolare
     * (versione ricorsiva)
     * 
     * ### Esercizi.
     * 
     * 1. Scrivere le specifiche concrete.
     * 2. Stimare il costo computazionale in tempo.
     */
    public static int numTriangleR(int n)
    {
        int z = 0;
        if (n>0) {
            z = n + numTriangleR(n-1);
        }
        return z;
    }

    /**
     * Il fattoriale di n.
     * 
     * 
     * ### Esercizi.
     * 
     * 1. Scrivere le specifiche concrete.
     * 2. Stimare il costo computazionale in tempo.
     */
    public static int factR(int n)
    {
        int z = 1;
        if (n>0) {
            z = n * factR(n-1);
        }
        return z;
    }
    
    /**
     * Fibonacci: n-mo valore
     * (versione ricosiva)
     * 
     * f_0 = 0, f_1 = 1,
     * f_n+2 = f_n + f_n+1
     * 
     * 
     * ### Esercizi.
     * 
     * 1. Scrivere le specifiche concrete.
     * 2. Stimare il costo computazionale in tempo.
     */
    public static int fibR(int n)
    {        int f = n;
        if (n>1) {
            f = fibR(n-1)+fibR(n-2);
        }
        return f;
    }
}
