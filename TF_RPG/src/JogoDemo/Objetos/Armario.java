package JogoDemo.Objetos;

import JogoDemo.Ferramentas.Chave;
import basicas.Ferramenta;
import basicas.Objeto;

public class Armario extends Objeto {
	public Armario() {
		super("armario","O armário está fechado",
			  "O armário está aberto. Não tem nada dentro");
	}

	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Chave) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
}