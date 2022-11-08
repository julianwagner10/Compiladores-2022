package Assembler;

import ArbolSintactico.ArbolSintactico;
import Principal.Main;

import java.io.*;

public class Assembler {
    private ArbolSintactico arbol;

    private String assemblerData = "";
    private String assemblerCode = "";

    private String assemblerHeader = "";


    private static final int limiteSuperiorint = 65535;
    private static final int limiteInferiorint = 0;
    private static final double limiteInferiorDoublePositivo = 2.2250738585272014d-308;
    private static final double limiteSuperiorDoublePositivo = 1.7976931348623157d+308;
    private static final double limiteInferiorDoubleNegativo = -1.7976931348623157d+308;
    private static final double limiteSuperiorDoubleNegativo = -2.2250738585072014d-308;
    private static final double limiteDoubleCero = 0.0;

    public Assembler(ArbolSintactico arbol){
        this.arbol = arbol;
    }

    public void generarCodigoAssembler() throws IOException {
        this.assemblerHeader += ".386" + '\n' + ".model flat, stdcall" + '\n' + "option casemap :none" + '\n' +
        "include \\masm32\\include\\windows.inc" + '\n' + "include \\masm32\\include\\kernel32.inc" + '\n' +
        "include \\masm32\\include\\user32.inc" + '\n' + "includelib \\masm32\\lib\\kernel32.lib" + '\n' +
        "includelib \\masm32\\lib\\user32.lib" + '\n' + ".STACK 200h" + '\n';

        this.assemblerData += ".data" + '\n';
        this.assemblerData += "_errorCero" + " DB " + "\"Error division\", 0" + '\n';
        this.assemblerData += "_errorNegativo" + " DB " + "\"Error resta\" , 0" + '\n';
        this.assemblerData += "_ceroDOUBLE DQ 0.0" + '\n';
        this.assemblerData += "_ceroULONGINT DD 0" + '\n';

        this.assemblerCode += ".code" + '\n';
        this.assemblerCode += "Error_Resta_Negativa:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorNegativo, addr _errorNegativo, MB_OK"+ '\n';
        this.assemblerCode += "invoke ExitProcess, 0" + '\n';
        this.assemblerCode += "Error_Division_Cero:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorCero, addr _errorCero, MB_OK"+ '\n';
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
    private String getCondicionDeSalto(String comparador) {
        switch (comparador) {
            case "<":
                return "JL";
            case "<=":
                return "JLE";
            case "==":
                return "JE";
            case "!=":
                return "JNE";
            case ">":
                return "JG";
            case ">=":
                return "JGE";
        }
        return null;
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