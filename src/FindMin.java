public class FindMin {

    //find smallest value in an array of numbers
    public static int Minimum(int[] a)
    {

        int m = a[0];
        int m_index = 0;

        for (int i = 0; i < a.length; i++)
        {
            int value = a[i];
            int index = i;

            if (value < m)
            {
                m = value;
                m_index = index;
            }
        }
        return m;

        /*
        //find smallest value in an half-open interval, need change signature
        if(from < 0 || to > a.length || from >= to)
        {
          throw new IllegalArgumentException("invalid interval");
        }
        int m = from;
        int m_value = a[from];

        for(int i = from+1; i < to; i++)
        {
           if(a[i] < m_value)
           {
             m = i;
             m_value = a[m];
           }
        }
        return m;

         */

    }
}
