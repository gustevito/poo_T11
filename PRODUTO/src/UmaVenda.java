import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Note que UmaVenda é uma classe imutável
public class UmaVenda{
    private Produto produto;
    private double precoUnitario;
    private int quantidade;
    private double desconto; 
    private double precoFinal; 
    private LocalDateTime dataHora;

    private static final DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm");
    
    public UmaVenda(Produto produto, double precoUnitario, int quantidade, double desconto, double precoFinal,
            LocalDateTime dataHora) {
        this.produto = produto;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.precoFinal = precoFinal;
        this.dataHora = dataHora;
    }

    public Produto getProduto() {
        return produto;
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
        return "[Codigo=" + produto.getCodigo() + ", PrecoUnitario=" + precoUnitario + ", Qtdade="
                + quantidade + ", Desconto=" + desconto + ", PrecoFinal=" + precoFinal + ", DataHora=" + dataHora.format(dateformatter) + "]";
    }
}
