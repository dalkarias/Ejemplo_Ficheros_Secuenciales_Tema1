package ejemplo06_Objetos.EjercicioPartidas;

import ejemplo06_Objetos.Dado;
import ejemplo06_Objetos.MyObjectOutPutStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner leer = new Scanner(System.in);
    private static ArrayList<Partida> listaPartida = new ArrayList<>();
    private static File partidasFichero = new File("./src/ejemplo06_Objetos/EjercicioPartidas/partidas.data");
    private static int opc=0;

    public static void main(String[] args) {

        do {
            opc = menu();
            leer.nextLine();
            switch (opc){
                case 1:guardarPartida();
                    break;
                case 2:mostrarPartidas();
                    break;
                case 3:eliminarPartida();
                    break;
                case 4:
                    System.out.println("Ha sido un placer");
                    break;
            }
        }while(opc!=4);
    }

    private static void eliminarPartida() {

        System.out.println("Desea borrar el fichero? si/no");
        String opc = leer.nextLine().toLowerCase().trim();
        try {
            if(opc.equals("si"))
            {
                if(partidasFichero.exists()) {
                    listaPartida.clear();
                    partidasFichero.delete();
                    System.out.println("PARTIDA BORRADA");
                }else{
                    System.out.println("NO EXISTE PARTIDA");
                }
            }
        }catch (Exception e){
            System.out.println("FALLO AL BORRAR");
        }
    }

    private static void mostrarPartidas() {
        try {
            FileInputStream fis = new FileInputStream(partidasFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                Partida par = (Partida) ois.readObject();
                System.out.println(par.toString());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch(EOFException r){

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void guardarPartida() {
        try {
            crearPartida();

            ObjectOutputStream ous;
            if(partidasFichero.exists()){
                ous = new MyObjectOutPutStream(  new FileOutputStream(partidasFichero, true));
            }
            else {
                ous = new ObjectOutputStream( new FileOutputStream(partidasFichero));
            }
            for (Partida a:listaPartida) {
                ous.writeObject(a);
            }
            ous.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void crearPartida() {
        for(int i = 0; i<10;i++){
            listaPartida.add(new Partida((int)(Math.random()*6+1),(int)(Math.random()*10+1)));
        }
    }

    private static int menu() {
        System.out.println("*******PARTIDAS******");
        System.out.println("1. Guardar Partida");
        System.out.println("2. Mostrar Partidas");
        System.out.println("3. Eliminar Ficheros Partidas");
        System.out.println("4. SALIR");

        return leer.nextInt();
    }
}
