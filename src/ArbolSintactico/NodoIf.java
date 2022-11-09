package ArbolSintactico;

import Principal.AtributosTablaS;

import java.util.Stack;

public class NodoIf extends ArbolSintactico {

    public static Stack<String> etiquetaDeSalto = new Stack<>();

    public NodoIf(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        return assembler;
    }
}