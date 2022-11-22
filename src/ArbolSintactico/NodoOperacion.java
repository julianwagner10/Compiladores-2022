package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoOperacion extends ArbolSintactico {

    public NodoOperacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos) {
        super(hijoIzq, hijoDer, atributos);
        chequearCompatiblidadTipo(hijoIzq, hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        return assembler;
    }

    public void chequearCompatiblidadTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        if (hijoIzq != null && hijoDer != null) {
            String tipoIzq = hijoIzq.getTipo();
            String tipoDer = hijoDer.getTipo();
            if (tipoIzq.equals(tipoDer))
                super.setTipo(tipoIzq);
            else
                super.setTipo("f32");
        }
    }
}