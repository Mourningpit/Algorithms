import java.util.*;

public class Tabell {

    private Tabell() {}

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n)
    {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a,i -> i+1);

        for (int k = n-1; k > 0; k--)
        {
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }
        return a;
    }

    public static void randPerm(int[] a)
    {
        Random r = new Random();

        for (int i = a.length-1; i > 0; i++)
        {
            int k = r.nextInt(i+1);
            bytt(a,i,k);
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("invalid interval");
        }

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra+1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks(int[] a)
    {
        return maks(a,0,a.length);
    }
}
