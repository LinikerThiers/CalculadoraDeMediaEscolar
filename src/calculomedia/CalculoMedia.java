package calculomedia;

import java.text.DecimalFormat;

public class CalculoMedia {
    public static double calcularMedia(double[] notas) {

        double soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        DecimalFormat formato = new DecimalFormat("#.#");

        double mediaFinal = soma / notas.length;

        String mediaFormatadaString = formato.format(mediaFinal);
        mediaFormatadaString = mediaFormatadaString.replace(',', '.');

        double mediaFormatada = Double.parseDouble(mediaFormatadaString);

        return mediaFormatada;
    }
}
