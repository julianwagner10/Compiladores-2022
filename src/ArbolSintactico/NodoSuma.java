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
        //situacion 1: (operador, var/cte, var/cte)
        if (this.getTipo().equals("i32")) {
            assembler += "MOV EBX, _" + this.getHijoIzq().getLexema() + '\n';
            assembler += "ADD EBX, _" + ", _" + this.getHijoDer().getLexema() + '\n';
           // assembler += "CMP EBX, _limiteSuperiorINT" + '\n'; // Comparo que no exceda el rango.
           // assembler += "JA " + "LabelOverflowSuma" + '\n'; // Si excede salto.

            String auxVar = "_var" + this.contador;
            assembler += "MOV " + auxVar + ", EBX" + '\n';// Muevo a la variable.

            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "Variable");
            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
            return assembler;
        } else {

            assembler = "";
            assembler += "FLD _" + this.getHijoIzq().getLexema()+ '\n';
            assembler += "FLD _" + this.getHijoDer().getLexema()+ '\n';
            assembler += "FADD" + '\n';

            String auxVar = "_var" + this.contador;
            assembler += "FSTP _" + auxVar+ '\n';
            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "Variable");

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
            return assembler;
        }

    }
}