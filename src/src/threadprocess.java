/**
 * Created by aln on 17/07/14.
 */
public class threadprocess {

    int maxPrime(int l, int r)
    {
        int MM = 0;
        for(int i = l; i <= r ; i += 1)
        {
            int k = i;
            for(int j = 2 ; j <= Math.sqrt(k); j +=1 )
                while( k%j == 0)
                {
                    k /= j;
                    MM = Math.max(MM, j);
                }
            if(k > 1)
                MM = Math.max(MM, k);
        }
        return MM;
    }

}
