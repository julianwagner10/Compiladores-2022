package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica2 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        buffer = buffer + Lexico.caracter;
        return null;
    }
}
