package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoAsignacionFor extends ArbolSintactico{

    public NodoAsignacionFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
        chequearCompatiblidadTipo(hijoIzq,hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
        String lexemaDer = this.getHijoDer().getLexemaReemplazado();
        assembler += "MOV EBX, _" + lexemaDer + '\n';
        assembler += "MOV _" + lexemaIzq + ", " + "EBX" + '\n';

        String label = "FOR_INICIO " + ++contador;
        NodoFor.etiquetaDeSalto.push(label);
        assembler += label + ":" + '\n';

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
