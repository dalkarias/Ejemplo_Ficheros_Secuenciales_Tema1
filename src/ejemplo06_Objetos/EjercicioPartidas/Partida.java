package ejemplo06_Objetos.EjercicioPartidas;

import java.io.Serializable;

public class Partida implements Serializable {
    private int vida;
    private int pantalla;

    public Partida() {
    }

    public Partida(int vida, int pantalla) {
        this.vida = vida;
        this.pantalla = pantalla;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getPantalla() {
        return pantalla;
    }

    public void setPantalla(int pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public String toString() {
        return "vida = " + vida + "\n" +
                "pantalla = " + pantalla;
    }
}
