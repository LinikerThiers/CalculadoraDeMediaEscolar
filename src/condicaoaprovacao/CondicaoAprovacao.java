package condicaoaprovacao;

public class CondicaoAprovacao {
    public static void CondicaoMedia(double media, double mediaAprovacao, double mediaRecuperacao) {

        if (media > mediaAprovacao) {

            System.out.printf("Aluno Aprovado!\n");

        } else if (media < mediaAprovacao && media > mediaRecuperacao) {

            System.out.printf("Recuperacao!\n");

        } else {

            System.out.printf("Aluno Reprovado!\n");
        }
    }
}
