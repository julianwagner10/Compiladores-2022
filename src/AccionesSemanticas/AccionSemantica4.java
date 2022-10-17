package AccionesSemanticas;

import Errores.Error3;
import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica4 extends AccionSemantica { //Accion semantica para constantes CTE_INT, en este caso los enteros son largos.
    @Override
    public Token ejecutarAccion() {
        Long constante = Long.parseLong(AccionSemantica.buffer); //Convierto el string dentro del buffer en una constante entera.
        if((constante >= (-1*Math.pow(2,31))) && (constante <= (Math.pow(2,31)))){
            Lexico.cursor--; // Me paro en el ultimo caracter leido y lo devuelvo
            Lexico.tablaSimbolos.setSimbolo(buffer,Lexico.CTE_INT);
            System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto la constante ENTERA LARGA -> "+ buffer);
            return new Token(Lexico.CTE_INT,buffer);
        }
        System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto la constante -> "+ buffer);
        return new Error3().ejecutarAccion();
    }
}