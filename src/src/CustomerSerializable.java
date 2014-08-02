import java.io.*;

/**
 * Created by aln on 19/07/14.
 */
public class CustomerSerializable {

    public void writeDataTOFile(String name, int id, int creditCardNo, float amount) {
        Customer objectCus = new Customer(name, id, creditCardNo, amount);
        File fileName = new File("/Users/aln/Documents/Eclipse/JavaConcepts/src/Customer.ser");
        try {

            if (fileName.exists() == false) {
                fileName.createNewFile();
                FileOutputStream fOut = new FileOutputStream(fileName, true);
                ObjectOutputStream outObject = new ObjectOutputStream(fOut);
                outObject.writeObject(objectCus);
                fOut.close();
                outObject.close();

            } else {
                FileOutputStream fOut = new FileOutputStream(fileName, true);
                AppendableObjectOutputStream outObject = new AppendableObjectOutputStream(fOut);
                outObject.writeObject(objectCus);
                fOut.close();
                outObject.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readDataFromFile() throws IOException, ClassNotFoundException {
        Customer objectCus;
        FileInputStream fIn = new FileInputStream("/Users/aln/Documents/Eclipse/JavaConcepts/src/Customer.ser");
        ObjectInputStream inObject = new ObjectInputStream(fIn);
        objectCus = (Customer) inObject.readObject();
        AppendableObjectInputStream appInObject = new AppendableObjectInputStream(fIn);
        try {
            while ((objectCus = (Customer) appInObject.readObject()) != null) {
                objectCus.displayRecord();
            }
        } catch (EOFException i) {
            System.out.println("Reached End oF FIle");
        }
    }


}
