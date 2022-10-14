package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error6 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Lexico.cursor--;
        Main.erroresLexicos.add("Error lexico: Linea " + Lexico.linea + " se esperaba un salto de linea despues de un '/' ");
        return null;
    }
}
