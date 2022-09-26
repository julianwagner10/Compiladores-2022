
package AccionesSemanticas;

import Principal.AccionSemantica;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica1 extends AccionSemantica{
    @Override
    public Token ejecutarAccion() {
        buffer = Character.toString(Lexico.caracter);
        return null;
    }
}
