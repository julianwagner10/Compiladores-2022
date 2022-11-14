package ArbolSintactico;

import Principal.AtributosTablaS;

import java.util.Stack;

public class NodoCuerpoIf extends ArbolSintactico {

    public static Stack<String> etiquetaDeSalto = new Stack<>();
    public NodoCuerpoIf(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        if(this.getHijoDer() == null){
            assembler += NodoIf.etiquetaDeSalto.pop() + ":" +'\n' ; //Desapilo la etiqueta que hace referencia a saltar directo al
                                                                    // else ya que no existe este bloque, si no se cumple la condicion del if
        }
        return assembler;
    }
}