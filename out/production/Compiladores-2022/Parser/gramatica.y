%token ID CTE_INT CTE_FLOTANTE MENOR_IGUAL MAYOR_IGUAL DISTINTO CADENA ASIGNACION IF THEN ELSE ENDIF OUT FUN RETURN BREAK DISCARD FOR CONTINUE F32 I32

%start programa

%%

programa : ID {System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto un programa con nombre solamente");}
         | ID bloque {System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa");}
         ;

bloque : bloque_declarativo bloque_ejecutable
       | bloque_declarativo
       | bloque_ejecutable
       ;

bloque_declarativo : declaracion
				   | '{' bloque_sentencias_declarativo '}'
				   ;

bloque_sentencias_declarativo : declaracion
				              | bloque_sentencias_declarativo declaracion
				              ;

bloque_ejecutable : ejecucion
                  | '{' bloque_sentencias_ejecutable '}'
                  ;

bloque_sentencias_ejecutable : ejecucion
                             | bloque_sentencias_ejecutable ejecucion
                             ;


declaracion : tipo lista_de_variables ';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variables");}
            | funcion ';'
            | error_declaracion
            ;

error_declaracion: tipo lista_de_variables error{System.out.println("Error sináctico: Linea " + Lexico.linea + " sentencia mal declarada, falta ';'");}
                 ;

lista_de_variables : ID {System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $1.sval);}
      		       | lista_de_variables ',' ID {System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + $3.sval);}
      		       | error_lista_de_variables
                   ;

error_lista_de_variables :  lista_de_variables ID {System.out.println("Error sintáctico: Linea " + Lexico.linea + " sentencia mal declarada, falta una ',' entre identificadores");}
                         ;

funcion : declaracion_fun '{'bloque'}' {System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
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
	  | seleccion ';'
	  | retorno ';'
	  | control ';'
	  | salida';'
	  | CONTINUE ';'
	  | BREAK ';'
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

factor 	: CTE_FLOTANTE {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + $1.sval);}
        | CTE_INT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + $1.sval);}
	    | ID {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + $1.sval);}
        | invocacion ';'
        | '-' factor {chequearNegativos();}
        ;

invocacion : ID '(' parametros_reales ')'
           ;

//Uso factor o creo uno nuevo(pq en factor esta la invocacion..)
parametros_reales : factor
                  | factor parametros_reales
                  ;

seleccion : IF '(' condicion ')' THEN bloque_ejecutable ENDIF {System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
	      | IF '(' condicion ')' THEN bloque_ejecutable ELSE bloque_ejecutable ENDIF {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
	      | error_seleccion
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

error_seleccion : IF     condicion ')' THEN bloque_ejecutable ENDIF';' {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta el parentesis de apertura ");}
                | IF '('           ')' THEN bloque_ejecutable ENDIF';'{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta condicion ");}
                | IF '(' condicion ')' THEN                              ENDIF';' {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta bloque ejecutable ");}
                | IF '(' condicion     THEN bloque_ejecutable ENDIF';' {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta parentesis de cierre ");}
                | IF '(' condicion ')' THEN bloque_ejecutable error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta ENDIF de cierre ");}
                | IF '(' condicion ')' THEN bloque_ejecutable ELSE              ENDIF';' {System.out.println("Error sintáctico: falta bloque ejecutable luego del ELSE ");}
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

