package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error5 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("Error lexico en la linea " + Lexico.linea + ": se esperaba un '/' antes de un salto de linea");
        return null;
    }
}
