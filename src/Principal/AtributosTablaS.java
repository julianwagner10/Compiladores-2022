package Principal;

public class AtributosTablaS {
    private int identificador;
    private String tipo ="";
    private String uso = "";
    private String ambito = "";

    public AtributosTablaS(int id, String tipo, String uso, String ambito){
        this.identificador = id;
        this.tipo = tipo;
        this.uso = uso;
        this.ambito = ambito;
    }

    public int getIdentificador(){
        return this.identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUso() {
        return uso;
    }

    public String getAmbito() {
        return ambito;
    }
}