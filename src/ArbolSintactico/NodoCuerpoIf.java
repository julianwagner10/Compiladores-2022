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
            String labelaux = NodoIf.etiquetaDeSalto.pop(); //Necesito la etiqueta que fue seteada previamente a esta.
            if(!NodoIf.etiquetaDeSalto.isEmpty()) {
                assembler += NodoIf.etiquetaDeSalto.pop() + ":" + '\n'; //Utilizo la etiqueta que necesito en ese momento
                NodoIf.etiquetaDeSalto.push(labelaux); //Vuelvo a pushear la etiqueta que habia sacado anteriormente.
            }
            else{
                assembler += labelaux + ":" + '\n'; //Utilizo la etiqueta que necesito en ese momento
            }

        }
        return assembler;
    }
}