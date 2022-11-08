package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoRetorno extends ArbolSintactico{
    public NodoRetorno(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoRetorno(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
