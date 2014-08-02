import java.util.HashMap;

/**
 * Created by aln on 22/07/14.
 */
public class Rack {


    public Rack() {

    }

    private String message;
    private boolean[] serialNumberAvailable = new boolean[1000];
    HashMap<Integer, Boolean> rackFind = new HashMap<Integer, Boolean>();
    HashMap<Integer, Book> rackBook = new HashMap<Integer, Book>();
    HashMap<String, Integer> requestCount = new HashMap<String, Integer>();

    public synchronized void addBook(String bookName) {


        Integer serialNumber = produceSerialNumber();
        rackFind.put(serialNumber, true);
        rackBook.put(serialNumber, new Book(bookName, serialNumber));
        System.out.println("Book as been added to library");
        notifyAll();
    }

    public int produceSerialNumber() {
        return (rackFind.size() + 1);

    }

    public Integer getBookSerial(String name) {
        for (Integer key : rackBook.keySet()) {
            if (rackBook.get(key).getName().equals(name)) {
                if (rackFind.get(key) == true)
                    return key;
            }
        }
        return -1;
    }

    public Integer getReturnBookSerial(String name) {
        for (Integer key : rackBook.keySet()) {
            if (rackBook.get(key).getName().equals(name)) {
                if (rackFind.get(key) == false)
                    return key;
            }
        }
        return -1;
    }

    public synchronized void getBook(String name) throws InterruptedException {

        Integer serialAvailable = getBookSerial(name);
        if (serialAvailable == -1)
            updateRequestCountIncrement(name);
        do {
            serialAvailable = getBookSerial(name);
            if (serialAvailable == -1) {
                notifyAll();
                wait(100);
            }

        } while (serialAvailable == -1);
        rackFind.put(serialAvailable, false);
        message = "";
        System.out.println("Book has been issued");

        notifyAll();
    }

    public synchronized void returnBook(String name) {

        int keyValue = getReturnBookSerial(name);

        if (keyValue != -1) {
            rackFind.put(keyValue, true);
            updateRequestCountDecrement(name);

        }
        System.out.println("Book has been returned");

        notifyAll();
    }

    public void printBook() {
        for (Book Bookname : rackBook.values()) {
            System.out.println(Bookname.getSerailName() + " " + Bookname.getName());

        }

    }

    public void updateRequestCountIncrement(String name) {
        if (!requestCount.containsKey(name))
            requestCount.put(name, 0);
        requestCount.put(name, (requestCount.get(name) + 1));
    }

    public void updateRequestCountDecrement(String name) {
        if (!requestCount.containsKey(name))
            requestCount.put(name, 1);
        if (requestCount.get(name) > 0)
            requestCount.put(name, (requestCount.get(name) - 1));

    }

    public synchronized void getBookGreaterThanThree() {

        message = "";
        for (String bookName : requestCount.keySet()) {
            if (requestCount.get(bookName) >= 2) {
                addBook(bookName);
                updateRequestCountDecrement(bookName);
            }
        }
        
        notifyAll();
    }

    public void displayResponse() {
        System.out.println(message);
    }
}
