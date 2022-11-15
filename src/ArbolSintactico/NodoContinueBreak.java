package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoContinueBreak extends ArbolSintactico{
    public NodoContinueBreak(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String label;
        String label1;
        System.out.println("Entre a nodo continue break");
        switch (this.getLexema()) {
            case ("break"):
                if(!NodoFor.etiquetaDeSalto.empty()) {
                    System.out.println("entre por el lado del break");
                    label = NodoFor.etiquetaDeSalto.pop();
                    assembler += "JMP " + label + '\n';
                    NodoFor.etiquetaDeSalto.push(label);
                }
                break;
            case ("continue"):
                if(!NodoFor.etiquetaDeSalto.empty()) {
                    label = NodoFor.etiquetaDeSalto.pop();
                    label1 = NodoFor.etiquetaDeSalto.pop();
                    assembler += "JMP " + label1 + '\n';
                    NodoFor.etiquetaDeSalto.push(label);
                    NodoFor.etiquetaDeSalto.push(label1);
                }
                break;
            case ("continue con etiquetado"):
                assembler += "JMP " + this.getHijoDer().getLexemaReemplazado() + '\n';
                this.setId(this.getHijoDer().getLexema());
                break;
            case ("break retorno"):
                System.out.println("entre por el lado del break retorno");
                if(this.getTipo().equals("i32")) {
                    String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
                    assembler += "MOV EAX, _"+lexemaIzq + '\n';
                }
                else{
                    String lexemaIzq = this.getHijoIzq().getLexemaReemplazado();
                    assembler += "FLD " +lexemaIzq;
                }
                break;

        }
        return assembler;

    }
}
