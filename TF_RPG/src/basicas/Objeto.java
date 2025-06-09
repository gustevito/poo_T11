package basicas;

public abstract class Objeto {
    private String nome;
    private String descricaoAntesAcao;
    private String descricaoDepoisAcao;
    private boolean acaoOk;

    public Objeto(String nome, String descricaoAntesAcao, String descricaoDepoisAcao) {
        this.nome = nome;
        this.descricaoAntesAcao = descricaoAntesAcao;
        this.descricaoDepoisAcao = descricaoDepoisAcao;
        this.acaoOk = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAcaoOk() {
        return acaoOk;
    }

    public void setAcaoOk(boolean acaoOk) {
        this.acaoOk = acaoOk;
    }

    public String getDescricao() {
        return acaoOk ? descricaoDepoisAcao : descricaoAntesAcao;
    }

    public abstract boolean usar(Ferramenta ferramenta);
}