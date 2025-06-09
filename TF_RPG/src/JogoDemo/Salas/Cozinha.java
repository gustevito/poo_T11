package JogoDemo.Salas;

import JogoDemo.Objetos.PoteDeAcucar;
import JogoDemo.Objetos.PoteDeArroz;
import basicas.Engine;
import basicas.Objeto;
import basicas.Sala;

public class Cozinha extends Sala {
    public Cozinha(Engine engine) {
        super("Cozinha", engine);
        Objeto poteAcucar = new PoteDeAcucar();
        this.getObjetos().put(poteAcucar.getNome(), poteAcucar);
        Objeto poteArroz = new PoteDeArroz();
        this.getObjetos().put(poteArroz.getNome(), poteArroz);
    }

    @Override
    public boolean usa(String objeto) {
        if (!this.getObjetos().containsKey(objeto)) {
            return false;
        }
        Objeto pote = this.getObjetos().get(objeto);
        boolean usou = pote.usar(this.getEngine().getMochila());
        if (pote instanceof PoteDeAcucar && usou) {
            this.getEngine().indicaFimDeJogo();
        }
        return usou;
    }
}