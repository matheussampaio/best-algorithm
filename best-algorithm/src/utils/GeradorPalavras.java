package utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class GeradorPalavras {

    public static void main(String[] args) throws FileNotFoundException,
            UnsupportedEncodingException {

        final int minValue = 65; // 91 sao simbolos
        final int maxValue = 91;

        PrintWriter writer = new PrintWriter("consulta_dict.txt", "UTF-8");

        Random gerador = new Random();
        Random geradorP = new Random();

        System.out.println("Starting....");

        System.out.println("Running");

        for (int i = 0; i < 7000000; i++) {
            int numero = gerador.nextInt(26) + minValue;
            int numero2 = gerador.nextInt(26) + minValue;
            int numero3 = gerador.nextInt(26) + minValue;
            int numero4 = gerador.nextInt(26) + minValue;
            int numero5 = gerador.nextInt(26) + minValue;
            int numero6 = gerador.nextInt(26) + minValue;
            int numero7 = gerador.nextInt(26) + minValue;
            int palavra = geradorP.nextInt(7) + 1;
            if (palavra == 3) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3);
            } else if (palavra == 4) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4);
            } else if (palavra == 5) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4 + ""
                        + (char) numero5);
            } else if (palavra == 6) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4 + ""
                        + (char) numero5 + "" + (char) numero6);
            } else {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4 + ""
                        + (char) numero5 + "" + (char) numero6 + ""
                        + (char) numero7);
            }
        }
        writer.close();

        System.out.println("Done!");

    }
}
