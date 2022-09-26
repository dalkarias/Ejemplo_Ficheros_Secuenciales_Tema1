package ejemplo03;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lectura {


    public static void main(String[]args){

        // fichero de destino
        File fichero = new File("ejemploLectura.txt");

        ArrayList<String>texto = new ArrayList<>();

        try {
            FileReader leer = new FileReader(fichero);


            BufferedReader bf= new BufferedReader(leer);

            String linea=null;

            while((linea = bf.readLine() )!=null){
               texto.add(linea);
            }
            if(texto.size()>=0){
                System.out.printf("El fichero tiene %d lineas, %ndime la linea a mostrar %n", texto.size());
                Scanner scanner = new Scanner(System.in);
                int numLinea = scanner.nextInt();

                try {
                    System.out.println(texto.get(numLinea - 1));
                }
                catch (IndexOutOfBoundsException exception) {
                    System.out.println("linea inexistente");
                }

                finally{
                    bf.close();
                    leer.close();
                }
            }
            else{
                System.out.println("El fichero esta vacio");
            }

        }catch(FileNotFoundException e){
            System.out.println("el fichoro no existe");
        } catch (IOException e) {
            System.out.println("no tengo permisos para leer");
        }



    }
}
