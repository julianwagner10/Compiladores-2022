package Parser;//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";








import Principal.*;

public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short ID=257;
public final static short CTE_INT=258;
public final static short CTE_FLOTANTE=259;
public final static short MENOR_IGUAL=260;
public final static short MAYOR_IGUAL=261;
public final static short DISTINTO=262;
public final static short CADENA=263;
public final static short ASIGNACION=264;
public final static short IF=265;
public final static short THEN=266;
public final static short ELSE=267;
public final static short ENDIF=268;
public final static short OUT=269;
public final static short FUN=270;
public final static short RETURN=271;
public final static short BREAK=272;
public final static short DISCARD=273;
public final static short FOR=274;
public final static short CONTINUE=275;
public final static short F32=276;
public final static short I32=277;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    1,    1,    1,    2,    2,    5,    5,    3,
    3,    7,    7,    4,    4,    4,   11,    9,    9,    9,
   12,   10,   13,   14,   14,   14,   15,    8,    8,    6,
    6,    6,    6,    6,    6,    6,    6,   16,   19,   19,
   22,   22,   22,   24,   24,   24,   25,   25,   25,   25,
   25,   17,   26,   26,   18,   18,   18,   27,   23,   23,
   23,   23,   23,   23,   20,   20,   29,   30,   21,   28,
   28,   28,   28,   28,   28,
};
final static short yylen[] = {                            2,
    1,    2,    2,    1,    1,    1,    3,    1,    2,    1,
    3,    1,    2,    3,    2,    1,    3,    1,    3,    1,
    2,    4,    5,    2,    3,    5,    2,    1,    1,    2,
    3,    2,    2,    2,    2,    2,    2,    4,    2,    2,
    1,    3,    3,    3,    3,    1,    1,    1,    1,    2,
    2,    4,    1,    2,    7,    9,    1,    3,    1,    1,
    1,    1,    1,    1,   12,   12,    4,    3,    5,    7,
    7,    7,    7,    7,    9,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   29,   28,    0,    2,    0,    5,    6,   10,    0,
    0,   16,    0,    0,    0,    0,    0,    0,   57,    0,
    0,   48,   47,    0,    0,    0,    0,    0,   46,    0,
    0,    0,   63,   62,   64,   61,   59,   60,    0,   40,
   36,    0,    0,    0,   37,    8,    0,   12,    0,    0,
    3,   18,    0,   20,   15,    0,   30,   32,   33,   34,
   35,    0,    0,    0,    0,   51,   50,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   31,    0,    0,    7,
    9,   11,   13,   17,   21,   14,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   44,   45,    0,
    0,   24,    0,    0,    0,    0,    0,   19,   22,   54,
   52,    0,    0,    0,    0,   69,   27,    0,   25,   23,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   67,
    0,    0,   71,   73,   72,   74,    0,   55,   70,   26,
    0,    0,    0,    0,    0,    0,    0,   75,   56,    0,
    0,    0,    0,    0,    0,   65,   66,
};
final static short yydgoto[] = {                          2,
   15,   16,   17,   18,   57,   19,   59,   20,   63,   21,
   22,   64,   23,   86,  114,   24,   36,   25,   26,   27,
   28,   37,   50,   38,   39,  101,   40,   29,   89,  133,
};
final static short yysindex[] = {                      -233,
 -119,    0,   -7,   -5,   48, -181,    7,   37, -157,   61,
   47,    0,    0, -142,    0,   16,    0,    0,    0, -150,
   49,    0,  -14,   55,   57,   58,   60,   62,    0,   64,
   73,    0,    0,   21,  -34,   65,   -1,   36,    0,   79,
 -138,   96,    0,    0,    0,    0,    0,    0,   27,    0,
    0,   73,   78, -117,    0,    0, -108,    0,  -72, -180,
    0,    0,  -13,    0,    0, -119,    0,    0,    0,    0,
    0,  -34,  -34, -125,  -35,    0,    0,  -34,  -34,  -34,
  -34,  -34, -124,  102,  -41,   86,    0,   84,   88,    0,
    0,    0,    0,    0,    0,    0,  -97,   41,   27,  -34,
  120,   16,   16, -103,   36,   36,   27,    0,    0,   16,
  119,    0,  -76,   43, -212,  124,  -66,    0,    0,    0,
    0,  -74,  -73,  -98,  -70,    0,    0, -212,    0,    0,
  -62,  -47,  133,  145,  146,  147, -193,  148,  167,    0,
  -34,   54,    0,    0,    0,    0,  -85,    0,    0,    0,
   27,  -49,  -48,  152,  -56,  175,  189,    0,    0,  109,
  114,   16,   16,  113,  115,    0,    0,
};
final static short yyrindex[] = {                         0,
  239,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   23,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -40,    0,    0,    0,    0,    0,    0,  -33,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  182,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  183,  204,
    0,    0,    0,    0,  -11,   -4,  -32,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   57,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  180,    0,    2,   33,    0,   22,    0,  -42,    0,    0,
    0,    0,    0,    0,  135,    0,  238,    0,    0,    0,
    0,   38,  -21,   24,   -2,  170,  214,    0,    0,    0,
};
final static int YYTABLESIZE=291;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        112,
   49,   49,   49,   14,   49,  104,   49,   41,   58,   41,
   35,   41,   47,   46,   48,   80,   90,   61,   49,   49,
   49,   49,    4,    1,   60,   41,   41,   41,   41,   42,
   97,   42,   76,   42,   34,   58,   43,   60,   43,   35,
   43,   78,  113,   79,   49,   96,   56,   42,   42,   42,
   42,   35,   92,   30,   43,   43,   43,   43,   47,   46,
   48,   74,  146,   12,   13,   35,   47,   46,   48,   78,
  100,   79,  130,  147,  148,   42,    3,   81,  108,  109,
   93,   58,   82,  129,    4,  113,  128,   41,    5,   91,
    7,    8,    9,   10,   11,   51,  152,  100,  153,   52,
   54,  105,  106,  122,  123,   55,   62,   65,   66,   99,
  141,  125,   73,   67,    3,   68,   69,  107,   70,   83,
   71,   72,    4,   77,   84,  137,    5,    6,    7,    8,
    9,   10,   11,   12,   13,   85,   87,    3,   60,   88,
  102,  110,  111,  115,  116,    4,  117,    4,  155,    5,
    6,    7,    8,    9,   10,   11,   12,   13,    3,  118,
  121,    6,  124,  164,  165,  119,    4,   12,   13,  136,
    5,    3,    7,    8,    9,   10,   11,  126,  151,    4,
  127,  131,  154,    5,    3,    7,    8,    9,   10,   11,
  132,  142,    4,  134,  135,  140,    5,  138,    7,    8,
    9,   10,   11,  143,  144,  145,  149,  150,  156,  157,
  158,  159,   43,   44,   45,  160,   49,   49,   49,   49,
   49,   49,   31,   32,   33,   49,   41,   41,   41,  161,
  103,  162,   41,   58,   12,   13,  163,  166,    1,  167,
   39,   38,   94,   95,   53,   98,   53,   75,   42,   42,
   42,   31,   32,   33,   42,   43,   43,   43,   43,   44,
   45,   43,  139,   31,   32,   33,   43,   44,   45,  120,
    0,    0,    3,    0,    0,    0,    0,   31,   32,   33,
    4,    0,    0,    0,    5,    0,    7,    8,    9,   10,
   11,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   41,   42,   43,  123,   45,   41,   47,   41,   41,   43,
   45,   45,   60,   61,   62,   37,  125,   16,   59,   60,
   61,   62,    0,  257,  123,   59,   60,   61,   62,   41,
   44,   43,   35,   45,   40,   14,   41,  123,   43,   45,
   45,   43,   85,   45,    7,   59,   14,   59,   60,   61,
   62,   45,  125,   61,   59,   60,   61,   62,   60,   61,
   62,   41,  256,  276,  277,   45,   60,   61,   62,   43,
   73,   45,  115,  267,  268,  257,  257,   42,   81,   82,
   59,   60,   47,   41,  265,  128,   44,   40,  269,   57,
  271,  272,  273,  274,  275,   59,   43,  100,   45,  257,
   40,   78,   79,  102,  103,   59,  257,   59,  123,   72,
  132,  110,   40,   59,  257,   59,   59,   80,   59,   41,
   59,   58,  265,   59,  263,  124,  269,  270,  271,  272,
  273,  274,  275,  276,  277,   40,   59,  257,  123,  257,
  266,  266,   41,   58,   61,  265,   59,  125,  147,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  257,  257,
   41,  270,  266,  162,  163,  125,  265,  276,  277,  268,
  269,  257,  271,  272,  273,  274,  275,   59,  141,  265,
  257,   58,  268,  269,  257,  271,  272,  273,  274,  275,
  257,   59,  265,  268,  268,  258,  269,  268,  271,  272,
  273,  274,  275,   59,   59,   59,   59,   41,  258,  258,
   59,  268,  260,  261,  262,   41,  257,  258,  259,  260,
  261,  262,  257,  258,  259,  266,  260,  261,  262,   41,
  266,  123,  266,  266,  276,  277,  123,  125,    0,  125,
   59,   59,  256,  257,   41,   66,    9,   34,  260,  261,
  262,  257,  258,  259,  266,  260,  261,  262,  260,  261,
  262,  266,  128,  257,  258,  259,  260,  261,  262,  100,
   -1,   -1,  257,   -1,   -1,   -1,   -1,  257,  258,  259,
  265,   -1,   -1,   -1,  269,   -1,  271,  272,  273,  274,
  275,
};
}
final static short YYFINAL=2;
final static short YYMAXTOKEN=277;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
"'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,"':'","';'",
"'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,"ID","CTE_INT","CTE_FLOTANTE","MENOR_IGUAL",
"MAYOR_IGUAL","DISTINTO","CADENA","ASIGNACION","IF","THEN","ELSE","ENDIF","OUT",
"FUN","RETURN","BREAK","DISCARD","FOR","CONTINUE","F32","I32",
};
final static String yyrule[] = {
"$accept : programa",
"programa : ID",
"programa : ID bloque",
"bloque : bloque_declarativo bloque_ejecutable",
"bloque : bloque_declarativo",
"bloque : bloque_ejecutable",
"bloque_declarativo : declaracion",
"bloque_declarativo : '{' bloque_sentencias_declarativo '}'",
"bloque_sentencias_declarativo : declaracion",
"bloque_sentencias_declarativo : bloque_sentencias_declarativo declaracion",
"bloque_ejecutable : ejecucion",
"bloque_ejecutable : '{' bloque_sentencias_ejecutable '}'",
"bloque_sentencias_ejecutable : ejecucion",
"bloque_sentencias_ejecutable : bloque_sentencias_ejecutable ejecucion",
"declaracion : tipo lista_de_variables ';'",
"declaracion : funcion ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"lista_de_variables : ID",
"lista_de_variables : lista_de_variables ',' ID",
"lista_de_variables : error_lista_de_variables",
"error_lista_de_variables : lista_de_variables ID",
"funcion : declaracion_fun '{' bloque '}'",
"declaracion_fun : FUN ID lista_de_parametros ':' tipo",
"lista_de_parametros : '(' ')'",
"lista_de_parametros : '(' parametro ')'",
"lista_de_parametros : '(' parametro ',' parametro ')'",
"parametro : tipo ID",
"tipo : I32",
"tipo : F32",
"ejecucion : asignacion ';'",
"ejecucion : DISCARD invocacion ';'",
"ejecucion : seleccion ';'",
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
"factor : CTE_FLOTANTE",
"factor : CTE_INT",
"factor : ID",
"factor : invocacion ';'",
"factor : '-' factor",
"invocacion : ID '(' parametros_reales ')'",
"parametros_reales : factor",
"parametros_reales : factor parametros_reales",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ELSE bloque_ejecutable ENDIF",
"seleccion : error_seleccion",
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
"error_seleccion : IF condicion ')' THEN bloque_ejecutable ENDIF ';'",
"error_seleccion : IF '(' ')' THEN bloque_ejecutable ENDIF ';'",
"error_seleccion : IF '(' condicion ')' THEN ENDIF ';'",
"error_seleccion : IF '(' condicion THEN bloque_ejecutable ENDIF ';'",
"error_seleccion : IF '(' condicion ')' THEN bloque_ejecutable error",
"error_seleccion : IF '(' condicion ')' THEN bloque_ejecutable ELSE ENDIF ';'",
};

//#line 152 "gramatica.y"

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

//#line 418 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 7 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto un programa con nombre solamente");}
break;
case 2:
//#line 8 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa");}
break;
case 14:
//#line 33 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variables");}
break;
case 17:
//#line 38 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " sentencia mal declarada, falta ';'");}
break;
case 18:
//#line 41 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 19:
//#line 42 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 21:
//#line 46 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " sentencia mal declarada, falta una ',' entre identificadores");}
break;
case 22:
//#line 49 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 28:
//#line 64 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 29:
//#line 65 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 42:
//#line 87 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 43:
//#line 88 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 44:
//#line 91 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 45:
//#line 92 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 47:
//#line 96 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 48:
//#line 97 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 49:
//#line 98 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 51:
//#line 100 "gramatica.y"
{chequearNegativos();}
break;
case 55:
//#line 111 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 56:
//#line 112 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 65:
//#line 127 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 66:
//#line 128 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 69:
//#line 138 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 70:
//#line 141 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta el parentesis de apertura ");}
break;
case 71:
//#line 142 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta condicion ");}
break;
case 72:
//#line 143 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta bloque ejecutable ");}
break;
case 73:
//#line 144 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta parentesis de cierre ");}
break;
case 74:
//#line 145 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta ENDIF de cierre ");}
break;
case 75:
//#line 146 "gramatica.y"
{System.out.println("Error sintáctico: falta bloque ejecutable luego del ELSE ");}
break;
//#line 683 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
