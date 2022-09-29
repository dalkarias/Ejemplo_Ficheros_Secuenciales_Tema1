package ejemplo05_binarios.ejercicios;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

public class ejer1_cargosBancarios {
    public static void main(String[] args) {
        File archivo = new File("./src/ejemplo05_binarios/ejercicios/cuenta.data");

        float entrada, salida, total=0;
        int parOimpar;
        Random dinero = new Random();
        DecimalFormat formato = new DecimalFormat("#.00");
        String conversion = null,resultado;

        conversion.replace(",",".");

        try {
            FileOutputStream preparacion = new FileOutputStream(archivo);
            DataOutputStream acceso = new DataOutputStream(preparacion);

            for (int i = 0; i < 10; i++) {
                parOimpar = dinero.nextInt(3);
                // System.out.println(parOimpar);
                // si es par sera una operacion de ABONO
                if (parOimpar % 2 == 0) {
                    entrada = dinero.nextFloat() * 100;
                    acceso.writeFloat(Float.parseFloat(formato.format(entrada)));

                    // System.out.println(formato.format(entrada)+"€");
                } else  // si es impar sera una operacion de CARGO
                {
                    salida = dinero.nextFloat() * 100 * (-1);
                    acceso.writeFloat(Float.parseFloat((formato.format(salida))));

                    //System.out.println(formato.format(salida)+"€");
                }
            }

            acceso.close();
            preparacion.close();

            FileInputStream preparacionLectura = new FileInputStream(archivo);
            DataInputStream lectura = new DataInputStream(preparacionLectura);

            while (true) {
                int numero = lectura.readInt();
                int numeroFinalizado;

                System.out.println("El numero es:"+ (total += (numeroFinalizado=(numero= Integer.parseInt((conversion))) )));

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) { // esta excepcion va antes  que la de IO
            System.out.println("EXPLOSION CONTROLADA");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}