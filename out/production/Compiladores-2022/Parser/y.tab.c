#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package Parser;
import Principal.*;
#line 9 "y.tab.c"
#define ID 257
#define CTE_INT 258
#define CTE_FLOTANTE 259
#define MENOR_IGUAL 260
#define MAYOR_IGUAL 261
#define DISTINTO 262
#define CADENA 263
#define ASIGNACION 264
#define IF 265
#define THEN 266
#define ELSE 267
#define ENDIF 268
#define OUT 269
#define FUN 270
#define RETURN 271
#define BREAK 272
#define DISCARD 273
#define FOR 274
#define CONTINUE 275
#define F32 276
#define I32 277
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    1,    1,    1,    1,    2,    2,    3,    3,
    6,    6,    4,    4,    4,    4,   10,    8,    8,    8,
   11,    9,    9,   13,   13,   13,   12,   12,   15,   15,
   15,   15,   15,   14,   14,   14,   14,   17,   17,   16,
   16,   18,   18,    7,    7,    5,    5,    5,    5,    5,
    5,    5,    5,    5,   25,   25,   25,   25,   25,   25,
   25,   25,   25,   25,   19,   19,   22,   22,   27,   26,
   26,   26,   26,   28,   28,   28,   28,   30,   30,   30,
   30,   29,   29,   29,   29,   20,   20,   20,   32,   31,
   31,   21,   21,   33,   34,   34,   34,   34,   34,   34,
   23,   23,   35,   36,   24,
};
short yylen[] = {                                         2,
    4,    1,    2,    2,    1,    1,    1,    2,    1,    3,
    1,    2,    3,    1,    2,    1,    3,    1,    3,    1,
    2,    4,    1,    4,    4,    3,    5,    1,    4,    4,
    4,    4,    4,    2,    3,    5,    1,    2,    2,    2,
    1,    1,    2,    1,    1,    2,    3,    2,    2,    2,
    2,    2,    2,    1,    1,    1,    1,    1,    1,    1,
    1,    2,    2,    2,    4,    1,    2,    1,    2,    1,
    3,    3,    1,    3,    3,    1,    1,    3,    3,    2,
    2,    1,    1,    1,    2,    4,    3,    1,    4,    1,
    2,    7,    9,    3,    1,    1,    1,    1,    1,    1,
   12,   12,    4,    3,    4,
};
short yydefred[] = {                                      0,
    2,    0,    0,    0,   66,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   45,   44,    0,    0,    0,    0,
    7,    9,    0,    0,   14,   16,   20,    0,   23,   28,
    0,    0,    0,    0,    0,    0,   54,   68,   88,    0,
    0,    0,    0,    0,    0,   37,   41,    0,    0,    0,
    0,    0,    0,   82,   84,   83,    0,    0,    0,    0,
    0,   76,   77,   52,    0,   62,    0,    0,   53,    0,
   11,    0,    1,    3,    8,    0,    0,   18,    0,   21,
   15,    0,    0,    0,   46,   64,   48,   49,   50,   51,
   43,    0,    0,    0,    0,    0,   40,    0,   38,   73,
    0,    0,    0,    0,    0,   34,    0,   85,   80,   81,
    0,    0,    0,    0,    0,   47,    0,    0,   10,   12,
   17,   13,   19,    0,   26,    0,    0,   35,   91,   89,
   86,    0,   29,   99,   98,  100,   97,   95,   96,    0,
    0,  105,   31,    0,   32,   30,    0,    0,   78,   74,
   79,   75,   87,    0,    0,   24,   25,   22,    0,    0,
    0,   27,    0,    0,    0,   36,    0,  103,    0,    0,
    0,   92,    0,    0,    0,    0,    0,    0,   93,    0,
    0,    0,    0,    0,    0,  101,  102,
};
short yydgoto[] = {                                       3,
   18,   19,   20,   21,   22,   72,   43,   24,   25,   26,
   27,   28,   29,   44,   30,   45,   46,   47,   31,   32,
   33,   34,   35,   36,   37,   60,   38,   61,   62,   63,
   95,   39,  102,  140,  118,  165,
};
short yysindex[] = {                                   -222,
    0,  -96,    0,  145,    0,  -40,    2,    5,  -38,   82,
    8,  -58,   34,   27,    0,    0,  385,  -89,  145, -174,
    0,    0, -175,  -27,    0,    0,    0, -116,    0,    0,
   31,   38,   50,   51,   52,   53,    0,    0,    0, -142,
  -30,   62, -136,   64,   84,    0,    0,  102, -137,  -36,
  -25,   70,    0,    0,    0,    0,  105,  105,  105,    9,
   18,    0,    0,    0,   90,    0,   73, -124,    0,   -2,
    0,  374,    0,    0,    0,  -34, -174,    0,   17,    0,
    0, -120,  145,  -79,    0,    0,    0,    0,    0,    0,
    0,    0,   -1,  105,  -22,  102,    0, -214,    0,    0,
   56,   97,   98, -214,  -53,    0, -214,    0,    0,    0,
  121,  121,  125,  129,   78,    0,   80,   83,    0,    0,
    0,    0,    0,   20,    0, -122, -219,    0,    0,    0,
    0,    9,    0,    0,    0,    0,    0,    0,    0,  102,
 -123,    0,    0, -214,    0,    0,   18,   18,    0,    0,
    0,    0,    0,   93, -109,    0,    0,    0,  111,    9,
  353,    0, -105,  -52,   99,    0, -188,    0,  102,   23,
  353,    0,    9,  -97,  -93, -106,  126,  128,    0,   48,
   49,  353,  353,   54,   57,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,   -3,    0,    0,    0,    0,
  170,    0,    0,  194,    0,    0,    0,    0,   58, -101,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  218,    0,  241,  264,  286,  308,    0,    0,    0,    0,
    0,    0,   37,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   55,    0,    0,    0,    0,    0,    0,   77,
  -12,    0,    0,    0,    0,    0,  330,    0,    0,    0,
    0,    0,    0,    0,    0,   -3, -100,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   30,  -44,  -21,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  100,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -110,    0,    0,   10,   32,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  132,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  122,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   22,  164,   -7,    7,   13,    0,  592,  162,    0,    0,
    0,    0,    0,   14,    0,  -23,    0,    0,    0,  175,
    0,    0,    0,    0,    0,   -9,    0,   -4,  366,    0,
   94,    0,    0,   25,    0,    0,
};
#define YYTABLESIZE 736
short yytable[] = {                                      41,
   66,   51,  158,   51,  144,   51,   84,  138,  137,  139,
   92,   74,   33,   39,   57,  106,   82,   93,  131,   90,
   42,  104,   52,    6,    4,   75,    4,   93,   70,   71,
   70,   81,   70,    1,    2,   73,   40,  115,  101,  128,
   18,   48,  127,   17,   49,  125,   70,   70,   70,   70,
   71,  111,   71,  112,   71,   18,   15,   16,   42,  113,
   82,   15,   16,  105,  114,  174,   64,  175,   71,   71,
   71,   71,   72,   68,   72,  122,   72,   42,  171,  172,
   42,   78,   76,   75,  120,   69,  132,   34,   87,   85,
   72,   72,   72,   72,   42,    9,   86,   73,  111,   73,
  112,   15,   16,  159,  124,  126,  147,  148,   87,   88,
   89,   90,   70,   69,   91,  138,  137,  139,  153,   96,
   97,   98,   57,   58,   99,  103,   57,  107,   59,  115,
  160,  116,  117,  157,   71,   67,  123,  141,  142,   83,
  154,  155,  161,   58,  156,   33,   57,  164,   59,   57,
  163,  166,  168,  167,    6,    4,   72,  170,   65,  173,
  177,  179,   58,  176,  178,   57,  180,   59,  181,   57,
  182,  183,   94,   57,  184,  185,    5,    6,  186,   69,
  104,  187,    5,   77,   79,    7,   67,  129,  169,    8,
    9,   10,   11,   12,   13,   14,   15,   16,   65,    0,
    0,   67,    0,    0,    0,    0,    0,  134,  135,  136,
    0,    0,    0,    0,    0,   40,    0,   40,   50,   40,
    0,   40,   15,   16,   65,   40,   54,   55,   56,   80,
   40,   39,   39,  130,   90,   15,   16,   15,   16,   15,
   16,   15,   16,   70,   70,   15,   16,   70,   70,   70,
   15,   16,   70,   18,   70,   70,   70,   70,   70,   70,
   70,   70,   70,   70,   70,   71,   71,   17,    0,   71,
   71,   71,  121,   80,   71,    0,   71,   71,   71,   71,
   71,   71,   71,   71,   71,   71,   71,   72,   72,    0,
    0,   72,   72,   72,   60,    0,   72,    0,   72,   72,
   72,   72,   72,   72,   72,   72,   72,   72,   72,    0,
   69,   69,   42,   42,    0,  134,  135,  136,   61,   69,
    0,   69,   69,   69,   69,   69,   69,   69,   69,   69,
   69,   69,   67,   67,   54,   55,   56,   53,   54,   55,
   56,   67,   55,   67,   67,   67,   67,   67,   67,   67,
   67,   67,   67,   67,    0,   65,   65,  100,   54,   55,
   56,   54,   55,   56,   65,   56,   65,   65,   65,   65,
   65,   65,   65,   65,   65,   65,   65,   54,   55,   56,
  149,   54,   55,   56,  151,   54,   55,   56,   57,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    5,    6,    0,    0,    0,    0,   94,    0,    0,    7,
   58,    0,    0,    8,    9,   10,   11,   12,   13,   14,
   15,   16,  108,  109,  110,   60,   60,    0,    0,    0,
    0,    0,   59,    0,   60,    0,   60,   60,   60,   60,
   60,   60,   60,   60,   60,   60,   60,    0,    0,   61,
   61,    0,    0,    0,   63,    0,    0,    0,   61,   94,
   61,   61,   61,   61,   61,   61,   61,   61,   61,   61,
   61,    0,    0,   55,   55,   17,    0,    0,  150,  152,
   94,    0,   55,    0,   55,   55,   55,   55,   55,   55,
   55,   55,   55,   55,   55,    0,   56,   56,  119,    0,
    0,    0,    0,    0,    0,   56,    0,   56,   56,   56,
   56,   56,   56,   56,   56,   56,   56,   56,    0,   57,
   57,    0,    0,    0,    0,    0,    0,    0,   57,    0,
   57,   57,   57,   57,   57,   57,   57,   57,   57,   57,
   57,   58,   58,    0,    0,    0,    0,    0,    0,    0,
   58,    0,   58,   58,   58,   58,   58,   58,   58,   58,
   58,   58,   58,   59,   59,    0,    0,    0,    0,    0,
    0,    0,   59,    0,   59,   59,   59,   59,   59,   59,
   59,   59,   59,   59,   59,   63,   63,    0,    0,    0,
    0,    0,    0,    0,   63,   23,   63,   63,   63,   63,
   63,   63,   63,   63,   63,   63,   63,    0,    5,   70,
   23,   23,    0,    0,    0,    0,    0,    7,    0,    0,
    0,    8,    0,   10,   11,   12,   13,   14,    0,    5,
   70,    0,    0,    0,    0,    0,    0,    0,    7,    0,
    5,   70,    8,    0,   10,   11,   12,   13,   14,    7,
    0,    0,    0,    8,    0,   10,   11,   12,   13,   14,
    0,    0,    0,    0,    0,    0,    0,    0,   23,    0,
    0,    0,    0,    0,   23,   23,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  133,
    0,    0,    0,    0,    0,  143,  145,    0,  146,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  162,
};
short yycheck[] = {                                      40,
   59,   40,  125,   40,   58,   40,  123,   60,   61,   62,
   41,   19,  123,   58,   45,   41,   44,   41,   41,   41,
   61,   58,    9,  125,  125,   19,  123,   51,   41,   17,
   43,   59,   45,  256,  257,  125,  256,   40,   48,   41,
   44,   40,   44,  123,   40,  125,   59,   60,   61,   62,
   41,   43,   43,   45,   45,   59,  276,  277,   61,   42,
   44,  276,  277,   50,   47,   43,   59,   45,   59,   60,
   61,   62,   41,   40,   43,   59,   45,   41,  267,  268,
   44,  257,  257,   77,   72,   59,   96,   58,   59,   59,
   59,   60,   61,   62,   58,  270,   59,   43,   43,   45,
   45,  276,  277,  127,   83,   84,  111,  112,   59,   59,
   59,   59,  125,   59,  257,   60,   61,   62,   41,   58,
  257,   58,   45,   42,   41,  263,   45,   58,   47,   40,
  140,   59,  257,  256,  125,   59,  257,   41,   41,  256,
   61,   59,  266,   42,  125,  256,   45,  257,   47,   45,
   58,   41,  258,  161,  256,  256,  125,   59,   59,  169,
  258,  268,   42,  171,  258,   45,   41,   47,   41,   45,
  123,  123,   41,   45,  182,  183,  256,  257,  125,  125,
   59,  125,  125,   20,   23,  265,   12,   94,  164,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  257,   -1,
   -1,  125,   -1,   -1,   -1,   -1,   -1,  260,  261,  262,
   -1,   -1,   -1,   -1,   -1,  256,   -1,  256,  257,  256,
   -1,  256,  276,  277,  125,  256,  257,  258,  259,  257,
  256,  276,  277,  256,  256,  276,  277,  276,  277,  276,
  277,  276,  277,  256,  257,  276,  277,  260,  261,  262,
  276,  277,  265,  257,  267,  268,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  256,  257,  123,   -1,  260,
  261,  262,  256,  257,  265,   -1,  267,  268,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  256,  257,   -1,
   -1,  260,  261,  262,  125,   -1,  265,   -1,  267,  268,
  269,  270,  271,  272,  273,  274,  275,  276,  277,   -1,
  256,  257,  276,  277,   -1,  260,  261,  262,  125,  265,
   -1,  267,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  256,  257,  257,  258,  259,  256,  257,  258,
  259,  265,  125,  267,  268,  269,  270,  271,  272,  273,
  274,  275,  276,  277,   -1,  256,  257,  256,  257,  258,
  259,  257,  258,  259,  265,  125,  267,  268,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  257,  258,  259,
  256,  257,  258,  259,  256,  257,  258,  259,  125,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  256,  257,   -1,   -1,   -1,   -1,   41,   -1,   -1,  265,
  125,   -1,   -1,  269,  270,  271,  272,  273,  274,  275,
  276,  277,   57,   58,   59,  256,  257,   -1,   -1,   -1,
   -1,   -1,  125,   -1,  265,   -1,  267,  268,  269,  270,
  271,  272,  273,  274,  275,  276,  277,   -1,   -1,  256,
  257,   -1,   -1,   -1,  125,   -1,   -1,   -1,  265,   94,
  267,  268,  269,  270,  271,  272,  273,  274,  275,  276,
  277,   -1,   -1,  256,  257,  123,   -1,   -1,  113,  114,
  115,   -1,  265,   -1,  267,  268,  269,  270,  271,  272,
  273,  274,  275,  276,  277,   -1,  256,  257,  125,   -1,
   -1,   -1,   -1,   -1,   -1,  265,   -1,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,   -1,  256,
  257,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,
  267,  268,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  256,  257,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  265,   -1,  267,  268,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  256,  257,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  265,   -1,  267,  268,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  256,  257,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  265,    4,  267,  268,  269,  270,
  271,  272,  273,  274,  275,  276,  277,   -1,  256,  257,
   19,   20,   -1,   -1,   -1,   -1,   -1,  265,   -1,   -1,
   -1,  269,   -1,  271,  272,  273,  274,  275,   -1,  256,
  257,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,
  256,  257,  269,   -1,  271,  272,  273,  274,  275,  265,
   -1,   -1,   -1,  269,   -1,  271,  272,  273,  274,  275,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   77,   -1,
   -1,   -1,   -1,   -1,   83,   84,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   98,
   -1,   -1,   -1,   -1,   -1,  104,  105,   -1,  107,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  144,
};
#define YYFINAL 3
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 277
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"'{'",0,
"'}'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,"ID","CTE_INT","CTE_FLOTANTE","MENOR_IGUAL",
"MAYOR_IGUAL","DISTINTO","CADENA","ASIGNACION","IF","THEN","ELSE","ENDIF","OUT",
"FUN","RETURN","BREAK","DISCARD","FOR","CONTINUE","F32","I32",
};
char *yyrule[] = {
"$accept : programa",
"programa : ID '{' bloque '}'",
"programa : error",
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
"asignacion : error",
"retorno : RETURN expresion_aritmetica",
"retorno : error_retorno",
"error_retorno : RETURN error",
"expresion_aritmetica : termino",
"expresion_aritmetica : expresion_aritmetica '+' termino",
"expresion_aritmetica : expresion_aritmetica '-' termino",
"expresion_aritmetica : error",
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
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 216 "gramatica.y"

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

#line 491 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 12 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
break;
case 2:
#line 13 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " programa mal declarado");}
break;
case 3:
#line 22 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero declarativo y luego ejecutable ");}
break;
case 4:
#line 23 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero ejecutable y luego declarativo ");}
break;
case 5:
#line 24 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque declarativo ");}
break;
case 6:
#line 25 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque ejecutable ");}
break;
case 13:
#line 40 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 17:
#line 46 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 18:
#line 49 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 19:
#line 50 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 21:
#line 54 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 22:
#line 57 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 24:
#line 61 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 25:
#line 62 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 26:
#line 63 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque ejecutable de la funcion");}
break;
case 29:
#line 70 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 30:
#line 71 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 31:
#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 32:
#line 73 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 33:
#line 74 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 38:
#line 83 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 39:
#line 84 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 42:
#line 91 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 43:
#line 92 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 44:
#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 45:
#line 96 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 52:
#line 105 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 53:
#line 106 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 55:
#line 110 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 56:
#line 111 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 57:
#line 112 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 58:
#line 113 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 59:
#line 114 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 60:
#line 115 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 61:
#line 116 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 62:
#line 117 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 63:
#line 118 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 64:
#line 119 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 66:
#line 123 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " error en la asignacion");}
break;
case 69:
#line 137 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 71:
#line 141 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 72:
#line 142 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 74:
#line 153 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 75:
#line 154 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 78:
#line 159 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el factor luego de un '*' ");}
break;
case 79:
#line 160 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el factor luego de un '/' ");}
break;
case 80:
#line 161 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el termino antes de un '*' ");}
break;
case 81:
#line 162 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el termino antes de un '/' ");}
break;
case 82:
#line 166 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 83:
#line 167 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 84:
#line 168 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 86:
#line 172 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);}
break;
case 87:
#line 173 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-2].sval);}
break;
case 89:
#line 177 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " Falta el ')' que encierra los parametros");}
break;
case 92:
#line 185 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 93:
#line 186 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 101:
#line 200 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 102:
#line 201 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 105:
#line 211 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
#line 867 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
