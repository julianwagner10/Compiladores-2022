package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCuerpoElse extends ArbolSintactico {

    public NodoCuerpoElse(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        assembler += NodoIf.etiquetaDeSalto.pop() + ":" ; //Desapilo la etiqueta que hace referencia al dedstino de la bifurcacion incondicional y la agrego al codigo de salida.
        return assembler;
    }
}