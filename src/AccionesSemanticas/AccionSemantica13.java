package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica13 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Lexico.cursor--;
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detectó el token '='");
        return new Token('=');
    }
}
