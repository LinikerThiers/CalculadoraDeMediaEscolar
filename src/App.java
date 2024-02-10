import java.util.Scanner;
import calculomedia.CalculoMedia;
import condicaoaprovacao.CondicaoAprovacao;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {

        int ponderadaOuAritmerica = 0;
        int quantidadeAlunos = 0;
        int quantidadeNotas = 0;
        double mediaAprovacao = 0.0;
        double mediaRecuperacao = 0.0;

        Scanner ler = new Scanner(System.in).useLocale(Locale.US);

        System.out.printf("--- Calculadora de Media Escolar ---\n");

        while (ponderadaOuAritmerica != 1 && ponderadaOuAritmerica != 2) {
            try {
                System.out.printf(
                        "\nA media calculada será Ponderada ou Aritmetica?\n [1] para Ponderada\n [2] para Aritmetica : ");
                ponderadaOuAritmerica = ler.nextInt();

                if (ponderadaOuAritmerica != 1 && ponderadaOuAritmerica != 2) {
                    System.out.println("Por favor, insira apenas os valores '1' ou '2'");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Insira o valor '1' ou '2'");
                ler.nextLine();
            }
        }

        while (quantidadeAlunos <= 0) {
            try {
                System.out.printf("\nInsira a quantidade de alunos: ");
                quantidadeAlunos = ler.nextInt();

                if (quantidadeAlunos <= 0) {
                    System.out.println("Por favor, insira um número inteiro maior do que 0");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Insira um número inteiro maior do que 0");
                ler.nextLine();
            }
        }

        while (quantidadeNotas <= 0) {
            try {
                System.out.printf("\nInsira a quantidade de notas por aluno: ");
                quantidadeNotas = ler.nextInt();

                if (quantidadeNotas <= 0) {
                    System.out.println("Por favor, insira um número inteiro maior do que 0");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Insira um número inteiro maior do que 0");
                ler.nextLine();
            }
        }

        double[][] pesoNotas = new double[quantidadeNotas][];

        // Inserir peso da nota por quantidade de notas escolhidas
        if (ponderadaOuAritmerica == 1) {
            for (int i = 0; i < quantidadeNotas; i++) {
                pesoNotas[i] = new double[quantidadeNotas];

                while (true) {
                    try {
                        System.out.println("Insira o peso para a nota " + (i + 1) + ": ");
                        // trocar a , pelo .
                        pesoNotas[i][0] = Double.parseDouble(ler.next().replace(',', '.'));
                        
                        if(pesoNotas[i][0] < 0){
                            System.out.println("Por favor, insira um número maior do que 0");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                        ler.nextLine();
                    }
                }
            }
        }

        while (mediaAprovacao <= 0) {
            try {
                System.out.printf("\nQual a media necessaria para a aprovacao? ");
                mediaAprovacao = Double.parseDouble(ler.next().replace(',', '.'));
                
                if(mediaAprovacao <= 0){
                    System.out.println("Insira um valor numérico maior do que 0. Use '.' ou ',' como separador decimal");
                }

            } catch (NumberFormatException e) {
                System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                ler.nextLine();
            }
        }

        while (mediaRecuperacao <= 0) {
            try {
                System.out.printf("\nQual a media minima para a recuperacao? ");
                mediaRecuperacao = Double.parseDouble(ler.next().replace(',', '.'));
                
                if(mediaRecuperacao <= 0){
                    System.out.println("Insira um valor numérico maior do que 0. Use '.' ou ',' como separador decimal");
                }

            } catch (NumberFormatException e) {
                System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                ler.nextLine();
            }
        }

        System.out.println(" ");

        double[][] alunos = new double[quantidadeAlunos][];

        // Criando a quantidade de array escolhida pelo usuario
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new double[quantidadeNotas];
        }

        // Inserindo cada nota dos alunos
        for (int i = 0; i < alunos.length; i++) {
            for (int j = 0; j < alunos[i].length; j++) {
                while (true) {
                    try {
                        System.out.printf("Digite a nota " + (j + 1) + " do aluno " + (i + 1) + ": ");
                        alunos[i][j] = Double.parseDouble(ler.next().replace(',', '.'));
                        
                        if(alunos[i][j] <= 0){
                            System.out.println("Por favor, insira um numero maior do que 0 para a nota");
                        }else{
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                        ler.nextLine();
                    }
                }
            }
        }

        // Resultado das notas digitadas
        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("\nNotas do Aluno " + (i + 1) + ": ");
            for (int j = 0; j < alunos[i].length; j++) {
                System.out.printf(alunos[i][j] + "  ");
            }

            // Resultado da media
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
