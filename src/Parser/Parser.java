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
    0,    0,    2,    2,    2,    1,    1,    3,    3,    6,
    6,    4,    4,    4,   10,   10,   10,    8,    8,    8,
   11,   11,   11,    9,    9,   13,   13,   13,   12,   12,
   15,   15,   15,   15,   15,   14,   14,   14,   14,   17,
   17,   17,   16,   16,   18,   18,    7,    7,    5,    5,
    5,    5,    5,    5,    5,    5,    5,   25,   25,   25,
   25,   25,   25,   25,   25,   25,   25,   19,   19,   27,
   27,   27,   22,   22,   28,   26,   26,   26,   26,   30,
   30,   29,   29,   29,   29,   32,   32,   32,   32,   31,
   31,   31,   31,   31,   20,   20,   20,   34,   34,   33,
   33,   33,   36,   35,   35,   35,   35,   21,   21,   21,
   39,   39,   39,   39,   39,   39,   39,   38,   38,   38,
   40,   40,   37,   41,   41,   41,   41,   41,   41,   23,
   23,   23,   44,   44,   44,   42,   42,   45,   45,   45,
   43,   43,   46,   46,   46,   24,   24,   47,   47,   47,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    2,    3,    1,    1,    3,    2,    2,    1,    3,    1,
    2,    2,    3,    4,    1,    3,    4,    3,    5,    1,
    4,    4,    4,    4,    5,    2,    3,    5,    1,    2,
    2,    7,    2,    1,    1,    2,    1,    1,    2,    3,
    2,    2,    2,    2,    2,    2,    1,    2,    2,    2,
    2,    2,    2,    2,    2,    3,    2,    3,    1,    3,
    3,    2,    2,    1,    1,    1,    3,    3,    1,    3,
    3,    3,    3,    1,    1,    3,    3,    2,    2,    1,
    1,    1,    1,    2,    4,    3,    1,    4,    3,    1,
    3,    1,    2,    1,    1,    1,    2,    7,    9,    1,
    6,    6,    6,    6,    6,    6,    7,    1,    3,    1,
    2,    2,    3,    1,    1,    1,    1,    1,    1,   10,
   10,    1,    9,    9,    9,    3,    1,    2,    2,    2,
    3,    1,    2,    2,    2,    4,    1,    3,    3,    3,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   48,   47,    0,    0,
    0,    6,    8,    9,    0,    0,   13,   14,   20,    0,
   25,   30,    0,    0,    0,    0,    0,    0,   57,   69,
   74,   97,  110,  132,  147,    0,    0,    0,    0,    0,
    0,    0,    0,   39,   44,    0,   92,   91,    0,    0,
    0,   93,    0,    0,   79,   84,   85,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   62,   55,    0,
   65,    0,    0,   64,   56,   22,    0,    3,    7,   18,
   17,    0,   21,   16,    0,    0,    0,   58,   49,   67,
   59,   51,   63,   52,   60,   53,   61,   54,    4,    1,
    0,    0,   71,    0,    0,  104,  106,  105,    0,    0,
    0,    0,    0,  102,   43,    0,   40,    0,   94,   88,
   89,    0,    0,    0,    0,    0,    0,  128,  127,  129,
  124,  125,  126,    0,    0,  148,    0,  149,   46,    0,
    0,   36,    0,   66,   50,    0,    0,    0,  137,    0,
   15,   12,   23,   19,   28,    0,   26,  107,    0,   37,
   98,   95,    0,  103,   31,   99,   96,   80,    0,   81,
    0,   86,   82,   87,   83,    0,    0,    0,    0,    0,
  146,   33,    0,   34,   32,  139,    0,  138,    0,    0,
   27,   24,    0,  101,    0,    0,    0,    0,    0,  120,
    0,    0,    0,    0,   35,   29,  136,    0,    0,    0,
  142,    0,    0,   38,    0,   10,    0,  121,   11,  113,
  114,  116,    0,  115,  112,    0,    0,    0,    0,  111,
    0,  119,  117,    0,  108,    0,    0,    0,    0,   42,
    0,    0,    0,    0,    0,    0,  109,  133,    0,  135,
    0,  134,  130,  131,
};
final static short yydgoto[] = {                          3,
   21,    4,   22,   23,  207,  208,   25,   26,   27,   28,
   29,   30,   31,   52,   32,   53,   54,   55,   33,   34,
   35,   36,   37,   38,   39,   69,   40,   41,   64,   65,
   66,   67,  122,   42,  123,  124,   70,  209,   43,  210,
  144,  158,  220,   44,  159,  221,   45,
};
final static short yysindex[] = {                      -116,
 -112,  107,    0,    0,  107,  107,  -37,  116,   74,  -16,
  -35,  116,  -49,  -53,    1,  -46,    0,    0, -196,  116,
  -19,    0,    0,    0,   45,  133,    0,    0,    0,    2,
    0,    0,   68,   12,  137,  286,  287,  387,    0,    0,
    0,    0,    0,    0,    0,   23,   44,  138,  129,    6,
 -182,   25,   40,    0,    0,   46,    0,    0,  393,  393,
  393,    0,  -14,   11,    0,    0,    0,   90,   50,   55,
   67,   27, -166,  -28,  -33,   59,  -14,    0,    0,   46,
    0,  388, -242,    0,    0,    0,   79,    0,    0,    0,
    0,  377,    0,    0, -192,   65,   86,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   46,  -14,    0,  -14, -166,    0,    0,    0,    0,  396,
   13,   51,   95,    0,    0, -203,    0,  109,    0,    0,
    0,  155,  161,  -44,  383, -144,    4,    0,    0,    0,
    0,    0,    0,  116, -143,    0,   83,    0,    0, -203,
   29,    0, -203,    0,    0, -232, -129,   75,    0, -133,
    0,    0,    0,    0,    0,  -40,    0,    0, -233,    0,
    0,    0,  396,    0,    0,    0,    0,    0,   11,    0,
   11,    0,    0,    0,    0,  221,  221,  158,  -14,  221,
    0,    0, -221,    0,    0,    0, -122,    0,  400,  221,
    0,    0,   18,    0,  -38,  283,    0,  244, -130,    0,
 -126,  180, -125, -123,    0,    0,    0,  437,  116,   87,
    0, -119, -233,    0,  116,    0,  264,    0,    0,    0,
    0,    0, -219,    0,    0,  -14,  116,  -14,   70,    0,
  111,    0,    0,  221,    0,  -14,  112,   28,   31,    0,
 -111,  221,  115,  221,  119,  221,    0,    0,  221,    0,
  221,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,  399,    0,    0,    0,
    0,  407,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  162,    0,    0,    0,
   -8,    0,    0,    0,    0,  518,    0,    0,    0,    0,
    0,    0,  408,  541,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  410,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   35,  411,    0,  414,  105,    0,    0,    0,   42,    0,
   49,    0,  114,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  415,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  569,    0,
  576,    0,    0,    0,    0,    0,    0,    0,   19,    0,
    0,    0,    0,    0,    0,    0,  106,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  135,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  357,    0,    0,    0,
    0,    0,    0,    0,    0,  108,  120,  122,    0,    0,
    0,    0,    0,    0,    0,  125,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   22,    0,   -7,    0,  562,  -36,  496,  141,    0,    0,
    0,    0,    0,    5,    0,  -41,    0,    0,    0,  463,
    0,    0,    0,    0,    0,  386,    0,    0,  -30,    0,
   38,    0,    0,    0, -103,    0,   -2,  490,    0,    0,
 -180,    0,    0,    0,    0,    0,    0,
};
final static int YYTABLESIZE=842;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         20,
   59,  128,   50,   19,   75,   81,    2,  152,  121,   79,
    6,   75,   85,   89,  156,   76,  168,   87,  219,  174,
   20,  157,   73,   72,   19,  196,   46,   47,  132,  150,
  133,  197,   45,  121,  215,   45,  243,  237,   89,   89,
   83,   20,   17,   18,  188,   19,  119,  244,  245,   45,
  120,   97,  134,  170,   17,   18,  169,  135,  224,  123,
   86,  223,   20,  163,  164,  137,   19,  148,  254,  204,
  100,  256,   17,   18,  125,   46,   90,   90,  151,   90,
  127,   90,  126,   20,  202,  128,  193,   19,   19,   89,
  149,  172,  132,   90,  133,  145,  129,  130,  131,   36,
   96,  179,  181,   91,   20,   88,   41,  146,   19,  141,
  143,  142,  248,   68,  249,   60,  153,  166,   59,  160,
   61,  186,  190,  191,   96,   20,   99,  203,  198,   19,
  136,   60,  200,  199,   59,  217,   61,  230,  173,  120,
    1,  231,  234,    5,  235,  239,   20,  109,  240,  177,
   19,  250,  252,  120,  100,  259,  257,   60,   89,  261,
   59,    5,   61,   99,  140,   92,  144,    0,  110,  227,
   60,  183,  185,   59,   10,   61,   95,    0,  145,   60,
  143,  241,   59,  141,   61,    0,    0,    0,    0,  165,
    0,   94,    0,  118,    0,  102,   60,   20,    0,   59,
    0,   61,   60,   80,    0,   59,   78,   61,    0,   84,
  167,  182,   56,   57,   58,  201,    7,  225,   48,   20,
   73,   74,   73,    8,    9,   49,   49,   73,   10,   11,
   12,   13,   14,   15,   16,   17,   18,    7,   17,   18,
   17,   18,   17,   18,    8,    9,   71,   17,   18,   10,
   11,   12,   13,   14,   15,   16,   17,   18,    7,   10,
   20,  115,  116,  117,  118,    8,    9,   45,   45,  187,
   10,   11,   12,   13,   14,   15,   16,   17,   18,    7,
  206,   17,   18,   20,  123,  253,    8,    9,  255,  147,
   90,   10,   11,   12,   13,   14,   15,   16,   17,   18,
    7,   90,  206,   20,   17,   18,  171,    8,    9,  138,
  139,  140,   10,   11,   12,   13,   14,   15,   16,   17,
   18,    7,   20,   98,   41,   41,    0,  247,    8,    9,
   56,   57,   58,   10,   11,   12,   13,   14,   15,   16,
   17,   18,    7,  206,  104,  106,   56,   57,   58,    8,
    9,  116,  117,  118,   10,   11,   12,   13,   14,   15,
   16,   17,   18,    7,  176,  116,  117,  118,  228,  100,
    8,    9,   56,   57,   58,   10,   11,   12,   13,   14,
   15,   16,   17,   18,  113,   56,   57,   58,  242,   93,
  118,   10,  101,   63,  111,   57,   58,   77,   10,   10,
    0,  118,  118,   10,    0,   10,   10,   10,   10,   10,
  178,   56,   57,   58,  205,  122,  180,   56,   57,   58,
   95,    8,    9,  212,    0,    0,   10,   59,   12,   13,
   14,   15,   16,  112,  114,  162,  205,   59,    0,    0,
  120,    0,   18,    8,    9,  108,  155,  232,   10,    0,
   12,   13,   14,   15,   16,    0,    0,   18,    0,  141,
  143,  142,    0,    0,    0,   75,   72,    0,   73,   70,
   62,   62,   68,  150,   62,    0,   82,  205,   60,    0,
    0,   59,   62,   61,    8,    9,    0,    0,    0,   10,
    0,   12,   13,   14,   15,   16,  141,  143,  142,    0,
  205,    0,   51,    0,    0,    0,   51,    8,    9,    0,
   62,   62,   10,    0,   12,   13,   14,   15,   16,    0,
  205,   62,   62,   62,    0,    0,    0,    8,    9,  189,
   62,    0,   10,    0,   12,   13,   14,   15,   16,  205,
    0,  103,  105,    0,    0,   51,    8,    9,    0,    0,
    0,   10,    0,   12,   13,   14,   15,   16,   90,   90,
   90,    0,   90,   24,   90,    0,   24,   24,    0,   51,
   51,    0,    0,    0,    0,    0,   90,   90,   90,   90,
    0,   76,   24,   76,    0,   76,    0,    0,    0,    0,
    0,   24,    0,    0,   62,   62,   62,   62,    0,   76,
   76,   76,   76,  236,  238,    0,   62,   24,   24,   77,
  112,   77,  122,   77,    0,    0,   78,    0,   78,    0,
   78,  175,  246,  122,  122,    0,    0,   77,   77,   77,
   77,    0,  161,   93,   78,   78,   78,   78,  184,   56,
   57,   58,  107,  154,    0,  192,  194,    0,  195,   56,
   57,   58,  116,  117,  118,   18,  218,   24,   24,  138,
  139,  140,   75,   72,   51,   73,   70,    0,    0,   68,
  150,    0,    0,    0,    0,    0,  211,  213,    0,  214,
   62,   62,    0,    0,    0,    0,    0,   62,  216,  222,
    0,    0,    0,   56,   57,   58,  138,  139,  140,   62,
    0,  233,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   51,    0,
    0,    0,    0,    0,    0,    0,    0,   24,    0,    0,
    0,    0,    0,  251,    0,    0,    0,    0,    0,    0,
    0,  258,    0,  260,    0,  262,    0,    0,  263,    0,
  264,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  226,    0,  229,
    0,    0,    0,   90,    0,    0,    0,   90,   90,   90,
    0,    0,    0,   90,    0,    0,    0,    0,  229,    0,
    0,    0,    0,    0,    0,    0,   76,    0,    0,    0,
   76,   76,   76,    0,    0,    0,   76,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   77,    0,    0,    0,   77,   77,
   77,   78,    0,    0,   77,   78,   78,   78,    0,    0,
    0,   78,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         40,
   45,   40,   40,   44,   40,   59,  123,   41,   50,   59,
  123,   40,   59,   21,  257,   11,  120,   20,  199,  123,
   40,  264,  256,   40,   44,  258,    5,    6,   43,   58,
   45,  264,   41,   75,  256,   44,  256,  218,   46,   47,
   40,   40,  276,  277,   41,   44,   41,  267,  268,   58,
   45,   30,   42,   41,  276,  277,   44,   47,   41,   41,
  257,   44,   40,  256,  257,   68,   44,   41,   41,  173,
   59,   41,  276,  277,  257,   41,   42,   43,   74,   45,
   41,   47,   58,   40,  125,   40,   58,   44,   44,   97,
  257,   41,   43,   59,   45,   41,   59,   60,   61,   58,
   59,  132,  133,   59,   40,  125,   58,   41,   44,   60,
   61,   62,   43,   40,   45,   42,   58,   96,   45,   41,
   47,  266,  266,   41,  123,   40,   59,  169,  258,   44,
   41,   42,  266,   59,   45,  258,   47,  268,   44,   45,
  257,  268,  268,  256,  268,   59,   40,  125,  268,   41,
   44,   41,   41,   45,   41,   41,  268,   42,  166,   41,
   45,    0,   47,   59,   59,   25,   59,   -1,  125,  206,
   42,  134,  135,   45,   40,   47,   44,   -1,   59,   42,
   59,  223,   45,   59,   47,   -1,   -1,   -1,   -1,  125,
   -1,   59,   -1,   59,   -1,   59,   42,   40,   -1,   45,
   -1,   47,   42,  257,   -1,   45,  256,   47,   -1,  256,
  125,  256,  257,  258,  259,  256,  257,  256,  256,   40,
  256,  257,  256,  264,  265,  264,  264,  256,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  257,  276,  277,
  276,  277,  276,  277,  264,  265,  263,  276,  277,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  257,  125,
   40,  256,  257,  258,  259,  264,  265,  276,  277,  266,
  269,  270,  271,  272,  273,  274,  275,  276,  277,  257,
  123,  276,  277,   40,  266,  258,  264,  265,  258,  263,
  256,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  257,  257,  123,   40,  276,  277,  256,  264,  265,  260,
  261,  262,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  257,   40,  256,  276,  277,   -1,  258,  264,  265,
  257,  258,  259,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  257,  123,   59,   59,  257,  258,  259,  264,
  265,  257,  258,  259,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  257,  256,  257,  258,  259,  125,  256,
  264,  265,  257,  258,  259,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  256,  257,  258,  259,  125,  257,
  256,  257,  256,    8,  257,  258,  259,   12,  264,  265,
   -1,  267,  268,  269,   -1,  271,  272,  273,  274,  275,
  256,  257,  258,  259,  257,   59,  256,  257,  258,  259,
   44,  264,  265,  266,   -1,   -1,  269,   45,  271,  272,
  273,  274,  275,   48,   49,   59,  257,   45,   -1,   -1,
   45,   -1,   44,  264,  265,   59,   59,  268,  269,   -1,
  271,  272,  273,  274,  275,   -1,   -1,   59,   -1,   60,
   61,   62,   -1,   -1,   -1,   59,   59,   -1,   59,   59,
    8,    9,   59,   59,   12,   -1,   14,  257,   42,   -1,
   -1,   45,   20,   47,  264,  265,   -1,   -1,   -1,  269,
   -1,  271,  272,  273,  274,  275,   60,   61,   62,   -1,
  257,   -1,    7,   -1,   -1,   -1,   11,  264,  265,   -1,
   48,   49,  269,   -1,  271,  272,  273,  274,  275,   -1,
  257,   59,   60,   61,   -1,   -1,   -1,  264,  265,  144,
   68,   -1,  269,   -1,  271,  272,  273,  274,  275,  257,
   -1,  256,  256,   -1,   -1,   50,  264,  265,   -1,   -1,
   -1,  269,   -1,  271,  272,  273,  274,  275,   41,   42,
   43,   -1,   45,    2,   47,   -1,    5,    6,   -1,   74,
   75,   -1,   -1,   -1,   -1,   -1,   59,   60,   61,   62,
   -1,   41,   21,   43,   -1,   45,   -1,   -1,   -1,   -1,
   -1,   30,   -1,   -1,  132,  133,  134,  135,   -1,   59,
   60,   61,   62,  218,  219,   -1,  144,   46,   47,   41,
  225,   43,  256,   45,   -1,   -1,   41,   -1,   43,   -1,
   45,  126,  237,  267,  268,   -1,   -1,   59,   60,   61,
   62,   -1,  256,  257,   59,   60,   61,   62,  256,  257,
  258,  259,  256,  256,   -1,  150,  151,   -1,  153,  257,
  258,  259,  257,  258,  259,  257,  257,   96,   97,  260,
  261,  262,  256,  256,  169,  256,  256,   -1,   -1,  256,
  256,   -1,   -1,   -1,   -1,   -1,  187,  188,   -1,  190,
  218,  219,   -1,   -1,   -1,   -1,   -1,  225,  193,  200,
   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,  237,
   -1,  212,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  223,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  166,   -1,   -1,
   -1,   -1,   -1,  244,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  252,   -1,  254,   -1,  256,   -1,   -1,  259,   -1,
  261,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  206,   -1,  208,
   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,  227,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,
  260,  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,
  262,  256,   -1,   -1,  266,  260,  261,  262,   -1,   -1,
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
"sentencia : declaracion",
"sentencia : ejecucion",
"bloque_ejecutable : ejecucion",
"bloque_ejecutable : bloque_ejecutable ejecucion",
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
"ejecucion : error_ejecucion",
"error_ejecucion : asignacion error",
"error_ejecucion : seleccion error",
"error_ejecucion : control error",
"error_ejecucion : salida error",
"error_ejecucion : BREAK error",
"error_ejecucion : retorno error",
"error_ejecucion : CONTINUE error",
"error_ejecucion : DISCARD ';'",
"error_ejecucion : DISCARD invocacion error",
"error_ejecucion : invocacion ';'",
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

//#line 273 "gramatica.y"

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

//#line 656 "Parser.java"
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
case 12:
//#line 46 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 15:
//#line 51 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 16:
//#line 52 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
break;
case 17:
//#line 53 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
break;
case 18:
//#line 56 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 19:
//#line 57 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 21:
//#line 61 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 22:
//#line 62 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 23:
//#line 63 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 24:
//#line 66 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 26:
//#line 70 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 27:
//#line 71 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 28:
//#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
break;
case 31:
//#line 79 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 32:
//#line 80 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 33:
//#line 81 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 34:
//#line 82 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 35:
//#line 83 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 40:
//#line 92 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 41:
//#line 93 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 42:
//#line 94 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 45:
//#line 101 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 46:
//#line 102 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 47:
//#line 105 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 48:
//#line 106 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 55:
//#line 115 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 56:
//#line 116 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 58:
//#line 120 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 59:
//#line 121 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 60:
//#line 122 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 61:
//#line 123 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 62:
//#line 124 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 63:
//#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 64:
//#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 65:
//#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
//#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
//#line 129 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 70:
//#line 136 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 71:
//#line 137 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 72:
//#line 138 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 75:
//#line 145 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 77:
//#line 149 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 78:
//#line 150 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 80:
//#line 154 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 81:
//#line 155 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 82:
//#line 158 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 83:
//#line 159 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 86:
//#line 164 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 87:
//#line 165 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 88:
//#line 166 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 89:
//#line 167 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 90:
//#line 170 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 91:
//#line 171 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 92:
//#line 172 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 93:
//#line 173 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 95:
//#line 177 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 98:
//#line 182 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 99:
//#line 184 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 103:
//#line 193 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 104:
//#line 196 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 105:
//#line 197 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 106:
//#line 198 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 108:
//#line 202 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 109:
//#line 203 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 111:
//#line 207 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 112:
//#line 208 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
break;
case 113:
//#line 209 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
break;
case 114:
//#line 210 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
break;
case 115:
//#line 211 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
break;
case 116:
//#line 212 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
break;
case 117:
//#line 213 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 121:
//#line 221 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
break;
case 122:
//#line 222 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
break;
case 130:
//#line 236 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 131:
//#line 237 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 133:
//#line 241 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 134:
//#line 242 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 135:
//#line 243 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 138:
//#line 250 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
break;
case 139:
//#line 251 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
break;
case 140:
//#line 252 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
break;
case 143:
//#line 259 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
break;
case 144:
//#line 260 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
break;
case 145:
//#line 261 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}
break;
case 146:
//#line 264 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 148:
//#line 268 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 149:
//#line 269 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
break;
case 150:
//#line 270 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
//#line 1173 "Parser.java"
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
