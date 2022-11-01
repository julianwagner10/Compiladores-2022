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
   10,   10,    6,    6,    6,    6,    6,    6,    6,    6,
   28,   28,   28,   28,   28,   28,   28,   28,   28,   28,
   28,    8,    8,    8,    8,    8,    8,    8,    8,    8,
    8,   29,   29,   29,   29,   29,   22,   22,   22,   31,
   31,   31,   31,   31,   25,   25,   32,   30,   30,   30,
   30,   34,   34,   33,   33,   33,   33,   36,   36,   36,
   36,   35,   35,   35,   35,   35,   35,   23,   23,   23,
   38,   38,   37,   37,   37,   40,   39,   39,   39,   39,
   39,   24,   24,   43,   43,   43,   43,   43,   42,   42,
   42,   46,   46,   46,   44,   44,   44,   45,   45,   45,
   47,   47,   48,   48,   48,   49,   49,   49,   50,   50,
   41,   41,   52,   52,   52,   51,   51,   51,   51,   51,
   51,   26,   26,   56,   55,   55,   55,   57,   57,   57,
   53,   53,   58,   58,   58,   54,   54,   59,   59,   59,
   27,   27,   60,   60,   60,
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
    2,    5,    1,    4,    4,    4,    4,    5,    3,    4,
    1,    4,    2,    3,    1,    3,    1,    2,    4,    1,
    2,    2,    3,    3,    3,    1,    3,    1,    2,    2,
    3,    1,    2,    2,    2,    1,    1,    1,    1,    1,
    1,    9,    1,    4,    2,    2,    1,    1,    2,    2,
    3,    1,    2,    2,    2,    3,    1,    2,    2,    2,
    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   89,   96,  120,  133,  173,  192,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   43,   48,    0,    0,  114,
  113,    0,    0,    0,  115,   94,    0,    0,  101,  106,
  107,  170,  169,  171,    0,  166,  167,  168,    0,    0,
    0,  162,    0,    0,    0,    0,    0,    0,    0,    0,
   69,    0,    0,   26,    0,    0,    3,    7,   22,   21,
    0,   25,   20,    0,    0,    0,   61,   53,   71,   62,
   55,   68,   56,   63,   58,   67,   59,    4,    1,    0,
   91,    0,   92,   88,    0,   65,    0,    0,  127,  129,
  128,    0,    0,    0,    0,    0,  125,   47,    0,   44,
   66,    0,  116,  117,  110,  111,    0,    0,    0,    0,
    0,    0,  165,    0,    0,    0,  193,    0,  194,   50,
    0,    0,   40,    0,   70,   54,    0,    0,    0,    0,
  182,   64,    0,   19,   16,   27,   23,   32,    0,   30,
   57,  130,  131,    0,   41,  121,  118,    0,  126,   35,
  122,  119,  102,    0,  103,    0,  108,  104,  109,  105,
    0,    0,  136,  141,    0,  137,    0,  135,  191,   37,
    0,   38,   36,  184,    0,  183,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   81,  174,  158,
    0,  134,   31,   28,    0,  124,    0,    0,    0,    0,
    0,  147,    0,    0,  132,   39,   33,  181,    0,    0,
   82,   78,    0,   83,    0,   79,    0,    0,   12,  159,
   13,   72,   74,   76,   77,    0,    0,    0,  187,    0,
   42,   14,    0,  151,   15,    0,    0,    0,  150,  139,
    0,    0,   73,   84,    0,   85,  157,    0,    0,    0,
    0,    0,  146,    0,    0,    0,    0,  142,  140,   75,
   86,   80,    0,  178,    0,    0,    0,  177,   46,    0,
  154,  153,  180,  175,  179,  176,    0,  149,  172,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,   24,   25,  222,  223,  240,   26,
   27,   28,   29,   30,   31,   32,   54,   33,   55,   56,
   57,   34,   35,   36,   37,   38,   39,   40,  228,   79,
   41,   42,   68,   69,   70,   71,  135,   43,  136,  137,
   80,  203,   44,  241,  278,  204,  242,  279,  229,  230,
   81,   82,  170,  268,  307,   45,  308,  171,  269,   46,
};
final static short yysindex[] = {                      -116,
  -91,   71,    0,    0,   71,   71,    0,   -7,  473,  561,
  -36,    4,  553,  -29,   -9,    0,    0, -222, -224,  753,
   94,    0,    0,    0,    0,  -41,   76,    0,    0,    0,
  -18,    0,    0,  -35,   62,  -32,   28,   54,   96,    0,
    0,    0,    0,    0,    0,    0,  118,  139,  493,  449,
  -40,   73, -200,   24,   85,    0,    0,   83,   92,    0,
    0,  -73,  127,  127,    0,    0,   74,   32,    0,    0,
    0,    0,    0,    0,  747,    0,    0,    0,  513,  113,
  553,    0,  136,  -28, -101,   -2,   17,  134,   74,   92,
    0,  125,   82,    0,  121,  153,    0,    0,    0,    0,
  105,    0,    0,  -58,   26,  164,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   92,
    0,   74,    0,    0,   74,    0,  144, -101,    0,    0,
    0,    0,  159,   86,   21,  115,    0,    0, -109,    0,
    0,  545,    0,    0,    0,    0,  570,  582,  324,  444,
 -168,  -26,    0,  553, -168,   74,    0,  168,    0,    0,
 -109,  -44,    0, -109,    0,    0, -142,  -21,  185,  158,
    0,    0, -168,    0,    0,    0,    0,    0,   49,    0,
    0,    0,    0,  -87,    0,    0,    0,  394,    0,    0,
    0,    0,    0,   32,    0,   32,    0,    0,    0,    0,
  340,  340,    0,    0, -162,    0,   74,    0,    0,    0,
  -65,    0,    0,    0,   46,    0,  -33,  137,  100,  143,
  204,  252,    0,  284,  317,  352,  365,    0,    0,    0,
  145,    0,    0,    0,  122,    0,  -38,  470,    0,  361,
  -89,    0,  -86,  340,    0,    0,    0,    0,  473, -224,
    0,    0,  367,    0,  372,    0,   19,  272,    0,    0,
    0,    0,    0,    0,    0,  753,  553,  403,    0,  -87,
    0,    0,  374,    0,    0,  385,  470,  176,    0,    0,
  198,  411,    0,    0,  331,    0,    0,   74,  553,   74,
   40,  433,    0,  470,    0,  406,  425,    0,    0,    0,
    0,    0,   74,    0, -125, -119,  441,    0,    0,  447,
    0,    0,    0,    0,    0,    0,  185,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,   81,    0,    0,
    0,    0,  364,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  472,    0,    0,
    0,    0,   -5,    0,    0,    0,    0,    0,  695,    0,
    0,    0,    0,    0,    0,    0,  377,  624,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  388,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   22,
    0,  408,    0,    0,  412,    0,    0,  429,    0,    0,
    0,  393,    0,   39,    0,   65,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   45,    0,   51,    0,  416,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  717,    0,  725,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   68,    0,    0,    0,
    0,    0,    0,    0,  436,    0,    0,    0,    0,    0,
    0,    0,  228,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  297,    0,
    0,    0,  422,  431,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  439,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  569,    0,    0,    0,    0,    0,    0,    0,
  453,    0,    0,    0,    0,    0,    0,  445,  452,  454,
    0,    0,    0,    0,  320,    0,    0,    0,    0,    0,
    0,    0,  455,    0,    0,    0,    0,    0,    0,   98,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   23,    0,  531,    0,    0,  615,  232, -146, -186,    9,
  480,    0,    0,    0,    0,    0,   61,    0,   16,    0,
    0, -122,   -4,  338,    0,   -8,  507,    0,    0,   -1,
    0,    0,  308,    0,   38,    0,    0,    0,  -64,    0,
   35,  275,    0,  321,  276,    0,    0,    0,  205,    0,
  -56,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=1015;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   66,  142,   18,   84,   65,   65,    2,   67,   65,   92,
   95,   89,  159,  211,  205,   65,   53,  100,  126,   51,
   53,   20,  154,  108,  250,   18,  111,   47,   48,   91,
   93,    6,   52,  277,   94,   49,  277,   87,   49,   19,
  121,  124,  127,   87,   65,   65,  224,  122,  125,   15,
   51,  273,   49,  106,   96,  161,  138,  163,   65,   65,
   53,  187,   50,  112,  112,   20,  112,  134,  112,   18,
   65,  189,   88,  149,  259,  261,   65,  286,  150,  156,
  112,  139,  305,   19,  306,  164,  113,  201,   20,  296,
  297,  163,   18,  244,   53,   53,   45,  202,  224,  224,
  145,  146,  134,  202,  105,  123,   19,  310,  161,  152,
   20,  261,  115,  132,   18,  214,  147,  133,  148,  104,
  109,  215,  169,  236,   22,  140,  185,  179,   19,  184,
  313,  142,  314,   20,  103,  224,  315,   18,  316,   22,
    1,  141,   65,   65,   65,   65,  162,  190,  104,   65,
  178,   19,  207,  155,  117,  160,  155,   20,  188,  133,
  226,   18,  271,  175,    5,  270,   16,   17,   85,  210,
  212,   62,  213,  234,  267,   19,  157,  276,   20,  172,
  276,  280,   18,  166,  143,  144,  198,  200,   16,   17,
  246,  164,   53,  173,  224,  252,   19,  176,  177,  235,
  257,  256,  181,   20,   76,   78,   77,   18,  209,  289,
   16,   17,  226,  226,  253,   99,  231,  249,   97,  247,
  107,   19,  249,  110,   20,   50,   83,   90,   58,  201,
   50,   16,   17,   15,  158,   15,  216,    7,    8,  202,
  121,  282,  118,   20,   65,    9,   10,  122,   49,  226,
   11,   12,   13,   85,   14,   15,   50,   16,   17,   85,
   86,   65,   65,  119,  288,  290,   15,   12,   16,   17,
   49,   49,   85,   16,   17,  285,  186,  112,   53,   16,
   17,    7,    8,  112,   65,  292,  156,  303,  180,    9,
   10,   20,   16,   17,   11,   12,   13,  304,   14,   15,
  164,   16,   17,  248,  233,    8,  163,  221,  226,  114,
  164,   20,    9,   10,   45,   45,  163,   11,   12,   13,
  123,   14,   15,  161,   16,   17,    7,    8,  128,  129,
  130,  131,  102,  161,    9,   10,   14,   22,  167,   11,
   12,   13,  262,   14,   15,  168,   16,   17,   16,   17,
    8,  116,   12,  155,   14,  145,   90,    9,   10,   14,
  174,  102,   11,   12,   13,  155,   14,   15,   62,   16,
   17,  129,  130,  131,    8,  263,  260,   14,  148,   20,
  165,    9,   10,   59,   60,   61,   11,   12,   13,  302,
   14,   15,  251,   16,   17,    8,  287,   19,  254,  255,
   20,  266,    9,   10,   72,   73,   74,   11,   12,   13,
  264,   14,   15,   20,   16,   17,  182,  183,   19,  145,
    8,   14,   97,  265,   20,  283,  206,    9,   10,  208,
  284,   19,   11,   12,   13,   93,   14,   15,  133,   16,
   17,  217,   19,  298,   14,   20,   95,  232,    9,   10,
   40,  119,  258,   11,  194,  196,  218,  219,   15,  220,
  217,  291,  238,   19,   20,  299,   90,    9,   10,  300,
   87,    5,   11,  309,  195,  218,  219,   15,  220,  245,
  143,  317,   19,  156,   12,  274,   20,  122,   62,  138,
   63,   12,   12,   62,  185,   64,   12,  160,  293,   12,
   12,   12,   12,  189,   19,  101,  225,  294,  217,   20,
  190,  144,  188,  186,   63,    9,   10,   62,  281,   64,
   11,  319,  243,  218,  219,   15,  220,   19,  217,    0,
  311,    0,    0,    0,   63,    9,   10,   62,    0,   64,
   11,    0,    0,  218,  219,   15,  220,    0,    0,  312,
    0,   98,  145,   14,    0,  147,    0,  148,  225,  225,
   14,   14,    0,  145,  145,   14,    0,   14,    0,   14,
   14,  318,   76,   78,   77,  148,   14,   98,   98,  197,
   59,   60,   61,   14,   14,  192,  301,  148,   14,  133,
   14,    0,   14,   14,   63,  225,  237,   62,    0,   64,
   75,    0,   63,    9,   10,   62,    0,   64,   11,    0,
   13,   63,   14,   15,   62,    0,   64,  237,    0,   97,
   76,   78,   77,   63,    9,   10,   62,  152,   64,   11,
  237,   13,   93,   14,   15,    0,   98,    9,   10,    0,
    0,  237,   11,   95,   13,    0,   14,   15,    9,   10,
  129,  130,  131,   11,  225,   13,    0,   14,   15,    0,
    0,    0,  237,   90,   98,    0,   98,   87,   98,    9,
   10,  195,    0,    0,   11,  227,   13,  143,   14,   15,
    0,  237,   98,   98,   98,   98,  138,    0,    9,   10,
    0,  152,    0,   11,  160,   13,    0,   14,   15,  199,
   59,   60,   61,  237,  123,   59,   60,   61,  144,   98,
    9,   10,    0,    0,    0,   11,    0,   13,    0,   14,
   15,    0,   15,    0,    0,    0,  237,  227,  227,   59,
   60,   61,    0,    9,   10,  112,  112,  112,   11,  112,
   13,  112,   14,   15,    0,    0,   15,    0,    0,  120,
   60,   61,    0,  112,  112,  112,  112,   99,    0,   99,
    0,   99,    0,    0,  227,  100,   15,  100,  153,  100,
    0,    0,   72,   73,   74,   99,   99,   99,   99,    0,
    0,    0,    0,  100,  100,  100,  100,  151,   63,    0,
    0,   62,    0,   64,   63,    0,    0,   62,    0,   64,
  191,  129,  130,  131,    0,    0,   76,   78,   77,   59,
   60,   61,   76,   78,   77,  239,  239,   59,   60,   61,
   72,   73,   74,  227,  152,  193,   59,   60,   61,    0,
    0,    0,    0,    0,    0,  152,  152,  195,   59,   60,
   61,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  272,    0,  275,    0,    0,    0,  239,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   98,
    0,    0,    0,   98,   98,   98,    0,  275,    0,   98,
  295,  272,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  272,    0,
  275,  275,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  275,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  112,    0,    0,    0,  112,  112,  112,    0,    0,    0,
  112,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   99,    0,    0,    0,   99,   99,   99,    0,
  100,    0,   99,    0,  100,  100,  100,    0,    0,    0,
  100,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   59,   60,   61,   72,   73,   74,   59,
   60,   61,   72,   73,   74,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          8,
    9,   40,   44,   40,    9,   10,  123,    9,   13,   14,
   19,   13,   41,   58,   41,   20,    8,   59,   59,   58,
   12,   40,   79,   59,   58,   44,   59,    5,    6,   59,
   40,  123,   40,  123,  257,   41,  123,   40,   44,   58,
   49,   50,   51,   40,   49,   50,  169,   49,   50,  274,
   58,  238,   58,   31,   20,   58,  257,   41,   63,   64,
   52,   41,   41,   42,   43,   40,   45,   52,   47,   44,
   75,  136,   12,   42,  221,  222,   81,   59,   47,   81,
   59,   58,   43,   58,   45,   41,   59,  256,   40,  276,
  277,   41,   44,  256,   86,   87,   58,  266,  221,  222,
   63,   64,   87,  266,  123,   41,   58,  294,   41,   75,
   40,  258,   59,   41,   44,  258,   43,   45,   45,   44,
   59,  264,   41,  188,   44,   41,   41,  105,   58,   44,
  256,   40,  258,   40,   59,  258,  256,   44,  258,   59,
  257,   59,  147,  148,  149,  150,   86,  139,   44,  154,
  125,   58,  154,   41,   59,  257,   59,   40,   44,   45,
  169,   44,   41,   59,  256,   44,  276,  277,  256,  161,
  162,   45,  164,  125,  231,   58,   41,  267,   40,   59,
  267,  268,   44,   59,  258,  259,  149,  150,  276,  277,
  256,   58,  184,   41,  317,   59,   58,  256,  257,  184,
   58,   59,   59,   40,   60,   61,   62,   44,   41,  266,
  276,  277,  221,  222,  219,  257,   59,  256,  125,  211,
  256,   58,  256,  256,   40,  264,  263,  257,  237,  256,
  264,  276,  277,  274,  263,  274,  258,  256,  257,  266,
  249,  250,  125,   40,  249,  264,  265,  249,  256,  258,
  269,  270,  271,  256,  273,  274,  264,  276,  277,  256,
  257,  266,  267,  125,  266,  267,  274,   40,  276,  277,
  276,  277,  256,  276,  277,  257,  256,  256,  270,  276,
  277,  256,  257,  256,  289,  270,   59,  289,  125,  264,
  265,   40,  276,  277,  269,  270,  271,  258,  273,  274,
  256,  276,  277,  258,  256,  257,  256,  123,  317,  256,
  266,   40,  264,  265,  276,  277,  266,  269,  270,  271,
  256,  273,  274,  256,  276,  277,  256,  257,  256,  257,
  258,  259,  257,  266,  264,  265,   40,  257,  257,  269,
  270,  271,   59,  273,  274,  264,  276,  277,  276,  277,
  257,  256,  125,  256,   58,   59,  257,  264,  265,   40,
  256,  257,  269,  270,  271,  268,  273,  274,   45,  276,
  277,  257,  258,  259,  257,   59,  125,   58,   59,   40,
  256,  264,  265,  257,  258,  259,  269,  270,  271,   59,
  273,  274,  256,  276,  277,  257,  125,   58,  256,  257,
   40,  257,  264,  265,  260,  261,  262,  269,  270,  271,
   59,  273,  274,   40,  276,  277,  258,  259,   58,  123,
  257,  125,   59,   59,   40,   59,  152,  264,  265,  155,
   59,   58,  269,  270,  271,   59,  273,  274,   45,  276,
  277,  257,   58,  268,  125,   40,   59,  173,  264,  265,
   58,   59,  221,  269,  147,  148,  272,  273,  274,  275,
  257,   59,  123,   58,   40,  268,   59,  264,  265,   59,
   59,    0,  269,   41,   59,  272,  273,  274,  275,  205,
   59,   41,   58,  256,  257,  125,   40,   59,   45,   59,
   42,  264,  265,   45,   59,   47,  269,   59,  125,  272,
  273,  274,  275,   59,   58,   26,  169,  123,  257,   40,
   59,   59,   59,   59,   42,  264,  265,   45,  243,   47,
  269,  317,  202,  272,  273,  274,  275,   58,  257,   -1,
  125,   -1,   -1,   -1,   42,  264,  265,   45,   -1,   47,
  269,   -1,   -1,  272,  273,  274,  275,   -1,   -1,  125,
   -1,   21,  256,  257,   -1,   43,   -1,   45,  221,  222,
  264,  265,   -1,  267,  268,  269,   -1,  271,   -1,  273,
  274,  125,   60,   61,   62,  256,  257,   47,   48,  256,
  257,  258,  259,  264,  265,   41,  256,  268,  269,   45,
  271,   -1,  273,  274,   42,  258,  257,   45,   -1,   47,
   40,   -1,   42,  264,  265,   45,   -1,   47,  269,   -1,
  271,   42,  273,  274,   45,   -1,   47,  257,   -1,  256,
   60,   61,   62,   42,  264,  265,   45,   59,   47,  269,
  257,  271,  256,  273,  274,   -1,  106,  264,  265,   -1,
   -1,  257,  269,  256,  271,   -1,  273,  274,  264,  265,
  257,  258,  259,  269,  317,  271,   -1,  273,  274,   -1,
   -1,   -1,  257,  256,   41,   -1,   43,  256,   45,  264,
  265,  256,   -1,   -1,  269,  169,  271,  256,  273,  274,
   -1,  257,   59,   60,   61,   62,  256,   -1,  264,  265,
   -1,  123,   -1,  269,  256,  271,   -1,  273,  274,  256,
  257,  258,  259,  257,  256,  257,  258,  259,  256,  179,
  264,  265,   -1,   -1,   -1,  269,   -1,  271,   -1,  273,
  274,   -1,  274,   -1,   -1,   -1,  257,  221,  222,  257,
  258,  259,   -1,  264,  265,   41,   42,   43,  269,   45,
  271,   47,  273,  274,   -1,   -1,  274,   -1,   -1,  257,
  258,  259,   -1,   59,   60,   61,   62,   41,   -1,   43,
   -1,   45,   -1,   -1,  258,   41,  274,   43,  256,   45,
   -1,   -1,  260,  261,  262,   59,   60,   61,   62,   -1,
   -1,   -1,   -1,   59,   60,   61,   62,   41,   42,   -1,
   -1,   45,   -1,   47,   42,   -1,   -1,   45,   -1,   47,
  256,  257,  258,  259,   -1,   -1,   60,   61,   62,  257,
  258,  259,   60,   61,   62,  201,  202,  257,  258,  259,
  260,  261,  262,  317,  256,  256,  257,  258,  259,   -1,
   -1,   -1,   -1,   -1,   -1,  267,  268,  256,  257,  258,
  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  238,   -1,  240,   -1,   -1,   -1,  244,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,
   -1,   -1,   -1,  260,  261,  262,   -1,  273,   -1,  266,
  276,  277,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  294,   -1,
  296,  297,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  310,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  256,   -1,   -1,   -1,  260,  261,  262,   -1,   -1,   -1,
  266,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
  256,   -1,  266,   -1,  260,  261,  262,   -1,   -1,   -1,
  266,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,  257,
  258,  259,  260,  261,  262,
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
"control : error_control",
"error_control : FOR '(' ')' bloque_for",
"incr_decr : '+' CTE_INT",
"incr_decr : '-' CTE_INT",
"incr_decr : error_incr_decr",
"error_incr_decr : CTE_INT",
"error_incr_decr : '-' error",
"error_incr_decr : '+' error",
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

//#line 544 "gramatica.y"

private Lexico lexico;
private ArbolSintactico arbolSintactico;
private String ambito;
private ArrayList<String> lista_variables;
private ArrayList<String> lista_parametros;

public Parser(Lexico lexico)
{
  this.lexico = lexico;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
  this.lista_parametros = new ArrayList<String>();

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
            System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
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
	return "";
}

public ArbolSintactico returnTree(){
	return this.arbolSintactico;
}

//#line 805 "Parser.java"
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
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
break;
case 2:
//#line 18 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
//#line 21 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
//#line 22 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 23 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
//#line 26 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 7:
//#line 27 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                           yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 9:
//#line 32 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
break;
case 11:
//#line 36 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 12:
//#line 39 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 13:
//#line 40 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableFor");
                                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 14:
//#line 44 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 15:
//#line 45 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableIf");
                                                      yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 16:
//#line 50 "gramatica.y"
{  String tipoVar = val_peek(2).sval;
                                            System.out.println("tipo de la variable"+tipoVar);

					                        lista_variables = (ArrayList<String>)val_peek(1).obj;
                                            for(String lexema : lista_variables){
                                                    String nuevoLexema = lexema + "." + ambito;
                                                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                                                        Main.tablaDeSimbolos.modificarSimbolo(lexema, nuevoLexema);
                                                        AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                                                        atributosT.setTipo(tipoVar);
                                                        atributosT.setUso("variable");
                                                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                                                    } else {
                                                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea+ " la variable " + lexema + " ya fue declarada en este ambito");
                                                        Main.tablaDeSimbolos.eliminarSimbolo(lexema);
                                                        }
                                                }
                                            lista_variables.clear();
                                            }
break;
case 19:
//#line 74 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 75 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 76 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 79 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);
                        lista_variables.add(val_peek(0).sval);
                        yyval = new ParserVal(lista_variables);
                                }
break;
case 23:
//#line 83 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + val_peek(0).sval);
                                         lista_variables = (ArrayList<String>) val_peek(2).obj;
                                         lista_variables.add(val_peek(0).sval);
                                         yyval = new ParserVal(lista_variables);
                                         }
break;
case 25:
//#line 91 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 92 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 93 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 96 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");
								ambito = ambito.substring(0,ambito.lastIndexOf("."));
                            }
break;
case 30:
//#line 102 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 103 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 104 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 33:
//#line 107 "gramatica.y"
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
                                Main.tablaDeSimbolos.modificarSimbolo(parametro, parametro +"."+ambito);
                                Main.tablaDeSimbolos.getAtributosTablaS(parametro +"."+ambito).setOrden(posicion);
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
//#line 133 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 134 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 135 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 136 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 137 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
//#line 140 "gramatica.y"
{lista_parametros.clear();
                              yyval = new ParserVal(lista_parametros);}
break;
case 41:
//#line 142 "gramatica.y"
{lista_parametros.clear();
                                     			     lista_parametros.add(val_peek(1).sval);
                                     			     yyval = new ParserVal(lista_parametros);}
break;
case 42:
//#line 145 "gramatica.y"
{lista_parametros.clear();
                                                     		    			if(!val_peek(3).sval.equals(val_peek(1).sval)){
                                                     						lista_parametros.add(val_peek(4).sval);
                                                     						lista_parametros.add(val_peek(2).sval);
                                                     					} else
                                                     						Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " no puede haber dos parametros con el mismo ID");
                                                     					yyval = new ParserVal(lista_parametros);}
break;
case 44:
//#line 155 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 156 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 157 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
//#line 160 "gramatica.y"
{      AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                   		  atributos.setUso("nombreParametro");
                   		  atributos.setTipo(val_peek(1).sval);
                   		  Main.tablaDeSimbolos.setAtributosDeSimbolo(val_peek(0).sval, atributos);
                   		  yyval = new ParserVal(val_peek(0).sval);}
break;
case 49:
//#line 168 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 169 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 172 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("INT");}
break;
case 52:
//#line 174 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("FLOAT");}
break;
case 53:
//#line 178 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 179 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                yyval.arbol = new NodoInvocacion(val_peek(1).arbol,null,lexDiscard);
	                                }
break;
case 55:
//#line 183 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 56:
//#line 184 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 185 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
	                           AtributosTablaS lexEtiqueta = new AtributosTablaS("Etiqueta");
	                           AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval);
	                           yyval.arbol = new NodoEtiquetado(new NodoHoja(lexID),val_peek(1).arbol,lexEtiqueta);
	                           }
break;
case 58:
//#line 190 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 59:
//#line 191 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 61:
//#line 195 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
//#line 196 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
//#line 197 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
//#line 198 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
//#line 199 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
//#line 200 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
//#line 201 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
//#line 202 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
//#line 203 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
//#line 204 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
//#line 205 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
//#line 208 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 73:
//#line 209 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                           yyval.arbol = new NodoInvocacion(val_peek(1).arbol,null,lexDiscard);
                                           }
break;
case 74:
//#line 213 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 75:
//#line 214 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                      AtributosTablaS lexEtiqueta = new AtributosTablaS("Etiqueta");
                                      AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval);
                                      yyval.arbol = new NodoEtiquetado(new NodoHoja(lexID),val_peek(1).arbol,lexEtiqueta);
                                      }
break;
case 76:
//#line 219 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 77:
//#line 220 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 78:
//#line 221 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              yyval.arbol = new NodoHoja(sentenciaBreak);}
break;
case 79:
//#line 224 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("Continue");
                                yyval.arbol = new NodoHoja(sentenciaContinue);}
break;
case 80:
//#line 227 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +val_peek(1).sval);
                                        AtributosTablaS sentenciaContinue =  new AtributosTablaS("Continue con etiquetado");
                                        AtributosTablaS controlEtiquetado = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                                        yyval.arbol = new NodoEtiquetado(new NodoHoja(controlEtiquetado),null,sentenciaContinue);}
break;
case 82:
//#line 234 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 83:
//#line 235 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
//#line 236 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
//#line 237 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
//#line 238 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 87:
//#line 241 "gramatica.y"
{  Main.tablaDeSimbolos.eliminarSimbolo(val_peek(2).sval);
AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                                AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                                if (nodoA.getTipo()!=null){
                                                yyval.arbol= nodoA;
                                                }
                                                else{
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                                }
                                                }
break;
case 88:
//#line 252 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                   AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                   AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                   yyval.arbol= new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                   }
break;
case 90:
//#line 260 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 91:
//#line 261 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
//#line 262 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 93:
//#line 263 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 94:
//#line 264 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 95:
//#line 267 "gramatica.y"
{ AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                        yyval.arbol = new NodoRetorno(val_peek(0).arbol,null,retorno);
                                      }
break;
case 97:
//#line 273 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 98:
//#line 276 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 99:
//#line 277 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                                 }
break;
case 100:
//#line 282 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                                                    }
break;
case 102:
//#line 289 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 103:
//#line 290 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 104:
//#line 293 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");

	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol,atributos);
                             }
break;
case 105:
//#line 298 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          }
break;
case 106:
//#line 302 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 108:
//#line 306 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 109:
//#line 307 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 110:
//#line 308 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 111:
//#line 309 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 112:
//#line 312 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
              yyval.arbol = new NodoHoja(atributos);
              }
break;
case 113:
//#line 315 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        yyval.arbol = new NodoHoja(atributos);
                       }
break;
case 114:
//#line 318 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        yyval.arbol = new NodoHoja(atributos);
                        }
                   }
break;
case 115:
//#line 323 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 116:
//#line 327 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       yyval.arbol = new NodoHoja(atributos);
                       }
                      }
break;
case 117:
//#line 332 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               yyval.arbol = new NodoHoja(atributos);
                               }
                           }
break;
case 118:
//#line 339 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);
                                            AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion");
                                            AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval+"."+ambito);
                                            yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),val_peek(1).arbol,lexInvocacion);}
break;
case 119:
//#line 343 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);
                           AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion sin parametros");
                           AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                           yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),null,lexInvocacion);}
break;
case 121:
//#line 350 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 122:
//#line 351 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 123:
//#line 354 "gramatica.y"
{AtributosTablaS lexParam = new AtributosTablaS("Un Parametro");
                                       yyval.arbol = new NodoParam(val_peek(0).arbol,null,lexParam);
                                       }
break;
case 124:
//#line 357 "gramatica.y"
{AtributosTablaS lexParam = new AtributosTablaS("Dos Parametros");
                                                               yyval.arbol = new NodoParam(val_peek(2).arbol,val_peek(0).arbol,lexParam);
                                                               }
break;
case 126:
//#line 363 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 127:
//#line 366 "gramatica.y"
{ AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                          yyval.arbol = new NodoHoja(atributos);
                          }
break;
case 128:
//#line 369 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                   yyval.arbol = new NodoHoja(atributos);
                                   }
break;
case 129:
//#line 373 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                               Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                               yyval.arbol = new NodoHoja(atributos);
                               }
                               }
break;
case 130:
//#line 379 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                  }
break;
case 131:
//#line 384 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                       }
break;
case 132:
//#line 390 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);}
break;
case 134:
//#line 396 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 135:
//#line 397 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 136:
//#line 398 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 137:
//#line 399 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 138:
//#line 400 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 139:
//#line 403 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    }
break;
case 140:
//#line 406 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                }
break;
case 142:
//#line 412 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 143:
//#line 413 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 144:
//#line 414 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 145:
//#line 418 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        yyval.arbol = new NodoElse(val_peek(0).arbol,null,atributos);}
break;
case 146:
//#line 420 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          yyval.arbol = new NodoElse(val_peek(1).arbol,null,atributos);}
break;
case 148:
//#line 425 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             yyval.arbol = new NodoElse(val_peek(0).arbol,null,atributos);}
break;
case 149:
//#line 427 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                yyval.arbol = new NodoElse(val_peek(1).arbol,null,atributos);}
break;
case 151:
//#line 432 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 152:
//#line 433 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 153:
//#line 436 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 154:
//#line 437 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 155:
//#line 438 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 156:
//#line 441 "gramatica.y"
{ yyval.arbol = val_peek(0).arbol;}
break;
case 157:
//#line 442 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 159:
//#line 446 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 160:
//#line 447 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 161:
//#line 451 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                                  yyval.arbol = new NodoCondicion(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 163:
//#line 457 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 164:
//#line 458 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 165:
//#line 459 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 166:
//#line 462 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 167:
//#line 463 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 168:
//#line 464 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 169:
//#line 465 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 170:
//#line 466 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 171:
//#line 467 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 172:
//#line 470 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                              AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                              AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                              AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                              ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor(val_peek(0).arbol,null,lexCuerpoFor);
                                                                              ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor(val_peek(6).arbol,val_peek(4).arbol,lexEncabezadoFor),val_peek(2).arbol,lexEncabezadoFor);
                                                                              yyval.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);}
break;
case 173:
//#line 477 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 174:
//#line 480 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 175:
//#line 483 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 176:
//#line 486 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 178:
//#line 492 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 179:
//#line 493 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 180:
//#line 494 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 181:
//#line 497 "gramatica.y"
{if (chequearRangoEnteros()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                            AtributosTablaS atributos2 = new AtributosTablaS("Asignacion FOR");
                                            AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                            NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributos),new NodoHoja(atributos3),atributos2);
                                            if (nodoA.getTipo()!=null){
                                            yyval.arbol= nodoA;
                                            }
                                            else{
                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                            }
                                      }
                                      }
break;
case 183:
//#line 514 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 184:
//#line 515 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 185:
//#line 516 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 186:
//#line 519 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CondicionFOR");
                                                   AtributosTablaS atributos2 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval);
                                                   AtributosTablaS atributos3 = new AtributosTablaS(val_peek(1).sval);
                                                   yyval.arbol = new NodoCondicionFor(new NodoExpresionLogica(new NodoHoja(atributos2),val_peek(0).arbol,atributos3),null,atributos);}
break;
case 188:
//#line 526 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 189:
//#line 527 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 190:
//#line 528 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 191:
//#line 531 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 193:
//#line 539 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 194:
//#line 540 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 195:
//#line 541 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1833 "Parser.java"
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
