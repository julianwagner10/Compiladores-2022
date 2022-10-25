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
//#line 21 "Parser.java"




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
   51,   26,   26,   26,   55,   55,   55,   55,   53,   53,
   56,   56,   56,   54,   54,   57,   57,   57,   27,   27,
   58,   58,   58,
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
    1,   10,   10,    1,    9,    9,    9,    4,    3,    1,
    2,    2,    2,    3,    1,    2,    2,    2,    4,    1,
    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   89,   96,  120,  133,  174,  190,    0,    0,    0,    0,
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
    0,    0,  165,    0,    0,    0,  191,    0,  192,   50,
    0,    0,   40,    0,   70,   54,    0,    0,    0,    0,
  180,   64,    0,   19,   16,   27,   23,   32,    0,   30,
   57,  130,  131,    0,   41,  121,  118,    0,  126,   35,
  122,  119,  102,    0,  103,    0,  108,  104,  109,  105,
    0,    0,  136,  141,    0,  137,    0,  135,  189,   37,
    0,   38,   36,  182,    0,  181,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   81,  178,  158,
    0,  134,   31,   28,    0,  124,    0,    0,    0,    0,
    0,  147,    0,    0,  132,   39,   33,  179,    0,    0,
   82,   78,    0,   83,    0,   79,    0,    0,   12,  159,
   13,   72,   74,   76,   77,    0,    0,    0,  185,    0,
   42,   14,    0,  151,   15,    0,    0,    0,  150,  139,
    0,    0,   73,   84,    0,   85,  157,    0,    0,    0,
    0,    0,  146,    0,    0,    0,    0,  142,  140,   75,
   86,   80,    0,    0,    0,    0,   46,    0,  154,  153,
    0,    0,    0,    0,    0,  149,  175,    0,  177,    0,
  176,  172,  173,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,   24,   25,  222,  223,  240,   26,
   27,   28,   29,   30,   31,   32,   54,   33,   55,   56,
   57,   34,   35,   36,   37,   38,   39,   40,  228,   79,
   41,   42,   68,   69,   70,   71,  135,   43,  136,  137,
   80,  203,   44,  241,  278,  204,  242,  279,  229,  230,
   81,   82,  170,  268,   45,  171,  269,   46,
};
final static short yysindex[] = {                       -92,
 -105,   89,    0,    0,   89,   89,    0,   18,  143,  700,
   -6,   71,  665,  136,  -21,    0,    0, -229, -237,  694,
    7,    0,    0,    0,    0,   54,   98,    0,    0,    0,
  -18,    0,    0,  -32,    5,   77,  130,  234,  285,    0,
    0,    0,    0,    0,    0,    0,  118,  142,  460,  406,
   28,   93, -202,   17,   60,    0,    0,   27,   59,    0,
    0, -189,  -41,  -41,    0,    0,   38,   21,    0,    0,
    0,    0,    0,    0,  585,    0,    0,    0,  707,   62,
  665,    0,   67,   12, -145,   14,  -16,   72,   38,   59,
    0,  361,  -34,    0,   78,   76,    0,    0,    0,    0,
  116,    0,    0, -129,   44,  164,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   59,
    0,   38,    0,    0,   38,    0,   80, -145,    0,    0,
    0,    0, -104,   -5,   48,  139,    0,    0,  -97,    0,
    0,  431,    0,    0,    0,    0,  528,  594,  523,  551,
 -141,  -12,    0,  665, -141,   38,    0,  115,    0,    0,
  -97,  -44,    0,  -97,    0,    0, -214, -137,  -38,  105,
    0,    0, -141,    0,    0,    0,    0,    0,   66,    0,
    0,    0,    0, -136,    0,    0,    0,  151,    0,    0,
    0,    0,    0,   21,    0,   21,    0,    0,    0,    0,
  345,  345,    0,    0, -140,    0,   38,    0,    0,    0,
  -79,    0,    0,    0,  -71,    0,  347,  384,  -65,  437,
  185,  246,    0,  135,  140,  150,  152,    0,    0,    0,
  670,    0,    0,    0,   53,    0,   42,  464,    0,  364,
  -93,    0, -100,  345,    0,    0,    0,    0,  143, -237,
    0,    0,  153,    0,  228,    0,  273,  259,    0,    0,
    0,    0,    0,    0,    0,  694,  665,  282,    0, -136,
    0,    0,  387,    0,    0,  412,  464,  -67,    0,    0,
  -58,  309,    0,    0,  403,    0,    0,   38,  665,   38,
  -30,  340,    0,  464,    0,  427,  440,    0,    0,    0,
    0,    0,   38,  373,   11,   15,    0,  451,    0,    0,
  -38,  383,  -38,  385,  -38,    0,    0,  -38,    0,  -38,
    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,  119,    0,    0,
    0,    0,  410,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  425,    0,    0,
    0,    0,   49,    0,    0,    0,    0,    0,  497,    0,
    0,    0,    0,    0,    0,    0,  447,  538,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  467,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  729,
    0,  470,    0,    0,  487,    0,    0,  371,    0,    0,
    0,  144,    0,   20,    0,   68,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   63,    0,  108,    0,  488,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  563,    0,  612,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  111,    0,    0,    0,
    0,    0,    0,    0,  372,    0,    0,    0,    0,    0,
    0,    0,  209,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  321,    0,
    0,    0,  490,  492,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  521,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  572,    0,    0,    0,    0,    0,    0,    0,
  534,    0,    0,    0,    0,    0,    0,  377,  380,  388,
    0,    0,    0,    0,  298,    0,    0,    0,    0,    0,
    0,    0,  396,    0,    0,    0,    0,  122,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
final static short yygindex[] = {                         0,
   61,    0,  754,    0,    0,  733,  211,  -99, -203,    9,
  430,    0,    0,    0,    0,    0,   45,    0,  -49,    0,
    0,  596,   -4,  627,    0,   -8,  661,    0,    0,   -1,
    0,    0,   58,    0,  -31,    0,    0,    0,  -74,    0,
    4,  659,    0,  261,  218,    0,    0,    0,  566,    0,
  -59,    0,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=1041;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   66,   20,  134,   62,   65,   65,  169,   67,   65,   92,
   95,   89,  305,  211,  306,   65,   53,    6,   93,  154,
   53,   20,  277,   96,  163,   18,  108,   94,  205,  277,
    2,  145,  146,   84,  273,  185,   15,  134,  184,   19,
  121,  124,  127,  214,   65,   65,   20,  122,  125,  215,
   18,  313,  159,   87,  138,  315,   88,   52,   65,   65,
   53,  189,  149,  109,   19,   47,   48,  150,  143,  144,
   65,  161,  296,  297,  139,   51,   65,   45,  152,  156,
  147,  142,  148,   20,  221,  141,  126,   18,  187,   49,
  308,  106,   49,  271,   53,   53,  270,   18,  142,   51,
  140,   19,  155,  164,  105,   20,   49,  157,  123,   18,
   87,  160,  100,  236,  201,  244,  173,  198,  200,   85,
  216,  259,  261,   19,  202,  202,  176,  177,   20,  164,
  162,   97,   18,  132,  235,  111,  172,  133,  181,   16,
   17,  104,   65,   65,   65,   65,   19,  190,  163,   65,
    5,  161,  207,  182,  183,  209,  103,   20,  261,  104,
  226,   18,   22,  231,    1,  179,  276,  280,  178,  210,
  212,  267,  213,  276,  175,   19,  246,   22,   16,   17,
  155,   20,  188,  133,   63,   18,  248,   62,  113,   64,
  234,   90,   53,  262,   91,  133,   16,   17,  263,   19,
  298,   40,  119,   20,  194,  196,  289,   18,  264,  299,
  265,  283,  226,  226,  253,   59,   60,   61,  217,  247,
  292,   19,  167,  107,   20,    9,   10,  304,   58,  168,
   11,   16,   17,  218,  219,   15,  220,    7,    8,   85,
  121,  282,  118,  201,   65,    9,   10,  122,   12,  226,
   11,   12,   13,  202,   14,   15,   83,   16,   17,   16,
   17,   65,   65,    8,  288,  290,  119,  156,  312,   85,
    9,   10,  314,   49,  158,   11,   12,   13,   53,   14,
   15,   50,   16,   17,   65,   20,  284,  303,  180,   16,
   17,   15,  115,   16,   17,   45,   45,  249,   20,    7,
    8,   15,  226,  186,  226,   50,  226,    9,   10,  226,
   99,  226,   11,   12,   13,   15,   14,   15,  164,   16,
   17,  233,    8,  123,   49,   49,   85,   86,  164,    9,
   10,  286,  110,   12,   11,   12,   13,   14,   14,   15,
  291,   16,   17,  117,    7,    8,   16,   17,  128,  129,
  130,  131,    9,   10,  102,   14,  148,   11,   12,   13,
   14,   14,   15,  163,   16,   17,  161,  300,   16,   17,
  260,  174,  102,  163,    8,   22,  161,  155,   14,  145,
  307,    9,   10,  287,   20,  112,   11,   12,   13,  155,
   14,   15,   90,   16,   17,  129,  130,  131,    8,   59,
   60,   61,   19,   20,  250,    9,   10,  129,  130,  131,
   11,   12,   13,  311,   14,   15,   15,   16,   17,  166,
    8,   19,   14,  318,    5,  320,   20,    9,   10,  122,
  183,  258,   11,   12,   13,  187,   14,   15,  188,   16,
   17,  217,  252,  145,   19,   14,  186,   63,    9,   10,
   62,   20,   64,   11,  184,  101,  218,  219,   15,  220,
  281,  302,  243,    0,  156,   12,   20,  238,   97,   19,
    0,  192,   12,   12,    0,  133,    0,   12,    0,   20,
   12,   12,   12,   12,   19,    0,    0,    0,  274,  114,
   20,    0,    0,    0,  257,  256,    0,   19,    0,    0,
    0,   63,  217,   20,   62,   93,   64,    0,   19,    9,
   10,  293,    0,    0,   11,  217,    0,  218,  219,   15,
  220,   19,    9,   10,    0,   95,    0,   11,   90,  285,
  218,  219,   15,  220,  294,    0,    0,  112,  112,  112,
  116,  112,    0,  112,    0,   87,  193,    0,  143,    0,
  138,  309,    0,  148,   14,  112,  112,  112,  112,    0,
    0,   14,   14,    0,  310,  148,   14,   62,   14,   63,
   14,   14,   62,    0,   64,  316,  145,   14,   98,  160,
   98,    0,   98,    0,   14,   14,    0,  145,  145,   14,
    0,   14,  144,   14,   14,   62,   98,   98,   98,   98,
    0,  237,  249,   99,    0,   99,    0,   99,    9,   10,
   50,    0,    0,   11,    0,   13,  165,   14,   15,    0,
  237,   99,   99,   99,   99,  151,   63,    9,   10,   62,
  152,   64,   11,    0,   13,   63,   14,   15,   62,  251,
   64,    0,    0,  237,   76,   78,   77,    0,    0,    0,
    9,   10,  100,    0,  100,   11,  100,   13,  301,   14,
   15,  123,   59,   60,   61,   97,    0,    0,  237,    0,
  100,  100,  100,  100,    0,    9,   10,    0,    0,   15,
   11,    0,   13,  237,   14,   15,  191,  129,  130,  131,
    9,   10,  254,  255,  152,   11,  237,   13,    0,   14,
   15,    0,   93,    9,   10,    0,   63,  237,   11,   62,
   13,   64,   14,   15,    9,   10,  120,   60,   61,   11,
  237,   13,   95,   14,   15,   90,    0,    9,   10,   76,
   78,   77,   11,   15,   13,   63,   14,   15,   62,   75,
   64,   63,   87,  193,   62,  143,   64,  138,    0,  147,
    0,  148,  112,   76,   78,   77,  112,  112,  112,   76,
   78,   77,  112,    0,  224,    0,   76,   78,   77,   50,
  112,  112,    0,  112,   98,  112,  160,    0,  197,   59,
   60,   61,    0,  193,   59,   60,   61,  112,    0,  144,
    0,    0,    0,   98,    0,  225,    0,   98,   98,   98,
   98,   98,    0,   98,    0,    0,  199,   59,   60,   61,
  206,    0,    0,  208,    0,    0,  224,  224,   99,    0,
    0,    0,   99,   99,   99,    0,    0,  152,   99,  227,
    0,  232,    0,    0,    0,    0,    0,    0,  152,  152,
    0,   59,   60,   61,   72,   73,   74,  225,  225,  195,
   59,   60,   61,  224,    0,    0,    0,    0,    0,   98,
    0,    0,    0,  245,    0,    0,    0,  100,    0,    0,
    0,  100,  100,  100,    0,    0,  317,  100,  319,    0,
  321,  227,  227,  322,  225,  323,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  224,    0,  224,    0,
  224,    0,    0,  224,    0,  224,    0,    0,  227,    0,
    0,   59,   60,   61,    0,    0,  266,    0,    0,   72,
   73,   74,   98,  239,  239,    0,    0,  225,    0,  225,
    0,  225,    0,    0,  225,    0,  225,    0,    0,    0,
   59,   60,   61,   72,   73,   74,   59,   60,   61,   72,
   73,   74,  153,    0,    0,    0,   72,   73,   74,    0,
  272,  227,  275,  227,    0,  227,  239,    0,  227,    0,
  227,    0,    0,    0,  112,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  275,    0,    0,  295,  272,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  272,    0,  275,  275,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  275,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          8,
    9,   40,   52,   45,    9,   10,   41,    9,   13,   14,
   19,   13,   43,   58,   45,   20,    8,  123,   40,   79,
   12,   40,  123,   20,   41,   44,   59,  257,   41,  123,
  123,   63,   64,   40,  238,   41,  274,   87,   44,   58,
   49,   50,   51,  258,   49,   50,   40,   49,   50,  264,
   44,   41,   41,   40,  257,   41,   12,   40,   63,   64,
   52,  136,   42,   59,   58,    5,    6,   47,  258,  259,
   75,   58,  276,  277,   58,   58,   81,   58,   75,   81,
   43,   40,   45,   40,  123,   59,   59,   44,   41,   41,
  294,   31,   44,   41,   86,   87,   44,   44,   40,   58,
   41,   58,   41,   41,  123,   40,   58,   41,   41,   44,
   40,  257,   59,  188,  256,  256,   41,  149,  150,  256,
  258,  221,  222,   58,  266,  266,  256,  257,   40,   58,
   86,  125,   44,   41,  184,   59,   59,   45,   59,  276,
  277,   44,  147,  148,  149,  150,   58,  139,   41,  154,
  256,   41,  154,  258,  259,   41,   59,   40,  258,   44,
  169,   44,   44,   59,  257,  105,  267,  268,  125,  161,
  162,  231,  164,  267,   59,   58,  256,   59,  276,  277,
   59,   40,   44,   45,   42,   44,  258,   45,   59,   47,
  125,  257,  184,   59,   59,   45,  276,  277,   59,   58,
  268,   58,   59,   40,  147,  148,  266,   44,   59,  268,
   59,   59,  221,  222,  219,  257,  258,  259,  257,  211,
  270,   58,  257,  256,   40,  264,  265,  258,  237,  264,
  269,  276,  277,  272,  273,  274,  275,  256,  257,  256,
  249,  250,  125,  256,  249,  264,  265,  249,   40,  258,
  269,  270,  271,  266,  273,  274,  263,  276,  277,  276,
  277,  266,  267,  257,  266,  267,  125,   59,  258,  256,
  264,  265,  258,  256,  263,  269,  270,  271,  270,  273,
  274,  264,  276,  277,  289,   40,   59,  289,  125,  276,
  277,  274,   59,  276,  277,  276,  277,  256,   40,  256,
  257,  274,  311,  256,  313,  264,  315,  264,  265,  318,
  257,  320,  269,  270,  271,  274,  273,  274,  256,  276,
  277,  256,  257,  256,  276,  277,  256,  257,  266,  264,
  265,   59,  256,  125,  269,  270,  271,   40,  273,  274,
   59,  276,  277,   59,  256,  257,  276,  277,  256,  257,
  258,  259,  264,  265,  257,   58,   59,  269,  270,  271,
   40,  273,  274,  256,  276,  277,  256,   59,  276,  277,
  125,  256,  257,  266,  257,  257,  266,  256,   58,   59,
   41,  264,  265,  125,   40,  256,  269,  270,  271,  268,
  273,  274,  257,  276,  277,  257,  258,  259,  257,  257,
  258,  259,   58,   40,   58,  264,  265,  257,  258,  259,
  269,  270,  271,   41,  273,  274,  274,  276,  277,   59,
  257,   58,  125,   41,    0,   41,   40,  264,  265,   59,
   59,  221,  269,  270,  271,   59,  273,  274,   59,  276,
  277,  257,   59,  123,   58,  125,   59,   42,  264,  265,
   45,   40,   47,  269,   59,   26,  272,  273,  274,  275,
  243,   59,  202,   -1,  256,  257,   40,  123,   59,   58,
   -1,   41,  264,  265,   -1,   45,   -1,  269,   -1,   40,
  272,  273,  274,  275,   58,   -1,   -1,   -1,  125,  256,
   40,   -1,   -1,   -1,   58,   59,   -1,   58,   -1,   -1,
   -1,   42,  257,   40,   45,   59,   47,   -1,   58,  264,
  265,  125,   -1,   -1,  269,  257,   -1,  272,  273,  274,
  275,   58,  264,  265,   -1,   59,   -1,  269,   59,  257,
  272,  273,  274,  275,  123,   -1,   -1,   41,   42,   43,
  256,   45,   -1,   47,   -1,   59,   59,   -1,   59,   -1,
   59,  125,   -1,  256,  257,   59,   60,   61,   62,   -1,
   -1,  264,  265,   -1,  125,  268,  269,   45,  271,   42,
  273,  274,   45,   -1,   47,  125,  256,  257,   41,   59,
   43,   -1,   45,   -1,  264,  265,   -1,  267,  268,  269,
   -1,  271,   59,  273,  274,   45,   59,   60,   61,   62,
   -1,  257,  256,   41,   -1,   43,   -1,   45,  264,  265,
  264,   -1,   -1,  269,   -1,  271,  256,  273,  274,   -1,
  257,   59,   60,   61,   62,   41,   42,  264,  265,   45,
   59,   47,  269,   -1,  271,   42,  273,  274,   45,  256,
   47,   -1,   -1,  257,   60,   61,   62,   -1,   -1,   -1,
  264,  265,   41,   -1,   43,  269,   45,  271,  256,  273,
  274,  256,  257,  258,  259,  256,   -1,   -1,  257,   -1,
   59,   60,   61,   62,   -1,  264,  265,   -1,   -1,  274,
  269,   -1,  271,  257,  273,  274,  256,  257,  258,  259,
  264,  265,  256,  257,  123,  269,  257,  271,   -1,  273,
  274,   -1,  256,  264,  265,   -1,   42,  257,  269,   45,
  271,   47,  273,  274,  264,  265,  257,  258,  259,  269,
  257,  271,  256,  273,  274,  256,   -1,  264,  265,   60,
   61,   62,  269,  274,  271,   42,  273,  274,   45,   40,
   47,   42,  256,  256,   45,  256,   47,  256,   -1,   43,
   -1,   45,  256,   60,   61,   62,  260,  261,  262,   60,
   61,   62,  266,   -1,  169,   -1,   60,   61,   62,   41,
   42,   43,   -1,   45,   21,   47,  256,   -1,  256,  257,
  258,  259,   -1,  256,  257,  258,  259,   59,   -1,  256,
   -1,   -1,   -1,  256,   -1,  169,   -1,  260,  261,  262,
   47,   48,   -1,  266,   -1,   -1,  256,  257,  258,  259,
  152,   -1,   -1,  155,   -1,   -1,  221,  222,  256,   -1,
   -1,   -1,  260,  261,  262,   -1,   -1,  256,  266,  169,
   -1,  173,   -1,   -1,   -1,   -1,   -1,   -1,  267,  268,
   -1,  257,  258,  259,  260,  261,  262,  221,  222,  256,
  257,  258,  259,  258,   -1,   -1,   -1,   -1,   -1,  106,
   -1,   -1,   -1,  205,   -1,   -1,   -1,  256,   -1,   -1,
   -1,  260,  261,  262,   -1,   -1,  311,  266,  313,   -1,
  315,  221,  222,  318,  258,  320,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  311,   -1,  313,   -1,
  315,   -1,   -1,  318,   -1,  320,   -1,   -1,  258,   -1,
   -1,  257,  258,  259,   -1,   -1,  257,   -1,   -1,  260,
  261,  262,  179,  201,  202,   -1,   -1,  311,   -1,  313,
   -1,  315,   -1,   -1,  318,   -1,  320,   -1,   -1,   -1,
  257,  258,  259,  260,  261,  262,  257,  258,  259,  260,
  261,  262,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
  238,  311,  240,  313,   -1,  315,  244,   -1,  318,   -1,
  320,   -1,   -1,   -1,  256,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  273,   -1,   -1,  276,  277,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  294,   -1,  296,  297,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  308,
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

//#line 415 "gramatica.y"

private Lexico lexico;
private ArbolSintactico arbolSintactico;

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
	return "xd";
}

public ArbolSintactico returnTree(){
	return this.arbolSintactico;
}

//#line 803 "Parser.java"
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
//#line 13 "gramatica.y"
{arbolSintactico = val_peek(1).arbol;
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
break;
case 2:
//#line 16 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
//#line 19 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
//#line 20 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
//#line 21 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
//#line 24 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 7:
//#line 25 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                           yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 9:
//#line 30 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
break;
case 11:
//#line 34 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 14:
//#line 41 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 15:
//#line 42 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableIf");
                                                      yyval.arbol = new NodoBloqueEjecutable(val_peek(1).arbol,val_peek(0).arbol,atributos);}
break;
case 16:
//#line 53 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 58 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 59 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
//#line 60 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
//#line 63 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 23:
//#line 64 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + val_peek(0).sval);}
break;
case 25:
//#line 68 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 69 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 70 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 73 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
//#line 77 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
//#line 78 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
//#line 79 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 35:
//#line 86 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
//#line 87 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
//#line 88 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
//#line 89 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
//#line 90 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 44:
//#line 99 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 100 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 101 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
//#line 108 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 109 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 112 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
//#line 113 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 53:
//#line 116 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 54:
//#line 117 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 55:
//#line 118 "gramatica.y"
{yyval.arbol = val_peek(1).arbol;}
break;
case 57:
//#line 120 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);}
break;
case 61:
//#line 126 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
//#line 127 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
//#line 128 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
//#line 129 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
//#line 130 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
//#line 131 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
//#line 132 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
//#line 133 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
//#line 134 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
//#line 135 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
//#line 136 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 73:
//#line 140 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 75:
//#line 142 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +val_peek(3).sval);}
break;
case 78:
//#line 145 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 79:
//#line 146 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 80:
//#line 147 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +val_peek(1).sval);}
break;
case 82:
//#line 151 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 83:
//#line 152 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
//#line 153 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
//#line 154 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
//#line 155 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 87:
//#line 160 "gramatica.y"
{AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval);
                                                AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                yyval.arbol= new NodoAsignacion(new NodoHoja(null,null,atributosId),val_peek(0).arbol,atributos);
                                                }
break;
case 88:
//#line 164 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                   AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval);
                                   AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                   yyval.arbol= new NodoAsignacion(new NodoHoja(null,null,atributosId),val_peek(0).arbol,atributos);
                                   }
break;
case 90:
//#line 172 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 91:
//#line 173 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
//#line 174 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 93:
//#line 175 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 94:
//#line 176 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 97:
//#line 183 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 98:
//#line 186 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 99:
//#line 187 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                          yyval.arbol = new NodoSuma(val_peek(2).arbol,val_peek(0).arbol);
	                                                    }
break;
case 100:
//#line 190 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	            yyval.arbol = new NodoResta(val_peek(2).arbol,val_peek(0).arbol);
	                                                    }
break;
case 102:
//#line 196 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 103:
//#line 197 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 104:
//#line 200 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          yyval.arbol = new NodoMultiplicacion(val_peek(2).arbol,val_peek(0).arbol);
                             }
break;
case 105:
//#line 203 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          yyval.arbol = new NodoDivision(val_peek(2).arbol,val_peek(0).arbol);
	                          }
break;
case 106:
//#line 206 "gramatica.y"
{yyval.arbol = val_peek(0).arbol;}
break;
case 108:
//#line 210 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 109:
//#line 211 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 110:
//#line 212 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 111:
//#line 213 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 112:
//#line 216 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
              yyval.arbol = new NodoHoja(null,null,atributos);
              }
break;
case 113:
//#line 219 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        yyval.arbol = new NodoHoja(null,null,atributos);
                       }
break;
case 114:
//#line 222 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                        yyval.arbol = new NodoHoja(null,null,atributos);
                        }
                   }
break;
case 115:
//#line 227 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                      yyval.arbol = new NodoHoja(null,null,atributosId);
                      }
break;
case 116:
//#line 231 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                       yyval.arbol = new NodoHoja(null,null,atributos);
                       }
                      }
break;
case 117:
//#line 236 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                               yyval.arbol = new NodoHoja(null,null,atributos);
                               }
                           }
break;
case 118:
//#line 243 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 119:
//#line 244 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);}
break;
case 121:
//#line 248 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 122:
//#line 249 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 126:
//#line 257 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 127:
//#line 260 "gramatica.y"
{ AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                          yyval.arbol = new NodoHoja(null,null,atributos);
                          }
break;
case 128:
//#line 263 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + val_peek(0).sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                   yyval.arbol = new NodoHoja(null,null,atributos);
                                   }
break;
case 129:
//#line 267 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                               Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + val_peek(0).sval);
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                               yyval.arbol = new NodoHoja(null,null,atributos);
                               }
                               }
break;
case 130:
//#line 273 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(null,null,atributos);
                                            }
                                  }
break;
case 131:
//#line 278 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+val_peek(0).sval);
                                            yyval.arbol = new NodoHoja(null,null,atributos);
                                            }
                                       }
break;
case 132:
//#line 284 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            yyval.arbol = new NodoIf(val_peek(2).arbol,val_peek(0).arbol,atributos);}
break;
case 134:
//#line 290 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 135:
//#line 291 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 136:
//#line 292 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 137:
//#line 293 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 138:
//#line 294 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 139:
//#line 297 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    yyval.arbol = new NodoCuerpoIf(val_peek(1).arbol,null,atributos);
                                    }
break;
case 140:
//#line 300 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                yyval.arbol = new NodoCuerpoIf(val_peek(2).arbol,val_peek(1).arbol,atributos);
                                                }
break;
case 142:
//#line 306 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 143:
//#line 307 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 144:
//#line 308 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 145:
//#line 312 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        yyval.arbol = new NodoElse(val_peek(0).arbol,null,atributos);}
break;
case 146:
//#line 314 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          yyval.arbol = new NodoElse(val_peek(1).arbol,null,atributos);}
break;
case 148:
//#line 319 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             yyval.arbol = new NodoElse(val_peek(0).arbol,null,atributos);}
break;
case 149:
//#line 321 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                yyval.arbol = new NodoElse(val_peek(1).arbol,null,atributos);}
break;
case 151:
//#line 326 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 152:
//#line 327 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 153:
//#line 330 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 154:
//#line 331 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 155:
//#line 332 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 159:
//#line 347 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 160:
//#line 348 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 161:
//#line 352 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(val_peek(1).sval);
                                                        yyval.arbol = new NodoCondicion(new NodoExpresionLogica(val_peek(2).arbol,val_peek(0).arbol,atributos2),null,atributos);}
break;
case 163:
//#line 358 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 164:
//#line 359 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 165:
//#line 360 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 166:
//#line 363 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 167:
//#line 364 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 168:
//#line 365 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 169:
//#line 366 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 170:
//#line 367 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 171:
//#line 368 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 172:
//#line 371 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 173:
//#line 372 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 174:
//#line 373 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 175:
//#line 376 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 176:
//#line 377 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 177:
//#line 378 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 178:
//#line 379 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 179:
//#line 382 "gramatica.y"
{if (chequearRangoEnteros()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(2).sval);
                                            AtributosTablaS atributos2 = new AtributosTablaS("Asignacion");
                                            AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS(val_peek(0).sval);
                                            yyval.arbol= new NodoAsignacion(new NodoHoja(null,null,atributos),new NodoHoja(null,null,atributos3),atributos2);
                                            }
                                      }
break;
case 181:
//#line 392 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 182:
//#line 393 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 183:
//#line 394 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 186:
//#line 401 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 187:
//#line 402 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 188:
//#line 403 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 189:
//#line 406 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 191:
//#line 410 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 192:
//#line 411 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 193:
//#line 412 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1614 "Parser.java"
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
