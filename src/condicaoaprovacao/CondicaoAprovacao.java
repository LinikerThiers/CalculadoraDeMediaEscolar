package condicaoaprovacao;

public class CondicaoAprovacao {
    public static void CondicaoMedia(double mediaAprovacao, double media) {
        if (media < mediaAprovacao) {
            System.out.printf("Aluno Reprovado!\n");
        } else {
            System.out.printf("Aluno Aprovado!\n");
        }
    }
}
