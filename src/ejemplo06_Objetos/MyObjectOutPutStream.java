package ejemplo06_Objetos;

import java.io.*;

public class MyObjectOutPutStream extends ObjectOutputStream {


    public MyObjectOutPutStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader() throws IOException{

    }
}
