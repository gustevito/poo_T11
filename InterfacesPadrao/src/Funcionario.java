public class Funcionario implements Comparable<Funcionario>{
    private int matricula;
    private String nome;
    private double valorHora;
    private int cargaHorariaSemanal;

    public Funcionario(int matricula,String nome, double valorHora, int chs) {
        this.matricula = matricula;
        this.nome = nome;
        this.valorHora = valorHora;
        this.cargaHorariaSemanal = chs;
    }

    public int getMatricula(){ return matricula; }
    public String getNome() { return nome; }
    public double getValorHora() { return valorHora; }
    public int getCargaHorariaSemanal() { return cargaHorariaSemanal; };
    public double salarioLiquido(){return valorHora*cargaHorariaSemanal;}

    @Override
    public String toString() {
        return getClass()+": [matr:" + getMatricula() + ", nome:" + getNome() + ", valor hora:"
                + getValorHora() + ", CHSem:" + getCargaHorariaSemanal() +", salario liquido:" + salarioLiquido() + "]";
    }

    @Override
    public int compareTo(Funcionario o) {
        return this.getMatricula() - outro.getMatricula();
        // para comparar os nomes:
        // return this.getNome().compareTo(String nome) (n sei se ta certo)
    }
        // lógica dessa porra:
        // A > B = >0
        // A < B = <0
        // A == B = 0

    /* if(this.getMatricula > outro.getMatricula()){
            return 1;
        }
        else{
        if (this.getMatricula < outro.getMatricula()){
            return -1;
            }

            return 0;
        }
    } */
}