package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCondicionIf extends ArbolSintactico {

    public NodoCondicionIf(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        return assembler;
    }
}