package ejemplo04;

import java.io.*;

public class Escritura {
    public static void main(String[]args) {

        File destino = new File("ejemploEscritura.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(destino, true));
            for(int i =0; i<10; i++){
                bw.write("esto es la linea "+i);
                bw.newLine();
            }
            bw.close();

        }catch(IOException e){
            System.out.println("error de escritura");
        }
    }
}
