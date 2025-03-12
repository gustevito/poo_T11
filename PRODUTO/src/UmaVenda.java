import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Note que UmaVenda é uma classe imutável
public class UmaVenda{
    private int codigoProduto;
    private double precoUnitario;
    private int quantidade;
    private double desconto; 
    private double precoFinal; 
    private LocalDateTime dataHora;

    private static final DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
    
    public UmaVenda(int codigoProduto, double precoUnitario, int quantidade, double desconto, double precoFinal,
            LocalDateTime dataHora) {
        this.codigoProduto = codigoProduto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.precoFinal = precoFinal;
        this.dataHora = dataHora;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        return "[Codigo=" + codigoProduto + ", PrecoUnitario=" + precoUnitario + ", Qtdade="
                + quantidade + ", Desconto=" + desconto + ", PrecoFinal=" + precoFinal + ", DataHora=" + dataHora.format(dateformatter) + "]";
    }
}
