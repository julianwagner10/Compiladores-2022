package Assembler;

import ArbolSintactico.ArbolSintactico;
import Principal.Main;

import java.io.*;

public class Assembler {
    private ArbolSintactico arbol;

    private String assemblerData = "";
    private String assemblerCode = "";
    private String assemblerHeader = "";


    private static final long limiteSuperiorint = 2147483647;
    private static final long limiteInferiorint = -2147483648;
    private static final float limiteInferiorDoublePositivo = 1.17549435f-38;
    private static final float limiteSuperiorDoublePositivo = 3.40282347f+38;
    private static final float limiteInferiorDoubleNegativo = -1.17549435f-38;
    private static final float limiteSuperiorDoubleNegativo = -3.40282347f+38;
    private static final float limiteDoubleCero = 0.0f;

    public Assembler(ArbolSintactico arbol){
        this.arbol = arbol;
    }

    public void generarCodigoAssembler() throws IOException {
        this.assemblerHeader += ".386" + '\n' + ".model flat, stdcall" + '\n' + "option casemap :none" + '\n' +
        "include \\masm32\\include\\windows.inc" + '\n' + "include \\masm32\\include\\kernel32.inc" + '\n' +
        "include \\masm32\\include\\user32.inc" + '\n' + "includelib \\masm32\\lib\\kernel32.lib" + '\n' +
        "includelib \\masm32\\lib\\user32.lib" + '\n' + ".STACK 200h" + '\n';

        this.assemblerData += ".data" + '\n';
        this.assemblerData += "_errorOverflowInt" + " DB " + "\"Error suma enteros\", 0" + '\n';
        this.assemblerData += "_errorOverflowFloat" + " DB " + "\"Error suma flotante\" , 0" + '\n';
        this.assemblerData += "_errorRecursionPropia" + " DB " + "\"Error en invocacion a funcion\" , 0" + '\n';

        this.assemblerCode += ".code" + '\n';
        this.assemblerCode += "Error_Suma_Enteros:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorOverflowInt, _errorOverflowInt, MB_OK"+ '\n';
        this.assemblerCode += "invoke ExitProcess, 0" + '\n';
        this.assemblerCode += "Error_Suma_Flotantes:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK"+ '\n';
        this.assemblerCode += "invoke ExitProcess, 0" + '\n';
        this.assemblerCode += "Error_Invocacion_Funcion:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorRecursionPropia, addr _errorRecursionPropia, MB_OK"+ '\n';
        this.assemblerCode += "invoke ExitProcess, 0" + '\n';


        if(this.arbol != null)
            this.getMostLeftTree(this.arbol);
        this.assemblerCode += "invoke ExitProcess, 0" + '\n' + "END START";

        this.assemblerData += Main.tablaDeSimbolos.generarCodigoAssembler();

        String assembler = this.assemblerHeader + this.assemblerData + this.assemblerCode;
        System.out.println(assembler);

        FileOutputStream fos = new FileOutputStream(new File("salida.asm"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(".386" + '\n'
                + ".model flat, stdcall" + '\n'
                + "option casemap :none" + '\n'
                + "include \\masm32\\include\\windows.inc" + '\n'
                + "include \\masm32\\include\\kernel32.inc" + '\n'
                + "include \\masm32\\include\\user32.inc" + '\n'
                + "includelib \\masm32\\lib\\kernel32.lib" + '\n'
                + "includelib \\masm32\\lib\\user32.lib" + '\n'
                + '\n' + ".data" + '\n');

        bw.write(this.assemblerData + "\n.code\nstart: \n" + this.assemblerCode + "invoke ExitProcess, 0\nend start");

        bw.close();

    }

    public void getMostLeftTree(ArbolSintactico raiz) {
        if (raiz != null && !raiz.esHoja()) {
            if ((raiz.getHijoDer() != null)) {
                if (raiz.getHijoIzq().esHoja() && raiz.getHijoDer().esHoja()) {
                    this.assemblerCode += raiz.generarCodigoAssembler();
                } else {
                    this.getMostLeftTree(raiz.getHijoIzq());
                    this.getMostLeftTree(raiz.getHijoDer());
                    this.assemblerCode += raiz.generarCodigoAssembler();
                }
            } else {
                if (raiz.getHijoIzq().esHoja())
                    this.assemblerCode += raiz.generarCodigoAssembler();
                else{
                    this.getMostLeftTree(raiz.getHijoIzq());
                    this.assemblerCode += raiz.generarCodigoAssembler();
                }
            }
        }
    }

}