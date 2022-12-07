package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCuerpoThen extends ArbolSintactico{

    private static int contador = 0;
    private boolean existeBreak = false;

    public NodoCuerpoThen(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoCuerpoThen(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, String operador) {
        super(hijoIzq, hijoDer, operador);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        buscarExistenciaDeBreak(this);
        if(!this.existeBreak) {
            String label = "IF_THEN" + ++contador;  //Si estoy en el then, quiere decir que me tengo que saltear al else.
            assembler += "JMP " + label + '\n';  //Genero la etiqueta correspondiente a la bifurcacion incondicional, es decir, no voy a entrar al else.
            if (!NodoIf.etiquetaDeSalto.isEmpty()) {
                assembler += NodoIf.etiquetaDeSalto.pop() + ":" + '\n'; //Desapilo la etiqueta correspondiente a la bifurcacion con su respectivo salto.
                NodoIf.etiquetaDeSalto.push(label); //Apilo la etiqueta generada para la bifurcacion incondicional.
            }else{
                NodoIf.etiquetaDeSalto.push(label);
            }
        }
        else{
            String label1 = "BREAK_CTRL" + ++contador;
            assembler += "JMP " + label1 + '\n';
            NodoIf.etiquetaDeSalto.push(label1);
        }
        return assembler;
    }

    public void buscarExistenciaDeBreak(ArbolSintactico raiz) {
        if (raiz.getLexema().equals("break retorno")) {
            this.existeBreak = true;
        } else if (raiz.getHijoIzq() != null && raiz.getHijoDer() == null) {
            this.buscarExistenciaDeBreak(raiz.getHijoIzq());
        }else if (raiz.getHijoDer() != null && raiz.getHijoIzq() == null) {
            this.buscarExistenciaDeBreak(raiz.getHijoDer());
        } else if (!raiz.esHoja()) {
            this.buscarExistenciaDeBreak(raiz.getHijoIzq());
            this.buscarExistenciaDeBreak(raiz.getHijoDer());
        }
    }


}
