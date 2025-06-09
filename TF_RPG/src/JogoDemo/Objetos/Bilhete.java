package JogoDemo.Objetos;

import basicas.Ferramenta;
import basicas.Objeto;

public class Bilhete extends Objeto {
    public Bilhete() {
		super("bilhete","Há um bilhete, nele está escrito \"A vida é doce!\"","");
	}

	public boolean usar(Ferramenta ferramenta) {
		return false;
	}
}
