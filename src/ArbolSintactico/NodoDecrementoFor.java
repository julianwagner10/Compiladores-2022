package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoDecrementoFor extends ArbolSintactico{
    public NodoDecrementoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }


    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        assembler += "MOV EBX, _" + this.id.replace('.','_')+ '\n';
        assembler += "SUB EBX, _" + this.getHijoIzq().getLexema().replace('.','_') + '\n';
        assembler += "MOV _" + this.id + ", " + "EBX" + '\n';

        return assembler;
    }
}
