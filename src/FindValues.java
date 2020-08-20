public class FindValues {

    public static int findMax(int[] a) {

        //use whatever method to demonstrate desired effect, uncomment lines as required

        /* // find index position of the largest value
        int m = 0;
        for (int i = 1; i < a.length; i++)
        {
            if (a[i] > a[m]) {
                m = i;
            }
        }
        return m;
        */

        /* //find largest value with temp
        int m = a[0];
        for (int i = 1; i < a.length; i++)
        {
            int verdi = a[i];
            if (verdi > m)
            {
                m = verdi;
            }
        }
        return m;
        */

        //find largest value [i] as conditional
        int m = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (m < a[i])
            {
                m = a[i];
            }
        }
        return m;
    }

    public static void main(String...args)
    {
        int[] val = {1,2,3,4,5,6};

        System.out.println(findMax(val));
    }

}

