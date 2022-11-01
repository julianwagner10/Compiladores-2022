package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoOperacion extends ArbolSintactico{

    public NodoOperacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
        chequearCompatiblidadTipo(hijoIzq,hijoDer);
    }

    public void chequearCompatiblidadTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        String tipoIzq = hijoIzq.getTipo();
        String tipoDer = hijoDer.getTipo();
        if (tipoIzq.equals(tipoDer))
            super.setTipo(tipoIzq);
        else{
            if (tipoIzq.equals("FLOAT")){
                super.setTipo("FLOAT");
                hijoDer.setTipo("FLOAT");
            }else{
                super.setTipo("FLOAT");
                hijoIzq.setTipo("FLOAT");
            }

        }
    }
}