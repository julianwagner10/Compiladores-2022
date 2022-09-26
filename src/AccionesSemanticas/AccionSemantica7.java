package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica7 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto el token '<='");
        return new Token(Lexico.MENOR_IGUAL);
    }
}
