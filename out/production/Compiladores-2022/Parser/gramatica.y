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
               | ID '{'bloque {System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
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
                  | '{' bloque_sentencias_ejecutables '}'
                  ;

bloque_sentencias_ejecutables : ejecucion
                              | bloque_sentencias_ejecutables ejecucion
                              ;

declaracion : tipo lista_de_variables';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
            | funcion ';'
            | lista_de_variables ';'
            ;

lista_de_variables : ID {System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $1.sval);}
      		       | lista_de_variables ',' ID {System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $3.sval);}
                   ;

funcion : declaracion_fun '{'bloque_ejecutable'}' {System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
        ;

declaracion_fun : FUN ID lista_de_parametros ':' tipo
                ;

lista_de_parametros : '(' ')' //Considero que se contemplara asi el hecho de que no haya parametros.
                    | '('parametro')'
                    | '(' parametro ',' parametro ')'
                    ;

parametro : tipo ID
          ;

tipo : I32 {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
     | F32 {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
     ;


ejecucion : asignacion ';'
	      | DISCARD invocacion ';'
	      | seleccion
	      | retorno ';'
	      | control ';'
	      | salida';'
	      | BREAK ';' {System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
	      | CONTINUE ';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
          ;

asignacion : ID '=' ':' expresion_aritmetica
           ;

retorno : RETURN expresion_aritmetica
        | RETURN comparador
        ;

expresion_aritmetica : termino
	                 | expresion_aritmetica '+' termino { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
	                 | expresion_aritmetica '-' termino { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
                     ;

termino : termino '*' factor { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
	    | termino '/' factor  { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
	    | factor
        ;

factor 	: ID {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + $1.sval);}
        | CTE_FLOTANTE {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + $1.sval);}
        | CTE_INT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + $1.sval);}
        ;

invocacion : ID '(' parametros_reales ')' { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
           ;

//Uso factor o creo uno nuevo(pq en factor esta la invocacion..)
parametros_reales : factor
                  | factor parametros_reales
                  ;

seleccion : IF '(' condicion ')' THEN bloque_ejecutable ENDIF';' {System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
	      | IF '(' condicion ')' THEN bloque_ejecutable ELSE bloque_ejecutable ENDIF';' {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
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

control : FOR '(' asignacion_for';'condicion_for';' '+' CTE_INT')' '{'bloque_ejecutable'}' {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
        | FOR '(' asignacion_for';'condicion_for';' '-' CTE_INT')' '{'bloque_ejecutable'}' {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
        ;

asignacion_for: ID '=' ':' CTE_INT
              ;

condicion_for: ID comparador expresion_aritmetica
             ;


salida : OUT '('CADENA')'';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
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

