import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class LeitorProdutos {
    public static final int MAX_PRODUTOS = 10000;

    public static Produto[] carregaProdutos(String caminhoArquivo) {
        Produto[] produtos = new Produto[MAX_PRODUTOS];
        int totalLinhas = 0;

        try (BufferedReader reader = Files.newBufferedReader(Path.of(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null && totalLinhas < MAX_PRODUTOS) {
                String[] partes = linha.split(",");

                if (partes.length < 3) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                int codigoProduto = Integer.parseInt(partes[0]);
                String descricao = partes[1];
                double precoUnitario = Double.parseDouble(partes[2]);

                Produto produto = new Produto(codigoProduto, descricao, precoUnitario);
                produtos[totalLinhas] = produto;
                totalLinhas++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        // Retorna um arranjo apenas com os dados lidos
        return Arrays.copyOfRange(produtos, 0, totalLinhas);
    }
}
