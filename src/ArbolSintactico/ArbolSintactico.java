package ArbolSintactico;

import Principal.AtributosTablaS;

public abstract class ArbolSintactico {
    private ArbolSintactico hijoIzq = null;
    private ArbolSintactico hijoDer = null;
    private AtributosTablaS atributo;

    private String operador = null;
    private int cant = 0;
    private String printTree = "";

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
    public ArbolSintactico(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
    }

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
        if(this.hijoIzq == null)
            this.hijoIzq = hijoIzq;
        else{
            ArbolSintactico aux = this.hijoIzq;
            while(aux.hijoIzq != null){
                aux = aux.hijoIzq;
            }
            aux.hijoIzq = hijoIzq;
        }
    }

    public void setHijoDer(ArbolSintactico hijoDer) {
        if(this.hijoDer == null)
            this.hijoDer = hijoDer;
        else{
            ArbolSintactico aux = this.hijoDer;
            while(aux.hijoDer != null){
                aux = aux.hijoDer;
            }
            aux.hijoDer = hijoDer;
        }
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
            this.printTree += tab(cant, hijo+nodo.getLexeme(), nodo.getTipo(), nodo.atributo.getUso()); // mostrar datos del nodo
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


    public String getLexeme() {
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

    public void setTipo(String tipo){
        this.atributo.setTipo(tipo);
    }
}
