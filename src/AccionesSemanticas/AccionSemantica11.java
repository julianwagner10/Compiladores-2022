package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica11 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detectó el token '=:" +
                "'");
        return new Token(Lexico.ASIGNACION);
    }
}
