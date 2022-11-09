package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCuerpoFor extends ArbolSintactico{
    public NodoCuerpoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
