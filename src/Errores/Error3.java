package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error3 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Main.erroresLexicos.add("Error lexico: Linea " + Lexico.linea + " la constante se encuentra fuera de rango");
        return null;
    }
}
