public class Funcionario{
    private String matricula;
    private String nome;
    private double salarioBase;
    
    public Funcionario(String matricula, String nome, double salarioBase){
        this.matricula = matricula;
        this.nome = nome;
        this. salarioBase = salarioBase;
    }

	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getSalarioBruto() {
		return salarioBase;
	}
    
    public double getINSS(){
        return salarioBase*0.1;
    }


    public double getSalarioLiquido(){
        return salarioBase - getINSS();
    }

    public String toString() {
        String aux = "";
        aux += "Categoria: "+this.getClass().getName()+"\n";
        aux += "Matricula: "+this.getMatricula()+"\n";
        aux += "Nome: "+this.getNome()+"\n";
        aux += "Salario bruto: "+this.getSalarioBruto()+"\n";
        aux += "(-) INSS: "+this.getINSS()+"\n";
        aux += "Salario liquido: "+this.getSalarioLiquido()+"\n";
        aux += "----------";
        return aux;    
    }
}