package ejemplo05_binarios;

import java.io.*;

public class ficheros_binarios {
    public static void main(String[]args){
        //escritura de binarios en un archivo

        File file = new File("binarios.data");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);


            for (int i = 0; i < 1000; i++) {
                dos.writeInt(i);
            }
            dos.writeInt(200);
            dos.writeChars("hola mundo");
            dos.writeBoolean(true);

            dos.close();
            fos.close();
        }catch(FileNotFoundException e){
            throw new RuntimeException();
        }catch (IOException a){
            System.out.println("Error de escritura");
        }

    }
}
