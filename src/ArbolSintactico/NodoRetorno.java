package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Lexico;
import Principal.Main;

public class NodoRetorno extends ArbolSintactico{
    public NodoRetorno(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String operador = this.getHijoIzq().getLexemaReemplazado();
        String usoOp = this.getHijoIzq().getUso();
        String tipoOperador = this.getHijoIzq().getTipo();
        if(usoOp.equals("Variable") || usoOp.equals("constante")){ //Necesito generar codigo assembler cuando la expresion aritmetica a retornar es una variable o una constante.
            if(tipoOperador.equals("i32")){
                assembler += "MOV EBX, _" + operador +'\n';
                String auxVar = "_var" + this.contador;
                assembler += "MOV " + auxVar + ", EBX" + '\n';// Muevo a la variable.
                Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "i32", "Variable");
            }
            else{
                assembler += "FLD _" + operador+ '\n';
                String auxVar = "_var" + this.contador;
                assembler += "FSTP " + auxVar+ '\n';
                Main.tablaDeSimbolos.setSimbolo(auxVar, Lexico.ID, "f32", "Variable");
            }
        }
        return assembler;
    }
}
