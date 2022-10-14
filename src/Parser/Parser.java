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
   40,   45,   45,   45,   44,   44,   44,   44,   44,   44,
   25,   25,   25,   48,   48,   48,   46,   46,   49,   49,
   49,   47,   47,   50,   50,   50,   26,   26,   51,   51,
   51,
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
    1,    2,    2,    2,    1,    1,    1,    1,    1,    1,
   10,   10,    1,    9,    9,    9,    3,    1,    2,    2,
    2,    3,    1,    2,    2,    2,    4,    1,    3,    3,
    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   83,   90,  113,  126,  153,  168,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   43,   48,    0,    0,  108,
  107,    0,    0,    0,  109,   88,    0,    0,   95,  100,
  101,  149,  148,  150,    0,  145,  146,  147,    0,    0,
    0,  141,    0,    0,    0,    0,    0,    0,    0,    0,
   69,    0,    0,   26,    0,    0,    3,    7,   22,   21,
    0,   25,   20,    0,    0,    0,   61,   53,   71,   62,
   55,   68,   56,   63,   58,   67,   59,    4,    1,    0,
   85,    0,   86,   82,    0,   65,    0,    0,  120,  122,
  121,    0,    0,    0,    0,    0,  118,   47,    0,   44,
   66,    0,  110,  104,  105,    0,    0,    0,    0,    0,
    0,  144,    0,    0,    0,  169,    0,  170,   50,    0,
    0,   40,    0,   70,   54,    0,    0,    0,  158,   64,
    0,   19,   16,   27,   23,   32,    0,   30,   57,  123,
    0,   41,  114,  111,    0,  119,   35,  115,  112,   96,
    0,   97,    0,  102,   98,  103,   99,    0,    0,    0,
    0,    0,  167,   37,    0,   38,   36,  160,    0,  159,
    0,    0,   31,   28,    0,  117,    0,    0,    0,    0,
    0,    0,    0,   75,    0,  137,    0,    0,    0,    0,
   39,   33,  157,    0,    0,    0,  163,    0,    0,   42,
    0,   76,   72,   77,    0,   73,    0,   12,    0,   13,
  138,   14,   15,  129,  130,  132,    0,  131,  128,    0,
    0,    0,    0,  127,    0,   78,    0,   79,  136,  133,
    0,  124,    0,    0,    0,    0,   46,   80,   74,    0,
    0,    0,    0,    0,    0,  125,  154,    0,  156,    0,
  155,  151,  152,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,   24,  221,  222,  223,   26,   27,
   28,   29,   30,   31,   32,   54,   33,   55,   56,   57,
   34,   35,   36,   37,   38,   39,   40,  224,   79,   41,
   42,   68,   69,   70,   71,  135,   43,  136,  137,   80,
  225,   44,  226,   81,   82,  168,  236,   45,  169,  237,
   46,
};
final static short yysindex[] = {                       -96,
 -100,   51,    0,    0,   51,   51,    0,   -8,   60,  492,
  -32,  -37,  439,  -50,  -16,    0,    0, -224, -237,  628,
   66,    0,    0,    0,    0,   57,   76,    0,    0,    0,
  -27,    0,    0,  -45,   -1,  -38,  113,  142,  349,    0,
    0,    0,    0,    0,    0,    0,   87,  111,  161,  153,
   30,   89, -195,   42,   63,    0,    0,   33,   75,    0,
    0,  455,  455,  455,    0,    0,   25,   70,    0,    0,
    0,    0,    0,    0,  586,    0,    0,    0,  117,   88,
  439,    0,  100,    4, -114,   19,   -3,   95,   25,   75,
    0,  356, -193,    0,   91,  118,    0,    0,    0,    0,
  357,    0,    0, -135,    7,  126,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   75,
    0,   25,    0,    0,   25,    0,  112, -114,    0,    0,
    0,    0,  461,   44,   85,  148,    0,    0, -109,    0,
    0,  426,    0,    0,    0,  -35,  435,  443,  447,  -93,
  -21,    0,  439,  -91,   25,    0,  135,    0,    0, -109,
   36,    0, -109,    0,    0, -212,  -78,  124,    0,    0,
  -77,    0,    0,    0,    0,    0,   29,    0,    0,    0,
 -228,    0,    0,    0,  461,    0,    0,    0,    0,    0,
   70,    0,   70,    0,    0,    0,    0,  271,  271,  230,
   25,  271,    0,    0, -128,    0,    0,    0,  -64,    0,
  469,  271,    0,    0,   92,    0,   23,  381,  334,  346,
    0,  292,    0,    0,  -72,    0,  -69,  251,  -66,  -59,
    0,    0,    0,  628,  439,  151,    0,  -55, -228,    0,
   60,    0,    0,    0,  158,    0,  -43,    0,  314,    0,
    0,    0,    0,    0,    0,    0,  -82,    0,    0,   25,
  439,   25,   80,    0,  249,    0,  383,    0,    0,    0,
  271,    0,   25,  308,   34,   52,    0,    0,    0,   99,
  271,  318,  271,  348,  271,    0,    0,  271,    0,  271,
    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,   98,    0,    0,
    0,    0,  387,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  423,    0,    0,
    0,    0,  -19,    0,    0,    0,    0,    0,  402,    0,
    0,    0,    0,    0,    0,    0,  400,  393,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  401,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  593,
    0,  420,    0,    0,  424,    0,    0,  378,    0,    0,
    0,  129,    0,   94,    0,  106,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -11,    0,   -5,    0,  430,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  539,    0,  563,    0,    0,    0,    0,    0,    0,    0,
   35,    0,    0,    0,    0,    0,    0,    0,  382,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  157,    0,  201,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  374,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  389,
  391,  392,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  397,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
   77,    0,  630,    0,    0,   13,  258, -136,  506,  459,
    0,    0,    0,    0,    0,   17,    0,  529,    0,    0,
    0,   -9,    0,    0,   48,    0,    0,    0,   -7,    0,
    0,   58,    0,   16,    0,    0,    0,  -22,    0,   15,
  570,    0,    0,  -53,    0,    0,    0,    0,    0,    0,
    0,
};
final static int YYTABLESIZE=890;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         65,
   65,   67,   87,   65,   92,   89,   63,   84,   91,   62,
   65,   64,   20,  108,   25,  268,   18,   25,   25,  200,
  111,   49,    6,   93,   49,  153,    2,   85,   88,  143,
   19,   52,   94,   25,   96,  142,   15,  162,   49,   65,
   65,  122,  125,   25,  158,  208,   20,   16,   17,   51,
   18,  209,   65,   65,   65,   58,   66,  109,   87,   25,
   25,  138,  142,  166,   19,   65,   95,  146,   20,  147,
  167,   65,   18,  155,  283,  140,  160,  143,  144,  145,
   51,   47,   48,  250,  182,  253,   19,  181,  126,  151,
   20,  141,  285,  205,   18,  105,  121,  124,  127,  139,
   18,   63,  161,  140,   62,   20,   64,  106,   19,   18,
  180,  148,  253,  186,  142,  100,  149,   25,   25,  104,
  174,  175,  275,   19,  276,  184,   20,  231,  154,  132,
   18,  176,  240,  133,  103,  239,   65,   65,   65,   65,
  156,   22,  159,   65,   19,  201,  116,   16,   17,  170,
   20,   45,  163,  214,   18,    5,   22,  235,  171,  146,
    1,  147,  216,  195,  197,   20,   16,   17,   19,   18,
  179,  113,  198,  270,  202,  203,   76,   78,   77,  210,
  261,  177,  211,   19,  271,  272,   40,  112,  212,   25,
   97,  185,  133,  233,   63,  254,   12,   62,  255,   64,
  115,  258,   63,  191,  193,   62,   90,   64,  259,  263,
  107,  118,  264,  267,   12,  134,  266,  110,   85,   86,
  190,   59,   60,   61,   65,   65,  260,  262,    7,    8,
   83,   65,  248,  122,  252,  119,    9,   10,   16,   17,
   13,   11,   12,   13,  199,   14,   15,   49,   16,   17,
  178,   65,   85,  273,  143,   50,   49,   49,   13,  135,
  142,  252,    7,    8,   58,   15,  157,   16,   17,   20,
    9,   10,   16,   17,   85,   11,   12,   13,  241,   14,
   15,   12,   16,   17,  213,    8,   50,   19,  121,  277,
   20,  282,    9,   10,   16,   17,   15,   11,   12,   13,
  140,   14,   15,   15,   16,   17,    7,    8,   19,  284,
   20,   16,   17,   99,    9,   10,   59,   60,   61,   11,
   12,   13,    8,   14,   15,   13,   16,   17,   19,    9,
   10,   20,  102,   15,   11,   12,   13,  274,   14,   15,
  183,   16,   17,    8,  128,  129,  130,  131,  281,   19,
    9,   10,  220,   20,   22,   11,   12,   13,  288,   14,
   15,  116,   16,   17,   16,   17,  286,    8,  112,   45,
   45,   19,  152,  220,    9,   10,   72,   73,   74,   11,
   12,   13,    8,   14,   15,   20,   16,   17,  290,    9,
   10,  247,  246,  220,   11,   12,   13,  114,   14,   15,
  104,   16,   17,   19,  129,  130,  131,  117,  123,   59,
   60,   61,  134,   12,  165,  173,  251,  120,   60,   61,
   12,   12,    5,  134,  134,   12,   15,   12,   12,   12,
   12,   12,  139,   92,   15,   92,  115,   92,  269,  243,
  161,  279,  106,  106,  106,   91,  106,  165,  106,  166,
  164,   92,   92,   92,   92,  162,  135,   13,   87,   89,
  106,  106,  106,  106,   13,   13,  189,  135,  135,   13,
  133,   13,   13,   13,   13,   13,   63,  249,   84,   62,
   63,   64,   81,   62,  101,   64,  217,   62,  171,    0,
    0,   62,    0,    9,   10,  228,    0,    0,   11,   62,
   13,  218,   14,   15,  219,  133,    0,  217,    0,    0,
    0,    0,    0,   53,    9,   10,    0,   53,  256,   11,
    0,   13,  218,   14,   15,  219,    0,  217,   76,   78,
   77,   75,    0,   63,    9,   10,   62,    0,   64,   11,
    0,   13,  218,   14,   15,  219,    0,    0,  217,    0,
    0,   76,   78,   77,    0,    9,   10,   53,    0,    0,
   11,    0,   13,  218,   14,   15,  219,    0,    0,    0,
  217,    0,    0,    0,    0,    0,    0,    9,   10,   93,
  134,   93,   11,   93,   13,  218,   14,   15,  219,  244,
  245,   53,   53,    0,    0,    0,    0,   93,   93,   93,
   93,    0,  217,   94,  116,   94,    0,   94,    0,    9,
   10,  164,  172,  102,   11,  134,   13,  218,   14,   15,
  219,   94,   94,   94,   94,    0,  150,   63,    0,  139,
   62,    0,   64,   50,  106,  106,  242,  106,  278,  106,
  139,  139,   91,    0,  187,   76,   78,   77,   92,    0,
   98,  106,   92,   92,   92,   87,   89,  106,   92,    0,
    0,  106,  106,  106,    0,  204,  206,  106,  207,   63,
    0,    0,   62,    0,   64,   84,   98,   98,    0,   81,
    0,  188,  129,  130,  131,  171,   53,   76,   78,   77,
  192,   59,   60,   61,    0,   59,   60,   61,  194,   59,
   60,   61,  196,   59,   60,   61,    0,    0,    0,  215,
  232,   59,   60,   61,    0,    0,    0,  129,  130,  131,
    0,    0,    0,    0,    0,  234,    0,    0,   72,   73,
   74,    0,    0,    0,    0,   98,    0,    0,    0,    0,
    0,    0,    0,    0,   53,    0,    0,    0,   59,   60,
   61,   72,   73,   74,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  265,  227,  229,
    0,  230,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  238,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   93,    0,    0,  257,   93,   93,
   93,    0,    0,    0,   93,    0,   98,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   94,    0,
    0,    0,   94,   94,   94,    0,    0,    0,   94,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  280,    0,   59,   60,   61,   72,   73,   74,  106,    0,
  287,    0,  289,    0,  291,    0,    0,  292,    0,  293,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   59,   60,   61,   72,   73,   74,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   10,    9,   40,   13,   14,   13,   42,   40,   59,   45,
   20,   47,   40,   59,    2,   59,   44,    5,    6,   41,
   59,   41,  123,   40,   44,   79,  123,  256,   12,   41,
   58,   40,  257,   21,   20,   41,  274,   41,   58,   49,
   50,   49,   50,   31,   41,  258,   40,  276,  277,   58,
   44,  264,   62,   63,   64,    8,    9,   59,   40,   47,
   48,  257,   40,  257,   58,   75,   19,   43,   40,   45,
  264,   81,   44,   81,   41,   41,   58,   62,   63,   64,
   58,    5,    6,  220,   41,  222,   58,   44,   59,   75,
   40,   59,   41,   58,   44,  123,   49,   50,   51,   58,
   44,   42,   86,   41,   45,   40,   47,   31,   58,   44,
  133,   42,  249,  136,   40,   59,   47,  105,  106,   44,
  256,  257,   43,   58,   45,   41,   40,  256,   41,   41,
   44,  125,   41,   45,   59,   44,  146,  147,  148,  149,
   41,   44,  257,  153,   58,  153,   41,  276,  277,   59,
   40,   58,   58,  125,   44,  256,   59,  211,   41,   43,
  257,   45,  185,  148,  149,   40,  276,  277,   58,   44,
   59,   59,  266,  256,  266,   41,   60,   61,   62,  258,
  234,  105,   59,   58,  267,  268,   58,   59,  266,  177,
  125,   44,   45,  258,   42,  268,   40,   45,  268,   47,
   59,  268,   42,  146,  147,   45,  257,   47,  268,   59,
  256,  125,  268,  257,   58,   59,   59,  256,  256,  257,
  256,  257,  258,  259,  234,  235,  234,  235,  256,  257,
  263,  241,  220,  241,  222,  125,  264,  265,  276,  277,
   40,  269,  270,  271,  266,  273,  274,  256,  276,  277,
  125,  261,  256,  261,  266,  264,  276,  277,   58,   59,
  266,  249,  256,  257,  217,  274,  263,  276,  277,   40,
  264,  265,  276,  277,  256,  269,  270,  271,  256,  273,
  274,  125,  276,  277,  256,  257,  264,   58,  241,   41,
   40,  258,  264,  265,  276,  277,  274,  269,  270,  271,
  266,  273,  274,  274,  276,  277,  256,  257,   58,  258,
   40,  276,  277,  257,  264,  265,  257,  258,  259,  269,
  270,  271,  257,  273,  274,  125,  276,  277,   58,  264,
  265,   40,  257,  274,  269,  270,  271,  258,  273,  274,
  256,  276,  277,  257,  256,  257,  258,  259,   41,   58,
  264,  265,  123,   40,  257,  269,  270,  271,   41,  273,
  274,  256,  276,  277,  276,  277,  268,  257,  256,  276,
  277,   58,  256,  123,  264,  265,  260,  261,  262,  269,
  270,  271,  257,  273,  274,   40,  276,  277,   41,  264,
  265,   58,   59,  123,  269,  270,  271,  256,  273,  274,
   44,  276,  277,   58,  257,  258,  259,   59,  256,  257,
  258,  259,  256,  257,   59,   59,  125,  257,  258,  259,
  264,  265,    0,  267,  268,  269,  274,  271,  272,  273,
  274,  275,   59,   41,  274,   43,   59,   45,  125,   59,
   59,   59,   41,   42,   43,   59,   45,   59,   47,   59,
   59,   59,   60,   61,   62,   59,  256,  257,   59,   59,
   59,   60,   61,   62,  264,  265,   41,  267,  268,  269,
   45,  271,  272,  273,  274,  275,   42,  220,   59,   45,
   42,   47,   59,   45,   26,   47,  257,   45,   59,   -1,
   -1,   45,   -1,  264,  265,  266,   -1,   -1,  269,   45,
  271,  272,  273,  274,  275,   45,   -1,  257,   -1,   -1,
   -1,   -1,   -1,    8,  264,  265,   -1,   12,  268,  269,
   -1,  271,  272,  273,  274,  275,   -1,  257,   60,   61,
   62,   40,   -1,   42,  264,  265,   45,   -1,   47,  269,
   -1,  271,  272,  273,  274,  275,   -1,   -1,  257,   -1,
   -1,   60,   61,   62,   -1,  264,  265,   52,   -1,   -1,
  269,   -1,  271,  272,  273,  274,  275,   -1,   -1,   -1,
  257,   -1,   -1,   -1,   -1,   -1,   -1,  264,  265,   41,
   52,   43,  269,   45,  271,  272,  273,  274,  275,  256,
  257,   86,   87,   -1,   -1,   -1,   -1,   59,   60,   61,
   62,   -1,  257,   41,  256,   43,   -1,   45,   -1,  264,
  265,  256,  256,  257,  269,   87,  271,  272,  273,  274,
  275,   59,   60,   61,   62,   -1,   41,   42,   -1,  256,
   45,   -1,   47,   41,   42,   43,  256,   45,  256,   47,
  267,  268,  256,   -1,  139,   60,   61,   62,  256,   -1,
   21,   59,  260,  261,  262,  256,  256,  256,  266,   -1,
   -1,  260,  261,  262,   -1,  160,  161,  266,  163,   42,
   -1,   -1,   45,   -1,   47,  256,   47,   48,   -1,  256,
   -1,  256,  257,  258,  259,  256,  181,   60,   61,   62,
  256,  257,  258,  259,   -1,  257,  258,  259,  256,  257,
  258,  259,  256,  257,  258,  259,   -1,   -1,   -1,  181,
  205,  257,  258,  259,   -1,   -1,   -1,  257,  258,  259,
   -1,   -1,   -1,   -1,   -1,  257,   -1,   -1,  260,  261,
  262,   -1,   -1,   -1,   -1,  106,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  239,   -1,   -1,   -1,  257,  258,
  259,  260,  261,  262,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  239,  199,  200,
   -1,  202,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  212,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  256,   -1,   -1,  228,  260,  261,
  262,   -1,   -1,   -1,  266,   -1,  177,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,
   -1,   -1,  260,  261,  262,   -1,   -1,   -1,  266,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  271,   -1,  257,  258,  259,  260,  261,  262,  256,   -1,
  281,   -1,  283,   -1,  285,   -1,   -1,  288,   -1,  290,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,
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

//#line 287 "gramatica.y"

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
    //System.out.println("Parser: " + s);
}

public void chequearNegativos(){
	String lexema = yylval.sval;
	int id = Main.tablaDeSimbolos.getIdentificador(lexema);
	if(id == Lexico.CTE_INT){
		Integer enteroNeg = -1*Integer.parseInt(lexema);
		if((enteroNeg >= (-Math.pow(2,31))) && (enteroNeg <= (Math.pow(2,31) - 1))){
		    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante ENTERA LARGA son signo negativo -> "+enteroNeg);
		    Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(enteroNeg));
		}
		else{
		    Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
		}
	}
	else if (id == Lexico.CTE_FLOTANTE) {
		Float flotanteNeg = -1*Float.parseFloat(lexema.replace('F','e'));
        if ((flotanteNeg > 1.17549435e-38 && flotanteNeg < 3.40282347e+38) || (flotanteNeg > -3.40282347e+38 && flotanteNeg < -1.17549435e-38) || (flotanteNeg == 0.0)){
            Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(flotanteNeg));
            System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
        }
        else {
            Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante FLOTANTE fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}

//#line 705 "Parser.java"
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
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia declarativa o ejecutable valida");}
break;
case 16:
//#line 39 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 44 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 45 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 46 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 49 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 23:
//#line 50 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + val_peek(0).sval);}
break;
case 25:
//#line 54 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 55 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 56 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 59 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
//#line 63 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 64 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 65 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 35:
//#line 72 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 73 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 74 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 75 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 76 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 44:
//#line 85 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 86 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 87 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
//#line 94 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 95 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 98 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
//#line 99 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 54:
//#line 103 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 57:
//#line 106 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);}
break;
case 61:
//#line 112 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
//#line 113 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
//#line 114 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
//#line 115 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
//#line 116 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
//#line 117 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
//#line 118 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
//#line 119 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
//#line 120 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
//#line 121 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
//#line 122 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
//#line 125 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 73:
//#line 126 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 74:
//#line 127 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +val_peek(1).sval);}
break;
case 76:
//#line 131 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 77:
//#line 132 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 78:
//#line 133 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 79:
//#line 134 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 80:
//#line 135 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 82:
//#line 139 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");}
break;
case 84:
//#line 143 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 85:
//#line 144 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 86:
//#line 145 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 87:
//#line 146 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 88:
//#line 147 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 91:
//#line 154 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 93:
//#line 158 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 94:
//#line 159 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 96:
//#line 163 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 97:
//#line 164 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 98:
//#line 167 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 99:
//#line 168 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 102:
//#line 173 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 103:
//#line 174 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 104:
//#line 175 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 105:
//#line 176 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 109:
//#line 182 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 110:
//#line 183 "gramatica.y"
{chequearNegativos();}
break;
case 111:
//#line 186 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 112:
//#line 187 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);}
break;
case 114:
//#line 191 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 115:
//#line 192 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 119:
//#line 200 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 121:
//#line 204 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 122:
//#line 205 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 123:
//#line 206 "gramatica.y"
{chequearNegativos();}
break;
case 124:
//#line 209 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");}
break;
case 125:
//#line 210 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF con ELSE");}
break;
case 127:
//#line 214 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 128:
//#line 215 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 129:
//#line 216 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 130:
//#line 217 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 131:
//#line 218 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada THEN de la sentencia IF ");}
break;
case 132:
//#line 219 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 133:
//#line 220 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 138:
//#line 229 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 139:
//#line 230 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 142:
//#line 237 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 143:
//#line 238 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 144:
//#line 239 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 151:
//#line 250 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 152:
//#line 251 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 154:
//#line 255 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 155:
//#line 256 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 156:
//#line 257 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 159:
//#line 264 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 160:
//#line 265 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 161:
//#line 266 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 164:
//#line 273 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 165:
//#line 274 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 166:
//#line 275 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 167:
//#line 278 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 169:
//#line 282 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 170:
//#line 283 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 171:
//#line 284 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1282 "Parser.java"
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
