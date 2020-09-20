package hjelpeklasser;

import java.util.*;

public class Tabell {

    private Tabell() {}

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j)
    {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
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

    public static int kostnader(int[] a)
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}
        return m;
    }

    public static int maks1(int[] a)
    {
        if (a.length < 1)
        {
            throw new NoSuchElementException("a=0");
        }

        int m = 0;

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > a[m])
            {
                m = i;
            }
        }
        return m;
    }

    public static int maks2(int[] a)
    {
        int m = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > maksverdi)
            {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks3(int[] a)
    {
        int last = a.length-1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[last];
        a[last] = 0x7fffffff;

        for (int i = 0; ; i++)
        {
            if (a[i] >= maksverdi)
            {
                if (a[i] == last)
                {
                    a[last] = temp;
                    return temp >= maksverdi ? last : m;
                }
                else
                {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        if (a == null)
        {
            throw new NullPointerException("a == 0");
        }
        fratilKontroll(a.length, fra, til);

        /*
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("invalid interval");
        }
        */

        if (fra == til)
        {
            throw new NoSuchElementException("fra "+fra+" = til "+til+" empty interval");
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

    public static int antallMaks(int[] a)
    {
        int antall = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > maksverdi)
            {
                antall++;
                maksverdi = a[i];
            }
        }
        return antall;
    }

    public static int min(int[] a, int fra, int til)
    {
        if(fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("invalid interval");
        }
        int m = fra;
        int m_value = a[fra];

        for(int i = fra+1; i < til; i++)
        {
            if(a[i] < m_value)
            {
                m = i;
                m_value = a[m];
            }
        }
        return m;
    }

    public static int min(int[] a)
    {
        return min(a,0,a.length);
    }

    public static void skriv(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        if (til - fra > 0)
        {
            System.out.println(a[fra]);
        }
        for (int i = fra+1; i < til; i++)
        {
            System.out.println(" "+a[i]);
        }
    }
    public static void skriv(int[] a)
    {
        skriv(a,0,a.length);
    }

    public static void skriv(char[] c, int fra, int til)
    {
        fratilKontroll(c.length,fra,til);

        if (til - fra > 0)
        {
            System.out.print(" "+c[fra]);
        }
        for (int i = fra+1; i < c.length; i++)
        {
            System.out.print(" "+c[til]);
        }
    }

    public static void skriv(char[] c)
    {
        skriv(c,0,c.length);
    }

    public static void skrivln(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);
        skriv(a,0,a.length);
        System.out.println();
    }

    public static void skrivln(int[] a)
    {
        skrivln(a,0,a.length);
    }

    public static void skrivln(char[] c, int fra, int til)
    {
        fratilKontroll(c.length,fra,til);

        if (fra  - til > 0)
        {
            System.out.println(c[fra]);
        }
        for (int i = fra+1; i < c.length; i++)
        {
            System.out.println(" "+c[til]);
        }
        System.out.println();
    }
    public static void skrivln(char[] c)
    {
        skrivln(c,0,c.length);
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)
        {
            throw new ArrayIndexOutOfBoundsException("fra "+fra+" er negative!");
        }

        if (til > tablengde)
        {
            throw new ArrayIndexOutOfBoundsException("til "+til+" > "+tablengde);
        }

        if (fra > til)
        {
            throw new IllegalArgumentException("fra "+fra+" > til "+til);
        }

        if (fra == til)
        {
            throw new NoSuchElementException("fra "+fra+" = til "+til+" tomt intervall");
        }
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
        {
            throw new ArrayIndexOutOfBoundsException("v "+v+" < 0");
        }

        if (h >= tablengde)
        {
            throw new ArrayIndexOutOfBoundsException("h "+h+" >= tablengde "+tablengde);
        }

        if (v > h+1)
        {
            throw new IllegalArgumentException("v = "+v+", h = "+h);
        }
    }

    public static int[] nestMaks(int[] a)
    {
        int n = a.length;

        if (n < 2)
        {
            throw new java.util.NoSuchElementException("a.length + "+n+" < 2");
        }

        int m = Tabell.maks(a);

        int nm;

        if (m == 0)
        {
            nm = maks(a,1,n);
        }
        if(m == n-1)
        {
            nm = maks(a,0,n-1);
        }
        else
        {
            int mv = maks(a,0,m);
            int mh = maks(a,m+1,n);
            nm = a[mh] > a[mv] ? mh : mv;
        }
        return new int[]{m,nm};
    }
}
