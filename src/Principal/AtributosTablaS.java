package Principal;

public class AtributosTablaS {
    private String lexema;
    private int identificador;
    private String tipo ="";
    private String uso = "";
    private String ambito = "";

    public AtributosTablaS(int id, String tipo, String uso, String ambito, String lexema){
        this.identificador = id;
        this.tipo = tipo;
        this.uso = uso;
        this.ambito = ambito;
        this.lexema = lexema;
    }
    public AtributosTablaS(String lexema){
        this.lexema = lexema;
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

    public String getLexema(){return lexema;}

    public void modificarLexema(String lexema){
        this.lexema = lexema;
    }

    public void setUso(String uso){this.uso=uso;}

    public void setTipo(String tipo){this.tipo=tipo;}
}