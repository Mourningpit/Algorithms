public class FindMax {

    public static int Maximum(int[] a)
    {
        /*
        //find largest value using [i] as conditional
        int m = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (m < a[i])
            {
                m = a[i];
            }
        }
        return m;

         */

        //find index position of the largest value
        int m = a[0];
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] > a[m])
            {
                m = i;
            }
        }
        return m;


        /* find largest value with a temporary variable
        int m = a[0];
        for (int i = 1; i < a.length; i++)
        {
            int value = a[i];
            if (value > m)
            {
                m = value;
            }
        }
        return m;
        */
    }
}
