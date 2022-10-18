package Principal;

import java.util.*;

public class TablaSimbolos {
    private static Hashtable<String,AtributosTablaS> tablaSimbolos;

    public TablaSimbolos(){

        tablaSimbolos = new Hashtable<>();
    }

    public void eliminarSimbolo(String lexema) {
        tablaSimbolos.remove(lexema);
    }

    public boolean existeLexema(String lexema) {
        return (tablaSimbolos.containsKey(lexema));
    }

    public Integer getIdentificador(String lexema){
        if(tablaSimbolos.containsKey(lexema)){
            return tablaSimbolos.get(lexema).getIdentificador();
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
            int identificador = tablaSimbolos.get(lexema).getIdentificador();
            if (identificador > 256 && identificador < 265)
                return false;
            else
                return true;
        }
        return false;
    }

    public void setAtributosDeSimbolo(String nuevoLexema, AtributosTablaS atributos){
        this.tablaSimbolos.replace(nuevoLexema,atributos);
    }

    public void setSimbolo(String lexema, int id){

        if(tablaSimbolos.containsKey(lexema))
            System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto un lexema ya existente en la tabla de simbolos, con valor -> "+ lexema );
        else {
            if (!this.esPalabraReservada(lexema)) {
                AtributosTablaS at = new AtributosTablaS(id,"","",""); //Los datos vacios  son temporales para evitar errores.
                tablaSimbolos.put(lexema, at);
            }
        }
    }

    public void mostrarTablasimbolos(){
        Enumeration iterator = tablaSimbolos.keys();
        while(iterator.hasMoreElements()){
            String lexema = (String)iterator.nextElement();
            if (!esPalabraReservada(lexema)) {
                AtributosTablaS ats = tablaSimbolos.get(lexema);
                System.out.print("Id:" + ats.getIdentificador() + " Lexema: " + lexema);
                System.out.println();
            }
        }
    }
}
