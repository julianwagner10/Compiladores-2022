package ArbolSintactico;

import Principal.AtributosTablaS;
import Assembler.Assembler;

import java.sql.SQLOutput;

public abstract class ArbolSintactico {
    private ArbolSintactico hijoIzq = null;
    private ArbolSintactico hijoDer = null;
    private AtributosTablaS atributo;

    private String operador = null;
    private int cant = 0;
    private String printTree = "";
    private String varRetorno = null; //Variable creada para poder obtener el valor a asignar cuando se usa una sentencia de control como expresion.

    public static int contador = 0;
    String id = null;

    public ArbolSintactico(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.atributo = atributo;

    }

    public ArbolSintactico(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, String operador) {
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.operador = operador;
    }

    public  abstract String generarCodigoAssembler();
    public ArbolSintactico getHijoIzq() {
        return this.hijoIzq;
    }

    public ArbolSintactico getHijoDer() {
        return this.hijoDer;
    }

    public AtributosTablaS getAtributo() {
        return this.atributo;
    }

    public void setHijoIzq(ArbolSintactico hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(ArbolSintactico hijoDer) {
        this.hijoDer = hijoDer;
    }

    public void setAtributo(AtributosTablaS atributo) {
        this.atributo = atributo;
    }

    public void printTree(ArbolSintactico nodo, String hijo) {
        if (nodo != null) {
            if (nodo.esHoja()) {
                this.printTree += tab(cant, hijo+nodo.atributo.getLexema(), nodo.atributo.getTipo(), nodo.atributo.getUso());
                return;
            }
            this.printTree += tab(cant, hijo+nodo.getLexema(), nodo.getTipo(), nodo.atributo.getUso()); // mostrar datos del nodo
            cant++;
            printTree(nodo.getHijoIzq(), "Hijo izquierdo: "); //recorre subarbol izquierdo
            printTree(nodo.getHijoDer(), "Hijo derecho: "); //recorre subarbol derecho
            cant--;
        }
    }
    private String tab(int cant, String lexeme, String type, String use){
        for(int i=cant; i>0; i--){
            lexeme = '\t' + lexeme;
        }
        return lexeme + '\n';
    }

    public boolean esHoja(){
        return (this.getHijoIzq() == null && this.getHijoDer() == null);
    }

    public String getPrintTree(){
        return this.printTree;
    }


    public String getLexema() {
        if (atributo.getLexema().isEmpty()){
            return operador;
        }
        else{
            return atributo.getLexema();
        }
    }
    public String getTipo() {
        return this.atributo.getTipo();
    }

    public String getUso(){
        return this.atributo.getUso();
    }

    public void setTipo(String tipo){
        this.atributo.setTipo(tipo);
    }

    public void eliminarHijos(ArbolSintactico raiz){
        raiz.setHijoIzq(null);
        raiz.setHijoDer(null);
    }

    public void reemplazarAtributos(ArbolSintactico raiz, AtributosTablaS atributos){
        this.atributo = atributos;
    }

    public String  getLexemaReemplazado(){
        this.atributo.setLexema(this.atributo.getLexema().replace('.','_'));
        return this.atributo.getLexema();
    }

    public String getCondicionDeSalto(String comparador) {
        switch (comparador) {
            case "<":
                return "JGE";
            case "<=":
                return "JG";
            case "=":
                return "JNE";
            case "!=":
                return "JE";
            case ">":
                return "JLE";
            case ">=":
                return "JL";
        }
        return null;
    }

    public String getCondicionDeSaltoSinSigno(String comparador) { //Metodo declarado para obtener las bifurcaciones despues de una comparacion entre flotantes.
        switch (comparador) {
            case "<":
                return "JAE";
            case "<=":
                return "JA";
            case "=":
                return "JNE";
            case "!=":
                return "JE";
            case ">":
                return "JBE";
            case ">=":
                return "JB";
        }
        return null;
    }

    public void setId(String id){
        this.id = id.replace(".","_");
    }

    public String getVarRetorno() {
        return this.varRetorno;
    }

    public void setVarRetorno(String varRetorno) {
        this.varRetorno = varRetorno;
    }
}