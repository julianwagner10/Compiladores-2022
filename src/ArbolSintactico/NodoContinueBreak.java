package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoContinueBreak extends ArbolSintactico{

    public NodoContinueBreak(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String label;
        String label1;
        switch (this.getLexema()) {
            case ("break"):
                if(!NodoFor.etiquetaDeSalto.empty()) {
                    label = NodoFor.etiquetaDeSalto.pop();
                    assembler += "JMP " + label + '\n';
                    NodoFor.etiquetaDeSalto.push(label);
                }
                break;
            case ("continue"):
                if(!NodoFor.etiquetaDeSalto.empty()) {
                    label = NodoFor.etiquetaDeSalto.pop();
                    if(!NodoFor.etiquetaDeSalto.empty()) {
                        label1 = NodoFor.etiquetaDeSalto.pop();
                        assembler += "JMP " + label1 + '\n';
                        NodoFor.etiquetaDeSalto.push(label1); //Vuelvo a setear las etiquetas como estaban antes del salto
                    }
                    NodoFor.etiquetaDeSalto.push(label);
                }
                break;
            case ("break retorno"):
            case("valor por defecto"):
                String auxVar = "_var"+this.contador;
                if(this.getTipo().equals("i32")) {
                    String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
                    assembler += "MOV EBX, _"+lexemaIzq+ '\n';
                    assembler += "MOV _"+auxVar+", EBX"+ '\n';
                    this.setVarRetorno(auxVar);
                    Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "VariableAuxiliar");
                }
                else{
                    String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
                    assembler += "FLD _" +lexemaIzq + '\n';
                    assembler += "FSTP _" + auxVar+ '\n';
                    this.setVarRetorno(auxVar);
                    Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "VariableAuxiliar");
                }
                break;
        }
        return assembler;
    }

}
