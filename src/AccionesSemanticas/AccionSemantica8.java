package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica8 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Lexico.cursor--;
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto el token '<'");
        return new Token('<');
    }
}
