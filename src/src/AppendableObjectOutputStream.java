import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Created by aln on 19/07/14.
 */
public class AppendableObjectOutputStream extends ObjectOutputStream {

    public AppendableObjectOutputStream( OutputStream out) throws IOException {
        super(out);
    }
    @Override
    protected void writeStreamHeader() throws IOException {

        reset();
    }

}
