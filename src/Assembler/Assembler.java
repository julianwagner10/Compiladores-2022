package Assembler;

import ArbolSintactico.ArbolSintactico;
import ArbolSintactico.NodoInvocacion;
import Principal.Main;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assembler {
    private ArbolSintactico arbol;

    private String assemblerData = "";
    private String assemblerCode = "";
    private String assemblerHeader = "";


    private static final long limiteSuperiorint = 2147483647;

    private static final float limiteSuperiorFloatPositivo = 3.40282347e+38f;
    private static final float limiteInferiorFloatPositivo =  1.17549435e-38f;
    private static final float limiteSuperiorFloatNegativo = -3.40282347e+38f;
    private static final float limiteInferiorFloatNegativo = -1.17549435e-38f;
    private static final float limiteFloatCero = 0.0f;


    public Assembler(ArbolSintactico arbol){
        this.arbol = arbol;
    }

    public void generarCodigoAssembler() throws IOException {
        this.assemblerHeader += ".386" + '\n' + ".model flat, stdcall" + '\n' + "option casemap :none" + '\n' +
        "include \\masm32\\include\\windows.inc" + '\n' + "include \\masm32\\include\\kernel32.inc" + '\n' +
        "include \\masm32\\include\\user32.inc" + '\n' + "includelib \\masm32\\lib\\kernel32.lib" + '\n' +
        "includelib \\masm32\\lib\\user32.lib" + '\n' + ".STACK 200h" + '\n';

        this.assemblerData += ".data" + '\n';
        this.assemblerData += "_limiteSuperiorInt DD " + limiteSuperiorint + '\n';
        this.assemblerData += "_limiteSuperiorFloatPositivo DQ " + limiteSuperiorFloatPositivo + '\n';
        this.assemblerData += "_limiteInferiorFloatPositivo DQ " + limiteInferiorFloatPositivo + '\n';
        this.assemblerData += "_limiteSuperiorFloatNegativo DQ " + limiteSuperiorFloatNegativo + '\n';
        this.assemblerData += "_limiteInferiorFloatNegativo DQ " + limiteInferiorFloatNegativo + '\n';
        this.assemblerData += "_limiteFloatCero DQ " + limiteFloatCero + '\n';



        this.assemblerData += "_errorOverflowInt" + " DB " + "\"Error suma enteros\", 0" + '\n';
        this.assemblerData += "_errorOverflowFloat" + " DB " + "\"Error suma flotante\" , 0" + '\n';

        this.assemblerCode += ".code" + '\n';

        this.assemblerCode += "Error_Suma_Enteros:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorOverflowInt, addr _errorOverflowInt, MB_OK"+ '\n';
        this.assemblerCode += "invoke ExitProcess, 0" + '\n';
        this.assemblerCode += "Error_Suma_Flotantes:"+ '\n';
        this.assemblerCode += "invoke MessageBox, NULL, addr _errorOverflowFloat, addr _errorOverflowFloat, MB_OK"+ '\n';
        this.assemblerCode += "invoke ExitProcess, 0" + '\n';
        this.assemblerCode += '\n';


        this.generarFunciones(this.arbol); //Genero todos los subprocesos, es decir, las funciones.

        this.assemblerCode += "start:" + '\n';

        if(this.arbol != null)
            this.getArbolDeMasIzq(this.arbol,"main");

        this.assemblerCode += "invoke ExitProcess, 0" + '\n' + "end start";

        this.assemblerData += Main.tablaDeSimbolos.generarCodigoAssembler();

        String assembler = this.assemblerHeader + this.assemblerData + this.assemblerCode;
        System.out.println(assembler);

        FileOutputStream fos = new FileOutputStream(new File("salida.asm"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(this.assemblerHeader + this.assemblerData  + this.assemblerCode);

        bw.close();

    }

    public void getArbolDeMasIzq(ArbolSintactico raiz, String ambitoActual) {
        if (raiz != null && !raiz.esHoja()) {
            if (raiz.getHijoIzq() != null) {
                if ((raiz.getHijoDer() != null)) {
                    if (raiz.getHijoIzq().esHoja() && raiz.getHijoDer().esHoja() && raiz.getAtributo().getAmbito().equals(ambitoActual)) {
                        this.assemblerCode += raiz.generarCodigoAssembler();
                    } else {
                        this.getArbolDeMasIzq(raiz.getHijoIzq(),ambitoActual);
                        this.getArbolDeMasIzq(raiz.getHijoDer(),ambitoActual);
                        if(raiz.getAtributo().getAmbito().equals(ambitoActual))
                            this.assemblerCode += raiz.generarCodigoAssembler();
                    }
                } else {
                    if (raiz.getHijoIzq().esHoja() && raiz.getAtributo().getAmbito().equals(ambitoActual)) {
                        this.assemblerCode += raiz.generarCodigoAssembler();
                    }
                    else {
                        this.getArbolDeMasIzq(raiz.getHijoIzq(),ambitoActual);
                        if(raiz.getAtributo().getAmbito().equals(ambitoActual))
                            this.assemblerCode += raiz.generarCodigoAssembler();
                    }
                }
            }
        }
    }

    public void generarFunciones(ArbolSintactico raiz){
        this.assemblerCode += "";
        ArrayList<String> funcionesGeneradas = new ArrayList<>(); //Necesito llevar un registro de las funciones a las cuales ya se le genero aseembler
        if(raiz != null) {
            for (String am : Main.listaDeAmbitos) {
                if (!am.equals("main")) {
                    String idFuncion = Main.tablaDeSimbolos.getFuncionMedianteAmbito( am.substring(0,am.lastIndexOf(".")),funcionesGeneradas);
                        this.assemblerCode += idFuncion.replace('.', '_') + ":" + '\n'; //Reemplazo por sintaxis aceptada por assembler
                        String subId = idFuncion.substring(0, idFuncion.indexOf(".", 0)); //Obtengo el nombre de la funcion sin nameMangling
                        am = Main.tablaDeSimbolos.getAtributosTablaS(idFuncion).getAmbito() + "." + subId; //Recreo el ambito interno de cada funcion para poder generar assembler independiente de cada una.
                        this.getArbolDeMasIzq(raiz, am); //Creo assembler para cada funcion en base a su ambito interno.
                        this.assemblerCode += "ret" + '\n';
                        this.assemblerCode += '\n';
                }
            }
        }
    }
}