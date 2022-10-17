%{
package Parser;
import Principal.*;
%}

%token ID CTE_INT CTE_FLOTANTE MENOR_IGUAL MAYOR_IGUAL DISTINTO CADENA ASIGNACION IF THEN ELSE ENDIF OUT FUN RETURN BREAK DISCARD FOR CONTINUE F32 I32

%start programa

%%

programa : ID '{' bloque'}' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
         | error_programa; {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
         ;

error_programa : '{'bloque'}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
               | ID error bloque'}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
               | ID '{'bloque  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
               ;

bloque : sentencia
       | bloque sentencia
       | error_bloque
       ;

error_bloque: error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
            ;

sentencia : declaracion
          | ejecucion
          ;

bloque_ejecutable_for: ejecucion_control
                     | bloque_ejecutable_for ejecucion_control
                     ;

bloque_ejecutable_if: ejecucion
                    | bloque_ejecutable_if ejecucion
                    ;
/*
bloque_ejecutable : ejecucion
                  | ejecucion_control
                  | bloque_ejecutable ejecucion
                  | bloque_ejecutable ejecucion_control
                  ;
*/

declaracion : tipo lista_de_variables ';'{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
            | funcion
            | error_declaracion
            ;

error_declaracion : tipo lista_de_variables error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
                  | lista_de_variables ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
                  | tipo  ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
                  ;

lista_de_variables : ID {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $1.sval);}
      		       | lista_de_variables ',' ID {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + $3.sval);}
                   | error_lista_de_variables
                   ;

error_lista_de_variables : lista_de_variables ID {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
                         | ',' ID {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
                         | lista_de_variables ',' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
                         ;

funcion : declaracion_fun '{'bloque'}' {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
        | error_funcion
        ;

error_funcion : declaracion_fun  bloque '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
              | declaracion_fun '{' bloque error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
              | declaracion_fun '{' '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
              ;

declaracion_fun : FUN ID lista_de_parametros ':' tipo
                | error_declaracion_fun
                ;

error_declaracion_fun :  ID lista_de_parametros ':' tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
                      | FUN lista_de_parametros ':' tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
                      | FUN ID ':' tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
                      | FUN ID lista_de_parametros tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
                      | FUN ID lista_de_parametros ':' error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
                      ;

lista_de_parametros : '(' ')'
                    | '('parametro')'
                    | '(' parametro ',' parametro ')'
                    | error_lista_de_parametros
                    ;

error_lista_de_parametros : parametro')' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
                          | '('parametro {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
                          | '(' parametro ',' parametro ',' parametro')'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
                          ;

parametro : tipo ID
          | error_parametro
          ;

error_parametro : tipo {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
                | error ID {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
                ;

tipo : I32 {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
     | F32 {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
     ;

ejecucion : asignacion ';'
	      | DISCARD invocacion ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
	      | seleccion ';'
	      | retorno ';'
	      | ID ':' control';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +$1.sval);}
	      | control ';'
	      | salida ';'
	      | error_ejecucion
          ;

error_ejecucion : asignacion error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
                | seleccion error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
                | control error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
                | ':' control ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
                | ID ':' ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
                | ID control ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
                | salida error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
                | retorno error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
                | DISCARD ';'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
                | DISCARD invocacion error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
                | invocacion ';'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
                ;

ejecucion_control: asignacion ';'
                 | DISCARD invocacion ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
                 | seleccion ';'
                 | ID ':' control';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +$1.sval);}
                 | control ';'
                 | salida ';'
                 | BREAK ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
                 | CONTINUE ';'{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
                 | CONTINUE ':' ID ';' {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +$3.sval);}
                 | error_ejecucion_control
                 ;

error_ejecucion_control: BREAK error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
                       | CONTINUE error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
                       | CONTINUE ID ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
                       | CONTINUE ':' ';' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
                       | CONTINUE ':' ID error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
                       ;

asignacion : ID ASIGNACION expresion_aritmetica
           | ID ASIGNACION control {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");}
           | error_asignacion
           ;

error_asignacion : ID error expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
                 | ID error control {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
                 | ID ASIGNACION error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
                 | ASIGNACION expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
                 | ASIGNACION control {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
                 ;

retorno : RETURN expresion_aritmetica
        | error_retorno
        ;

error_retorno : RETURN {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
              ;

expresion_aritmetica : termino
	                 | expresion_aritmetica '+' termino { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
	                 | expresion_aritmetica '-' termino { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
	                 | error_expresion_aritmetica
                     ;

error_expresion_aritmetica : expresion_aritmetica '+' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
                           | expresion_aritmetica '-' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
                           ;

termino : termino '*' factor { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
	    | termino '/' factor  { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
	    | factor
	    | error_termino
        ;

error_termino : termino '*' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
              | termino '/' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
              | '*' factor {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
              | '/' factor {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
              ;

factor 	: ID
        | CTE_FLOTANTE
        | CTE_INT {chequearRangoEnteros();}
        | invocacion {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
        | '-' CTE_INT {chequearNegativos();}
        | '-' CTE_FLOTANTE {chequearNegativos();}
        ;

invocacion : ID '(' parametros_reales ')' { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + $1.sval);}
           | ID '('  ')' { Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + $1.sval);}
           | error_invocacion
           ;

error_invocacion : ID '(' parametros_reales error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
                 | ID '(' error{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
                 ;

parametros_reales : factor_invocacion
                  | factor_invocacion  ','  factor_invocacion
                  | error_parametros_reales
                  ;

error_parametros_reales : factor_invocacion factor_invocacion {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
                        ;

factor_invocacion 	: ID
                    | CTE_FLOTANTE {Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + $1.sval);}
                    | CTE_INT {chequearRangoEnteros();
                               Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + $1.sval);}
                    | '-' CTE_INT {chequearNegativos();}
                    | '-' CTE_FLOTANTE {chequearNegativos();}
                    ;

seleccion : IF '(' condicion ')' THEN bloque_if ENDIF {Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");}
	      | IF '(' condicion ')' THEN bloque_if ELSE bloque_if ENDIF {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF con ELSE");}
          | error_seleccion
          ;

error_seleccion: '(' condicion ')' THEN bloque_if ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
               | IF condicion ')' THEN bloque_if ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
               | IF '(' ')' THEN bloque_if ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
               | IF '(' condicion  THEN bloque_if ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
               | IF '(' condicion ')'  bloque_if ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada THEN de la sentencia IF ");}
               | IF '(' condicion ')' THEN  ENDIF {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
               | IF '(' condicion ')' THEN bloque_if error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
               ;

bloque_for : ejecucion_control
              | '{' bloque_ejecutable_for '}'
              | error_bloque_for
              ;

bloque_if : ejecucion
              | '{' bloque_ejecutable_if '}'
              | error_bloque_if
              ;
error_bloque_for : bloque_ejecutable_for '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
                | '{' bloque_ejecutable_for  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
                ;

error_bloque_if : bloque_ejecutable_if '}' {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
                | '{' bloque_ejecutable_if  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
                ;


condicion : expresion_aritmetica comparador expresion_aritmetica
          | error_condicion
          ;

error_condicion : comparador expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
                | expresion_aritmetica comparador  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
                | expresion_aritmetica error {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
                ;

comparador : '<'
           | '>'
           | '='
           | MAYOR_IGUAL
           | MENOR_IGUAL
           | DISTINTO
           ;

control : FOR '(' asignacion_for';'condicion_for';' '+' CTE_INT')' bloque_for {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
        | FOR '(' asignacion_for';'condicion_for';' '-' CTE_INT')' bloque_for {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
        | error_control {Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
        ;

error_control : FOR '(' asignacion_for';'condicion_for';'  CTE_INT')' bloque_for {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
              | FOR '(' asignacion_for';'condicion_for';' '-' ')' bloque_for {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
              | FOR '(' asignacion_for';'condicion_for';' '+' ')' bloque_for {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
              | FOR '(' ')' bloque_for {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
              ;

asignacion_for: ID ASIGNACION CTE_INT {chequearRangoEnteros();}
              | error_asignacion_for
              ;

error_asignacion_for : ASIGNACION CTE_INT {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
                     | ID  CTE_INT {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
                     | ID ASIGNACION  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
                     ;

condicion_for: ID comparador expresion_aritmetica
             | error_condicion_for
             ;

error_condicion_for : comparador expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
                    | ID expresion_aritmetica {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
                    | ID comparador  {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
                    ;

salida : OUT '('CADENA')'{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
       | error_salida
       ;

error_salida: OUT CADENA')'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
            | OUT '('')'{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
            | OUT '('CADENA {Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
            ;
%%

private Lexico lexico;


public Parser(Lexico lexico)
{
  this.lexico = lexico;

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

public void chequearRangoEnteros(){
	String lexema = yylval.sval;
    Long constante = Long.parseLong(lexema); //Convierto el string dentro del buffer en una constante entera.
        if((constante >= (-1*Math.pow(2,31))) && (constante <= (Math.pow(2,31) - 1))){
		    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante ENTERA LARGA positiva -> "+constante);
        }
        else{
        	Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
        }
}

public void chequearNegativos(){
	String lexema = yylval.sval;
	int id = Main.tablaDeSimbolos.getIdentificador(lexema);
	if(id == Lexico.CTE_INT){
		Long enteroNeg = -1*Long.parseLong(lexema);
		if((enteroNeg >= (-Math.pow(2,31))) && (enteroNeg <= (Math.pow(2,31) - 1))){
		    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante ENTERA LARGA con signo negativo -> "+enteroNeg);
		    Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(enteroNeg));
		}
		else{
		    Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
		}
	}
	else if (id == Lexico.CTE_FLOTANTE) {
		Float flotanteNeg = -1*Float.parseFloat(lexema.replace('F','e'));
        if ((flotanteNeg > 1.17549435e-38 && flotanteNeg < 3.40282347e+38) || (flotanteNeg > -3.40282347e+38 && flotanteNeg < -1.17549435e-38) || (flotanteNeg == 0.0)){
            Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(flotanteNeg));
            System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
        }
        else {
            Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante FLOTANTE fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}

