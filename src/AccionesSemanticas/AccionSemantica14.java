package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class AccionSemantica14 extends AccionSemantica {
    @Override
    public Token ejecutarAccion() {
        buffer = buffer + Lexico.caracter;
        Lexico.tablaSimbolos.setSimbolo(buffer, Lexico.CADENA);
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detectó una cadena de caracteres");
        return new Token(Lexico.CADENA, buffer);
    }
}