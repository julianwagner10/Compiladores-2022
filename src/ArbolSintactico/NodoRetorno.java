package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoRetorno extends ArbolSintactico{
    public NodoRetorno(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        return "" + '\n';
    }
}
