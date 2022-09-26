package ejemplo01;

import java.io.File;
import java.util.Scanner;


public class listarDirectorios {
        public static Scanner leer = new Scanner(System.in);

    public static void main (String[]args){
        //lectura de ficheros segun ruta del usuario
        rutaFichero();

       // listarFicherosDirectorioAtual();

    }

    private static void rutaFichero() {
        String ruta;
        System.out.println("Dime la ruta para encontrar el fichero");
        ruta = leer.nextLine();

        File comprobar= new File(ruta);
        if (comprobar.exists())
        {
            File[] listaficheros = comprobar.listFiles();
            System.out.printf("Ficheros en el directorio actual: %d %n", listaficheros.length);

            for(int i = 0; i < listaficheros.length; i++){
                File f2 = listaficheros[i];
                System.out.printf("Nombre: %s, es fichero?:%b, es directorio?; %b %n", f2.getName(), f2.isFile(),f2.isDirectory());
            }
        }
        else
        {
            System.out.println("ruta no existe");
        }

    }

    private static void listarFicherosDirectorioAtual() {
        String dirAtual=".";
        File file = new File(dirAtual);

        String[] archivos = file.list();

        System.out.printf("Ficheros en el directorio actual %s: %d %n", file .getName(), archivos.length);

        for (String fichero: archivos)
        {
            File temp = new File(file, fichero);
            System.out.printf("Nombre: %s - File - %b - DIR: %b %n ", temp.getName(), temp.isFile(), temp.isDirectory());
        }

    }
}
