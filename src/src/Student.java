import java.nio.file.LinkOption;

/**
 * Created by aln on 21/07/14.
 */
public class Student implements Runnable {

    public Student(Rack obj, int inFunction, String name) {
        this.obj = obj;
        this.inFunction = inFunction;
        this.name = name;
    }
    public Student()
    {

    }
    public Student(Rack obj, int inFunction)
    {
        this.obj = obj;
        this.inFunction = inFunction;
    }

    private Rack obj;
    private int inFunction;
    private String name;

    public Student getBook(String name, Rack obj) {
        return new Student(obj, 1, name);
    }

    public Student returnBook(String name, Rack obj) {
        return new Student(obj, 2, name);
    }

    public Student printBook(Rack obj) {

        return new Student(obj, 3);
    }


    @Override
    public void run() {
        if (inFunction == 1) {
            try {
                obj.getBook(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else if (inFunction == 2) {
            obj.returnBook(name);
        } else {
            obj.printBook();
        }
        obj.displayResponse();
    }
}
