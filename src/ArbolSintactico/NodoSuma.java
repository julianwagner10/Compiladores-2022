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
            assembler += "JA " + "Error_Suma_Enteros" + '\n'; // Si excede salto.
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

            String auxVar1 = "_var" + this.contador;
            assembler += "FSTP _" + auxVar1+ '\n';
            Main.tablaDeSimbolos.setSimbolo(auxVar1, Lexico.ID, "f32", "VariableAuxiliar");

            assembler += "FLD _" + auxVar1 + '\n';
            this.contador++;
            //Chequeo que el valor se encuentre en alguno de los dos rangos permitidos.

            assembler += "FCOMP " + "_limiteInferiorFloatPositivo" + '\n'; //Comparo el lexema de la der con el valor guardado en ST, y se extrae el valor en ST.

            String auxVar2 = "_var" + this.contador;
            this.contador++;
            assembler += "FSTSW _" + auxVar2 + '\n';
            assembler += "MOV AX, _" + auxVar2 + '\n';
            assembler += "SAHF" + '\n';

            assembler += "JA LabelLimiteSupPositivo \n";
            assembler += "JBE LabelLimiteInfNegativo \n";

            Main.tablaDeSimbolos.setSimbolo(auxVar2, Lexico.ID, "f32", "ComparacionFloat");

            assembler += "LabelLimiteSupPositivo: \n";
            assembler += "FLD _" + auxVar1 + '\n';

            assembler += "FCOMP " + "_limiteSuperiorFloatPositivo" + '\n';

            String auxVar3 = "_var" + this.contador;
            this.contador++;
            assembler += "FSTSW _" + auxVar3 + '\n';
            assembler += "MOV AX, _" + auxVar3 + '\n';
            assembler += "SAHF" + '\n';
            assembler += "JB LabelNoOverflow \n";
            assembler += "JAE Error_Suma_Flotantes \n";

            Main.tablaDeSimbolos.setSimbolo(auxVar3, Lexico.ID, "f32", "ComparacionFloat");


            assembler += "LabelLimiteInfNegativo: \n";
            assembler += "FLD _" + auxVar1 + '\n';
            assembler += "FCOMP " + "_limiteSuperiorFloatNegativo" + '\n';

            String auxVar4 = "_var" + this.contador;
            this.contador++;
            assembler += "FSTSW _" + auxVar4 + '\n';
            assembler += "MOV AX, _" + auxVar4 + '\n';
            assembler += "SAHF" + '\n';
            assembler += "JA LabelLimiteSupNegativo \n";
            assembler += "JBE Error_Suma_Flotantes \n";

            Main.tablaDeSimbolos.setSimbolo(auxVar4, Lexico.ID, "f32", "ComparacionFloat");

            assembler += "LabelLimiteSupNegativo: \n";
            assembler += "FLD _" + auxVar1 + '\n';
            assembler += "FCOMP " + "_limiteInferiorFloatNegativo" + '\n';

            String auxVar5 = "_var" + this.contador;
            this.contador++;
            assembler += "FSTSW _" + auxVar5 + '\n';
            assembler += "MOV AX, _" + auxVar5 + '\n';
            assembler += "SAHF" + '\n';
            assembler += "JB LabelNoOverflow \n";
            assembler += "JAE LabelCero \n";

            Main.tablaDeSimbolos.setSimbolo(auxVar5, Lexico.ID, "f32", "ComparacionFloat");


            assembler += "LabelCero: \n";
            assembler += "FLD _" + auxVar1 + '\n';
            assembler += "FCOMP " + "_limiteFloatCero" +  '\n';
            String auxVar6 = "_var" + this.contador;
            this.contador++;
            assembler += "FSTSW _" + auxVar6 + '\n';
            assembler += "MOV AX, _" + auxVar6 + '\n';
            assembler += "SAHF" + '\n';

            assembler += "JNE Error_Suma_Flotantes \n";
            Main.tablaDeSimbolos.setSimbolo(auxVar6, Lexico.ID, "f32", "ComparacionFloat");

            assembler+= "LabelNoOverflow: \n";

            this.eliminarHijos(this);
            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(auxVar1);
            this.reemplazarAtributos(this, atributos);
        }
        return assembler;

    }
}