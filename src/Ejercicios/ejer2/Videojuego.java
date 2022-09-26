package Ejercicios.ejer2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Videojuego {
    private static Scanner leer = new Scanner(System.in);
    private static int datosVida, datosPantalla;

    private static File archivo = new File("./src/Ejercicios/ejer2/partida.txt");
    private static EstadoPartida partida;

    public static void main (String[]args){
        try {
            guardarPartida();
            cargarPartida(archivo);
        }catch (IOException a){
            System.out.println("Error de escritura de archivo");
        }catch (Exception lectura) {
            System.out.println("Error de lectura del archivo");
        }
    }

    private static void guardarPartida() throws IOException {
       // do {
            System.out.println("Cuantas vidas tienes?");
            datosVida = leer.nextInt();
            System.out.println("En que pantalla estas?");
            datosPantalla = leer.nextInt();
            leer.nextLine();
       // }while((datosVida != 0 ) && (datosPantalla != 0));

        partida = new EstadoPartida(datosVida,datosPantalla);

        partida.guardar(partida, archivo);
    }
    private static void cargarPartida(File archivo)throws IOException {
        partida.cargar(archivo);
    }
}

