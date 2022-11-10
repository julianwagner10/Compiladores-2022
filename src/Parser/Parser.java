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
   38,   38,   37,   37,   37,   40,   40,   40,   39,   39,
   39,   39,   39,   24,   24,   43,   43,   43,   43,   43,
   42,   42,   42,   46,   46,   46,   44,   44,   44,   45,
   45,   45,   47,   47,   48,   48,   48,   49,   49,   49,
   50,   50,   41,   41,   52,   52,   52,   51,   51,   51,
   51,   51,   51,   26,   26,   56,   55,   55,   55,   57,
   57,   57,   57,   57,   53,   53,   58,   58,   58,   54,
   54,   59,   59,   59,   27,   27,   60,   60,   60,
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
    4,    3,    1,    3,    1,    2,    5,    7,    1,    1,
    1,    2,    2,    5,    1,    4,    4,    4,    4,    5,
    3,    4,    1,    4,    2,    3,    1,    3,    1,    2,
    4,    1,    2,    2,    3,    3,    3,    1,    3,    1,
    2,    2,    3,    1,    2,    2,    2,    1,    1,    1,
    1,    1,    1,    9,    1,    4,    2,    2,    1,    1,
    2,    2,    1,    2,    3,    1,    2,    2,    2,    3,
    1,    2,    2,    2,    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   89,   96,  120,  135,  175,  196,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   43,   48,    0,    0,  114,
  113,    0,    0,    0,  115,   94,    0,    0,  101,  106,
  107,  172,  171,  173,    0,  168,  169,  170,    0,    0,
    0,  164,    0,    0,    0,    0,    0,    0,    0,    0,
   69,    0,    0,   26,    0,    0,    3,    7,   22,   21,
    0,   25,   20,    0,    0,    0,   61,   53,   71,   62,
   55,   68,   56,   63,   58,   67,   59,    4,    1,    0,
   91,    0,   92,   88,    0,   65,    0,    0,  129,  131,
  130,    0,    0,    0,    0,    0,  125,   47,    0,   44,
   66,    0,  116,  117,  110,  111,    0,    0,    0,    0,
    0,    0,  167,    0,    0,    0,  197,    0,  198,   50,
    0,    0,   40,    0,   70,   54,    0,    0,    0,    0,
  186,   64,    0,   19,   16,   27,   23,   32,    0,   30,
   57,  132,  133,    0,   41,  121,  118,    0,  126,   35,
  122,  119,  102,    0,  103,    0,  108,  104,  109,  105,
    0,    0,  138,  143,    0,  139,    0,  137,  195,   37,
    0,   38,   36,  188,    0,  187,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   81,  176,  160,
    0,  136,   31,   28,    0,    0,    0,    0,    0,    0,
    0,  149,    0,    0,  134,   39,   33,  185,    0,    0,
   82,   78,    0,   83,    0,   79,    0,    0,   12,  161,
   13,   72,   74,   76,   77,    0,    0,    0,  191,    0,
   42,    0,   14,    0,  153,   15,    0,    0,    0,  152,
  141,    0,    0,   73,   84,    0,   85,  159,    0,    0,
    0,    0,    0,    0,  148,    0,    0,    0,    0,  144,
  142,   75,   86,   80,    0,  180,  183,    0,    0,    0,
  179,   46,    0,    0,  156,  155,  182,  177,  181,  178,
  184,    0,  128,  151,  174,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,   24,   25,  222,  223,  240,   26,
   27,   28,   29,   30,   31,   32,   54,   33,   55,   56,
   57,   34,   35,   36,   37,   38,   39,   40,  228,   79,
   41,   42,   68,   69,   70,   71,  135,   43,  136,  137,
   80,  203,   44,  241,  279,  204,  242,  280,  229,  230,
   81,   82,  170,  268,  310,   45,  311,  171,  269,   46,
};
final static short yysindex[] = {                       -92,
  -76,   59,    0,    0,   59,   59,    0,  150,   68,  630,
  -27,   16,  127,  -36,  -11,    0,    0, -185, -208,  706,
   74,    0,    0,    0,    0,  373,  412,    0,    0,    0,
  -18,    0,    0,   57,   20,   93,  198,  301,  371,    0,
    0,    0,    0,    0,    0,    0,   97,  118,  449,  473,
  -55,  122, -159,   43,   66,    0,    0,   95,  117,    0,
    0, -129,  390,  390,    0,    0,  104,   62,    0,    0,
    0,    0,    0,    0,  581,    0,    0,    0,  713,  119,
  127,    0,  123,  -26,  -82,   18,  -16,  120,  104,  117,
    0,  420,  -34,    0,  125,  146,    0,    0,    0,    0,
  431,    0,    0,  -56,   11,  139,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  117,
    0,  104,    0,    0,  104,    0,  132,  -82,    0,    0,
    0,    0,  -49,   67,  -21,  378,    0,    0,  -74,    0,
    0,   61,    0,    0,    0,    0,  310,  540,  352,  357,
 -191,  -39,    0,  127, -191,  104,    0,  155,    0,    0,
  -74,  -44,    0,  -74,    0,    0, -214,  -60,  186,  152,
    0,    0, -191,    0,    0,    0,    0,    0,   34,    0,
    0,    0,    0, -186,    0,    0,    0,  403,    0,    0,
    0,    0,    0,   62,    0,   62,    0,    0,    0,    0,
  319,  319,    0,    0, -169,    0,  104,    0,    0,    0,
 -183,    0,    0,    0,  -53,    0,  -40,  433,   64,  514,
  260,  209,    0,  294,  299,  366,  374,    0,    0,    0,
  719,    0,    0,    0,   98,  396,  137,  409,    0,  332,
  -99,    0,  -86,  319,    0,    0,    0,    0,   68, -208,
    0,    0,  379,    0,  411,    0,  -32,  238,    0,    0,
    0,    0,    0,    0,    0,  706,  127,  413,    0, -186,
    0,  403,    0,  360,    0,    0,  381,  409,  108,    0,
    0,  185,  417,    0,    0,  464,    0,    0,  104,  127,
  104,  161,  427,  444,    0,  409,    0,  394,  429,    0,
    0,    0,    0,    0,  104,    0,    0,  -64, -125,  436,
    0,    0,  403,  440,    0,    0,    0,    0,    0,    0,
    0,  186,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  442,    0,    0,
    0,    0,  469,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  497,    0,    0,
    0,    0,   -6,    0,    0,    0,    0,    0,  674,    0,
    0,    0,    0,    0,    0,    0,  472,  499,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  489,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   81,
    0,  493,    0,    0,  522,    0,    0,  430,    0,    0,
    0,  404,    0,   25,    0,   -2,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -38,    0,  -22,    0,  527,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  559,    0,  681,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   40,    0,    0,    0,
    0,    0,    0,    0,  434,    0,    0,    0,    0,    0,
    0,    0,  172,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   13,    0,    0,  282,    0,
    0,    0,  532,  536,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  539,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  471,    0,    0,    0,    0,    0,    0,
    0,  548,    0,    0,    0,    0,    0,    0,  441,  446,
  447,    0,    0,   21,    0,    0,  306,    0,    0,    0,
    0,    0,    0,    0,  455,    0,    0,    0,    0,    0,
    0,    0,    0,  253,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  679,    0,  716,    0,    0,  625,  278, -158, -210,    9,
  490,    0,    0,    0,    0,    0,   41,    0,   99,    0,
    0, -137,   -4, -133,    0,   -8,  588,    0,    0,   -1,
    0,    0,  317,    0,  -30,    0,    0,    0, -106,    0,
   37,  -17,    0,  320,  283,    0,    0,    0,  205,    0,
  277,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=981;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   66,  205,  166,  126,   65,   65,  169,   67,   65,   92,
   95,   89,   84,  211,  159,   65,   53,  250,  165,  187,
   53,   20,   91,  278,  163,   18,  287,  274,   93,  189,
    2,  224,  145,  146,   49,  225,  278,   49,  123,   19,
  121,  124,  127,  214,   65,   65,    6,  122,  125,  215,
   20,   49,   88,  124,   18,   87,   96,   87,   65,   65,
   53,  127,  259,  261,  201,   15,  298,  299,   19,   85,
   65,   94,  246,   20,  202,  161,   65,   18,  109,  156,
  163,  236,   45,  224,  224,  314,  244,  225,  225,   16,
   17,   19,   16,   17,   53,   53,  202,  138,   20,  261,
  139,  192,   18,  149,  105,  133,  140,  185,  150,   63,
  184,  152,   62,   20,   64,  108,   19,   18,  198,  200,
  224,   50,  112,  112,  225,  112,  162,  112,  143,  144,
  319,   19,  320,  321,  206,  178,   20,  208,  271,  112,
   18,  270,   65,   65,   65,   65,  147,  190,  148,   65,
  134,  111,  207,  141,   19,  232,  142,   20,  234,  155,
  226,   18,  132,  157,    1,  294,  133,  277,   63,  210,
  212,   62,  213,   64,  160,   19,  142,  164,   20,    5,
  277,  281,   18,  172,  224,  134,  173,  245,  225,   52,
  181,  317,   53,  318,   51,  209,   19,  216,   97,  176,
  177,   16,   17,  308,  248,  309,  323,   51,  182,  183,
  231,   12,  226,  226,  253,  249,  201,  166,   15,  247,
   90,  118,  167,   50,  286,   20,  202,  166,   58,  168,
  158,   16,   17,  165,  186,   83,  158,    7,    8,   85,
  121,  283,  119,  165,   65,    9,   10,  122,   20,  226,
   11,   12,   13,  123,   14,   15,  113,   16,   17,   16,
   17,   65,   65,  180,  289,  291,    7,    8,  124,   49,
   49,   85,   86,   85,    9,   10,  127,   20,   53,   11,
   12,   13,  235,   14,   15,   65,   16,   17,  305,  233,
    8,   16,   17,   16,   17,  163,   12,    9,   10,   20,
   45,   45,   11,   12,   13,  163,   14,   15,  221,   16,
   17,  157,  107,  226,    7,    8,  191,  129,  130,  131,
   90,   14,    9,   10,   59,   60,   61,   11,   12,   13,
    8,   14,   15,  260,   16,   17,  112,    9,   10,   14,
  147,   15,   11,   12,   13,   14,   14,   15,  110,   16,
   17,   63,  262,    8,   62,  154,   64,  263,   20,  115,
    9,   10,  288,   14,  150,   11,   12,   13,  293,   14,
   15,   20,   16,   17,    8,  300,   19,  128,  129,  130,
  131,    9,   10,   59,   60,   61,   11,   12,   13,   19,
   14,   15,  249,   16,   17,    8,   62,   16,   17,   20,
   50,   62,    9,   10,  147,   49,   14,   11,   12,   13,
   15,   14,   15,   50,   16,   17,   18,   19,  306,  307,
   20,  188,  133,   15,  264,   16,   17,  158,   12,  117,
   14,  100,  265,   20,   62,   12,   12,  284,   19,  272,
   12,  238,  217,   12,   12,   12,   12,  133,   20,    9,
   10,   19,  301,  112,   11,  104,  275,  218,  219,   15,
  220,   40,  119,  194,  196,  217,   19,  312,   20,  285,
  103,  292,    9,   10,  104,  302,  322,   11,  166,   20,
  218,  219,   15,  220,  295,   22,   19,  313,  122,  175,
   63,  252,  189,   62,  217,   64,    5,   19,  258,  193,
   22,    9,   10,  296,  194,  192,   11,  267,  157,  218,
  219,   15,  220,  190,   63,  101,  217,   62,  315,   64,
  157,  243,  304,    9,   10,  282,  325,   97,   11,  154,
   93,  218,  219,   15,  220,    0,    0,  147,   14,   98,
    0,   98,  290,   98,    0,   14,   14,   95,  147,  147,
   14,   90,   14,  316,   14,   14,  114,   98,   98,   98,
   98,  150,   14,    0,  324,  193,   59,   60,   61,   14,
   14,  257,  256,  150,   14,  237,   14,    0,   14,   14,
   87,   63,    9,   10,   62,  199,   64,   11,  237,   13,
  145,   14,   15,  154,  140,    9,   10,  162,    0,   99,
   11,   99,   13,   99,   14,   15,  146,  197,   59,   60,
   61,    0,  199,   59,   60,   61,  237,   99,   99,   99,
   99,  151,   63,    9,   10,   62,  116,   64,   11,   99,
   13,    0,   14,   15,  129,  130,  131,  237,    0,    0,
   76,   78,   77,    0,    9,   10,   59,   60,   61,   11,
  237,   13,    0,   14,   15,    0,    0,    9,   10,  129,
  130,  131,   11,    0,   13,  237,   14,   15,  102,   75,
    0,   63,    9,   10,   62,  165,   64,   11,    0,   13,
    0,   14,   15,   47,   48,  237,  174,  102,  251,   76,
   78,   77,    9,   10,    0,    0,  237,   11,   22,   13,
    0,   14,   15,    9,   10,  120,   60,   61,   11,  106,
   13,    0,   14,   15,  112,  112,  112,    0,  112,  303,
  112,  100,   15,  100,   97,  100,  154,   93,  123,   59,
   60,   61,  112,  112,  112,  112,   98,  154,  154,  100,
  100,  100,  100,    0,   95,    0,   15,   63,   90,    0,
   62,    0,   64,    0,   98,  147,  227,  148,   98,   98,
   98,    0,   98,   98,   98,   76,   78,   77,    0,  254,
  255,    0,   76,   78,   77,    0,    0,   87,   76,   78,
   77,    0,  199,  179,    0,    0,    0,  145,    0,    0,
    0,  140,    0,    0,  162,  195,   59,   60,   61,    0,
    0,    0,    0,  146,    0,    0,    0,    0,  227,  227,
    0,    0,    0,    0,   99,    0,    0,    0,   99,   99,
   99,   98,    0,    0,   99,  239,  239,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   59,   60,   61,
   72,   73,   74,    0,    0,  227,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  273,    0,  276,    0,    0,    0,  239,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   59,   60,   61,   72,
   73,   74,    0,    0,   98,    0,    0,    0,  276,    0,
    0,  297,  273,    0,    0,    0,    0,    0,    0,  227,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  273,    0,  276,  276,    0,    0,    0,    0,    0,  112,
    0,    0,    0,  112,  112,  112,  100,    0,  276,  112,
  100,  100,  100,    0,    0,    0,  100,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   59,   60,   61,   72,   73,   74,  153,    0,
    0,    0,   72,   73,   74,  266,    0,    0,   72,   73,
   74,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          8,
    9,   41,   41,   59,    9,   10,   41,    9,   13,   14,
   19,   13,   40,   58,   41,   20,    8,   58,   41,   41,
   12,   40,   59,  123,   41,   44,   59,  238,   40,  136,
  123,  169,   63,   64,   41,  169,  123,   44,   41,   58,
   49,   50,   51,  258,   49,   50,  123,   49,   50,  264,
   40,   58,   12,   41,   44,   40,   20,   40,   63,   64,
   52,   41,  221,  222,  256,  274,  277,  278,   58,  256,
   75,  257,  256,   40,  266,   58,   81,   44,   59,   81,
   41,  188,   58,  221,  222,  296,  256,  221,  222,  276,
  277,   58,  276,  277,   86,   87,  266,  257,   40,  258,
   58,   41,   44,   42,  123,   45,   41,   41,   47,   42,
   44,   75,   45,   40,   47,   59,   58,   44,  149,  150,
  258,   41,   42,   43,  258,   45,   86,   47,  258,  259,
  256,   58,  258,  259,  152,  125,   40,  155,   41,   59,
   44,   44,  147,  148,  149,  150,   43,  139,   45,  154,
   52,   59,  154,   59,   58,  173,   40,   40,  125,   41,
  169,   44,   41,   41,  257,  272,   45,  267,   42,  161,
  162,   45,  164,   47,  257,   58,   40,   58,   40,  256,
  267,  268,   44,   59,  322,   87,   41,  205,  322,   40,
   59,  256,  184,  258,   58,   41,   58,  258,  125,  256,
  257,  276,  277,   43,  258,   45,  313,   58,  258,  259,
   59,   40,  221,  222,  219,  256,  256,  256,  274,  211,
  257,  125,  257,  264,  257,   40,  266,  266,  237,  264,
   59,  276,  277,  256,  256,  263,  263,  256,  257,  256,
  249,  250,  125,  266,  249,  264,  265,  249,   40,  258,
  269,  270,  271,  256,  273,  274,   59,  276,  277,  276,
  277,  266,  267,  125,  266,  267,  256,  257,  256,  276,
  277,  256,  257,  256,  264,  265,  256,   40,  270,  269,
  270,  271,  184,  273,  274,  290,  276,  277,  290,  256,
  257,  276,  277,  276,  277,  256,  125,  264,  265,   40,
  276,  277,  269,  270,  271,  266,  273,  274,  123,  276,
  277,   59,  256,  322,  256,  257,  256,  257,  258,  259,
  257,   40,  264,  265,  257,  258,  259,  269,  270,  271,
  257,  273,  274,  125,  276,  277,  256,  264,  265,   58,
   59,  274,  269,  270,  271,   40,  273,  274,  256,  276,
  277,   42,   59,  257,   45,   79,   47,   59,   40,   59,
  264,  265,  125,   58,   59,  269,  270,  271,  270,  273,
  274,   40,  276,  277,  257,  268,   58,  256,  257,  258,
  259,  264,  265,  257,  258,  259,  269,  270,  271,   58,
  273,  274,  256,  276,  277,  257,   45,  276,  277,   40,
  264,   45,  264,  265,  123,  256,  125,  269,  270,  271,
  274,  273,  274,  264,  276,  277,   44,   58,  258,  259,
   40,   44,   45,  274,   59,  276,  277,  256,  257,   59,
  125,   59,   59,   40,   45,  264,  265,   59,   58,   44,
  269,  123,  257,  272,  273,  274,  275,   45,   40,  264,
  265,   58,  268,  256,  269,   44,  125,  272,  273,  274,
  275,   58,   59,  147,  148,  257,   58,   41,   40,   59,
   59,   59,  264,  265,   44,   59,   41,  269,   59,   40,
  272,  273,  274,  275,  125,   44,   58,   44,   59,   59,
   42,   59,   59,   45,  257,   47,    0,   58,  221,   59,
   59,  264,  265,  123,   59,   59,  269,  231,  256,  272,
  273,  274,  275,   59,   42,   26,  257,   45,  125,   47,
  268,  202,   59,  264,  265,  243,  322,   59,  269,   59,
   59,  272,  273,  274,  275,   -1,   -1,  256,  257,   41,
   -1,   43,  266,   45,   -1,  264,  265,   59,  267,  268,
  269,   59,  271,  125,  273,  274,  256,   59,   60,   61,
   62,  256,  257,   -1,  125,  256,  257,  258,  259,  264,
  265,   58,   59,  268,  269,  257,  271,   -1,  273,  274,
   59,   42,  264,  265,   45,   59,   47,  269,  257,  271,
   59,  273,  274,  123,   59,  264,  265,   59,   -1,   41,
  269,   43,  271,   45,  273,  274,   59,  256,  257,  258,
  259,   -1,  256,  257,  258,  259,  257,   59,   60,   61,
   62,   41,   42,  264,  265,   45,  256,   47,  269,  257,
  271,   -1,  273,  274,  257,  258,  259,  257,   -1,   -1,
   60,   61,   62,   -1,  264,  265,  257,  258,  259,  269,
  257,  271,   -1,  273,  274,   -1,   -1,  264,  265,  257,
  258,  259,  269,   -1,  271,  257,  273,  274,  257,   40,
   -1,   42,  264,  265,   45,  256,   47,  269,   -1,  271,
   -1,  273,  274,    5,    6,  257,  256,  257,  256,   60,
   61,   62,  264,  265,   -1,   -1,  257,  269,  257,  271,
   -1,  273,  274,  264,  265,  257,  258,  259,  269,   31,
  271,   -1,  273,  274,   41,   42,   43,   -1,   45,  256,
   47,   41,  274,   43,  256,   45,  256,  256,  256,  257,
  258,  259,   59,   60,   61,   62,   21,  267,  268,   59,
   60,   61,   62,   -1,  256,   -1,  274,   42,  256,   -1,
   45,   -1,   47,   -1,  256,   43,  169,   45,  260,  261,
  262,   -1,   47,   48,  266,   60,   61,   62,   -1,  256,
  257,   -1,   60,   61,   62,   -1,   -1,  256,   60,   61,
   62,   -1,  256,  105,   -1,   -1,   -1,  256,   -1,   -1,
   -1,  256,   -1,   -1,  256,  256,  257,  258,  259,   -1,
   -1,   -1,   -1,  256,   -1,   -1,   -1,   -1,  221,  222,
   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,
  262,  106,   -1,   -1,  266,  201,  202,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,  258,  259,
  260,  261,  262,   -1,   -1,  258,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  238,   -1,  240,   -1,   -1,   -1,  244,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  257,  258,  259,  260,
  261,  262,   -1,   -1,  179,   -1,   -1,   -1,  274,   -1,
   -1,  277,  278,   -1,   -1,   -1,   -1,   -1,   -1,  322,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  296,   -1,  298,  299,   -1,   -1,   -1,   -1,   -1,  256,
   -1,   -1,   -1,  260,  261,  262,  256,   -1,  314,  266,
  260,  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  257,  258,  259,  260,  261,  262,  256,   -1,
   -1,   -1,  260,  261,  262,  257,   -1,   -1,  260,  261,
  262,
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
"control : error_control",
"error_control : FOR '(' ')' bloque_for",
"incr_decr : '+' CTE_INT",
"incr_decr : '-' CTE_INT",
"incr_decr : error_incr_decr",
"error_incr_decr : CTE_INT",
"error_incr_decr : '-' error",
"error_incr_decr : '+' error",
"error_incr_decr : CTE_FLOTANTE",
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

//#line 704 "gramatica.y"

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

//#line 809 "Parser.java"
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
								        ambito = ambito.substring(0,ambito.lastIndexOf("."));
                            }
break;
case 30:
//#line 109 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 110 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 111 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 33:
//#line 114 "gramatica.y"
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
//#line 139 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 140 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 141 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 142 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 143 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
//#line 146 "gramatica.y"
{lista_parametros.clear();
                              yyval = new ParserVal(lista_parametros);}
break;
case 41:
//#line 148 "gramatica.y"
{lista_parametros.clear();
                                     			     lista_parametros.add(val_peek(1).sval);
                                     			     yyval = new ParserVal(lista_parametros);}
break;
case 42:
//#line 151 "gramatica.y"
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
//#line 162 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 163 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 164 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
//#line 167 "gramatica.y"
{String nuevoAmbitoId = val_peek(0).sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo(val_peek(0).sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo(val_peek(1).sval);
                    atributos.setUso("nombreParametro");
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    yyval = new ParserVal(nuevoAmbitoId);}
break;
case 49:
//#line 177 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 178 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 181 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("i32");}
break;
case 52:
//#line 183 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("f32");}
break;
case 53:
//#line 187 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 188 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if(val_peek(1).arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    yyval.arbol = new NodoInvocacion(val_peek(1).arbol,null,lexDiscard);
	                                }
	                                }
break;
case 55:
//#line 194 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 56:
//#line 195 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 196 "gramatica.y"
{ if (val_peek(1).arbol!=null){
	                                String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                    if(ambitoCheck != null){
                                        Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval+"."+ambito);
                                        Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval+"."+ambito).setUso("nombreEtiqueta");
                                        AtributosTablaS lexEtiqueta = new AtributosTablaS("Etiqueta");
                                        yyval.arbol = new NodoEtiquetado(new NodoHoja(atributos),val_peek(1).arbol,lexEtiqueta);
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+val_peek(3).sval+"' en algun ambito alcanzable");
                                }else
                                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " sentencia de control mal definida");
                                }
break;
case 58:
//#line 209 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 59:
//#line 210 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 61:
//#line 214 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
//#line 215 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
//#line 216 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
//#line 217 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
//#line 218 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
//#line 219 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
//#line 220 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
//#line 221 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
//#line 222 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
//#line 223 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
//#line 224 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
//#line 227 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 73:
//#line 228 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(val_peek(1).arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               yyval.arbol = new NodoInvocacion(val_peek(1).arbol,null,lexDiscard);
                                           }
                                           }
break;
case 74:
//#line 234 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 75:
//#line 235 "gramatica.y"
{  if (val_peek(1).arbol!=null){
                                            String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                            if(ambitoCheck != null){
                                                Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                                AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval+"."+ambito);
                                                Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval+"."+ambito).setUso("nombreEtiqueta");
                                                AtributosTablaS lexEtiqueta = new AtributosTablaS("Etiqueta");
                                                yyval.arbol = new NodoEtiquetado(new NodoHoja(atributos),val_peek(1).arbol,lexEtiqueta);
                                            }else
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+val_peek(3).sval+"' en algun ambito alcanzable");
                                        }else
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " sentencia de control mal definida");
                                     }
break;
case 76:
//#line 248 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 77:
//#line 249 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 78:
//#line 250 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              yyval.arbol = new NodoHoja(sentenciaBreak);}
break;
case 79:
//#line 253 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("Continue");
                                yyval.arbol = new NodoHoja(sentenciaContinue);}
break;
case 80:
//#line 256 "gramatica.y"
{/*String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito($3.sval,ambito);*/
                                        /*if(ambitoCheck != null){*/
                                            Main.tablaDeSimbolos.modificarSimbolo(val_peek(1).sval,val_peek(1).sval+"."+ambito);
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval+"."+ambito);
                                            Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval+"."+ambito).setUso("referenciaAEtiqueta");
                                            Main.tablaDeSimbolos.setAtributosDeSimbolo(val_peek(1).sval+"."+ambito, atributos);
                                            AtributosTablaS sentenciaContinue =  new AtributosTablaS("Continue con etiquetado");
                                            yyval.arbol = new NodoEtiquetado(new NodoHoja(atributos),null,sentenciaContinue);
                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +val_peek(1).sval);
                                      /* }
                                        else{
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+$3.sval+"' en algun ambito alcanzable");
                                            $$.arbol = null;
                                        }*/
                                        }
break;
case 82:
//#line 274 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 83:
//#line 275 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
//#line 276 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
//#line 277 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
//#line 278 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 87:
//#line 281 "gramatica.y"
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
case 88:
//#line 300 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                   AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                   Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito).setUso("Variable");
                                   AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                   yyval.arbol= new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                   }
break;
case 90:
//#line 309 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 91:
//#line 310 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
//#line 311 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 93:
//#line 312 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 94:
//#line 313 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 95:
//#line 316 "gramatica.y"
{ AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                        yyval.arbol = new NodoRetorno(val_peek(0).arbol,null,retorno);
                                      }
break;
case 97:
//#line 322 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 98:
//#line 325 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 99:
//#line 326 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                                 }
break;
case 100:
//#line 331 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                                                    }
break;
case 102:
//#line 338 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 103:
//#line 339 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 104:
//#line 342 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol,atributos);
                             }
break;
case 105:
//#line 346 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          }
break;
case 106:
//#line 350 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 108:
//#line 354 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 109:
//#line 355 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 110:
//#line 356 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 111:
//#line 357 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 112:
//#line 360 "gramatica.y"
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
case 113:
//#line 373 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        yyval.arbol = new NodoHoja(atributos);
                       }
break;
case 114:
//#line 376 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setTipo("i32");
                        yyval.arbol = new NodoHoja(atributos);
                        }
                   }
break;
case 115:
//#line 382 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 116:
//#line 386 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       yyval.arbol = new NodoHoja(atributos);
                       }
                      }
break;
case 117:
//#line 391 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               yyval.arbol = new NodoHoja(atributos);
                               }
                           }
break;
case 118:
//#line 398 "gramatica.y"
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
case 119:
//#line 433 "gramatica.y"
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
case 121:
//#line 451 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 122:
//#line 452 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 123:
//#line 455 "gramatica.y"
{ if(val_peek(0).arbol !=null){
                                            AtributosTablaS lexParam = new AtributosTablaS("Un Parametro");
                                            yyval.arbol = new NodoParam(val_peek(0).arbol,null,lexParam);
                                        }
                                        else
                                            yyval.arbol = null;
                                        }
break;
case 124:
//#line 462 "gramatica.y"
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
case 126:
//#line 474 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 127:
//#line 475 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 128:
//#line 476 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 129:
//#line 479 "gramatica.y"
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
case 130:
//#line 491 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                    lista_parametros_reales.clear();
                                    lista_parametros_reales.add(val_peek(0).sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                    yyval.arbol = new NodoHoja(atributos);
                                   }
break;
case 131:
//#line 497 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                                   lista_parametros_reales.clear();
                                   lista_parametros_reales.add(val_peek(0).sval);
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                   yyval.arbol = new NodoHoja(atributos);
                               }
                               }
break;
case 132:
//#line 505 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                  }
break;
case 133:
//#line 510 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                       }
break;
case 134:
//#line 516 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);}
break;
case 136:
//#line 522 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 137:
//#line 523 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 138:
//#line 524 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 139:
//#line 525 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 140:
//#line 526 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 141:
//#line 529 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    }
break;
case 142:
//#line 532 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                }
break;
case 144:
//#line 538 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 145:
//#line 539 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 146:
//#line 540 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 147:
//#line 544 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);}
break;
case 148:
//#line 546 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          yyval.arbol = new NodoCuerpoThen(val_peek(1).arbol,null,atributos);}
break;
case 150:
//#line 551 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             yyval.arbol = new NodoCuerpoElse(val_peek(0).arbol,null,atributos);}
break;
case 151:
//#line 553 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                yyval.arbol = new NodoCuerpoElse(val_peek(1).arbol,null,atributos);}
break;
case 153:
//#line 558 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 154:
//#line 559 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 155:
//#line 562 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 156:
//#line 563 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 157:
//#line 564 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 158:
//#line 567 "gramatica.y"
{ yyval.arbol = val_peek(0).arbol;}
break;
case 159:
//#line 568 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 161:
//#line 572 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 162:
//#line 573 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 163:
//#line 577 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 165:
//#line 583 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 166:
//#line 584 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 167:
//#line 585 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 168:
//#line 588 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 169:
//#line 589 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 170:
//#line 590 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 171:
//#line 591 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 172:
//#line 592 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 173:
//#line 593 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 174:
//#line 596 "gramatica.y"
{if((val_peek(6).arbol != null)&&(val_peek(4).arbol != null)&&(val_peek(2).arbol != null)){
                                                                                  Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                  AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                  AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                  AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                  ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor(val_peek(0).arbol,null,lexCuerpoFor);
                                                                                  ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor(val_peek(6).arbol,val_peek(4).arbol,lexEncabezadoFor),val_peek(2).arbol,lexEncabezadoFor);
                                                                                  yyval.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                }
                                                                                else
                                                                                    yyval.arbol = null;
                                                                              }
break;
case 175:
//#line 608 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 176:
//#line 611 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 177:
//#line 614 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 178:
//#line 617 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 179:
//#line 620 "gramatica.y"
{ yyval.arbol = null;}
break;
case 180:
//#line 623 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 181:
//#line 624 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 182:
//#line 625 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 183:
//#line 626 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
break;
case 184:
//#line 627 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
break;
case 185:
//#line 630 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                        if(ambitoCheck != null){
                                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                            if(tipoId.equals("i32")){
                                                if (chequearRangoEnteros()==true){
                                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                                    Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                    AtributosTablaS atributos2 = new AtributosTablaS("Asignacion FOR");
                                                    AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                                    NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributos),new NodoHoja(atributos3),atributos2);
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
case 187:
//#line 665 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 188:
//#line 666 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 189:
//#line 667 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 190:
//#line 670 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                                   if(ambitoCheck != null){
                                                       Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                       AtributosTablaS atributos = new AtributosTablaS("CondicionFOR");
                                                       AtributosTablaS atributos2 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval);
                                                       AtributosTablaS atributos3 = new AtributosTablaS(val_peek(1).sval);
                                                       yyval.arbol = new NodoCondicionFor(new NodoExpresionLogica(new NodoHoja(atributos2),val_peek(0).arbol,atributos3),null,atributos);
                                                   }
                                                   else{
                                                       Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no existe el id "+ val_peek(2).sval +" en ningun ambito alcanzable. Imposible determinar rango de control");
                                                       yyval.arbol = null;
                                                   }
                                                   }
break;
case 192:
//#line 686 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 193:
//#line 687 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 194:
//#line 688 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 195:
//#line 691 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 197:
//#line 699 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 198:
//#line 700 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 199:
//#line 701 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 2014 "Parser.java"
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
