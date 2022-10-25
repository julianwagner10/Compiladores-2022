package ArbolSintactico;

import Principal.AtributosTablaS;

public class NodoCuerpoFor extends ArbolSintactico{
    public NodoCuerpoFor(ArbolSintactico hijoIzq, ArbolSintactico hijoDer, AtributosTablaS atributo) {
        super(hijoIzq, hijoDer, atributo);
    }

    public NodoCuerpoFor(ArbolSintactico hijoIzq,ArbolSintactico hijoDer) {
        super(hijoIzq, hijoDer);
    }
}
