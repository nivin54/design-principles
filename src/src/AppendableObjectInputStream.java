import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Created by aln on 19/07/14.
 */
public class AppendableObjectInputStream extends ObjectInputStream {
    public AppendableObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected void readStreamHeader() {

    }


}
