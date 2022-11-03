package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoAsignacion extends ArbolSintactico{

    public NodoAsignacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
        chequearCompatiblidadTipo(hijoIzq,hijoDer);
    }

    public void chequearCompatiblidadTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        String tipoIzq = hijoIzq.getTipo();
        String tipoDer = hijoDer.getTipo();
        if (tipoIzq.equals(tipoDer))
            super.setTipo(tipoIzq);
        else{
            if (tipoIzq.equals("f32")){
                super.setTipo("f32");
                hijoDer.setTipo("f32");
            }else{
                super.setTipo(null);
            }

        }
    }

}
