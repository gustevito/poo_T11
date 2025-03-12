public class App {
    public static void main(String[] args) throws Exception {
        LeitorProdutos lp = new LeitorProdutos();
        Produto[] produtos = lp.carregaProdutos("produtos.txt");

        for(int i = 0; i < produtos.length; i++){
            System.out.println(produtos[i].toString());
        }
    }
}
