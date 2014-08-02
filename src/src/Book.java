/**
 * Created by aln on 25/07/14.
 */
public class Book {

    private String name;

    public Book(String name, Integer serailName) {
        this.name = name;
        this.serailName = serailName;
    }

    private Integer serailName;

    public void setName(String name) {
        this.name = name;
    }

    public void setSerailName(Integer serailName) {
        this.serailName = serailName;
    }

    public String getName() {

        return name;
    }

    public Integer getSerailName() {
        return serailName;
    }

    Book() {

    }


}
