package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoAsignacion extends ConTipo{

    public NodoAsignacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
        System.out.println("TIPO DE LA ASIGNACION antes del chequeo"+super.getType());
        chequearCompatiblidadTipo(hijoIzq,hijoDer);
        System.out.println("TIPO DE LA ASIGNACION despues del chequeo"+super.getType());
    }

    @Override
    public void chequearCompatiblidadTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        String tipoIzq = hijoIzq.getType();
        String tipoDer = hijoDer.getType();
        if (tipoIzq.equals(tipoDer)) {
            /*System.out.println("COINCIDEN LOS TIPOS");
            System.out.println("TIPO izq"+tipoIzq);
            System.out.println("TIPO der"+tipoDer);*/
            super.setTipo(tipoIzq);
        }
        else{
            if (tipoIzq.equals("FLOAT")){
                super.setTipo("FLOAT");
                hijoDer.setTipo("FLOAT");
                System.out.println("no COINCIDEN LOS TIPOS PERO HAGO LA CONVERSION");
            }else{
                super.setTipo(null);
                System.out.println("NO COINCIDEN LOS TIPOS Y NO CONVIERTO");
            }

        }
    }
}
