package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoEtiquetado extends ArbolSintactico{
    public NodoEtiquetado(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoEtiquetado(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }
}
