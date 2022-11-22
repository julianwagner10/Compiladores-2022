package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoDivision extends NodoOperacion{

    public NodoDivision(ArbolSintactico hijoIzq, ArbolSintactico hijoDer,AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        if (this.getTipo().equals("i32")) {

            assembler += "MOV EAX, _" + this.getHijoIzq().getLexema() + '\n';
            assembler += "IDIV _" + this.getHijoDer().getLexema() + '\n';

            String auxVar = "_var" + this.contador;
            assembler += "MOV _" + auxVar + ", EAX" + '\n';// Muevo a la variable.

            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "VariableAuxiliar");

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
        } else {
            String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
            String lexemaDer = this.getHijoDer().getLexemaReemplazado();
            lexemaIzq = lexemaIzq.replace("+","__");
            lexemaDer = lexemaDer.replace('.','_');
            lexemaDer = lexemaDer.replace('-','_');
            lexemaDer = lexemaDer.replace("+","__");

            assembler += "FLD _" + lexemaIzq+ '\n';
            assembler += "FDIV _" + lexemaDer+ '\n';

            String auxVar = "_var" + this.contador;
            assembler += "FSTP _" + auxVar+ '\n';
            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "VariableAuxiliar");

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
        }
        return assembler;

    }
}

