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


        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        String somatorioFormatado = formatoMoeda.format(somaVendas); 
        
        // contador para saber a quantidade de produtos vendidos
        int [] contadores = new int[produtos.length];
        float[] totaisVendidos = new float[produtos.length];

        System.out.println("-------------------------------"); // produtos e vendas
        for(int i = 0; i < vendas.length; i++){
            int codProduto = vendas[i].getCodigoProduto();
            contadores[codProduto] += vendas[i].getQuantidade();
            totaisVendidos[codProduto] += vendas[i].getPrecoFinal();            
        }

        for(int i = 0; i < produtos.length; i++){
            System.out.println(produtos[i].toString() + "(Qtd.: " + contadores[i] + " / Total: " + "R$" + totaisVendidos[i] + ")");
        }
        System.out.println("-------------------------------"); // somatorio + total

        System.out.println("Soma total das vendas: " + somatorioFormatado);
        System.out.println("Total de itens vendidos: " + itensVendidos);

        System.out.println("-------------------------------"); // total de unidades + valor total de cada produto   

        System.out.println();

    }
}
