package ArbolSintactico;

import Principal.AtributosTablaS;

public abstract class ConTipo extends ArbolSintactico{
    public ConTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo){
        super(hijoIzq,hijoDer,atributo);
    }

    public abstract void chequearCompatiblidadTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer);

    public void setTipo(String tipo){
        super.getAtributo().setTipo(tipo);
    }
    public String getTipo(){return super.getType();}
}
