package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoElse extends ArbolSintactico {

    public NodoElse(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}