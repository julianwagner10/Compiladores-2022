package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoResta extends NodoOperacion{

    public NodoResta(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        if (this.getTipo().equals("i32")) {
            assembler += "MOV EBX, _" + this.getHijoIzq().getLexemaReemplazado() + '\n';
            assembler += "SUB EBX, _" + this.getHijoDer().getLexemaReemplazado() + '\n';
            String auxVar = "_var" + this.contador;
            assembler += "MOV _" + auxVar + ", EBX" + '\n';// Muevo a la variable.

            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "VariableAuxiliar",this.getAtributo().getAmbito());

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
                assembler += "FLD _" + lexemaIzq+ '\n';
                assembler += "FSUB _" + lexemaDer+ '\n';
            }
            else{
                if(this.getHijoIzq().getTipo().equals("i32")){
                    assembler += "FILD _" + lexemaIzq + '\n';
                    assembler += "FSUB _" + lexemaDer+ '\n';
                }
                else{
                    String conversion = "_var" + this.contador;
                    Main.tablaDeSimbolos.setSimbolo(conversion, Lexico.ID, "f32", "VariableAuxiliar",this.getAtributo().getAmbito());
                    assembler += "FILD _" + lexemaDer + '\n';
                    assembler += "FSTP _" + conversion+ '\n';
                    assembler += "FLD _" + lexemaIzq + '\n';
                    assembler += "FSUB _" + conversion + '\n';
                    this.contador++;
                }
            }


            String auxVar = "_var" + this.contador;
            assembler += "FSTP _" + auxVar+ '\n';
            Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "VariableAuxiliar",this.getAtributo().getAmbito());

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar);
            this.reemplazarAtributos(this, atributos);
            this.contador++;
        }
        return assembler;

    }
}
