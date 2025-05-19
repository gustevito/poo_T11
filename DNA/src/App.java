public class App {
    public static void main(String[] args) throws Exception {
        IProcessaDNA pDNA = new ProcessaDNA_String();
        
        //String fname = "casoLetrasRepNoInicio";
        //String fname = "caso100";
        //String fname = "caso200";
        //String fname = "caso500";
        //String fname = "caso1000";
        String fname = "caso2000"; // 300 ms kkkkk caraca linkedlist é foda
        
        System.out.println("Começou! Arquivo: "+fname);
        pDNA.carregaDados(fname);
        System.out.println("Dados carregados!");
        System.out.println("Processando ...");
        long t1 = System.currentTimeMillis();
        String resp = pDNA.degradaDNA();
        long t2 = System.currentTimeMillis();
        long tp = (t2-t1);
        System.out.println("Resultado: "+resp);
        System.out.println("Tempo de processamento: "+tp+" milisegundos");
    }
}
