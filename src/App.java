import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

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

                        if (pesoNotas[i][0] < 0) {
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

                if (mediaAprovacao <= 0) {
                    System.out
                            .println("Insira um valor numérico maior do que 0. Use '.' ou ',' como separador decimal");
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

                if (mediaRecuperacao <= 0) {
                    System.out
                            .println("Insira um valor numérico maior do que 0. Use '.' ou ',' como separador decimal");
                }

            } catch (NumberFormatException e) {
                System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                ler.nextLine();
            }
        }

        System.out.println(" ");

        double[][] alunos = new double[quantidadeAlunos][];

        String[] nomesAlunos = new String[quantidadeAlunos];

        // Criando a quantidade de array escolhida pelo usuario
        for (int i = 0; i < alunos.length; i++) {

            ler.nextLine();

            // inserir o nome do aluno
            System.out.println("Digite o nome do aluno " + (i + 1) + ": ");
            nomesAlunos[i] = ler.nextLine();
            System.out.println(" ");

            alunos[i] = new double[quantidadeNotas];
        }

        System.out.println(" ");

        // Inserindo cada nota dos alunos
        for (int i = 0; i < alunos.length; i++) {
            for (int j = 0; j < alunos[i].length; j++) {
                while (true) {
                    try {
                        System.out.printf("Digite a nota " + (j + 1) + " do aluno " + nomesAlunos[i] + ": ");
                        alunos[i][j] = Double.parseDouble(ler.next().replace(',', '.'));

                        if (alunos[i][j] <= 0) {
                            System.out.println("Por favor, insira um numero maior do que 0 para a nota");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                        ler.nextLine();
                    }
                }
                System.out.println(" ");
            }
        }

        // Resultado das notas digitadas
        for (int i = 0; i < alunos.length; i++) {
            System.out.printf("\nNotas do Aluno " + nomesAlunos[i] + ": ");
            for (int j = 0; j < alunos[i].length; j++) {
                System.out.printf(alunos[i][j] + "  ");
            }

            // Resultado da media
            double media;
            if (ponderadaOuAritmerica == 1) {
                media = calcularMediaPonderada(alunos[i], pesoNotas);
            } else {
                media = calcularMediaAritmetica(alunos[i]);
            }

            System.out.printf("\nMédia do aluno " + nomesAlunos[i] + ": " + media + "\n");
            CondicaoMedia(media, mediaAprovacao, mediaRecuperacao);
        }

        ler.close();

    }

    private static void CondicaoMedia(double media, double mediaAprovacao, double mediaRecuperacao) {

        if (media >= mediaAprovacao) {

            System.out.printf("Aluno Aprovado!\n");

        } else if (media < mediaAprovacao && media >= mediaRecuperacao) {

            System.out.printf("Recuperacao!\n");

        } else {

            System.out.printf("Aluno Reprovado!\n");
        }
    }

    private static double calcularMediaAritmetica(double[] notas) {

        double soma, mediaFinal;

        soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];
        }

        DecimalFormat formato = new DecimalFormat("#.#");

        mediaFinal = soma / notas.length;

        String mediaFormatadaString = formato.format(mediaFinal);
        mediaFormatadaString = mediaFormatadaString.replace(',', '.');

        return Double.parseDouble(mediaFormatadaString);
    }

    private static double calcularMediaPonderada(double[] notas, double[][] pesoNotas) {

        double soma, somaPesos, mediaFinal;

        soma = 0;
        somaPesos = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i] * pesoNotas[i][0];
            somaPesos += pesoNotas[i][0];
        }

        DecimalFormat formato = new DecimalFormat("#.#");

        mediaFinal = soma / somaPesos;

        String mediaFormatadaString = formato.format(mediaFinal);
        mediaFormatadaString = mediaFormatadaString.replace(',', '.');

        return Double.parseDouble(mediaFormatadaString);

    }

}
