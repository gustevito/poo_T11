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

        int qtd = 0;
        int totalVendas = 0;

        for(int i = 0; i < vendas.length; i++){
            somaVendas += vendas[i].getPrecoFinal();
            itensVendidos += vendas[i].getPrecoFinal();
        }

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        String somatorioFormatado = formatoMoeda.format(somaVendas); 


        // ta tudo errado ainda kkkk mas to tentando resolver.
        System.out.println("-------------------------------"); // produtos e vendas
        for(int i = 0; i < produtos.length; i++){
            int codProduto = produtos[i].getCodigo();
                for (int j = 0; j < vendas.length; j++){
                    if (vendas[j].getCodigoProduto() == codProduto){
                        qtd += vendas[j].getQuantidade();
                    }
                } 
            System.out.println(produtos[i].toString() + "(Qtd.: " + qtd + " / Total: " + vendas[i].getPrecoFinal() + ")");
        }
        System.out.println("-------------------------------"); // somatorio + total

        System.out.println("Soma total das vendas: " + somatorioFormatado);
        System.out.println("Total de itens vendidos: " + itensVendidos);

        System.out.println("-------------------------------"); // total de unidades + valor total de cada produto   

        System.out.println();

    }
}
