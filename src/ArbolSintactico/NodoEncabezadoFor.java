package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoEncabezadoFor extends ArbolSintactico{
    public NodoEncabezadoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoEncabezadoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
