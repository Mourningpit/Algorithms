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

        /*find largest value in an half-open interval, need change signature
        if(from < 0 || to > a.length || from >= to)
        {
          throw new IllegalArgumentException("invalid interval");
        }
        int m = from;
        int m_value = a[from];

        for(int i = 0; i < to; i++)
        {
           if(a[i] > m_value)
           {
             m = i;
             m_value = a[m];
           }
        }
        return m;
        */

        /* find largest value in closed interval, need change signature
        if()
        {}
        */
    }
}
