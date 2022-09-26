package Errores;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class Error1 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        System.out.println("Error lexico en la linea " + Lexico.linea + " el caracter "+Lexico.caracter+" no es valido");
        return null;
    }
}
