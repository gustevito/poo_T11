package JogoDemo.Ferramentas;

import basicas.Ferramenta;

public class Martelo extends Ferramenta{
    public Martelo(){
        super("Martelo");
    }

    @Override
    public boolean usar() {
        return true;
    }    
}
