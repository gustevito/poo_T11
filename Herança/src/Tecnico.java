public class Tecnico extends Funcionario{
    int categoria;

    public Tecnico(String matricula, String nome, String cargo, double salarioBase, int categoria){
        super(matricula, nome, salarioBase);
        this.categoria = categoria;
    }

    public int getCategoria(){ return categoria; }

    // muito incompleto
    @Override
    public double getSalarioLiquido(){
        if(categoria > 3){
        return super.getSalarioLiquido();
    } return super.getSalarioLiquido();
    }
}
