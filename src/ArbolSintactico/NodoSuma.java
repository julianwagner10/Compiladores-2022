package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

import java.util.ArrayList;

public class NodoSuma extends NodoOperacion {

    public NodoSuma(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        if (this.getTipo().equals("i32")) {
            assembler += "MOV EBX, _" + this.getHijoIzq().getLexema().replace('.','_')+ '\n';
            assembler += "ADD EBX, _" + this.getHijoDer().getLexema().replace('.','_') + '\n';
            assembler += "CMP EBX, _limiteSuperiorInt" + '\n'; // Comparo que no exceda el rango.
            assembler += "JG " + "Error_Suma_Enteros" + '\n'; // Si excede salto.
            String auxVar = "_var" + this.contador;
            assembler += "MOV " + auxVar + ", EBX" + '\n';// Muevo a la variable.

            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "Variable");

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

            assembler += "FLD " + lexemaIzq+ '\n';
            assembler += "FADD _" + lexemaDer+ '\n';

            assembler += "FCOMP " + "_limiteSuperiorFloatPositivo" + '\n'; //Comparo el lexema de la der con el valor guardado en ST, y se extrae el valor en ST.

            String auxVarComp = "_var" + this.contador;     //Necesito la variable aux para guardar la palabra de estado en la memoria

            //Estas tres instrucciones se hacen luego de hacer una comparacion en el coprocesador.
            assembler += "FSTSW "+auxVarComp + '\n';       //Almaceno la palabra de estado en la memoria.
            assembler += "MOV AX, " + auxVarComp + '\n';   //Copio el contenido en el registro AX
            assembler += "SAHF" + '\n';                 //Almacena en los 8 bits menos significativos, del registro de indicadores, el valor del registro AH.

            assembler += "JA " + "Error_Suma_Flotantes" + '\n'; // Si excede salto.


            String auxVar = "_var" + this.contador;
            assembler += "FSTP " + auxVar+ '\n';
            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "Variable");

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
        }
        return assembler;

    }
}