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
    0,    1,    1,    1,    2,    2,    5,    5,    3,    3,
    7,    7,    4,    4,    4,    9,    9,   10,   11,   12,
   12,   12,   13,    8,    8,    6,    6,    6,    6,    6,
    6,    6,    6,   14,   17,   17,   20,   20,   20,   22,
   22,   22,   23,   23,   23,   15,   24,   24,   16,   16,
   25,   21,   21,   21,   21,   21,   21,   18,   18,   26,
   27,   19,
};
final static short yylen[] = {                            2,
    2,    2,    1,    1,    1,    3,    1,    2,    1,    3,
    1,    2,    3,    2,    2,    1,    3,    4,    5,    2,
    3,    5,    2,    1,    1,    2,    3,    2,    2,    2,
    2,    2,    2,    4,    2,    2,    1,    3,    3,    3,
    3,    1,    1,    1,    1,    4,    1,    2,    7,    9,
    3,    1,    1,    1,    1,    1,    1,   12,   12,    4,
    3,    5,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   25,   24,    0,    1,    0,    4,    5,    9,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   45,   44,   43,   56,   55,   57,   54,   52,
   53,    0,   36,    0,   42,   32,    0,    0,    0,   33,
    7,    0,   11,    0,    0,    0,    2,   16,    0,   15,
    0,   14,    0,   26,   28,   29,   30,   31,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   27,
    0,    0,    6,    8,   10,   12,   13,   17,    0,    0,
    0,    0,    0,   20,    0,    0,    0,    0,    0,   40,
   41,    0,    0,    0,    0,   18,    0,    0,   62,   23,
    0,   21,   19,   48,   46,    0,    0,    0,    0,    0,
   60,    0,    0,    0,   49,   22,    0,    0,    0,    0,
    0,    0,   50,    0,    0,    0,    0,    0,    0,   58,
   59,
};
final static short yydgoto[] = {                          2,
   15,   16,   17,   18,   52,   19,   54,   20,   21,   22,
   23,   74,   96,   24,   48,   25,   26,   27,   28,   42,
   43,   44,   45,  103,   71,   82,  118,
};
final static short yysindex[] = {                      -245,
 -121,    0,  -47,    1,   15, -212,  -44,    4, -191,   29,
   43,    0,    0, -190,    0, -100,    0,    0,    0, -180,
   -2,   53,  -29,   54,   57,   58,   59,   60,   30, -167,
 -149,   80,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   50,    0,   11,    0,    0,   81,   63, -134,    0,
    0,  -91,    0,  -81,  -47, -168,    0,    0,    5,    0,
 -133,    0, -100,    0,    0,    0,    0,    0, -167,  -10,
   84,   85,  -41,   71, -167, -167, -167, -167, -167,    0,
   69,   72,    0,    0,    0,    0,    0,    0,    7,   50,
 -167, -132,   74,    0, -122,   18, -204,   11,   11,    0,
    0, -167,   96,   82, -119,    0,   50, -100,    0,    0,
 -204,    0,    0,    0,    0, -117,  -23,   83, -159,   98,
    0, -167,   55, -100,    0,    0,   50, -115, -113, -110,
  105,  106,    0,   36,   37, -100, -100,   38,   39,    0,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,   17,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  161,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  103,    0,  -40,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  108,
    0,    0,    0,    0,    0,    0,    0,  -35,  -30,    0,
    0,  127,    0,    0,    0,    0,  129,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  118,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
    0,    0,   -9,   26,    0,   14,    0,  -37,  158,    0,
    0,    0,   70,    0,    0,    0,    0,    0,    0,  -26,
  -61,   35,  -31,   78,    0,    0,    0,
};
final static int YYTABLESIZE=252;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         94,
   37,   14,   37,   70,   37,   38,   57,   38,   91,   38,
   39,    1,   39,   29,   39,   40,   39,   41,   37,   37,
   37,   37,   56,   38,   38,   38,   38,   53,   39,   39,
   39,   39,   75,   83,   76,   95,   40,   39,   41,   51,
   30,   61,   90,   85,   32,  100,  101,  102,   61,   40,
   39,   41,   77,   89,   31,  122,   60,   78,  112,  113,
   16,  111,   46,   87,  107,   47,    3,   86,   49,   53,
  102,   12,   13,   95,    4,   16,   58,   84,    5,    6,
    7,    8,    9,   10,   11,   12,   13,   69,   55,   33,
   34,   35,   75,   63,   76,  127,    4,  128,  119,  129,
    5,   50,    7,    8,    9,   10,   11,  124,  125,   98,
   99,   62,   64,   72,  130,   65,   66,   67,   68,   73,
   79,   80,   81,   88,   92,   93,  138,  139,   97,  104,
  105,  106,  109,  108,  110,    3,  115,  117,  126,  116,
  121,  123,  131,    4,  132,  134,  135,    5,    6,    7,
    8,    9,   10,   11,   12,   13,   55,  133,  136,  137,
    3,   35,  140,  141,    4,   58,   34,   47,    5,   51,
    7,    8,    9,   10,   11,   55,   61,   59,    6,  114,
  120,    0,    0,    4,   12,   13,    0,    5,    0,    7,
    8,    9,   10,   11,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   33,   34,   35,   36,   37,   38,    0,   37,
   37,   37,    0,    0,   38,   38,   38,    0,    0,   39,
   39,   39,    0,    0,   12,   13,   36,   37,   38,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   36,
   37,   38,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
   41,  123,   43,   30,   45,   41,   16,   43,   70,   45,
   41,  257,   43,   61,   45,   60,   61,   62,   59,   60,
   61,   62,  123,   59,   60,   61,   62,   14,   59,   60,
   61,   62,   43,  125,   45,   73,   60,   61,   62,   14,
   40,   44,   69,  125,  257,   77,   78,   79,   44,   60,
   61,   62,   42,   63,   40,  117,   59,   47,   41,   97,
   44,   44,   59,   59,   91,  257,  257,   54,   40,   56,
  102,  276,  277,  111,  265,   59,  257,   52,  269,  270,
  271,  272,  273,  274,  275,  276,  277,   58,  257,  257,
  258,  259,   43,  123,   45,  122,  265,   43,  108,   45,
  269,   59,  271,  272,  273,  274,  275,  267,  268,   75,
   76,   59,   59,  263,  124,   59,   59,   59,   59,   40,
   40,   59,  257,  257,   41,   41,  136,  137,   58,   61,
   59,  125,   59,  266,  257,  257,   41,  257,   41,   58,
  258,   59,  258,  265,  258,   41,   41,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  257,  268,  123,  123,
    0,   59,  125,  125,  265,  257,   59,   41,  269,   41,
  271,  272,  273,  274,  275,  257,   59,   20,  270,  102,
  111,   -1,   -1,  265,  276,  277,   -1,  269,   -1,  271,
  272,  273,  274,  275,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  257,  258,  259,  260,  261,  262,   -1,  260,
  261,  262,   -1,   -1,  260,  261,  262,   -1,   -1,  260,
  261,  262,   -1,   -1,  276,  277,  260,  261,  262,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  260,
  261,  262,
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
"invocacion : ID '(' parametros_reales ')'",
"parametros_reales : factor",
"parametros_reales : factor parametros_reales",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ELSE bloque_ejecutable ENDIF",
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

//#line 140 "gramatica.y"

private Lexico lexico;


public Parser(Lexico lexico)
{
  this.lexico = lexico;

}

public int yylex(){
   Token token = this.lexico.obtenerToken();

   if(token != null ){
   	int val = token.getId();
   	System.out.println("lexema: "+token.getLexema()+" Identificador "+token.getId());
   	yylval = new ParserVal(token.getLexema());
   	return val;
   }
   System.out.println("Token = null");
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

//#line 396 "Parser.java"
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
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa");}
break;
case 2:
//#line 15 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] ambos bloques ");}
break;
case 3:
//#line 16 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] solo bloque declarativo ");}
break;
case 4:
//#line 17 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] solo bloque ejecutable ");}
break;
case 9:
//#line 28 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] ejecucion ");}
break;
case 13:
//#line 37 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variables");}
break;
case 16:
//#line 44 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 17:
//#line 45 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 18:
//#line 49 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 24:
//#line 64 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 25:
//#line 65 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 32:
//#line 75 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] TOY EN BREAK");}
break;
case 33:
//#line 76 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] TOY EN CONTINUE");}
break;
case 38:
//#line 87 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 39:
//#line 88 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 40:
//#line 91 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 41:
//#line 92 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 43:
//#line 96 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 44:
//#line 97 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 45:
//#line 98 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 46:
//#line 101 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 49:
//#line 109 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 50:
//#line 110 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 58:
//#line 124 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 59:
//#line 125 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 62:
//#line 135 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
//#line 649 "Parser.java"
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
