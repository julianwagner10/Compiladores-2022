package Principal;

import java.util.*;

public class TablaSimbolos {
    private static Hashtable<String, AtributosTablaS> tablaSimbolos;

    public TablaSimbolos() {

        tablaSimbolos = new Hashtable<>();
    }

    public void eliminarSimbolo(String lexema) {
        if(this.tablaSimbolos.contains(lexema))
            this.tablaSimbolos.remove(lexema);
    }

    public boolean existeLexema(String lexema) {
        return (tablaSimbolos.containsKey(lexema));
    }

    public Integer getIdentificador(String lexema) {
        if (tablaSimbolos.containsKey(lexema)) {
            return tablaSimbolos.get(lexema).getIdentificador();
        } else
            return null;
    }

    public void modificarSimbolo(String lexemaviejo, String lexemaNuevo) {
        AtributosTablaS atributos = tablaSimbolos.get(lexemaviejo);
        atributos.modificarLexema(lexemaNuevo);
        tablaSimbolos.remove(lexemaviejo);
        tablaSimbolos.put(lexemaNuevo, atributos);

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

    public void setAtributosDeSimbolo(String nuevoLexema, AtributosTablaS atributos) {
        this.tablaSimbolos.replace(nuevoLexema, atributos);
    }

    public void setSimbolo(String lexema, int id) {

        if (tablaSimbolos.containsKey(lexema))
            System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto un lexema ya existente en la tabla de simbolos, con valor -> " + lexema);
        else {
            if (!this.esPalabraReservada(lexema)) {
                AtributosTablaS at = new AtributosTablaS(id, "", "", "", lexema); //Los datos vacios  son temporales para evitar errores.
                tablaSimbolos.put(lexema, at);
            }
        }
    }

    public void setSimbolo(String lexema, int id, String tipo) {

        if (tablaSimbolos.containsKey(lexema))
            System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto un lexema ya existente en la tabla de simbolos, con valor -> " + lexema);
        else {
            if (!this.esPalabraReservada(lexema)) {
                AtributosTablaS at = new AtributosTablaS(id, tipo, "", "", lexema); //Los datos vacios  son temporales para evitar errores.
                tablaSimbolos.put(lexema, at);
            }
        }
    }
    public void setSimbolo(String lexema, int id, String tipo,String uso) {

        if (tablaSimbolos.containsKey(lexema))
            System.out.println("[Lexico | linea " + Lexico.linea + "] Se detecto un lexema ya existente en la tabla de simbolos, con valor -> " + lexema);
        else {
            if (!this.esPalabraReservada(lexema)) {
                AtributosTablaS at = new AtributosTablaS(id, tipo, uso, "", lexema); //Los datos vacios  son temporales para evitar errores.
                tablaSimbolos.put(lexema, at);
            }
        }
    }
    public void mostrarTablasimbolos() {
        Enumeration iterator = tablaSimbolos.keys();
        while (iterator.hasMoreElements()) {
            String lexema = (String) iterator.nextElement();
            if (!esPalabraReservada(lexema)) {
                AtributosTablaS ats = tablaSimbolos.get(lexema);
                System.out.print("Id:" + ats.getIdentificador() + " Lexema: " + lexema);
                System.out.println();
            }
        }
    }

    public AtributosTablaS getAtributosTablaS(String lexema) {
        if (tablaSimbolos.containsKey(lexema))
            return tablaSimbolos.get(lexema);
        return null;
    }


    public String chequearAmbito(String id, String ambito) {
        String aux = id + "." + ambito;
        while (!aux.equals(id)) { //Hasta que no desgloce todo el ambito
            if (tablaSimbolos.containsKey(aux)) {
                return aux;
            }
            aux = aux.substring(0, aux.lastIndexOf("."));
        }
        return null;
    }

    public String generarCodigoAssembler(){
        String assembler ="";
        String value = "";
        int counter = 0;
        for(String key : this.tablaSimbolos.keySet()) {
                AtributosTablaS atributos = this.tablaSimbolos.get(key);
                String lexema = atributos.getLexema();
                switch (atributos.getIdentificador()) {
                    case (Lexico.ID):
                        if(atributos.getTipo().equals("i32")){
                            assembler += "_" + lexema.replace('.','_') + " DD ?"  + '\n'; //32 bits
                        }
                        if(atributos.getTipo().equals("f32")) {
                            assembler += "_" + lexema.replace('.','_') + " DQ ?"  + '\n'; //32 bits
                        }
                        break;
                    case (Lexico.CADENA):
                        assembler = assembler + "_" + lexema.replace('.','_') + " DB " + lexema + ", 0 \n";
                        break;

                    case (Lexico.CTE_INT):
                        assembler = assembler + "_" + lexema.replace('.','_') + " DD " + lexema + '\n';
                        break;

                    case (Lexico.CTE_FLOTANTE):
                        assembler += "_" + lexema.replace('.','_') + " DQ " + lexema + '\n'; //64 bits
                        break;

            }
        }
        return assembler;
    }

}