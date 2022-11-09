package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoSalida extends ArbolSintactico{
    public NodoSalida(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
