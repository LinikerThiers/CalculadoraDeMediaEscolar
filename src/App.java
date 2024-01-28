import java.util.Scanner;
import calculomedia.CalculoMedia;
import condicaoaprovacao.CondicaoAprovacao;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner ler = new Scanner(System.in);

        System.out.printf("--- Calculadora de Media Escolar ---");

        System.out.printf("\nInsira a quantidade de alunos: ");
        int quantidadeAlunos = ler.nextInt();

        System.out.printf("\nInsira a quantidade de notas por aluno: ");
        int quantidadeNotas = ler.nextInt();

        System.out.printf("\nQual a media necessaria para a aprovacao? ");
        double mediaAprovacao = ler.nextDouble();

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

            double media = CalculoMedia.calcularMedia(alunos[i]);
            System.out.printf("\nMédia do aluno " + (i + 1) + ": " + media + "\n");
            CondicaoAprovacao.CondicaoMedia(mediaAprovacao, media);
        }

        ler.close();

    }
}
