package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error2 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("Error lexico en la linea " + Lexico.linea + " se esperaba un dígito y se leyó el carácter "+Lexico.caracter);
        return null;
    }
}
