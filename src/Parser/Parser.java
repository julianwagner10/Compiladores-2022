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
    3,    7,    7,    9,    9,    5,    5,    5,   13,   13,
   13,   11,   11,   11,   14,   14,   14,   12,   12,   16,
   16,   16,   15,   15,   18,   18,   18,   18,   18,   17,
   17,   17,   17,   20,   20,   20,   19,   19,   21,   21,
   10,   10,    6,    6,    6,    6,    6,    6,    6,    6,
   28,   28,   28,   28,   28,   28,   28,   28,   28,   28,
   28,    8,    8,    8,    8,    8,    8,    8,    8,    8,
    8,   29,   29,   29,   29,   29,   22,   22,   22,   31,
   31,   31,   31,   31,   25,   25,   32,   30,   30,   30,
   30,   34,   34,   33,   33,   33,   33,   36,   36,   36,
   36,   35,   35,   35,   35,   35,   35,   23,   23,   23,
   38,   38,   37,   37,   37,   40,   39,   39,   39,   39,
   39,   24,   24,   24,   43,   43,   43,   43,   43,   43,
   43,   44,   44,   44,   42,   42,   42,   45,   45,   46,
   46,   41,   41,   48,   48,   48,   47,   47,   47,   47,
   47,   47,   26,   26,   26,   51,   51,   51,   51,   49,
   49,   52,   52,   52,   50,   50,   53,   53,   53,   27,
   27,   54,   54,   54,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    4,    2,    2,    1,
    2,    2,    2,    3,    3,    3,    2,    2,    2,    3,
    2,    2,    3,    2,    4,    2,    2,    2,    2,    4,
    1,    2,    2,    3,    3,    4,    3,    3,    1,    3,
    3,    3,    2,    2,    2,    1,    1,    1,    3,    3,
    1,    3,    3,    3,    3,    1,    1,    3,    3,    2,
    2,    1,    1,    1,    1,    2,    2,    4,    3,    1,
    4,    3,    1,    3,    1,    2,    1,    1,    1,    2,
    2,    7,    9,    1,    6,    6,    6,    6,    6,    6,
    7,    1,    3,    1,    1,    3,    1,    2,    2,    2,
    2,    3,    1,    2,    2,    2,    1,    1,    1,    1,
    1,    1,   10,   10,    1,    9,    9,    9,    4,    3,
    1,    2,    2,    2,    3,    1,    2,    2,    2,    4,
    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   89,   96,  120,  134,  165,  181,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   43,   48,    0,    0,  114,
  113,    0,    0,    0,  115,   94,    0,    0,  101,  106,
  107,  161,  160,  162,    0,  157,  158,  159,    0,    0,
    0,  153,    0,    0,    0,    0,    0,    0,    0,    0,
   69,    0,    0,   26,    0,    0,    3,    7,   22,   21,
    0,   25,   20,    0,    0,    0,   61,   53,   71,   62,
   55,   68,   56,   63,   58,   67,   59,    4,    1,    0,
   91,    0,   92,   88,    0,   65,    0,    0,  127,  129,
  128,    0,    0,    0,    0,    0,  125,   47,    0,   44,
   66,    0,  116,  117,  110,  111,    0,    0,    0,    0,
    0,    0,  156,    0,    0,    0,  182,    0,  183,   50,
    0,    0,   40,    0,   70,   54,    0,    0,    0,    0,
  171,   64,    0,   19,   16,   27,   23,   32,    0,   30,
   57,  130,  131,    0,   41,  121,  118,    0,  126,   35,
  122,  119,  102,    0,  103,    0,  108,  104,  109,  105,
    0,    0,    0,    0,    0,  180,   37,    0,   38,   36,
  173,    0,  172,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   81,  169,  144,    0,    0,   31,
   28,    0,  124,    0,    0,    0,    0,    0,  147,    0,
    0,    0,    0,   39,   33,  170,    0,    0,   82,   78,
    0,   83,    0,   79,    0,    0,   12,  148,   13,   72,
   74,   76,   77,    0,    0,    0,  176,    0,    0,   42,
   14,    0,  150,   15,  137,  138,  140,    0,  139,  136,
    0,   73,   84,    0,   85,  143,    0,    0,    0,    0,
  135,    0,  146,  141,    0,  132,   75,   86,   80,    0,
    0,    0,    0,   46,    0,    0,    0,    0,    0,    0,
  133,  166,    0,  168,    0,  167,  163,  164,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,   24,   25,  219,  220,  237,   26,
   27,   28,   29,   30,   31,   32,   54,   33,   55,   56,
   57,   34,   35,   36,   37,   38,   39,   40,  225,   79,
   41,   42,   68,   69,   70,   71,  135,   43,  136,  137,
   80,  238,   44,  226,  227,  239,   81,   82,  170,  266,
   45,  171,  267,   46,
};
final static short yysindex[] = {                       -95,
  -89,   61,    0,    0,   61,   61,    0,  148,   62,  584,
   34,   14,  548,  -22,   13,    0,    0, -226, -238,  536,
   76,    0,    0,    0,    0,   82,  119,    0,    0,    0,
  -20,    0,    0,  -41,    8,  -36,   58,   98,  107,    0,
    0,    0,    0,    0,    0,    0,   91,  116,  381,  330,
  -40,  139, -202,   56,   57,    0,    0,   47,   68,    0,
    0, -131,  399,  399,    0,    0,   33,   40,    0,    0,
    0,    0,    0,    0,  668,    0,    0,    0,  557,   95,
  548,    0,   99,  -38, -115,  -18,   16,   89,   33,   68,
    0,  110,   10,    0,   96,  138,    0,    0,    0,    0,
  163,    0,    0, -118,   12,  137,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   68,
    0,   33,    0,    0,   33,    0,  124, -115,    0,    0,
    0,    0, -100,   48,   -9,  235,    0,    0, -101,    0,
    0,  442,    0,    0,    0,    0,  492,  522,  314,  464,
  -81,  -39,    0,  548,  -77,   33,    0,  156,    0,    0,
 -101,   52,    0, -101,    0,    0, -214,  -59,  188,  150,
    0,    0,  -48,    0,    0,    0,    0,    0,   39,    0,
    0,    0,    0, -192,    0,    0,    0,  406,    0,    0,
    0,    0,    0,   40,    0,   40,    0,    0,    0,    0,
  363,  363,  311,   33,  363,    0,    0, -154,    0,    0,
    0,   -3,    0,  -43,  123,  117,  -33,  254,  202,    0,
  312,  368,  370,  373,    0,    0,    0,  656,  363,    0,
    0,   71,    0,  114,  410,    0,  378,  167,    0,  186,
  342,  190,  196,    0,    0,    0,   62, -238,    0,    0,
  383,    0,  411,    0,   65,  233,    0,    0,    0,    0,
    0,    0,    0,  536,  548,  413,    0,  201, -192,    0,
    0,  397,    0,    0,    0,    0,    0, -138,    0,    0,
  414,    0,    0,  127,    0,    0,   33,  548,   33,   43,
    0,  440,    0,    0,  363,    0,    0,    0,    0,   33,
  444,  -28,  -27,    0,  220,  188,  448,  188,  450,  188,
    0,    0,  188,    0,  188,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  160,    0,    0,
    0,    0,  128,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  495,    0,    0,
    0,    0,  -11,    0,    0,    0,    0,    0,  635,    0,
    0,    0,    0,    0,    0,    0,  135,  471,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  143,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  437,
    0,  149,    0,    0,  264,    0,    0,  441,    0,    0,
    0,  133,    0,   67,    0,   50,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -37,    0,  -34,    0,  298,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  501,    0,  644,    0,    0,    0,    0,
    0,    0,    0,  -14,    0,    0,    0,    0,    0,    0,
    0,  445,    0,    0,    0,    0,    0,    0,    0,  174,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  284,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  374,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -135,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  451,  454,  456,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  458,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   63,    0,  693,    0,    0,  652,  281, -156,  266,    9,
  498,    0,    0,    0,    0,    0,   27,    0,    6,    0,
    0,  517,   -4,  556,    0,   -8,  570,    0,    0,   -1,
    0,    0,  293,    0,    2,    0,    0,    0, -107,    0,
   15, -130,    0, -110,    0,    0,  377,    0,    0,    0,
    0,    0,    0,    0,
};
final static int YYTABLESIZE=947;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   66,  203,  159,  155,   65,   65,  154,   67,   65,   92,
   95,   89,  308,  310,  248,   65,   53,  108,  126,   20,
   53,   87,  111,   18,  255,  254,  152,    2,  189,   49,
   94,  187,   49,    6,   96,   15,   91,   19,   88,  161,
  121,  124,  127,  211,   65,   65,   49,  122,  125,  212,
  169,   20,   93,   87,  138,   18,  163,  134,   65,   65,
   53,  257,  259,   85,  145,  146,  109,   47,   48,   19,
   65,  240,  242,   84,  243,  147,   65,  148,   20,  156,
  233,  149,   18,   16,   17,  302,  150,  303,  185,  152,
  123,  184,  134,  106,   53,   53,   19,  140,  268,  259,
   20,  244,  105,   63,   18,  141,   62,  142,   64,  208,
  278,  270,  162,  139,  269,   20,  113,  294,   19,   18,
  151,   16,   17,  285,   45,   18,  143,  144,  295,  296,
   20,  151,  151,   19,   18,  155,  178,  176,  177,  157,
  100,  160,   65,   65,   65,   65,  164,  190,   19,   65,
  198,  200,  204,  142,  172,   20,  115,  182,  183,   18,
  223,    1,  104,  231,  305,  117,    5,  179,  166,  207,
  209,   51,  210,   19,   16,   17,   20,  103,  173,  132,
   18,  250,  181,  133,  201,  299,   97,   52,  205,  232,
   40,  119,   53,   93,   19,  312,  206,  314,  213,  316,
   97,   95,  317,   22,  318,   51,  104,   90,  228,  223,
  223,  251,  247,   12,  107,  118,  245,  229,   22,  110,
   50,  175,  252,  253,  158,   58,  202,   20,  155,  307,
  309,  154,  142,   15,   90,    7,    8,   85,  121,  281,
  119,   20,   65,    9,   10,  122,  186,  223,   11,   12,
   13,  152,   14,   15,  246,   16,   17,   16,   17,   65,
   65,  180,  287,  289,   49,   49,  167,    7,    8,   85,
   86,   85,   20,  168,  292,    9,   10,   53,  188,  133,
   11,   12,   13,   65,   14,   15,  300,   16,   17,   16,
   17,   16,   17,   20,  230,    8,   83,  223,   12,  223,
  301,  223,    9,   10,  223,  123,  223,   11,   12,   13,
  218,   14,   15,  112,   16,   17,    7,    8,   59,   60,
   61,  284,   87,   14,    9,   10,  258,   16,   17,   11,
   12,   13,    8,   14,   15,   15,   16,   17,   99,    9,
   10,   14,   45,   45,   11,   12,   13,    8,   14,   15,
   20,   16,   17,  114,    9,   10,  184,  286,   62,   11,
   12,   13,  116,   14,   15,  165,   16,   17,   19,  247,
  260,   63,    8,   90,   62,  102,   64,   50,  249,    9,
   10,   20,  298,   97,   11,   12,   13,   15,   14,   15,
   93,   16,   17,    8,  128,  129,  130,  131,   95,   19,
    9,   10,   20,   49,   90,   11,   12,   13,   14,   14,
   15,   50,   16,   17,   16,   17,   22,   20,  174,  102,
   19,   15,   63,   16,   17,   62,  261,   64,  262,  142,
   12,  263,  149,  235,  275,   19,   20,   12,   12,  194,
  196,  282,   12,   62,  214,   12,   12,   12,   12,   20,
  133,    9,   10,  276,   19,  154,   11,  279,  214,  215,
  216,   15,  217,  280,  235,    9,   10,   19,  291,  283,
   11,  290,  297,  215,  216,   15,  217,   50,  112,  112,
  304,  112,  192,  112,  306,  235,  133,  311,  313,  214,
  315,  129,  130,  131,    5,  112,    9,   10,  256,  122,
  272,   11,  273,  174,  215,  216,   15,  217,   62,  178,
  214,   98,  179,   98,  177,   98,  175,    9,   10,   87,
    0,  293,   11,  101,    0,  215,  216,   15,  217,   98,
   98,   98,   98,   63,    0,    0,   62,    0,   64,  145,
   14,   99,    0,   99,    0,   99,    0,   14,   14,    0,
  145,  145,   14,  184,   14,    0,   14,   14,    0,   99,
   99,   99,   99,   63,    0,    0,   62,  234,   64,  197,
   59,   60,   61,    0,    9,   10,  241,   63,    0,   11,
   62,   13,   64,   14,   15,  123,   59,   60,   61,   63,
    0,    0,   62,    0,   64,   76,   78,   77,  234,  147,
    0,  148,    0,   15,  265,    9,   10,    0,    0,  277,
   11,    0,   13,    0,   14,   15,   76,   78,   77,  234,
    0,    0,    0,   75,    0,   63,    9,   10,   62,  149,
   64,   11,    0,   13,  234,   14,   15,  120,   60,   61,
  288,    9,   10,   76,   78,   77,   11,    0,   13,    0,
   14,   15,    0,  234,   15,   59,   60,   61,    0,    0,
    9,   10,  129,  130,  131,   11,  234,   13,    0,   14,
   15,    0,    0,    9,   10,  112,  112,  112,   11,  112,
   13,  112,   14,   15,  100,  221,  100,    0,  100,    0,
    0,    0,  112,  112,  112,  112,  112,  191,  129,  130,
  131,    0,  100,  100,  100,  100,    0,    0,  151,   63,
    0,    0,   62,   98,   64,   76,   78,   77,    0,  199,
   59,   60,   61,    0,  222,    0,   98,   76,   78,   77,
   98,   98,   98,    0,  221,  221,   98,    0,  224,   98,
   98,    0,    0,    0,    0,    0,    0,  193,   59,   60,
   61,    0,    0,    0,    0,    0,   99,    0,    0,    0,
   99,   99,   99,    0,    0,    0,   99,    0,    0,    0,
    0,    0,  221,  222,  222,    0,    0,  195,   59,   60,
   61,    0,    0,    0,    0,    0,    0,  224,  224,    0,
    0,    0,   59,   60,   61,   72,   73,   74,   98,    0,
    0,    0,    0,    0,   59,   60,   61,    0,    0,    0,
    0,  222,  153,    0,    0,    0,   72,   73,   74,    0,
    0,    0,  221,    0,  221,  224,  221,    0,    0,  221,
    0,  221,    0,    0,    0,    0,    0,    0,    0,    0,
   59,   60,   61,   72,   73,   74,    0,    0,    0,    0,
    0,    0,  236,  236,  236,    0,  236,    0,    0,    0,
    0,  222,    0,  222,    0,  222,    0,    0,  222,    0,
  222,   98,    0,    0,    0,  224,    0,  224,    0,  224,
  236,    0,  224,    0,  224,    0,  271,    0,  274,    0,
  112,    0,  236,    0,  112,  112,  112,    0,    0,  100,
  112,    0,    0,  100,  100,  100,    0,    0,    0,  100,
    0,    0,  264,    0,    0,   72,   73,   74,    0,    0,
    0,    0,    0,  274,   59,   60,   61,   72,   73,   74,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  236,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          8,
    9,   41,   41,   41,    9,   10,   41,    9,   13,   14,
   19,   13,   41,   41,   58,   20,    8,   59,   59,   40,
   12,   40,   59,   44,   58,   59,   41,  123,  136,   41,
  257,   41,   44,  123,   20,  274,   59,   58,   12,   58,
   49,   50,   51,  258,   49,   50,   58,   49,   50,  264,
   41,   40,   40,   40,  257,   44,   41,   52,   63,   64,
   52,  218,  219,  256,   63,   64,   59,    5,    6,   58,
   75,  202,  203,   40,  205,   43,   81,   45,   40,   81,
  188,   42,   44,  276,  277,   43,   47,   45,   41,   75,
   41,   44,   87,   31,   86,   87,   58,   41,  229,  256,
   40,  256,  123,   42,   44,   59,   45,   40,   47,   58,
  241,   41,   86,   58,   44,   40,   59,  256,   58,   44,
  256,  276,  277,   59,   58,   44,  258,  259,  267,  268,
   40,  267,  268,   58,   44,   41,  125,  256,  257,   41,
   59,  257,  147,  148,  149,  150,   58,  139,   58,  154,
  149,  150,  154,   40,   59,   40,   59,  258,  259,   44,
  169,  257,   44,  125,  295,   59,  256,  105,   59,  161,
  162,   58,  164,   58,  276,  277,   40,   59,   41,   41,
   44,   59,   59,   45,  266,   59,   59,   40,  266,  184,
   58,   59,  184,   59,   58,  306,   41,  308,  258,  310,
  125,   59,  313,   44,  315,   58,   44,   59,   59,  218,
  219,  216,  256,   40,  256,  125,  208,  266,   59,  256,
  264,   59,  256,  257,  263,  234,  266,   40,  266,  258,
  258,  266,   59,  274,  257,  256,  257,  256,  247,  248,
  125,   40,  247,  264,  265,  247,  256,  256,  269,  270,
  271,  266,  273,  274,  258,  276,  277,  276,  277,  264,
  265,  125,  264,  265,  276,  277,  257,  256,  257,  256,
  257,  256,   40,  264,  269,  264,  265,  269,   44,   45,
  269,  270,  271,  288,  273,  274,  288,  276,  277,  276,
  277,  276,  277,   40,  256,  257,  263,  306,  125,  308,
  258,  310,  264,  265,  313,  256,  315,  269,  270,  271,
  123,  273,  274,  256,  276,  277,  256,  257,  257,  258,
  259,  257,   59,   40,  264,  265,  125,  276,  277,  269,
  270,  271,  257,  273,  274,  274,  276,  277,  257,  264,
  265,   58,  276,  277,  269,  270,  271,  257,  273,  274,
   40,  276,  277,  256,  264,  265,   59,  125,   45,  269,
  270,  271,  256,  273,  274,  256,  276,  277,   58,  256,
   59,   42,  257,  257,   45,  257,   47,  264,  256,  264,
  265,   40,  256,  256,  269,  270,  271,  274,  273,  274,
  256,  276,  277,  257,  256,  257,  258,  259,  256,   58,
  264,  265,   40,  256,  256,  269,  270,  271,  125,  273,
  274,  264,  276,  277,  276,  277,  257,   40,  256,  257,
   58,  274,   42,  276,  277,   45,   59,   47,   59,  256,
  257,   59,   59,  123,  268,   58,   40,  264,  265,  147,
  148,   59,  269,   45,  257,  272,  273,  274,  275,   40,
   45,  264,  265,  268,   58,   79,  269,  268,  257,  272,
  273,  274,  275,  268,  123,  264,  265,   58,  268,   59,
  269,   59,   59,  272,  273,  274,  275,   41,   42,   43,
   41,   45,   41,   47,   41,  123,   45,  268,   41,  257,
   41,  257,  258,  259,    0,   59,  264,  265,  218,   59,
  235,  269,  125,   59,  272,  273,  274,  275,   45,   59,
  257,   41,   59,   43,   59,   45,   59,  264,  265,  256,
   -1,  125,  269,   26,   -1,  272,  273,  274,  275,   59,
   60,   61,   62,   42,   -1,   -1,   45,   -1,   47,  256,
  257,   41,   -1,   43,   -1,   45,   -1,  264,  265,   -1,
  267,  268,  269,  256,  271,   -1,  273,  274,   -1,   59,
   60,   61,   62,   42,   -1,   -1,   45,  257,   47,  256,
  257,  258,  259,   -1,  264,  265,  266,   42,   -1,  269,
   45,  271,   47,  273,  274,  256,  257,  258,  259,   42,
   -1,   -1,   45,   -1,   47,   60,   61,   62,  257,   43,
   -1,   45,   -1,  274,  228,  264,  265,   -1,   -1,  268,
  269,   -1,  271,   -1,  273,  274,   60,   61,   62,  257,
   -1,   -1,   -1,   40,   -1,   42,  264,  265,   45,  256,
   47,  269,   -1,  271,  257,  273,  274,  257,  258,  259,
  264,  264,  265,   60,   61,   62,  269,   -1,  271,   -1,
  273,  274,   -1,  257,  274,  257,  258,  259,   -1,   -1,
  264,  265,  257,  258,  259,  269,  257,  271,   -1,  273,
  274,   -1,   -1,  264,  265,   41,   42,   43,  269,   45,
  271,   47,  273,  274,   41,  169,   43,   -1,   45,   -1,
   -1,   -1,  256,   59,   60,   61,   62,  256,  257,  258,
  259,   -1,   59,   60,   61,   62,   -1,   -1,   41,   42,
   -1,   -1,   45,   21,   47,   60,   61,   62,   -1,  256,
  257,  258,  259,   -1,  169,   -1,  256,   60,   61,   62,
  260,  261,  262,   -1,  218,  219,  266,   -1,  169,   47,
   48,   -1,   -1,   -1,   -1,   -1,   -1,  256,  257,  258,
  259,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,
  260,  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,
   -1,   -1,  256,  218,  219,   -1,   -1,  256,  257,  258,
  259,   -1,   -1,   -1,   -1,   -1,   -1,  218,  219,   -1,
   -1,   -1,  257,  258,  259,  260,  261,  262,  106,   -1,
   -1,   -1,   -1,   -1,  257,  258,  259,   -1,   -1,   -1,
   -1,  256,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
   -1,   -1,  306,   -1,  308,  256,  310,   -1,   -1,  313,
   -1,  315,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,  258,  259,  260,  261,  262,   -1,   -1,   -1,   -1,
   -1,   -1,  201,  202,  203,   -1,  205,   -1,   -1,   -1,
   -1,  306,   -1,  308,   -1,  310,   -1,   -1,  313,   -1,
  315,  179,   -1,   -1,   -1,  306,   -1,  308,   -1,  310,
  229,   -1,  313,   -1,  315,   -1,  235,   -1,  237,   -1,
  256,   -1,  241,   -1,  260,  261,  262,   -1,   -1,  256,
  266,   -1,   -1,  260,  261,  262,   -1,   -1,   -1,  266,
   -1,   -1,  257,   -1,   -1,  260,  261,  262,   -1,   -1,
   -1,   -1,   -1,  272,  257,  258,  259,  260,  261,  262,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  295,
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
"ejecucion : ID ':' control ';'",
"ejecucion : control ';'",
"ejecucion : salida ';'",
"ejecucion : error_ejecucion",
"error_ejecucion : asignacion error",
"error_ejecucion : seleccion error",
"error_ejecucion : control error",
"error_ejecucion : ':' control ';'",
"error_ejecucion : ID ':' ';'",
"error_ejecucion : ID control ';'",
"error_ejecucion : salida error",
"error_ejecucion : retorno error",
"error_ejecucion : DISCARD ';'",
"error_ejecucion : DISCARD invocacion error",
"error_ejecucion : invocacion ';'",
"ejecucion_control : asignacion ';'",
"ejecucion_control : DISCARD invocacion ';'",
"ejecucion_control : seleccion ';'",
"ejecucion_control : ID ':' control ';'",
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
"factor_invocacion : ID",
"factor_invocacion : CTE_FLOTANTE",
"factor_invocacion : CTE_INT",
"factor_invocacion : '-' CTE_INT",
"factor_invocacion : '-' CTE_FLOTANTE",
"seleccion : IF '(' condicion ')' THEN bloque_if ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_if ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"error_seleccion : '(' condicion ')' THEN bloque_if ENDIF",
"error_seleccion : IF condicion ')' THEN bloque_if ENDIF",
"error_seleccion : IF '(' ')' THEN bloque_if ENDIF",
"error_seleccion : IF '(' condicion THEN bloque_if ENDIF",
"error_seleccion : IF '(' condicion ')' bloque_if ENDIF",
"error_seleccion : IF '(' condicion ')' THEN ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_if error",
"bloque_for : ejecucion_control",
"bloque_for : '{' bloque_ejecutable_for '}'",
"bloque_for : error_bloque_for",
"bloque_if : ejecucion",
"bloque_if : '{' bloque_ejecutable_if '}'",
"bloque_if : error_bloque_if",
"error_bloque_for : bloque_ejecutable_for '}'",
"error_bloque_for : '{' bloque_ejecutable_for",
"error_bloque_if : bloque_ejecutable_if '}'",
"error_bloque_if : '{' bloque_ejecutable_if",
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
"control : FOR '(' asignacion_for ';' condicion_for ';' '+' CTE_INT ')' bloque_for",
"control : FOR '(' asignacion_for ';' condicion_for ';' '-' CTE_INT ')' bloque_for",
"control : error_control",
"error_control : FOR '(' asignacion_for ';' condicion_for ';' CTE_INT ')' bloque_for",
"error_control : FOR '(' asignacion_for ';' condicion_for ';' '-' ')' bloque_for",
"error_control : FOR '(' asignacion_for ';' condicion_for ';' '+' ')' bloque_for",
"error_control : FOR '(' ')' bloque_for",
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

//#line 338 "gramatica.y"

private Lexico lexico;


public Parser(Lexico lexico)
{
  this.lexico = lexico;
}

public int yylex(){
   Token token = this.lexico.obtenerToken();

    if(token != null ){
        List<AtributosTablaS> atributos = Main.tablaDeSimbolos.getAtributos(token.getLexema());
        int val = token.getId();
        yylval = new ParserVal(atributos);
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
            System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
            return true;
        }
        else {
            Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante FLOTANTE fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
            return false;
	 	}
	}
}

//#line 756 "Parser.java"
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
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
break;
case 2:
//#line 13 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
//#line 16 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
//#line 17 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 18 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 9:
//#line 26 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
break;
case 16:
//#line 48 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 53 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 54 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 55 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 58 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 23:
//#line 59 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + val_peek(0).sval);}
break;
case 25:
//#line 63 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 64 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 65 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 68 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
//#line 72 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 73 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 74 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 35:
//#line 81 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 82 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 83 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 84 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 85 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 44:
//#line 94 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 95 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 96 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
//#line 103 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 104 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 107 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
//#line 108 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 54:
//#line 112 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 57:
//#line 115 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);}
break;
case 61:
//#line 121 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
//#line 122 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
//#line 123 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
//#line 124 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
//#line 125 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
//#line 126 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
//#line 127 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
//#line 128 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
//#line 129 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
//#line 130 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
//#line 131 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 73:
//#line 135 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 75:
//#line 137 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);}
break;
case 78:
//#line 140 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 79:
//#line 141 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 80:
//#line 142 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +val_peek(1).sval);}
break;
case 82:
//#line 146 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 83:
//#line 147 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
//#line 148 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
//#line 149 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
//#line 150 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 88:
//#line 154 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");}
break;
case 90:
//#line 158 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 91:
//#line 159 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
//#line 160 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 93:
//#line 161 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 94:
//#line 162 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 97:
//#line 169 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 98:
//#line 172 "gramatica.y"
{yyval.arbol = val_peek(0).arbol}
break;
case 99:
//#line 173 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                          yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol);
	                                                    }
break;
case 100:
//#line 176 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	            yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol);
	                                                    }
break;
case 102:
//#line 182 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 103:
//#line 183 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 104:
//#line 186 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol);
                             }
break;
case 105:
//#line 189 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol);
	                          }
break;
case 106:
//#line 192 "gramatica.y"
{yyval.arbol = val_peek(0).arbol}
break;
case 108:
//#line 196 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 109:
//#line 197 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 110:
//#line 198 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 111:
//#line 199 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 112:
//#line 202 "gramatica.y"
{yyval.arbol = new NodoHoja(null,null,val_peek(0));}
break;
case 113:
//#line 203 "gramatica.y"
{yyval.arbol = new NodoHoja(null,null,val_peek(0));}
break;
case 114:
//#line 204 "gramatica.y"
{if chequearRangoEnteros()
                   yyval.arbol = new NodoHoja(null,null,val_peek(0));
                   }
break;
case 115:
//#line 207 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      yyval.arbol = new NodoHoja(null,null,val_peek(0));
                      }
break;
case 116:
//#line 210 "gramatica.y"
{if chequearNegativos()
                       yyval.arbol = new NodoHoja(null,null,val_peek(0));
                      }
break;
case 117:
//#line 213 "gramatica.y"
{if chequearNegativos()
                               yyval.arbol = new NodoHoja(null,null,val_peek(0));
                           }
break;
case 118:
//#line 218 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 119:
//#line 219 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);}
break;
case 121:
//#line 223 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 122:
//#line 224 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 126:
//#line 232 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 127:
//#line 235 "gramatica.y"
{yyval.arbol = new NodoHoja(null,null,val_peek(0));}
break;
case 128:
//#line 236 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                   yyval.arbol = new NodoHoja(null,null,val_peek(0));
                                   }
break;
case 129:
//#line 239 "gramatica.y"
{if chequearRangoEnteros() {
                               Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                               yyval.arbol = new NodoHoja(null,null,val_peek(0));
                               }
                               }
break;
case 130:
//#line 244 "gramatica.y"
{if chequearNegativos()
                                            yyval.arbol = new NodoHoja(null,null,val_peek(0));
                                  }
break;
case 131:
//#line 247 "gramatica.y"
{if chequearNegativos()
                                            yyval.arbol = new NodoHoja(null,null,val_peek(0));
                                       }
break;
case 132:
//#line 251 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");}
break;
case 133:
//#line 252 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF con ELSE");}
break;
case 135:
//#line 256 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 136:
//#line 257 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 137:
//#line 258 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 138:
//#line 259 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 139:
//#line 260 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada THEN de la sentencia IF ");}
break;
case 140:
//#line 261 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 141:
//#line 262 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 148:
//#line 274 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 149:
//#line 275 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 150:
//#line 278 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 151:
//#line 279 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 154:
//#line 287 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 155:
//#line 288 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 156:
//#line 289 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 163:
//#line 300 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 164:
//#line 301 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 165:
//#line 302 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 166:
//#line 305 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 167:
//#line 306 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 168:
//#line 307 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 169:
//#line 308 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 170:
//#line 311 "gramatica.y"
{chequearRangoEnteros();}
break;
case 172:
//#line 315 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 173:
//#line 316 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 174:
//#line 317 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 177:
//#line 324 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 178:
//#line 325 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 179:
//#line 326 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 180:
//#line 329 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 182:
//#line 333 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 183:
//#line 334 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 184:
//#line 335 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1423 "Parser.java"
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
