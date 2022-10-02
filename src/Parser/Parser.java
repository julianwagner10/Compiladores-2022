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
    0,    0,    2,    2,    2,    1,    1,    1,    1,    3,
    3,    4,    4,    7,    7,    5,    5,    5,    5,   11,
    9,    9,    9,   12,   10,   10,   14,   14,   14,   13,
   13,   16,   16,   16,   16,   16,   15,   15,   15,   15,
   18,   18,   17,   17,   19,   19,    8,    8,    6,    6,
    6,    6,    6,    6,    6,    6,    6,   26,   26,   26,
   26,   26,   26,   26,   26,   26,   26,   20,   20,   28,
   28,   28,   28,   23,   23,   29,   27,   27,   27,   30,
   30,   30,   30,   32,   32,   32,   32,   31,   31,   31,
   31,   21,   21,   21,   34,   33,   33,   22,   22,   35,
   36,   36,   36,   36,   36,   36,   24,   24,   37,   38,
   25,
};
final static short yylen[] = {                            2,
    4,    1,    3,    4,    3,    2,    2,    1,    1,    1,
    2,    1,    3,    1,    2,    3,    1,    2,    1,    3,
    1,    3,    1,    2,    4,    1,    4,    4,    3,    5,
    1,    4,    4,    4,    4,    4,    2,    3,    5,    1,
    2,    2,    2,    1,    1,    2,    1,    1,    2,    3,
    2,    2,    2,    2,    2,    2,    1,    1,    1,    1,
    1,    1,    1,    1,    2,    2,    2,    4,    1,    3,
    3,    4,    3,    2,    1,    2,    1,    3,    3,    3,
    3,    1,    1,    3,    3,    2,    2,    1,    1,    1,
    2,    4,    3,    1,    4,    1,    2,    7,    9,    3,
    1,    1,    1,    1,    1,    1,   12,   12,    4,    3,
    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   48,   47,    0,    0,    0,
    0,    0,   10,   12,    0,    0,   17,   19,   23,    0,
   26,   31,    0,    0,    0,    0,    0,    0,   57,   69,
   75,   94,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   40,   44,    0,    0,    0,    0,    0,   76,   88,
   90,   89,    0,    0,    0,    0,    0,   82,   83,   55,
    0,   65,    0,    0,   56,    0,   14,    0,    0,    3,
    6,   11,    0,    0,   21,    0,   24,   18,    0,    0,
    0,   49,   67,   51,   52,   53,   54,    4,    1,   46,
    0,    0,    0,    0,    0,    0,    0,   43,    0,   41,
    0,    0,    0,    0,    0,   37,    0,   91,   86,   87,
    0,    0,    0,    0,    0,   50,    0,    0,   13,   15,
    0,   20,   16,   22,    0,   29,    0,    0,   38,   97,
   95,   92,   72,    0,   32,  105,  104,  106,  103,  101,
  102,    0,    0,  111,   34,    0,   35,   33,    0,    0,
   84,   80,   85,   81,   93,    0,    0,   27,   28,   25,
    0,    0,    0,   30,    0,    0,    0,   39,    0,  109,
    0,    0,    0,   98,    0,    0,    0,    0,    0,    0,
   99,    0,    0,    0,    0,    0,    0,  107,  108,
};
final static short yydgoto[] = {                          3,
   20,    4,   21,   22,   23,   24,   78,   25,   26,   27,
   28,   29,   30,   31,   50,   32,   51,   52,   53,   33,
   34,   35,   36,   37,   38,   39,   66,   40,   41,   67,
   68,   69,  105,   42,  112,  152,  128,  177,
};
final static short yysindex[] = {                      -115,
 -111,  344,    0,    0,  344,  344,  -37,  -21,  -13,  -30,
  142,   13,  -20,   41,   37,    0,    0,  333,   29,  -27,
  344, -200,    0,    0, -160,  -12,    0,    0,    0, -109,
    0,    0,   40,   42,   43,   44,   50,   52,    0,    0,
    0,    0,  -11,  -10, -157,  399,  -23,  165, -145,   59,
   77,    0,    0,  399, -143,  -25,   53,   65,    0,    0,
    0,    0,  375,  375,  375,   22,    6,    0,    0,    0,
   84,    0,   66, -130,    0,   -9,    0,  272,  399,    0,
    0,    0,  -35, -200,    0,   -1,    0,    0, -126,  344,
  366,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   22,    0,   15,  375,  -41,  310,   22,    0, -236,    0,
  331,   94,   95, -236,  -52,    0, -236,    0,    0,    0,
  399,  399,  326,  427,   92,    0,   71,   79,    0,    0,
   22,    0,    0,    0,   18,    0, -100, -222,    0,    0,
    0,    0,    0,   22,    0,    0,    0,    0,    0,    0,
    0,  399, -122,    0,    0, -236,    0,    0,    6,    6,
    0,    0,    0,    0,    0,   82, -108,    0,    0,    0,
  105,   22,  499,    0, -104,  449,   96,    0, -217,    0,
  399,   28,  499,    0,   22, -101,  -98, -110,  121,  122,
    0,   48,   54,  499,  499,   39,   51,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,   30,    0,    0,    0,
    0,  183,    0,    0,  206,    0,    0,    0,    0,    0,
    4,    9,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  228,    0,  250,  403,  425,  447,    0,    0,
    0,    0,    0,  166,    0,    0,    0,    0,  -28,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   69,    1,    0,    0,    0,
    0,    0,  469,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   30,   26,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   91,   20,  -47,  -39,    0,    0,  113,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  139,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  161,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0, -103,    0,    0,   23,   45,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  124,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  108,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   31,    0,  151,  -14,   -4,   17,    0,  720,  150,    0,
    0,    0,    0,    0,   19,    0,  -19,    0,    0,    0,
  169,    0,    0,    0,    0,    0,   62,    0,    0,  -29,
  523,    0,   74,    0,    0,    3,    0,    0,
};
final static int YYTABLESIZE=876;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        142,
   77,   96,   47,    8,   57,  156,   81,    2,    9,   57,
   42,    6,   45,   91,   57,   45,   82,  102,   54,   36,
   46,   63,   78,   48,  170,    7,   55,  103,   58,   45,
  125,   89,  114,   45,   77,   43,   44,  103,   72,   16,
   17,   77,   89,   77,   79,   77,   88,  123,   46,  183,
  184,   48,  124,   16,   17,  139,   83,  133,  138,   77,
   77,   77,   77,   78,  121,   78,  122,   78,   74,   10,
  186,   70,  187,   21,  115,   16,   17,   37,   93,   82,
   74,   78,   78,   78,   78,   79,   79,   79,   21,   79,
   70,  159,  160,  116,  130,   75,   85,   80,   92,  100,
   93,   94,   95,   79,   79,   79,   79,  101,   96,  107,
   97,  108,   71,   98,   99,  111,  109,  110,  171,  113,
  135,  137,  117,  125,  126,   77,  127,   74,    8,   74,
  134,  166,  165,    9,  153,  154,   63,  167,   73,  175,
  131,    1,  168,  173,    5,  178,   90,   78,  176,   70,
    7,   70,   36,  180,  182,  169,  189,  191,  179,  190,
   68,  192,  193,  198,  100,    5,  110,  144,  188,   79,
  194,   71,   84,   71,   86,  199,  195,  140,  181,  196,
  197,   73,   63,   64,    0,    0,   63,    0,   65,    0,
    0,    0,    0,   74,    0,    0,    0,   73,    0,   73,
    0,    0,    0,    0,    0,   64,   64,    0,    0,   63,
    0,   65,    0,  172,  141,   70,   96,    0,   45,   68,
   45,   68,  106,   16,   17,   45,   56,   58,   42,   42,
   45,    0,   45,   60,   61,   62,   71,   71,   16,   17,
   16,   17,  185,   63,   87,   16,   17,   45,   45,   59,
   16,   17,   16,   17,  132,   87,   77,   77,    0,    8,
   77,   77,   77,   73,    9,   77,   64,   77,   77,   77,
   77,   77,   77,   77,   77,   77,   77,   77,   78,   78,
    0,    7,   78,   78,   78,   68,   21,   78,   58,   78,
   78,   78,   78,   78,   78,   78,   78,   78,   78,   78,
   79,   79,    0,    0,   79,   79,   79,   63,   45,   79,
   59,   79,   79,   79,   79,   79,   79,   79,   79,   79,
   79,   79,    0,    0,   74,   74,    0,    0,   16,   17,
   64,    0,   19,   74,    0,   74,   74,   74,   74,   74,
   74,   74,   74,   74,   74,   74,   70,   70,   60,   61,
   62,   64,   58,    0,   63,   70,   65,   70,   70,   70,
   70,   70,   70,   70,   70,   70,   70,   70,   71,   71,
   63,    0,    0,  121,   59,  122,    0,   71,    0,   71,
   71,   71,   71,   71,   71,   71,   71,   71,   71,   71,
  150,  149,  151,   19,   73,   73,  129,   59,   60,   61,
   62,    0,   60,   73,   19,   73,   73,   73,   73,   73,
   73,   73,   73,   73,   73,   73,   68,   68,    0,   63,
    0,   60,   61,   62,   61,   68,   19,   68,   68,   68,
   68,   68,   68,   68,   68,   68,   68,   68,   63,   63,
   64,    0,    0,   63,    0,   65,   62,   63,    0,   63,
   63,   63,   63,   63,   63,   63,   63,   63,   63,   63,
    0,   64,   64,   60,    0,    0,   18,    0,   66,    0,
   64,   63,   64,   64,   64,   64,   64,   64,   64,   64,
   64,   64,   64,   58,   58,   61,    0,    0,   18,    0,
  136,    0,   58,    0,   58,   58,   58,   58,   58,   58,
   58,   58,   58,   58,   58,   59,   59,   62,  150,  149,
  151,    0,    0,    0,   59,    0,   59,   59,   59,   59,
   59,   59,   59,   59,   59,   59,   59,   60,   76,   66,
    0,    0,    0,    0,    0,    0,    8,    0,    0,    0,
    9,    0,   11,   12,   13,   14,   15,    0,    0,   61,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   19,
    0,    0,    0,    0,    0,  143,   60,   61,   62,  104,
    0,   62,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  161,   60,   61,   62,  118,  119,  120,    0,   76,
  146,  147,  148,   66,    0,    0,    0,    8,    0,    0,
    7,    9,    0,   11,   12,   13,   14,   15,    8,    0,
    0,    0,    9,   10,   11,   12,   13,   14,   15,   16,
   17,   18,    7,    0,    0,    0,  104,    0,    0,    0,
    8,   60,   61,   62,    9,   10,   11,   12,   13,   14,
   15,   16,   17,    0,    0,  162,  164,  104,    0,    0,
    0,    0,    0,    0,    0,   60,   61,   62,   60,   60,
    0,    0,    0,    0,    0,    0,    0,   60,    0,   60,
   60,   60,   60,   60,   60,   60,   60,   60,   60,   60,
   61,   61,  163,   60,   61,   62,    0,    0,    0,   61,
    0,   61,   61,   61,   61,   61,   61,   61,   61,   61,
   61,   61,   62,   62,    0,    0,    0,    0,  146,  147,
  148,   62,    0,   62,   62,   62,   62,   62,   62,   62,
   62,   62,   62,   62,   66,   66,   49,    0,    0,   49,
    0,    0,    0,   66,    0,   66,   66,   66,   66,   66,
   66,   66,   66,   66,   66,   66,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   76,    0,    0,    0,    0,
    0,    0,    0,    8,    0,    0,   49,    9,    0,   11,
   12,   13,   14,   15,    0,   49,   49,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   49,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  145,    0,
    0,    0,    0,  155,  157,    0,  158,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   49,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  174,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         41,
    0,   41,   40,    0,   40,   58,   21,  123,    0,   40,
   58,  123,   41,  123,   40,   44,   21,   41,   40,  123,
   58,   45,    0,   61,  125,    0,   40,   47,   10,   58,
   40,   44,   58,  256,   18,    5,    6,   57,   59,  276,
  277,   41,   44,   43,    0,   45,   59,   42,   58,  267,
  268,   61,   47,  276,  277,   41,  257,   59,   44,   59,
   60,   61,   62,   41,   43,   43,   45,   45,    0,  270,
   43,   59,   45,   44,   56,  276,  277,   58,   59,   84,
   40,   59,   60,   61,   62,   41,   58,   43,   59,   45,
    0,  121,  122,   41,   78,   59,  257,  125,   59,  257,
   59,   59,   59,   59,   60,   61,   62,   46,   59,   48,
   59,  257,    0,  125,  125,   54,   58,   41,  138,  263,
   90,   91,   58,   40,   59,  125,  257,   59,  125,   61,
  257,   61,   41,  125,   41,   41,   45,   59,    0,   58,
   79,  257,  125,  266,  256,   41,  256,  125,  257,   59,
  125,   61,  256,  258,   59,  256,  258,  268,  173,  258,
    0,   41,   41,  125,   41,    0,   59,  106,  183,  125,
  123,   59,   22,   61,   25,  125,  123,  104,  176,  194,
  195,   13,    0,   42,   -1,   -1,   45,   -1,   47,   -1,
   -1,   -1,   -1,  125,   -1,   -1,   -1,   59,   -1,   61,
   -1,   -1,   -1,   -1,   -1,    0,   42,   -1,   -1,   45,
   -1,   47,   -1,  152,  256,  125,  256,   -1,  256,   59,
  256,   61,   58,  276,  277,  256,  257,    0,  276,  277,
  256,   -1,  256,  257,  258,  259,  257,  125,  276,  277,
  276,  277,  181,   61,  257,  276,  277,  276,  277,    0,
  276,  277,  276,  277,  256,  257,  256,  257,   -1,  256,
  260,  261,  262,  125,  256,  265,   61,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  257,
   -1,  256,  260,  261,  262,  125,  257,  265,   61,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  256,  257,   -1,   -1,  260,  261,  262,  125,  256,  265,
   61,  267,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  277,   -1,   -1,  256,  257,   -1,   -1,  276,  277,
  125,   -1,   61,  265,   -1,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  256,  257,  257,  258,
  259,   42,  125,   -1,   45,  265,   47,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  257,
   45,   -1,   -1,   43,  125,   45,   -1,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
   60,   61,   62,   61,  256,  257,  125,  256,  257,  258,
  259,   -1,    0,  265,   61,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  256,  257,   -1,   45,
   -1,  257,  258,  259,    0,  265,   61,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  257,
   42,   -1,   -1,   45,   -1,   47,    0,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
   -1,  256,  257,   61,   -1,   -1,  123,   -1,    0,   -1,
  265,   45,  267,  268,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  256,  257,   61,   -1,   -1,  123,   -1,
  125,   -1,  265,   -1,  267,  268,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  256,  257,   61,   60,   61,
   62,   -1,   -1,   -1,  265,   -1,  267,  268,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  125,  257,   61,
   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,   -1,   -1,
  269,   -1,  271,  272,  273,  274,  275,   -1,   -1,  125,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   61,
   -1,   -1,   -1,   -1,   -1,  256,  257,  258,  259,   47,
   -1,  125,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  256,  257,  258,  259,   63,   64,   65,   -1,  257,
  260,  261,  262,  125,   -1,   -1,   -1,  265,   -1,   -1,
  257,  269,   -1,  271,  272,  273,  274,  275,  265,   -1,
   -1,   -1,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  123,  257,   -1,   -1,   -1,  104,   -1,   -1,   -1,
  265,  257,  258,  259,  269,  270,  271,  272,  273,  274,
  275,  276,  277,   -1,   -1,  123,  124,  125,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  257,  258,  259,  256,  257,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  256,  257,  256,  257,  258,  259,   -1,   -1,   -1,  265,
   -1,  267,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  256,  257,   -1,   -1,   -1,   -1,  260,  261,
  262,  265,   -1,  267,  268,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  256,  257,    7,   -1,   -1,   10,
   -1,   -1,   -1,  265,   -1,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  257,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  265,   -1,   -1,   47,  269,   -1,  271,
  272,  273,  274,  275,   -1,   56,   57,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   83,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  109,   -1,
   -1,   -1,   -1,  114,  115,   -1,  117,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  138,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  156,
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
"bloque : bloque_declarativo bloque_ejecutable",
"bloque : bloque_ejecutable bloque_declarativo",
"bloque : bloque_declarativo",
"bloque : bloque_ejecutable",
"bloque_declarativo : declaracion",
"bloque_declarativo : bloque_declarativo declaracion",
"bloque_ejecutable : ejecucion",
"bloque_ejecutable : '{' bloque_sentencias_ejecutables '}'",
"bloque_sentencias_ejecutables : ejecucion",
"bloque_sentencias_ejecutables : bloque_sentencias_ejecutables ejecucion",
"declaracion : tipo lista_de_variables ';'",
"declaracion : funcion",
"declaracion : lista_de_variables ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"lista_de_variables : ID",
"lista_de_variables : lista_de_variables ',' ID",
"lista_de_variables : error_lista_de_variables",
"error_lista_de_variables : lista_de_variables ID",
"funcion : declaracion_fun '{' bloque '}'",
"funcion : error_funcion",
"error_funcion : declaracion_fun error bloque '}'",
"error_funcion : declaracion_fun '{' bloque error",
"error_funcion : declaracion_fun '{' '}'",
"declaracion_fun : FUN ID lista_de_parametros ':' tipo",
"declaracion_fun : error_declaracion_fun",
"error_declaracion_fun : ID lista_de_parametros ':' tipo",
"error_declaracion_fun : FUN lista_de_parametros ':' tipo",
"error_declaracion_fun : FUN ID ':' tipo",
"error_declaracion_fun : FUN ID lista_de_parametros tipo",
"error_declaracion_fun : FUN ID lista_de_parametros ':'",
"lista_de_parametros : '(' ')'",
"lista_de_parametros : '(' parametro ')'",
"lista_de_parametros : '(' parametro ',' parametro ')'",
"lista_de_parametros : error_lista_de_parametros",
"error_lista_de_parametros : parametro ')'",
"error_lista_de_parametros : '(' parametro",
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
"error_ejecucion : asignacion",
"error_ejecucion : seleccion",
"error_ejecucion : retorno",
"error_ejecucion : control",
"error_ejecucion : salida",
"error_ejecucion : BREAK",
"error_ejecucion : CONTINUE",
"error_ejecucion : DISCARD ';'",
"error_ejecucion : DISCARD invocacion",
"error_ejecucion : invocacion ';'",
"asignacion : ID '=' ':' expresion_aritmetica",
"asignacion : error_asignacion",
"error_asignacion : ID ':' expresion_aritmetica",
"error_asignacion : ID '=' expresion_aritmetica",
"error_asignacion : ID '=' ':' error",
"error_asignacion : '=' ':' expresion_aritmetica",
"retorno : RETURN expresion_aritmetica",
"retorno : error_retorno",
"error_retorno : RETURN error",
"expresion_aritmetica : termino",
"expresion_aritmetica : expresion_aritmetica '+' termino",
"expresion_aritmetica : expresion_aritmetica '-' termino",
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
"factor : '-' factor",
"invocacion : ID '(' parametros_reales ')'",
"invocacion : ID '(' ')'",
"invocacion : error_invocacion",
"error_invocacion : ID '(' parametros_reales error",
"parametros_reales : factor",
"parametros_reales : factor parametros_reales",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_ejecutable ELSE bloque_ejecutable ENDIF",
"condicion : expresion_aritmetica comparador expresion_aritmetica",
"comparador : '<'",
"comparador : '>'",
"comparador : '='",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
"control : FOR '(' asignacion_for ';' condicion_for ';' '+' CTE_INT ')' '{' bloque_ejecutable '}'",
"control : FOR '(' asignacion_for ';' condicion_for ';' '-' CTE_INT ')' '{' bloque_ejecutable '}'",
"asignacion_for : ID '=' ':' CTE_INT",
"condicion_for : ID comparador expresion_aritmetica",
"salida : OUT '(' CADENA ')'",
};

//#line 213 "gramatica.y"

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

//#line 594 "Parser.java"
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
case 6:
//#line 21 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero declarativo y luego ejecutable ");}
break;
case 7:
//#line 22 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero ejecutable y luego declarativo ");}
break;
case 8:
//#line 23 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque declarativo ");}
break;
case 9:
//#line 24 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque ejecutable ");}
break;
case 16:
//#line 39 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 20:
//#line 45 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 21:
//#line 48 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 22:
//#line 49 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 24:
//#line 53 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 25:
//#line 56 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 27:
//#line 60 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 28:
//#line 61 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 29:
//#line 62 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque ejecutable de la funcion");}
break;
case 32:
//#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 33:
//#line 70 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 34:
//#line 71 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 35:
//#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 36:
//#line 73 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 41:
//#line 82 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 42:
//#line 83 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 45:
//#line 90 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 46:
//#line 91 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 47:
//#line 94 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 48:
//#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 55:
//#line 104 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 56:
//#line 105 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 58:
//#line 109 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 59:
//#line 110 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 60:
//#line 111 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 61:
//#line 112 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 62:
//#line 113 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 63:
//#line 114 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 64:
//#line 115 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 65:
//#line 116 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
//#line 117 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
//#line 118 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 70:
//#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=' en la asignacion");}
break;
case 71:
//#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' en la asignacion");}
break;
case 72:
//#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 73:
//#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 76:
//#line 135 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 78:
//#line 139 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 79:
//#line 140 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 80:
//#line 150 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 81:
//#line 151 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 84:
//#line 156 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el factor luego de un '*' ");}
break;
case 85:
//#line 157 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el factor luego de un '/' ");}
break;
case 86:
//#line 158 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el termino antes de un '*' ");}
break;
case 87:
//#line 159 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el termino antes de un '/' ");}
break;
case 88:
//#line 163 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
case 89:
//#line 164 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + val_peek(0).sval);}
break;
case 90:
//#line 165 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + val_peek(0).sval);}
break;
case 92:
//#line 169 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(3).sval);}
break;
case 93:
//#line 170 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + val_peek(2).sval);}
break;
case 95:
//#line 174 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " Falta el ')' que encierra los parametros");}
break;
case 98:
//#line 182 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 99:
//#line 183 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 107:
//#line 197 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 108:
//#line 198 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 111:
//#line 208 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
//#line 999 "Parser.java"
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
