import java.io.Serializable;

/**
 * Created by aln on 19/07/14.
 */
public class Customer implements Serializable {

    private String name;
    private int id;
    private transient int creditCardNo;


    private float amount;

    public Customer() {

    }
    public Customer(String namep, int idp, int creditCardNop, float amountp) {

        name = namep;
        id = idp;
        creditCardNo = creditCardNo;
        amount = amountp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", creditCardNo=" + creditCardNo +
                ", amount=" + amount +
                '}';
    }

    public void displayRecord() {
        System.out.println(toString());
    }


}
