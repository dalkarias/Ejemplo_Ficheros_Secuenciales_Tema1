package ejemplo06_Objetos.EjercicioPartidas;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutPutStream extends ObjectOutputStream {
    public MyObjectOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException{

    }

}
