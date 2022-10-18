package ArbolSintactico;

import Principal.AtributosTablaS;

public class ArbolSintactico {
    private ArbolSintactico hijoIzq = null;
    private ArbolSintactico hijoDer = null;
    private AtributosTablaS atributo = null;

    public ArbolSintactico(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        this.hijoIzq = hijoIzq;
        this.hijoDer = hijoDer;
        this.atributo = atributo;
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
        this.hijoIzq = hijoIzq;
    }

    public void setHijoDer(ArbolSintactico hijoDer) {
        this.hijoDer = hijoDer;
    }

    public void setAtributo(AtributosTablaS atributo) {
        this.atributo = atributo;
    }
}
