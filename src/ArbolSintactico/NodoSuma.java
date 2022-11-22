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
            assembler += "MOV _" + auxVar + ", EBX" + '\n';// Muevo a la variable.

            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "VariableAuxiliar");

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
        } else {

            String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
            String lexemaDer = this.getHijoDer().getLexemaReemplazado();
            lexemaIzq = lexemaIzq.replace("+","__");
            lexemaIzq = lexemaIzq.replace('.','_');
            lexemaIzq = lexemaIzq.replace('-','_');
            lexemaDer = lexemaDer.replace('.','_');
            lexemaDer = lexemaDer.replace('-','_');
            lexemaDer = lexemaDer.replace("+","__");

            if (this.getHijoIzq().getTipo().equals(this.getHijoDer().getTipo())){
                assembler += "FLD _" + lexemaIzq + '\n';
                assembler += "FADD _" + lexemaDer + '\n';
            }
            else{
                if(this.getHijoIzq().getTipo().equals("i32")){
                    assembler += "FILD _" + lexemaIzq + '\n';
                    assembler += "FADD _" + lexemaDer + '\n';
                }
                else{
                    assembler += "FILD _" + lexemaDer + '\n';
                    assembler += "FADD _" + lexemaIzq + '\n';
                }
            }
            assembler += "FCOMP " + "_limiteSuperiorFloatPositivo" + '\n'; //Comparo el lexema de la der con el valor guardado en ST, y se extrae el valor en ST.
            assembler += "JA " + "Error_Suma_Flotantes" + '\n'; // Si excede salto.

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