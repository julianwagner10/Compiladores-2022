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
import java.util.Stack;
import java.util.*;

//#line 25 "Parser.java"




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
    6,    6,   28,   28,   28,   28,   28,   28,   28,   28,
    8,    8,    8,    8,    8,    8,    8,    8,    8,   29,
   29,   29,   29,   29,   30,   22,   22,   22,   32,   32,
   32,   32,   32,   25,   25,   33,   31,   31,   31,   31,
   35,   35,   34,   34,   34,   34,   37,   37,   37,   37,
   36,   36,   36,   36,   36,   36,   23,   23,   23,   39,
   39,   38,   38,   38,   41,   41,   41,   40,   40,   40,
   40,   40,   24,   24,   44,   44,   44,   44,   44,   43,
   43,   43,   47,   47,   47,   45,   45,   45,   46,   46,
   46,   48,   48,   49,   49,   49,   50,   50,   50,   51,
   51,   42,   42,   53,   53,   53,   52,   52,   52,   52,
   52,   52,   26,   26,   26,   57,   56,   56,   56,   58,
   58,   58,   58,   58,   54,   54,   59,   59,   59,   55,
   55,   60,   60,   60,   27,   27,   61,   61,   61,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    2,    2,
    4,    1,    2,    2,    2,    2,    2,    2,    3,    2,
    2,    3,    2,    2,    2,    2,    2,    4,    1,    2,
    2,    3,    3,    4,    2,    3,    3,    1,    3,    3,
    3,    2,    2,    2,    1,    1,    1,    3,    3,    1,
    3,    3,    3,    3,    1,    1,    3,    3,    2,    2,
    1,    1,    1,    1,    2,    2,    4,    3,    1,    4,
    3,    1,    3,    1,    2,    5,    7,    1,    1,    1,
    2,    2,    5,    1,    4,    4,    4,    4,    5,    3,
    4,    1,    4,    2,    3,    1,    3,    1,    2,    4,
    1,    2,    2,    3,    3,    3,    1,    3,    1,    2,
    2,    3,    1,    2,    2,    2,    1,    1,    1,    1,
    1,    1,    9,   10,    1,    4,    2,    2,    1,    1,
    2,    2,    2,    2,    3,    1,    2,    2,    2,    3,
    1,    2,    2,    2,    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   52,   51,    0,
    0,    0,    6,    8,   10,   11,    0,    0,   17,   18,
   24,    0,   29,   34,    0,    0,    0,    0,    0,    0,
   62,    0,   88,   95,  119,  134,  175,  196,    0,    0,
    0,    0,   85,    0,    0,    0,    0,   43,   48,    0,
  113,  112,    0,    0,    0,  114,   93,    0,    0,  100,
  105,  106,    0,  171,  170,  172,    0,  167,  168,  169,
    0,    0,    0,  163,    0,    0,    0,    0,    0,    0,
    0,   59,    0,   68,    0,    0,   60,    0,   26,    0,
    3,    7,   22,   21,    0,   25,   20,    0,    0,    0,
   63,   53,   70,   64,   55,   67,   56,   65,   57,   66,
   58,    0,    4,    1,    0,   90,    0,   91,   87,    0,
    0,  128,  130,  129,    0,    0,    0,    0,    0,  124,
   47,    0,   44,    0,  115,  116,  109,  110,    0,    0,
    0,    0,    0,    0,  166,    0,    0,    0,  197,    0,
  198,   50,    0,    0,   40,    0,   69,   54,    0,    0,
    0,    0,  186,    0,    0,   19,   16,   27,   23,   32,
    0,   30,    0,  131,  132,    0,   41,  120,  117,    0,
  125,   35,  121,  118,  101,    0,  102,    0,  107,  103,
  108,  104,    0,    0,  137,  142,    0,  138,    0,  136,
  195,   37,    0,   38,   36,  188,    0,  187,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   79,
  176,  159,    0,   61,  135,   31,   28,    0,    0,    0,
    0,    0,    0,    0,    0,  148,    0,    0,  133,   39,
   33,  185,    0,   80,   76,    0,   81,    0,   77,    0,
    0,   12,  160,   13,   71,   73,   74,   75,    0,    0,
    0,  191,    0,    0,   42,    0,   14,    0,  152,   15,
    0,    0,    0,  151,  140,    0,   72,   82,    0,   83,
  158,    0,    0,    0,    0,    0,    0,    0,  147,    0,
    0,    0,    0,  143,  141,   84,   78,    0,  180,    0,
    0,    0,  179,    0,   46,    0,    0,  155,  154,  182,
  177,  183,  181,  178,  184,    0,    0,  127,  150,  173,
    0,  174,
};
final static short yydgoto[] = {                          3,
   22,    4,   23,   24,   25,   26,  224,  225,  244,   27,
   28,   29,   30,   31,   32,   33,   56,   34,   57,   58,
   59,   35,   36,   37,   38,   39,   40,   41,  230,   42,
   81,   43,   44,   69,   70,   71,   72,  138,   45,  139,
  140,   82,  205,   46,  245,  283,  206,  246,  284,  231,
  232,   83,   84,  172,  271,  312,   47,  313,  173,  272,
   48,
};
final static short yysindex[] = {                       -91,
  -73,   78,    0,    0,   78,   78,    0,   -6,  403,  743,
   -4,   -3,  629,  -19,  -10,   11,   71,    0,    0, -182,
  789,   99,    0,    0,    0,    0,   83,  110,    0,    0,
    0,  -37,    0,    0,  -34,   28,   55,  102,  106,  130,
    0, -159,    0,    0,    0,    0,    0,    0,  120,  142,
  515,  483,    0,   47, -178,   63,   84,    0,    0,   54,
    0,    0,  -60,  439,  439,    0,    0,   68,   81,    0,
    0,    0,   93,    0,    0,    0,  768,    0,    0,    0,
  668,   94,  629,    0,  100,  -32,  -89,   -1,   60,  126,
   68,    0,   93,    0,  213,   50,    0,  -77,    0,  147,
    0,    0,    0,    0,  131,    0,    0,  153,   25,  166,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  155,    0,    0,   54,    0,   68,    0,    0,   68,
  -89,    0,    0,    0,    0,  170,   96,  -27,  168,    0,
    0,  199,    0,  122,    0,    0,    0,    0,  583,  597,
  215,  464, -225,  -15,    0,  629, -225,   68,    0,  151,
    0,    0,  199,   16,    0,  199,    0,    0, -181,  -57,
  416,  145,    0,  150, -225,    0,    0,    0,    0,    0,
   56,    0, -140,    0,    0, -195,    0,    0,    0,  587,
    0,    0,    0,    0,    0,   81,    0,   81,    0,    0,
    0,    0,  243,  243,    0,    0, -193,    0,   68,    0,
    0,    0, -167,    0,    0,    0,  -40,    0,  101,  302,
  -36,  144,  481,  430,    0,  301,  323,  344,  363,    0,
    0,    0,  622,    0,    0,    0,    0,  374,  112,  405,
  -39,  443,    0,  299,  -88,    0,  -90,  243,    0,    0,
    0,    0,  403,    0,    0,  398,    0,  409,    0,    9,
  462,    0,    0,    0,    0,    0,    0,    0,  789,  629,
  432,    0,  622, -195,    0,  587,    0,  319,    0,    0,
  343,  443,  185,    0,    0,  231,    0,    0,  373,    0,
    0,   68,  629,   68,   52,  442,  469,  459,    0,  443,
    0,  362,  381,    0,    0,    0,    0,   68,    0,  -65,
  -51,  470,    0,   52,    0,  587,  394,    0,    0,    0,
    0,    0,    0,    0,    0,  416,  479,    0,    0,    0,
  416,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  141,    0,    0,
    0,    0,  392,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  505,
    0,    0,    0,    0,  -20,    0,    0,    0,    0,   89,
    0,    0,    0,    0,    0,    0,    0,  393,  536,    0,
    0,    0,  717,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  401,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -30,    0,  408,    0,    0,  422,
  463,    0,    0,    0,  421,    0,   32,    0,  -14,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   12,    0,   13,    0,  423,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  561,    0,  706,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   21,    0,
    0,    0,    0,    0,    0,    0,  467,    0,    0,    0,
    0,    0,    0,    0,  279,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   29,
    0,    0,  221,    0,    0,    0,  445,  454,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  468,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  282,    0,    0,
    0,    0,    0,    0,    0,  487,    0,    0,    0,    0,
    0,  472,  473,  474,    0,    0,    0,   62,    0,    0,
  190,    0,    0,    0,    0,    0,    0,  475,    0,    0,
    0,    0,    0,    0,    0,    0,  152,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,
};
final static short yygindex[] = {                         0,
   61,    0,    6,    0,    0,  615,  306,  300, -162,   10,
  510,    0,    0,    0,    0,    0,   18,    0,  -31,    0,
    0,  577,   -5,  609,    0,   -9,  624,    0,    0,    0,
   -7,    0,    0,  348,    0,   20,    0,    0,    0, -119,
    0,   27,  -49,    0,  336,  294,    0,    0,    0, -224,
    0,  591,    0,  359,  272,  233,    0,    0,    0,    0,
    0,
};
final static int YYTABLESIZE=1051;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         67,
  144,   68,   21,   66,   66,   91,   20,   66,  161,   95,
   50,  111,  111,  189,  111,   66,  111,   55,   53,  191,
   49,   55,  137,   49,  112,  207,  122,  102,  111,   90,
  203,    2,  282,   54,  282,   86,   89,   49,   89,   92,
  204,  126,  129,  127,  130,   66,   66,  100,   94,    6,
   96,   53,  165,  164,  102,  102,  163,  137,   66,   66,
   87,  162,  248,   55,   21,   49,   50,  290,   20,  123,
  240,   66,  204,  213,   99,  158,  216,   66,  141,  278,
   18,   19,  217,  147,  148,  109,  113,  135,  250,   45,
  171,  136,  110,  144,  310,   21,  311,   55,   55,   20,
  165,  330,  126,  154,  208,  164,  332,  210,   18,   19,
  149,   53,  150,  115,  122,  102,  169,   21,  302,  303,
  142,   20,  151,  170,  143,  235,   20,  152,   98,   97,
  111,  111,  144,  111,  157,  111,  187,  317,   21,  186,
  159,  104,   20,   66,   66,   66,   66,  111,  209,  180,
   66,  192,  275,  108,  239,  274,  298,  249,   53,   21,
  117,  228,  194,   20,  119,    1,  136,  162,  107,  181,
  200,  202,  212,  214,  108,  215,  281,  285,  281,  174,
  237,   21,    5,  166,   22,   20,  102,  175,  121,  177,
  320,  211,  321,  322,  183,   55,  328,  145,  146,   22,
  218,  260,  259,  233,  323,   21,  324,  325,  234,   20,
  156,  190,  136,  228,  228,  256,  253,  252,    7,    8,
   93,  111,  251,  101,   52,  111,    9,   10,  188,   14,
  160,   11,   12,   13,   14,   15,   16,   17,   18,   19,
  203,  122,  297,  126,  123,  127,   93,   66,  149,   51,
  204,  228,   87,   88,   87,   49,   49,   52,   85,   63,
   14,  292,  294,   66,   66,  289,  124,  165,  164,   18,
   19,  168,   18,   19,   18,   19,  162,  165,  164,  146,
    7,    8,   21,   55,  123,  308,  162,   66,    9,   10,
  182,   18,   19,   11,   12,   13,   14,   15,   16,   17,
   18,   19,  131,  132,  133,  134,  169,   45,   45,  309,
  114,  236,    8,  170,   14,   87,  228,  126,   12,    9,
   10,  228,   18,   19,   11,   12,   13,   14,   15,   16,
   17,   18,   19,    7,    8,   18,   19,  157,   21,  103,
  153,    9,   10,  146,  111,   14,   11,   12,   13,   14,
   15,   16,   17,   18,   19,    8,  253,  116,   21,  265,
  255,  118,    9,   10,   52,  242,  106,   11,   12,   13,
   14,   15,   16,   17,   18,   19,    8,  193,  132,  133,
  134,  266,   21,    9,   10,  120,  176,  106,   11,   12,
   13,   14,   15,   16,   17,   18,   19,   22,    8,  257,
  258,   21,  267,   12,  153,    9,   10,  156,  178,  179,
   11,   12,   13,   14,   15,   16,   17,   18,   19,  156,
   21,  268,    8,  279,  132,  133,  134,  184,  185,    9,
   10,  307,  273,   21,   11,   12,   13,   14,   15,   16,
   17,   18,   19,  299,   64,  149,   14,   63,  276,   65,
   96,   92,  304,   14,   14,   21,  287,  149,   14,   94,
   14,   14,   14,   14,   14,  300,   89,  288,  167,   21,
  199,   73,   61,   62,   18,   19,  146,   14,   40,  118,
   86,  199,   21,   63,   14,   14,  318,  146,  146,   14,
  295,   14,   14,   14,   14,   14,  196,  198,  305,  241,
  314,   21,  316,  144,    5,  319,    9,   10,   63,  315,
  326,   11,  139,   13,   14,   15,   16,   17,  329,  331,
   21,  121,  262,  264,   64,  189,  161,   63,  261,   65,
  193,  194,  192,  190,  157,   12,  105,  153,  223,  247,
  286,  238,   12,   12,  296,  145,  327,   12,  153,  153,
   12,   12,   12,   12,  263,  241,   64,  254,    0,   63,
  264,   65,    9,   10,    0,    0,    0,   11,    0,   13,
   14,   15,   16,   17,    0,  241,   97,    0,   97,    0,
   97,    0,    9,   10,    0,    0,  291,   11,    0,   13,
   14,   15,   16,   17,   97,   97,   97,   97,    0,  241,
    0,   98,    0,   98,    0,   98,    9,   10,    0,    0,
    0,   11,    0,   13,   14,   15,   16,   17,  241,   98,
   98,   98,   98,    0,   64,    9,   10,   63,  306,   65,
   11,  136,   13,   14,   15,   16,   17,  241,   64,    0,
    0,   63,    0,   65,    9,   10,    0,   96,   92,   11,
  241,   13,   14,   15,   16,   17,   94,    9,   10,   60,
   61,   62,   11,   89,   13,   14,   15,   16,   17,    0,
   64,  156,  219,   63,    0,   65,   16,   86,  199,    9,
   10,   78,   80,   79,   11,    0,  219,  220,  221,   16,
  222,    0,    0,    9,   10,   73,   61,   62,   11,  241,
  144,  220,  221,   16,  222,    0,    9,   10,    0,  139,
  149,   11,  150,   13,   14,   15,   16,   17,  219,  201,
   73,   61,   62,  161,    0,    9,   10,   78,   80,   79,
   11,    0,    0,  220,  221,   16,  222,  219,  128,   60,
   61,   62,  145,    0,    9,   10,   99,  226,   99,   11,
   99,    0,  220,  221,   16,  222,   16,  111,  111,  111,
    0,  111,    0,  111,   99,   99,   99,   99,    0,    0,
    0,  125,   61,   62,    0,  111,  111,  111,  111,  227,
    0,    0,   77,    0,   64,    0,    0,   63,   16,   65,
    0,   97,    0,    0,  229,   97,   97,   97,    0,  226,
  226,   97,   78,   80,   79,    0,    0,    0,  153,   64,
    0,    0,   63,    0,   65,    0,   98,  243,  243,    0,
   98,   98,   98,  270,    0,    0,   98,   78,   80,   79,
   64,  227,  227,   63,    0,   65,    0,  226,  195,   73,
   61,   62,    0,  132,  133,  134,  229,  229,   78,   80,
   79,    0,  197,   73,   61,   62,  277,    0,  280,  293,
    0,    0,  243,  270,    0,    0,    0,    0,    0,  227,
    0,    0,    0,    0,    0,    0,    0,    0,  269,    0,
    0,   74,   75,   76,  229,   73,   61,   62,    0,    0,
    0,    0,  280,    0,    0,  301,  277,    0,    0,    0,
    0,    0,  226,    0,    0,    0,    0,  226,    0,    0,
    0,    0,    0,    0,  277,    0,  280,  280,    0,    0,
    0,    0,    0,  155,    0,    0,    0,   74,   75,   76,
    0,  280,    0,    0,  227,    0,    0,    0,    0,  227,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  229,
    0,    0,    0,    0,  229,    0,    0,    0,    0,    0,
    0,   99,    0,    0,    0,   99,   99,   99,    0,    0,
    0,   99,  111,    0,    0,    0,  111,  111,  111,    0,
    0,    0,  111,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   73,
   61,   62,   74,   75,   76,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   73,   61,   62,   74,   75,   76,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   73,   61,   62,   74,   75,
   76,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   40,    9,   40,    9,   10,   13,   44,   13,   41,   15,
   41,   42,   43,   41,   45,   21,   47,    8,   58,  139,
   41,   12,   54,   44,   59,   41,   41,   22,   59,   12,
  256,  123,  123,   40,  123,   40,   40,   58,   40,   59,
  266,   51,   52,   51,   52,   51,   52,   21,   59,  123,
   40,   58,   41,   41,   49,   50,   58,   89,   64,   65,
  256,   41,  256,   54,   40,    5,    6,   59,   44,   41,
  190,   77,  266,   58,  257,   83,  258,   83,  257,  242,
  276,  277,  264,   64,   65,  123,   59,   41,  256,   58,
   41,   45,   32,   40,   43,   40,   45,   88,   89,   44,
   41,  326,   41,   77,  154,   88,  331,  157,  276,  277,
   43,   58,   45,   59,  274,  110,  257,   40,  281,  282,
   58,   44,   42,  264,   41,  175,   44,   47,   58,   59,
   42,   43,   40,   45,   41,   47,   41,  300,   40,   44,
   41,   59,   44,  149,  150,  151,  152,   59,  156,  125,
  156,  142,   41,   44,  186,   44,  276,  207,   58,   40,
   59,  171,   41,   44,   59,  257,   45,  257,   59,  109,
  151,  152,  163,  164,   44,  166,  267,  268,  267,  257,
  125,   40,  256,   58,   44,   44,  181,   41,   59,   59,
  256,   41,  258,  259,   40,  186,  316,  258,  259,   59,
  258,   58,   59,   59,  256,   40,  258,  259,   59,   44,
   59,   44,   45,  223,  224,  221,  256,  258,  256,  257,
  257,  256,  213,  125,  264,  256,  264,  265,  256,   40,
  263,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  256,  256,  274,  253,  125,  253,  257,  253,   59,  256,
  266,  261,  256,  257,  256,  276,  277,  264,  263,   45,
   40,  269,  270,  269,  270,  257,  125,  256,  256,  276,
  277,   59,  276,  277,  276,  277,  256,  266,  266,   59,
  256,  257,   40,  274,  256,  293,  266,  293,  264,  265,
  125,  276,  277,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  256,  257,  258,  259,  257,  276,  277,  258,
  256,  256,  257,  264,  125,  256,  326,  256,   40,  264,
  265,  331,  276,  277,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  256,  257,  276,  277,   59,   40,  257,
   59,  264,  265,  123,  256,  125,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  257,  256,  256,   40,   59,
   59,  256,  264,  265,  264,  123,  257,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  257,  256,  257,  258,
  259,   59,   40,  264,  265,  256,  256,  257,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  257,  257,  256,
  257,   40,   59,  125,  123,  264,  265,  256,  256,  257,
  269,  270,  271,  272,  273,  274,  275,  276,  277,  268,
   40,   59,  257,  125,  257,  258,  259,  258,  259,  264,
  265,   59,   59,   40,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  125,   42,  256,  257,   45,   44,   47,
   59,   59,  268,  264,  265,   40,   59,  268,  269,   59,
  271,  272,  273,  274,  275,  123,   59,   59,  256,   40,
  256,  257,  258,  259,  276,  277,  256,  257,   58,   59,
   59,   59,   40,   45,  264,  265,  125,  267,  268,  269,
   59,  271,  272,  273,  274,  275,  149,  150,  268,  257,
   59,   40,   44,   59,    0,  125,  264,  265,   45,   41,
   41,  269,   59,  271,  272,  273,  274,  275,  125,   41,
   40,   59,  223,  224,   42,   59,   59,   45,  223,   47,
   59,   59,   59,   59,  256,  257,   27,  256,  123,  204,
  247,  183,  264,  265,  273,   59,  314,  269,  267,  268,
  272,  273,  274,  275,  125,  257,   42,  256,   -1,   45,
  261,   47,  264,  265,   -1,   -1,   -1,  269,   -1,  271,
  272,  273,  274,  275,   -1,  257,   41,   -1,   43,   -1,
   45,   -1,  264,  265,   -1,   -1,  125,  269,   -1,  271,
  272,  273,  274,  275,   59,   60,   61,   62,   -1,  257,
   -1,   41,   -1,   43,   -1,   45,  264,  265,   -1,   -1,
   -1,  269,   -1,  271,  272,  273,  274,  275,  257,   59,
   60,   61,   62,   -1,   42,  264,  265,   45,  256,   47,
  269,   45,  271,  272,  273,  274,  275,  257,   42,   -1,
   -1,   45,   -1,   47,  264,  265,   -1,  256,  256,  269,
  257,  271,  272,  273,  274,  275,  256,  264,  265,  257,
  258,  259,  269,  256,  271,  272,  273,  274,  275,   -1,
   42,   81,  257,   45,   -1,   47,  274,  256,  256,  264,
  265,   60,   61,   62,  269,   -1,  257,  272,  273,  274,
  275,   -1,   -1,  264,  265,  257,  258,  259,  269,  257,
  256,  272,  273,  274,  275,   -1,  264,  265,   -1,  256,
   43,  269,   45,  271,  272,  273,  274,  275,  257,  256,
  257,  258,  259,  256,   -1,  264,  265,   60,   61,   62,
  269,   -1,   -1,  272,  273,  274,  275,  257,  256,  257,
  258,  259,  256,   -1,  264,  265,   41,  171,   43,  269,
   45,   -1,  272,  273,  274,  275,  274,   41,   42,   43,
   -1,   45,   -1,   47,   59,   60,   61,   62,   -1,   -1,
   -1,  257,  258,  259,   -1,   59,   60,   61,   62,  171,
   -1,   -1,   40,   -1,   42,   -1,   -1,   45,  274,   47,
   -1,  256,   -1,   -1,  171,  260,  261,  262,   -1,  223,
  224,  266,   60,   61,   62,   -1,   -1,   -1,   41,   42,
   -1,   -1,   45,   -1,   47,   -1,  256,  203,  204,   -1,
  260,  261,  262,  233,   -1,   -1,  266,   60,   61,   62,
   42,  223,  224,   45,   -1,   47,   -1,  261,  256,  257,
  258,  259,   -1,  257,  258,  259,  223,  224,   60,   61,
   62,   -1,  256,  257,  258,  259,  242,   -1,  244,  269,
   -1,   -1,  248,  273,   -1,   -1,   -1,   -1,   -1,  261,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,   -1,
   -1,  260,  261,  262,  261,  257,  258,  259,   -1,   -1,
   -1,   -1,  278,   -1,   -1,  281,  282,   -1,   -1,   -1,
   -1,   -1,  326,   -1,   -1,   -1,   -1,  331,   -1,   -1,
   -1,   -1,   -1,   -1,  300,   -1,  302,  303,   -1,   -1,
   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
   -1,  317,   -1,   -1,  326,   -1,   -1,   -1,   -1,  331,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  326,
   -1,   -1,   -1,   -1,  331,   -1,   -1,   -1,   -1,   -1,
   -1,  256,   -1,   -1,   -1,  260,  261,  262,   -1,   -1,
   -1,  266,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
   -1,   -1,  266,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,
  258,  259,  260,  261,  262,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  257,  258,  259,  260,  261,
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
"ejecucion : control ';'",
"ejecucion : salida ';'",
"ejecucion : BREAK ';'",
"ejecucion : CONTINUE ';'",
"ejecucion : CONTINUE ':' ID ';'",
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

//#line 788 "gramatica.y"

private Lexico lexico;
private ArbolSintactico arbolSintactico;
private String ambito;
private ArrayList<String> lista_variables;
private ArrayList<String> lista_parametros;
private ArrayList<String> lista_parametros_reales;
private Hashtable<String,ArrayList<Parametro>> parametrosFunciones;

public Parser(Lexico lexico)
{
  this.lexico = lexico;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
  this.lista_parametros = new ArrayList<String>();
  this.lista_parametros_reales = new ArrayList<String>();
  this.parametrosFunciones = new Hashtable<>();
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

//#line 832 "Parser.java"
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
//#line 17 "gramatica.y"
{arbolSintactico = val_peek(1).arbol;
                            Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval).setUso("nombrePrograma");
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
break;
case 2:
//#line 21 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
//#line 24 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
//#line 25 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 26 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
//#line 29 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 7:
//#line 30 "gramatica.y"
{     if(val_peek(0).arbol != null){
                                        if (val_peek(1).arbol !=null){
                                            AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);
                                    }else{
                                         AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                         atributos.setAmbito(ambito);
                                         yyval.arbol = new NodoBloqueEjecutable(val_peek(0).arbol,val_peek(1).arbol,atributos);
                                    }
                                }
                           }
break;
case 9:
//#line 45 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
break;
case 10:
//#line 48 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 11:
//#line 49 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 12:
//#line 52 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 13:
//#line 53 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableFor");
                                                               atributos.setAmbito(ambito);
                                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 14:
//#line 58 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 15:
//#line 59 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableIf");
                                                      atributos.setAmbito(ambito);
                                                      yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 16:
//#line 65 "gramatica.y"
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
//#line 81 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 19:
//#line 85 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 86 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 87 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 90 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);
                        lista_variables.add(val_peek(0).sval);
                        Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval).setUso("Variable");
                        yyval = new ParserVal(lista_variables);
                                }
break;
case 23:
//#line 95 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables ");
      		                                    Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval).setUso("Variable");
                                                lista_variables = (ArrayList<String>) val_peek(2).obj;
                                                lista_variables.add(val_peek(0).sval);
                                                yyval = new ParserVal(lista_variables);
                                                }
break;
case 25:
//#line 104 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 105 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 106 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 109 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");
								        Main.listaDeAmbitos.add(ambito);
								        yyval.arbol = val_peek(1).arbol;
								        if(!ambito.equals("main")){
                                        	ambito = ambito.substring(0,ambito.lastIndexOf("."));
                                        }
                            }
break;
case 30:
//#line 119 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 120 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 121 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 33:
//#line 124 "gramatica.y"
{
                    String nuevoLexema = val_peek(3).sval + "." + ambito;
                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaDeSimbolos.modificarSimbolo(val_peek(3).sval, nuevoLexema);
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                        atributos.setAmbito(ambito);
                        System.out.println("Ambito de la funcion: "+nuevoLexema+ ", es: "+ ambito);
                        atributos.setUso("nombreFuncion");
                        atributos.setTipo(val_peek(0).sval);
                        atributos.setListaDeParametros(lista_parametros);
                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema, atributos);
                        if(!lista_parametros.isEmpty()){
                            int posicion = 1;
                            for(String parametro : lista_parametros){
                                Main.tablaDeSimbolos.getAtributosTablaS(parametro).setOrden(posicion);
                                posicion++;
                            }
                        }

                        ArrayList<Parametro> parametros_actuales = new ArrayList<>();
                        for(String p: lista_parametros){
                            String idParametro = p;
                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(p).getTipo();
                            Parametro param = new Parametro(tipoId,idParametro);
                            parametros_actuales.add(param);
                        }
                        parametrosFunciones.put(nuevoLexema,parametros_actuales);

                        Main.informesSemanticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una funcion declarada con nombre "+val_peek(3).sval+ " en el ámbito "+ambito+", con tipo de retorno " + Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getTipo());
                    } else {
                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " la funcion "+ val_peek(3).sval + " ya fue declarada en este ambito");
                        }
                    ambito = ambito + "."+ val_peek(3).sval;
                    }
break;
case 35:
//#line 161 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 162 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 163 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 164 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 165 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
//#line 168 "gramatica.y"
{lista_parametros.clear();}
break;
case 41:
//#line 169 "gramatica.y"
{lista_parametros.clear();
                                      lista_parametros.add(val_peek(1).sval);}
break;
case 42:
//#line 171 "gramatica.y"
{lista_parametros.clear();
                                                      if(!val_peek(3).sval.equals(val_peek(1).sval)){
                                                        lista_parametros.add(val_peek(3).sval);
                                                        lista_parametros.add(val_peek(1).sval);
                                                      } else
                                                            Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " no puede haber dos parametros con el mismo ID");
                                                      }
break;
case 44:
//#line 181 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 182 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 183 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
//#line 186 "gramatica.y"
{String nuevoAmbitoId = val_peek(0).sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo(val_peek(0).sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo(val_peek(1).sval);
                    atributos.setUso("nombreParametro");
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    yyval = new ParserVal(nuevoAmbitoId);}
break;
case 49:
//#line 196 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 197 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 200 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("i32");}
break;
case 52:
//#line 202 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("f32");}
break;
case 53:
//#line 206 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 207 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if(val_peek(1).arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    lexDiscard.setAmbito(ambito);
	                                    yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,null,lexDiscard);
	                                }
	                                }
break;
case 55:
//#line 214 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 56:
//#line 215 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 216 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 58:
//#line 217 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 59:
//#line 218 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                        AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                        sentenciaBreak.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 60:
//#line 222 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                          AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                          sentenciaContinue.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 61:
//#line 226 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                  if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                      Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                      AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                      AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                      lexEtiqueta.setAmbito(ambito);
                                      yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                              }else
                                  Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+val_peek(1).sval+"' en algun ambito alcanzable");
                       }
break;
case 63:
//#line 239 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 64:
//#line 240 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 65:
//#line 241 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 66:
//#line 242 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 67:
//#line 243 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 68:
//#line 244 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 69:
//#line 245 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 70:
//#line 246 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 71:
//#line 249 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 72:
//#line 250 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(val_peek(1).arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               lexDiscard.setAmbito(ambito);
                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,null,lexDiscard);
                                           }
                                           }
break;
case 73:
//#line 257 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 74:
//#line 258 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 75:
//#line 259 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 76:
//#line 260 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              sentenciaBreak.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 77:
//#line 264 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                                sentenciaContinue.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 78:
//#line 268 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                        if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                        Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                        AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                        lexEtiqueta.setAmbito(ambito);
                                        yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+val_peek(1).sval+"' en algun ambito alcanzable");
                             }
break;
case 80:
//#line 281 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 81:
//#line 282 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 82:
//#line 283 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 83:
//#line 284 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 84:
//#line 285 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 85:
//#line 288 "gramatica.y"
{  String nuevoLexema = val_peek(1).sval + "." + ambito;
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
case 86:
//#line 301 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                                if(ambitoCheck != null){
                                                    if (val_peek(0).arbol!=null){
                                                        Main.tablaDeSimbolos.eliminarSimbolo(val_peek(2).sval);
                                                        AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                        atributosId.setAmbito(ambito);
                                                        Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                        AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                        atributos.setAmbito(ambito);
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
case 87:
//#line 322 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                   AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                   atributosId.setAmbito(ambito);
                                   Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito).setUso("Variable");
                                   AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                   atributos.setAmbito(ambito);
                                   yyval.arbol= new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                   }
break;
case 89:
//#line 333 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 90:
//#line 334 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 91:
//#line 335 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 92:
//#line 336 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 93:
//#line 337 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 94:
//#line 340 "gramatica.y"
{ AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                        retorno.setAmbito(ambito);
                                        yyval.arbol = new NodoRetorno(val_peek(0).arbol,null,retorno);
                                      }
break;
case 96:
//#line 347 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 97:
//#line 350 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 98:
//#line 351 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 atributos.setAmbito(ambito);
	                 	                                 yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                                 }
break;
case 99:
//#line 357 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              atributos.setAmbito(ambito);
	                 	                 	              yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                                                    }
break;
case 101:
//#line 365 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 102:
//#line 366 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 103:
//#line 369 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol,atributos);
                             }
break;
case 104:
//#line 374 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          }
break;
case 105:
//#line 379 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 107:
//#line 383 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 108:
//#line 384 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 109:
//#line 385 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 110:
//#line 386 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 111:
//#line 389 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
              if(ambitoCheck != null){
                  AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                  Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                  String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                  atributos.setTipo(tipoId);
                  atributos.setAmbito(ambito);
                  yyval.arbol = new NodoHoja(atributos);
              }
              else{
                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(0).sval);
                    yyval.arbol = null;
                    }
              }
break;
case 112:
//#line 403 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                       }
break;
case 113:
//#line 407 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setTipo("i32");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                        }
                   }
break;
case 114:
//#line 414 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                      atributosId.setAmbito(ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 115:
//#line 419 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       atributos.setAmbito(ambito);
                       yyval.arbol = new NodoHoja(atributos);
                       }
                      }
break;
case 116:
//#line 425 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               atributos.setAmbito(ambito);
                               yyval.arbol = new NodoHoja(atributos);
                               }
                           }
break;
case 117:
//#line 433 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                            if(ambitoCheck != null){
                                                if (val_peek(1).arbol !=null){
                                                    ArrayList<Parametro> parametros_funcion_actual = new ArrayList<>();
                                                    parametros_funcion_actual.addAll(parametrosFunciones.get(ambitoCheck));
                                                    if(parametros_funcion_actual.size() == lista_parametros_reales.size()){
                                                        int pos = 0;
                                                        int nroDeNoCoincidencias = 0;
                                                        for(String paramR : lista_parametros_reales){
                                                            String tipoParamR = Main.tablaDeSimbolos.getAtributosTablaS(paramR).getTipo();
                                                            String tipoParam = parametros_funcion_actual.get(pos).getTipo();
                                                            if(!tipoParamR.equals(tipoParam))
                                                                nroDeNoCoincidencias++;
                                                            pos++;
                                                        }
                                                        if(nroDeNoCoincidencias == 0){
                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);
                                                            AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion");
                                                            lexInvocacion.setAmbito(ambito);
                                                            AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
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
case 118:
//#line 469 "gramatica.y"
{  String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                            if(ambitoCheck != null){
                                if(lista_parametros.size() == lista_parametros_reales.size()){
                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);
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
case 120:
//#line 486 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 121:
//#line 487 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 122:
//#line 490 "gramatica.y"
{ if(val_peek(0).arbol !=null){
                                            AtributosTablaS lexParam = new AtributosTablaS("Un Parametro");
                                            lista_parametros_reales.clear();
                                            lista_parametros_reales.add(val_peek(0).sval);
                                            lexParam.setParametroEnLista(val_peek(0).sval);
                                            yyval.arbol = new NodoParam(val_peek(0).arbol,null,lexParam);
                                        }
                                        else
                                            yyval.arbol = null;
                                        }
break;
case 123:
//#line 500 "gramatica.y"
{ if(val_peek(2).arbol !=null && val_peek(0).arbol!=null){
                                                                    AtributosTablaS lexParam = new AtributosTablaS("Dos Parametros");
                                                                    lexParam.setParametroEnLista(val_peek(2).sval);
                                                                    lexParam.setParametroEnLista(val_peek(0).sval);
                                                                    lista_parametros_reales.clear();
                                                                    lista_parametros_reales.add(val_peek(2).sval);
                                                                    lista_parametros_reales.add(val_peek(0).sval);
                                                                    yyval.arbol = new NodoParam(val_peek(2).arbol,val_peek(0).arbol,lexParam);
                                                               }else
                                                                    yyval.arbol = null;
                                                               }
break;
case 125:
//#line 515 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 126:
//#line 516 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 127:
//#line 517 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 128:
//#line 520 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
                      if(ambitoCheck != null){
                          AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                          atributos.setAmbito(ambito);
                          Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                          yyval.arbol = new NodoHoja(atributos);
                          }else{
                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(0).sval);
                            yyval.arbol = null;
                          }
                          }
break;
case 129:
//#line 531 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoHoja(atributos);
                                   }
break;
case 130:
//#line 536 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                   atributos.setAmbito(ambito);
                                   yyval.arbol = new NodoHoja(atributos);
                               }
                               }
break;
case 131:
//#line 543 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                  }
break;
case 132:
//#line 549 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            }
                                       }
break;
case 133:
//#line 556 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);}
break;
case 135:
//#line 563 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 136:
//#line 564 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 137:
//#line 565 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 138:
//#line 566 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 139:
//#line 567 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 140:
//#line 570 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    }
break;
case 141:
//#line 574 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                }
break;
case 143:
//#line 581 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 144:
//#line 582 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 145:
//#line 583 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 146:
//#line 587 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);}
break;
case 147:
//#line 590 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          atributos.setAmbito(ambito);
                                          yyval.arbol = new NodoCuerpoThen(val_peek(1).arbol,null,atributos);}
break;
case 149:
//#line 596 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             atributos.setAmbito(ambito);
                             yyval.arbol = new NodoCuerpoElse(val_peek(0).arbol,null,atributos);}
break;
case 150:
//#line 599 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoElse(val_peek(1).arbol,null,atributos);}
break;
case 152:
//#line 605 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 153:
//#line 606 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 154:
//#line 609 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 155:
//#line 610 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 156:
//#line 611 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 157:
//#line 614 "gramatica.y"
{ yyval.arbol = val_peek(0).arbol;}
break;
case 158:
//#line 615 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 160:
//#line 619 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 161:
//#line 620 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 162:
//#line 624 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  atributos.setAmbito(ambito);
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                                  atributos2.setAmbito(ambito);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 164:
//#line 632 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 165:
//#line 633 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 166:
//#line 634 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 167:
//#line 637 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 168:
//#line 638 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 169:
//#line 639 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 170:
//#line 640 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 171:
//#line 641 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 172:
//#line 642 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 173:
//#line 645 "gramatica.y"
{if((val_peek(6).arbol != null)&&(val_peek(4).arbol != null)&&(val_peek(2).arbol != null)){
                                                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                            AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                            lexSentenciaFor.setAmbito(ambito);
                                                                                            AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                            lexCuerpoFor.setAmbito(ambito);
                                                                                            AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                            lexEncabezadoFor.setAmbito(ambito);
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
case 174:
//#line 663 "gramatica.y"
{if((val_peek(6).arbol != null)&&(val_peek(4).arbol != null)&&(val_peek(2).arbol != null)){
                                                                                  Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                  AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                  lexSentenciaFor.setAmbito(ambito);
                                                                                  AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                  lexCuerpoFor.setAmbito(ambito);
                                                                                  AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                  lexEncabezadoFor.setAmbito(ambito);
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
case 175:
//#line 682 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 176:
//#line 685 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 177:
//#line 688 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 178:
//#line 692 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 179:
//#line 696 "gramatica.y"
{ yyval.arbol = null;}
break;
case 180:
//#line 699 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 181:
//#line 700 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 182:
//#line 701 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 183:
//#line 702 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
break;
case 184:
//#line 703 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
break;
case 185:
//#line 706 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                        if(ambitoCheck != null){
                                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                            if(tipoId.equals("i32")){
                                                if (chequearRangoEnteros()==true){
                                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                                    atributos.setAmbito(ambito);
                                                    Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                    AtributosTablaS atributos2 = new AtributosTablaS("Asignacion FOR");
                                                    atributos2.setAmbito(ambito);
                                                    AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                                    atributos3.setAmbito(ambito);
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
case 187:
//#line 744 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 188:
//#line 745 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 189:
//#line 746 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 190:
//#line 749 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                                   if(ambitoCheck != null){
                                                       Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                       AtributosTablaS atributos = new AtributosTablaS("CondicionFOR");
                                                       atributos.setAmbito(ambito);
                                                       AtributosTablaS atributos2 = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                       atributos2.setAmbito(ambito);
                                                       AtributosTablaS atributos3 = new AtributosTablaS(val_peek(1).sval);
                                                       atributos3.setAmbito(ambito);
                                                       yyval.arbol = new NodoCondicionFor(new NodoComparacionFor(new NodoHoja(atributos2),val_peek(0).arbol,atributos3),null,atributos);
                                                   }
                                                   else{
                                                       Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no existe el id "+ val_peek(2).sval +" en ningun ambito alcanzable. Imposible determinar rango de control");
                                                       yyval.arbol = null;
                                                   }
                                                   }
break;
case 192:
//#line 768 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 193:
//#line 769 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 194:
//#line 770 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 195:
//#line 773 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          lexSalida.setAmbito(ambito);
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                          lexCadena.setAmbito(ambito);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 197:
//#line 783 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 198:
//#line 784 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 199:
//#line 785 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 2125 "Parser.java"
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
