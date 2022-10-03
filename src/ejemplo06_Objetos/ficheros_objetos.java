package ejemplo06_Objetos;

import java.io.*;
import java.util.ArrayList;

public class ficheros_objetos {

    private static ArrayList<Dado> dados = new ArrayList<>();
    private static File dadosFichero= new File("dados.data");

    public static void main(String[] args) {
        crearTiradas();
        escribirTiradas();
        leerTiradas();
    }

    private static void leerTiradas() {
        try {
            FileInputStream fis = new FileInputStream(dadosFichero);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while(true){
                Dado tirada = (Dado) ois.readObject();
                System.out.printf("LA TIRADA ES -> %d %n",tirada.getTirada());
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

    private static void escribirTiradas() {
        try {
            FileOutputStream fos ;
            ObjectOutputStream ous;
            if(dadosFichero.exists()){
                ous = new MyObjectOutPutStream(fos=  new FileOutputStream(dadosFichero, true));
            }
            else {
                ous = new ObjectOutputStream(fos=  new FileOutputStream(dadosFichero));
            }
            for (Dado a:dados) {
                ous.writeObject(a);
            }
            ous.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void crearTiradas() {
        for (int i = 0; i < 1000; i++) {
            dados.add(new Dado((int)(Math.random()*Dado.CARAS+1)));
        }
    }
}
