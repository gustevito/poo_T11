package JogoDemo.Salas;

import JogoDemo.Ferramentas.Martelo;
import basicas.Engine;
import basicas.Sala;
import basicas.Ferramenta;

public class HallEntrada extends Sala {
    public HallEntrada(Engine engine) {
        super("Hall_de_Entrada", engine);
        Ferramenta martelo = new Martelo();
        this.getFerramentas().put(martelo.getNome(), martelo);
    }

    @Override
    public boolean usa(String nomeFerramenta) {
        return false;
    }
}

