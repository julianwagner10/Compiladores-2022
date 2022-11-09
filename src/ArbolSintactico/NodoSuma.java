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
            assembler += "MOV EBX, _" + this.getHijoIzq().getLexema() + '\n';
            assembler += "ADD EBX, _" + this.getHijoDer().getLexema() + '\n';
           // assembler += "CMP EBX, _limiteSuperiorINT" + '\n'; // Comparo que no exceda el rango.
           // assembler += "JA " + "LabelOverflowSuma" + '\n'; // Si excede salto.
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
            assembler += "FADD " + lexemaDer+ '\n';

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