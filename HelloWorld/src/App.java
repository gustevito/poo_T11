public class App {
    public static void main(String[] args) throws Exception {
        Aluno a = new Aluno(1019,"Huguinho Pato");
        a.setNota(1, 8);
        a.setNota(2, 6);
        a.setNota(3, 10);
        System.out.println(a.getMatricula());
        System.out.println(a.getNome());
        for(int i=1;i<=a.MAX_NOTAS;i++){
            System.out.println(a.getNota(i));
        }
        System.out.println("Media: "+a.media());
        if (a.aprovado()){
            System.out.println("Aprovado!");
        }else{
            System.out.println("Reprovado.");
        }
        Turma t = new Turma(10,"Pato Donald",10);
        t.novoAluno(a);
        t.novoAluno(new Aluno(1022,"Luizinho Pato"));


        Aluno x = t.getAluno(1022);
        System.out.println(x.toString());
        x.setNota(1, 5);

        t.informaNota(1022, 1, 5);
        t.informaNota(1022, 2, 8);
        t.informaNota(1022, 3, 10);

        t.informaNota(1023, 1, 10);


        Aluno[] aprovados = t.aprovados();
        for(int i = 0; i < aprovados.length; i++){
            // finaliza isso dps
        }
    }
}
