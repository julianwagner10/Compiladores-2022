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
import ArbolSintactico.*;
import java.util.ArrayList;

//#line 23 "Parser.java"




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
    3,    7,    7,    9,    9,    5,    5,    5,   13,   13,
   13,   11,   11,   11,   14,   14,   14,   12,   12,   16,
   16,   16,   15,   15,   18,   18,   18,   18,   18,   17,
   17,   17,   17,   20,   20,   20,   19,   19,   21,   21,
   10,   10,    6,    6,    6,    6,    6,    6,    6,   28,
   28,   28,   28,   28,   28,   28,   28,    8,    8,    8,
    8,    8,    8,    8,    8,    8,   29,   29,   29,   29,
   29,   30,   22,   22,   22,   32,   32,   32,   32,   32,
   25,   25,   33,   31,   31,   31,   31,   35,   35,   34,
   34,   34,   34,   37,   37,   37,   37,   36,   36,   36,
   36,   36,   36,   23,   23,   23,   39,   39,   38,   38,
   38,   41,   41,   41,   40,   40,   40,   40,   40,   24,
   24,   44,   44,   44,   44,   44,   43,   43,   43,   47,
   47,   47,   45,   45,   45,   46,   46,   46,   48,   48,
   49,   49,   49,   50,   50,   50,   51,   51,   42,   42,
   53,   53,   53,   52,   52,   52,   52,   52,   52,   26,
   26,   26,   57,   56,   56,   56,   58,   58,   58,   58,
   58,   54,   54,   59,   59,   59,   55,   55,   60,   60,
   60,   27,   27,   61,   61,   61,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    2,    3,    2,    2,    3,    2,
    2,    2,    2,    2,    4,    1,    2,    2,    3,    3,
    4,    2,    3,    3,    1,    3,    3,    3,    2,    2,
    2,    1,    1,    1,    3,    3,    1,    3,    3,    3,
    3,    1,    1,    3,    3,    2,    2,    1,    1,    1,
    1,    2,    2,    4,    3,    1,    4,    3,    1,    3,
    1,    2,    5,    7,    1,    1,    1,    2,    2,    5,
    1,    4,    4,    4,    4,    5,    3,    4,    1,    4,
    2,    3,    1,    3,    1,    2,    4,    1,    2,    2,
    3,    3,    3,    1,    3,    1,    2,    2,    3,    1,
    2,    2,    2,    1,    1,    1,    1,    1,    1,    9,
   10,    1,    4,    2,    2,    1,    1,    2,    2,    2,
    2,    3,    1,    2,    2,    2,    3,    1,    2,    2,
    2,    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    6,    8,   10,   11,    0,    0,   17,   18,   24,    0,
   29,   34,    0,    0,    0,    0,    0,    0,   59,    0,
   85,   92,  116,  131,  172,  193,    0,    0,    0,    0,
   82,    0,    0,    0,    0,   43,   48,    0,  110,  109,
    0,    0,    0,  111,   90,    0,    0,   97,  102,  103,
    0,  168,  167,  169,    0,  164,  165,  166,    0,    0,
    0,  160,    0,    0,    0,    0,    0,    0,    0,    0,
   65,    0,    0,   26,    0,    3,    7,   22,   21,    0,
   25,   20,    0,    0,    0,   60,   53,   67,   61,   55,
   64,   56,   62,   57,   63,   58,    0,    4,    1,    0,
   87,    0,   88,   84,    0,    0,  125,  127,  126,    0,
    0,    0,    0,    0,  121,   47,    0,   44,    0,  112,
  113,  106,  107,    0,    0,    0,    0,    0,    0,  163,
    0,    0,    0,  194,    0,  195,   50,    0,    0,   40,
    0,   66,   54,    0,    0,    0,    0,  183,    0,   19,
   16,   27,   23,   32,    0,   30,    0,  128,  129,    0,
   41,  117,  114,    0,  122,   35,  118,  115,   98,    0,
   99,    0,  104,  100,  105,  101,    0,    0,  134,  139,
    0,  135,    0,  133,  192,   37,    0,   38,   36,  185,
    0,  184,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   76,  173,  156,    0,  132,   31,   28,
    0,    0,    0,    0,    0,    0,    0,    0,  145,    0,
    0,  130,   39,   33,  182,    0,   77,   73,    0,   78,
    0,   74,    0,    0,   12,  157,   13,   68,   70,   71,
   72,    0,    0,    0,  188,    0,    0,   42,    0,   14,
    0,  149,   15,    0,    0,    0,  148,  137,    0,   69,
   79,    0,   80,  155,    0,    0,    0,    0,    0,    0,
    0,  144,    0,    0,    0,    0,  140,  138,   81,   75,
    0,  177,    0,    0,    0,  176,    0,   46,    0,    0,
  152,  151,  179,  174,  180,  178,  175,  181,    0,    0,
  124,  147,  170,    0,  171,
};
final static short yydgoto[] = {                          3,
   20,    4,   21,   22,   23,   24,  218,  219,  237,   25,
   26,   27,   28,   29,   30,   31,   54,   32,   55,   56,
   57,   33,   34,   35,   36,   37,   38,   39,  224,   40,
   79,   41,   42,   67,   68,   69,   70,  133,   43,  134,
  135,   80,  199,   44,  238,  276,  200,  239,  277,  225,
  226,   81,   82,  167,  264,  305,   45,  306,  168,  265,
   46,
};
final static short yysindex[] = {                      -101,
  -97,   93,    0,    0,   93,   93,    0,  -33,   72,  535,
  -39,  -30,  448,  -25,  -29,    0,    0, -196,  681,  108,
    0,    0,    0,    0,   94,  111,    0,    0,    0,   27,
    0,    0,  -35,  -10,   16,   29,   68,  124,    0, -188,
    0,    0,    0,    0,    0,    0,  135,  153,  175,  248,
    0,   -6, -141,   70,   91,    0,    0,   -4,    0,    0,
 -221,  102,  102,    0,    0,   20,   84,    0,    0,    0,
   96,    0,    0,    0,  594,    0,    0,    0,  512,  113,
  448,    0,  131,  -38, -108,  -28,  -14,  118,   20,   96,
    0,  130,   25,    0,  144,    0,    0,    0,    0,   99,
    0,    0,  -92,   49,  174,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  120,    0,    0,   -4,
    0,   20,    0,    0,   20, -108,    0,    0,    0,    0,
  -64,  127,  -18,  391,    0,    0,  138,    0,  132,    0,
    0,    0,    0,  507,  519,  478,  502, -166,  -26,    0,
  448, -166,   20,    0,  158,    0,    0,  138,  -41,    0,
  138,    0,    0, -134,  -78,  189,  145,    0, -166,    0,
    0,    0,    0,    0,   71,    0, -139,    0,    0, -208,
    0,    0,    0,  216,    0,    0,    0,    0,    0,   84,
    0,   84,    0,    0,    0,    0,  314,  314,    0,    0,
 -143,    0,   20,    0,    0,    0, -178,    0,    0,    0,
  -51,    0,  -45,  139,   86,   76,  267,  227,    0,  316,
  324,  335,  362,    0,    0,    0,  618,    0,    0,    0,
  366,  146,  396,   24,  425,    0,  347, -105,    0,  -76,
  314,    0,    0,    0,    0,   72,    0,    0,  383,    0,
  410,    0,   51,  246,    0,    0,    0,    0,    0,    0,
    0,  681,  448,  418,    0,  618, -208,    0,  216,    0,
  373,    0,    0,  358,  425,  187,    0,    0,  192,    0,
    0,  278,    0,    0,   20,  448,   20,  -24,  423,  444,
  450,    0,  425,    0,  388,  401,    0,    0,    0,    0,
   20,    0,  495,  542,  456,    0,  -24,    0,  216,  412,
    0,    0,    0,    0,    0,    0,    0,    0,  189,  473,
    0,    0,    0,  189,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  119,    0,    0,
    0,    0,  279,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  538,    0,    0,
    0,    0,  -12,    0,    0,    0,    0,   61,    0,    0,
    0,    0,    0,    0,    0,  361,  141,    0,    0,    0,
  650,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  407,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   38,
    0,  408,    0,    0,  417,  453,    0,    0,    0,  154,
    0,   -8,    0,   18,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   10,    0,   21,    0,  457,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  484,
    0,  659,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   55,    0,    0,    0,    0,    0,    0,    0,
  489,    0,    0,    0,    0,    0,    0,    0,  214,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   46,    0,    0,  334,    0,    0,    0,  458,
  469,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  471,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  357,    0,    0,    0,    0,    0,    0,    0,  474,    0,
    0,    0,    0,    0,  494,  497,  501,    0,    0,    0,
   60,    0,    0,  294,    0,    0,    0,    0,    0,    0,
  511,    0,    0,    0,    0,    0,    0,    0,    0,  200,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   47,    0,  742,    0,    0,  660,  359, -162, -202,    8,
  556,    0,    0,    0,    0,    0,   19,    0,  129,    0,
    0,  563,   -5,  565,    0,   -9,  567,    0,    0,    0,
   -7,    0,    0,  364,    0,   59,    0,    0,    0,  500,
    0,    9,  -40,    0,  386,  346,    0,    0,    0, -217,
    0,  490,    0,  415,  323,  286,    0,    0,    0,    0,
    0,
};
final static int YYTABLESIZE=970;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         65,
   84,   66,  156,   64,   64,   89,   52,   64,   92,   87,
   93,   87,   51,   64,  201,   53,  207,  275,  303,   53,
  304,    2,  183,  107,   51,    6,  160,   95,   49,  158,
   88,   49,  271,   91,  130,  139,  140,  141,  131,  121,
  124,  122,  125,   64,   64,   49,  275,   85,  108,   45,
  162,   47,   48,   51,  255,  257,   64,   64,  119,   53,
   94,  161,  144,  139,  145,  166,   19,   16,   17,   64,
   18,  295,  296,  153,  110,   64,  105,  243,   50,  108,
  108,   51,  108,  149,  108,  117,  120,  112,   19,  197,
  310,  257,   18,   53,   53,  159,  108,   16,   17,  198,
  123,  323,  108,  108,  159,  108,  325,  108,  202,  283,
   19,  204,  241,   62,   18,  136,   61,  164,   63,  108,
  142,  143,  198,  210,  165,  146,  114,  137,  228,  211,
  147,  138,   19,  253,  252,  139,   18,   18,   64,   64,
   64,   64,  103,  203,  186,   64,   61,   19,  157,  104,
  175,   18,   99,  152,  103,    1,  222,  171,    5,  177,
  242,  274,   22,  172,  173,  206,  208,  181,  209,  102,
  180,  154,  188,  174,   19,  161,  131,   22,   18,  212,
  132,   94,  116,   94,  169,   94,  268,   53,  163,  267,
  274,  278,   19,  178,  179,  230,   18,  248,  205,   94,
   94,   94,   94,  227,  194,  196,  245,  222,  222,  249,
  246,   40,  115,   19,  244,  132,   62,   18,   50,   61,
  106,   63,   49,   83,  155,   85,   86,   85,   19,  197,
   50,   90,   96,  302,   16,   17,  121,  182,  122,  198,
   64,   85,   16,   17,  222,   16,   17,   16,   17,  126,
  127,  128,  129,   12,  285,  287,   64,   64,  153,  118,
  131,   16,   17,   49,   49,  162,   19,   45,   45,   16,
   17,  109,  154,  119,   53,  162,  161,  119,  301,  246,
   64,  164,    7,    8,  111,   19,  161,   50,  165,   62,
    9,   10,   61,  108,   63,   11,   12,   13,  176,   14,
   15,  120,   16,   17,    7,    8,   19,  282,  232,  222,
  159,  217,    9,   10,  222,  123,  108,   11,   12,   13,
  159,   14,   15,  113,   16,   17,  229,    8,   58,   59,
   60,  250,  251,   14,    9,   10,  300,   93,   12,   11,
   12,   13,   90,   14,   15,   15,   16,   17,    7,    8,
   98,  256,  146,   19,  170,  101,    9,   10,   71,   59,
   60,   11,   12,   13,    8,   14,   15,  101,   16,   17,
  284,    9,   10,   14,  258,   22,   11,   12,   13,  115,
   14,   15,  259,   16,   17,  162,   19,  187,  127,  128,
  129,    8,  143,  260,  247,  290,   94,   19,    9,   10,
   94,   94,   94,   11,   12,   13,   94,   14,   15,    8,
   16,   17,   19,   16,   17,  150,    9,   10,   14,   89,
  261,   11,   12,   13,  266,   14,   15,   19,   16,   17,
    8,  120,   59,   60,  184,  131,  235,    9,   10,  269,
   19,  280,   11,   12,   13,  213,   14,   15,   15,   16,
   17,   19,    9,   10,  297,  153,  143,   11,   14,  298,
  214,  215,   15,  216,   19,   91,   86,  153,  281,  154,
   12,  272,  127,  128,  129,   83,  288,   12,   12,  150,
  293,  307,   12,  213,  308,   12,   12,   12,   12,   62,
    9,   10,   61,  309,   63,   11,  319,  292,  214,  215,
   15,  216,  213,  123,   58,   59,   60,  190,  192,    9,
   10,  118,  311,  324,   11,  196,  141,  214,  215,   15,
  216,   15,   61,  213,   95,  312,   95,  136,   95,  158,
    9,   10,  142,  299,   93,   11,  322,    5,  214,  215,
   15,  216,   95,   95,   95,   95,   61,  186,   62,  146,
   14,   61,  190,   63,  144,  191,  145,   14,   14,  189,
   62,  146,   14,   61,   14,   63,   14,   14,  151,  187,
  234,   76,   78,   77,   75,  254,   62,    9,   10,   61,
  100,   63,   11,  240,   13,  279,   14,   15,  289,  143,
   14,  231,  320,    0,   76,   78,   77,   14,   14,    0,
  143,  143,   14,  234,   14,    0,   14,   14,    0,    0,
    9,   10,  150,    0,  234,   11,   89,   13,    0,   14,
   15,    9,   10,  150,  150,    0,   11,    0,   13,  234,
   14,   15,    0,  185,  148,   62,    9,   10,   61,    0,
   63,   11,    0,   13,  234,   14,   15,  127,  128,  129,
    0,    9,   10,   76,   78,   77,   11,  234,   13,    0,
   14,   15,   91,   86,    9,   10,    0,    0,  234,   11,
    0,   13,   83,   14,   15,    9,   10,   76,   78,   77,
   11,  234,   13,  233,   14,   15,    0,    0,    9,   10,
  108,  108,  108,   11,  108,   13,  108,   14,   15,   96,
    0,   96,    0,   96,   71,   59,   60,    0,  108,  108,
  108,  108,  196,  141,    0,    0,  263,   96,   96,   96,
   96,    0,   62,    0,  136,   61,  158,   63,  220,  142,
  221,    0,  223,  193,   71,   59,   60,    0,    0,   95,
   76,   78,   77,   95,   95,   95,    0,    0,    0,   95,
  313,  286,  314,  315,    0,  263,    0,  195,   71,   59,
   60,   97,  189,   71,   59,   60,    0,  150,  291,    0,
    0,   72,   73,   74,  191,   71,   59,   60,    0,  220,
  220,  221,  221,  223,  223,    0,    0,    0,   97,   97,
    0,   71,   59,   60,   72,   73,   74,  316,    0,  317,
  318,    0,    0,    0,    0,    0,    0,    0,  321,    0,
    0,    0,    0,    0,    0,    0,  220,    0,  221,    0,
  223,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   97,    0,    0,    0,
   71,   59,   60,   72,   73,   74,  236,  236,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  262,    0,    0,   72,   73,   74,
    0,  220,    0,  221,    0,  223,  220,    0,  221,    0,
  223,    0,    0,    0,  270,    0,  273,    0,    0,    0,
  236,    0,    0,    0,    0,  108,    0,    0,    0,  108,
  108,  108,    0,    0,   96,  108,   97,    0,   96,   96,
   96,    0,    0,    0,   96,    0,    0,    0,    0,    0,
  273,    0,    0,  294,  270,    0,    0,   71,   59,   60,
   72,   73,   74,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  270,    0,  273,  273,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  273,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   40,    9,   41,    9,   10,   13,   40,   13,   14,   40,
   40,   40,   58,   19,   41,    8,   58,  123,   43,   12,
   45,  123,   41,   59,   58,  123,   41,   19,   41,   58,
   12,   44,  235,   59,   41,   40,  258,  259,   45,   49,
   50,   49,   50,   49,   50,   58,  123,  256,   59,   58,
   41,    5,    6,   58,  217,  218,   62,   63,   41,   52,
  257,   41,   43,   40,   45,   41,   40,  276,  277,   75,
   44,  274,  275,   81,   59,   81,   30,  256,   41,   42,
   43,   58,   45,   75,   47,  274,   41,   59,   40,  256,
  293,  254,   44,   86,   87,   41,   59,  276,  277,  266,
   41,  319,   42,   43,   86,   45,  324,   47,  149,   59,
   40,  152,  256,   42,   44,  257,   45,  257,   47,   59,
   62,   63,  266,  258,  264,   42,   59,   58,  169,  264,
   47,   41,   40,   58,   59,   40,   44,   44,  144,  145,
  146,  147,   44,  151,  137,  151,   45,   40,  257,  123,
  104,   44,   59,   41,   44,  257,  166,   59,  256,   40,
  201,  267,   44,  256,  257,  158,  159,   41,  161,   59,
   44,   41,   41,  125,   40,   58,   45,   59,   44,  258,
   52,   41,   59,   43,   41,   45,   41,  180,   59,   44,
  267,  268,   40,  258,  259,  125,   44,   59,   41,   59,
   60,   61,   62,   59,  146,  147,  258,  217,  218,  215,
  256,   58,   59,   40,  207,   87,   42,   44,  264,   45,
  256,   47,  256,  263,  263,  256,  257,  256,   40,  256,
  264,  257,  125,  258,  276,  277,  246,  256,  246,  266,
  246,  256,  276,  277,  254,  276,  277,  276,  277,  256,
  257,  258,  259,   40,  262,  263,  262,  263,   59,  125,
   45,  276,  277,  276,  277,  256,   40,  276,  277,  276,
  277,  256,   59,  256,  267,  266,  256,  125,  286,  256,
  286,  257,  256,  257,  256,   40,  266,  264,  264,   42,
  264,  265,   45,  256,   47,  269,  270,  271,  125,  273,
  274,  256,  276,  277,  256,  257,   40,  257,  180,  319,
  256,  123,  264,  265,  324,  256,  256,  269,  270,  271,
  266,  273,  274,  256,  276,  277,  256,  257,  257,  258,
  259,  256,  257,   40,  264,  265,   59,   59,  125,  269,
  270,  271,  257,  273,  274,  274,  276,  277,  256,  257,
  257,  125,   59,   40,  256,  257,  264,  265,  257,  258,
  259,  269,  270,  271,  257,  273,  274,  257,  276,  277,
  125,  264,  265,   40,   59,  257,  269,  270,  271,  256,
  273,  274,   59,  276,  277,  256,   40,  256,  257,  258,
  259,  257,   59,   59,  256,  267,  256,   40,  264,  265,
  260,  261,  262,  269,  270,  271,  266,  273,  274,  257,
  276,  277,   40,  276,  277,   59,  264,  265,  125,   59,
   59,  269,  270,  271,   59,  273,  274,   40,  276,  277,
  257,  257,  258,  259,   44,   45,  123,  264,  265,   44,
   40,   59,  269,  270,  271,  257,  273,  274,  274,  276,
  277,   40,  264,  265,  268,  256,  123,  269,  125,  268,
  272,  273,  274,  275,   40,   59,   59,  268,   59,  256,
  257,  125,  257,  258,  259,   59,   59,  264,  265,  123,
  123,   59,  269,  257,   41,  272,  273,  274,  275,   42,
  264,  265,   45,   44,   47,  269,   41,  125,  272,  273,
  274,  275,  257,  256,  257,  258,  259,  144,  145,  264,
  265,   59,  125,   41,  269,   59,   59,  272,  273,  274,
  275,  274,   45,  257,   41,  125,   43,   59,   45,   59,
  264,  265,   59,  256,  256,  269,  125,    0,  272,  273,
  274,  275,   59,   60,   61,   62,   45,   59,   42,  256,
  257,   45,   59,   47,   43,   59,   45,  264,  265,   59,
   42,  268,  269,   45,  271,   47,  273,  274,   79,   59,
  257,   60,   61,   62,   40,  217,   42,  264,  265,   45,
   25,   47,  269,  198,  271,  240,  273,  274,  266,  256,
  257,  177,  307,   -1,   60,   61,   62,  264,  265,   -1,
  267,  268,  269,  257,  271,   -1,  273,  274,   -1,   -1,
  264,  265,  256,   -1,  257,  269,  256,  271,   -1,  273,
  274,  264,  265,  267,  268,   -1,  269,   -1,  271,  257,
  273,  274,   -1,  134,   41,   42,  264,  265,   45,   -1,
   47,  269,   -1,  271,  257,  273,  274,  257,  258,  259,
   -1,  264,  265,   60,   61,   62,  269,  257,  271,   -1,
  273,  274,  256,  256,  264,  265,   -1,   -1,  257,  269,
   -1,  271,  256,  273,  274,  264,  265,   60,   61,   62,
  269,  257,  271,  184,  273,  274,   -1,   -1,  264,  265,
   41,   42,   43,  269,   45,  271,   47,  273,  274,   41,
   -1,   43,   -1,   45,  257,  258,  259,   -1,   59,   60,
   61,   62,  256,  256,   -1,   -1,  227,   59,   60,   61,
   62,   -1,   42,   -1,  256,   45,  256,   47,  166,  256,
  166,   -1,  166,  256,  257,  258,  259,   -1,   -1,  256,
   60,   61,   62,  260,  261,  262,   -1,   -1,   -1,  266,
  256,  262,  258,  259,   -1,  266,   -1,  256,  257,  258,
  259,   20,  256,  257,  258,  259,   -1,  256,  269,   -1,
   -1,  260,  261,  262,  256,  257,  258,  259,   -1,  217,
  218,  217,  218,  217,  218,   -1,   -1,   -1,   47,   48,
   -1,  257,  258,  259,  260,  261,  262,  256,   -1,  258,
  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  309,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  254,   -1,  254,   -1,
  254,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  105,   -1,   -1,   -1,
  257,  258,  259,  260,  261,  262,  197,  198,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  257,   -1,   -1,  260,  261,  262,
   -1,  319,   -1,  319,   -1,  319,  324,   -1,  324,   -1,
  324,   -1,   -1,   -1,  235,   -1,  237,   -1,   -1,   -1,
  241,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,
  261,  262,   -1,   -1,  256,  266,  175,   -1,  260,  261,
  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,   -1,
  271,   -1,   -1,  274,  275,   -1,   -1,  257,  258,  259,
  260,  261,  262,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  293,   -1,  295,  296,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  310,
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
"bloque_ejecutable_for : ejecucion_control",
"bloque_ejecutable_for : bloque_ejecutable_for ejecucion_control",
"bloque_ejecutable_if : ejecucion",
"bloque_ejecutable_if : bloque_ejecutable_if ejecucion",
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
"ejecucion_control : asignacion ';'",
"ejecucion_control : DISCARD invocacion ';'",
"ejecucion_control : seleccion ';'",
"ejecucion_control : control ';'",
"ejecucion_control : salida ';'",
"ejecucion_control : BREAK ';'",
"ejecucion_control : CONTINUE ';'",
"ejecucion_control : CONTINUE ':' ID ';'",
"ejecucion_control : error_ejecucion_control",
"error_ejecucion_control : BREAK error",
"error_ejecucion_control : CONTINUE error",
"error_ejecucion_control : CONTINUE ID ';'",
"error_ejecucion_control : CONTINUE ':' ';'",
"error_ejecucion_control : CONTINUE ':' ID error",
"etiqueta : ID ':'",
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
"factor : '-' CTE_INT",
"factor : '-' CTE_FLOTANTE",
"invocacion : ID '(' parametros_reales ')'",
"invocacion : ID '(' ')'",
"invocacion : error_invocacion",
"error_invocacion : ID '(' parametros_reales error",
"error_invocacion : ID '(' error",
"parametros_reales : factor_invocacion",
"parametros_reales : factor_invocacion ',' factor_invocacion",
"parametros_reales : error_parametros_reales",
"error_parametros_reales : factor_invocacion factor_invocacion",
"error_parametros_reales : factor_invocacion ',' factor_invocacion ',' factor_invocacion",
"error_parametros_reales : factor_invocacion ',' factor_invocacion ',' factor_invocacion ',' factor_invocacion",
"factor_invocacion : ID",
"factor_invocacion : CTE_FLOTANTE",
"factor_invocacion : CTE_INT",
"factor_invocacion : '-' CTE_INT",
"factor_invocacion : '-' CTE_FLOTANTE",
"seleccion : IF '(' condicion ')' cuerpo_if",
"seleccion : error_seleccion",
"error_seleccion : '(' condicion ')' cuerpo_if",
"error_seleccion : IF condicion ')' cuerpo_if",
"error_seleccion : IF '(' ')' cuerpo_if",
"error_seleccion : IF '(' condicion cuerpo_if",
"error_seleccion : IF '(' condicion ')' error",
"cuerpo_if : THEN cuerpo_then ENDIF",
"cuerpo_if : THEN cuerpo_then cuerpo_else ENDIF",
"cuerpo_if : error_cuerpo_if",
"error_cuerpo_if : error cuerpo_then cuerpo_else ENDIF",
"error_cuerpo_if : THEN cuerpo_then",
"error_cuerpo_if : THEN cuerpo_then cuerpo_else",
"cuerpo_then : ejecucion",
"cuerpo_then : '{' bloque_ejecutable_if '}'",
"cuerpo_then : error_cuerpo_then",
"cuerpo_else : ELSE ejecucion",
"cuerpo_else : ELSE '{' bloque_ejecutable_if '}'",
"cuerpo_else : error_cuerpo_else",
"error_cuerpo_then : bloque_ejecutable_if '}'",
"error_cuerpo_then : '{' bloque_ejecutable_if",
"error_cuerpo_else : '{' bloque_ejecutable_if '}'",
"error_cuerpo_else : ELSE bloque_ejecutable_if '}'",
"error_cuerpo_else : ELSE '{' bloque_ejecutable_if",
"bloque_for : ejecucion_control",
"bloque_for : '{' bloque_ejecutable_for '}'",
"bloque_for : error_bloque_for",
"error_bloque_for : bloque_ejecutable_for '}'",
"error_bloque_for : '{' bloque_ejecutable_for",
"condicion : expresion_aritmetica comparador expresion_aritmetica",
"condicion : error_condicion",
"error_condicion : comparador expresion_aritmetica",
"error_condicion : expresion_aritmetica comparador",
"error_condicion : expresion_aritmetica error",
"comparador : '<'",
"comparador : '>'",
"comparador : '='",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
"control : FOR '(' asignacion_for ';' condicion_for ';' incr_decr ')' bloque_for",
"control : etiqueta FOR '(' asignacion_for ';' condicion_for ';' incr_decr ')' bloque_for",
"control : error_control",
"error_control : FOR '(' ')' bloque_for",
"incr_decr : '+' CTE_INT",
"incr_decr : '-' CTE_INT",
"incr_decr : error_incr_decr",
"error_incr_decr : CTE_INT",
"error_incr_decr : '-' error",
"error_incr_decr : '+' error",
"error_incr_decr : '+' CTE_FLOTANTE",
"error_incr_decr : '-' CTE_FLOTANTE",
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

//#line 711 "gramatica.y"

private Lexico lexico;
private ArbolSintactico arbolSintactico;
private String ambito;
private ArrayList<String> lista_variables;
private ArrayList<String> lista_parametros;
private ArrayList<String> lista_parametros_reales;

public Parser(Lexico lexico)
{
  this.lexico = lexico;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
  this.lista_parametros = new ArrayList<String>();
  this.lista_parametros_reales = new ArrayList<String>();
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

//#line 804 "Parser.java"
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
//#line 15 "gramatica.y"
{arbolSintactico = val_peek(1).arbol;
                            Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval).setUso("nombrePrograma");
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
break;
case 2:
//#line 19 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
//#line 22 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
//#line 23 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 24 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
//#line 27 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 7:
//#line 28 "gramatica.y"
{     if(val_peek(0).arbol != null){
                                        if (val_peek(1).arbol !=null){
                                        AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                        yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);
                                    }else{
                                         AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                         yyval.arbol = new NodoBloqueEjecutable(val_peek(0).arbol,val_peek(1).arbol,atributos);
                                    }
                                }
                           }
break;
case 9:
//#line 41 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
break;
case 10:
//#line 44 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 11:
//#line 45 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 12:
//#line 48 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 13:
//#line 49 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableFor");
                                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 14:
//#line 53 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 15:
//#line 54 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableIf");
                                                      yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 16:
//#line 59 "gramatica.y"
{  String tipoVar = val_peek(2).sval;
					                        lista_variables = (ArrayList<String>)val_peek(1).obj;
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
break;
case 17:
//#line 75 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 19:
//#line 79 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 80 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 81 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 84 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);
                        lista_variables.add(val_peek(0).sval);
                        Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval).setUso("Variable");
                        yyval = new ParserVal(lista_variables);
                                }
break;
case 23:
//#line 89 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables ");
      		                                    Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval).setUso("Variable");
                                                lista_variables = (ArrayList<String>) val_peek(2).obj;
                                                lista_variables.add(val_peek(0).sval);
                                                yyval = new ParserVal(lista_variables);
                                                }
break;
case 25:
//#line 98 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 99 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 100 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 103 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");
								        {yyval.arbol = val_peek(1).arbol;}
								        if(!ambito.equals("main")){
                                        	ambito = ambito.substring(0,ambito.lastIndexOf("."));
                                        }
                            }
break;
case 30:
//#line 112 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 113 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 114 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 33:
//#line 117 "gramatica.y"
{
                    lista_parametros = (ArrayList<String>)val_peek(2).obj;
                    String nuevoLexema = val_peek(3).sval + "." + ambito;
                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaDeSimbolos.modificarSimbolo(val_peek(3).sval, nuevoLexema);
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                        atributos.setUso("nombreFuncion");
                        atributos.setTipo(val_peek(0).sval);
                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema, atributos);
                        if(!lista_parametros.isEmpty()){
                            int posicion = 1;
                            for(String parametro : lista_parametros){
                                Main.tablaDeSimbolos.getAtributosTablaS(parametro).setOrden(posicion);
                                posicion++;
                            }
                        }
                        Main.informesSemanticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una funcion declarada con nombre "+val_peek(3).sval+ " en el ámbito "+ambito+", con tipo de retorno " + Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getTipo());
                    } else {
                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " la funcion "+ val_peek(3).sval + " ya fue declarada en este ambito");
                        }
                    ambito = ambito + "."+ val_peek(3).sval;
                    }
break;
case 35:
//#line 142 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 143 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 144 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 145 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 146 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
//#line 149 "gramatica.y"
{lista_parametros.clear();
                              yyval = new ParserVal(lista_parametros);}
break;
case 41:
//#line 151 "gramatica.y"
{lista_parametros.clear();
                                     			     lista_parametros.add(val_peek(1).sval);
                                     			     yyval = new ParserVal(lista_parametros);}
break;
case 42:
//#line 154 "gramatica.y"
{lista_parametros.clear();
                                                      if(!val_peek(3).sval.equals(val_peek(1).sval)){
                                                        lista_parametros.add(val_peek(3).sval);
                                                        lista_parametros.add(val_peek(1).sval);
                                                        yyval = new ParserVal(lista_parametros);
                                                      } else
                                                            Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " no puede haber dos parametros con el mismo ID");
                                                      }
break;
case 44:
//#line 165 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 166 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 167 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
//#line 170 "gramatica.y"
{String nuevoAmbitoId = val_peek(0).sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo(val_peek(0).sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo(val_peek(1).sval);
                    atributos.setUso("nombreParametro");
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    yyval = new ParserVal(nuevoAmbitoId);}
break;
case 49:
//#line 180 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 181 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 184 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("i32");}
break;
case 52:
//#line 186 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("f32");}
break;
case 53:
//#line 190 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 191 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if(val_peek(1).arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    yyval.arbol = new NodoInvocacion(val_peek(1).arbol,null,lexDiscard);
	                                }
	                                }
break;
case 55:
//#line 197 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 56:
//#line 198 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 199 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 58:
//#line 200 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 60:
//#line 204 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 61:
//#line 205 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 62:
//#line 206 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 63:
//#line 207 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 64:
//#line 208 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 65:
//#line 209 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
//#line 210 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
//#line 211 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 68:
//#line 214 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 69:
//#line 215 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(val_peek(1).arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               yyval.arbol = new NodoInvocacion(val_peek(1).arbol,null,lexDiscard);
                                           }
                                           }
break;
case 70:
//#line 221 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 71:
//#line 222 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 72:
//#line 223 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 73:
//#line 224 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 74:
//#line 227 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 75:
//#line 230 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);

                                        if(ambitoCheck != null){
                                        Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                        AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                        yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+val_peek(1).sval+"' en algun ambito alcanzable");
                             }
break;
case 77:
//#line 243 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 78:
//#line 244 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 79:
//#line 245 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 80:
//#line 246 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 81:
//#line 247 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 82:
//#line 250 "gramatica.y"
{
                             String nuevoLexema = val_peek(1).sval + "." + ambito;
                             if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                                 Main.tablaDeSimbolos.modificarSimbolo(val_peek(1).sval, nuevoLexema);
                                 AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                                 atributosT.setUso("nombreEtiqueta");
                                 Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                                 yyval = new ParserVal(nuevoLexema);
                             } else {
                                 Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea+ " la etiqueta " + val_peek(1).sval + " ya fue declarada en este ambito");
                                 Main.tablaDeSimbolos.eliminarSimbolo(val_peek(1).sval);
                                 }
                     }
break;
case 83:
//#line 269 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                                if(ambitoCheck != null){
                                                    if (val_peek(0).arbol!=null){
                                                        Main.tablaDeSimbolos.eliminarSimbolo(val_peek(2).sval);
                                                        AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                        Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                        AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                        NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                                    if (nodoA.getTipo()!=null){
                                                        yyval.arbol= nodoA;
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                                    }
                                                }
                                                }else
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(2).sval);
                                                }
break;
case 84:
//#line 288 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                   AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                   Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito).setUso("Variable");
                                   AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                   yyval.arbol= new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                   }
break;
case 86:
//#line 297 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 87:
//#line 298 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 88:
//#line 299 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 89:
//#line 300 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 90:
//#line 301 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 91:
//#line 304 "gramatica.y"
{ AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                        yyval.arbol = new NodoRetorno(val_peek(0).arbol,null,retorno);
                                      }
break;
case 93:
//#line 310 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 94:
//#line 313 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 95:
//#line 314 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                                 }
break;
case 96:
//#line 319 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                                                    }
break;
case 98:
//#line 326 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 99:
//#line 327 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 100:
//#line 330 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol,atributos);
                             }
break;
case 101:
//#line 334 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          }
break;
case 102:
//#line 338 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 104:
//#line 342 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 105:
//#line 343 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 106:
//#line 344 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 107:
//#line 345 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 108:
//#line 348 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
              if(ambitoCheck != null){
                  AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                  Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                  String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                  atributos.setTipo(tipoId);
                  yyval.arbol = new NodoHoja(atributos);
              }
              else{
                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(0).sval);
                    yyval.arbol = null;
                    }
              }
break;
case 109:
//#line 361 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        yyval.arbol = new NodoHoja(atributos);
                       }
break;
case 110:
//#line 364 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setTipo("i32");
                        yyval.arbol = new NodoHoja(atributos);
                        }
                   }
break;
case 111:
//#line 370 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 112:
//#line 374 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       yyval.arbol = new NodoHoja(atributos);
                       }
                      }
break;
case 113:
//#line 379 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               yyval.arbol = new NodoHoja(atributos);
                               }
                           }
break;
case 114:
//#line 386 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                            if(ambitoCheck != null){
                                                if (val_peek(1).arbol !=null){
                                                    if(lista_parametros.size() == lista_parametros_reales.size()){
                                                        int pos = 0;
                                                        int nroDeNoCoincidencias = 0;
                                                        for(String paramR : lista_parametros_reales){
                                                            String tipoParamR = Main.tablaDeSimbolos.getAtributosTablaS(paramR).getTipo();
                                                            String parametro = lista_parametros.get(pos);
                                                            String tipoParam = Main.tablaDeSimbolos.getAtributosTablaS(parametro).getTipo();
                                                            if(!tipoParamR.equals(tipoParam))
                                                                nroDeNoCoincidencias++;
                                                            }
                                                            pos++;
                                                        if(nroDeNoCoincidencias == 0){
                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);
                                                            Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("idInvocacion");
                                                            AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion");
                                                            AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval+"."+ambito);
                                                            yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),val_peek(1).arbol,lexInvocacion);
                                                        }
                                                        else{
                                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el tipo de los parametros invocados no coinciden con los de la funcion a invocar");
                                                            yyval.arbol = null;
                                                        }
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] se quiere invocar a una funcion con un numero incorrecto de parametros ");
                                                        yyval.arbol = null;
                                                    }
                                                }
                                            }
                                            else
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                                            }
break;
case 115:
//#line 421 "gramatica.y"
{  String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                            if(ambitoCheck != null){
                                if(lista_parametros.size() == lista_parametros_reales.size()){
                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);
                                    Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("idInvocacion");
                                    AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion sin parametros");
                                    AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                    yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),null,lexInvocacion);
                                }
                                else
                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] flatan el/los parametros en la invocacion ");
                            }
                            else
                              Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                         }
break;
case 117:
//#line 439 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 118:
//#line 440 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 119:
//#line 443 "gramatica.y"
{ if(val_peek(0).arbol !=null){
                                            AtributosTablaS lexParam = new AtributosTablaS("Un Parametro");
                                            yyval.arbol = new NodoParam(val_peek(0).arbol,null,lexParam);
                                        }
                                        else
                                            yyval.arbol = null;
                                        }
break;
case 120:
//#line 450 "gramatica.y"
{ if(val_peek(2).arbol !=null && val_peek(0).arbol!=null){
                                                                    AtributosTablaS lexParam = new AtributosTablaS("Dos Parametros");
                                                                    lista_parametros_reales.clear();
                                                                    lista_parametros_reales.add(val_peek(2).sval);
                                                                    lista_parametros_reales.add(val_peek(0).sval);
                                                                    yyval.arbol = new NodoParam(val_peek(2).arbol,val_peek(0).arbol,lexParam);
                                                               }else
                                                                    yyval.arbol = null;
                                                               }
break;
case 122:
//#line 462 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 123:
//#line 463 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 124:
//#line 464 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 125:
//#line 467 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
                      if(ambitoCheck != null){
                          AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                          Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                          lista_parametros_reales.clear();
                          lista_parametros_reales.add(val_peek(0).sval);
                          yyval.arbol = new NodoHoja(atributos);
                          }else{
                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(0).sval);
                            yyval.arbol = null;
                          }
                          }
break;
case 126:
//#line 479 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                    lista_parametros_reales.clear();
                                    lista_parametros_reales.add(val_peek(0).sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                    yyval.arbol = new NodoHoja(atributos);
                                   }
break;
case 127:
//#line 485 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                                   lista_parametros_reales.clear();
                                   lista_parametros_reales.add(val_peek(0).sval);
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                   yyval.arbol = new NodoHoja(atributos);
                               }
                               }
break;
case 128:
//#line 493 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                  }
break;
case 129:
//#line 498 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                       }
break;
case 130:
//#line 504 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);}
break;
case 132:
//#line 510 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 133:
//#line 511 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 134:
//#line 512 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 135:
//#line 513 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 136:
//#line 514 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 137:
//#line 517 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    }
break;
case 138:
//#line 520 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                }
break;
case 140:
//#line 526 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 141:
//#line 527 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 142:
//#line 528 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 143:
//#line 532 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);}
break;
case 144:
//#line 534 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          yyval.arbol = new NodoCuerpoThen(val_peek(1).arbol,null,atributos);}
break;
case 146:
//#line 539 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             yyval.arbol = new NodoCuerpoElse(val_peek(0).arbol,null,atributos);}
break;
case 147:
//#line 541 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                yyval.arbol = new NodoCuerpoElse(val_peek(1).arbol,null,atributos);}
break;
case 149:
//#line 546 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 150:
//#line 547 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 151:
//#line 550 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 152:
//#line 551 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 153:
//#line 552 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 154:
//#line 555 "gramatica.y"
{ yyval.arbol = val_peek(0).arbol;}
break;
case 155:
//#line 556 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 157:
//#line 560 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 158:
//#line 561 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 159:
//#line 565 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 161:
//#line 571 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 162:
//#line 572 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 163:
//#line 573 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 164:
//#line 576 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 165:
//#line 577 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 166:
//#line 578 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 167:
//#line 579 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 168:
//#line 580 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 169:
//#line 581 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 170:
//#line 584 "gramatica.y"
{if((val_peek(6).arbol != null)&&(val_peek(4).arbol != null)&&(val_peek(2).arbol != null)){
                                                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                            AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                            AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                            AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                            ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor(val_peek(0).arbol,null,lexCuerpoFor);
                                                                                            String IdAIncrementar = val_peek(6).arbol.getHijoIzq().getLexema();
                                                                                            val_peek(4).arbol.getHijoIzq().setId(IdAIncrementar);
                                                                                            val_peek(2).arbol.setId(IdAIncrementar);
                                                                                            ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor(val_peek(6).arbol,val_peek(4).arbol,lexEncabezadoFor),val_peek(2).arbol,lexEncabezadoFor);
                                                                                            yyval.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                          }
                                                                                          else
                                                                                              yyval.arbol = null;
                                                                                        }
break;
case 171:
//#line 599 "gramatica.y"
{if((val_peek(6).arbol != null)&&(val_peek(4).arbol != null)&&(val_peek(2).arbol != null)){
                                                                                  Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                  AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                  AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                  AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                  ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor(val_peek(0).arbol,null,lexCuerpoFor);
                                                                                  String IdAIncrementar = val_peek(6).arbol.getHijoIzq().getLexema();
                                                                                  val_peek(6).arbol.setId(val_peek(9).sval);
                                                                                  val_peek(4).arbol.getHijoIzq().setId(IdAIncrementar);
                                                                                  val_peek(2).arbol.setId(IdAIncrementar);
                                                                                  ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor(val_peek(6).arbol,val_peek(4).arbol,lexEncabezadoFor),val_peek(2).arbol,lexEncabezadoFor);
                                                                                  yyval.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                }
                                                                                else
                                                                                    yyval.arbol = null;
                                                                              }
break;
case 172:
//#line 615 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 173:
//#line 618 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 174:
//#line 621 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 175:
//#line 624 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 176:
//#line 627 "gramatica.y"
{ yyval.arbol = null;}
break;
case 177:
//#line 630 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 178:
//#line 631 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 179:
//#line 632 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 180:
//#line 633 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
break;
case 181:
//#line 634 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
break;
case 182:
//#line 637 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                        if(ambitoCheck != null){
                                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                            if(tipoId.equals("i32")){
                                                if (chequearRangoEnteros()==true){
                                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                                    Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                    AtributosTablaS atributos2 = new AtributosTablaS("Asignacion FOR");
                                                    AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                                    NodoAsignacionFor nodoA = new NodoAsignacionFor(new NodoHoja(atributos),new NodoHoja(atributos3),atributos2);
                                                    if (nodoA.getTipo()!=null){
                                                        yyval.arbol= nodoA;
                                                    }else{
                                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " asignacion con tipo incompatibles ");
                                                        yyval.arbol= null;
                                                    }
                                                }
                                                else{
                                                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero a asignar esta fuera de rango");
                                                    yyval.arbol= null;
                                                }
                                            }
                                            else{
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el tipo declarado para el id es incorrecto");
                                                yyval.arbol= null;
                                            }
                                        }
                                        else{
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(2).sval);
                                            yyval.arbol= null;
                                        }
                                        }
break;
case 184:
//#line 672 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 185:
//#line 673 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 186:
//#line 674 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 187:
//#line 677 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                                   if(ambitoCheck != null){
                                                       Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                       AtributosTablaS atributos = new AtributosTablaS("CondicionFOR");
                                                       AtributosTablaS atributos2 = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                       AtributosTablaS atributos3 = new AtributosTablaS(val_peek(1).sval);
                                                       yyval.arbol = new NodoCondicionFor(new NodoComparacionFor(new NodoHoja(atributos2),val_peek(0).arbol,atributos3),null,atributos);
                                                   }
                                                   else{
                                                       Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no existe el id "+ val_peek(2).sval +" en ningun ambito alcanzable. Imposible determinar rango de control");
                                                       yyval.arbol = null;
                                                   }
                                                   }
break;
case 189:
//#line 693 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 190:
//#line 694 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 191:
//#line 695 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 192:
//#line 698 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 194:
//#line 706 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 195:
//#line 707 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 196:
//#line 708 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 2009 "Parser.java"
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
