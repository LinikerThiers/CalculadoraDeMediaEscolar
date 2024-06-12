import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private List<Double> notas;

    public Aluno(String nome) {
        this.nome = nome;
        this.notas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void adicionarNota(double nota) {
        this.notas.add(nota);
    }
    
}
