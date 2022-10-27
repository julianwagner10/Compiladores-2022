package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoInvocacion extends ArbolSintactico{
    public NodoInvocacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoInvocacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }
}
