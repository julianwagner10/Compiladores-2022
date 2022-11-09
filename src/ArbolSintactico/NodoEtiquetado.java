package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoEtiquetado extends ArbolSintactico{
    public NodoEtiquetado(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler ="";
        return assembler;
    }
}
