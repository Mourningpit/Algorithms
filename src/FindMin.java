public class FindMin {

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
        return m_index;
    }
}
