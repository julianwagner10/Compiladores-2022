package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoDecrementoFor extends ArbolSintactico{
    public NodoDecrementoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoDecrementoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }
}
