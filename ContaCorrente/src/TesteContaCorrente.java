public class TesteContaCorrente {
    public static void main(String[] args) {
        try {
            // criando conta com saldo válido
            ContaCorrente conta = new ContaCorrente(1000);
            
            // depósito válido
            try {
                conta.deposito(500);
            } catch (OperacaoInvalidaException e) {
                System.out.println("Erro no depósito: " + e.getMessage());
            }
            System.out.println("Saldo após depósito: " + conta.getSaldo());
            
            // tentativa de depósito inválido
            try {
                conta.deposito(-100);
            } catch (OperacaoInvalidaException e) {
                System.out.println("Erro no depósito: " + e.getMessage());
            }
            
            // retirada válida
            try {
                conta.retirada(200);
            } catch (OperacaoInvalidaException e) {
                System.out.println("Erro na retirada: " + e.getMessage());
            }
            System.out.println("Saldo após retirada: " + conta.getSaldo());
            
            // tentativa de retirada inválida (valor negativo)
            try {
                conta.retirada(-50);
            } catch (OperacaoInvalidaException e) {
                System.out.println("Erro na retirada: " + e.getMessage());
            }
            
            // tentativa de retirada com saldo insuficiente
            try {
                conta.retirada(2000);
            } catch (OperacaoInvalidaException e) {
                System.out.println("Erro na retirada: " + e.getMessage());
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro na retirada: " + e.getMessage());
            }
            
        } catch (SaldoInicialInvalidoException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
        
        // tentativa de criar conta com saldo inválido
        try {
            ContaCorrente contaInvalida = new ContaCorrente(-100);
        } catch (SaldoInicialInvalidoException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }
    }
}