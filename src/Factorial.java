public class Factorial {

    public static long fak(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("n<0");
        }

        long fak = 1;

        for (int i = 2; i <= n; i++)
        {
            fak *= i;
        }
        return fak;
    }
}
