import hjelpeklasser.*;
import java.util.*;

public class Program {

    public static void main(String[] args)
    {
        /*
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);
        */

        int[] a = Tabell.randPerm(20);
        int[] b = Tabell.nestMaks(a);

        int m = b[0], nm = b[1];

        Tabell.skrivln(a);

        System.out.print("Størst "+a[nm]+" har posisjon "+m);
        System.out.println(", nest størst "+a[nm]+" har posisjon "+nm);
    }
}