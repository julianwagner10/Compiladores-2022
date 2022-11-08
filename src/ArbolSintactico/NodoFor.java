package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoFor extends ArbolSintactico{
    public NodoFor(ArbolSintactico hijoIzq,ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
