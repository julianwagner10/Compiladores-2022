package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error7 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("Error lexico en la linea " + Lexico.linea + ": el carácter " + Lexico.caracter + " no pertenece al lenguaje");
        return null;
    }
}
