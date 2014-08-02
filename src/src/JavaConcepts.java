import java.io.IOException;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aln on 16/07/14.
 */
public class JavaConcepts {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //Rack object = new Rack();
        MyJdbc obj = new MyJdbc();
        System.out.println(obj.getPrimaryID("nivinanton"));

        /*Librarian librarian = new Librarian();
        Student student = new Student();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(librarian.provideService(object));
        executor.execute(librarian.addBook("book1", object));
        executor.execute(librarian.addBook("book2", object));
        executor.execute(librarian.addBook("book3", object));
        executor.execute(student.getBook("book1", object));
        executor.execute(student.getBook("book1", object));
        executor.execute(student.getBook("book1", object));
        Thread.sleep(400);
        executor.execute(student.returnBook("book1", object));
        executor.shutdown();
*/
    }

}
