package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCondicionFor extends ArbolSintactico {

    public NodoCondicionFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
