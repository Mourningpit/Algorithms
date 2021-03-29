package hjelpeklasser;

import eksempelklasser.*;

import java.util.*;

public class Tabell {

    private Tabell() {}

    public static <T> int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m;                 // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static <T> int binærsøk(T[] a, T verdi, Comparator<? super T> c)
    {
        return binærsøk(a,0,a.length,verdi,c);  // bruker metoden over
    }

    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;
        T maksverdi = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i].compareTo(maksverdi) > 0)
            {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static <T>
    int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (v <= h && c.compare(a[v],skilleverdi) < 0) v++;
        while (v <= h && c.compare(skilleverdi,a[h]) <= 0) h--;

        while (true)
        {
            if (v < h) Tabell.bytt(a,v++,h--); else return v;
            while (c.compare(a[v],skilleverdi) < 0) v++;
            while (c.compare(skilleverdi,a[h]) <= 0) h--;
        }
    }

    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c)
    {
        return parter(a,0,a.length-1,skilleverdi,c);  // kaller metoden over
    }

    public static <T> int sParter(T[] a, int v, int h, int k, Comparator<? super T> c)
    {
        if (v < 0 || h >= a.length || k < v || k > h) throw new
                IllegalArgumentException("Ulovlig parameterverdi");

        bytt(a,k,h);   // bytter - skilleverdien a[k] legges bakerst
        int p = parter(a,v,h-1,a[h],c);  // partisjonerer a[v:h-1]
        bytt(a,p,h);   // bytter for å få skilleverdien på rett plass

        return p;    // returnerer posisjonen til skilleverdien
    }

    public static <T>
    int sParter(T[] a, int k, Comparator<? super T> c)   // bruker hele tabellen
    {
        return sParter(a,0,a.length-1,k,c); // v = 0 og h = a.lenght-1
    }

    private static <T>
    void kvikksortering(T[] a, int v, int h, Comparator<? super T> c)
    {
        if (v >= h) return;  // hvis v = h er a[v:h] allerede sortert

        int p = sParter(a,v,h,(v + h)/2,c);
        kvikksortering(a,v,p-1,c);
        kvikksortering(a,p+1,h,c);
    }

    public static <T> void kvikksortering(T[] a, Comparator<? super T> c) // sorterer hele tabellen
    {
        kvikksortering(a,0,a.length-1,c);
    }

    private static <T> void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c)
    {
        int n = m - fra;   // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;     // løkkevariabler og indekser

        while (i < n && j < til)  // fletter b[0:n> og a[m:til>, legger
            a[k++] = c.compare(b[i],a[j]) <= 0 ? b[i++] : a[j++];  // resultatet i a[fra:til>

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    public static <T> void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;     // a[fra:til> har maks ett element

        int m = (fra + til)/2;          // midt mellom fra og til

        flettesortering(a,b,fra,m,c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til,c);   // sorterer a[m:til>

        flett(a,b,fra,m,til,c);         // fletter a[fra:m> og a[m:til>
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);
        flettesortering(a,b,0,a.length,c);  // kaller metoden over
    }

    public static <T extends Comparable<?super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            T verdi = a[i];
            int j = i - 1;

            for (;j >= 0 && verdi.compareTo(a[j]) < 0; j--)a[j + 1] = a[j];
            {
                a[j + 1] = verdi;
            }
        }
    }

    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static int sammenlign(String s1, String s2)
    {
        int n1 = s1.length();
        int n2 = s2.length();

        int n = n1 < n2 ? n1:n2;

        for (int i = 0; i < n; i++)
        {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2)
            {
                return c1 - c2;
            }
        }
        return n1 -n2;
    }

    /*
    public static <T> void bytt(T[] a, int i, int j)
    {
        T temp = a[i]; a[i] = a[j]; a[j] = temp;
    }
    */

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j)
    {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void snu(int[] a, int v, int h)
    {
        while (v < h)
        {
            bytt(a, v++, h--);
        }
    }

    public static void snu(int[] a, int v)
    {
        snu(a,v,a.length-1);
    }

    public static void snu(int[]a )
    {
        snu(a,0,a.length-1);
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];
        Arrays.setAll(a, i -> i + 1);

        Random r = new Random();

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);
            bytt(a,k,i);
        }
        return a;
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

    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length-2;

        while (i > 0 && a[i] > a[i+1])
        {
            i--;
        }
        if (i < 0 )
        {
            return false;
        }

        int j = a.length-1;

        while (a[j] < a[i])
        {
            j--;
        }

        bytt(a,i,j);
        snu(a,i+1);
        return true;
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }

    public static void utvalgssortering(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            bytt(a,i,min(a,i,a.length));
        }
    }

    public static void utvalgssortering(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til-1; i++)
        {
            bytt(a,i,min(a,i,til));
        }
    }

    public static int kostnader(int[] a)
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}
        return m;
    }

    public static int maks(double[] a)
    {
        int m = 0;
        double maksverdi = a[0];

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

    public static <T> int maks(T[] a, Comparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden nedenfor
    }

    public static <T> int maks(T[] a, int fra, int til, Comparator<? super T> c)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                // indeks til største verdi
        T maksverdi = a[fra];       // største verdi

        for (int i = fra + 1; i < til; i++)   // går gjennom intervallet
        {
            if (c.compare(a[i],maksverdi) > 0)  // bruker komparatoren
            {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdateres
            }
        }
        return m;                 // posisjonen til største verdi

    }  // maks

    public static int maks(String[] a)
    {
        int m = 0;
        String maksverdi = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i].compareTo(maksverdi) > 0)
            {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks(char[] c)
    {
        int m = 0;
        char maksverdi = c[0];

        for (int i = 1; i < c.length; i++)
        {
            if (c[i] > maksverdi)
            {
                maksverdi = c[i];
                m = i;
            }
        }
        return m;
    }

    public static int maks(Integer[] a)
    {
        int m = 0;
        Integer maksverdi = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i].compareTo(maksverdi) > 0)
            {
                maksverdi = a[i];
                m = i;
            }
        }
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

    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra;           // indeks til minste verdi i a[fra:til>
        T minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (c.compare(a[i], minverdi) < 0)
        {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static <T> int min(T[] a, Comparator<? super T> c)  // bruker hele tabellen
    {
        return min(a,0,a.length,c);     // kaller metoden over
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

    public static void skriv(Object[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        for (int i = fra; i < til; i++)
        {
            System.out.print(a[i]+" ");
        }
    }

    public static void skriv(Object[] a)
    {
        skriv(a,0,a.length);
    }

    public static void skrivln(Object[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(Object[] a)
    {
        skrivln(a,0,a.length);
    }

    public static void bytt(Object[] a,int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public class TomTabellUnntak extends RuntimeException
    {
        public TomTabellUnntak()
        {
            super();
        }

        public TomTabellUnntak(String melding)
        {
            super(melding);
        }
    }
}
