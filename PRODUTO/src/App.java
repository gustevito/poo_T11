import java.text.NumberFormat;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        LeitorVendas lv = new LeitorVendas();
        LeitorProdutos lp = new LeitorProdutos();

        UmaVenda[] vendas = lv.carregaVendas("vendas.txt");
        Produto[] produtos = lp.carregaProdutos("produtos.txt");

        // vendas
        System.out.println("-------------------------------");
        System.out.println("Qtd. de registros de produtos: " + vendas.length);
        int somaVendas = 0;
        int itensVendidos = 0;
        for (int i = 0; i < vendas.length; i++) {
            somaVendas += vendas[i].getPrecoFinal();
            itensVendidos += vendas[i].getPrecoFinal();
        }

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        String somatorioFormatado = formatoMoeda.format(somaVendas);

        System.out.println("-------------------------------"); // PARTE 1: somatorio + total

        System.out.println("Soma total das vendas: " + somatorioFormatado);
        System.out.println("Total de itens vendidos: " + itensVendidos);

        System.out.println("-------------------------------"); // PARTE 2: total de unidades + valor total de cada produto
                                                               
        // contador para saber a quantidade de produtos vendidos
        int[] contadores = new int[produtos.length];
        float[] totaisVendidos = new float[produtos.length];
        for (int i = 0; i < vendas.length; i++) {
            int codProduto = vendas[i].getCodigoProduto();
            contadores[codProduto] += vendas[i].getQuantidade();
            totaisVendidos[codProduto] += vendas[i].getPrecoFinal();
        }

        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int produtoMenorUni = 0;
        int produtoMaiorUni = 0;
        for(int i = 0; i < produtos.length; i++){
            if (maior < contadores[i]){

                produtoMaiorUni = i;
            }
        }

        for(int i = 0; i < produtos.length; i++){
            if (menor > contadores[i]){
                produtoMenorUni = i;
            }
        }

        System.out.println("Produto que mais vendeu: " + );

        for (int i = 0; i < produtos.length; i++) {
            System.out.println(
                    produtos[i].toString() + "(Qtd.: " + contadores[i] + " / Total: " + "R$" + totaisVendidos[i] + ")");
        }
        System.out.println("-------------------------------");

    }
}
