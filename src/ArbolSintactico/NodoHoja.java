package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoHoja extends ArbolSintactico{

    public NodoHoja(AtributosTablaS atributo){
        super(null,null,atributo);
    }


    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        return assembler;
    }
}
