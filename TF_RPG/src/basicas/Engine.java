package basicas;

import java.util.Scanner;

public abstract class Engine {
    private Ferramenta mochila;
    private Sala salaCorrente;
    private boolean fim;

    public Engine() {
        this.mochila = null;
        this.salaCorrente = null;
        this.fim = false;
        criaCenario();
    }

    public Ferramenta getMochila() {
        return mochila;
    }

    public void setMochila(Ferramenta ferramenta) {
        this.mochila = ferramenta;
    }

    public Sala getSalaCorrente() {
        return salaCorrente;
    }

    public void setSalaCorrente(Sala sala) {
        this.salaCorrente = sala;
    }

    public void indicaFimDeJogo() {
        this.fim = true;
    }

    public abstract void criaCenario();

    public void joga() {
        Scanner scanner = new Scanner(System.in);
        while (!fim) {
            System.out.println("-------------------------");
            System.out.println(salaCorrente.textoDescricao());
            System.out.print("O que você deseja fazer? ");
            String acao = scanner.nextLine();
            String[] tokens = acao.split(" ");
            switch (tokens[0]) {
                case "fim":
                    fim = true;
                    break;
                case "pega":
                    if (salaCorrente.pega(tokens[1])) {
                        System.out.println("Ok! " + tokens[1] + " guardado!");
                    } else {
                        System.out.println("Objeto " + tokens[1] + " não encontrado.");
                    }
                    break;
                case "inventario":
                    System.out.println("Ferramenta disponível para ser usada: " + (mochila != null ? mochila.getNome() : "Nenhuma"));
                    break;
                case "usa":
                    if (salaCorrente.usa(tokens[1])) {
                        System.out.println("Feito!!");
                        if (fim) {
                            System.out.println("Parabéns, você venceu!");
                        }
                    } else {
                        System.out.println("Não é possível usar " + tokens[1] + " nesta sala");
                    }
                    break;
                case "sai":
                    Sala novaSala = salaCorrente.sai(tokens[1]);
                    if (novaSala == null) {
                        System.out.println("Sala desconhecida ...");
                    } else {
                        salaCorrente = novaSala;
                    }
                    break;
                default:
                    System.out.println("Comando desconhecido: " + tokens[0]);
                    break;
            }
        }
        System.out.println("Jogo encerrado!");
        scanner.close();
    }
}