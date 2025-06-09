package JogoDemo.Salas;

import basicas.Engine;
import basicas.Sala;
import basicas.Objeto;
import JogoDemo.Objetos.Armario;

public class SalaDeEstar extends Sala {
    public SalaDeEstar(Engine engine) {
        super("Sala_de_Estar", engine);
        Objeto armario = new Armario();
        this.getObjetos().put(armario.getNome(), armario);
    }

    @Override
    public boolean usa(String nomeFerramenta) {
        if (!this.getObjetos().containsKey(nomeFerramenta)) {
            return false;
        }
        Objeto armario = this.getObjetos().get(nomeFerramenta);
        return armario.usar(this.getEngine().getMochila());
    }
}
