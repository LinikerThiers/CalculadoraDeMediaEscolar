package calculomedia;

import java.text.DecimalFormat;

public class CalculoMedia {
    public static double calcularMediaAritmetica(double[] notas) {

        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        DecimalFormat formato = new DecimalFormat("#.#");

        double mediaFinal = soma / notas.length;

        String mediaFormatadaString = formato.format(mediaFinal);
        mediaFormatadaString = mediaFormatadaString.replace(',', '.');

        return Double.parseDouble(mediaFormatadaString);
    }

    public static double calcularMediaPonderada(double[] notas, double[][] pesoNotas) {
        double soma = 0;
        double somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesoNotas[i][0];
            somaPesos += pesoNotas[i][0];
        }

        DecimalFormat formato = new DecimalFormat("#.#");

        double mediaFinal = soma / somaPesos;

        String mediaFormatadaString = formato.format(mediaFinal);
        mediaFormatadaString = mediaFormatadaString.replace(',', '.');

        return Double.parseDouble(mediaFormatadaString);

    }
}
