package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoInvocacion extends ArbolSintactico{


    public NodoInvocacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        return null;
    }

}
