package JogoDemo.Objetos;

import JogoDemo.Ferramentas.Martelo;
import basicas.Ferramenta;
import basicas.Objeto;

public class PoteDeArroz extends Objeto {
	public PoteDeArroz() {
		super("pote_de_arroz","O pote de arroz esta fechado",
			  "O pote de arroz esta quebrado. Tem arroz espalhado por todo lado");

	}

	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Martelo) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
}