package ArbolSintactico;

import Principal.AtributosTablaS;
import Principal.Main;

public class NodoSalida extends ArbolSintactico{
    public NodoSalida(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    @Override
    public String generarCodigoAssembler() {
        String assembler = "";
        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(this.getHijoIzq().getLexema()); //Obtengo los atributos de la cadena a imprimir.
        String impresion = atributos.getLexema();
        assembler += "invoke MessageBox, NULL, addr _" + impresion + ", addr _" + impresion + ", MB_OK \n";
        return assembler;
    }
}
