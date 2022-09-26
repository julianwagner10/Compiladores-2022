package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error6 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        Lexico.cursor--;
        System.out.println("Error lexico en la linea " + Lexico.linea + ": se esperaba un salto de linea despues de un '/' ");
        return null;
    }
}
