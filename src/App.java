import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("--- Calculadora de Media Escolar ---");

        int tipoMedia = lerTipoMedia(ler);
        int quantidadeAlunos = lerQuantidade("alunos", ler);
        int quantidadeNotas = lerQuantidade("notas por aluno", ler);
        
        List<Double> pesos = null;
        if (tipoMedia == 1) {
            pesos = lerPesos(quantidadeNotas, ler);
        }

        double mediaAprovacao = lerMedia("Qual a media necessaria para a aprovacao?", ler);
        double mediaRecuperacao = lerMedia("Qual a media minima para a recuperacao?", ler);

        List<Aluno> alunos = new ArrayList<>();
        for (int i = 0; i < quantidadeAlunos; i++) {
            ler.nextLine();
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            String nome = ler.nextLine();
            Aluno aluno = new Aluno(nome);
            for (int j = 0; j < quantidadeNotas; j++) {
                aluno.adicionarNota(lerNota("Digite a nota " + (j + 1) + " do aluno " + nome + ": ", ler));
            }
            alunos.add(aluno);
        }

        for (Aluno aluno : alunos) {
            double media = (tipoMedia == 1)
                    ? CalculadoraDeMedia.calcularMediaPonderada(aluno.getNotas(), pesos)
                    : CalculadoraDeMedia.calcularMediaAritmetica(aluno.getNotas());
            System.out.println("\nNotas do Aluno " + aluno.getNome() + ":");
            for (double nota : aluno.getNotas()) {
                System.out.print(nota + ", ");
            }
            System.out.println("\nMédia do aluno " + aluno.getNome() + ": " + media);
            CalculadoraDeMedia.verificarCondicaoMedia(media, mediaAprovacao, mediaRecuperacao);
        }

        ler.close();
    }

    private static int lerTipoMedia(Scanner ler){
        int tipoMedia = 0;
        while(tipoMedia != 1 && tipoMedia != 2) {
            try {
                System.out.print("\nA media calculada será Ponderada ou Aritmetica?\n [1] para Ponderada\n [2] para Aritmetica: ");
                tipoMedia = ler.nextInt();
                if (tipoMedia != 1 && tipoMedia != 2) {
                    System.out.println("Por favor, insira apenas os valores '1' ou '2'");
                } 
            } catch(java.util.InputMismatchException e) {
                System.out.println("Insira o valor '1' ou '2'");
                ler.nextLine();
            }
        }
        return tipoMedia;
    }

    private static int lerQuantidade(String tipo, Scanner ler){
        int quantidade = 0;
        while(quantidade <= 0){
            try {
                System.out.print("\nInsira a quantidade de " + tipo + ": ");
                quantidade = ler.nextInt();
                if (quantidade <= 0) {
                    System.out.println("Por favor, insira um número inteiro maior do que 0");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Insira um número inteiro maior do que 0");
                ler.nextLine();
            }
        }
        return quantidade;
    }

    private static List<Double> lerPesos(int quantidadeNotas, Scanner ler){
        List<Double> pesos = new ArrayList<>();
        for (int i = 0; i < quantidadeNotas; i++) {
            while (true) {
                try {
                    System.out.print("Insira o peso para a nota " + (i + 1) + ": ");
                    double peso = Double.parseDouble(ler.next().replace(',', '.'));
                    if (peso < 0) {
                        System.out.println("Por favor, insira um número maior do que 0");
                    } else {
                        pesos.add(peso);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                    ler.nextLine();
                }
            }
        }
        return pesos;
    }

    private static double lerNota(String mensagem, Scanner ler) {
        double nota = 0;
        while (true) {
            try {
                System.out.print(mensagem);
                nota = Double.parseDouble(ler.next().replace(',', '.'));
                if (nota <= 0) {
                    System.out.println("Por favor, insira um número maior do que 0 para a nota");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                ler.nextLine();
            }
        }
        return nota;
    }

    private static double lerMedia(String mensagem, Scanner ler) {
        double media = 0;
        while (media <= 0) {
            try {
                System.out.print("\n" + mensagem + " ");
                media = Double.parseDouble(ler.next().replace(',', '.'));
                if (media <= 0) {
                    System.out.println("Insira um valor numérico maior do que 0. Use '.' ou ',' como separador decimal");
                }
            } catch (NumberFormatException e) {
                System.out.println("Utilize valores numéricos. Use '.' ou ',' como separador decimal");
                ler.nextLine();
            }
        }
        return media;
    }

}
