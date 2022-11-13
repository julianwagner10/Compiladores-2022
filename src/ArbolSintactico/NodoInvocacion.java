package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Main;

import java.util.ArrayList;
import java.util.List;

public class NodoInvocacion extends ArbolSintactico{

    private List<String> listaDeParametros;

    public NodoInvocacion(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
        this.listaDeParametros = new ArrayList<>();
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        String idFuncionAInvocar = this.getHijoIzq().getAtributo().getLexema();
        this.listaDeParametros.addAll(Main.tablaDeSimbolos.getAtributosTablaS(idFuncionAInvocar).getListaDeParametros());
        if(!this.listaDeParametros.isEmpty()){
            List<String> listaDeParametrosReales = new ArrayList<>();
            listaDeParametrosReales.addAll(this.getHijoDer().getAtributo().getListaDeParametros());
            for(int i=0; i< listaDeParametrosReales.size();i++){
                if(Main.tablaDeSimbolos.getAtributosTablaS(listaDeParametrosReales.get(i)).getTipo().equals("i32")){
                    assembler += "MOV _"+ this.listaDeParametros.get(i) + ", _" + listaDeParametrosReales.get(i) + '\n';
                }
                else{
                    assembler += "FLD _" +listaDeParametrosReales.get(i) + '\n';
                    assembler += "FSTP _" + this.listaDeParametros.get(i) + '\n';
                }
            }
        }
        assembler += "CALL " + idFuncionAInvocar + '\n';
        return assembler;
    }
}
