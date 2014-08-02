import java.util.HashMap;

/**
 * Created by aln on 21/07/14.
 */
public class Librarian implements Runnable {


    public Librarian(String bookName, int info, Rack obj) {
        this.bookName = bookName;
        this.info = info;
        this.obj = obj;
    }

    private String bookName;
    private int info;
    private Rack obj;

    public Librarian(int info, Rack obj) {
        this.info = info;
        this.obj = obj;
    }
    Librarian()
    {

    }
    Librarian addBook (String bookName1, Rack ob) {

        return new Librarian(bookName1, 0, ob);
    }

     Librarian provideService(Rack ob) throws InterruptedException {


        return new Librarian(1, ob);
    }

    @Override
    public void run() {
        if (info == 0) {
            obj.addBook(bookName);
        } else if (info == 1) {
            while (true) {
                obj.getBookGreaterThanThree();
            }
        }
        obj.displayResponse();


    }

}
