package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Main;
import Principal.Lexico;

public class NodoAsignacion extends ArbolSintactico{

    String valorRetorno = null;
    String variableRetorno = null;

    public NodoAsignacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributos){
        super(hijoIzq,hijoDer,atributos);
        chequearCompatiblidadTipo(hijoIzq,hijoDer);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
        String lexemaDer = null;



        if(this.getLexema().equals("Asignacion"))
            if(this.getHijoDer().getLexema().equals("Invocacion")){ //Aqui obtengo el valor de retorno de una funcion, cuando se la invoca en una asignacion.
                String idFuncion = this.getHijoDer().getHijoIzq().getLexema();
                lexemaDer = Main.tablaDeSimbolos.getValorDeRetornoDeFuncion(idFuncion.replace('_','.'));
            }
            else
                lexemaDer = this.getHijoDer().getLexemaReemplazado();
        else
            if(this.getLexema().equals("AsignacionConControl")){
                this.getValorDeRetornoDeControl(this.getHijoDer());
                lexemaDer = this.variableRetorno;
            }
        if (this.getTipo().equals("i32")) {
            assembler += "MOV EBX, _" + lexemaDer + '\n';
            assembler += "MOV _" + lexemaIzq + ", " + "EBX" + '\n';
        }else{
            lexemaDer = lexemaDer.replace("+","__");
            lexemaDer = lexemaDer.replace('.','_');
            lexemaDer = lexemaDer.replace('-','_');
            assembler += "FLD _" + lexemaDer+ '\n';
            assembler += "FSTP _" + lexemaIzq + '\n';
        }
        this.eliminarHijos(this);
        return assembler;
    }

    public void chequearCompatiblidadTipo(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        String tipoIzq = hijoIzq.getTipo();
        String tipoDer = hijoDer.getTipo();
        if (tipoIzq.equals(tipoDer) ) {
            super.setTipo(tipoIzq);
        }
        else{
            if (tipoIzq.equals("f32")){
                super.setTipo("f32");
                Main.informesSemanticos.add("[Parser | Linea " + Lexico.linea + "] se realizo una conversion de "+hijoDer.getTipo()+", a "+tipoIzq);
                hijoDer.setTipo("f32");
            }else{
                super.setTipo(null);
            }
        }
    }

    public void getValorDeRetornoDeControl(ArbolSintactico raiz) {
        if (raiz.getLexema().equals("break retorno") || raiz.getLexema().equals("valor por defecto")) {
            this.valorRetorno = raiz.getHijoIzq().getLexemaReemplazado();
            this.variableRetorno = raiz.getVarRetorno();
        } else if (raiz.getHijoIzq() != null && raiz.getHijoDer() == null) {
                    this.getValorDeRetornoDeControl(raiz.getHijoIzq());
                }else if (raiz.getHijoDer() != null && raiz.getHijoIzq() == null) {
                            this.getValorDeRetornoDeControl(raiz.getHijoDer());
                        } else if (!raiz.esHoja()) {
                                    this.getValorDeRetornoDeControl(raiz.getHijoIzq());
                                    this.getValorDeRetornoDeControl(raiz.getHijoDer());
                                }
    }
}