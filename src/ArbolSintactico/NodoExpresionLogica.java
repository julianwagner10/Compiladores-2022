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
        String assembler = "";
        if((this.getHijoIzq().getUso().equals("Variable")) || (this.getHijoIzq().getUso().equals("constante"))) {
            if (this.getHijoIzq().getTipo().equals("i32")) {
                assembler += "MOV EBX, _" + this.getHijoIzq().getLexema() + '\n'; //Muevo el lexema de la izq al registro EBX
                assembler += "CMP EBX, _"+ this.getHijoDer().getLexema() + '\n'; //Comparo el lexema de la derecha con lo del registro EBX

                String label = "IF_CMP " + ++contadorEtiquetas;
                assembler += this.getCondicionDeSalto(this.getLexema()) + " " + label + '\n';
                NodoIf.etiquetaDeSalto.push(label);
            }
            else{
                assembler += "FLD _" +this.getHijoIzq().getLexema() + '\n'; //Copio el lexema ded la izq en ST, es decir, el tope de los registros del coprocesador.
                assembler += "FCOMP " +this.getHijoDer().getLexema() + '\n'; //Comparo el lexema de la der con el valor guardado en ST, y se extrae el valor en ST.

                String auxVar = "_var" + this.contador;     //Necesito la variable aux para guardar la palabra de estado en la memoria
                                                            //Estas tres instrucciones se hacen luego de hacer una comparacion en el coprocesador.
                assembler += "FSTSW _"+auxVar + '\n';       //Almaceno la palabra de estado en la memoria.
                assembler += "MOV AX, _" + auxVar + '\n';   //Copio el contenido en el registro AX
                assembler += "SAHF" + '\n';                 //Almacena en los 8 bits menos significativos, del registro de indicadores, el valor del registro AH.

                Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "Variable");

                String label = "IF_CMP " + ++contadorEtiquetas;
                assembler += this.getCondicionDeSaltoSinSigno(this.getLexema())+ " " +label + '\n';
                NodoIf.etiquetaDeSalto.push(label);
            }
            this.contadorEtiquetas++;
            return assembler;
        }
        return assembler;
    }
}