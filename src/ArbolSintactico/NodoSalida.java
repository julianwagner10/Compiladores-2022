package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoSalida extends ArbolSintactico{
    public NodoSalida(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoSalida(ArbolSintactico hijoIzq, ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }
}
