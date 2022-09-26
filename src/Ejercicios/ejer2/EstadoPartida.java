package Ejercicios.ejer2;

import java.io.*;
import java.util.ArrayList;

public class EstadoPartida {
    private int vidasRestantes;
    private int pantallaActual;


    public EstadoPartida() {
    }
    public EstadoPartida(int vidasRestantes, int pantallaActual) {
        this.vidasRestantes = vidasRestantes;
        this.pantallaActual = pantallaActual;
    }

    public int getVidasRestantes() {
        return vidasRestantes;
    }

    public void setVidasRestantes(int vidasRestantes) {
        this.vidasRestantes = vidasRestantes;
    }

    public int getPantallaActual() {
        return pantallaActual;
    }

    public void setPantallaActual(int pantallaActual) {
        this.pantallaActual = pantallaActual;
    }

    @Override
    public String toString() {
        return  "Vidas =" + vidasRestantes + "\n" +
                "Pantalla =" + pantallaActual;
    }

    public void guardar(EstadoPartida partida, File archivo)throws IOException {

        String vida = String.valueOf(partida.getVidasRestantes());
        String pantalla = String.valueOf(partida.getPantallaActual());

        BufferedWriter escritura = new BufferedWriter(new FileWriter(archivo));
        escritura.write(vida);
        escritura.newLine();
        escritura.write(pantalla);
        escritura.newLine();
        escritura.close();

    }

    public void cargar(File archivo)throws IOException {

        FileReader lectura = new FileReader(archivo);
        BufferedReader preparacionLectura = new BufferedReader(lectura);
        String linea = null;
        ArrayList<String> contenidoArchivo = new ArrayList<>();


        while((linea = preparacionLectura.readLine()) != null){
            contenidoArchivo.add(linea);
        }
        for (String a: contenidoArchivo) {
            System.out.println(a);
        }
        preparacionLectura.close();
        lectura.close();
    }
}
