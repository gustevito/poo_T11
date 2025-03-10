class Turma{
    private int numero;
    private String professor;
    private int vagas;
    private Aluno[] alunos;
    private int qtdadeAlunos;

    public Turma(int nro, String nomeProf, int vagas){
        if (nro<=0 || nomeProf.length() < 2 || vagas <=0){
            throw new IllegalArgumentException("Valor inválido");
        }
        this.numero = nro;
        this.professor = nomeProf;
        this.vagas = vagas;
        this.alunos = new Aluno[vagas];
        this.qtdadeAlunos = 0;
    }

    public void novoAluno(Aluno aluno){
        if (qtdadeAlunos == vagas){
            throw new IllegalStateException("Turma cheia!");
        }
        alunos[qtdadeAlunos] = aluno;
        qtdadeAlunos++;
    }


    // encontrar aluno pela matricula
    public Aluno getAluno(int matricula){
        for(int i = 0; i < qtdadeAlunos; i++){
            if(alunos[i].getMatricula() == matricula){
                return alunos[i];
            }
        } return null;
    }

    public void informaNota(int matricula, int nroNota, float nota){
        Aluno tmp = getAluno(matricula);
        if (tmp == null){
            throw new IllegalArgumentException("Matricula Inválida!");
        }
        else{
            tmp.setNota(nroNota, nota);
        }
    }


    // get todos os alunos
    public Aluno[] getTodosAlunos(){
        return this.alunos;
    }

    public Aluno[] aprovados(){
        Aluno[] listaAprovados = new Aluno[this.qtdadeAlunos];
        int contAprovados = 0;
        int pos = 0;

        for(int i=0; i < this.qtdadeAlunos; i++){
            if (alunos[i].notasValidas() == true && alunos[i].aprovado()){
                contAprovados++;
            }
        }

        listaAprovados = new Aluno[contAprovados];

        for(int i=0; i < this.qtdadeAlunos; i++){
            if (alunos[i].notasValidas() == true && alunos[i].aprovado()){
                listaAprovados[pos] = alunos[i];
                pos++;
            }
        }
        return listaAprovados;
    }
}