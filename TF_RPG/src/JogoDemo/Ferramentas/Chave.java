package JogoDemo.Ferramentas;

import basicas.Ferramenta;

public class Chave extends Ferramenta{
    public Chave(){
        super("Chave");
    }

    @Override
    public boolean usar() {
        return true;
    }    
}
