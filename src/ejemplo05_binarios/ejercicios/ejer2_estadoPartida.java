package ejemplo05_binarios.ejercicios;

import java.io.*;

public class ejer2_estadoPartida {

    private static File backUp = new File("./src/ejemplo05_binarios/ejercicios/backUP.data");

    public static void main(String[] args) {
        EstadoPartida estado = new EstadoPartida(12,4);

        guardarPartida(estado);
        EstadoPartida recuperada = recuperarPartida();

        if(recuperada!=null){
            System.out.println("Partida cargada con exito");
        }
    }

    private static EstadoPartida recuperarPartida() {
        try {
            FileInputStream fis = new FileInputStream(backUp);
            DataInputStream dis = new DataInputStream(fis);
            return new EstadoPartida(dis.readInt(),dis.readInt());
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }

    }

    private static void guardarPartida(EstadoPartida estado) {

        try {
            FileOutputStream fos = new FileOutputStream(backUp);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeInt(estado.getVidasRestantes());
            dos.writeInt(estado.getPantallaActual());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
