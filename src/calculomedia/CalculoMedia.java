package calculomedia;

public class CalculoMedia {
    public static double calcularMedia(double[] notas) {
        int soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        return soma / notas.length;
    }
}
