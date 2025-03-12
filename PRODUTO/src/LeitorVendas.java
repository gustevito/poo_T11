import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LeitorVendas {
    public static final int MAX_VENDAS = 100000; // carrega arquivos de até 100.000 linhas

    public static UmaVenda[] carregaVendas(String caminhoArquivoVendas){
        UmaVenda[] vendas = new UmaVenda[MAX_VENDAS]; 
        int totalLinhas = 0;

        try (var reader = Files.newBufferedReader(Path.of(caminhoArquivoVendas))) {
            String linha;
            while ((linha = reader.readLine()) != null && totalLinhas < MAX_VENDAS) {
                String[] partes = linha.split(",");

                if (partes.length < 6) {
                    System.out.println("Linha inválida: " + linha);
                    continue;
                }

                int codigoProduto = Integer.parseInt(partes[0]);
                double precoUnitario = Double.parseDouble(partes[1]);
                int quantidade = Integer.parseInt(partes[2]);
                double desconto = Double.parseDouble(partes[3]);
                double precoFinal = Double.parseDouble(partes[4]);
                // Convertendo data e hora corretamente
                String dataHoraStr = partes[5];
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
                LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, formato);

                // Criando o objeto UmaVenda e armazenando no Array
                vendas[totalLinhas] = new UmaVenda(codigoProduto, precoUnitario, quantidade, desconto, precoFinal,dataHora);

                // Atualiza o contador de linhas
                totalLinhas++;
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        return Arrays.copyOfRange(vendas, 0, totalLinhas);
    }
}
