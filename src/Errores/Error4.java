package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error4 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("Error lexico en la linea " + Lexico.linea + ": se esperaba un dígito, un '+' o un '-' y se leyó otro carácter ");
        return null;
    }
}
