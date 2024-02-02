import java.util.Scanner;
import calculomedia.CalculoMedia;
import condicaoaprovacao.CondicaoAprovacao;

public class App {
    public static void main(String[] args) throws Exception {

        int ponderadaOuAritmerica, quantidadeAlunos, quantidadeNotas;
        double mediaAprovacao, mediaRecuperacao;

        Scanner ler = new Scanner(System.in);

        System.out.printf("--- Calculadora de Media Escolar ---\n");

        System.out.printf(
                "\nA media calculada será Ponderada ou Aritmetica?\n [1] para Ponderada\n [2] para Aritmetica : ");
        ponderadaOuAritmerica = ler.nextInt();

        System.out.printf("\nInsira a quantidade de alunos: ");
        quantidadeAlunos = ler.nextInt();

        System.out.printf("\nInsira a quantidade de notas por aluno: ");
        quantidadeNotas = ler.nextInt();

        double[][] pesoNotas = new double[quantidadeNotas][];

        //Inserir peso da nota por quantidade de notas escolhidas
        if (ponderadaOuAritmerica == 1) {
            for (int i = 0; i < quantidadeNotas; i++) {
                pesoNotas[i] = new double[quantidadeNotas];

                System.out.printf("\nInsira o peso para a nota " + (i + 1) + ": ");
                pesoNotas[i][0] = ler.nextDouble();
            }
        }

        System.out.printf("\nQual a media necessaria para a aprovacao? ");
        mediaAprovacao = ler.nextDouble();

        System.out.printf("\nQual a media minima para a recuperacao? ");
        mediaRecuperacao = ler.nextDouble();

        System.out.println(" ");

        double[][] alunos = new double[quantidadeAlunos][];

        //Criando a quantidade de array escolhida pelo usuario
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new double[quantidadeNotas];
        }

        //Inserindo cada nota dos alunos 
        for (int i = 0; i < alunos.length; i++) {
            for (int j = 0; j < alunos[i].length; j++) {
                System.out.printf("Digite a nota " + (j + 1) + " do aluno " + (i + 1) + ": ");
                alunos[i][j] = ler.nextDouble();
            }
        }

        //Resultado das notas digitadas
        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("\nNotas do Aluno " + (i + 1) + ": ");
            for (int j = 0; j < alunos[i].length; j++) {
                System.out.printf(alunos[i][j] + "  ");
            }

            //Resultado da media
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
