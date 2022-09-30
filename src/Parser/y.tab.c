#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package Parser;
import Principal.*;
#line 9 "y.tab.c"
#define ID 257
#define CTE_INT 258
#define CTE_FLOTANTE 259
#define MENOR_IGUAL 260
#define MAYOR_IGUAL 261
#define DISTINTO 262
#define CADENA 263
#define ASIGNACION 264
#define IF 265
#define THEN 266
#define ELSE 267
#define ENDIF 268
#define OUT 269
#define FUN 270
#define RETURN 271
#define BREAK 272
#define DISCARD 273
#define FOR 274
#define CONTINUE 275
#define F32 276
#define I32 277
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    2,    2,    2,    1,    1,    1,    1,    3,
    3,    4,    4,    7,    7,    5,    5,    5,    9,    9,
   10,   11,   12,   12,   12,   13,    8,    8,    6,    6,
    6,    6,    6,    6,    6,    6,   14,   17,   17,   20,
   20,   20,   22,   22,   22,   23,   23,   23,   15,   24,
   24,   16,   16,   25,   21,   21,   21,   21,   21,   21,
   18,   18,   26,   27,   19,
};
short yylen[] = {                                         2,
    4,    1,    3,    4,    3,    2,    2,    1,    1,    1,
    2,    1,    3,    1,    2,    3,    2,    2,    1,    3,
    4,    5,    2,    3,    5,    2,    1,    1,    2,    3,
    1,    2,    2,    2,    2,    2,    4,    2,    2,    1,
    3,    3,    3,    3,    1,    1,    1,    1,    4,    1,
    2,    8,   10,    3,    1,    1,    1,    1,    1,    1,
   12,   12,    4,    3,    5,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   28,   27,    0,    0,    0,
    0,   10,   12,    0,    0,    0,    0,    0,   31,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   46,   48,
   47,   59,   58,   60,   57,   55,   56,    0,   39,    0,
   45,   35,    0,    0,    0,   36,    0,   14,    0,    3,
    6,   11,   19,    0,    0,   18,    0,   17,    0,   29,
   32,   33,   34,    4,    1,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   30,    0,    0,   13,
   15,   16,   20,    0,    0,    0,    0,    0,   23,    0,
    0,    0,    0,    0,   43,   44,    0,    0,    0,    0,
   21,    0,    0,   65,   26,    0,   24,   22,   51,   49,
    0,    0,    0,    0,    0,   63,    0,    0,    0,    0,
   25,    0,    0,    0,    0,   52,    0,    0,    0,    0,
    0,   53,    0,    0,    0,    0,   61,   62,
};
short yydgoto[] = {                                       3,
   19,    4,   20,   21,   22,   23,   59,   24,   25,   26,
   27,   81,  101,   28,   54,   29,   30,   31,   32,   48,
   49,   50,   51,  108,   78,   89,  123,
};
short yysindex[] = {                                   -119,
 -116, -121,    0,    0, -121, -121,  -17,   15,   19, -190,
  -44,   17, -174,   55,   43,    0,    0, -200,  -21, -121,
 -214,    0,    0, -152,    1,   48,  -15,   50,    0,   51,
   52,   53,  -19,  -12,   56, -172, -148,   76,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   46,    0,   11,
    0,    0,   77,   59, -137,    0,  -17,    0,  -89,    0,
    0,    0,    0, -214,    2,    0, -136,    0, -100,    0,
    0,    0,    0,    0,    0, -172,  -10,   81,   82,  -41,
   66, -172, -172, -172, -172, -172,    0,   64,   67,    0,
    0,    0,    0,    3,   46, -172, -139,   70,    0, -127,
   36, -183,   11,   11,    0,    0, -172,   90,   74, -124,
    0,   46, -100,    0,    0, -183,    0,    0,    0,    0,
 -123,  -23,   83, -171,  100,    0, -172,   47, -100,   84,
    0,   46, -113, -112, -110,    0,  118,  119,  102,   39,
   41,    0, -100, -100,   42,   45,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,   22,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    9,
   12,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  166,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  120,    0,  -40,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   14,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  122,    0,    0,    0,    0,    0,
    0,    0,  -35,  -30,    0,    0,  146,    0,    0,    0,
    0,  147,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  130,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   93,    0,  169,   34,   20,   23,    0,  -38,  167,    0,
    0,    0,   78,    0,    0,    0,    0,    0,    0,   -8,
  -43,   18,  -37,   85,    0,    0,    0,
};
#define YYTABLESIZE 252
short yytable[] = {                                      99,
   40,   18,   40,    2,   40,   41,    6,   41,    8,   41,
   42,    9,   42,    7,   42,   46,   45,   47,   40,   40,
   40,   40,   18,   41,   41,   41,   41,   77,   42,   42,
   42,   42,   82,   96,   83,   90,   46,   45,   47,   62,
   58,  100,   63,   35,   67,   67,  105,  106,  107,   46,
   45,   47,   84,   61,   36,   10,   57,   85,   37,   66,
   92,   16,   17,  118,    8,   19,   38,   95,    9,  107,
   11,   12,   13,   14,   15,   52,  117,  100,  127,  116,
   19,   91,   53,   62,   39,   40,   41,  112,   82,  133,
   83,  134,   16,   17,   55,  129,  130,   33,   34,  103,
  104,   56,   94,   60,   63,   74,   68,   69,   70,   71,
   72,   73,   75,   76,   79,   80,   86,   87,  132,   88,
   93,   97,   98,  102,  109,  110,  113,  111,  114,  115,
  120,  121,  122,    8,  126,    7,    9,    1,    7,    5,
  131,  128,  136,    8,  137,  138,  124,    9,   10,   11,
   12,   13,   14,   15,   16,   17,   57,  139,  140,  141,
  142,  143,  135,  144,    8,    5,  147,   57,    9,  148,
   11,   12,   13,   14,   15,    8,  145,  146,   38,    9,
   37,   11,   12,   13,   14,   15,   50,   54,   64,   64,
   65,  119,    0,  125,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   39,   40,   41,   42,   43,   44,    0,   40,
   40,   40,    0,    0,   41,   41,   41,    0,    0,   42,
   42,   42,    0,    0,   16,   17,   42,   43,   44,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   42,
   43,   44,
};
short yycheck[] = {                                      41,
   41,  123,   43,  123,   45,   41,  123,   43,    0,   45,
   41,    0,   43,    0,   45,   60,   61,   62,   59,   60,
   61,   62,  123,   59,   60,   61,   62,   36,   59,   60,
   61,   62,   43,   77,   45,  125,   60,   61,   62,   20,
   18,   80,  257,   61,   44,   44,   84,   85,   86,   60,
   61,   62,   42,   20,   40,  270,  257,   47,   40,   59,
   59,  276,  277,  102,  265,   44,  257,   76,  269,  107,
  271,  272,  273,  274,  275,   59,   41,  116,  122,   44,
   59,   59,  257,   64,  257,  258,  259,   96,   43,   43,
   45,   45,  276,  277,   40,  267,  268,    5,    6,   82,
   83,   59,   69,  125,  257,  125,   59,  123,   59,   59,
   59,   59,  125,   58,  263,   40,   40,   59,  127,  257,
  257,   41,   41,   58,   61,   59,  266,  125,   59,  257,
   41,   58,  257,  125,  258,  257,  125,  257,  125,  256,
   41,   59,   59,  265,  258,  258,  113,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  257,  268,   41,   41,
   59,  123,  129,  123,  265,    0,  125,  257,  269,  125,
  271,  272,  273,  274,  275,  265,  143,  144,   59,  269,
   59,  271,  272,  273,  274,  275,   41,   41,   59,   21,
   24,  107,   -1,  116,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  257,  258,  259,  260,  261,  262,   -1,  260,
  261,  262,   -1,   -1,  260,  261,  262,   -1,   -1,  260,
  261,  262,   -1,   -1,  276,  277,  260,  261,  262,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  260,
  261,  262,
};
#define YYFINAL 3
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 277
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"'{'",0,
"'}'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,"ID","CTE_INT","CTE_FLOTANTE","MENOR_IGUAL",
"MAYOR_IGUAL","DISTINTO","CADENA","ASIGNACION","IF","THEN","ELSE","ENDIF","OUT",
"FUN","RETURN","BREAK","DISCARD","FOR","CONTINUE","F32","I32",
};
char *yyrule[] = {
"$accept : programa",
"programa : ID '{' bloque '}'",
"programa : error_programa",
"error_programa : '{' bloque '}'",
"error_programa : ID error bloque '}'",
"error_programa : ID '{' bloque",
"bloque : bloque_declarativo bloque_ejecutable",
"bloque : bloque_ejecutable bloque_declarativo",
"bloque : bloque_declarativo",
"bloque : bloque_ejecutable",
"bloque_declarativo : declaracion",
"bloque_declarativo : bloque_declarativo declaracion",
"bloque_ejecutable : ejecucion",
"bloque_ejecutable : '{' bloque_sentencias_ejecutables '}'",
"bloque_sentencias_ejecutables : ejecucion",
"bloque_sentencias_ejecutables : bloque_sentencias_ejecutables ejecucion",
"declaracion : tipo lista_de_variables ';'",
"declaracion : funcion ';'",
"declaracion : lista_de_variables ';'",
"lista_de_variables : ID",
"lista_de_variables : lista_de_variables ',' ID",
"funcion : declaracion_fun '{' bloque_ejecutable '}'",
"declaracion_fun : FUN ID lista_de_parametros ':' tipo",
"lista_de_parametros : '(' ')'",
"lista_de_parametros : '(' parametro ')'",
"lista_de_parametros : '(' parametro ',' parametro ')'",
"parametro : tipo ID",
"tipo : I32",
"tipo : F32",
"ejecucion : asignacion ';'",
"ejecucion : DISCARD invocacion ';'",
"ejecucion : seleccion",
"ejecucion : retorno ';'",
"ejecucion : control ';'",
"ejecucion : salida ';'",
"ejecucion : BREAK ';'",
"ejecucion : CONTINUE ';'",
"asignacion : ID '=' ':' expresion_aritmetica",
"retorno : RETURN expresion_aritmetica",
"retorno : RETURN comparador",
"expresion_aritmetica : termino",
"expresion_aritmetica : expresion_aritmetica '+' termino",
"expresion_aritmetica : expresion_aritmetica '-' termino",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"factor : ID",
"factor : CTE_FLOTANTE",
"factor : CTE_INT",
"invocacion : ID '(' parametros_reales ')'",
"parametros_reales : factor",
"parametros_reales : factor parametros_reales",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ENDIF ';'",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ELSE bloque_ejecutable ENDIF ';'",
"condicion : expresion_aritmetica comparador expresion_aritmetica",
"comparador : '<'",
"comparador : '>'",
"comparador : '='",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
"control : FOR '(' asignacion_for ';' condicion_for ';' '+' CTE_INT ')' '{' bloque_ejecutable '}'",
"control : FOR '(' asignacion_for ';' condicion_for ';' '-' CTE_INT ')' '{' bloque_ejecutable '}'",
"asignacion_for : ID '=' ':' CTE_INT",
"condicion_for : ID comparador expresion_aritmetica",
"salida : OUT '(' CADENA ')' ';'",
};
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 138 "gramatica.y"

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

#line 333 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 12 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
break;
case 3:
#line 16 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
#line 17 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
#line 18 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
#line 21 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero declarativo y luego ejecutable ");}
break;
case 7:
#line 22 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero ejecutable y luego declarativo ");}
break;
case 8:
#line 23 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque declarativo ");}
break;
case 9:
#line 24 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque ejecutable ");}
break;
case 16:
#line 39 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
#line 44 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 20:
#line 45 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 21:
#line 48 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 27:
#line 62 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 28:
#line 63 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 35:
#line 73 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 36:
#line 74 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 41:
#line 85 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 42:
#line 86 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 43:
#line 89 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 44:
#line 90 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 46:
#line 94 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 47:
#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 48:
#line 96 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 49:
#line 99 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 52:
#line 107 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 53:
#line 108 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 61:
#line 122 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 62:
#line 123 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 65:
#line 133 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
#line 589 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
