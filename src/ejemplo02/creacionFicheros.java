package ejemplo02;

import java.io.File;
import java.io.IOException;

public class creacionFicheros {

    public static void main(String[]args){
        //como crear una nueva carpeta -> pruebas
        File directorio = new File("pruebas");
        directorio.mkdir();

        File f1 = new File(directorio, "f1.txt");
        File f2 = new File(directorio, "f2.txt");

        try {
            boolean f1Created = f1.createNewFile();
            boolean f2Created = f2.createNewFile();

            if(f1Created){
                System.out.println("Fichero 1 creado");
            }
            else{
                System.out.println("Fichero 1 NO");
            }

            if(f2Created){
                System.out.println("Fichero 2 creado");
            }
            else{
                System.out.println("Fichero 2 NO");
            }

            // RENOMBRAR FICHEROS

            if(f1Created){
               boolean renombrado =  f1.renameTo(new File(directorio,"f1new.txt"));
               if (renombrado){
                   System.out.println("Fichero Renombrado");
               }
               else{
                   System.out.println("Fichero no a sido posible renombrado");
               }
            }

            //borrar ficheros o directorios
            //para borrar directorios deben de estar vacios

            boolean borrado = f2.delete();

            if(borrado){
                System.out.println("Fichero borrado");
            }
            else
            {
                System.out.println("Fichero aun en acción");
            }

            

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
