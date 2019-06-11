public class Max_number {

    public static void main (String[] args)
    {
        int ar[][]= {{7,8,9},{6,5,4},{3,2,1}};

        int max=ar[0][0];

        for(int i=0; i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                if(max<ar[i][j])
                {
                    max=ar[i][j];
                }
            }
        }
        System.out.println(max);


    }
}
