public class PesquisadorBrigadista extends Pesquisador implements Brigadista{
    public static final int NIVELMAX = 5;
    private int nivelBrigadista;

    public PesquisadorBrigadista(String nome,double salarioBase,int cargaHoraria,int nivelBrigadista) {
        super(nome,salarioBase,cargaHoraria);
        this.nivelBrigadista = nb;
    }

    @Override
    public int nivelDeFormacao() { return nivelBrigadista; }

    @Override
    public void incrementaNivelFormacao() { if (nivelBrigadista < NIVELMAX){ nivelBrigadista++; } }
}