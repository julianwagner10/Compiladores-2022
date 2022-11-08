package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoIncrementoFor extends ArbolSintactico{
    public NodoIncrementoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoIncrementoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
