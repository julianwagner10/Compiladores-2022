package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCuerpoThen extends ArbolSintactico{

    private static int contador = 0;

    public NodoCuerpoThen(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoCuerpoThen(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, String operador) {
        super(hijoIzq, hijoDer, operador);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String label = "IF_THEN " + ++contador;  //Si estoy en el then, quiere decir que me tengo que saltear al else.
        assembler += "JMP " + label + '\n';  //Genero la etiqueta correspondiente a la bifurcacion incondicional, es decir, no voy a entrar al else.
        assembler += NodoIf.etiquetaDeSalto.pop() + ":" + '\n'; //Desapilo la etiqueta correspondiente a la bifurcacion con su respectivo salto.
        NodoIf.etiquetaDeSalto.push(label); //Apilo la etiqueta generada para la bifurcacion incondicional.
        return assembler;
    }
}
