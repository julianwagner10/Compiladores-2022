package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoParam extends ArbolSintactico{
    public NodoParam(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoParam(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }
}
