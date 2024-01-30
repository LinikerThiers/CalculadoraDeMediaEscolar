import java.util.Scanner;
import calculomedia.CalculoMedia;
import condicaoaprovacao.CondicaoAprovacao;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);

        System.out.printf("--- Calculadora de Media Escolar ---\n");

        System.out.printf(
                "\nA media calculada será Ponderada ou Aritmetica?\n [1] para ponderada\n [2] para aritmerica : ");
        int ponderadaOuAritmerica = ler.nextInt();

        System.out.printf("\nInsira a quantidade de alunos: ");
        int quantidadeAlunos = ler.nextInt();

        System.out.printf("\nInsira a quantidade de notas por aluno: ");
        int quantidadeNotas = ler.nextInt();

        double[][] pesoNotas = new double[quantidadeNotas][];

        if (ponderadaOuAritmerica == 1) {
            for (int i = 0; i < quantidadeNotas; i++) {
                pesoNotas[i] = new double[quantidadeNotas];

                System.out.printf("\nInsira o peso para a nota " + (i + 1) + ": ");
                pesoNotas[i][0] = ler.nextDouble();
            }
        }

        System.out.printf("\nQual a media necessaria para a aprovacao? ");
        double mediaAprovacao = ler.nextDouble();

        System.out.printf("\nQual a media minima para a recuperacao? ");
        double mediaRecuperacao = ler.nextDouble();

        System.out.println(" ");

        double[][] alunos = new double[quantidadeAlunos][];

        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new double[quantidadeNotas];
        }

        for (int i = 0; i < alunos.length; i++) {
            for (int j = 0; j < alunos[i].length; j++) {
                System.out.printf("Digite a nota " + (j + 1) + " do aluno " + (i + 1) + ": ");
                alunos[i][j] = ler.nextDouble();
            }
        }

        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("\nNotas do Aluno " + (i + 1) + ": ");
            for (int j = 0; j < alunos[i].length; j++) {
                System.out.printf(alunos[i][j] + "  ");
            }

            double media;
            if (ponderadaOuAritmerica == 1) {
                media = CalculoMedia.calcularMediaPonderada(alunos[i], pesoNotas);
            } else {
                media = CalculoMedia.calcularMediaAritmetica(alunos[i]);
            }

            System.out.printf("\nMédia do aluno " + (i + 1) + ": " + media + "\n");
            CondicaoAprovacao.CondicaoMedia(media, mediaAprovacao, mediaRecuperacao);
        }

        ler.close();

    }
}
