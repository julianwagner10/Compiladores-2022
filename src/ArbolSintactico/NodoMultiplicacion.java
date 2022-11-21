package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoMultiplicacion extends NodoOperacion {

    public NodoMultiplicacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer,AtributosTablaS atributos) {
        super(hijoIzq, hijoDer,atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        if (this.getTipo().equals("i32")) {

            assembler += "MOV EAX, " + this.getHijoIzq().getLexema() + '\n';
            assembler += "IMUL " + this.getHijoDer().getLexema() + '\n';
            String auxVar = "_var" + this.contador;
            assembler += "MOV " + auxVar + ", EAX" + '\n';// Muevo a la variable.

            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "Variable"); //Transformo a flotante porque el resultado es de 64 bits.

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
            assembler += "FMUL " + lexemaDer+ '\n';

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