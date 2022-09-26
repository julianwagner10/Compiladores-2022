package AccionesSemanticas;

import Errores.Error3;
import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica4 extends AccionSemantica { //Accion semantica para constantes CTE_INT
    @Override
    public Token ejecutarAccion() {
        Integer constante = Integer.parseInt(AccionSemantica.buffer); //Convierto el string dentro del buffer en una constante entera.
        if((constante >= (-Math.pow(2,31))) && (constante <= (Math.pow(2,31) - 1))){
            Lexico.cursor--; // Me paro en el ultimo caracter leido y lo devuelvo
            Lexico.tablaSimbolos.setSimbolo(buffer,Lexico.CTE_INT);
            System.out.println("Hay una constante entera en la linea "+ Lexico.linea + " con valor " + buffer);
            return new Token(Lexico.CTE_INT,buffer);
        }
        return new Error3().ejecutarAccion();
    }
}