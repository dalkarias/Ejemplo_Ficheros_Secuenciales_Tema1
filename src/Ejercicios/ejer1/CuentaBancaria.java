package Ejercicios.ejer1;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Float.parseFloat;

public class CuentaBancaria {
    private static int parOimpar;
    private static float entrada,salida,totalCuenta;
    private static Random dinero = new Random();
    private static DecimalFormat formato = new DecimalFormat("#.00");
    private static ArrayList<String> listaCuenta = new ArrayList<>();
    private static int contador=0;
    private static String conversionCaracter;


    public static void main (String[]args)
    {
        // Creamos el archivo de texto
        File archivo = new File("./src/Ejercicios/ejer1/cuentaBancaria.txt");

        // ESCRITURA DEL ARCHIVO
        try {
            //preparamos el programa para escribir en dicho archivo
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            // System.out.println("Cargos en la Cuenta Abonos o Cargos");//para lectura
            // Introducimos 3 operaciones bancarias
            for(int i =0 ; i<10; i++)
            {
                parOimpar = dinero.nextInt(3);
                // System.out.println(parOimpar);
                // si es par sera una operacion de ABONO
                if(parOimpar%2==0)
                {
                    entrada = dinero.nextFloat() * 100;
                    bw.write(String.valueOf(formato.format(entrada)));
                    bw.newLine();
                    // System.out.println(formato.format(entrada)+"€");
                }
                else  // si es impar sera una operacion de CARGO
                {
                    salida = dinero.nextFloat() * 100 * (-1);
                    bw.write(String.valueOf(formato.format(salida)));
                    bw.newLine();
                    //System.out.println(formato.format(salida)+"€");
                }
            }
            bw.close();
        }
        catch (IOException e)
        {
            System.out.println("Error de escritura");
        }

        // LECTURA DEL ARCHIVO
        try {
            FileReader lectura = new FileReader(archivo);

            BufferedReader bf = new BufferedReader(lectura);

            String linea = null;

            while((linea = bf.readLine()) != null){
                listaCuenta.add(linea);
                conversionCaracter = listaCuenta.get(contador);
                // es necesario hacer la conversion por que los puntos al pasarlos a string en ficheros son "," en lo que respecta a campo numerico
                // y si no cambiamos las comas por puntos el programa es incapaz de leerlo para volver a pasar dichos strings a numeros
                conversionCaracter = conversionCaracter.replace(",",".");
                totalCuenta += parseFloat(conversionCaracter);
                contador++;
            }
            System.out.println("total cuenta -> "+ formato.format(totalCuenta) +"€");

            bf.close();
            lectura.close();

        }
        catch (IOException l){
            System.out.println("Fallo de lectura");
        }
        //cuando finalice el programa salario final de cuenta + cargos y abonos
    }


}

