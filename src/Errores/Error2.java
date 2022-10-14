package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error2 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Main.erroresLexicos.add("Error lexico: Linea " + Lexico.linea + " se esperaba un dígito y se leyó el carácter "+Lexico.caracter);
        return null;
    }
}
