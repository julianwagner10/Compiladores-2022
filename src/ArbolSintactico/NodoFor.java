package ArbolSintactico;

import Principal.AtributosTablaS;

import java.util.Stack;

public class NodoFor extends ArbolSintactico{
    public static Stack<String> etiquetaDeSalto = new Stack<>();

    public NodoFor(ArbolSintactico hijoIzq,ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        assembler += this.etiquetaDeSalto.pop() + ":" + '\n';
        return assembler;

    }
}
