/**
 * Created by aln on 17/07/14.
 */
public class JavaThreads implements Runnable {

    private Thread t;
    private String threadName;
    private int l, r;
    private static int maxValue;


    JavaThreads(int l1, int r1, String Name)
    {
        l = l1; r = r1;
        threadName = Name;


    }
    public void run() {

        threadprocess obj = new threadprocess();
        maxValue = Math.max(maxValue, obj.maxPrime(l,r));

    }

    public void start () throws InterruptedException {


        if (t == null)
        { t = new Thread (this, threadName);

            t.start ();

        }
    }
    public int getters()
    {
        return maxValue;
    }

}
