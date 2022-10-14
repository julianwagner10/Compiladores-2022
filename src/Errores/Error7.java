package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error7 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Main.erroresLexicos.add("Error lexico: Linea " + Lexico.linea + " el carácter " + Lexico.caracter + " no pertenece al lenguaje");
        return null;
    }
}
