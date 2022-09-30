//### This file created by BYACC 1.8(/Java extension  1.15)
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






//#line 2 "gramatica.y"
package Parser;
import Principal.*;
//#line 20 "Parser.java"




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
    0,    0,    2,    2,    2,    1,    1,    1,    1,    3,
    3,    4,    4,    7,    7,    5,    5,    5,    9,    9,
   10,   11,   12,   12,   12,   13,    8,    8,    6,    6,
    6,    6,    6,    6,    6,    6,   14,   17,   17,   20,
   20,   20,   22,   22,   22,   23,   23,   23,   15,   24,
   24,   16,   16,   25,   21,   21,   21,   21,   21,   21,
   18,   18,   26,   27,   19,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    2,    2,    1,    1,    1,
    2,    1,    3,    1,    2,    3,    2,    2,    1,    3,
    4,    5,    2,    3,    5,    2,    1,    1,    2,    3,
    1,    2,    2,    2,    2,    2,    4,    2,    2,    1,
    3,    3,    3,    3,    1,    1,    1,    1,    4,    1,
    2,    8,   10,    3,    1,    1,    1,    1,    1,    1,
   12,   12,    4,    3,    5,
};
final static short yydefred[] = {                         0,
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
final static short yydgoto[] = {                          3,
   19,    4,   20,   21,   22,   23,   59,   24,   25,   26,
   27,   81,  101,   28,   54,   29,   30,   31,   32,   48,
   49,   50,   51,  108,   78,   89,  123,
};
final static short yysindex[] = {                      -119,
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
final static short yyrindex[] = {                         0,
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
final static short yygindex[] = {                         0,
   93,    0,  169,   34,   20,   23,    0,  -38,  167,    0,
    0,    0,   78,    0,    0,    0,    0,    0,    0,   -8,
  -43,   18,  -37,   85,    0,    0,    0,
};
final static int YYTABLESIZE=252;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         99,
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
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
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
}
final static short YYFINAL=3;
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

//#line 138 "gramatica.y"

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

//#line 397 "Parser.java"
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
//#line 12 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
break;
case 3:
//#line 16 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
//#line 17 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 18 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
//#line 21 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero declarativo y luego ejecutable ");}
break;
case 7:
//#line 22 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero ejecutable y luego declarativo ");}
break;
case 8:
//#line 23 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque declarativo ");}
break;
case 9:
//#line 24 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque ejecutable ");}
break;
case 16:
//#line 39 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 44 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 20:
//#line 45 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 21:
//#line 48 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 27:
//#line 62 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 28:
//#line 63 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 35:
//#line 73 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 36:
//#line 74 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 41:
//#line 85 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 42:
//#line 86 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 43:
//#line 89 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 44:
//#line 90 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 46:
//#line 94 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 47:
//#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 48:
//#line 96 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 49:
//#line 99 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 52:
//#line 107 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 53:
//#line 108 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 61:
//#line 122 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 62:
//#line 123 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 65:
//#line 133 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
//#line 662 "Parser.java"
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
