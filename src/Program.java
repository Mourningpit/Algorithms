import java.util.*;

public class Program {

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

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
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

    public static int kostnader(int[] a)
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}
        return m;
    }

    public static void main(String[] args)
    {
    }
}