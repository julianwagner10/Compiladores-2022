%{
package Parser;
import Principal.*;
%}

%token ID CTE_INT CTE_FLOTANTE MENOR_IGUAL MAYOR_IGUAL DISTINTO CADENA ASIGNACION IF THEN ELSE ENDIF OUT FUN RETURN BREAK DISCARD FOR CONTINUE F32 I32

%start programa

%%

programa : ID '{'bloque'}' {System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
         | error_programa;
         ;

error_programa : '{'bloque'}' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
               | ID error bloque'}' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
               | ID '{'bloque  {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
               ;

bloque : bloque_declarativo bloque_ejecutable {System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero declarativo y luego ejecutable ");}
       | bloque_ejecutable bloque_declarativo {System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero ejecutable y luego declarativo ");}
       | bloque_declarativo {System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque declarativo ");}
       | bloque_ejecutable {System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque ejecutable ");}
       ;

bloque_declarativo : declaracion
				   | bloque_declarativo declaracion
				   ;

bloque_ejecutable : ejecucion
                  | bloque_ejecutable ejecucion
                  ;


declaracion : tipo lista_de_variables ';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
            | funcion
            | error_declaracion
            ;

error_declaracion : tipo lista_de_variables error {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
                  | lista_de_variables ';' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
                  | tipo  ';' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
                  ;

lista_de_variables : ID {System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $1.sval);}
      		       | lista_de_variables ',' ID {System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $3.sval);}
                   | error_lista_de_variables
                   ;

error_lista_de_variables : lista_de_variables ID {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
                         | ',' ID {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
                         | lista_de_variables ',' error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
                         ;

funcion : declaracion_fun '{'bloque'}' {System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
        | error_funcion
        ;

error_funcion : declaracion_fun  bloque '}' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
              | declaracion_fun '{' bloque error {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
              | declaracion_fun '{' '}' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
              ;

declaracion_fun : FUN ID lista_de_parametros ':' tipo
                | error_declaracion_fun
                ;

error_declaracion_fun :  ID lista_de_parametros ':' tipo {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
                      | FUN lista_de_parametros ':' tipo {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
                      | FUN ID ':' tipo {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
                      | FUN ID lista_de_parametros tipo {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
                      | FUN ID lista_de_parametros ':' error {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
                      ;

lista_de_parametros : '(' ')'
                    | '('parametro')'
                    | '(' parametro ',' parametro ')'
                    | error_lista_de_parametros
                    ;

error_lista_de_parametros : parametro')' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
                          | '('parametro {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
                          | '(' parametro ',' parametro ',' parametro')'{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
                          ;

parametro : tipo ID
          | error_parametro
          ;

error_parametro : tipo {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
                | error ID {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
                ;

tipo : I32 {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
     | F32 {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
     ;

ejecucion : asignacion ';'
	      | DISCARD invocacion ';'
	      | seleccion ';'
	      | retorno ';'
	      | control ';'
	      | salida ';'
	      | BREAK ';' {System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
	      | CONTINUE ';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
	      | error_ejecucion
          ;

error_ejecucion : asignacion error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
                |seleccion error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
                |control error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
                |salida error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
                |BREAK error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
                |retorno error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
                |CONTINUE error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
                |DISCARD ';'{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
                |DISCARD invocacion error {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
                | invocacion ';'{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
                ;

asignacion : ID ASIGNACION expresion_aritmetica
           | error_asignacion
           ;

error_asignacion : ID error expresion_aritmetica {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
                 | ID ASIGNACION error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
                 | ASIGNACION expresion_aritmetica {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
                 ;

retorno : RETURN expresion_aritmetica
        | error_retorno
        ;

error_retorno : RETURN {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
              ;

expresion_aritmetica : termino
	                 | expresion_aritmetica '+' termino { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
	                 | expresion_aritmetica '-' termino { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
	                 | error_expresion_aritmetica
                     ;

error_expresion_aritmetica : expresion_aritmetica '+' error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
                           |expresion_aritmetica '-' error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
                           ;


termino : termino '*' factor { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
	    | termino '/' factor  { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
	    | factor
	    | error_termino
        ;

error_termino : termino '*' error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
              | termino '/' error{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
              | '*' factor {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
              | '/' factor {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
              ;


factor 	: ID {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + $1.sval);}
        | CTE_FLOTANTE {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + $1.sval);}
        | CTE_INT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + $1.sval);}
        | invocacion
        | '-' factor
        ;

invocacion : ID '(' parametros_reales ')' { System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + $1.sval);}
           | ID '('  ')'
           | error_invocacion
           ;


error_invocacion : ID '(' parametros_reales error {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
               //  | ID  ')' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
                 ;

parametros_reales : factor_invocacion
                  | factor_invocacion  ','  factor_invocacion
                  ;

factor_invocacion 	: ID {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + $1.sval);}
        | CTE_FLOTANTE {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + $1.sval);}
        | CTE_INT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + $1.sval);}
        | '-' factor
        ;


seleccion : IF '(' condicion ')' THEN bloque_if_for ENDIF {System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
	      | IF '(' condicion ')' THEN bloque_if_for ELSE bloque_if_for ENDIF {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
          | error_seleccion
;

error_seleccion: '(' condicion ')' THEN bloque_if_for ENDIF {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
               | IF condicion ')' THEN bloque_if_for ENDIF {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
               | IF '(' ')' THEN bloque_if_for ENDIF {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
               | IF '(' condicion  THEN bloque_if_for ENDIF {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
               | IF '(' condicion ')'  bloque_if_for ENDIF {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
               | IF '(' condicion ')' THEN  ENDIF {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
               | IF '(' condicion ')' THEN bloque_if_for error {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
               ;


bloque_if_for : ejecucion
          | '{' bloque_ejecutable '}'
          | error_bloque_if
          ;

error_bloque_if : bloque_ejecutable '}' {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
          | '{' bloque_ejecutable  {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
          ;

condicion : expresion_aritmetica comparador expresion_aritmetica
          ;

comparador : '<'
           | '>'
           | '='
           | MAYOR_IGUAL
           | MENOR_IGUAL
           | DISTINTO
           ;

control : FOR '(' asignacion_for';'condicion_for';' '+' CTE_INT')' bloque_if_for {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
        | FOR '(' asignacion_for';'condicion_for';' '-' CTE_INT')' bloque_if_for {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
        | error_control
        ;

error_control : FOR '(' asignacion_for';'condicion_for';'  CTE_INT')' bloque_if_for {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
              | FOR '(' asignacion_for';'condicion_for';' '-' ')' bloque_if_for {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
              | FOR '(' asignacion_for';'condicion_for';' '+' ')' bloque_if_for {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
              ;
asignacion_for: ID ASIGNACION CTE_INT
              | error_asignacion_for
              ;

error_asignacion_for : ASIGNACION CTE_INT {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
                     | ID  CTE_INT {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
                     | ID ASIGNACION  {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
                     ;

condicion_for: ID comparador expresion_aritmetica
             | error_condicion_for
             ;

error_condicion_for : comparador expresion_aritmetica {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
                    | ID expresion_aritmetica {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
                    | ID comparador  {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}


salida : OUT '('CADENA')'{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
       | error_salida
       ;

error_salida: OUT CADENA')'{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
            | OUT '('')'{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
            | OUT '('CADENA {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
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
    System.out.println("Parser: " + s);
}

public void chequearNegativos(){
	String lexema = yylval.sval;
	int id = Main.tablaDeSimbolos.getIdentificador(lexema);
	if(id == Lexico.CTE_INT){
		Integer enteroNeg = -1*Integer.parseInt(lexema);
		if((enteroNeg >= (-Math.pow(2,31))) && (enteroNeg <= (Math.pow(2,31) - 1))){
		    Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(enteroNeg));
		}
		else{
		    System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
		}
	}
	else if (id == Lexico.CTE_FLOTANTE) {
		Float flotanteNeg = -1*Float.parseFloat(lexema.replace('F','e'));
        if ((flotanteNeg > 1.17549435e-38 && flotanteNeg < 3.40282347e+38) || (flotanteNeg > -3.40282347e+38 && flotanteNeg < -1.17549435e-38) || (flotanteNeg == 0.0))
            Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(flotanteNeg));
        else {
            System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante FLOTANTE fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}

