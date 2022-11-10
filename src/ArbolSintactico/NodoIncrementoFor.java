package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoIncrementoFor extends ArbolSintactico{
    public NodoIncrementoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        assembler += "MOV EBX, _" + this.id.replace('.','_')+ '\n';
        assembler += "ADD EBX, _" + this.getHijoIzq().getLexema().replace('.','_') + '\n';
        assembler += "MOV _" + this.id + ", " + "EBX" + '\n';

        return assembler;
    }
}
