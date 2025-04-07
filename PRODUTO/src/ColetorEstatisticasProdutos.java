public class ColetorEstatisticasProdutos {
    private ProdutoEstatistica[] produtosEst;
    private UmaVenda[] vendas;
    private double valorTotalVendido;
    private int quantidadeDeItensVendidos;
    private ProdutoEstatistica vendeuMenos;
    private ProdutoEstatistica vendeuMais;
    private ProdutoEstatistica[] maisVendidos;

    public ColetorEstatisticasProdutos() {
        produtosEst = null;
        vendas = null;
        zeraEstatisticas();
    }

    private void zeraEstatisticas() {
        valorTotalVendido = 0;
        quantidadeDeItensVendidos = 0;
        vendeuMais = null;
        vendeuMenos = null;
        maisVendidos = null;
    }

    public void coleta(Produto[] produtos, UmaVenda[] vendas) {
        // Guarda a lista de vendas
        this.vendas = vendas;
        // Se não é a primeira coleta, zera estatisticas
        if (produtosEst != null) {
            zeraEstatisticas();
        }
        // Monta o arranjo de ProdutosEstatistica
        produtosEst = new ProdutoEstatistica[produtos.length];
        for (int i = 0; i < produtos.length; i++) {
            produtosEst[i] = new ProdutoEstatistica(produtos[i]);
        }
        // Percorre o arranjo de vendas coletando as estatísticas preliminares
        for (UmaVenda umaVenda : vendas) {
            // Coleta estatísticas individuais do produto
            produtosEst[umaVenda.getProduto().getCodigo()].registraVenda(umaVenda);
            // Coleta estatísticas relativas ao conjunto de produtos
            valorTotalVendido += umaVenda.getPrecoFinal();
            quantidadeDeItensVendidos += umaVenda.getQuantidade();
        }
        // Verifica os produtos mais e menos vendidos
        this.vendeuMais = produtosEst[0];
        this.vendeuMenos = produtosEst[0];
        for (ProdutoEstatistica prodEst : produtosEst) {
            if (this.vendeuMais.getUnidadesVendidas() < prodEst.getUnidadesVendidas()) {
                this.vendeuMais = prodEst;
            }
            if (this.vendeuMenos.getUnidadesVendidas() > prodEst.getUnidadesVendidas()) {
                this.vendeuMenos = prodEst;
            }
        }
        // Verifica os 3 produtos mais vendidos (só funciona para mais de 3 produtos)
        maisVendidos = new ProdutoEstatistica[3];
        maisVendidos[0] = vendeuMais;
        maisVendidos[1] = vendeuMenos;
        maisVendidos[2] = vendeuMenos;
        for (int i = 1; i < 3; i++) {
            for (ProdutoEstatistica prodEst : produtosEst) {
                boolean usado = false;
                for (int j = 0; j < i; j++) {
                    if (maisVendidos[j].getProduto().getCodigo() == prodEst.getProduto().getCodigo()) {
                        usado = true;
                        break;
                    }
                }
                if (!usado && this.maisVendidos[i].getUnidadesVendidas() < prodEst.getUnidadesVendidas()) {
                    this.maisVendidos[i] = prodEst;
                }
            }
        }
    }

    public int getQtdadeProdutos() {
        if (produtosEst == null) {
            return 0;
        }
        return produtosEst.length;
    }

    public int getQtdadeOperacoesVenda() {
        if (vendas == null) {
            return 0;
        }
        return vendas.length;
    }

    public double getValorTotalVendido() {
        return valorTotalVendido;
    }

    public int getQuantidadeDeItensVendidos() {
        return quantidadeDeItensVendidos;
    }

    public ProdutoEstatistica[] getEstatisticaProdutos() {
        return this.produtosEst;
    }

    public ProdutoEstatistica getProdutoMaisVendido() {
        return this.vendeuMais;
    }

    public ProdutoEstatistica getProdutoMenosVendido() {
        return this.vendeuMenos;
    }

    public ProdutoEstatistica[] getMaisVendidos(){
        return maisVendidos;
    }
}
