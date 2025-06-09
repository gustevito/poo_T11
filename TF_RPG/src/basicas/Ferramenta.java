package basicas;

public abstract class Ferramenta {
    private String nome;

    public Ferramenta(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract boolean usar();
}