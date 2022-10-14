package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error4 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Main.erroresLexicos.add("Error lexico: Linea " + Lexico.linea + " se esperaba un dígito, un '+' o un '-' y se leyó otro carácter ");
        return null;
    }
}
