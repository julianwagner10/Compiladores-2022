package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoComparacionFor extends ArbolSintactico {

    public static int contadorEtiquetas = 0;

    public NodoComparacionFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        if((this.getHijoIzq().getUso().equals("Variable")) && (this.getHijoIzq().getLexema().equals(this.id)) ) {
                assembler += "MOV EBX, _" + this.getHijoIzq().getLexema() + '\n'; //Muevo el lexema de la izq al registro EBX
                assembler += "CMP EBX, _"+ this.getHijoDer().getLexema() + '\n'; //Comparo el lexema de la derecha con lo del registro EBX

                String label = " FOR_CMP " + ++contadorEtiquetas;
                assembler += this.getCondicionDeSalto(this.getLexema()) + label + '\n';
                NodoFor.etiquetaDeSalto.push(label);

            }
            return assembler;
        }

}