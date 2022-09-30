package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica3 extends AccionSemantica { //Esta accion semantica chequea identificadores junto con palabras reservadas.
    @Override
    public Token ejecutarAccion() {
        Lexico.cursor--; // Me paro en el ultimo caracter leido y lo devuelvo.

        if (buffer.length() > 25) {
            buffer = buffer.substring(0, 25);
            System.out.println("Warning: en la linea "+ Lexico.linea +" se truncó el identificador a 25 caracteres");
        }
        if(!Lexico.tablaSimbolos.existeLexema(buffer)){ //Si no existe en la tabla lo agrego, y ademas ya se que no es una palabra reservada.
            Lexico.tablaSimbolos.setSimbolo(buffer,Lexico.ID);
        }
        else  //Si existe tengo que chequear si es palabra reservada o solo un identificador
            if (Lexico.tablaSimbolos.esPalabraReservada(buffer)) { //Si es palabra reservada retorno el token solamente con su id.
                System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto la palabra reservada "+buffer);
                return new Token(this.getIdPalabra());
            }

            System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto el identificador "+ buffer);
            return new Token(Lexico.ID, buffer); //Si no es palabra reservada retorno el token con el lexico y el id.

    }

    public int getIdPalabra(){
        switch (buffer){
            case "if":
                return Lexico.IF;
            case "then":
                return Lexico.THEN;
            case "else":
                return Lexico.ELSE;
            case "end_if":
                return Lexico.ENDIF;
            case "fun":
                return Lexico.FUN;
            case "return":
                return Lexico.RETURN;
            case "break":
                return Lexico.BREAK;
            case "f32":
                return Lexico.F32;
            case "out":
                return Lexico.OUT;
            case "discard":
                return Lexico.DISCARD;
            case "for":
                return Lexico.FOR;
            case "continue":
                return Lexico.CONTINUE;
            case "i32":
                return Lexico.I32;

        }
        return 0;
    }
}
