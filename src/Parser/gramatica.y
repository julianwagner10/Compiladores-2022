%{
package Parser;
import Principal.*;
import ArbolSintactico.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

%}

%token ID CTE_INT CTE_FLOTANTE MENOR_IGUAL MAYOR_IGUAL DISTINTO CADENA ASIGNACION IF THEN ELSE ENDIF OUT FUN RETURN BREAK DISCARD FOR CONTINUE F32 I32

%start programa

%%

programa : ID '{' bloque'}' {arbolSintactico = $3.arbol;
                            Main.tablaDeSimbolos.getAtributosTablaS($1.sval).setUso("nombrePrograma");
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
         | error_programa; {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
         ;

error_programa : '{'bloque'}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
               | ID error bloque'}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
               | ID '{'bloque  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
               ;

bloque : sentencia {$$.arbol = $1.arbol;}
       | bloque sentencia {     if($2.arbol != null){
                                        if ($1.arbol !=null){
                                            AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                            atributos.setAmbito(ambito);
                                            $$.arbol = new NodoBloqueEjecutable($1.arbol,$2.arbol,atributos);
                                    }else{
                                         AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                         atributos.setAmbito(ambito);
                                         $$.arbol = new NodoBloqueEjecutable($2.arbol,$1.arbol,atributos);
                                    }
                                }
                           }
       | error_bloque
       ;

error_bloque: error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
            ;

sentencia : declaracion {$$.arbol = $1.arbol;}
          | ejecucion {$$.arbol = $1.arbol;}
          ;

bloque_ejecutable_for: ejecucion_control {$$.arbol = $1.arbol;}
                     | bloque_ejecutable_for ejecucion_control{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableFor");
                                                               atributos.setAmbito(ambito);
                                                               $$.arbol = new NodoBloqueEjecutable($1.arbol,$2.arbol,atributos);}
                     ;

bloque_ejecutable_if: ejecucion {$$.arbol = $1.arbol;}
                    | bloque_ejecutable_if ejecucion {AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableIf");
                                                      atributos.setAmbito(ambito);
                                                      $$.arbol = new NodoBloqueEjecutable($1.arbol,$2.arbol,atributos);}
                    ;


declaracion : tipo lista_de_variables ';'{  String tipoVar = $1.sval;
					                        lista_variables = (ArrayList<String>)$2.obj;
                                            for(String lexema : lista_variables){
                                                    String nuevoLexema = lexema + "." + ambito;
                                                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                                                        Main.tablaDeSimbolos.modificarSimbolo(lexema, nuevoLexema);
                                                        AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                                                        atributosT.setTipo(tipoVar);
                                                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                                                    } else {
                                                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea+ " la variable " + lexema + " ya fue declarada en este ambito");
                                                        Main.tablaDeSimbolos.eliminarSimbolo(lexema);
                                                        }
                                                }
                                            lista_variables.clear();
                                            }
            | funcion {$$.arbol = $1.arbol;}
            | error_declaracion
            ;

error_declaracion : tipo lista_de_variables error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
                  | lista_de_variables ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
                  | tipo  ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
                  ;

lista_de_variables : ID {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $1.sval);
                        lista_variables.add($1.sval);
                        Main.tablaDeSimbolos.getAtributosTablaS($1.sval).setUso("Variable");
                        $$ = new ParserVal(lista_variables);
                                }
      		       | lista_de_variables ',' ID {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables ");
      		                                    Main.tablaDeSimbolos.getAtributosTablaS($3.sval).setUso("Variable");
                                                lista_variables = (ArrayList<String>) $1.obj;
                                                lista_variables.add($3.sval);
                                                $$ = new ParserVal(lista_variables);
                                                }
                   | error_lista_de_variables
                   ;

error_lista_de_variables : lista_de_variables ID {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
                         | ',' ID {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
                         | lista_de_variables ',' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
                         ;

funcion : declaracion_fun '{'bloque'}' {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");
								        Main.listaDeAmbitos.add(ambito);
								        $$.arbol = $3.arbol;
								        if(!ambito.equals("main")){
                                        	ambito = ambito.substring(0,ambito.lastIndexOf("."));
                                        }
                            }
        | error_funcion
        ;

error_funcion : declaracion_fun  bloque '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
              | declaracion_fun '{' bloque error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
              | declaracion_fun '{' '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
              ;

declaracion_fun : FUN ID lista_de_parametros ':' tipo{
                    String nuevoLexema = $2.sval + "." + ambito;
                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaDeSimbolos.modificarSimbolo($2.sval, nuevoLexema);
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                        atributos.setAmbito(ambito);
                        atributos.setUso("nombreFuncion");
                        atributos.setTipo($5.sval);
                        atributos.setListaDeParametros(lista_parametros);
                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema, atributos);
                        if(!lista_parametros.isEmpty()){
                            int posicion = 1;
                            for(String parametro : lista_parametros){
                                Main.tablaDeSimbolos.getAtributosTablaS(parametro).setOrden(posicion);
                                posicion++;
                            }
                        }

                        ArrayList<Parametro> parametros_actuales = new ArrayList<>();
                        for(String p: lista_parametros){
                            String idParametro = p;
                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(p).getTipo();
                            Parametro param = new Parametro(tipoId,idParametro);
                            parametros_actuales.add(param);
                        }
                        parametrosFunciones.put(nuevoLexema,parametros_actuales);

                        Main.informesSemanticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una funcion declarada con nombre "+$2.sval+ " en el ámbito "+ambito+", con tipo de retorno " + Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getTipo());
                    } else {
                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " la funcion "+ $2.sval + " ya fue declarada en este ambito");
                        }
                    ambito = ambito + "."+ $2.sval;
                    }
                | error_declaracion_fun
                ;

error_declaracion_fun : ID lista_de_parametros ':' tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
                      | FUN lista_de_parametros ':' tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
                      | FUN ID ':' tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
                      | FUN ID lista_de_parametros tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
                      | FUN ID lista_de_parametros ':' error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
                      ;

lista_de_parametros : '(' ')' {lista_parametros.clear();}
                    | '('parametro')'{lista_parametros.clear();
                                      lista_parametros.add($2.sval);}
                    | '(' parametro ',' parametro ')'{lista_parametros.clear();
                                                      if(!$2.sval.equals($4.sval)){
                                                        lista_parametros.add($2.sval);
                                                        lista_parametros.add($4.sval);
                                                      } else
                                                            Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " no puede haber dos parametros con el mismo ID");
                                                      }
                    | error_lista_de_parametros
                    ;

error_lista_de_parametros : parametro')' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
                          | '('parametro {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
                          | '(' parametro ',' parametro ',' parametro')'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
                          ;

parametro : tipo ID{String nuevoAmbitoId = $2.sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo($2.sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo($1.sval);
                    atributos.setUso("nombreParametro");
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    $$ = new ParserVal(nuevoAmbitoId);} //copia valor
          | error_parametro
          ;

error_parametro : tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
                | error ID {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
                ;

tipo : I32 {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            $$ = new ParserVal ("i32");}
     | F32 {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            $$ = new ParserVal ("f32");}
     ;

ejecucion : asignacion ';'{$$.arbol = $1.arbol;}
	      | DISCARD invocacion ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if($2.arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    lexDiscard.setAmbito(ambito);
	                                    $$.arbol = new NodoBloqueEjecutable($2.arbol,null,lexDiscard);
	                                }
	                                }
	      | seleccion ';'{$$.arbol = $1.arbol;}
	      | retorno ';' {$$.arbol = $1.arbol;}
	      | control ';'{$$.arbol = $1.arbol;}
	      | salida ';' {$$.arbol = $1.arbol;}
          | BREAK ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                        AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                        sentenciaBreak.setAmbito(ambito);
                        $$.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
          | CONTINUE ';'{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                          AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                          sentenciaContinue.setAmbito(ambito);
                        $$.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
          | CONTINUE ':' ID ';' { String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($3.sval,ambito);
                                  if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                      Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +$1.sval);
                                      AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                      AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                      lexEtiqueta.setAmbito(ambito);
                                      $$.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                              }else
                                  Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+$3.sval+"' en algun ambito alcanzable");
                       }
	      | error_ejecucion
          ;

error_ejecucion : asignacion error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
                | seleccion error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
                | control error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
                | salida error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
                | retorno error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
                | DISCARD ';'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
                | DISCARD invocacion error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
                | invocacion ';'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
                ;

ejecucion_control: asignacion ';' {$$.arbol = $1.arbol;}
                 | DISCARD invocacion ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if($2.arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               lexDiscard.setAmbito(ambito);
                                               $$.arbol = new NodoBloqueEjecutable($2.arbol,null,lexDiscard);
                                           }
                                           }
                 | seleccion ';' {$$.arbol = $1.arbol;}
                 | control ';' {$$.arbol = $1.arbol;}
                 | salida ';' {$$.arbol = $1.arbol;}
                 | BREAK ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              sentenciaBreak.setAmbito(ambito);
                              $$.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
                 | CONTINUE ';'{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                                sentenciaContinue.setAmbito(ambito);
                              $$.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
                 | CONTINUE ':' ID ';' { String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($3.sval,ambito);
                                        if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                        Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +$1.sval);
                                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                        AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                        lexEtiqueta.setAmbito(ambito);
                                        $$.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+$3.sval+"' en algun ambito alcanzable");
                             }
                 | error_ejecucion_control
                 ;

error_ejecucion_control: BREAK error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
                       | CONTINUE error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
                       | CONTINUE ID ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
                       | CONTINUE ':' ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
                       | CONTINUE ':' ID error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
                       ;

etiqueta : ID ':' {  String nuevoLexema = $1.sval + "." + ambito;
                     if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                         Main.tablaDeSimbolos.modificarSimbolo($1.sval, nuevoLexema);
                         AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                         atributosT.setUso("nombreEtiqueta");
                         Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                         $$ = new ParserVal(nuevoLexema);
                     } else {
                         Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea+ " la etiqueta " + $1.sval + " ya fue declarada en este ambito");
                         Main.tablaDeSimbolos.eliminarSimbolo($1.sval);
                         }
                     }

asignacion : ID ASIGNACION expresion_aritmetica{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
                                                if(ambitoCheck != null){
                                                    if ($3.arbol!=null){
                                                        Main.tablaDeSimbolos.eliminarSimbolo($1.sval);
                                                        AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                        atributosId.setAmbito(ambito);
                                                        Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                        AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                        atributos.setAmbito(ambito);
                                                        NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),$3.arbol,atributos);
                                                    if (nodoA.getTipo()!=null){
                                                        $$.arbol= nodoA;
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                                    }
                                                }
                                                }else
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+$1.sval);
                                                }

           | ID ASIGNACION control {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                   AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS($1.sval+"."+ambito);
                                   atributosId.setAmbito(ambito);
                                   Main.tablaDeSimbolos.getAtributosTablaS($1.sval+"."+ambito).setUso("Variable");
                                   AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                   atributos.setAmbito(ambito);
                                   $$.arbol= new NodoAsignacion(new NodoHoja(atributosId),$3.arbol,atributos);
                                   }
           | error_asignacion
           ;

error_asignacion : ID error expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
                 | ID error control {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
                 | ID ASIGNACION error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
                 | ASIGNACION expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
                 | ASIGNACION control {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
                 ;

retorno : RETURN expresion_aritmetica { AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                        retorno.setAmbito(ambito);
                                        $$.arbol = new NodoRetorno($2.arbol,null,retorno);
                                      }
        | error_retorno
        ;

error_retorno : RETURN {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
              ;

expresion_aritmetica : termino{$$.arbol = $1.arbol;}
	                 | expresion_aritmetica '+' termino { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 atributos.setAmbito(ambito);
	                 	                                 $$.arbol = new NodoSuma($1.arbol,$3.arbol,atributos);
	                 	                                 }

	                 | expresion_aritmetica '-' termino { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              atributos.setAmbito(ambito);
	                 	                 	              $$.arbol = new NodoResta($1.arbol,$3.arbol,atributos);
	                                                    }
	                 | error_expresion_aritmetica
                     ;

error_expresion_aritmetica : expresion_aritmetica '+' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
                           | expresion_aritmetica '-' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
                           ;

termino : termino '*' factor { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          atributos.setAmbito(ambito);
	                          $$.arbol = new NodoMultiplicacion($1.arbol,$3.arbol,atributos);
                             }
	    | termino '/' factor  { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          atributos.setAmbito(ambito);
	                          $$.arbol = new NodoDivision($1.arbol,$3.arbol,atributos);
	                          }
	    | factor{$$.arbol = $1.arbol;}
	    | error_termino
        ;

error_termino : termino '*' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
              | termino '/' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
              | '*' factor {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
              | '/' factor {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
              ;

factor 	: ID {String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
              if(ambitoCheck != null){
                  AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                  Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                  String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                  atributos.setTipo(tipoId);
                  atributos.setAmbito(ambito);
                  $$.arbol = new NodoHoja(atributos);
              }
              else{
                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+$1.sval);
                    $$.arbol = null;
                    }
              }
        | CTE_FLOTANTE {AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS($1.sval);
                        atributos.setAmbito(ambito);
                        $$.arbol = new NodoHoja(atributos);
                       }
        | CTE_INT {if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS($1.sval);
                        atributos.setTipo("i32");
                        atributos.setAmbito(ambito);
                        $$.arbol = new NodoHoja(atributos);
                        }
                   }
        | invocacion {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS($1.sval+"."+ambito);
                      atributosId.setAmbito(ambito);
                      $$.arbol = new NodoHoja(atributosId);
                      }
        | '-' CTE_INT {if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+$2.sval);
                       atributos.setAmbito(ambito);
                       $$.arbol = new NodoHoja(atributos);
                       }
                      }
        | '-' CTE_FLOTANTE {if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+$2.sval);
                               atributos.setAmbito(ambito);
                               $$.arbol = new NodoHoja(atributos);
                               }
                           }
        ;

invocacion : ID '(' parametros_reales ')' { String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
                                            if(ambitoCheck != null){
                                                if ($3.arbol !=null){
                                                    ArrayList<Parametro> parametros_funcion_actual = new ArrayList<>();
                                                    parametros_funcion_actual.addAll(parametrosFunciones.get(ambitoCheck));
                                                    if(parametros_funcion_actual.size() == lista_parametros_reales.size()){
                                                        int pos = 0;
                                                        int nroDeNoCoincidencias = 0;
                                                        for(String paramR : lista_parametros_reales){
                                                            String tipoParamR = Main.tablaDeSimbolos.getAtributosTablaS(paramR).getTipo();
                                                            String tipoParam = parametros_funcion_actual.get(pos).getTipo();
                                                            if(!tipoParamR.equals(tipoParam))
                                                                nroDeNoCoincidencias++;
                                                            pos++;
                                                        }
                                                        if(nroDeNoCoincidencias == 0){
                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + $1.sval);
                                                            AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion");
                                                            lexInvocacion.setAmbito(ambito);
                                                            AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                            $$.arbol = new NodoInvocacion(new NodoHoja(lexID),$3.arbol,lexInvocacion);
                                                        }
                                                        else{
                                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el tipo de los parametros invocados no coinciden con los de la funcion a invocar");
                                                            $$.arbol = null;
                                                        }
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] se quiere invocar a una funcion con un numero incorrecto de parametros ");
                                                        $$.arbol = null;
                                                    }
                                                }
                                            }
                                            else
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                                            }
           | ID '('  ')' {  String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
                            if(ambitoCheck != null){
                                if(lista_parametros.size() == lista_parametros_reales.size()){
                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + $1.sval);
                                    AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion sin parametros");
                                    AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS($1.sval+"."+ambito);
                                    $$.arbol = new NodoInvocacion(new NodoHoja(lexID),null,lexInvocacion);
                                }
                                else
                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] flatan el/los parametros en la invocacion ");
                            }
                            else
                              Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                         }
           | error_invocacion
           ;

error_invocacion : ID '(' parametros_reales error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
                 | ID '(' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
                 ;

parametros_reales : factor_invocacion { if($1.arbol !=null){
                                            AtributosTablaS lexParam = new AtributosTablaS("Un Parametro");
                                            lista_parametros_reales.clear();
                                            lista_parametros_reales.add($1.sval);
                                            lexParam.setParametroEnLista($1.sval);
                                            $$.arbol = new NodoParam($1.arbol,null,lexParam);
                                        }
                                        else
                                            $$.arbol = null;
                                        }
                  | factor_invocacion  ','  factor_invocacion { if($1.arbol !=null && $3.arbol!=null){
                                                                    AtributosTablaS lexParam = new AtributosTablaS("Dos Parametros");
                                                                    lexParam.setParametroEnLista($1.sval);
                                                                    lexParam.setParametroEnLista($3.sval);
                                                                    lista_parametros_reales.clear();
                                                                    lista_parametros_reales.add($1.sval);
                                                                    lista_parametros_reales.add($3.sval);
                                                                    $$.arbol = new NodoParam($1.arbol,$3.arbol,lexParam);
                                                               }else
                                                                    $$.arbol = null;
                                                               }
                  | error_parametros_reales
                  ;


error_parametros_reales : factor_invocacion factor_invocacion {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
                        | factor_invocacion  ','  factor_invocacion ','  factor_invocacion {Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
                        | factor_invocacion  ','  factor_invocacion ','  factor_invocacion ','  factor_invocacion {Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
                        ;

factor_invocacion 	: ID { String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
                      if(ambitoCheck != null){
                          AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS($1.sval+"."+ambito);
                          atributos.setAmbito(ambito);
                          Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                          $$.arbol = new NodoHoja(atributos);
                          }else{
                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+$1.sval);
                            $$.arbol = null;
                          }
                          }
                    | CTE_FLOTANTE {Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + $1.sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS($1.sval);
                                    atributos.setAmbito(ambito);
                                    $$.arbol = new NodoHoja(atributos);
                                   }
                    | CTE_INT {if (chequearRangoEnteros() == true) {
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + $1.sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS($1.sval);
                                   atributos.setAmbito(ambito);
                                   $$.arbol = new NodoHoja(atributos);
                               }
                               }
                    | '-' CTE_INT {if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+$2.sval);
                                            atributos.setAmbito(ambito);
                                            $$.arbol = new NodoHoja(atributos);
                                            }
                                  }
                    | '-' CTE_FLOTANTE {if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+$2.sval);
                                            atributos.setAmbito(ambito);
                                            $$.arbol = new NodoHoja(atributos);
                                            }
                                       }
                    ;
seleccion : IF '(' condicion ')' cuerpo_if {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            atributos.setAmbito(ambito);
                                            $$.arbol = new NodoIf($3.arbol,$5.arbol,atributos);}
          | error_seleccion
          ;

error_seleccion: '(' condicion ')' cuerpo_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
               | IF condicion ')' cuerpo_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
               | IF '(' ')' cuerpo_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
               | IF '(' condicion  cuerpo_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
               | IF '(' condicion ')' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
               ;

cuerpo_if : THEN cuerpo_then ENDIF {AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    atributos.setAmbito(ambito);
                                    $$.arbol = new NodoCuerpoIf($2.arbol,null,atributos);
                                    }
          | THEN cuerpo_then cuerpo_else ENDIF {AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                atributos.setAmbito(ambito);
                                                $$.arbol = new NodoCuerpoIf($2.arbol,$3.arbol,atributos);
                                                }
          | error_cuerpo_if
          ;

error_cuerpo_if: error cuerpo_then cuerpo_else ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
               | THEN cuerpo_then {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
               | THEN cuerpo_then cuerpo_else  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
               ;


cuerpo_then: ejecucion {AtributosTablaS atributos = new AtributosTablaS("Then");
                        atributos.setAmbito(ambito);
                        $$.arbol = new NodoCuerpoThen($1.arbol,null,atributos);}
           | '{' bloque_ejecutable_if '}'{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          atributos.setAmbito(ambito);
                                          $$.arbol = new NodoCuerpoThen($2.arbol,null,atributos);}
           | error_cuerpo_then
           ;

cuerpo_else: ELSE ejecucion {AtributosTablaS atributos = new AtributosTablaS("Else");
                             atributos.setAmbito(ambito);
                             $$.arbol = new NodoCuerpoElse($2.arbol,null,atributos);}
           | ELSE '{' bloque_ejecutable_if '}' {AtributosTablaS atributos = new AtributosTablaS("Else");
                                                atributos.setAmbito(ambito);
                                                $$.arbol = new NodoCuerpoElse($3.arbol,null,atributos);}
           | error_cuerpo_else
           ;

error_cuerpo_then : bloque_ejecutable_if '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
                | '{' bloque_ejecutable_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
                ;

error_cuerpo_else :   '{' bloque_ejecutable_if '}'  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
                | ELSE bloque_ejecutable_if '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
                | ELSE '{' bloque_ejecutable_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
                ;

bloque_for : ejecucion_control{ $$.arbol = $1.arbol;}
           | '{' bloque_ejecutable_for '}' {$$.arbol = $2.arbol;}
           | error_bloque_for
           ;

error_bloque_for : bloque_ejecutable_for '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
                | '{' bloque_ejecutable_for  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
                ;


condicion : expresion_aritmetica comparador expresion_aritmetica {AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  atributos.setAmbito(ambito);
                                                                  AtributosTablaS atributos2 = new AtributosTablaS($2.sval);
                                                                  atributos2.setAmbito(ambito);
                                                                  $$.arbol = new NodoCondicionIf(new NodoExpresionLogica($1.arbol,$3.arbol,atributos2),null,atributos);}
          | error_condicion
          ;

error_condicion : comparador expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
                | expresion_aritmetica comparador  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
                | expresion_aritmetica error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
                ;

comparador : '<' {$$ = new ParserVal("<");}
           | '>' {$$ = new ParserVal(">");}
           | '=' {$$ = new ParserVal("=");}
           | MAYOR_IGUAL {$$ = new ParserVal(">=");}
           | MENOR_IGUAL {$$ = new ParserVal("<=");}
           | DISTINTO {$$ = new ParserVal("=!");}
           ;

control : FOR '(' asignacion_for';'condicion_for';' incr_decr ')' bloque_for {if(($3.arbol != null)&&($5.arbol != null)&&($7.arbol != null)){
                                                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                            AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                            lexSentenciaFor.setAmbito(ambito);
                                                                                            AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                            lexCuerpoFor.setAmbito(ambito);
                                                                                            AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                            lexEncabezadoFor.setAmbito(ambito);
                                                                                            ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor($9.arbol,null,lexCuerpoFor);
                                                                                            String IdAIncrementar = $3.arbol.getHijoIzq().getLexema();
                                                                                            $5.arbol.getHijoIzq().setId(IdAIncrementar);
                                                                                            $7.arbol.setId(IdAIncrementar);
                                                                                            ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor($3.arbol,$5.arbol,lexEncabezadoFor),$7.arbol,lexEncabezadoFor);
                                                                                            $$.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                          }
                                                                                          else
                                                                                              $$.arbol = null;
                                                                                        }
           |etiqueta FOR '(' asignacion_for';'condicion_for';' incr_decr ')' bloque_for {if(($4.arbol != null)&&($6.arbol != null)&&($8.arbol != null)){
                                                                                  Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                  AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                  lexSentenciaFor.setAmbito(ambito);
                                                                                  AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                  lexCuerpoFor.setAmbito(ambito);
                                                                                  AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                  lexEncabezadoFor.setAmbito(ambito);
                                                                                  ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor($10.arbol,null,lexCuerpoFor);
                                                                                  String IdAIncrementar = $4.arbol.getHijoIzq().getLexema();
                                                                                  $4.arbol.setId($1.sval);
                                                                                  $6.arbol.getHijoIzq().setId(IdAIncrementar);
                                                                                  $8.arbol.setId(IdAIncrementar);
                                                                                  ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor($4.arbol,$6.arbol,lexEncabezadoFor),$8.arbol,lexEncabezadoFor);
                                                                                  $$.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                }
                                                                                else
                                                                                    $$.arbol = null;
                                                                              }
        | error_control {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
        ;

error_control : FOR '(' ')' bloque_for {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
              ;

incr_decr : '+' CTE_INT {
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          atributos1.setAmbito(ambito);
                          $$.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS($2.sval)), null, atributos1);}
           | '-' CTE_INT {
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          atributos1.setAmbito(ambito);
                          $$.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS($2.sval)), null, atributos1);}
           | error_incr_decr{ $$.arbol = null;}
           ;

error_incr_decr : CTE_INT {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
                | '-' error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
                | '+' error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
                | '+' CTE_FLOTANTE {Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
                | '-' CTE_FLOTANTE {Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
                ;

asignacion_for: ID ASIGNACION CTE_INT { String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
                                        if(ambitoCheck != null){
                                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                            if(tipoId.equals("i32")){
                                                if (chequearRangoEnteros()==true){
                                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS($1.sval+"."+ambito);
                                                    atributos.setAmbito(ambito);
                                                    Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                    AtributosTablaS atributos2 = new AtributosTablaS("Asignacion FOR");
                                                    atributos2.setAmbito(ambito);
                                                    AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS($3.sval);
                                                    atributos3.setAmbito(ambito);
                                                    NodoAsignacionFor nodoA = new NodoAsignacionFor(new NodoHoja(atributos),new NodoHoja(atributos3),atributos2);
                                                    if (nodoA.getTipo()!=null){
                                                        $$.arbol= nodoA;
                                                    }else{
                                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " asignacion con tipo incompatibles ");
                                                        $$.arbol= null;
                                                    }
                                                }
                                                else{
                                                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero a asignar esta fuera de rango");
                                                    $$.arbol= null;
                                                }
                                            }
                                            else{
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el tipo declarado para el id es incorrecto");
                                                $$.arbol= null;
                                            }
                                        }
                                        else{
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+$1.sval);
                                            $$.arbol= null;
                                        }
                                        }
              | error_asignacion_for
              ;

error_asignacion_for : ASIGNACION CTE_INT {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
                     | ID  CTE_INT {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
                     | ID ASIGNACION  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
                     ;

condicion_for: ID comparador expresion_aritmetica {String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($1.sval,ambito);
                                                   if(ambitoCheck != null){
                                                       Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                       AtributosTablaS atributos = new AtributosTablaS("CondicionFOR");
                                                       atributos.setAmbito(ambito);
                                                       AtributosTablaS atributos2 = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                       atributos2.setAmbito(ambito);
                                                       AtributosTablaS atributos3 = new AtributosTablaS($2.sval);
                                                       atributos3.setAmbito(ambito);
                                                       $$.arbol = new NodoCondicionFor(new NodoComparacionFor(new NodoHoja(atributos2),$3.arbol,atributos3),null,atributos);
                                                   }
                                                   else{
                                                       Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no existe el id "+ $1.sval +" en ningun ambito alcanzable. Imposible determinar rango de control");
                                                       $$.arbol = null;
                                                   }
                                                   }
             | error_condicion_for
             ;

error_condicion_for : comparador expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
                    | ID expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
                    | ID comparador  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
                    ;

salida : OUT '('CADENA')'{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          lexSalida.setAmbito(ambito);
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS($3.sval);
                          lexCadena.setAmbito(ambito);
                          $$.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
       | error_salida
       ;

error_salida: OUT CADENA')'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
            | OUT '('')'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
            | OUT '('CADENA {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
            ;
%%

private Lexico lexico;
private ArbolSintactico arbolSintactico;
private String ambito;
private ArrayList<String> lista_variables;
private ArrayList<String> lista_parametros;
private ArrayList<String> lista_parametros_reales;
private Hashtable<String,ArrayList<Parametro>> parametrosFunciones;

public Parser(Lexico lexico)
{
  this.lexico = lexico;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
  this.lista_parametros = new ArrayList<String>();
  this.lista_parametros_reales = new ArrayList<String>();
  this.parametrosFunciones = new Hashtable<>();
}

public int yylex(){
   Token token = this.lexico.obtenerToken();

   if(token != null ){
   	int val = token.getId();
   	yylval = new ParserVal(token.getLexema());
   	return val;
   }
   return 0;
}

public void yyerror(String s){
    //System.out.println("Parser: " + s);
}

public boolean chequearRangoEnteros(){
	String lexema = yylval.sval;
    Long constante = Long.parseLong(lexema); //Convierto el string dentro del buffer en una constante entera.
        if((constante >= (-1*Math.pow(2,31))) && (constante <= (Math.pow(2,31) - 1))){
		    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante ENTERA LARGA positiva -> "+constante);
		    return true;
        }
        else{
        	Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
            return false;
        }
}

public boolean chequearNegativos(){
	String lexema = yylval.sval;
	int id = Main.tablaDeSimbolos.getIdentificador(lexema);
	if(id == Lexico.CTE_INT){
		Long enteroNeg = -1*Long.parseLong(lexema);
		if((enteroNeg >= (-Math.pow(2,31))) && (enteroNeg <= (Math.pow(2,31) - 1))){
		    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante ENTERA LARGA con signo negativo -> "+enteroNeg);
		    Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(enteroNeg));
		    return true;
		}
		else{
		    Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
            return false;
		}
	}
	else if (id == Lexico.CTE_FLOTANTE) {
		Float flotanteNeg = -1*Float.parseFloat(lexema.replace('F','e'));
        if ((flotanteNeg > 1.17549435e-38 && flotanteNeg < 3.40282347e+38) || (flotanteNeg > -3.40282347e+38 && flotanteNeg < -1.17549435e-38) || (flotanteNeg == 0.0)){
            Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(flotanteNeg));
            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
            return true;
        }
        else {
            Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante FLOTANTE fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
            return false;
	 	}
	}
	return false;
}

public String printSyntacticTree(){
	if(this.arbolSintactico != null){
		this.arbolSintactico.printTree(this.arbolSintactico, "Root: ");
		return this.arbolSintactico.getPrintTree();
	}
	else
	    System.out.println("No hay ningun arbol mostrable");
	return "";
}

public ArbolSintactico returnTree(){
	return this.arbolSintactico;
}

