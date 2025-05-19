// exceçoes verificadas
class SaldoInicialInvalidoException extends Exception {
    public SaldoInicialInvalidoException(String mensagem) {
        super(mensagem);
    }
}

class OperacaoInvalidaException extends Exception {
    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}

// exceçao nao verificada
class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}

public class ContaCorrente {
    private double saldo;

    public ContaCorrente(double saldoInicial) throws SaldoInicialInvalidoException {
        if (saldoInicial <= 0) {
            throw new SaldoInicialInvalidoException("saldo inicial não pode ser negativo ou zero");
        }
        saldo = saldoInicial;
    }

    public void deposito(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("valor de depósito deve ser positivo");
        }
        saldo += valor;
    }

    public void retirada(double valor) throws OperacaoInvalidaException {
        if (valor <= 0) {
            throw new OperacaoInvalidaException("valor de retirada deve ser positivo");
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException("saldo insuficiente para a retirada");
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}