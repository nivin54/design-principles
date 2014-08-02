/**
 * Created by aln on 17/07/14.
 */
public class PrimeRange
{
    private int l, r;
    PrimeRange()
    {


    }
    int findit(int start, int end)
    {
        int cnt = 0, maxPrime = 0, quo = (end - start + 1) / 10;
        JavaThreads[] array = new JavaThreads[Math.min(end-start, 12)];
        for(int i = start - 1 ; i < end ; i += quo )
        {

            array[cnt] = new JavaThreads(i + 1, i + quo, String.valueOf(i) );
            try {
                array[cnt].start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException g){
                g.printStackTrace();
            }
            maxPrime = Math.max(maxPrime, array[cnt].getters());
            cnt += 1;

        }
        return maxPrime;



    }

}
