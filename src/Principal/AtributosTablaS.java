package Principal;

import java.util.ArrayList;
import java.util.List;

public class AtributosTablaS {
    private String lexema;
    private int identificador;
    private String tipo = null;
    private String uso = "";
    private String ambito = "";
    private List<String> listaDeParametros;

    private int orden;

    public AtributosTablaS(int id, String tipo, String uso, String ambito, String lexema){
        this.identificador = id;
        this.tipo = tipo;
        this.uso = uso;
        this.ambito = ambito;
        this.lexema = lexema;
        this.listaDeParametros = new ArrayList<>();

    }
    public AtributosTablaS(String lexema){
        this.lexema = lexema;
        this.listaDeParametros = new ArrayList<>();
    }
    public int getIdentificador(){
        return this.identificador;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getUso() {
        return uso;
    }

    public String getAmbito() {
        return ambito;
    }

    public String getLexema(){return lexema;}

    public int getOrden(){return this.orden;}
    public void modificarLexema(String lexema){
        this.lexema = lexema;
    }

    public void setUso(String uso){this.uso=uso;}

    public void setTipo(String tipo){this.tipo=tipo;}

    public void setOrden(int orden){this.orden=orden;}

    public void setLexema(String lexema){
        this.lexema=lexema;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public void setParametroEnLista(String parametro){
        this.listaDeParametros.add(parametro);
    }

    public void setListaDeParametros(List<String> listaDeParametros){
        this.listaDeParametros.addAll(listaDeParametros);
    }

    public List<String> getListaDeParametros(){
        return this.listaDeParametros;
    }
}