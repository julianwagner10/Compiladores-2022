package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoFor extends ArbolSintactico{
    public NodoFor(ArbolSintactico hijoIzq,ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
