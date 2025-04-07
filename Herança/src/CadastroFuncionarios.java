import java.util.ArrayList;

public class CadastroFuncionarios{
    private ArrayList<Funcionario> funcionarios;

    private void carregaFuncionarios(){
        funcionarios.add(new Funcionario("A3212","Huguinho Pato","Tecnico",1890.0));
        funcionarios.add(new Funcionario("A3312","Zezinho Pato","Tecnico",3720.0));
        funcionarios.add(new Funcionario("A3412","Luizinho Pato","Professor",8940.0));
        funcionarios.add(new Funcionario("B9931","Lala Pata","Tecnico",4220.0));
        funcionarios.add(new Funcionario("B9932","Lele Pata","Professor",1283.0));
        funcionarios.add(new Funcionario("B9933","Lili Pata","Professor",12438.0));
    }

    public CadastroFuncionarios(){
        funcionarios = new ArrayList<>();
        carregaFuncionarios();
    }

    public void cadastraFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public Funcionario recuperaPorMatricula(String matricula){
        for(Funcionario func:funcionarios){
            if (func.getMatricula().equals(matricula)){
                return func;
            }
        }
        return null;
    }
}