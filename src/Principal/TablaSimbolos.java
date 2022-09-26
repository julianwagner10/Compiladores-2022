package Principal;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class TablaSimbolos {
    private static Hashtable<String, List<AtributosTablaS>> tablaSimbolos;

    public TablaSimbolos(){

        tablaSimbolos = new Hashtable<String,List<AtributosTablaS>>();
    }

    public void eliminarSimbolo(String lexema) {
        tablaSimbolos.remove(lexema);
    }

    public boolean existeLexema(String lexema) {
        return (tablaSimbolos.containsKey(lexema));
    }

    public List<Integer> getIdentificador(String lexema){
        List<Integer> retorno = new ArrayList<>();
        if(tablaSimbolos.containsKey(lexema)){
            List<AtributosTablaS> aux = tablaSimbolos.get(lexema);
            for(int i=0;i<aux.size();i++) {
                retorno.add(aux.get(i).getIdentificador());
            }
            return retorno;
        }
        else
            return null;
    }

    public void modificarSimbolo(String lexemaviejo, String lexemaNuevo) {
        tablaSimbolos.put(lexemaNuevo,tablaSimbolos.get(lexemaviejo));
        tablaSimbolos.remove(lexemaviejo);
    }

    public boolean esPalabraReservada(String lexema) {
        if (tablaSimbolos.containsKey(lexema)) {
            int identificador = this.tablaSimbolos.get(lexema).get(0).getIdentificador();
            if (identificador > 256 && identificador < 268)
                return false;
            else
                return true;
        }
        return false;
    }

    public void setAtributosDeSimbolo(String nuevoLexema, List<AtributosTablaS> atributos){
        this.tablaSimbolos.replace(nuevoLexema,atributos);
    }

    public void setSimbolo(String lexema, int id){

        if(tablaSimbolos.containsKey(lexema)){
            if(!this.esPalabraReservada(lexema)){
                /*AtributosTablaS at = new AtributosTablaS(id,tipo,uso);
                tablaSimbolos.put(lexema,at);*/
            }
        }
    }

    public void mostrarTablasimbolos(){
        ArrayList<String> aux = new ArrayList<>();
        List<Integer> identificadores = new ArrayList<>();
        Set<String> keys = tablaSimbolos.keySet();
        aux.addAll(keys);
        for(String lexema:aux){
            if(!this.esPalabraReservada(lexema)) {
                identificadores = this.getIdentificador(lexema);
                if (identificadores!=null) {
                    for(int i=0;i<identificadores.size();i++){
                        System.out.print("Id:" + identificadores.get(i) + " Lexema: " + lexema);
                        System.out.println();
                    }
                }
            }
        }
    }
}
