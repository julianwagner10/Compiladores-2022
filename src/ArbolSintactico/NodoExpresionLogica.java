package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoExpresionLogica extends ArbolSintactico {

    public NodoExpresionLogica(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}