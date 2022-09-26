package ejemplo05_binarios;

import java.io.*;

public class leerFicherosBinarios {
    public static void main(String[] args) {
        File file = new File("binarios.data");
        try {
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);

            while (true){
                int numero = dis.readInt();
                System.out.printf("El numero es: %d %n", numero);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException eofException){
            System.out.println("lectura finalizada");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
