package Principal;

public class AtributosTablaS {
    private int identificador;
    private String tipo;

    private String ambito;
    //Despues hay que ver que otros atributos agregamos.

    public AtributosTablaS(int id, String tipo){
        this.identificador = id;
        this.tipo = tipo;
    }

    public int getIdentificador(){
        return this.identificador;
    }


    public String getTipo(){
        return this.tipo;
    }


    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

}