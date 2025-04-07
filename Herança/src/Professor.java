public class Professor extends Funcionario{
    private int cargaHoraria;
    
    public Professor(String matricula, String nome, String cargo, double salarioBase, int cargaHoraria){
        super(matricula, nome, cargaHoraria); // reutiliza os atributos da outra classe para nao declarar novamente
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria(){ return cargaHoraria; }

    // override (sobrescrever) o método de calculo do salario
    @Override
    public int getCargaHoraria(){
        return super.get
    }
}
