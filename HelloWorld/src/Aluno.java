import java.util.Arrays;

public class Aluno {
    public final int MAX_NOTAS = 3;
    private long matricula;
    private String nome;
    private float[] notas;

    public Aluno(long matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        this.notas = new float[MAX_NOTAS];
        for (int i = 0; i < MAX_NOTAS; i++) {
            notas[i] = -1;
        }
    }

    public long getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    // Os números das notas vão de 1 até MAX_NOTAS
    public void setNota(int nro, float nota) {
        if (nro < 1 || nro > MAX_NOTAS) {
            throw new IllegalArgumentException("Número da nota inválido");
        }
        if (nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("Nota inválida");
        }
        notas[nro - 1] = nota;
    }

    public float getNota(int nro) {
        if (nro < 1 || nro > MAX_NOTAS) {
            throw new IllegalArgumentException("Número da nota inválido");
        }
        return notas[nro - 1];
    }

    public boolean notasValidas() {
        for (int i = 0; i < MAX_NOTAS; i++) {
            if (notas[i] == -1) {
                return (false);
            }
        }
        return true;
    }

    public float media() {
        if (!notasValidas()) {
            throw new IllegalArgumentException("Falta informar notas");
        }
        float acum = 0.0F;
        for (int i = 0; i < MAX_NOTAS; i++) {
            acum += notas[i];
        }
        return acum / MAX_NOTAS;
    }

    public boolean aprovado(){
        return media() >= 7.0;
    }
}