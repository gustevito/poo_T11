public class Produto {
    private int codigo;
    private String descricao;
    private double preco;
    
    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço inválido!!");
        }
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nCódigo: " + codigo + "\nDescrição: " + descricao + "\nPreço: R$" + preco;
    };

    
    
    
}
