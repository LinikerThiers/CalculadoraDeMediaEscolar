import java.text.DecimalFormat;
import java.util.List;

public class CalculadoraDeMedia {

    public static double calcularMediaAritmetica(List<Double> notas) {
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        double media = soma / notas.size();

        return formatarMedia(media);
    }

    public static double calcularMediaPonderada(List<Double> notas, List<Double> pesos) {
        double soma = 0;
        double somaPesos = 0;

        for(int i = 0; i < notas.size(); i++){
            soma += notas.get(i) * pesos.get(i);
            somaPesos += pesos.get(i);
        }

        double media = soma / somaPesos;
        return formatarMedia(media);
    }

    private static double formatarMedia(double media) {
        DecimalFormat formato = new DecimalFormat("#.#");
        String mediaFormatadaString = formato.format(media);
        mediaFormatadaString = mediaFormatadaString.replace(",", ".");
        return Double.parseDouble(mediaFormatadaString);
    }

    public static void verificarCondicaoMedia(double media, double mediaAprovacao, double mediaRecuperacao) {
        if(media >= mediaAprovacao){
            System.out.println("Aluno Aprovado!");
        } else if(media >= mediaRecuperacao) {
            System.out.println("Recuperação!");
        } else {
            System.out.println("Aluno Reprovado!");
        }
    }

}
