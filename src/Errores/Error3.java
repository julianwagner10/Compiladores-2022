package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error3 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("Error lexico en la linea " + Lexico.linea + ": la constante se encuentra fuera de rango");
        return null;
    }
}
