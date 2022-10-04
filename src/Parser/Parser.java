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
    0,    0,    2,    2,    2,    1,    1,    1,    4,    3,
    3,    7,    7,    7,    7,    5,    5,    5,   12,   12,
   12,   10,   10,   10,   13,   13,   13,   11,   11,   15,
   15,   15,   14,   14,   17,   17,   17,   17,   17,   16,
   16,   16,   16,   19,   19,   19,   18,   18,   20,   20,
    9,    9,    6,    6,    6,    6,    6,    6,    6,   27,
   27,   27,   27,   27,   27,   27,   27,    8,    8,    8,
   28,   28,   21,   21,   21,   30,   30,   30,   30,   30,
   24,   24,   31,   29,   29,   29,   29,   33,   33,   32,
   32,   32,   32,   35,   35,   35,   35,   34,   34,   34,
   34,   34,   22,   22,   22,   37,   37,   36,   36,   36,
   39,   38,   38,   38,   38,   23,   23,   23,   42,   42,
   42,   42,   42,   42,   42,   41,   41,   41,   41,   43,
   43,   40,   44,   44,   44,   44,   44,   44,   25,   25,
   25,   47,   47,   47,   45,   45,   48,   48,   48,   46,
   46,   49,   49,   49,   26,   26,   50,   50,   50,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    1,    2,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    2,    3,    2,    2,    2,    1,
    2,    2,    3,    3,    1,    3,    3,    3,    2,    2,
    2,    1,    1,    1,    3,    3,    1,    3,    3,    3,
    3,    1,    1,    3,    3,    2,    2,    1,    1,    1,
    1,    2,    4,    3,    1,    4,    3,    1,    3,    1,
    2,    1,    1,    1,    2,    7,    9,    1,    6,    6,
    6,    6,    6,    6,    7,    1,    1,    3,    1,    2,
    2,    3,    1,    1,    1,    1,    1,    1,   10,   10,
    1,    9,    9,    9,    3,    1,    2,    2,    2,    3,
    1,    2,    2,    2,    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    6,    8,   10,   11,    0,    0,   17,   18,   24,    0,
   29,   34,    0,    0,    0,    0,    0,    0,   59,   75,
   82,  105,  118,  141,  156,    0,    0,    0,    0,    0,
    0,    0,    0,   43,   48,    0,  100,   99,    0,    0,
    0,  101,   80,    0,    0,   87,   92,   93,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   65,
    0,    0,   26,    0,    3,    7,   22,   21,    0,   25,
   20,    0,    0,    0,   60,   53,   67,   61,   55,   64,
   56,   62,   57,   63,   58,    4,    1,    0,   77,    0,
   78,   74,    0,    0,  112,  114,  113,    0,    0,    0,
    0,    0,  110,   47,    0,   44,    0,  102,   96,   97,
    0,    0,    0,    0,    0,    0,  137,  136,  138,  133,
  134,  135,    0,    0,  157,    0,  158,   50,    0,    0,
   40,    0,   66,   54,    0,    0,    0,  146,    0,   19,
   16,   27,   23,   32,    0,   30,  115,    0,   41,  106,
  103,    0,  111,   35,  107,  104,   88,    0,   89,    0,
   94,   90,   95,   91,    0,    0,    0,    0,    0,  155,
   37,    0,   38,   36,  148,    0,  147,    0,    0,   31,
   28,    0,  109,    0,    0,    0,    0,    0,    0,    0,
   70,    0,  129,    0,    0,    0,    0,   39,   33,  145,
    0,    0,    0,  151,    0,    0,   42,    0,   71,   68,
   72,   69,   12,    0,   13,  130,   14,   15,  121,  122,
  124,    0,  123,  120,    0,    0,    0,    0,  119,    0,
  128,  125,    0,  116,    0,    0,    0,    0,   46,    0,
    0,    0,    0,    0,    0,  117,  142,    0,  144,    0,
  143,  139,  140,
};
final static short yydgoto[] = {                          3,
   20,    4,   21,   22,   23,  208,  209,  210,   25,   26,
   27,   28,   29,   30,   31,   52,   32,   53,   54,   55,
   33,   34,   35,   36,   37,   38,   39,  211,   70,   40,
   41,   65,   66,   67,   68,  121,   42,  122,  123,   71,
  212,   43,  213,  143,  157,  223,   44,  158,  224,   45,
};
final static short yysindex[] = {                      -108,
  -97,   36,    0,    0,   36,   36,    0,  115,   60,   37,
  -28,  -26,  506,  -42,   -5,    0,    0, -220,  506,   51,
    0,    0,    0,    0,   29,   69,    0,    0,    0,  -31,
    0,    0,  -38,  -13,  -36,  120,  134,  137,    0,    0,
    0,    0,    0,    0,    0,   66,   89,   98,  138,  126,
 -202,    5,   27,    0,    0,   35,    0,    0,  287,  287,
  287,    0,    0,   73,   22,    0,    0,    0,   90,  413,
   40,   57,  -22, -146,  -24,   26,   72,   73,   35,    0,
  195, -226,    0,   86,    0,    0,    0,    0,  148,    0,
    0, -163,   -8,  104,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   35,    0,   73,
    0,    0,   73, -146,    0,    0,    0,    0,  363,   55,
  -12,  129,    0,    0, -156,    0,  403,    0,    0,    0,
  424,  449,  355,  374, -128,  -39,    0,    0,    0,    0,
    0,    0,  506, -116,    0,  110,    0,    0, -156,   -1,
    0, -156,    0,    0, -205,  -98,  102,    0, -104,    0,
    0,    0,    0,    0,   14,    0,    0, -190,    0,    0,
    0,  363,    0,    0,    0,    0,    0,   22,    0,   22,
    0,    0,    0,    0,  241,  241,  188,   73,  241,    0,
    0, -173,    0,    0,    0,  -95,    0,  470,  241,    0,
    0,   71,    0,    8,  199,  291,  312,    0,  264,    0,
    0, -103,    0, -102,  215, -100,  -99,    0,    0,    0,
  557,  506,  105,    0,  -93, -190,    0,   60,    0,    0,
    0,    0,    0,  293,    0,    0,    0,    0,    0,    0,
    0, -159,    0,    0,   73,  506,   73,  -37,    0,  140,
    0,    0,  241,    0,   73,  143,  -34,  -11,    0,  -90,
  241,  145,  241,  146,  241,    0,    0,  241,    0,  241,
    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  113,    0,    0,
    0,    0,  342,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  189,    0,    0,    0,
  -17,    0,    0,    0,    0,  547,    0,    0,    0,    0,
    0,    0,    0,  390,  381,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  422,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  111,    0,  434,
    0,    0,  436,  139,    0,    0,    0,   83,    0,   68,
    0,   21,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  438,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  458,    0,  481,
    0,    0,    0,    0,    0,    0,    0,  -30,    0,    0,
    0,    0,    0,    0,    0,  141,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  142,    0,  164,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  388,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  144,  147,  149,    0,    0,    0,
    0,    0,    0,    0,  150,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
   84,    0,   25,    0,    0,  462,  -19, -160,  499,  172,
    0,    0,    0,    0,    0,   10,    0,  -32,    0,    0,
    0,   -9,    0,    0,   -6,    0,    0,    0,   52,    0,
    0,   15,    0,  519,    0,    0,    0,  -94,    0,    1,
  513,    0,    0, -165,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=819;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   62,  187,   63,   62,   81,  257,  263,  258,   19,   62,
  132,   73,   18,   76,    2,   76,   80,  120,  147,   84,
   96,   77,   99,   49,  167,    6,   49,  173,  171,  265,
  155,   19,  222,  149,   82,   18,   83,  156,   62,   62,
   49,  109,  112,  120,   86,   97,  235,  127,  238,   62,
   62,   62,  195,   19,  124,  246,  192,   18,  196,   62,
   64,  108,  125,  133,   78,   74,  151,  126,  134,  136,
   86,   86,   18,  238,  127,   19,   69,  203,   60,   18,
  144,   59,  218,   61,  150,   16,   17,   88,   46,   47,
   19,   93,  162,  163,   18,  169,  252,  145,  168,  110,
  113,   60,   16,   17,   59,   19,   61,  253,  254,   18,
  148,  227,   92,   94,  226,  131,  164,  132,   86,   16,
   17,   62,   62,   62,   62,   45,  159,   91,   19,  152,
  135,   60,   18,   62,   59,  202,   61,  185,  201,   60,
   40,  104,   59,   19,   61,  178,  180,   18,    1,  189,
  190,   50,   98,   98,   50,   98,   22,   98,    5,  197,
  198,  199,  220,  248,  239,  240,  118,  243,  244,   98,
  119,   22,  172,  119,  249,   85,  165,  266,  101,   60,
  259,   12,   59,  261,   61,  268,  270,  234,    5,   86,
  106,   92,  103,  250,  188,  105,   89,  107,    0,  149,
  126,    0,  153,   13,    0,  154,  161,  152,  150,    0,
    0,   62,   62,  107,   79,    0,    0,   95,   62,   98,
  256,  109,  127,  262,    7,    8,  186,   19,  166,   74,
   75,   74,    9,   10,   72,  132,   62,   11,   12,   13,
  146,   14,   15,  170,   16,   17,  264,    7,    8,   16,
   17,   16,   17,  154,   19,    9,   10,  230,   49,   49,
   11,   12,   13,  228,   14,   15,   12,   16,   17,  200,
    8,   49,  245,  247,   16,   17,  108,    9,   10,  110,
   19,   74,   11,   12,   13,   87,   14,   15,   13,   16,
   17,    7,    8,   56,   57,   58,    0,  255,    0,    9,
   10,   16,   17,   19,   11,   12,   13,    8,   14,   15,
  207,   16,   17,    0,    9,   10,   56,   57,   58,   11,
   12,   13,    8,   14,   15,   90,   16,   17,    0,    9,
   10,   59,   19,   15,   11,   12,   13,  207,   14,   15,
    0,   16,   17,   45,   45,    8,   56,   57,   58,  232,
    0,   19,    9,   10,  108,   57,   58,   11,   12,   13,
    8,   14,   15,  207,   16,   17,   98,    9,   10,   22,
   48,   15,   11,   12,   13,  100,   14,   15,   49,   16,
   17,  114,  115,  116,  117,  115,  116,  117,  236,  102,
   16,   17,  104,  111,   56,   57,   58,  126,   12,   59,
   83,   16,   17,  160,   90,   12,   12,  119,  126,  126,
   12,   15,   12,   12,   12,   12,   12,  251,   59,  127,
   13,   84,    0,   84,    0,   84,    0,   13,   13,    0,
  127,  127,   13,    0,   13,   13,   13,   13,   13,   84,
   84,   84,   84,  176,  204,    0,  131,  119,   79,    0,
  153,    9,   10,  215,  229,  131,   11,  132,   13,  205,
   14,   15,  206,   24,    0,   60,   24,   24,   59,    0,
   61,  204,  140,  142,  141,    0,    0,    0,    9,   10,
   81,   24,  241,   11,    0,   13,  205,   14,   15,  206,
   60,   24,   76,   59,   73,   61,  159,  204,   85,    0,
   85,    0,   85,    0,    9,   10,   51,   24,   24,   11,
   51,   13,  205,   14,   15,  206,   85,   85,   85,   85,
  204,   86,    0,   86,    0,   86,    0,    9,   10,  140,
  142,  141,   11,    0,   13,  205,   14,   15,  206,   86,
   86,   86,   86,   56,   57,   58,  231,   60,   51,  204,
   59,    0,   61,    0,   24,   24,    9,   10,    0,    0,
    0,   11,    0,   13,  205,   14,   15,  206,  204,    0,
    0,    0,    0,   51,   51,    9,   10,  128,  129,  130,
   11,    0,   13,  205,   14,   15,  206,   98,   98,   98,
    0,   98,    0,   98,    0,    0,    0,   83,   60,    0,
    0,   59,    0,   61,    0,   98,   98,   98,   98,    0,
  181,   56,   57,   58,    0,    0,  140,  142,  141,  115,
  116,  117,    0,  174,    0,    0,   24,    0,    0,  183,
   56,   57,   58,    0,    0,    0,   84,    0,    0,    0,
   84,   84,   84,  131,    0,   79,   84,  191,  193,    0,
  194,  182,  184,    0,  131,  131,    0,    0,  175,  115,
  116,  117,    0,    0,    0,    0,   51,    0,  233,    0,
  237,    0,  137,  138,  139,    0,    0,   81,    0,  177,
   56,   57,   58,    0,    0,    0,    0,    0,    0,   76,
  219,   73,    0,  159,    0,  237,    0,    0,  214,  216,
    0,  217,    0,    0,  179,   56,   57,   58,    0,    0,
    0,  225,    0,   85,    0,    0,    0,   85,   85,   85,
    0,    0,    0,   85,   51,    0,  221,  242,    0,  137,
  138,  139,    0,    0,    0,    0,   86,    0,    0,    0,
   86,   86,   86,    0,    0,    0,   86,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   56,   57,   58,  260,    0,    0,    0,    0,
    0,    0,    0,  267,    0,  269,    0,  271,    0,    0,
  272,    0,  273,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   98,    0,    0,    0,   98,   98,   98,    0,
    0,    0,   98,   56,   57,   58,  137,  138,  139,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   10,   41,    9,   13,   14,   43,   41,   45,   40,   19,
   41,   40,   44,   40,  123,   40,   59,   50,   41,   19,
   59,   12,   59,   41,  119,  123,   44,  122,   41,   41,
  257,   40,  198,   58,   40,   44,  257,  264,   48,   49,
   58,   48,   49,   76,   20,   59,  207,   40,  209,   59,
   60,   61,  258,   40,  257,  221,   58,   44,  264,   69,
    9,   41,   58,   42,   13,  256,   41,   41,   47,   69,
   46,   47,   44,  234,   40,   40,   40,  172,   42,   44,
   41,   45,  256,   47,   75,  276,  277,   59,    5,    6,
   40,  123,  256,  257,   44,   41,  256,   41,   44,   48,
   49,   42,  276,  277,   45,   40,   47,  267,  268,   44,
  257,   41,   44,   30,   44,   43,  125,   45,   94,  276,
  277,  131,  132,  133,  134,   58,   41,   59,   40,   58,
   41,   42,   44,  143,   45,  168,   47,  266,  125,   42,
   58,   59,   45,   40,   47,  131,  132,   44,  257,  266,
   41,   41,   42,   43,   40,   45,   44,   47,  256,  258,
   59,  266,  258,   59,  268,  268,   41,  268,  268,   59,
   45,   59,   44,   45,  268,  125,   93,  268,   59,   42,
   41,   40,   45,   41,   47,   41,   41,  207,    0,  165,
  125,   44,   59,  226,  143,   59,   25,   59,   -1,   59,
   59,   -1,   59,   40,   -1,   59,   59,   59,   59,   -1,
   -1,  221,  222,  125,  257,   -1,   -1,  256,  228,  256,
  258,  228,   59,  258,  256,  257,  266,   40,  125,  256,
  257,  256,  264,  265,  263,  266,  246,  269,  270,  271,
  263,  273,  274,  256,  276,  277,  258,  256,  257,  276,
  277,  276,  277,   59,   40,  264,  265,   59,  276,  277,
  269,  270,  271,  256,  273,  274,  125,  276,  277,  256,
  257,  264,  221,  222,  276,  277,  256,  264,  265,  228,
   40,  256,  269,  270,  271,  257,  273,  274,  125,  276,
  277,  256,  257,  257,  258,  259,   -1,  246,   -1,  264,
  265,  276,  277,   40,  269,  270,  271,  257,  273,  274,
  123,  276,  277,   -1,  264,  265,  257,  258,  259,  269,
  270,  271,  257,  273,  274,  257,  276,  277,   -1,  264,
  265,   45,   40,  274,  269,  270,  271,  123,  273,  274,
   -1,  276,  277,  276,  277,  257,  257,  258,  259,   59,
   -1,   40,  264,  265,  257,  258,  259,  269,  270,  271,
  257,  273,  274,  123,  276,  277,  256,  264,  265,  257,
  256,  274,  269,  270,  271,  256,  273,  274,  264,  276,
  277,  256,  257,  258,  259,  257,  258,  259,  125,  256,
  276,  277,  256,  256,  257,  258,  259,  256,  257,   45,
   59,  276,  277,  256,  257,  264,  265,   45,  267,  268,
  269,  274,  271,  272,  273,  274,  275,  125,   45,  256,
  257,   41,   -1,   43,   -1,   45,   -1,  264,  265,   -1,
  267,  268,  269,   -1,  271,  272,  273,  274,  275,   59,
   60,   61,   62,   41,  257,   -1,   59,   45,   59,   -1,
  256,  264,  265,  266,  256,   43,  269,   45,  271,  272,
  273,  274,  275,    2,   -1,   42,    5,    6,   45,   -1,
   47,  257,   60,   61,   62,   -1,   -1,   -1,  264,  265,
   59,   20,  268,  269,   -1,  271,  272,  273,  274,  275,
   42,   30,   59,   45,   59,   47,   59,  257,   41,   -1,
   43,   -1,   45,   -1,  264,  265,    8,   46,   47,  269,
   12,  271,  272,  273,  274,  275,   59,   60,   61,   62,
  257,   41,   -1,   43,   -1,   45,   -1,  264,  265,   60,
   61,   62,  269,   -1,  271,  272,  273,  274,  275,   59,
   60,   61,   62,  257,  258,  259,  256,   42,   50,  257,
   45,   -1,   47,   -1,   93,   94,  264,  265,   -1,   -1,
   -1,  269,   -1,  271,  272,  273,  274,  275,  257,   -1,
   -1,   -1,   -1,   75,   76,  264,  265,   59,   60,   61,
  269,   -1,  271,  272,  273,  274,  275,   41,   42,   43,
   -1,   45,   -1,   47,   -1,   -1,   -1,  256,   42,   -1,
   -1,   45,   -1,   47,   -1,   59,   60,   61,   62,   -1,
  256,  257,  258,  259,   -1,   -1,   60,   61,   62,  257,
  258,  259,   -1,  125,   -1,   -1,  165,   -1,   -1,  256,
  257,  258,  259,   -1,   -1,   -1,  256,   -1,   -1,   -1,
  260,  261,  262,  256,   -1,  256,  266,  149,  150,   -1,
  152,  133,  134,   -1,  267,  268,   -1,   -1,  256,  257,
  258,  259,   -1,   -1,   -1,   -1,  168,   -1,  207,   -1,
  209,   -1,  260,  261,  262,   -1,   -1,  256,   -1,  256,
  257,  258,  259,   -1,   -1,   -1,   -1,   -1,   -1,  256,
  192,  256,   -1,  256,   -1,  234,   -1,   -1,  186,  187,
   -1,  189,   -1,   -1,  256,  257,  258,  259,   -1,   -1,
   -1,  199,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
   -1,   -1,   -1,  266,  226,   -1,  257,  215,   -1,  260,
  261,  262,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,
  260,  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  257,  258,  259,  253,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  261,   -1,  263,   -1,  265,   -1,   -1,
  268,   -1,  270,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
   -1,   -1,  266,  257,  258,  259,  260,  261,  262,
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
"bloque : sentencia",
"bloque : bloque sentencia",
"bloque : error_bloque",
"error_bloque : error",
"sentencia : declaracion",
"sentencia : ejecucion",
"bloque_ejecutable : ejecucion",
"bloque_ejecutable : ejecucion_control",
"bloque_ejecutable : bloque_ejecutable ejecucion",
"bloque_ejecutable : bloque_ejecutable ejecucion_control",
"declaracion : tipo lista_de_variables ';'",
"declaracion : funcion",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"error_declaracion : lista_de_variables ';'",
"error_declaracion : tipo ';'",
"lista_de_variables : ID",
"lista_de_variables : lista_de_variables ',' ID",
"lista_de_variables : error_lista_de_variables",
"error_lista_de_variables : lista_de_variables ID",
"error_lista_de_variables : ',' ID",
"error_lista_de_variables : lista_de_variables ',' error",
"funcion : declaracion_fun '{' bloque '}'",
"funcion : error_funcion",
"error_funcion : declaracion_fun bloque '}'",
"error_funcion : declaracion_fun '{' bloque error",
"error_funcion : declaracion_fun '{' '}'",
"declaracion_fun : FUN ID lista_de_parametros ':' tipo",
"declaracion_fun : error_declaracion_fun",
"error_declaracion_fun : ID lista_de_parametros ':' tipo",
"error_declaracion_fun : FUN lista_de_parametros ':' tipo",
"error_declaracion_fun : FUN ID ':' tipo",
"error_declaracion_fun : FUN ID lista_de_parametros tipo",
"error_declaracion_fun : FUN ID lista_de_parametros ':' error",
"lista_de_parametros : '(' ')'",
"lista_de_parametros : '(' parametro ')'",
"lista_de_parametros : '(' parametro ',' parametro ')'",
"lista_de_parametros : error_lista_de_parametros",
"error_lista_de_parametros : parametro ')'",
"error_lista_de_parametros : '(' parametro",
"error_lista_de_parametros : '(' parametro ',' parametro ',' parametro ')'",
"parametro : tipo ID",
"parametro : error_parametro",
"error_parametro : tipo",
"error_parametro : error ID",
"tipo : I32",
"tipo : F32",
"ejecucion : asignacion ';'",
"ejecucion : DISCARD invocacion ';'",
"ejecucion : seleccion ';'",
"ejecucion : retorno ';'",
"ejecucion : control ';'",
"ejecucion : salida ';'",
"ejecucion : error_ejecucion",
"error_ejecucion : asignacion error",
"error_ejecucion : seleccion error",
"error_ejecucion : control error",
"error_ejecucion : salida error",
"error_ejecucion : retorno error",
"error_ejecucion : DISCARD ';'",
"error_ejecucion : DISCARD invocacion error",
"error_ejecucion : invocacion ';'",
"ejecucion_control : BREAK ';'",
"ejecucion_control : CONTINUE ';'",
"ejecucion_control : error_ejecucion_control",
"error_ejecucion_control : BREAK error",
"error_ejecucion_control : CONTINUE error",
"asignacion : ID ASIGNACION expresion_aritmetica",
"asignacion : ID ASIGNACION control",
"asignacion : error_asignacion",
"error_asignacion : ID error expresion_aritmetica",
"error_asignacion : ID error control",
"error_asignacion : ID ASIGNACION error",
"error_asignacion : ASIGNACION expresion_aritmetica",
"error_asignacion : ASIGNACION control",
"retorno : RETURN expresion_aritmetica",
"retorno : error_retorno",
"error_retorno : RETURN",
"expresion_aritmetica : termino",
"expresion_aritmetica : expresion_aritmetica '+' termino",
"expresion_aritmetica : expresion_aritmetica '-' termino",
"expresion_aritmetica : error_expresion_aritmetica",
"error_expresion_aritmetica : expresion_aritmetica '+' error",
"error_expresion_aritmetica : expresion_aritmetica '-' error",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"termino : error_termino",
"error_termino : termino '*' error",
"error_termino : termino '/' error",
"error_termino : '*' factor",
"error_termino : '/' factor",
"factor : ID",
"factor : CTE_FLOTANTE",
"factor : CTE_INT",
"factor : invocacion",
"factor : '-' factor",
"invocacion : ID '(' parametros_reales ')'",
"invocacion : ID '(' ')'",
"invocacion : error_invocacion",
"error_invocacion : ID '(' parametros_reales error",
"error_invocacion : ID '(' error",
"parametros_reales : factor_invocacion",
"parametros_reales : factor_invocacion ',' factor_invocacion",
"parametros_reales : error_parametros_reales",
"error_parametros_reales : factor_invocacion factor_invocacion",
"factor_invocacion : ID",
"factor_invocacion : CTE_FLOTANTE",
"factor_invocacion : CTE_INT",
"factor_invocacion : '-' factor_invocacion",
"seleccion : IF '(' condicion ')' THEN bloque_if_for ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_if_for ELSE bloque_if_for ENDIF",
"seleccion : error_seleccion",
"error_seleccion : '(' condicion ')' THEN bloque_if_for ENDIF",
"error_seleccion : IF condicion ')' THEN bloque_if_for ENDIF",
"error_seleccion : IF '(' ')' THEN bloque_if_for ENDIF",
"error_seleccion : IF '(' condicion THEN bloque_if_for ENDIF",
"error_seleccion : IF '(' condicion ')' bloque_if_for ENDIF",
"error_seleccion : IF '(' condicion ')' THEN ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_if_for error",
"bloque_if_for : ejecucion",
"bloque_if_for : ejecucion_control",
"bloque_if_for : '{' bloque_ejecutable '}'",
"bloque_if_for : error_bloque_if",
"error_bloque_if : bloque_ejecutable '}'",
"error_bloque_if : '{' bloque_ejecutable",
"condicion : expresion_aritmetica comparador expresion_aritmetica",
"comparador : '<'",
"comparador : '>'",
"comparador : '='",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
"control : FOR '(' asignacion_for ';' condicion_for ';' '+' CTE_INT ')' bloque_if_for",
"control : FOR '(' asignacion_for ';' condicion_for ';' '-' CTE_INT ')' bloque_if_for",
"control : error_control",
"error_control : FOR '(' asignacion_for ';' condicion_for ';' CTE_INT ')' bloque_if_for",
"error_control : FOR '(' asignacion_for ';' condicion_for ';' '-' ')' bloque_if_for",
"error_control : FOR '(' asignacion_for ';' condicion_for ';' '+' ')' bloque_if_for",
"asignacion_for : ID ASIGNACION CTE_INT",
"asignacion_for : error_asignacion_for",
"error_asignacion_for : ASIGNACION CTE_INT",
"error_asignacion_for : ID CTE_INT",
"error_asignacion_for : ID ASIGNACION",
"condicion_for : ID comparador expresion_aritmetica",
"condicion_for : error_condicion_for",
"error_condicion_for : comparador expresion_aritmetica",
"error_condicion_for : ID expresion_aritmetica",
"error_condicion_for : ID comparador",
"salida : OUT '(' CADENA ')'",
"salida : error_salida",
"error_salida : OUT CADENA ')'",
"error_salida : OUT '(' ')'",
"error_salida : OUT '(' CADENA",
};

//#line 289 "gramatica.y"

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

//#line 664 "Parser.java"
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
case 9:
//#line 26 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " no es una sentencia declarativa o ejecutable valida");}
break;
case 16:
//#line 52 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 57 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 58 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
break;
case 21:
//#line 59 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
break;
case 22:
//#line 62 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 23:
//#line 63 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 25:
//#line 67 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 68 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 72 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
//#line 76 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 31:
//#line 77 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 32:
//#line 78 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
break;
case 35:
//#line 85 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 36:
//#line 86 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 37:
//#line 87 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 38:
//#line 88 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 39:
//#line 89 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 44:
//#line 98 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 99 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 100 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
//#line 107 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 108 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 111 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
//#line 112 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 60:
//#line 124 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 61:
//#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 62:
//#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 63:
//#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 64:
//#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 65:
//#line 129 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
//#line 130 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
//#line 131 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 68:
//#line 134 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 69:
//#line 135 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 71:
//#line 139 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 72:
//#line 140 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 76:
//#line 148 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 77:
//#line 149 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 78:
//#line 150 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 79:
//#line 151 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 80:
//#line 152 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 83:
//#line 160 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 85:
//#line 164 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 86:
//#line 165 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 88:
//#line 169 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 89:
//#line 170 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 90:
//#line 173 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 91:
//#line 174 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 94:
//#line 179 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 95:
//#line 180 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 96:
//#line 181 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 97:
//#line 182 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 98:
//#line 185 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 99:
//#line 186 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 100:
//#line 187 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 101:
//#line 188 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 103:
//#line 192 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 106:
//#line 197 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 107:
//#line 199 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 111:
//#line 208 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 112:
//#line 211 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 113:
//#line 212 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 114:
//#line 213 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 116:
//#line 217 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 117:
//#line 218 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 119:
//#line 222 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 120:
//#line 223 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
break;
case 121:
//#line 224 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
break;
case 122:
//#line 225 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
break;
case 123:
//#line 226 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
break;
case 124:
//#line 227 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
break;
case 125:
//#line 228 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 130:
//#line 237 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
break;
case 131:
//#line 238 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
break;
case 139:
//#line 252 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 140:
//#line 253 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 142:
//#line 257 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 143:
//#line 258 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 144:
//#line 259 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 147:
//#line 266 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
break;
case 148:
//#line 267 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
break;
case 149:
//#line 268 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
break;
case 152:
//#line 275 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
break;
case 153:
//#line 276 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
break;
case 154:
//#line 277 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}
break;
case 155:
//#line 280 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 157:
//#line 284 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 158:
//#line 285 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
break;
case 159:
//#line 286 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1193 "Parser.java"
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
