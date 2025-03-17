import java.text.NumberFormat;
import java.util.Locale;
public class App {
    public static void main(String[] args) throws Exception {
        LeitorVendas lv = new LeitorVendas();
        LeitorProdutos lp = new LeitorProdutos();

        UmaVenda[] vendas = lv.carregaVendas("vendas.txt");
        Produto[] produtos = lp.carregaProdutos("produtos.txt");

        // vendas
        System.out.println("Qtd. de registros de produtos: " + vendas.length);
        int somaVendas = 0;
        int itensVendidos = 0;

        for(int i = 0; i < vendas.length; i++){
            somaVendas += vendas[i].getPrecoFinal();
            itensVendidos += vendas[i].getPrecoFinal();
        }

        // formatação textual da moeda
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        String somatorioFormatado = formatoMoeda.format(somaVendas); 

        // out
        System.out.println("Soma total das vendas: " + somatorioFormatado);
        System.out.println("Total de itens vendidos: " + itensVendidos);
        
        // divisão gambiarrenta
        System.out.println("-------------------------------");

        // produtos
        for(int i = 0; i < produtos.length; i++){
            System.out.println(produtos[i].toString());
        }
    }
}
