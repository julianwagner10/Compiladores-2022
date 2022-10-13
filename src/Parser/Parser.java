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
    9,    9,    6,    6,    6,    6,    6,    6,    6,    6,
   27,   27,   27,   27,   27,   27,   27,   27,   27,   27,
   27,    8,    8,    8,    8,   28,   28,   28,   28,   28,
   21,   21,   21,   30,   30,   30,   30,   30,   24,   24,
   31,   29,   29,   29,   29,   33,   33,   32,   32,   32,
   32,   35,   35,   35,   35,   34,   34,   34,   34,   34,
   22,   22,   22,   37,   37,   36,   36,   36,   39,   38,
   38,   38,   38,   23,   23,   23,   42,   42,   42,   42,
   42,   42,   42,   41,   41,   41,   41,   43,   43,   40,
   44,   44,   44,   44,   44,   44,   25,   25,   25,   47,
   47,   47,   45,   45,   48,   48,   48,   46,   46,   49,
   49,   49,   26,   26,   50,   50,   50,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    1,    2,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    4,    2,    2,    1,
    2,    2,    2,    3,    3,    3,    2,    2,    2,    3,
    2,    2,    2,    4,    1,    2,    2,    3,    3,    4,
    3,    3,    1,    3,    3,    3,    2,    2,    2,    1,
    1,    1,    3,    3,    1,    3,    3,    3,    3,    1,
    1,    3,    3,    2,    2,    1,    1,    1,    1,    2,
    4,    3,    1,    4,    3,    1,    3,    1,    2,    1,
    1,    1,    2,    7,    9,    1,    6,    6,    6,    6,
    6,    6,    7,    1,    1,    3,    1,    2,    2,    3,
    1,    1,    1,    1,    1,    1,   10,   10,    1,    9,
    9,    9,    3,    1,    2,    2,    2,    3,    1,    2,
    2,    2,    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   83,   90,  113,  126,  149,  164,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   43,   48,    0,    0,  108,
  107,    0,    0,    0,  109,   88,    0,    0,   95,  100,
  101,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   69,    0,    0,   26,    0,    0,    3,    7,
   22,   21,    0,   25,   20,    0,    0,    0,   61,   53,
   71,   62,   55,   68,   56,   63,   58,   67,   59,    4,
    1,    0,   85,    0,   86,   82,    0,   65,    0,    0,
  120,  122,  121,    0,    0,    0,    0,    0,  118,   47,
    0,   44,   66,    0,  110,  104,  105,    0,    0,    0,
    0,    0,    0,  145,  144,  146,  141,  142,  143,    0,
    0,  165,    0,  166,   50,    0,    0,   40,    0,   70,
   54,    0,    0,    0,  154,   64,    0,   19,   16,   27,
   23,   32,    0,   30,   57,  123,    0,   41,  114,  111,
    0,  119,   35,  115,  112,   96,    0,   97,    0,  102,
   98,  103,   99,    0,    0,    0,    0,    0,  163,   37,
    0,   38,   36,  156,    0,  155,    0,    0,   31,   28,
    0,  117,    0,    0,    0,    0,    0,    0,    0,   75,
    0,  137,    0,    0,    0,    0,   39,   33,  153,    0,
    0,    0,  159,    0,    0,   42,    0,   76,   72,   77,
    0,   73,    0,   12,    0,   13,  138,   14,   15,  129,
  130,  132,    0,  131,  128,    0,    0,    0,    0,  127,
    0,   78,    0,   79,  136,  133,    0,  124,    0,    0,
    0,    0,   46,   80,   74,    0,    0,    0,    0,    0,
    0,  125,  150,    0,  152,    0,  151,  147,  148,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,   24,  217,  218,  219,   26,   27,
   28,   29,   30,   31,   32,   54,   33,   55,   56,   57,
   34,   35,   36,   37,   38,   39,   40,  220,   73,   41,
   42,   68,   69,   70,   71,  127,   43,  128,  129,   74,
  221,   44,  222,  150,  164,  232,   45,  165,  233,   46,
};
final static short yysindex[] = {                      -100,
  -92,   54,    0,    0,   54,   54,    0,  -20,  116,   33,
  -28,   32,  425,  -51,   29,    0,    0, -199, -177,  425,
   69,    0,    0,    0,    0,   95,  112,    0,    0,    0,
  -31,    0,    0,  -52,   45,  -45,  -29,    3,   37,    0,
    0,    0,    0,    0,    0,    0,   84,  107,  160,  154,
   42,  144, -151,   59,   78,    0,    0,   64,   86,    0,
    0,  428,  428,  428,    0,    0,   48,   53,    0,    0,
    0,  415,   60,   93,  103,  -12, -117,   -1,  -15,  102,
   48,   86,    0,   79, -208,    0,  111,  133,    0,    0,
    0,    0,  285,    0,    0, -120,    8,  122,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   86,    0,   48,    0,    0,   48,    0,  118, -117,
    0,    0,    0,    0,  433,  -19,   10,  108,    0,    0,
 -104,    0,    0,  306,    0,    0,    0,  395,  419,  268,
  402,  -83,  -17,    0,    0,    0,    0,    0,    0,  425,
  -78,    0,  150,    0,    0, -104,  129,    0, -104,    0,
    0, -175,  -63,  141,    0,    0,  -56,    0,    0,    0,
    0,    0,   30,    0,    0,    0, -191,    0,    0,    0,
  433,    0,    0,    0,    0,    0,   53,    0,   53,    0,
    0,    0,    0,  274,  274,  179,   48,  274,    0,    0,
 -131,    0,    0,    0,  -55,    0,  438,  274,    0,    0,
   27,    0,   41,  100,  -42,  349,    0,  310,    0,    0,
  -50,    0,   28,  240,   49,   94,    0,    0,    0,  570,
  425,  153,    0,  136, -191,    0,  116,    0,    0,    0,
  208,    0,  -49,    0,  330,    0,    0,    0,    0,    0,
    0,    0,  -89,    0,    0,   48,  425,   48,    2,    0,
  172,    0,  138,    0,    0,    0,  274,    0,   48,  344,
  -38,    5,    0,    0,    0,  148,  274,  383,  274,  398,
  274,    0,    0,  274,    0,  274,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  125,    0,    0,
    0,    0,  300,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  446,    0,    0,
    0,    0,   -8,    0,    0,    0,    0,    0,  475,    0,
    0,    0,    0,    0,    0,    0,  379,  509,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  399,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  448,    0,  400,    0,    0,  406,    0,    0,  390,
    0,    0,    0,  117,    0,  132,    0,   18,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  412,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  548,    0,  584,    0,
    0,    0,    0,    0,    0,    0,  -13,    0,    0,    0,
    0,    0,    0,    0,  404,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  158,    0,  212,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  382,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  416,  423,  435,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  437,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   71,    0,  530,    0,    0,   13,  258, -181,  480,  476,
    0,    0,    0,    0,    0,    9,    0,  590,    0,    0,
    0,   -9,    0,    0,   99,    0,    0,    0,   -7,    0,
    0,   43,    0,   52,    0,    0,    0,  -46,    0,   12,
  510,    0,    0, -140,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=850;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         65,
   65,   67,  279,   65,   84,   81,  100,   83,   20,  264,
   65,   76,   18,  103,   25,  243,  242,   25,   25,   52,
   80,  178,    2,  196,  177,  158,   19,  140,  154,  105,
    6,   88,   49,   25,  246,   49,  249,   51,   79,   65,
   65,  114,  117,   25,  271,  281,  272,   20,  162,   49,
  180,   18,   65,   65,   65,  163,  156,   86,  116,   25,
   25,  107,   65,  249,   77,   19,  231,  236,   85,   20,
  235,   79,   72,   18,   63,   47,   48,   62,  176,   64,
  134,  182,  204,  143,   16,   17,  157,   19,  205,  257,
  138,   97,  139,   20,  140,  109,   15,   18,   51,  141,
  118,   98,  138,  101,  139,  130,   58,   66,   20,   25,
   25,   19,   18,  135,  136,  137,  131,   87,  132,  147,
  149,  148,  133,   20,  227,  134,   19,   18,   65,   65,
   65,   65,  172,  151,  212,  170,  171,  161,   18,  155,
   65,   19,  197,  152,   16,   17,   20,  113,  116,  119,
   18,  181,  125,   92,  210,   96,    1,   63,  239,  159,
   62,   20,   64,    5,   19,   18,  266,  173,   22,  166,
   95,   16,   17,  167,   40,  112,  175,  267,  268,   19,
  187,  189,  194,   22,  124,   25,  201,  198,  125,   45,
  199,  191,  193,   89,  206,   63,  275,   12,   62,  207,
   64,   63,  229,   99,   62,   82,   64,  263,  110,  208,
  102,  259,  273,  240,  241,   12,  134,  250,   20,  278,
   65,   65,  256,  258,    7,    8,  104,   65,  244,  114,
  248,  111,    9,   10,   75,   49,   19,   11,   12,   13,
   77,   14,   15,   50,   16,   17,  174,   65,  195,  269,
  153,   13,  140,   15,   77,   16,   17,  248,  106,  270,
   16,   17,  280,    7,    8,  179,  262,   49,   49,   13,
  135,    9,   10,  116,   16,   17,   11,   12,   13,   20,
   14,   15,   12,   16,   17,  209,    8,   77,   78,   59,
   60,   61,  108,    9,   10,  251,  237,   19,   11,   12,
   13,  216,   14,   15,   50,   16,   17,   16,   17,    7,
    8,   58,   62,   20,   15,   15,  254,    9,   10,  144,
  145,  146,   11,   12,   13,    8,   14,   15,   96,   16,
   17,   19,    9,   10,  160,  113,   13,   11,   12,   13,
    8,   14,   15,  169,   16,   17,  185,    9,   10,   20,
  125,   91,   11,   12,   13,  238,   14,   15,   91,   16,
   17,  255,  216,    8,  121,  122,  123,   19,   94,   20,
    9,   10,   59,   60,   61,   11,   12,   13,    8,   14,
   15,   22,   16,   17,  277,    9,   10,   19,   20,   15,
   11,   12,   13,  274,   14,   15,  216,   16,   17,  120,
  121,  122,  123,  260,   16,   17,   19,   45,   45,  115,
   59,   60,   61,  134,   12,  282,  112,   60,   61,   16,
   17,   12,   12,  284,  134,  134,   12,   15,   12,   12,
   12,   12,   12,   15,  247,  213,   63,   87,  286,   62,
  139,   64,    9,   10,  224,    5,   62,   11,  115,   13,
  214,   14,   15,  215,  265,  142,   63,   89,   84,   62,
   63,   64,  157,   62,   81,   64,   63,  135,   13,   62,
  167,   64,   62,  245,  161,   13,   13,  125,  135,  135,
   13,  162,   13,   13,   13,   13,   13,   53,   50,  106,
  106,   53,  106,  160,  106,  158,  213,  147,  149,  148,
    0,   93,    0,    9,   10,    0,  106,  252,   11,    0,
   13,  214,   14,   15,  215,  106,  106,  106,    0,  106,
    0,  106,    0,  190,   59,   60,   61,    0,    0,    0,
  213,   53,    0,  106,  106,  106,  106,    9,   10,    0,
  168,   94,   11,    0,   13,  214,   14,   15,  215,   92,
   90,   92,    0,   92,    0,   91,    0,   53,   53,    0,
    0,  184,  121,  122,  123,    0,  213,   92,   92,   92,
   92,    0,    0,    9,   10,    0,   90,   90,   11,    0,
   13,  214,   14,   15,  215,    0,  213,    0,   93,    0,
   93,    0,   93,    9,   10,    0,    0,    0,   11,    0,
   13,  214,   14,   15,  215,  213,   93,   93,   93,   93,
  183,   63,    9,   10,   62,    0,   64,   11,    0,   13,
  214,   14,   15,  215,   94,    0,   94,   90,   94,  147,
  149,  148,    0,    0,   87,  200,  202,  139,  203,    0,
    0,  126,   94,   94,   94,   94,    0,    0,  139,  139,
  186,   59,   60,   61,   89,   84,   53,  192,   59,   60,
   61,   81,    0,    0,    0,    0,    0,  167,  126,    0,
    0,   59,   60,   61,  188,   59,   60,   61,    0,    0,
  228,   59,   60,   61,   59,   60,   61,    0,    0,  121,
  122,  123,    0,    0,  230,    0,    0,  144,  145,  146,
    0,    0,   90,  106,  223,  225,    0,  226,    0,    0,
    0,    0,    0,    0,   53,    0,    0,  234,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  106,    0,    0,  253,  106,  106,  106,    0,    0,    0,
  106,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   92,    0,  211,    0,   92,   92,
   92,    0,    0,    0,   92,    0,  276,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  283,    0,  285,    0,
  287,    0,    0,  288,    0,  289,    0,    0,    0,    0,
    0,    0,    0,   93,    0,    0,    0,   93,   93,   93,
    0,    0,    0,   93,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  261,    0,   59,   60,   61,  144,
  145,  146,    0,    0,    0,    0,    0,    0,    0,   94,
    0,    0,    0,   94,   94,   94,    0,    0,    0,   94,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   10,    9,   41,   13,   14,   13,   59,   59,   40,   59,
   20,   40,   44,   59,    2,   58,   59,    5,    6,   40,
   12,   41,  123,   41,   44,   41,   58,   41,   41,   59,
  123,   20,   41,   21,  216,   44,  218,   58,   40,   49,
   50,   49,   50,   31,   43,   41,   45,   40,  257,   58,
   41,   44,   62,   63,   64,  264,   58,  257,   41,   47,
   48,   59,   72,  245,  256,   58,  207,   41,   40,   40,
   44,   40,   40,   44,   42,    5,    6,   45,  125,   47,
   40,  128,  258,   72,  276,  277,   78,   58,  264,  230,
   43,  123,   45,   40,   42,   59,  274,   44,   58,   47,
   59,   31,   43,   59,   45,  257,    8,    9,   40,   97,
   98,   58,   44,   62,   63,   64,   58,   19,   41,   60,
   61,   62,   59,   40,  256,   40,   58,   44,  138,  139,
  140,  141,  125,   41,  181,  256,  257,   59,   44,  257,
  150,   58,  150,   41,  276,  277,   40,   49,   50,   51,
   44,   44,   45,   59,  125,   44,  257,   42,   59,   58,
   45,   40,   47,  256,   58,   44,  256,   97,   44,   59,
   59,  276,  277,   41,   58,   59,   59,  267,  268,   58,
  138,  139,  266,   59,   41,  173,   58,  266,   45,   58,
   41,  140,  141,  125,  258,   42,   59,   40,   45,   59,
   47,   42,  258,  256,   45,  257,   47,  257,  125,  266,
  256,   59,   41,  256,  257,   58,   59,  268,   40,  258,
  230,  231,  230,  231,  256,  257,  256,  237,  216,  237,
  218,  125,  264,  265,  263,  256,   58,  269,  270,  271,
  256,  273,  274,  264,  276,  277,  125,  257,  266,  257,
  263,   40,  266,  274,  256,  276,  277,  245,  256,  258,
  276,  277,  258,  256,  257,  256,   59,  276,  277,   58,
   59,  264,  265,  256,  276,  277,  269,  270,  271,   40,
  273,  274,  125,  276,  277,  256,  257,  256,  257,  257,
  258,  259,  256,  264,  265,  268,  256,   58,  269,  270,
  271,  123,  273,  274,  264,  276,  277,  276,  277,  256,
  257,  213,   45,   40,  274,  274,  268,  264,  265,  260,
  261,  262,  269,  270,  271,  257,  273,  274,   44,  276,
  277,   58,  264,  265,  256,  237,  125,  269,  270,  271,
  257,  273,  274,   59,  276,  277,   41,  264,  265,   40,
   45,  257,  269,  270,  271,  256,  273,  274,   59,  276,
  277,  268,  123,  257,  257,  258,  259,   58,  257,   40,
  264,  265,  257,  258,  259,  269,  270,  271,  257,  273,
  274,  257,  276,  277,   41,  264,  265,   58,   40,  274,
  269,  270,  271,  256,  273,  274,  123,  276,  277,  256,
  257,  258,  259,  268,  276,  277,   58,  276,  277,  256,
  257,  258,  259,  256,  257,  268,  257,  258,  259,  276,
  277,  264,  265,   41,  267,  268,  269,  274,  271,  272,
  273,  274,  275,  274,  125,  257,   42,   59,   41,   45,
   59,   47,  264,  265,  266,    0,   45,  269,   59,  271,
  272,  273,  274,  275,  125,   41,   42,   59,   59,   45,
   42,   47,   59,   45,   59,   47,   42,  256,  257,   45,
   59,   47,   45,  216,   59,  264,  265,   45,  267,  268,
  269,   59,  271,  272,  273,  274,  275,    8,   41,   42,
   43,   12,   45,   59,   47,   59,  257,   60,   61,   62,
   -1,   26,   -1,  264,  265,   -1,   59,  268,  269,   -1,
  271,  272,  273,  274,  275,   41,   42,   43,   -1,   45,
   -1,   47,   -1,  256,  257,  258,  259,   -1,   -1,   -1,
  257,   52,   -1,   59,   60,   61,   62,  264,  265,   -1,
  256,  257,  269,   -1,  271,  272,  273,  274,  275,   41,
   21,   43,   -1,   45,   -1,  256,   -1,   78,   79,   -1,
   -1,  256,  257,  258,  259,   -1,  257,   59,   60,   61,
   62,   -1,   -1,  264,  265,   -1,   47,   48,  269,   -1,
  271,  272,  273,  274,  275,   -1,  257,   -1,   41,   -1,
   43,   -1,   45,  264,  265,   -1,   -1,   -1,  269,   -1,
  271,  272,  273,  274,  275,  257,   59,   60,   61,   62,
  131,   42,  264,  265,   45,   -1,   47,  269,   -1,  271,
  272,  273,  274,  275,   41,   -1,   43,   98,   45,   60,
   61,   62,   -1,   -1,  256,  156,  157,  256,  159,   -1,
   -1,   52,   59,   60,   61,   62,   -1,   -1,  267,  268,
  256,  257,  258,  259,  256,  256,  177,  256,  257,  258,
  259,  256,   -1,   -1,   -1,   -1,   -1,  256,   79,   -1,
   -1,  257,  258,  259,  256,  257,  258,  259,   -1,   -1,
  201,  257,  258,  259,  257,  258,  259,   -1,   -1,  257,
  258,  259,   -1,   -1,  257,   -1,   -1,  260,  261,  262,
   -1,   -1,  173,  256,  195,  196,   -1,  198,   -1,   -1,
   -1,   -1,   -1,   -1,  235,   -1,   -1,  208,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  256,   -1,   -1,  224,  260,  261,  262,   -1,   -1,   -1,
  266,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  256,   -1,  177,   -1,  260,  261,
  262,   -1,   -1,   -1,  266,   -1,  267,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  277,   -1,  279,   -1,
  281,   -1,   -1,  284,   -1,  286,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  235,   -1,  257,  258,  259,  260,
  261,  262,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,
   -1,   -1,   -1,  260,  261,  262,   -1,   -1,   -1,  266,
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

//#line 281 "gramatica.y"

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

//#line 683 "Parser.java"
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
//#line 39 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 44 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 45 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 46 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 49 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 23:
//#line 50 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + val_peek(0).sval);}
break;
case 25:
//#line 54 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 55 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 56 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 59 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
//#line 63 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 64 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 65 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 35:
//#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 73 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 74 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 75 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 76 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 44:
//#line 85 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 86 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 87 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
//#line 94 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 95 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 98 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
//#line 99 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 57:
//#line 106 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);}
break;
case 61:
//#line 112 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
//#line 113 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
//#line 114 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
//#line 115 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
//#line 116 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
//#line 117 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
//#line 118 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
//#line 119 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
//#line 120 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
//#line 121 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
//#line 122 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
//#line 125 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 73:
//#line 126 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 74:
//#line 127 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +val_peek(1).sval);}
break;
case 76:
//#line 131 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 77:
//#line 132 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 78:
//#line 133 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 79:
//#line 134 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 80:
//#line 135 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 82:
//#line 139 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");}
break;
case 84:
//#line 143 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 85:
//#line 144 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 86:
//#line 145 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 87:
//#line 146 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 88:
//#line 147 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 91:
//#line 154 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 93:
//#line 158 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 94:
//#line 159 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 96:
//#line 163 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 97:
//#line 164 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 98:
//#line 167 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 99:
//#line 168 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 102:
//#line 173 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 103:
//#line 174 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 104:
//#line 175 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 105:
//#line 176 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 106:
//#line 179 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 107:
//#line 180 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 108:
//#line 181 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 109:
//#line 182 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 110:
//#line 183 "gramatica.y"
{chequearNegativos();}
break;
case 111:
//#line 186 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 112:
//#line 187 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);}
break;
case 114:
//#line 191 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 115:
//#line 192 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 119:
//#line 200 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 120:
//#line 203 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 121:
//#line 204 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 122:
//#line 205 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 123:
//#line 206 "gramatica.y"
{chequearNegativos();}
break;
case 124:
//#line 209 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");}
break;
case 125:
//#line 210 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF con ELSE");}
break;
case 127:
//#line 214 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 128:
//#line 215 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 129:
//#line 216 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 130:
//#line 217 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 131:
//#line 218 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada THEN de la sentencia IF ");}
break;
case 132:
//#line 219 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 133:
//#line 220 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 138:
//#line 229 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 139:
//#line 230 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 147:
//#line 244 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 148:
//#line 245 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 150:
//#line 249 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 151:
//#line 250 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 152:
//#line 251 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 155:
//#line 258 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 156:
//#line 259 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 157:
//#line 260 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 160:
//#line 267 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 161:
//#line 268 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 162:
//#line 269 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 163:
//#line 272 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 165:
//#line 276 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 166:
//#line 277 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 167:
//#line 278 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1260 "Parser.java"
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
