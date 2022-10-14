package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error1 extends AccionSemantica {

    @Override
    public Token ejecutarAccion() {
        Main.erroresLexicos.add("Error lexico: Linea " + Lexico.linea + " el caracter "+Lexico.caracter+" no es valido");
        return null;
    }
}
