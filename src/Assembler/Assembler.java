package Assembler;

import ArbolSintactico.ArbolSintactico;

public class Assembler {
    private ArbolSintactico arbol;

    private String assemblerData = "";
    private String assemblerCode = "";
    private boolean EAX;
    private boolean EBX;
    private boolean ECX;
    private boolean EDX;

    private static final int limiteSuperiorint = 65535;
    private static final int limiteInferiorint = 0;
    private static final double limiteInferiorDoublePositivo = 2.2250738585272014d-308;
    private static final double limiteSuperiorDoublePositivo = 1.7976931348623157d+308;
    private static final double limiteInferiorDoubleNegativo = -1.7976931348623157d+308;
    private static final double limiteSuperiorDoubleNegativo = -2.2250738585072014d-308;
    private static final double limiteDoubleCero = 0.0;

    public Assembler(ArbolSintactico arbol){
        this.arbol = arbol;
        this.EAX = true;
        this.EBX = true;
        this.ECX = true;
        this.EDX = true;
    }


    private String getRegistro() {
        if (ECX) {
            ECX = false;
            return "ECX";
        } else if (EBX) {
            EBX = false;
            return "EBX";
        } else if (EAX) {
            EAX = false;
            return "EAX";
        } else if (EDX) {
            EDX = false;
            return "EDX";
        }
        return null;
    }

    private void liberarRegistro(String registro) {
        if (registro.equals("EAX"))
            EAX = true;
        if (registro.equals("EBX"))
            EBX = true;
        if (registro.equals("ECX"))
            ECX = true;
        if (registro.equals("EDX"))
            EDX = true;
    }

    private String tipoSalto(String comparador) {
        switch (comparador) {
            case "==":
                return "JNE";
            case "!=":
                return "JE";
            case "<":
                return "JAE";
            case "<=":
                return "JA";
            case ">":
                return "JBE";
            case ">=":
                return "JB";
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