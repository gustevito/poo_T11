package JogoDemo.Objetos;

import JogoDemo.Ferramentas.Martelo;
import basicas.Ferramenta;
import basicas.Objeto;

public class PoteDeAcucar extends Objeto {
	public PoteDeAcucar() {
		super("pote_de_acucar","O pote de açúcar esta fechado",
			  "O pote de açúcar esta quebrado. Tinha um diamante dentro!");
	}

	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Martelo) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
}