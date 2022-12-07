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
   35,   35,   35,   35,   35,   25,   25,   36,   33,   33,
   33,   33,   38,   38,   37,   37,   37,   37,   40,   40,
   40,   40,   39,   39,   39,   39,   39,   39,   23,   23,
   23,   42,   42,   41,   41,   41,   43,   43,   43,   31,
   31,   31,   31,   31,   24,   24,   46,   46,   46,   46,
   46,   45,   45,   45,   48,   48,   48,   47,   47,   47,
   47,   34,   34,   34,   34,   49,   49,   50,   50,   50,
   50,   51,   51,   51,   52,   52,   44,   44,   54,   54,
   54,   53,   53,   53,   53,   53,   53,   26,   26,   26,
   58,   57,   57,   57,   59,   59,   59,   59,   59,   55,
   55,   60,   60,   60,   56,   56,   61,   61,   61,   27,
   27,   62,   62,   62,
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
    2,    2,    2,    3,    3,    4,    2,    3,    4,    1,
    3,    4,    3,    2,    3,    2,    1,    1,    1,    3,
    3,    1,    3,    3,    3,    3,    1,    1,    3,    3,
    2,    2,    1,    1,    1,    1,    2,    2,    4,    3,
    1,    4,    3,    1,    3,    1,    2,    5,    7,    1,
    1,    1,    2,    2,    5,    1,    4,    4,    4,    4,
    5,    3,    4,    1,    4,    2,    3,    1,    3,    1,
    1,    2,    4,    2,    1,    2,    2,    3,    3,    3,
    2,    1,    3,    1,    2,    2,    3,    1,    2,    2,
    2,    1,    1,    1,    1,    1,    1,    9,   10,    1,
    4,    2,    2,    1,    1,    2,    2,    2,    2,    3,
    1,    2,    2,    2,    3,    1,    2,    2,    2,    4,
    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   52,   51,    0,
    0,    0,    6,    8,   10,   11,    0,    0,   17,   18,
   24,    0,   29,   34,    0,    0,    0,    0,    0,    0,
   62,    0,   90,   97,  121,  136,  180,  201,    0,    0,
    0,    0,   87,    0,    0,    0,    0,   43,   48,    0,
  115,  114,    0,    0,    0,  116,    0,    0,    0,  102,
  107,  108,    0,  176,  175,  177,    0,  172,  173,  174,
    0,    0,    0,  168,    0,    0,    0,    0,    0,    0,
    0,   59,    0,   68,    0,    0,   60,    0,   26,    0,
    3,    7,   22,   21,    0,   25,   20,    0,    0,    0,
   63,   53,   70,   64,   55,   67,   56,   65,   57,   66,
   58,    0,    4,    1,    0,    0,    0,   93,    0,    0,
    0,  130,  132,  131,    0,    0,    0,    0,    0,  126,
   47,    0,   44,    0,  117,  118,  111,  112,    0,    0,
   95,  155,    0,    0,    0,    0,    0,    0,  171,    0,
    0,    0,  202,    0,  203,   50,    0,    0,   40,    0,
   69,   54,    0,    0,    0,    0,  191,    0,    0,   19,
   16,   27,   23,   32,    0,   30,    0,   92,   89,  133,
  134,    0,   41,    0,  127,  122,  119,   35,  123,  120,
  161,    0,    0,    0,    0,    0,  154,    0,    0,   14,
    0,  103,    0,  104,    0,  109,  105,  110,  106,    0,
    0,  139,  144,    0,  140,    0,  138,  200,   37,    0,
   38,   36,  193,    0,  192,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   79,  181,  164,    0,
   61,  137,   31,   28,    0,    0,    0,    0,    0,    0,
  159,   15,   81,  158,    0,    0,    0,  150,    0,  151,
    0,    0,  135,   39,   33,  190,   82,   76,    0,   83,
    0,   77,    0,    0,   12,  165,   13,   71,   73,   74,
   75,    0,    0,    0,  196,    0,    0,   42,    0,   80,
  153,    0,  156,    0,  142,    0,   72,   84,    0,   85,
  163,    0,    0,    0,    0,    0,    0,    0,  149,  145,
  143,   86,   78,    0,  185,    0,    0,    0,  184,    0,
   46,    0,  187,  182,  188,  186,  183,  189,    0,    0,
  129,  178,    0,  179,
};
final static short yydgoto[] = {                          3,
   22,    4,   23,   24,   25,   26,  241,  242,  267,   27,
   28,   29,   30,   31,   32,   33,   56,   34,   57,   58,
   59,   35,   36,   37,   38,   39,   40,   41,  247,  268,
  208,   42,   81,  151,   43,   44,   69,   70,   71,   72,
  139,   45,  140,   82,  222,   46,  269,  223,  270,  152,
  248,  249,   83,   84,  176,  294,  328,   47,  329,  177,
  295,   48,
};
final static short yysindex[] = {                       -72,
  -99,  114,    0,    0,  114,  114,    0,  -29,   99,  687,
  -33,  -31,  742,  -34,  -47,   60,   47,    0,    0, -146,
  777,   -3,    0,    0,    0,    0,   57,   69,    0,    0,
    0,   46,    0,    0,  -45,   61,  -42,   23,   45,   79,
    0, -147,    0,    0,    0,    0,    0,    0,  135,  156,
  144,  423,    0,   36, -132,   87,  106,    0,    0,   29,
    0,    0, -123,  260,  260,    0, -102,   13,   -8,    0,
    0,    0,  130,    0,    0,    0,  766,    0,    0,    0,
  627,  149,  742,    0,  160,  -11,  -81,  -20,  -38,  147,
   13,    0,  130,    0,  317,  -14,    0,  -76,    0,  172,
    0,    0,    0,    0,  112,    0,    0,  -96,   68,  179,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  157,    0,    0,   29, -102,   13,    0, -102,   13,
  -81,    0,    0,    0,    0,  -71,   85,  139,   21,    0,
    0, -113,    0,  573,    0,    0,    0,    0,  251,  443,
    0,    0,  709,  723,  255,  337, -164,   24,    0,  742,
 -164,   13,    0,  175,    0,    0, -113,   52,    0, -113,
    0,    0, -179,  -30,  466,  161,    0,  182, -164,    0,
    0,    0,    0,    0,   90,    0, -143,    0,    0,    0,
    0, -183,    0,  576,    0,    0,    0,    0,    0,    0,
    0,  -27,  485,  443,    0,  202,    0,  250,  -27,    0,
  355,    0,   -8,    0,   -8,    0,    0,    0,    0,  291,
  291,    0,    0, -149,    0,   13,    0,    0,    0, -181,
    0,    0,    0,  -24,    0,  359,  381,   92,  427,  521,
  488,    0,  322,  356,  363,  380,    0,    0,    0,  649,
    0,    0,    0,    0,  382,   96,  391,   99,  386,  376,
    0,    0,    0,    0,  443,    0,  402,    0, -102,    0,
  -95,  291,    0,    0,    0,    0,    0,    0,  405,    0,
  410,    0,   -2,  507,    0,    0,    0,    0,    0,    0,
    0,  777,  742,  419,    0,  649, -183,    0,  576,    0,
    0,  421,    0,  211,    0,  216,    0,    0,  387,    0,
    0,   13,  742,   13,   18,  428,  447,  451,    0,    0,
    0,    0,    0,   13,    0,  -64,  -52,  450,    0,   18,
    0,  576,    0,    0,    0,    0,    0,    0,  466,  461,
    0,    0,  466,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  123,    0,    0,
    0,    0,  413,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  503,
    0,    0,    0,    0,  -18,    0,    0,    0,    0,  494,
    0,    0,    0,    0,    0,    0,    0,  446,  593,    0,
    0,    0,  756,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  470,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    7,    0,  472,    0,    0,  481,
  445,    0,    0,    0,  140,    0,   75,   26,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   33,
    0,  168,    0,  513,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  462,    0,    0,  313,    0,    0,    0,    0,    0,
    0,    0,  601,    0,  660,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  181,    0,    0,    0,    0,
    0,    0,    0,  473,    0,    0,    0,    0,    0,    0,
    0,  335,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   27,    0,    0,  -44,
    0,    0,    0,    0,    0,  225,    0,    0,    0,    0,
  517,  544,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  334,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  499,    0,    0,    0,  546,    0,    0,    0,    0,
    0,  474,  475,  476,    0,    0,    0,   42,    0,    0,
    0,    0,    0,  479,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   65,    0,   93,    0,    0,  730,  305, -152,  393,   10,
  524,    0,    0,    0,    0,    0,   43,    0,  -53,    0,
    0, -122,   -5,  600,    0,   -9,  630,    0,    0,  403,
  -35,    0,   -7,  607,    0,    0,  309,    0,  -32,    0,
    0,    0,    0,   14,  689,    0,  333,    0,    0,    0,
 -259,    0,  127,    0,  370,  263,  237,    0,    0,    0,
    0,    0,
};
final static int YYTABLESIZE=1039;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         67,
  137,   68,  169,   66,   66,   91,   86,   66,   89,   95,
   54,   94,  144,  112,  160,   66,  115,   55,  138,   89,
  150,   55,   49,    6,   92,   49,  175,  150,   53,  165,
   53,  147,  148,  155,  100,  137,   21,  167,  156,   49,
   20,  126,  129,  127,  130,   66,   66,   50,  113,  113,
    2,  113,  243,  113,   90,  153,  310,  154,   66,   66,
  326,  197,  327,   55,  224,  113,  124,  125,  144,   49,
   50,   66,   87,  170,  274,  162,  135,   66,  233,  342,
  136,  117,  128,  344,  234,   21,   53,  285,  287,   20,
  158,  220,   18,   19,   18,   19,  110,   55,   55,   96,
   20,  221,  195,  119,   98,   97,  272,   21,  138,  230,
   99,   20,  108,  173,  102,  104,  221,  243,  243,  113,
  174,  101,  217,  219,  141,  193,  122,  107,  192,   21,
  168,  287,   45,   20,  145,  146,  298,  121,  256,  297,
   64,  102,  102,   63,  142,   65,  143,   66,   66,   66,
   66,  198,  226,   21,   66,  108,    5,   20,  257,  182,
  183,  243,   18,   19,  149,  245,   22,  259,  109,  144,
  181,  149,  305,  185,   21,  166,  229,  231,   20,  232,
  178,   22,  194,  136,    1,   64,  190,  191,   63,  161,
   65,  333,  184,  334,  335,   21,  187,   40,  120,   20,
  163,   55,  102,  336,  170,  337,  338,  160,  169,   93,
  111,  160,  179,  114,  254,  228,  243,   87,   21,  250,
  243,  167,   20,  160,   87,   88,   51,  235,  258,   85,
  245,  245,  279,  276,   52,   87,   52,   18,   19,  275,
  251,   21,  173,  317,   18,   19,   18,   19,  126,  174,
  127,  164,   66,    8,  309,   18,   19,   49,   49,  123,
    9,   10,  113,  318,   14,   11,   12,   13,   14,   15,
   16,   17,   18,   19,  245,  325,  196,  102,  116,  220,
  124,  124,  125,  148,  312,  314,   66,   66,  170,  221,
   21,  131,  132,  133,  134,  136,  341,  128,  170,   63,
  118,    7,    8,  186,   63,  324,   55,   66,  263,    9,
   10,   18,   19,  103,   11,   12,   13,   14,   15,   16,
   17,   18,   19,    7,    8,  106,  261,   18,   19,  245,
   21,    9,   10,  245,  120,  136,   11,   12,   13,   14,
   15,   16,   17,   18,   19,  253,    8,  148,   93,   14,
   45,   45,   14,    9,   10,   60,   61,   62,   11,   12,
   13,   14,   15,   16,   17,   18,   19,  180,  106,    7,
    8,  152,   16,  204,   12,  172,  293,    9,   10,   22,
  288,   63,   11,   12,   13,   14,   15,   16,   17,   18,
   19,    8,  166,  162,   21,  132,  133,  134,    9,   10,
  125,   61,   62,   11,   12,   13,   14,   15,   16,   17,
   18,   19,    8,  265,  289,   21,   53,   16,  313,    9,
   10,  290,  293,  169,   11,   12,   13,   14,   15,   16,
   17,   18,   19,  169,  299,    8,  167,   14,  291,  278,
  296,   21,    9,   10,  300,  323,  167,   11,   12,   13,
   14,   15,   16,   17,   18,   19,  166,  162,  209,   12,
   21,  213,  215,  307,   64,    9,   10,   63,  308,   65,
   11,   98,   13,   14,   15,   16,   17,  315,  320,  264,
  148,   14,   21,  321,  283,  282,  330,  331,   14,   14,
  339,  148,  148,   14,  332,   14,   14,   14,   14,   14,
  301,  343,    5,  123,   94,   21,  201,  202,  133,  134,
  216,   73,   61,   62,    9,   10,   73,   61,   62,   11,
  130,   13,  203,   15,   16,   17,  303,   21,   96,  136,
   91,  194,  198,  199,  197,  113,  113,  195,  113,   88,
  113,  206,  211,   92,  284,  319,   21,  202,  133,  134,
  105,  207,  113,  271,    9,   10,  255,  157,  316,   11,
   21,   13,  203,   15,   16,   17,  340,    0,  152,   14,
    0,  204,  171,    0,    0,  146,   14,   14,    0,    0,
  152,   14,    0,   14,   14,   14,   14,   14,  240,  166,
  162,   12,  218,   73,   61,   62,  260,    0,   12,   12,
  166,  162,  141,   12,  147,    0,   12,   12,   12,   12,
    0,  209,  286,  200,  258,    0,    0,  136,    9,   10,
  136,  157,   52,   11,    0,   13,   14,   15,   16,   17,
    0,  311,  209,   99,    0,   99,  277,   99,    0,    9,
   10,  100,  322,  100,   11,  100,   13,   14,   15,   16,
   17,   99,   99,   99,   99,    0,    0,  302,  209,  100,
  100,  100,  100,    0,    0,    9,   10,    0,   98,  153,
   11,  154,   13,   14,   15,   16,   17,  209,  128,   60,
   61,   62,  280,  281,    9,   10,   78,   80,   79,   11,
    0,   13,   14,   15,   16,   17,   16,    0,    0,  209,
  101,   94,  101,    0,  101,    0,    9,   10,   78,   80,
   79,   11,    0,   13,   14,   15,   16,   17,  101,  101,
  101,  101,  236,    0,    0,   96,   77,   91,   64,    9,
   10,   63,  188,   65,   11,  189,   88,  237,  238,   16,
  239,  132,  133,  134,  236,    0,   78,   80,   79,  113,
   64,    9,   10,   63,  157,   65,   11,    0,    0,  237,
  238,   16,  239,  236,   64,  157,  157,   63,  204,   65,
    9,   10,  146,    0,  244,   11,    0,  236,  237,  238,
   16,  239,    0,   64,    9,   10,   63,    0,   65,   11,
    0,    0,  237,  238,   16,  239,  113,  113,  113,  141,
  113,  147,  113,    0,  246,    0,  157,   64,    0,    0,
   63,    0,   65,    0,  113,  113,  113,  113,   64,    0,
    0,   63,    0,   65,    0,   78,   80,   79,  199,  132,
  133,  134,  132,  133,  134,    0,   78,   80,   79,  244,
  244,    0,    0,    0,    0,    0,  225,    0,   99,  227,
    0,    0,   99,   99,   99,    0,  100,    0,   99,    0,
  100,  100,  100,    0,    0,    0,  100,  252,    0,  246,
  246,    0,    0,    0,    0,  304,    0,  306,  205,  210,
    0,    0,  159,  244,    0,    0,   74,   75,   76,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  292,    0,    0,   74,   75,
   76,    0,  273,  246,    0,  101,    0,    0,    0,  101,
  101,  101,    0,    0,    0,  101,    0,    0,    0,    0,
    0,    0,    0,  210,    0,  262,    0,    0,  244,    0,
  262,    0,  244,   73,   61,   62,   74,   75,   76,  266,
  266,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  212,   73,   61,   62,  246,    0,
    0,    0,  246,    0,    0,    0,    0,    0,  214,   73,
   61,   62,    0,    0,    0,    0,    0,    0,    0,  262,
    0,    0,    0,    0,  210,    0,  262,    0,   73,   61,
   62,  266,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  113,    0,    0,    0,  113,  113,  113,    0,    0,
    0,  113,   73,   61,   62,   74,   75,   76,    0,    0,
    0,  262,    0,   73,   61,   62,   74,   75,   76,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          9,
   54,    9,   41,    9,   10,   13,   40,   13,   40,   15,
   40,   59,   40,   59,   59,   21,   59,    8,   54,   40,
  123,   12,   41,  123,   59,   44,   41,  123,   58,   41,
   58,   64,   65,   42,   21,   89,   40,   58,   47,   58,
   44,   51,   52,   51,   52,   51,   52,   41,   42,   43,
  123,   45,  175,   47,   12,   43,   59,   45,   64,   65,
   43,   41,   45,   54,   41,   59,   41,   41,   40,    5,
    6,   77,  256,   41,  256,   83,   41,   83,  258,  339,
   45,   59,   41,  343,  264,   40,   58,  240,  241,   44,
   77,  256,  276,  277,  276,  277,   32,   88,   89,   40,
   44,  266,  138,   59,   58,   59,  256,   40,  144,   58,
  257,   44,   44,  257,   22,   59,  266,  240,  241,   59,
  264,  125,  155,  156,  257,   41,  274,   59,   44,   40,
   88,  284,   58,   44,  258,  259,   41,   59,  192,   44,
   42,   49,   50,   45,   58,   47,   41,  153,  154,  155,
  156,  142,  160,   40,  160,   44,  256,   44,  194,  256,
  257,  284,  276,  277,  267,  175,   44,  203,  123,   40,
   59,  267,  268,  109,   40,  257,  167,  168,   44,  170,
  257,   59,   44,   45,  257,   42,  258,  259,   45,   41,
   47,  256,  125,  258,  259,   40,   40,   58,   59,   44,
   41,  192,  110,  256,   58,  258,  259,   81,   41,  257,
  256,  256,   41,  256,  125,   41,  339,  256,   40,   59,
  343,   41,   44,  268,  256,  257,  256,  258,  256,  263,
  240,  241,  238,  258,  264,  256,  264,  276,  277,  230,
   59,   40,  257,  297,  276,  277,  276,  277,  258,  264,
  258,  263,  258,  257,  257,  276,  277,  276,  277,  125,
  264,  265,  256,  299,   40,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  284,  258,  256,  185,  256,  256,
  125,  256,  256,   59,  292,  293,  292,  293,  256,  266,
   40,  256,  257,  258,  259,   45,  332,  256,  266,   45,
  256,  256,  257,  125,   45,  313,  297,  313,   59,  264,
  265,  276,  277,  257,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  256,  257,  257,  125,  276,  277,  339,
   40,  264,  265,  343,  256,   45,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  256,  257,  123,  257,  125,
  276,  277,   40,  264,  265,  257,  258,  259,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  256,  257,  256,
  257,   59,  274,  123,   40,   59,  250,  264,  265,  257,
   59,   45,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  257,   59,   59,   40,  257,  258,  259,  264,  265,
  257,  258,  259,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  257,  123,   59,   40,   58,  274,  292,  264,
  265,   59,  296,  256,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  266,   44,  257,  256,  125,   59,   59,
   59,   40,  264,  265,   59,   59,  266,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  123,  123,  257,  125,
   40,  153,  154,   59,   42,  264,  265,   45,   59,   47,
  269,   59,  271,  272,  273,  274,  275,   59,  268,  125,
  256,  257,   40,  268,   58,   59,   59,   41,  264,  265,
   41,  267,  268,  269,   44,  271,  272,  273,  274,  275,
  125,   41,    0,   59,   59,   40,  256,  257,  258,  259,
  256,  257,  258,  259,  264,  265,  257,  258,  259,  269,
   59,  271,  272,  273,  274,  275,  125,   40,   59,   45,
   59,   59,   59,   59,   59,   42,   43,   59,   45,   59,
   47,  149,  150,   59,  240,  125,   40,  257,  258,  259,
   27,  149,   59,  221,  264,  265,  187,   59,  296,  269,
   40,  271,  272,  273,  274,  275,  330,   -1,  256,  257,
   -1,   59,  256,   -1,   -1,   59,  264,  265,   -1,   -1,
  268,  269,   -1,  271,  272,  273,  274,  275,  123,  256,
  256,  257,  256,  257,  258,  259,  204,   -1,  264,  265,
  267,  267,   59,  269,   59,   -1,  272,  273,  274,  275,
   -1,  257,  125,   41,  256,   -1,   -1,   45,  264,  265,
   45,  123,  264,  269,   -1,  271,  272,  273,  274,  275,
   -1,  125,  257,   41,   -1,   43,  256,   45,   -1,  264,
  265,   41,  256,   43,  269,   45,  271,  272,  273,  274,
  275,   59,   60,   61,   62,   -1,   -1,  265,  257,   59,
   60,   61,   62,   -1,   -1,  264,  265,   -1,  256,   43,
  269,   45,  271,  272,  273,  274,  275,  257,  256,  257,
  258,  259,  256,  257,  264,  265,   60,   61,   62,  269,
   -1,  271,  272,  273,  274,  275,  274,   -1,   -1,  257,
   41,  256,   43,   -1,   45,   -1,  264,  265,   60,   61,
   62,  269,   -1,  271,  272,  273,  274,  275,   59,   60,
   61,   62,  257,   -1,   -1,  256,   40,  256,   42,  264,
  265,   45,  126,   47,  269,  129,  256,  272,  273,  274,
  275,  257,  258,  259,  257,   -1,   60,   61,   62,  256,
   42,  264,  265,   45,  256,   47,  269,   -1,   -1,  272,
  273,  274,  275,  257,   42,  267,  268,   45,  256,   47,
  264,  265,  256,   -1,  175,  269,   -1,  257,  272,  273,
  274,  275,   -1,   42,  264,  265,   45,   -1,   47,  269,
   -1,   -1,  272,  273,  274,  275,   41,   42,   43,  256,
   45,  256,   47,   -1,  175,   -1,   41,   42,   -1,   -1,
   45,   -1,   47,   -1,   59,   60,   61,   62,   42,   -1,
   -1,   45,   -1,   47,   -1,   60,   61,   62,  256,  257,
  258,  259,  257,  258,  259,   -1,   60,   61,   62,  240,
  241,   -1,   -1,   -1,   -1,   -1,  158,   -1,  256,  161,
   -1,   -1,  260,  261,  262,   -1,  256,   -1,  266,   -1,
  260,  261,  262,   -1,   -1,   -1,  266,  179,   -1,  240,
  241,   -1,   -1,   -1,   -1,  269,   -1,  271,  149,  150,
   -1,   -1,  256,  284,   -1,   -1,  260,  261,  262,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  257,   -1,   -1,  260,  261,
  262,   -1,  224,  284,   -1,  256,   -1,   -1,   -1,  260,
  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  204,   -1,  206,   -1,   -1,  339,   -1,
  211,   -1,  343,  257,  258,  259,  260,  261,  262,  220,
  221,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  256,  257,  258,  259,  339,   -1,
   -1,   -1,  343,   -1,   -1,   -1,   -1,   -1,  256,  257,
  258,  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  260,
   -1,   -1,   -1,   -1,  265,   -1,  267,   -1,  257,  258,
  259,  272,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  256,   -1,   -1,   -1,  260,  261,  262,   -1,   -1,
   -1,  266,  257,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  302,   -1,  257,  258,  259,  260,  261,  262,
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
"asignacion : ID ASIGNACION control cuerpo_else",
"asignacion : error_asignacion",
"error_asignacion : ID error expresion_aritmetica",
"error_asignacion : ID error control cuerpo_else",
"error_asignacion : ID ASIGNACION error",
"error_asignacion : ASIGNACION expresion_aritmetica",
"error_asignacion : ASIGNACION control cuerpo_else",
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
"error_cuerpo_else : ELSE error",
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

//#line 952 "gramatica.y"

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
        	Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una constante ENTERA LARGA fuera de rango");
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
		    Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una constante ENTERA LARGA fuera de rango");
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
            Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una constante FLOTANTE fuera de rango");
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



//#line 840 "Parser.java"
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
                            Main.tablaDeSimbolos.getAtributosTablaS(val_peek(3).sval).setAmbito(ambito);
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
break;
case 2:
//#line 22 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
//#line 25 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador de programa");}
break;
case 4:
//#line 26 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 27 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la llave de cierre de bloque de programa");}
break;
case 6:
//#line 30 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 7:
//#line 31 "gramatica.y"
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
//#line 46 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] no es una sentencia válida");}
break;
case 10:
//#line 49 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 11:
//#line 50 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 12:
//#line 53 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 13:
//#line 54 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableFor");
                                                               atributos.setAmbito(ambito);
                                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 14:
//#line 59 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 15:
//#line 60 "gramatica.y"
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
                                                        atributosT.setAmbito(ambito);
                                                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                                                    } else {
                                                        if(Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getUso().equals("nombreFuncion")){
                                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] ya se declaro una funcion con id " + lexema + " en este ambito");
                                                            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
                                                        }
                                                        else{
                                                            if(Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getUso().equals("Variable")){
                                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] la variable " + lexema + " ya fue declarada en este ambito");
                                                                Main.tablaDeSimbolos.eliminarSimbolo(lexema);
                                                            }
                                                        }
                                                    }
                                            }
                                            lista_variables.clear();
                                            }
break;
case 17:
//#line 90 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 19:
//#line 94 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 95 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 96 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 99 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);
                        lista_variables.add(val_peek(0).sval);
                        Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval).setUso("Variable");
                        yyval = new ParserVal(lista_variables);
                                }
break;
case 23:
//#line 104 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables ");
      		                                    Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval).setUso("Variable");
                                                lista_variables = (ArrayList<String>) val_peek(2).obj;
                                                lista_variables.add(val_peek(0).sval);
                                                yyval = new ParserVal(lista_variables);
                                                }
break;
case 25:
//#line 113 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ',' entre identificadores de variables");}
break;
case 26:
//#line 114 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador antes de la coma");}
break;
case 27:
//#line 115 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador despues de la coma");}
break;
case 28:
//#line 118 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");
								        Main.listaDeAmbitos.add(ambito);
								        yyval.arbol = val_peek(1).arbol;
								        lista_parametros.clear();
								        if(!ambito.equals("main")){
                                        	ambito = ambito.substring(0,ambito.lastIndexOf("."));
                                        }

                            }
break;
case 30:
//#line 130 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 131 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 132 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el bloque de sentencias de la funcion");}
break;
case 33:
//#line 135 "gramatica.y"
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
                        if (Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getUso().equals("nombreFuncion"))
                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] la funcion "+ val_peek(3).sval + " ya fue declarada en este ambito");
                        else
                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] ya existe una variable declarada con el id "+ val_peek(3).sval + ", por lo tanto no puede llamarse asi la funcion");
                    }
                    ambito = ambito + "."+ val_peek(3).sval;
                    }
break;
case 35:
//#line 174 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 175 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 176 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 177 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 178 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
//#line 181 "gramatica.y"
{lista_parametros.clear();}
break;
case 41:
//#line 182 "gramatica.y"
{lista_parametros.clear();
                                      lista_parametros.add(val_peek(1).sval);}
break;
case 42:
//#line 184 "gramatica.y"
{lista_parametros.clear();
                                                      if(!val_peek(3).sval.equals(val_peek(1).sval)){
                                                        lista_parametros.add(val_peek(3).sval);
                                                        lista_parametros.add(val_peek(1).sval);
                                                      } else
                                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no puede haber dos parametros con el mismo ID");
                                                      }
break;
case 44:
//#line 194 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 195 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 196 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] el número máximo de parámetros permitidos es 2");}
break;
case 47:
//#line 199 "gramatica.y"
{String nuevoAmbitoId = val_peek(0).sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo(val_peek(0).sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo(val_peek(1).sval);
                    atributos.setUso("nombreParametro");
                    atributos.setAmbito(ambito);
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    yyval = new ParserVal(nuevoAmbitoId);}
break;
case 49:
//#line 210 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador del parametro");}
break;
case 50:
//#line 211 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el tipo del parametro");}
break;
case 51:
//#line 214 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("i32");}
break;
case 52:
//#line 216 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("f32");}
break;
case 53:
//#line 220 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 221 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if(val_peek(1).arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    lexDiscard.setAmbito(ambito);
	                                    yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,null,lexDiscard);
	                                }
	                                }
break;
case 55:
//#line 228 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 56:
//#line 229 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 230 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 58:
//#line 231 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 59:
//#line 232 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                        AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                        sentenciaBreak.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 60:
//#line 236 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                          AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                          sentenciaContinue.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 61:
//#line 240 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                  if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                      Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                      AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                      AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                      lexEtiqueta.setAmbito(ambito);
                                      yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                              }else
                                  Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no exite una sentencia de control etiquetada con '"+val_peek(1).sval+"' en algun ambito alcanzable");
                       }
break;
case 63:
//#line 253 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la asignacion");}
break;
case 64:
//#line 254 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la seleccion");}
break;
case 65:
//#line 255 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la sentencia de control");}
break;
case 66:
//#line 256 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la impresion");}
break;
case 67:
//#line 257 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final del retorno");}
break;
case 68:
//#line 258 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la invocacion despues de la palabra discard");}
break;
case 69:
//#line 259 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la invocacion");}
break;
case 70:
//#line 260 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la palabra discard antes de la invocacion");}
break;
case 71:
//#line 263 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;
                                   yyval.sval = val_peek(1).sval;}
break;
case 72:
//#line 265 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(val_peek(1).arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               lexDiscard.setAmbito(ambito);
                                               yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,null,lexDiscard);
                                           }
                                           }
break;
case 73:
//#line 272 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;
                                  yyval.sval = val_peek(1).sval;}
break;
case 74:
//#line 274 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 75:
//#line 275 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 76:
//#line 276 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              sentenciaBreak.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 77:
//#line 280 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                                sentenciaContinue.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 78:
//#line 284 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                        if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                        Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);
                                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                        AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                        lexEtiqueta.setAmbito(ambito);
                                        yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                                    }else
                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no exite una sentencia de control etiquetada con '"+val_peek(1).sval+"' en algun ambito alcanzable");
                             }
break;
case 80:
//#line 297 "gramatica.y"
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
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no es posible asignar "+ val_peek(1).sval +" a la variable deseada");
                                                        yyval.arbol = null;
                                                    }
                                                }
break;
case 81:
//#line 325 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(1).sval,ambito);
                                         String usoFactor = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval).getUso();
                                         String tipoFactor = null;
                                         AtributosTablaS retornoAsignable = null;
                                         if(ambitoCheck != null || usoFactor.equals("constante")){
                                             Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto un valor de retorno por defecto");
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
                                                 Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no exite la variable "+ val_peek(1).sval +" para poder retornarla");
                                                 yyval.arbol = null;
                                             }
                                         }
break;
case 82:
//#line 355 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' o valor a retornar al final de la sentencia BREAK");}
break;
case 83:
//#line 356 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
//#line 357 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
//#line 358 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
//#line 359 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta ';' al final de la sentencia CONTINUE");}
break;
case 87:
//#line 362 "gramatica.y"
{  String nuevoLexema = val_peek(1).sval + "." + ambito;
                     if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                         Main.tablaDeSimbolos.modificarSimbolo(val_peek(1).sval, nuevoLexema);
                         AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                         atributosT.setUso("nombreEtiqueta");
                         Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                         yyval = new ParserVal(nuevoLexema);
                     } else {
                         Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] la etiqueta " + val_peek(1).sval + " ya fue declarada en este ambito");
                         Main.tablaDeSimbolos.eliminarSimbolo(val_peek(1).sval);
                         }
                     }
break;
case 88:
//#line 375 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                                if(ambitoCheck != null){
                                                    if (val_peek(0).arbol!=null){
                                                        Main.tablaDeSimbolos.eliminarSimbolo(val_peek(2).sval);
                                                        AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                        if(atributosId.getAmbito().equals(""))
                                                            atributosId.setAmbito(ambito);
                                                        Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                        AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                        atributos.setAmbito(ambito);
                                                        NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),val_peek(0).arbol,atributos);
                                                    if (nodoA.getTipo()!=null){
                                                        yyval.arbol= nodoA;
                                                        yyval.sval = val_peek(0).sval;
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                                    }
                                                }
                                                }else
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] falta la declaracion de "+val_peek(2).sval);
                                                }
break;
case 89:
//#line 398 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                    if(ambitoCheck != null){
                                        if (val_peek(1).arbol!=null && val_peek(0).arbol!=null){
                                           Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                           Main.tablaDeSimbolos.eliminarSimbolo(val_peek(3).sval);
                                           AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                           atributosId.setAmbito(ambito);
                                           atributosId.setTipo(Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo());
                                           Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                           AtributosTablaS atributos = new AtributosTablaS("AsignacionConControl");
                                           atributos.setAmbito(ambito);
                                           atributos.setTipo(val_peek(1).sval);
                                           AtributosTablaS atributos2 = new AtributosTablaS("Control con retorno");
                                           atributos2.setAmbito(ambito);
                                           atributos2.setTipo(val_peek(1).sval);
                                           NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos2),atributos);
                                           if (nodoA.getTipo()!=null){
                                               yyval.arbol= nodoA;
                                           }
                                           else{
                                               Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                           }
                                    }else
                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "]  falta la declaracion de "+val_peek(3).sval);
                                   }
                                   }
break;
case 91:
//#line 427 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta '=:' en la asignacion");}
break;
case 92:
//#line 428 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta '=:' en la asignacion");}
break;
case 93:
//#line 429 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la expresion aritmetica en la asignacion");}
break;
case 94:
//#line 430 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador en la asignacion");}
break;
case 95:
//#line 431 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador en la asignacion");}
break;
case 96:
//#line 434 "gramatica.y"
{if(Main.tablaDeSimbolos.getTipoFuncionDeRetorno(ambito,val_peek(0).sval)){
                                            AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                            retorno.setAmbito(ambito);
                                            yyval.arbol = new NodoRetorno(val_peek(0).arbol,null,retorno);
                                        }
                                        else{
                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe la funcion, el valor a retornar o el tipo del mismo es diferente al de la funcion ");
                                            yyval.arbol = null;
                                        }
                                      }
break;
case 98:
//#line 447 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 99:
//#line 450 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;
                               yyval.sval = val_peek(0).sval;
                               }
break;
case 100:
//#line 453 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 atributos.setAmbito(ambito);
	                 	                                 yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                                 yyval.sval = val_peek(0).sval;
	                 	                                 }
break;
case 101:
//#line 460 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              atributos.setAmbito(ambito);
	                 	                 	              yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                 	                 	              yyval.sval = val_peek(0).sval;
	                                                    }
break;
case 103:
//#line 469 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el termino luego de un '+' ");}
break;
case 104:
//#line 470 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el termino luego de un '-' ");}
break;
case 105:
//#line 473 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          yyval.sval = val_peek(0).sval;
                             }
break;
case 106:
//#line 479 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol,atributos);
	                          yyval.sval = val_peek(0).sval;
	                          }
break;
case 107:
//#line 485 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;
	             yyval.sval = val_peek(0).sval;}
break;
case 109:
//#line 490 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el factor luego de un '*' ");}
break;
case 110:
//#line 491 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el factor luego de un '/' ");}
break;
case 111:
//#line 492 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el termino antes de un '*' ");}
break;
case 112:
//#line 493 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el termino antes de un '/' ");}
break;
case 113:
//#line 496 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
              if(ambitoCheck != null){
                  AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                  Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                  String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                  atributos.setTipo(tipoId);
                  if(atributos.getAmbito().equals(""))
                    atributos.setAmbito(ambito);
                  yyval.arbol = new NodoHoja(atributos);
                  yyval.sval = tipoId;
              }
              else{
                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] falta la declaracion de "+val_peek(0).sval);
                    yyval.arbol = null;
                    }
              }
break;
case 114:
//#line 512 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                         yyval.sval = "f32";
                       }
break;
case 115:
//#line 517 "gramatica.y"
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
//#line 525 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      yyval.arbol = val_peek(0).arbol;
                      yyval.sval = val_peek(0).sval;
                      }
break;
case 117:
//#line 529 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       atributos.setAmbito(ambito);
                       yyval.arbol = new NodoHoja(atributos);
                       yyval.sval = "i32";
                       }
                      }
break;
case 118:
//#line 536 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               atributos.setAmbito(ambito);
                               yyval.arbol = new NodoHoja(atributos);
                               yyval.sval = "f32";
                               }
                           }
break;
case 119:
//#line 545 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(3).sval,ambito);
                                            boolean recursionCheck = Main.tablaDeSimbolos.chequearRecursionFuncion(val_peek(3).sval,ambito);
                                            String usoAmbitoCheck = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso();
                                            if((ambitoCheck != null) && (recursionCheck) && usoAmbitoCheck.equals("nombreFuncion")){
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
                                                            lexInvocacion.setTipo(Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo());
                                                            AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                            yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),val_peek(1).arbol,lexInvocacion);
                                                            yyval.sval = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
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
                                                      else{
                                                          if(ambitoCheck == null){
                                                              Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                                                              yyval.arbol = null;
                                                              }
                                                          if (!recursionCheck){
                                                              Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] la funcion se esta queriendo autoinvocar ");
                                                              yyval.arbol = null;
                                                          }
                                                      }
                                            }
break;
case 120:
//#line 593 "gramatica.y"
{  String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                            boolean recursionCheck = Main.tablaDeSimbolos.chequearRecursionFuncion(val_peek(2).sval,ambito);
                            if((ambitoCheck != null)&& (recursionCheck)){
                                if(lista_parametros.size() == lista_parametros_reales.size()){
                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);
                                    AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion sin parametros");
                                    lexInvocacion.setAmbito(ambito);
                                    lexInvocacion.setTipo(Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo());
                                    AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval+"."+ambito);
                                    yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),null,lexInvocacion);
                                    yyval.sval = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                }
                                else{
                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] faltan el/los parametros en la invocacion ");
                                    yyval.arbol = null;
                                }
                            }
                            else{
                                if(ambitoCheck == null){
                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                                    yyval.arbol = null;
                                    }
                                if (!recursionCheck){
                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] la funcion se esta queriendo autoinvocar ");
                                    yyval.arbol = null;
                                }
                            }
                         }
break;
case 122:
//#line 624 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el ')' de cierre de la invocacion ");}
break;
case 123:
//#line 625 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el ')' de cierre de la invocacion ");}
break;
case 124:
//#line 628 "gramatica.y"
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
//#line 638 "gramatica.y"
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
//#line 653 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta una ',' entre los dos parametros reales ");}
break;
case 128:
//#line 654 "gramatica.y"
{Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el numero maximo de parametros soportados es de dos ");}
break;
case 129:
//#line 655 "gramatica.y"
{Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el numero maximo de parametros soportados es de dos ");}
break;
case 130:
//#line 658 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(0).sval,ambito);
                      if(ambitoCheck != null){
                          AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval+"."+ambito);
                          atributos.setAmbito(ambito);
                          String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                          atributos.setTipo(tipoId);
                          Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                          yyval.arbol = new NodoHoja(atributos);
                          yyval.sval = ambitoCheck;
                          }else{
                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] falta la declaracion de "+val_peek(0).sval);
                            yyval.arbol = null;
                          }
                          }
break;
case 131:
//#line 672 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoHoja(atributos);
                                    yyval.sval = val_peek(0).sval;
                                   }
break;
case 132:
//#line 678 "gramatica.y"
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
//#line 686 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = val_peek(0).sval;
                                            }
                                  }
break;
case 134:
//#line 693 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = val_peek(0).sval;
                                            }
                                       }
break;
case 135:
//#line 701 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);
                                            yyval.sval = val_peek(0).sval;}
break;
case 137:
//#line 710 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la palabra reservada IF ");}
break;
case 138:
//#line 711 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '(' de la sentencia IF ");}
break;
case 139:
//#line 712 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la condicion de la sentencia IF ");}
break;
case 140:
//#line 713 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el ')' de la sentencia IF ");}
break;
case 141:
//#line 714 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el bloque ejecutable de la sentencia IF ");}
break;
case 142:
//#line 717 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    yyval.sval = val_peek(1).sval;
                                    }
break;
case 143:
//#line 722 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                 yyval.sval = val_peek(1).sval;
                                                }
break;
case 145:
//#line 730 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta palabra reservada ENDIF ");}
break;
case 146:
//#line 731 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta palabra reservada ENDIF ");}
break;
case 147:
//#line 732 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta palabra reservada ENDIF ");}
break;
case 148:
//#line 736 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);}
break;
case 149:
//#line 739 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          atributos.setAmbito(ambito);
                                          yyval.arbol = new NodoCuerpoThen(val_peek(1).arbol,null,atributos);}
break;
case 150:
//#line 742 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                atributos.setAmbito(ambito);
                                atributos.setTipo(val_peek(0).sval);
                                yyval.arbol = new NodoCuerpoThen(val_peek(0).arbol,null,atributos);
                                yyval.sval = val_peek(0).sval;}
break;
case 152:
//#line 750 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             atributos.setAmbito(ambito);
                             yyval.arbol = new NodoCuerpoElse(val_peek(0).arbol,null,atributos);}
break;
case 153:
//#line 753 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoElse(val_peek(1).arbol,null,atributos);}
break;
case 154:
//#line 756 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                     atributos.setAmbito(ambito);
                                     atributos.setTipo(val_peek(0).sval);
                                     yyval.arbol = new NodoCuerpoElse(val_peek(0).arbol,null,atributos);
                                     yyval.sval = val_peek(0).sval;}
break;
case 156:
//#line 764 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 157:
//#line 765 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 158:
//#line 768 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 159:
//#line 769 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 160:
//#line 770 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 161:
//#line 771 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el valor de retorno por defecto ");}
break;
case 162:
//#line 774 "gramatica.y"
{ yyval.arbol = val_peek(0).arbol;
                                yyval.sval = val_peek(0).sval;}
break;
case 163:
//#line 776 "gramatica.y"
{yyval.sval = val_peek(1).sval;
                                            yyval.arbol = val_peek(1).arbol;}
break;
case 165:
//#line 781 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 166:
//#line 782 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 167:
//#line 786 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  atributos.setAmbito(ambito);
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                                  atributos2.setAmbito(ambito);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 169:
//#line 794 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta una expresion aritmetica en la condicion ");}
break;
case 170:
//#line 795 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta una expresion aritmetica en la condicion ");}
break;
case 171:
//#line 796 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] condicion mal declarada ");}
break;
case 172:
//#line 799 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 173:
//#line 800 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 174:
//#line 801 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 175:
//#line 802 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 176:
//#line 803 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 177:
//#line 804 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 178:
//#line 807 "gramatica.y"
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
                                                                                            yyval.sval = val_peek(0).sval;
                                                                                          }
                                                                                          else
                                                                                              yyval.arbol = null;
                                                                                        }
break;
case 179:
//#line 827 "gramatica.y"
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
case 180:
//#line 846 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 181:
//#line 849 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el contenido dentro de los parentensis del for");}
break;
case 182:
//#line 852 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 183:
//#line 856 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval)), null, atributos1);}
break;
case 184:
//#line 860 "gramatica.y"
{ yyval.arbol = null;}
break;
case 185:
//#line 863 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el signo '+' o '-' antes de la constante");}
break;
case 186:
//#line 864 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la constante entera luego del '-'");}
break;
case 187:
//#line 865 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la constante entera luego del '+'");}
break;
case 188:
//#line 866 "gramatica.y"
{Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el incremento debe ser un numero entero");}
break;
case 189:
//#line 867 "gramatica.y"
{Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el decremento debe ser un numero entero");}
break;
case 190:
//#line 870 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(val_peek(2).sval,ambito);
                                        if(ambitoCheck != null){
                                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                            if(tipoId.equals("i32")){
                                                if (chequearRangoEnteros()==true){
                                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
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
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                                        yyval.arbol= null;
                                                    }
                                                }
                                                else{
                                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el numero a asignar esta fuera de rango");
                                                    yyval.arbol= null;
                                                }
                                            }
                                            else{
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el tipo declarado para el id es incorrecto");
                                                yyval.arbol= null;
                                            }
                                        }
                                        else{
                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] falta la declaracion de "+val_peek(2).sval);
                                            yyval.arbol= null;
                                        }
                                        }
break;
case 192:
//#line 908 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 193:
//#line 909 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 194:
//#line 910 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 195:
//#line 913 "gramatica.y"
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
                                                       Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe el id "+ val_peek(2).sval +" en ningun ambito alcanzable. Imposible determinar rango de control");
                                                       yyval.arbol = null;
                                                   }
                                                   }
break;
case 197:
//#line 932 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el identificador en la condicion de la sentencia FOR ");}
break;
case 198:
//#line 933 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el comparador en la condicion de la sentencia FOR ");}
break;
case 199:
//#line 934 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 200:
//#line 937 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          lexSalida.setAmbito(ambito);
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(1).sval);
                          lexCadena.setAmbito(ambito);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 202:
//#line 947 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el '(' que encierra la cadena ");}
break;
case 203:
//#line 948 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta la cadena que se quiere imprimir ");}
break;
case 204:
//#line 949 "gramatica.y"
{Main.erroresSintacticos.add("[Parser | Linea " + Lexico.linea + "] falta el ')' que encierra la cadena ");}
break;
//#line 2310 "Parser.java"
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
