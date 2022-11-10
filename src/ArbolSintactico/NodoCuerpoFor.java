package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCuerpoFor extends ArbolSintactico{
    public NodoCuerpoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {

        String assembler = "";
        String label = NodoFor.etiquetaDeSalto.pop();
        String label1 = NodoFor.etiquetaDeSalto.pop();
        assembler += "JMP " + label1 + '\n';
        NodoFor.etiquetaDeSalto.push(label);
        return assembler;

    }
}
