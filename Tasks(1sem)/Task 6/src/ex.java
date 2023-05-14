public class ex {
    public static int solve(int v1, int v2, int v3)
    {
       int sum = 0;
       if ((v1 >= v2) && (v1 >= v3))
       {
            if (v2 > v3)
            {
                sum = (v2 + v1);
            }
            else
            {
                sum = (v1 + v3);
            }
       }
        if ((v2 > v1) && (v2 > v3))
        {
            if (v1 > v3)
            {
                sum = (v2 + v1);
            }
            else
            {
                sum = (v2 + v3);
            }
        }
        if ((v3 > v2) && (v3 > v1))
        {
            if (v1 > v2)
            {
                sum = (v3 + v1);
            }
            else
            {
                sum = (v2 + v3);
            }
        }
        return sum;
    }
}
