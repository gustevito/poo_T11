public class ProdutoEstatistica {
    private Produto produto;
    private int unidadesVendidas;
    private double valorTotalVendido;
    
    public ProdutoEstatistica(Produto produto){
        this.produto = produto;
        this.unidadesVendidas = 0;
        this.valorTotalVendido = 0;
    }

    public void registraVenda(UmaVenda umaVenda){
        // Se a venda não corresponde ao produto corrente, gera uma exceção
        if (this.produto.getCodigo() != umaVenda.getProduto().getCodigo()){
            throw new RuntimeException("Venda não corresponde ao produto: "+umaVenda.getProduto().getCodigo()+":"+produto.getCodigo());
        }
        // Coleta estatísticas relativas a venda
        this.unidadesVendidas += umaVenda.getQuantidade();
        this.valorTotalVendido += umaVenda.getPrecoFinal();
    }

    public Produto getProduto() {
        return produto;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public double getValorTotalVendido() {
        return valorTotalVendido;
    }
}
