package AccionesSemanticas;

import Errores.Error3;
import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica5 extends AccionSemantica { //Accion semantica para constantes singles CTE_SINGLE
    @Override
    public Token ejecutarAccion() {

        Float flotante = Float.parseFloat(buffer.replace('F', 'e'));

        if ((flotante > 1.17549435e-38 && flotante < 3.40282347e+38) || (flotante > -3.40282347e+38 && flotante < -1.17549435e-38) || (flotante == 0.0)) {
            Lexico.cursor--; // Me paro en el ultimo caracter leido y lo devuelvo
            Lexico.tablaSimbolos.setSimbolo(buffer, Lexico.CTE_FLOTANTE);
            System.out.println("Hay una constante flotante en la linea " + Lexico.linea + " con valor " + buffer);
            return new Token(Lexico.CTE_FLOTANTE,buffer);
        }
        return new Error3().ejecutarAccion();
    }
}
