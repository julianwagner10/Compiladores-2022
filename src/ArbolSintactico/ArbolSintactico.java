package ArbolSintactico;

import Principal.AtributosTablaS;

public class ArbolSintactico {
    private ArbolSintactico hijoIzq = null;
    private ArbolSintactico hijoDer = null;
    private AtributosTablaS atributo;
    private boolean isHoja;

    public ArbolSintactico(AtributosTablaS atributo, boolean isHoja) {
        this.atributo = atributo;
        this.isHoja = isHoja;
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

    public boolean isHoja() {
        return this.isHoja;
    }

    public void setHoja(boolean hoja) {
        this.isHoja = hoja;
    }

}
