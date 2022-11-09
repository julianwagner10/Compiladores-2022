package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoExpresionLogica extends ArbolSintactico {

    public static int contadorEtiquetas = 0;

    public NodoExpresionLogica(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = null;
        if((this.getHijoIzq().getUso().equals("Variable")) || (this.getHijoIzq().getUso().equals("constante"))) {
            if (this.getHijoIzq().getTipo().equals("i32")) {
                assembler += "MOV EBX, _" + this.getHijoIzq().getLexema() + '\n';
                assembler += "CMP EBX, _"+ this.getHijoDer().getLexema() + '\n';
            }
            else{
                assembler += "FLD _" +this.getHijoIzq().getLexema() + '\n';
                assembler += "FCOMP" +this.getHijoDer().getLexema() + '\n';

                String auxVar = "_var" + this.contador;

                assembler += "FSTSW _"+auxVar + '\n';
                assembler += "MOV AX, _" + auxVar + '\n';
                assembler += "SAHF" + '\n';

                Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "Variable");
            }
        }
        String label = "IF_CMP" + ++contadorEtiquetas;
        assembler += this.getCondicionDeSalto(this.getLexema()) + label + '\n';
        NodoIf.etiquetaDeSalto.push(label);
        this.contadorEtiquetas++;
        return assembler;
    }
}