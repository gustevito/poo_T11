import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> nomes = new ArrayList<>();

        System.out.println("\nNomes:");
        nomes.add("José Maria");
        nomes.add("Lisiane Souto");
        nomes.add("Carla Azambuja");
        nomes.add("Araon Fischman");
        nomes.add("Berenice Andrade");
        
        for(String nome:nomes){
            System.out.println(nome);
        }

        System.out.println("\nFuncionarios:");
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(100,"José Maria",120,40));
        funcionarios.add(new Funcionario(90,"Lisiane Souto",150,36));
        funcionarios.add(new Funcionario(120,"Carla Azambuja",100,40));
        funcionarios.add(new Funcionario(180,"Araon Fishman",180,30));
        funcionarios.add(new Funcionario(90,"Berenice Andrade",160,20));

        // em interfaces posso escrever um unico metodo sort e ele ordena qualquer coisa, pois é um método genérico
        Collections.sort(nome);

        for(Funcionario f:funcionarios){
            System.out.println(f.toString());
        }

        System.out.println("");


        

    }
}
