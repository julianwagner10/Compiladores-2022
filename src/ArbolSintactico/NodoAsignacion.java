package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoAsignacion extends ArbolSintactico{

    public NodoAsignacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
        chequearCompatiblidadTipo(hijoIzq,hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
        String lexemaDer = this.getHijoDer().getLexemaReemplazado();
        if (this.getTipo().equals("i32")) {
            assembler += "MOV EBX, " + lexemaDer + '\n';
            assembler += "MOV _" + lexemaIzq + ", " + "EBX" + '\n';
        }else{
            assembler += "FLD " + lexemaDer+ '\n';
            assembler += "FSTP _" + lexemaIzq + '\n';

        }
        this.eliminarHijos(this);
        return assembler;
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
