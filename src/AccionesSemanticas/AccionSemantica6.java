package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica6 extends AccionSemantica { //Accion semantica para caracteres simples
    @Override
    public Token ejecutarAccion() {
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto el token -> " + Lexico.caracter);
        return new Token(Lexico.caracter);
    }
}

