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
    8,    8,    8,    8,    8,    8,    8,    8,    8,   30,
   30,   29,   29,   29,   29,   29,   32,   22,   22,   22,
   34,   34,   34,   34,   34,   25,   25,   35,   33,   33,
   33,   33,   37,   37,   36,   36,   36,   36,   39,   39,
   39,   39,   38,   38,   38,   38,   38,   38,   23,   23,
   23,   41,   41,   40,   40,   40,   42,   42,   42,   31,
   31,   31,   31,   31,   24,   24,   45,   45,   45,   45,
   45,   44,   44,   44,   48,   48,   48,   46,   46,   46,
   46,   47,   47,   47,   47,   49,   49,   50,   50,   50,
   51,   51,   51,   52,   52,   43,   43,   54,   54,   54,
   53,   53,   53,   53,   53,   53,   26,   26,   26,   58,
   57,   57,   57,   59,   59,   59,   59,   59,   55,   55,
   60,   60,   60,   56,   56,   61,   61,   61,   27,   27,
   62,   62,   62,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    2,    2,
    4,    1,    2,    2,    2,    2,    2,    2,    3,    2,
    2,    3,    2,    2,    2,    2,    2,    4,    1,    3,
    2,    2,    2,    3,    3,    4,    2,    3,    3,    1,
    3,    3,    3,    2,    2,    2,    1,    1,    1,    3,
    3,    1,    3,    3,    3,    3,    1,    1,    3,    3,
    2,    2,    1,    1,    1,    1,    2,    2,    4,    3,
    1,    4,    3,    1,    3,    1,    2,    5,    7,    1,
    1,    1,    2,    2,    5,    1,    4,    4,    4,    4,
    5,    3,    4,    1,    4,    2,    3,    1,    3,    1,
    1,    2,    4,    2,    1,    2,    2,    3,    3,    3,
    1,    3,    1,    2,    2,    3,    1,    2,    2,    2,
    1,    1,    1,    1,    1,    1,    9,   10,    1,    4,
    2,    2,    1,    1,    2,    2,    2,    2,    3,    1,
    2,    2,    2,    3,    1,    2,    2,    2,    4,    1,
    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   52,   51,    0,
    0,    0,    6,    8,   10,   11,    0,    0,   17,   18,
   24,    0,   29,   34,    0,    0,    0,    0,    0,    0,
   62,    0,   90,   97,  121,  136,  179,  200,    0,    0,
    0,    0,   87,    0,    0,    0,    0,   43,   48,    0,
  115,  114,    0,    0,    0,  116,   95,    0,    0,  102,
  107,  108,    0,  175,  174,  176,    0,  171,  172,  173,
    0,    0,    0,  167,    0,    0,    0,    0,    0,    0,
    0,   59,    0,   68,    0,    0,   60,    0,   26,    0,
    3,    7,   22,   21,    0,   25,   20,    0,    0,    0,
   63,   53,   70,   64,   55,   67,   56,   65,   57,   66,
   58,    0,    4,    1,    0,   92,    0,   93,   89,    0,
    0,  130,  132,  131,    0,    0,    0,    0,    0,  126,
   47,    0,   44,    0,  117,  118,  111,  112,    0,    0,
    0,    0,    0,    0,  170,    0,    0,    0,  201,    0,
  202,   50,    0,    0,   40,    0,   69,   54,    0,    0,
    0,    0,  190,    0,    0,   19,   16,   27,   23,   32,
    0,   30,    0,  133,  134,    0,   41,    0,  127,  122,
  119,   35,  123,  120,  103,    0,  104,    0,  109,  105,
  110,  106,    0,    0,  139,  144,    0,  140,    0,  138,
  199,   37,    0,   38,   36,  192,    0,  191,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   79,
  180,  163,    0,   61,  137,   31,   28,    0,    0,    0,
    0,    0,    0,    0,    0,  150,    0,    0,  151,    0,
    0,  135,   39,   33,  189,    0,   82,   76,    0,   83,
    0,   77,    0,    0,   12,  164,   13,   71,   73,   74,
   75,    0,    0,    0,  195,    0,    0,   42,    0,    0,
    0,   14,    0,  156,   15,   81,    0,    0,    0,  155,
  142,    0,   72,   84,    0,   85,  162,    0,    0,    0,
    0,    0,    0,    0,   80,  149,    0,    0,    0,  154,
    0,  145,  143,   86,   78,    0,  184,    0,    0,    0,
  183,    0,   46,    0,    0,  159,  158,  186,  181,  187,
  185,  182,  188,    0,    0,  129,  153,  177,    0,  178,
};
final static short yydgoto[] = {                          3,
   22,    4,   23,   24,   25,   26,  224,  225,  245,   27,
   28,   29,   30,   31,   32,   33,   56,   34,   57,   58,
   59,   35,   36,   37,   38,   39,   40,   41,  230,  246,
  247,   42,   81,   43,   44,   69,   70,   71,   72,  139,
   45,  140,   82,  205,   46,  248,  289,  206,  249,  290,
  231,  232,   83,   84,  172,  274,  320,   47,  321,  173,
  275,   48,
};
final static short yysindex[] = {                       -93,
  -89,   84,    0,    0,   84,   84,    0,   -4,  108,  648,
   16,    1,   42,   24,  -40,  -28,   71,    0,    0, -234,
  736,  116,    0,    0,    0,    0,   60,   63,    0,    0,
    0,  -37,    0,    0,   35,  107,  165,  183,  216,  236,
    0, -236,    0,    0,    0,    0,    0,    0,  137,  158,
  146,  469,    0,   86, -200,  126,   28,    0,    0,   85,
    0,    0,  179,  446,  446,    0,    0,   72,  -18,    0,
    0,    0,  150,    0,    0,    0,  715,    0,    0,    0,
  582,  160,   42,    0,  170,    7,  -51,  -31,  -13,  201,
   72,    0,  150,    0,  291,   64,    0,   39,    0,  331,
    0,    0,    0,    0,  474,    0,    0,  185,   33,  204,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  377,    0,    0,   85,    0,   72,    0,    0,   72,
  -51,    0,    0,    0,    0,  192,  131,  141,   -2,    0,
    0,  176,    0,  528,    0,    0,    0,    0,  545,  605,
  268,  515, -235,   56,    0,   42, -235,   72,    0,  378,
    0,    0,  176,  -47,    0,  176,    0,    0, -116,  167,
  449,  426,    0,  436, -235,    0,    0,    0,    0,    0,
   62,    0, -141,    0,    0, -136,    0,  532,    0,    0,
    0,    0,    0,    0,    0,  -18,    0,  -18,    0,    0,
    0,    0,  229,  229,    0,    0, -153,    0,   72,    0,
    0,    0,  -77,    0,    0,    0,  238,    0,  310,  395,
  242,  -44,  337,  475,    0,  471,  472,  478,  479,    0,
    0,    0,  610,    0,    0,    0,    0,  480,  139,  464,
   -3,  381,  284,    0,  271,    0,  491, -106,    0,  -98,
  229,    0,    0,    0,    0,  108,    0,    0,  492,    0,
  495,    0,  -39,  494,    0,    0,    0,    0,    0,    0,
    0,  736,   42,  503,    0,  610, -136,    0,  532,  504,
   -3,    0,  324,    0,    0,    0,  248,  284,  297,    0,
    0,  302,    0,    0,  398,    0,    0,   72,   42,   72,
   89,  519,  550,  560,    0,    0,  284,    0,  384,    0,
  404,    0,    0,    0,    0,   72,    0,  -64,  187,  566,
    0,   89,    0,  532,  427,    0,    0,    0,    0,    0,
    0,    0,    0,  449,  574,    0,    0,    0,  449,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  138,    0,    0,
    0,    0,  431,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  633,
    0,    0,    0,    0,    8,    0,    0,    0,    0,  162,
    0,    0,    0,    0,    0,    0,    0,  438,  575,    0,
    0,    0,   20,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  451,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   67,    0,  473,    0,    0,  505,
  546,    0,    0,    0,  412,    0,   99,   59,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  113,    0,  118,    0,  549,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  621,    0,  674,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  305,    0,
    0,    0,    0,    0,    0,    0,  586,    0,    0,    0,
    0,    0,    0,    0,  357,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  122,
  587,    0,    0,  191,    0,    0,    0,    0,    0,  558,
  564,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  565,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  544,    0,    0,    0,    0,    0,    0,    0,
    0,  569,    0,    0,    0,    0,    0,  601,  604,  615,
    0,    0,    0,  127,    0,    0,    0,  311,    0,    0,
    0,    0,    0,    0,    0,  626,    0,    0,    0,    0,
    0,    0,    0,    0,  -46,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   69,    0,  730,    0,    0,  645,  463, -128, -217,   10,
  670,    0,    0,    0,    0,    0,   23,    0,  -21,    0,
    0, -131,   -5,  518,    0,   -9,  583,    0,    0,  424,
  -53,    0,   -7,    0,    0,  334,    0,  -14,    0,    0,
    0,    0,   11,  -36,    0,  508,  466,    0,    0,    0,
 -281,    0,  584,    0,  537,  461,  416,    0,    0,    0,
    0,    0,
};
final static int YYTABLESIZE=998;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         67,
  138,   68,   21,   66,   66,   91,   20,   66,   89,   95,
  213,   96,  160,  263,  262,   66,  288,   55,   94,  296,
  203,   55,   99,  151,  288,  283,  163,  165,  152,    2,
  204,  100,  137,    6,   90,   54,  144,  122,  191,  226,
   89,  126,  129,  127,  130,   66,   66,  161,   49,  147,
  148,   49,  338,   53,   53,   86,  141,  340,   66,   66,
  113,  113,  113,   55,  113,   49,  113,  137,  143,  309,
  311,   66,   21,   49,   50,  158,   20,   66,  113,  113,
  113,  113,   92,   64,  189,  109,   63,  154,   65,  325,
  138,  226,  226,  112,  265,  267,  207,   55,   55,  124,
  110,   21,  251,   20,  171,   20,  108,   50,  113,  113,
  164,  113,  204,  113,  149,  169,  150,  208,  104,   87,
  210,  107,  170,   21,  144,  113,  135,   20,   98,   97,
  136,  318,  226,  319,  240,  267,  200,  202,  235,   18,
   19,  216,   53,   66,   66,   66,   66,  217,  209,   64,
   66,  192,   63,  169,   65,   21,   45,  180,  168,   20,
  287,  228,  125,    1,  239,  113,    5,  128,  287,  291,
  252,  187,  212,  214,  186,  215,   21,  181,  253,  278,
   20,   22,  277,  142,  188,  136,  237,   64,  280,  144,
   63,  328,   65,  329,  330,   55,   22,   21,   18,   19,
  157,   20,  226,  113,  113,  162,  113,  226,  113,  160,
  159,  260,  261,  228,  228,  259,   93,  295,    7,    8,
  113,  160,  254,  115,   87,  304,    9,   10,   18,   19,
   14,   11,   12,   13,   14,   15,   16,   17,   18,   19,
  101,  117,   87,   21,   18,   19,  126,   20,  127,  148,
   66,   51,  256,  190,  228,  303,   87,   88,  166,   52,
   52,  123,   18,   19,  298,  300,   66,   66,   21,  160,
  336,   18,   19,  136,  119,  113,   18,   19,   85,  113,
  113,  113,  124,   49,   49,  113,   55,   21,    7,    8,
  111,  316,  136,   66,  121,  174,    9,   10,   73,   61,
   62,   11,   12,   13,   14,   15,   16,   17,   18,   19,
   21,  203,   63,  148,  124,   14,  103,  236,    8,  106,
  169,  204,  113,   21,  228,    9,   10,  170,  182,  228,
   11,   12,   13,   14,   15,   16,   17,   18,   19,    7,
    8,  131,  132,  133,  134,  166,  317,    9,   10,  168,
   14,  243,   11,   12,   13,   14,   15,   16,   17,   18,
   19,   18,   19,   21,   60,   61,   62,   53,  169,  152,
  307,  175,    8,  168,   45,   45,   21,  125,  169,    9,
   10,   16,  128,  168,   11,   12,   13,   14,   15,   16,
   17,   18,   19,    8,   22,  284,   12,  132,  133,  134,
    9,   10,  125,   61,   62,   11,   12,   13,   14,   15,
   16,   17,   18,   19,    8,  161,  183,  113,  211,   16,
  114,    9,   10,   21,  218,  136,   11,   12,   13,   14,
   15,   16,   17,   18,   19,   14,  145,  146,  116,   92,
  178,  179,  331,   21,  332,  333,  148,   14,  306,  184,
  185,   18,   19,  258,   14,   14,  315,  148,  148,   14,
    8,   14,   14,   14,   14,   14,   21,    9,   10,   40,
  120,  118,   11,   12,   13,   14,   15,   16,   17,   18,
   19,   12,  196,  198,  233,  241,  133,  134,   21,   98,
   63,  120,    9,   10,  234,  255,   94,   11,   93,   13,
  242,   15,   16,   17,  241,  133,  134,  279,  326,   96,
   64,    9,   10,   63,   21,   65,   11,  108,   13,  242,
   15,   16,   17,  199,   73,   61,   62,  281,  327,  268,
  269,   91,  177,   21,    9,   10,  270,  271,  276,   11,
  281,   13,   14,   15,   16,   17,  167,    9,   10,  286,
  293,  337,   11,  294,   13,   14,   15,   16,   17,   63,
  166,  301,  305,   88,  312,  256,  152,   14,  194,  313,
  166,  223,  136,   52,   14,   14,  136,  322,  152,   14,
  281,   14,   14,   14,   14,   14,   64,    9,   10,   63,
  323,   65,   11,  219,   13,   14,   15,   16,   17,  266,
    9,   10,  157,  324,  123,   11,  334,  203,  220,  221,
   16,  222,  161,   12,  339,   99,  146,   99,  297,   99,
   12,   12,  141,  165,  149,   12,  150,  147,   12,   12,
   12,   12,    5,   99,   99,   99,   99,  132,  133,  134,
  281,   78,   80,   79,  193,  130,   64,    9,   10,   63,
  257,   65,   11,  314,   13,   14,   15,   16,   17,  197,
  281,  100,  198,  100,  156,  100,  157,    9,   10,   78,
   80,   79,   11,  196,   13,   14,   15,   16,   17,  100,
  100,  100,  100,  281,  194,  264,   98,   77,  227,   64,
    9,   10,   63,   94,   65,   11,  105,   13,   14,   15,
   16,   17,   73,   61,   62,  219,   96,   78,   80,   79,
  310,  250,    9,   10,  101,  292,  101,   11,  101,  238,
  220,  221,   16,  222,  128,   60,   61,   62,   91,  176,
  106,  219,  101,  101,  101,  101,  302,  335,    9,   10,
  227,  227,   16,   11,    0,    0,  220,  221,   16,  222,
  219,  102,    0,  229,    0,  153,   64,    9,   10,   63,
   88,   65,   11,    0,    0,  220,  221,   16,  222,    0,
  201,   73,   61,   62,   78,   80,   79,   64,  102,  102,
   63,  227,   65,  193,  132,  133,  134,    0,  132,  133,
  134,    0,    0,    0,    0,   78,   80,   79,    0,  157,
  195,   73,   61,   62,  203,  229,  229,    0,    0,    0,
  157,  157,    0,  146,    0,    0,  273,    0,    0,  141,
  165,    0,    0,    0,  147,    0,    0,    0,    0,    0,
   99,    0,    0,    0,   99,   99,   99,  155,    0,  102,
   99,   74,   75,   76,    0,    0,  229,  244,  244,    0,
    0,  227,    0,    0,    0,  299,  227,    0,    0,  273,
  197,   73,   61,   62,    0,    0,  272,    0,    0,   74,
   75,   76,    0,    0,    0,    0,  100,    0,    0,    0,
  100,  100,  100,    0,    0,    0,  100,  282,    0,  285,
    0,    0,    0,    0,    0,  244,    0,    0,    0,    0,
    0,    0,    0,    0,   73,   61,   62,   74,   75,   76,
  102,    0,    0,    0,    0,    0,  229,    0,    0,    0,
    0,  229,    0,    0,    0,    0,    0,  285,    0,  101,
    0,  308,  282,  101,  101,  101,    0,    0,    0,  101,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  282,    0,  285,    0,  285,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  285,
    0,   73,   61,   62,   74,   75,   76,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   73,   61,   62,   74,   75,   76,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   54,    9,   40,    9,   10,   13,   44,   13,   40,   15,
   58,   40,   59,   58,   59,   21,  123,    8,   59,   59,
  256,   12,  257,   42,  123,  243,   58,   41,   47,  123,
  266,   21,   54,  123,   12,   40,   40,  274,   41,  171,
   40,   51,   52,   51,   52,   51,   52,   41,   41,   64,
   65,   44,  334,   58,   58,   40,  257,  339,   64,   65,
   41,   42,   43,   54,   45,   58,   47,   89,   41,  287,
  288,   77,   40,    5,    6,   83,   44,   83,   59,   60,
   61,   62,   59,   42,  138,  123,   45,   77,   47,  307,
  144,  223,  224,   59,  223,  224,   41,   88,   89,   41,
   32,   40,  256,   44,   41,   44,   44,   41,   42,   43,
   88,   45,  266,   47,   43,  257,   45,  154,   59,  256,
  157,   59,  264,   40,   40,   59,   41,   44,   58,   59,
   45,   43,  264,   45,  188,  264,  151,  152,  175,  276,
  277,  258,   58,  149,  150,  151,  152,  264,  156,   42,
  156,  142,   45,   41,   47,   40,   58,  125,   41,   44,
  267,  171,   41,  257,  186,   59,  256,   41,  267,  268,
  207,   41,  163,  164,   44,  166,   40,  109,  256,   41,
   44,   44,   44,   58,   44,   45,  125,   42,  242,   40,
   45,  256,   47,  258,  259,  186,   59,   40,  276,  277,
   41,   44,  334,   42,   43,  257,   45,  339,   47,  256,
   41,  256,  257,  223,  224,  221,  257,  257,  256,  257,
   59,  268,  213,   59,  256,  279,  264,  265,  276,  277,
   40,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  125,   59,  256,   40,  276,  277,  256,   44,  256,   59,
  256,  256,  256,  256,  264,  277,  256,  257,   58,  264,
  264,  125,  276,  277,  272,  273,  272,  273,   40,  263,
  324,  276,  277,   45,   59,  256,  276,  277,  263,  260,
  261,  262,  125,  276,  277,  266,  277,   40,  256,  257,
  256,  299,   45,  299,   59,  257,  264,  265,  257,  258,
  259,  269,  270,  271,  272,  273,  274,  275,  276,  277,
   40,  256,   45,  123,  256,  125,  257,  256,  257,  257,
  257,  266,  256,   40,  334,  264,  265,  264,  125,  339,
  269,  270,  271,  272,  273,  274,  275,  276,  277,  256,
  257,  256,  257,  258,  259,   41,  258,  264,  265,   59,
   40,  123,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  276,  277,   40,  257,  258,  259,   58,  256,   59,
  123,   41,  257,  256,  276,  277,   40,  256,  266,  264,
  265,  274,  256,  266,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  257,  257,  125,   40,  257,  258,  259,
  264,  265,  257,  258,  259,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  257,   59,   40,  256,   41,  274,
  256,  264,  265,   40,  258,   45,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  125,  258,  259,  256,   59,
  256,  257,  256,   40,  258,  259,  256,  257,  125,  258,
  259,  276,  277,   59,  264,  265,   59,  267,  268,  269,
  257,  271,  272,  273,  274,  275,   40,  264,  265,   58,
   59,  256,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  125,  149,  150,   59,  257,  258,  259,   40,   59,
   45,  256,  264,  265,   59,  258,   59,  269,  257,  271,
  272,  273,  274,  275,  257,  258,  259,   44,  125,   59,
   42,  264,  265,   45,   40,   47,  269,   44,  271,  272,
  273,  274,  275,  256,  257,  258,  259,  257,  125,   59,
   59,   59,   59,   40,  264,  265,   59,   59,   59,  269,
  257,  271,  272,  273,  274,  275,  256,  264,  265,   59,
   59,  125,  269,   59,  271,  272,  273,  274,  275,   45,
  256,   59,   59,   59,  268,  256,  256,  257,   41,  268,
  266,  123,   45,  264,  264,  265,   45,   59,  268,  269,
  257,  271,  272,  273,  274,  275,   42,  264,  265,   45,
   41,   47,  269,  257,  271,  272,  273,  274,  275,  125,
  264,  265,   59,   44,   59,  269,   41,   59,  272,  273,
  274,  275,  256,  257,   41,   41,   59,   43,  125,   45,
  264,  265,   59,   59,   43,  269,   45,   59,  272,  273,
  274,  275,    0,   59,   60,   61,   62,  257,  258,  259,
  257,   60,   61,   62,   59,   59,   42,  264,  265,   45,
  256,   47,  269,  256,  271,  272,  273,  274,  275,   59,
  257,   41,   59,   43,   81,   45,  123,  264,  265,   60,
   61,   62,  269,   59,  271,  272,  273,  274,  275,   59,
   60,   61,   62,  257,   59,  223,  256,   40,  171,   42,
  264,  265,   45,  256,   47,  269,   27,  271,  272,  273,
  274,  275,  257,  258,  259,  257,  256,   60,   61,   62,
  287,  204,  264,  265,   41,  250,   43,  269,   45,  183,
  272,  273,  274,  275,  256,  257,  258,  259,  256,  256,
  257,  257,   59,   60,   61,   62,  276,  322,  264,  265,
  223,  224,  274,  269,   -1,   -1,  272,  273,  274,  275,
  257,   22,   -1,  171,   -1,   41,   42,  264,  265,   45,
  256,   47,  269,   -1,   -1,  272,  273,  274,  275,   -1,
  256,  257,  258,  259,   60,   61,   62,   42,   49,   50,
   45,  264,   47,  256,  257,  258,  259,   -1,  257,  258,
  259,   -1,   -1,   -1,   -1,   60,   61,   62,   -1,  256,
  256,  257,  258,  259,  256,  223,  224,   -1,   -1,   -1,
  267,  268,   -1,  256,   -1,   -1,  233,   -1,   -1,  256,
  256,   -1,   -1,   -1,  256,   -1,   -1,   -1,   -1,   -1,
  256,   -1,   -1,   -1,  260,  261,  262,  256,   -1,  110,
  266,  260,  261,  262,   -1,   -1,  264,  203,  204,   -1,
   -1,  334,   -1,   -1,   -1,  272,  339,   -1,   -1,  276,
  256,  257,  258,  259,   -1,   -1,  257,   -1,   -1,  260,
  261,  262,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,
  260,  261,  262,   -1,   -1,   -1,  266,  243,   -1,  245,
   -1,   -1,   -1,   -1,   -1,  251,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,
  181,   -1,   -1,   -1,   -1,   -1,  334,   -1,   -1,   -1,
   -1,  339,   -1,   -1,   -1,   -1,   -1,  283,   -1,  256,
   -1,  287,  288,  260,  261,  262,   -1,   -1,   -1,  266,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  307,   -1,  309,   -1,  311,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  325,
   -1,  257,  258,  259,  260,  261,  262,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  257,  258,  259,  260,  261,  262,
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
"break_con_retorno : BREAK factor_invocacion ';'",
"break_con_retorno : factor_invocacion ';'",
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
"cuerpo_then : break_con_retorno",
"cuerpo_then : error_cuerpo_then",
"cuerpo_else : ELSE ejecucion",
"cuerpo_else : ELSE '{' bloque_ejecutable_if '}'",
"cuerpo_else : ELSE break_con_retorno",
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

//#line 906 "gramatica.y"

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



//#line 828 "Parser.java"
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
//#line 160 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 161 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 162 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 163 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 164 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
//#line 167 "gramatica.y"
{lista_parametros.clear();}
break;
case 41:
//#line 168 "gramatica.y"
{lista_parametros.clear();
                                      lista_parametros.add(val_peek(1).sval);}
break;
case 42:
//#line 170 "gramatica.y"
{lista_parametros.clear();
                                                      if(!val_peek(3).sval.equals(val_peek(1).sval)){
                                                        lista_parametros.add(val_peek(3).sval);
                                                        lista_parametros.add(val_peek(1).sval);
                                                      } else
                                                            Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " no puede haber dos parametros con el mismo ID");
                                                      }
break;
case 44:
//#line 180 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 181 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 182 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
//#line 185 "gramatica.y"
{String nuevoAmbitoId = val_peek(0).sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo(val_peek(0).sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo(val_peek(1).sval);
                    atributos.setUso("nombreParametro");
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    yyval = new ParserVal(nuevoAmbitoId);}
break;
case 49:
//#line 195 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 196 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 199 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("i32");}
break;
case 52:
//#line 201 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("f32");}
break;
case 53:
//#line 205 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 206 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if(val_peek(1).arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    lexDiscard.setAmbito(ambito);
	                                    yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,null,lexDiscard);
	                                }
	                                }
break;
case 55:
//#line 213 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 56:
//#line 214 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 215 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 58:
//#line 216 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 59:
//#line 217 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                        AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                        sentenciaBreak.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 60:
//#line 221 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                          AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                          sentenciaContinue.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 61:
//#line 225 "gramatica.y"
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
//#line 238 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 64:
//#line 239 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 65:
//#line 240 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 66:
//#line 241 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 67:
//#line 242 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 68:
//#line 243 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 69:
//#line 244 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 70:
//#line 245 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 71:
//#line 248 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 72:
//#line 249 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(val_peek(1).arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               lexDiscard.setAmbito(ambito);
                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,null,lexDiscard);
                                           }
                                           }
break;
case 73:
//#line 256 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;
                                  yyval.sval = val_peek(1).sval;}
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
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                                String usoFactor = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval).getUso();
                                                String tipoFactor = null;
                                                AtributosTablaS retornoAsignable = null;
                                                if(ambitoCheck != null || usoFactor.equals("constante")){
                                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK acompañada de un valor de retorno");
                                                    if(ambitoCheck != null){
                                                         tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                                         retornoAsignable = new AtributosTablaS(ambitoCheck);
                                                    }
                                                    else{
                                                        tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval).getTipo();
                                                        retornoAsignable = new AtributosTablaS(val_peek(1).sval);
                                                    }
                                                    AtributosTablaS ats = new AtributosTablaS("break retorno");
                                                    ats.setAmbito(ambito);
                                                    ats.setTipo(tipoFactor);
                                                    retornoAsignable.setTipo(tipoFactor);
                                                    retornoAsignable.setAmbito(ambito);
                                                    yyval.arbol = new NodoContinueBreak(new NodoHoja(retornoAsignable),null,ats);
                                                    yyval.sval = tipoFactor;
                                                }
                                                else
                                                    if(ambitoCheck == null){
                                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite la variable "+ val_peek(1).sval +" para poder retornarla");
                                                        yyval.arbol = null;
                                                    }
                                                }
break;
case 81:
//#line 309 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                         String usoFactor = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval).getUso();
                                         String tipoFactor = null;
                                         AtributosTablaS retornoAsignable = null;
                                         if(ambitoCheck != null || usoFactor.equals("constante")){
                                             Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK acompañada de un valor de retorno");
                                             if(ambitoCheck != null){
                                                  tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                                  retornoAsignable = new AtributosTablaS(ambitoCheck);
                                             }
                                             else{
                                                 tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval).getTipo();
                                                 retornoAsignable = new AtributosTablaS(val_peek(1).sval);
                                             }
                                             AtributosTablaS ats = new AtributosTablaS("valor por defecto");
                                             ats.setTipo(tipoFactor);
                                             ats.setAmbito(ambito);
                                             retornoAsignable.setTipo(tipoFactor);
                                             retornoAsignable.setAmbito(ambito);
                                             yyval.arbol = new NodoContinueBreak(new NodoHoja(retornoAsignable),null,ats);
                                             yyval.sval = tipoFactor;
                                         }
                                         else
                                             if(ambitoCheck == null){
                                                 Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite la variable "+ val_peek(1).sval +" para poder retornarla");
                                                 yyval.arbol = null;
                                             }
                                         }
break;
case 82:
//#line 339 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' o valor a retornar al final de la sentencia BREAK");}
break;
case 83:
//#line 340 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
//#line 341 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
//#line 342 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
//#line 343 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 87:
//#line 346 "gramatica.y"
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
case 88:
//#line 359 "gramatica.y"
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
case 89:
//#line 380 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                    if(ambitoCheck != null){
                                        if (val_peek(0).arbol!=null){
                                           Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                           Main.tablaDeSimbolos.eliminarSimbolo(val_peek(2).sval);
                                           AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                           atributosId.setAmbito(ambito);
                                           Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                           AtributosTablaS atributos = new AtributosTablaS("AsignacionConControl");
                                           atributos.setAmbito(ambito);
                                           atributos.setTipo(val_peek(0).sval);
                                           NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                           if (nodoA.getTipo()!=null){
                                               yyval.arbol= nodoA;
                                           }
                                           else{
                                               Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                           }
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(2).sval);
                                   }
                                   }
break;
case 91:
//#line 405 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
//#line 406 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 93:
//#line 407 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 94:
//#line 408 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 95:
//#line 409 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 96:
//#line 412 "gramatica.y"
{ if(Main.tablaDeSimbolos.getTipoFuncionDeRetorno(ambito,val_peek(0).sval)){
                                            AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                            retorno.setAmbito(ambito);
                                            yyval.arbol = new NodoRetorno(val_peek(0).arbol,null,retorno);
                                        }
                                        else{
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el tipo que se quiere retornar no coincide con el de la funcion ");
                                            yyval.arbol = null;
                                        }
                                      }
break;
case 98:
//#line 425 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 99:
//#line 428 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;
                               yyval.sval = val_peek(0).sval;
                               }
break;
case 100:
//#line 431 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 atributos.setAmbito(ambito);
	                 	                                 yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                                 yyval.sval = val_peek(0).sval;
	                 	                                 }
break;
case 101:
//#line 438 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              atributos.setAmbito(ambito);
	                 	                 	              yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                 	              yyval.sval = val_peek(0).sval;
	                                                    }
break;
case 103:
//#line 447 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 104:
//#line 448 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 105:
//#line 451 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          yyval.sval = val_peek(0).sval;
                             }
break;
case 106:
//#line 457 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          yyval.sval = val_peek(0).sval;
	                          }
break;
case 107:
//#line 463 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 109:
//#line 467 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 110:
//#line 468 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 111:
//#line 469 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 112:
//#line 470 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 113:
//#line 473 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
              if(ambitoCheck != null){
                  AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                  Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                  String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                  atributos.setTipo(tipoId);
                  atributos.setAmbito(ambito);
                  yyval.arbol = new NodoHoja(atributos);
                  yyval.sval = tipoId;
              }
              else{
                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(0).sval);
                    yyval.arbol = null;
                    }
              }
break;
case 114:
//#line 488 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                         yyval.sval = "f32";
                       }
break;
case 115:
//#line 493 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setTipo("i32");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                        yyval.sval = "i32";
                        }
                   }
break;
case 116:
//#line 501 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                      atributosId.setAmbito(ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 117:
//#line 506 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       atributos.setAmbito(ambito);
                       yyval.arbol = new NodoHoja(atributos);
                       yyval.sval = "i32";
                       }
                      }
break;
case 118:
//#line 513 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               atributos.setAmbito(ambito);
                               yyval.arbol = new NodoHoja(atributos);
                               yyval.sval = "f32";
                               }
                           }
break;
case 119:
//#line 522 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                            boolean recursionCheck = Main.tablaDeSimbolos.chequearRecursionFuncion(val_peek(3).sval,ambito);
                                            if((ambitoCheck != null) && (recursionCheck)){
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
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] error de invocacion de la funcion " + val_peek(3).sval +  ", ya sea porque no existe o porque se esta autoinvocando ");
                                            }
break;
case 120:
//#line 559 "gramatica.y"
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
case 122:
//#line 576 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 123:
//#line 577 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 124:
//#line 580 "gramatica.y"
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
case 125:
//#line 590 "gramatica.y"
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
case 127:
//#line 605 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 128:
//#line 606 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 129:
//#line 607 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 130:
//#line 610 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
                      if(ambitoCheck != null){
                          AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                          atributos.setAmbito(ambito);
                          String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                          atributos.setTipo(tipoId);
                          Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                          yyval.arbol = new NodoHoja(atributos);
                          yyval.sval = val_peek(0).sval;
                          }else{
                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+val_peek(0).sval);
                            yyval.arbol = null;
                          }
                          }
break;
case 131:
//#line 624 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoHoja(atributos);
                                    yyval.sval = val_peek(0).sval;
                                   }
break;
case 132:
//#line 630 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                   atributos.setAmbito(ambito);
                                   yyval.arbol = new NodoHoja(atributos);
                                   yyval.sval = val_peek(0).sval;
                               }
                               }
break;
case 133:
//#line 638 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = val_peek(0).sval;
                                            }
                                  }
break;
case 134:
//#line 645 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = val_peek(0).sval;
                                            }
                                       }
break;
case 135:
//#line 653 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);
                                            yyval.sval = val_peek(0).sval;}
break;
case 137:
//#line 661 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 138:
//#line 662 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 139:
//#line 663 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 140:
//#line 664 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 141:
//#line 665 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 142:
//#line 668 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    yyval.sval = val_peek(1).sval;
                                    }
break;
case 143:
//#line 673 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                 yyval.sval = val_peek(1).sval;
                                                }
break;
case 145:
//#line 681 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 146:
//#line 682 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 147:
//#line 683 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 148:
//#line 687 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);}
break;
case 149:
//#line 690 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          atributos.setAmbito(ambito);
                                          yyval.arbol = new NodoCuerpoThen(val_peek(1).arbol,null,atributos);}
break;
case 150:
//#line 693 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                atributos.setAmbito(ambito);
                                atributos.setTipo(val_peek(0).sval);
                                System.out.println("Tipo breakConRetorno dentro de then" + val_peek(0).sval);
                                yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);
                                yyval.sval = val_peek(0).sval;}
break;
case 152:
//#line 702 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             atributos.setAmbito(ambito);
                             yyval.arbol = new NodoCuerpoElse(val_peek(0).arbol,null,atributos);}
break;
case 153:
//#line 705 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoElse(val_peek(1).arbol,null,atributos);}
break;
case 154:
//#line 708 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                     atributos.setAmbito(ambito);
                                     atributos.setTipo(val_peek(0).sval);
                                     yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);
                                     yyval.sval = val_peek(0).sval;}
break;
case 156:
//#line 716 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 157:
//#line 717 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 158:
//#line 720 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 159:
//#line 721 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 160:
//#line 722 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 161:
//#line 725 "gramatica.y"
{ yyval.arbol = val_peek(0).arbol;
                                System.out.println("Tipo ejecucion_control: " +val_peek(0).sval);
                                yyval.sval = val_peek(0).sval;}
break;
case 162:
//#line 728 "gramatica.y"
{yyval.sval = val_peek(1).sval;
                                            System.out.println("Tipo bloque_ejecutable_for: " +val_peek(1).sval);
                                            yyval.arbol = val_peek(1).arbol;}
break;
case 164:
//#line 734 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 165:
//#line 735 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 166:
//#line 739 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  atributos.setAmbito(ambito);
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                                  atributos2.setAmbito(ambito);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 168:
//#line 747 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 169:
//#line 748 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 170:
//#line 749 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 171:
//#line 752 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 172:
//#line 753 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 173:
//#line 754 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 174:
//#line 755 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 175:
//#line 756 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 176:
//#line 757 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 177:
//#line 760 "gramatica.y"
{if((val_peek(6).arbol != null)&&(val_peek(4).arbol != null)&&(val_peek(2).arbol != null)){
                                                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                            AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                            lexSentenciaFor.setAmbito(ambito);
                                                                                            lexSentenciaFor.setTipo(val_peek(0).sval);
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
                                                                                            System.out.println("Tipo bloque_for: " +val_peek(0).sval);
                                                                                            yyval.sval = val_peek(0).sval;
                                                                                          }
                                                                                          else
                                                                                              yyval.arbol = null;
                                                                                        }
break;
case 178:
//#line 781 "gramatica.y"
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
case 179:
//#line 800 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 180:
//#line 803 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 181:
//#line 806 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 182:
//#line 810 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 183:
//#line 814 "gramatica.y"
{ yyval.arbol = null;}
break;
case 184:
//#line 817 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 185:
//#line 818 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 186:
//#line 819 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 187:
//#line 820 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
break;
case 188:
//#line 821 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
break;
case 189:
//#line 824 "gramatica.y"
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
case 191:
//#line 862 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 192:
//#line 863 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 193:
//#line 864 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 194:
//#line 867 "gramatica.y"
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
case 196:
//#line 886 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 197:
//#line 887 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 198:
//#line 888 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 199:
//#line 891 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          lexSalida.setAmbito(ambito);
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                          lexCadena.setAmbito(ambito);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 201:
//#line 901 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 202:
//#line 902 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 203:
//#line 903 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 2249 "Parser.java"
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
