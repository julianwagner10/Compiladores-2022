package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoBloqueEjecutable extends ArbolSintactico{

    public NodoBloqueEjecutable(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        return assembler;
    }

}
