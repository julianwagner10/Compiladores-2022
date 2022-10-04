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
    9,    9,    6,    6,    6,    6,    6,    6,    6,   27,
   27,   27,   27,   27,   27,   27,   27,    8,    8,    8,
   28,   28,   21,   21,   30,   30,   30,   24,   24,   31,
   29,   29,   29,   29,   33,   33,   32,   32,   32,   32,
   35,   35,   35,   35,   34,   34,   34,   34,   34,   22,
   22,   22,   37,   37,   36,   36,   36,   39,   38,   38,
   38,   38,   23,   23,   23,   42,   42,   42,   42,   42,
   42,   42,   41,   41,   41,   43,   43,   40,   44,   44,
   44,   44,   44,   44,   25,   25,   25,   47,   47,   47,
   45,   45,   48,   48,   48,   46,   46,   49,   49,   49,
   26,   26,   50,   50,   50,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    1,    2,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    2,    3,    2,    2,    2,    1,
    2,    2,    3,    1,    3,    3,    2,    2,    1,    1,
    1,    3,    3,    1,    3,    3,    3,    3,    1,    1,
    3,    3,    2,    2,    1,    1,    1,    1,    2,    4,
    3,    1,    4,    3,    1,    3,    1,    2,    1,    1,
    1,    2,    7,    9,    1,    6,    6,    6,    6,    6,
    6,    7,    1,    3,    1,    2,    2,    3,    1,    1,
    1,    1,    1,    1,   10,   10,    1,    9,    9,    9,
    3,    1,    2,    2,    2,    3,    1,    2,    2,    2,
    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    6,    8,   10,   11,    0,    0,   17,   18,   24,    0,
   29,   34,    0,    0,    0,    0,    0,    0,   59,   74,
   79,  102,  115,  137,  152,    0,    0,    0,    0,    0,
    0,    0,    0,   43,   48,    0,   97,   96,    0,    0,
    0,   98,    0,    0,   84,   89,   90,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   65,    0,
    0,   26,    0,    3,    7,   22,   21,    0,   25,   20,
    0,    0,    0,   60,   53,   67,   61,   55,   64,   56,
   62,   57,   63,   58,    4,    1,    0,    0,   76,    0,
    0,  109,  111,  110,    0,    0,    0,    0,    0,  107,
   47,    0,   44,    0,   99,   93,   94,    0,    0,    0,
    0,    0,    0,  133,  132,  134,  129,  130,  131,    0,
    0,  153,    0,  154,   50,    0,    0,   40,    0,   66,
   54,    0,    0,    0,  142,    0,   19,   16,   27,   23,
   32,    0,   30,  112,    0,   41,  103,  100,    0,  108,
   35,  104,  101,   85,    0,   86,    0,   91,   87,   92,
   88,    0,    0,    0,    0,    0,  151,   37,    0,   38,
   36,  144,    0,  143,    0,    0,   31,   28,    0,  106,
    0,    0,    0,    0,    0,    0,   13,   70,    0,  125,
    0,    0,    0,    0,   39,   33,  141,    0,    0,    0,
  147,    0,    0,   42,    0,   71,   68,   72,   69,   12,
    0,  126,   14,   15,  118,  119,  121,    0,  120,  117,
    0,    0,    0,    0,  116,    0,  124,  122,    0,  113,
    0,    0,    0,    0,   46,    0,    0,    0,    0,    0,
    0,  114,  138,    0,  140,    0,  139,  135,  136,
};
final static short yydgoto[] = {                          3,
   20,    4,   21,   22,   23,  205,  206,  207,   25,   26,
   27,   28,   29,   30,   31,   52,   32,   53,   54,   55,
   33,   34,   35,   36,   37,   38,   39,  208,   69,   40,
   41,   64,   65,   66,   67,  118,   42,  119,  120,   70,
  209,   43,  210,  140,  154,  220,   44,  155,  221,   45,
};
final static short yysindex[] = {                      -109,
 -102,   26,    0,    0,   26,   26,    0,   97,  277,  118,
  -31,  -35,  277,  -53,  -21,    0,    0, -226,  277,   41,
    0,    0,    0,    0,   59,   77,    0,    0,    0,  -40,
    0,    0,  -51,  -12,  -49,  -48,  -47,  -44,    0,    0,
    0,    0,    0,    0,    0,   56,   71,  538,  397,    8,
 -203,    6,   27,    0,    0,   44,    0,    0,  309,  309,
  309,    0,   88,   70,    0,    0,    0,  135,  107,   78,
   79,    9, -165,  -33,   -6,   58,   88,   44,    0,  -42,
 -221,    0,   81,    0,    0,    0,    0,   51,    0,    0,
 -199,  -18,   86,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   44,   88,    0,   88,
 -165,    0,    0,    0,    0,  340,   34,    1,  402,    0,
    0, -175,    0,  165,    0,    0,    0,  428,  435,  370,
  388, -143,  -39,    0,    0,    0,    0,    0,    0,  277,
 -141,    0,   87,    0,    0, -175,  -57,    0, -175,    0,
    0, -224, -131,   73,    0, -128,    0,    0,    0,    0,
    0,    4,    0,    0, -205,    0,    0,    0,  340,    0,
    0,    0,    0,    0,   70,    0,   70,    0,    0,    0,
    0,  186,  186,  139,   88,  186,    0,    0, -183,    0,
    0,    0, -118,    0,  542,  186,    0,    0,   47,    0,
   37,   38,   75,  252,    0,  214,    0,    0, -125,    0,
 -124,  163, -123, -122,    0,    0,    0,  407,  277,   92,
    0, -121, -205,    0,  277,    0,    0,    0,    0,    0,
  239,    0,    0,    0,    0,    0,    0, -169,    0,    0,
   88,  277,   88,   31,    0,  112,    0,    0,  186,    0,
   88,  116,  -23,  -13,    0, -112,  186,  121,  186,  123,
  186,    0,    0,  186,    0,  186,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,   80,    0,    0,
    0,    0,   82,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  159,    0,    0,    0,
  -28,    0,    0,    0,    0,  503,    0,    0,    0,    0,
    0,    0,   90,  357,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  102,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   20,  114,    0,  125,
  111,    0,    0,    0,   46,    0,   11,    0,   48,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  141,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  510,    0,  532,    0,    0,    0,
    0,    0,    0,    0,  -38,    0,    0,    0,    0,    0,
    0,    0,  113,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  115,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  264,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  119,  124,  126,    0,    0,    0,    0,    0,    0,    0,
  127,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   50,    0,   13,    0,    0,  513,  -17, -179,  588,  146,
    0,    0,    0,    0,    0,   12,    0,  -30,    0,    0,
    0,  481,    0,    0,    0,    0,    0,    0,  416,    0,
    0,  -15,    0,  -22,    0,    0,    0,  -87,    0,   22,
  556,    0,    0, -172,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=822;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         19,
  189,  184,  128,   18,   75,   79,   75,   95,   72,   98,
  100,  102,   49,    2,  104,   49,  151,  259,   81,  117,
    6,   19,  219,   76,  146,   18,  234,  261,  164,   49,
   82,  170,   85,  192,  148,  152,  125,  126,  127,  193,
   83,  168,  153,   19,  117,  242,   96,   18,  115,  144,
   73,  234,  116,  121,   46,   47,  159,  160,   85,   85,
   50,   95,   95,  122,   95,   19,   95,  123,   45,   18,
   16,   17,  215,  253,  166,  254,  124,  165,   95,   93,
   19,  200,   92,  124,   18,  147,  248,  224,  105,  133,
  223,  145,   16,   17,   91,   19,  227,  249,  250,   18,
   16,   17,   18,   40,  101,   85,  161,  179,  181,  158,
   19,  130,  175,  177,   18,  149,  131,   87,  141,  142,
   91,  156,  182,   22,  186,   19,  194,  187,  198,   18,
  128,  195,  129,  229,  199,   90,   50,  196,   22,  217,
   80,  162,  235,  236,  239,  240,  245,    1,   77,  128,
  244,  129,  255,    5,   12,  262,  257,   68,    5,   60,
   78,  264,   59,  266,   61,   84,  137,  139,  138,  104,
   88,  145,   75,  123,   85,  132,   60,  149,   19,   59,
  105,   61,  150,   73,  148,  146,  231,    0,    0,    0,
    0,    0,  246,    0,    0,  106,    0,    0,    0,  155,
    0,    0,   19,   78,   94,  173,   97,   99,  101,  116,
  163,  103,    0,  150,    0,    7,    8,    0,   16,   17,
   73,   74,   73,    9,   10,   19,  183,  128,   11,   12,
   13,   71,   14,   15,  258,   16,   17,    7,    8,   12,
   16,   17,   16,   17,  260,    9,   10,   49,   49,   73,
   11,   12,   13,   19,   14,   15,  167,   16,   17,  197,
    8,  204,    0,  111,  112,  113,  114,    9,   10,   16,
   17,  143,   11,   12,   13,   95,   14,   15,   19,   16,
   17,    7,    8,   16,   17,  204,   45,   45,  252,    9,
   10,   19,  225,  226,   11,   12,   13,    8,   14,   15,
   49,   16,   17,  105,    9,   10,  157,   89,  204,   11,
   12,   13,    8,   14,   15,   86,   16,   17,   60,    9,
   10,   59,  127,   61,   11,   12,   13,    8,   14,   15,
  228,   16,   17,   89,    9,   10,   22,   80,  232,   11,
   12,   13,    8,   14,   15,   77,   16,   17,    0,    9,
   10,    0,   48,   59,   11,   12,   13,   78,   14,   15,
   49,   16,   17,  247,    0,    0,  134,  135,  136,   75,
  123,   12,   16,   17,   56,   57,   58,    0,   12,   12,
   73,  123,  123,   12,  116,   12,   12,   12,   12,   12,
    0,   56,   57,   58,    0,  201,  155,   81,    0,   81,
    0,   81,    9,   10,  212,    0,    0,   11,    0,   13,
  202,   14,   15,  203,   59,   81,   81,   81,   81,  201,
  172,  112,  113,  114,   63,    0,    9,   10,   77,    0,
  237,   11,   59,   13,  202,   14,   15,  203,   60,    0,
    0,   59,  201,   61,    0,  169,  116,    0,   60,    9,
   10,   59,    0,   61,   11,    0,   13,  202,   14,   15,
  203,    0,    0,  108,  110,    0,  137,  139,  138,   60,
  201,    0,   59,    0,   61,    0,   60,    9,   10,   59,
    0,   61,   11,    0,   13,  202,   14,   15,  203,   62,
   62,    0,    0,   62,   80,  201,    0,    0,    0,   62,
    0,    0,    9,   10,    0,    0,    0,   11,  201,   13,
  202,   14,   15,  203,   24,    9,   10,   24,   24,  127,
   11,    0,   13,  202,   14,   15,  203,    0,   62,   62,
  127,  127,   24,   56,   57,   58,    0,    0,    0,   62,
   62,   62,   24,   95,   95,   95,    0,   95,   62,   95,
   82,    0,   82,    0,   82,  185,    0,    0,   24,   24,
    0,   95,   95,   95,   95,   56,   57,   58,   82,   82,
   82,   82,   83,    0,   83,    0,   83,    0,    0,   60,
    0,    0,   59,    0,   61,    0,    0,    0,    0,    0,
   83,   83,   83,   83,    0,   51,  112,  113,  114,   51,
    0,  137,  139,  138,   24,   24,    0,    0,   62,   62,
   62,   62,   81,    0,    0,    0,   81,   81,   81,    0,
   62,    0,   81,    0,    0,  178,   56,   57,   58,    0,
    0,    0,    0,  241,  243,    0,    0,   51,    0,    0,
  108,    0,    0,  180,   56,   57,   58,    0,    0,    0,
    0,    0,  109,   56,   57,   58,    0,  251,  112,  113,
  114,   51,   51,   56,   57,   58,  134,  135,  136,    0,
    0,    0,    0,    0,   24,    0,    0,    0,    0,    0,
    0,    0,    0,  174,   56,   57,   58,    0,    0,    0,
  176,   56,   57,   58,    0,    0,    0,    0,   62,   62,
    0,    0,    0,    0,    0,   62,    0,    0,    0,  171,
    0,    0,    0,    0,    0,    0,  230,    0,  233,    0,
    0,    0,   62,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  188,  190,    0,  191,    0,  211,  213,
    0,  214,    0,  233,    0,    0,    0,    0,    0,    0,
    0,  222,   51,    0,    0,    0,    0,    0,   95,    0,
    0,    0,   95,   95,   95,   82,    0,  238,   95,   82,
   82,   82,    0,    0,    0,   82,  216,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   83,    0,    0,
    0,   83,   83,   83,  107,   57,   58,   83,  218,    0,
    0,  134,  135,  136,  256,    0,    0,    0,    0,    0,
   51,    0,  263,    0,  265,    0,  267,    0,    0,  268,
    0,  269,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         40,
   58,   41,   41,   44,   40,   59,   40,   59,   40,   59,
   59,   59,   41,  123,   59,   44,   59,   41,   40,   50,
  123,   40,  195,   12,   58,   44,  206,   41,  116,   58,
  257,  119,   20,  258,   41,  257,   59,   60,   61,  264,
   19,   41,  264,   40,   75,  218,   59,   44,   41,   41,
  256,  231,   45,  257,    5,    6,  256,  257,   46,   47,
   41,   42,   43,   58,   45,   40,   47,   41,   58,   44,
  276,  277,  256,   43,   41,   45,   40,   44,   59,   30,
   40,  169,  123,   40,   44,   74,  256,   41,   41,   68,
   44,  257,  276,  277,   44,   40,   59,  267,  268,   44,
  276,  277,   44,   58,   59,   93,  125,  130,  131,   59,
   40,   42,  128,  129,   44,   58,   47,   59,   41,   41,
   44,   41,  266,   44,  266,   40,  258,   41,  125,   44,
   43,   59,   45,   59,  165,   59,   40,  266,   59,  258,
   59,   92,  268,  268,  268,  268,  268,  257,   59,   43,
   59,   45,   41,  256,   40,  268,   41,   40,    0,   42,
   59,   41,   45,   41,   47,  125,   60,   61,   62,   59,
   25,   59,   59,   59,  162,   41,   42,   59,   40,   45,
  125,   47,   59,   59,   59,   59,  204,   -1,   -1,   -1,
   -1,   -1,  223,   -1,   -1,  125,   -1,   -1,   -1,   59,
   -1,   -1,   40,  257,  256,   41,  256,  256,  256,   45,
  125,  256,   -1,  256,   -1,  256,  257,   -1,  276,  277,
  256,  257,  256,  264,  265,   40,  266,  266,  269,  270,
  271,  263,  273,  274,  258,  276,  277,  256,  257,  125,
  276,  277,  276,  277,  258,  264,  265,  276,  277,  256,
  269,  270,  271,   40,  273,  274,  256,  276,  277,  256,
  257,  123,   -1,  256,  257,  258,  259,  264,  265,  276,
  277,  263,  269,  270,  271,  256,  273,  274,   40,  276,
  277,  256,  257,  276,  277,  123,  276,  277,  258,  264,
  265,   40,  256,  256,  269,  270,  271,  257,  273,  274,
  264,  276,  277,  256,  264,  265,  256,  257,  123,  269,
  270,  271,  257,  273,  274,  257,  276,  277,   42,  264,
  265,   45,   59,   47,  269,  270,  271,  257,  273,  274,
  256,  276,  277,  257,  264,  265,  257,  256,  125,  269,
  270,  271,  257,  273,  274,  256,  276,  277,   -1,  264,
  265,   -1,  256,   45,  269,  270,  271,  256,  273,  274,
  264,  276,  277,  125,   -1,   -1,  260,  261,  262,  256,
  256,  257,  276,  277,  257,  258,  259,   -1,  264,  265,
  256,  267,  268,  269,   45,  271,  272,  273,  274,  275,
   -1,  257,  258,  259,   -1,  257,  256,   41,   -1,   43,
   -1,   45,  264,  265,  266,   -1,   -1,  269,   -1,  271,
  272,  273,  274,  275,   45,   59,   60,   61,   62,  257,
  256,  257,  258,  259,    9,   -1,  264,  265,   13,   -1,
  268,  269,   45,  271,  272,  273,  274,  275,   42,   -1,
   -1,   45,  257,   47,   -1,   44,   45,   -1,   42,  264,
  265,   45,   -1,   47,  269,   -1,  271,  272,  273,  274,
  275,   -1,   -1,   48,   49,   -1,   60,   61,   62,   42,
  257,   -1,   45,   -1,   47,   -1,   42,  264,  265,   45,
   -1,   47,  269,   -1,  271,  272,  273,  274,  275,    9,
   10,   -1,   -1,   13,   14,  257,   -1,   -1,   -1,   19,
   -1,   -1,  264,  265,   -1,   -1,   -1,  269,  257,  271,
  272,  273,  274,  275,    2,  264,  265,    5,    6,  256,
  269,   -1,  271,  272,  273,  274,  275,   -1,   48,   49,
  267,  268,   20,  257,  258,  259,   -1,   -1,   -1,   59,
   60,   61,   30,   41,   42,   43,   -1,   45,   68,   47,
   41,   -1,   43,   -1,   45,  140,   -1,   -1,   46,   47,
   -1,   59,   60,   61,   62,  257,  258,  259,   59,   60,
   61,   62,   41,   -1,   43,   -1,   45,   -1,   -1,   42,
   -1,   -1,   45,   -1,   47,   -1,   -1,   -1,   -1,   -1,
   59,   60,   61,   62,   -1,    8,  257,  258,  259,   12,
   -1,   60,   61,   62,   92,   93,   -1,   -1,  128,  129,
  130,  131,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
  140,   -1,  266,   -1,   -1,  256,  257,  258,  259,   -1,
   -1,   -1,   -1,  218,  219,   -1,   -1,   50,   -1,   -1,
  225,   -1,   -1,  256,  257,  258,  259,   -1,   -1,   -1,
   -1,   -1,  256,  257,  258,  259,   -1,  242,  257,  258,
  259,   74,   75,  257,  258,  259,  260,  261,  262,   -1,
   -1,   -1,   -1,   -1,  162,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,  257,  258,  259,   -1,   -1,   -1,
  256,  257,  258,  259,   -1,   -1,   -1,   -1,  218,  219,
   -1,   -1,   -1,   -1,   -1,  225,   -1,   -1,   -1,  122,
   -1,   -1,   -1,   -1,   -1,   -1,  204,   -1,  206,   -1,
   -1,   -1,  242,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  146,  147,   -1,  149,   -1,  183,  184,
   -1,  186,   -1,  231,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  196,  165,   -1,   -1,   -1,   -1,   -1,  256,   -1,
   -1,   -1,  260,  261,  262,  256,   -1,  212,  266,  260,
  261,  262,   -1,   -1,   -1,  266,  189,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,
   -1,  260,  261,  262,  257,  258,  259,  266,  257,   -1,
   -1,  260,  261,  262,  249,   -1,   -1,   -1,   -1,   -1,
  223,   -1,  257,   -1,  259,   -1,  261,   -1,   -1,  264,
   -1,  266,
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
"ejecucion_control : BREAK ';'",
"ejecucion_control : CONTINUE ';'",
"ejecucion_control : error_ejecucion_control",
"error_ejecucion_control : BREAK error",
"error_ejecucion_control : CONTINUE error",
"asignacion : ID ASIGNACION expresion_aritmetica",
"asignacion : error_asignacion",
"error_asignacion : ID error expresion_aritmetica",
"error_asignacion : ID ASIGNACION error",
"error_asignacion : ASIGNACION expresion_aritmetica",
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

//#line 284 "gramatica.y"

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

//#line 659 "Parser.java"
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
//#line 52 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
//#line 57 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
//#line 58 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
break;
case 21:
//#line 59 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
break;
case 22:
//#line 62 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 23:
//#line 63 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 25:
//#line 67 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
//#line 68 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
//#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
//#line 72 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
//#line 76 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 31:
//#line 77 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 32:
//#line 78 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
break;
case 35:
//#line 85 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 36:
//#line 86 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 37:
//#line 87 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 38:
//#line 88 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 39:
//#line 89 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 44:
//#line 98 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
//#line 99 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
//#line 100 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
//#line 107 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
//#line 108 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
//#line 111 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
//#line 112 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 60:
//#line 124 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 61:
//#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 62:
//#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 63:
//#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 64:
//#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 65:
//#line 129 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
//#line 130 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
//#line 131 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 68:
//#line 134 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 69:
//#line 135 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 71:
//#line 139 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 72:
//#line 140 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 75:
//#line 147 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 76:
//#line 148 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 77:
//#line 149 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 80:
//#line 156 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 82:
//#line 160 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 83:
//#line 161 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 85:
//#line 165 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 86:
//#line 166 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 87:
//#line 169 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 88:
//#line 170 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 91:
//#line 175 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 92:
//#line 176 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 93:
//#line 177 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 94:
//#line 178 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 95:
//#line 181 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 96:
//#line 182 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 97:
//#line 183 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 98:
//#line 184 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 100:
//#line 188 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 103:
//#line 193 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 104:
//#line 195 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 108:
//#line 204 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 109:
//#line 207 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 110:
//#line 208 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 111:
//#line 209 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 113:
//#line 213 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 114:
//#line 214 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 116:
//#line 218 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 117:
//#line 219 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
break;
case 118:
//#line 220 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
break;
case 119:
//#line 221 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
break;
case 120:
//#line 222 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
break;
case 121:
//#line 223 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
break;
case 122:
//#line 224 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 126:
//#line 232 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
break;
case 127:
//#line 233 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
break;
case 135:
//#line 247 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 136:
//#line 248 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 138:
//#line 252 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 139:
//#line 253 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 140:
//#line 254 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 143:
//#line 261 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
break;
case 144:
//#line 262 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
break;
case 145:
//#line 263 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
break;
case 148:
//#line 270 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
break;
case 149:
//#line 271 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
break;
case 150:
//#line 272 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}
break;
case 151:
//#line 275 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 153:
//#line 279 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 154:
//#line 280 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
break;
case 155:
//#line 281 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1180 "Parser.java"
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
