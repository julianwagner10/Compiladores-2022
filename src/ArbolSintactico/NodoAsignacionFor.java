package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoAsignacionFor extends ArbolSintactico{
    public NodoAsignacionFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoAsignacionFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }
}
