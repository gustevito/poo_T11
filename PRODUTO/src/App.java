import java.text.NumberFormat;
import java.util.Locale;

public class App {
    private static final String CAMINHO_ARQUIVO_PRODUTOS = "produtos.txt";
    private static final String CAMINHO_ARQUIVO_VENDAS = "vendas.txt";

    public static void main(String[] args) {
        // Carrega o arquivo de produtos 
        Produto[] produtos = LeitorProdutos.carregaProdutos(CAMINHO_ARQUIVO_PRODUTOS);
        // Carrega o arquivo de vendas
        UmaVenda[] vendas = LeitorVendas.carregaVendas(CAMINHO_ARQUIVO_VENDAS,produtos);
        // Coleta estatísticas
        ColetorEstatisticasProdutos estatisticas = new ColetorEstatisticasProdutos();
        estatisticas.coleta(produtos,vendas);
        // Exibe estatisticas
        NumberFormat formatoMonetarioBR = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        NumberFormat formatoInteiroBR = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));

        // Entrega 1
        System.out.println("Estatísticas de vendas");
        System.out.println("Tamanho do catalogo de produtos: "+formatoInteiroBR.format(estatisticas.getQtdadeProdutos()));
        System.out.println("Quantidade de operações de venda: "+formatoInteiroBR.format(estatisticas.getQtdadeOperacoesVenda()));
        System.out.println("Valor total vendido: "+formatoMonetarioBR.format(estatisticas.getValorTotalVendido()));
        System.out.println("Quantidade de itens vendidos: "+formatoInteiroBR.format(estatisticas.getQuantidadeDeItensVendidos()));
        
        // Entrega 2
        System.out.println("Estatisticas por produto: (unidades vendidas/valor total)");
        for(ProdutoEstatistica prodEst:estatisticas.getEstatisticaProdutos()){
            System.out.print("    Codigo: "+prodEst.getProduto().getCodigo());
            System.out.print(", Descricao: "+prodEst.getProduto().getDescricao());
            System.out.print(" ("+formatoInteiroBR.format(prodEst.getUnidadesVendidas()));
            System.out.println("/"+formatoMonetarioBR.format(prodEst.getValorTotalVendido())+")");
        } 
        
        // Entrega 3
        ProdutoEstatistica maisVendido = estatisticas.getProdutoMaisVendido();
        System.out.print("Produto mais vendido: "+maisVendido.getProduto().getCodigo());  
        System.out.println(", "+maisVendido.getProduto().getDescricao());
        ProdutoEstatistica menosVendido = estatisticas.getProdutoMenosVendido();
        System.out.print("Produto menos vendido: "+menosVendido.getProduto().getCodigo());  
        System.out.println(", "+menosVendido.getProduto().getDescricao());
        
        // Entrega 4
        System.out.println("Produtos mais vendidos:");
        for(ProdutoEstatistica prodEst:estatisticas.getMaisVendidos()){
            System.out.print("    "+prodEst.getProduto().getCodigo());
            System.out.println(", "+prodEst.getProduto().getDescricao());
        }
    }
}
