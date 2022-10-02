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
short yylen[] = {                                         2,
    4,    1,    3,    4,    3,    2,    2,    1,    1,    1,
    2,    1,    3,    1,    2,    3,    1,    2,    1,    3,
    1,    3,    1,    2,    4,    1,    4,    4,    3,    5,
    1,    4,    4,    4,    4,    4,    2,    3,    5,    1,
    2,    2,    2,    1,    1,    2,    1,    1,    2,    3,
    2,    2,    2,    2,    2,    2,    1,    1,    1,    1,
    1,    1,    1,    1,    2,    2,    2,    4,    1,    3,
    3,    4,    3,    2,    1,    2,    1,    3,    3,    3,
    3,    1,    1,    3,    3,    2,    2,    1,    1,    1,
    2,    4,    3,    1,    3,    1,    2,    7,    9,    3,
    1,    1,    1,    1,    1,    1,   12,   12,    4,    3,
    4,
};
short yydefred[] = {                                      0,
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
   92,   72,    0,   32,  105,  104,  106,  103,  101,  102,
    0,    0,  111,   34,    0,   35,   33,    0,    0,   84,
   80,   85,   81,   93,    0,    0,   27,   28,   25,    0,
    0,    0,   30,    0,    0,    0,   39,    0,  109,    0,
    0,    0,   98,    0,    0,    0,    0,    0,    0,   99,
    0,    0,    0,    0,    0,    0,  107,  108,
};
short yydgoto[] = {                                       3,
   20,    4,   21,   22,   23,   24,   78,   25,   26,   27,
   28,   29,   30,   31,   50,   32,   51,   52,   53,   33,
   34,   35,   36,   37,   38,   39,   66,   40,   41,   67,
   68,   69,  105,   42,  112,  151,  128,  176,
};
short yysindex[] = {                                   -121,
 -116,  560,    0,    0,  560,  560,  -37,  -10,   -2,  -31,
  142,  -19,  -40,    9,   -1,    0,    0,  333,   13,  -47,
  560, -200,    0,    0, -176,  -16,    0,    0,    0, -115,
    0,    0,   28,   30,   34,   41,   49,   55,    0,    0,
    0,    0,  -13,   -3, -142,  399,  -23,  163, -138,   62,
   80,    0,    0,  399, -140,  -29,   53,   66,    0,    0,
    0,    0,  360,  360,  360,    5,   54,    0,    0,    0,
   85,    0,   68, -126,    0,   -6,    0,  272,  399,    0,
    0,    0,  -25, -200,    0,  -27,    0,    0, -125,  560,
  538,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    5,    0,   15,  360,   93,  310,    5,    0, -202,    0,
  331,   94,   97, -202,  -53,    0, -202,    0,    0,    0,
  399,  399,  -45,  114,   92,    0,   81,   87,    0,    0,
    5,    0,    0,    0,   24,    0, -111, -223,    0,    0,
    0,    0,    5,    0,    0,    0,    0,    0,    0,    0,
  399, -119,    0,    0, -202,    0,    0,   54,   54,    0,
    0,    0,    0,    0,   95, -102,    0,    0,    0,  117,
    5,  582,    0,  -98,  405,  103,    0, -165,    0,  399,
   22,  582,    0,    5,  -95,  -94, -103,  125,  127,    0,
   46,   48,  582,  582,   50,   56,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,   -8,    0,    0,    0,
    0,  228,    0,    0,  250,    0,    0,    0,    0,    0,
    4,   26,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  403,    0,  425,  447,  469,  491,    0,    0,
    0,    0,    0,  176,    0,    0,    0,    0,   51,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   69,    1,    0,    0,    0,
    0,    0,  513,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   -8,   31,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   91,   52,  -21,  113,  139,    0,  161,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  183,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  206,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0, -113,    0,    0,   23,   45,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  136,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  121,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
    7,    0,  160,  -15,   -5,    2,    0,  811,  165,    0,
    0,    0,    0,    0,   17,    0,  -22,    0,    0,    0,
  172,    0,    0,    0,    0,    0,   -7,    0,    0,   -4,
  516,    0,   82,    0,    0,   16,    0,    0,
};
#define YYTABLESIZE 966
short yytable[] = {                                      63,
   77,    2,   47,    8,  155,   81,    6,   91,   57,   36,
   57,   43,   44,  169,   57,   82,   89,  102,   72,   77,
   46,   63,   78,   48,  103,    9,   58,   89,  114,   54,
    7,  133,   45,  125,  103,   21,   42,   55,  101,   70,
  107,   77,   88,   77,   79,   77,  111,  121,   74,  122,
   21,   46,   16,   17,   48,  139,   83,   75,  138,   77,
   77,   77,   77,   78,  185,   78,  186,   78,   74,   10,
   79,  131,  115,   16,   17,   16,   17,   80,   82,  130,
   85,   78,   78,   78,   78,   79,   92,   79,   93,   79,
   70,   45,   94,  116,   45,  123,  135,  137,  143,   95,
  124,  182,  183,   79,   79,   79,   79,   96,   45,   37,
   93,   98,   96,   97,  100,  170,  158,  159,  108,  109,
  110,   99,  113,  117,  125,   77,  126,   74,    8,   74,
  127,  134,  164,  141,  152,    1,   63,  153,   95,    5,
   90,  165,   36,  171,  168,  166,  172,   78,  167,   70,
    9,   70,  174,   96,  175,    7,  178,  177,   63,  179,
   71,  181,  188,  189,  190,  191,  187,  192,  193,   79,
  194,   96,  184,   96,  197,    5,  100,  195,  196,  110,
  198,   84,   73,   64,   73,  140,   63,    0,   65,   86,
  180,    0,    0,   74,    0,    0,    0,   95,    0,   95,
    0,    0,    0,    0,   64,   68,    0,   63,    0,   65,
  160,   60,   61,   62,    0,   70,   71,    0,   45,   71,
  106,   71,   16,   17,   45,   56,   45,   63,  132,   87,
   45,    0,   45,   60,   61,   62,    0,   96,   16,   17,
   87,   73,    0,   73,   16,   17,   16,   17,   21,   64,
   16,   17,   16,   17,   42,   42,   77,   77,    0,    8,
   77,   77,   77,   95,   68,   77,   68,   77,   77,   77,
   77,   77,   77,   77,   77,   77,   77,   77,   78,   78,
    0,    9,   78,   78,   78,   71,    7,   78,   63,   78,
   78,   78,   78,   78,   78,   78,   78,   78,   78,   78,
   79,   79,    0,    0,   79,   79,   79,   73,   45,   79,
   64,   79,   79,   79,   79,   79,   79,   79,   79,   79,
   79,   79,    0,    0,   74,   74,   45,   45,   16,   17,
   68,    0,   19,   74,    0,   74,   74,   74,   74,   74,
   74,   74,   74,   74,   74,   74,   70,   70,   60,   61,
   62,   64,   63,    0,   63,   70,   65,   70,   70,   70,
   70,   70,   70,   70,   70,   70,   70,   70,   96,  162,
   60,   61,   62,  121,   64,  122,    0,   96,    0,   96,
   96,   96,   96,   96,   96,   96,   96,   96,   96,   96,
  149,  148,  150,   19,   95,   95,  129,   59,   60,   61,
   62,    0,   58,   95,   63,   95,   95,   95,   95,   95,
   95,   95,   95,   95,   95,   95,   71,   71,    0,   60,
   61,   62,    0,    0,   59,   71,    0,   71,   71,   71,
   71,   71,   71,   71,   71,   71,   71,   71,   73,   73,
   64,    0,    0,   63,    0,   65,   60,   73,    0,   73,
   73,   73,   73,   73,   73,   73,   73,   73,   73,   73,
    0,   68,   68,   58,  149,  148,  150,    0,   61,    0,
   68,    0,   68,   68,   68,   68,   68,   68,   68,   68,
   68,   68,   68,   63,   63,   59,    0,    0,    0,    0,
   62,    0,   63,    0,   63,   63,   63,   63,   63,   63,
   63,   63,   63,   63,   63,   64,   64,   60,    0,    0,
    0,    0,   66,    0,   64,    0,   64,   64,   64,   64,
   64,   64,   64,   64,   64,   64,   64,   58,   76,   61,
    0,    0,    0,    0,    0,    0,    8,    0,    0,    0,
    9,    0,   11,   12,   13,   14,   15,    0,    0,   59,
    0,   62,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  104,    0,    0,  142,   60,   61,   62,    0,
    0,   60,    0,   66,    0,    0,    0,    0,  118,  119,
  120,    0,    0,    0,    0,    0,    0,    0,    0,   76,
  145,  146,  147,   61,    0,    0,    0,    8,   19,    0,
    0,    9,    0,   11,   12,   13,   14,   15,    0,    0,
    0,    0,    0,    0,    0,   62,   60,   61,   62,  104,
   19,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   66,  161,  163,
  104,    0,   19,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   60,   61,   62,   58,   58,
   18,    0,  136,    0,  145,  146,  147,   58,    0,   58,
   58,   58,   58,   58,   58,   58,   58,   58,   58,   58,
   59,   59,   18,    0,    0,    0,    0,    0,    0,   59,
    0,   59,   59,   59,   59,   59,   59,   59,   59,   59,
   59,   59,   60,   60,   18,    0,    0,    0,    0,    0,
    0,   60,    0,   60,   60,   60,   60,   60,   60,   60,
   60,   60,   60,   60,   61,   61,    0,    0,    0,    0,
    0,    0,    0,   61,    0,   61,   61,   61,   61,   61,
   61,   61,   61,   61,   61,   61,   62,   62,    0,    0,
    0,    0,    0,    0,    0,   62,    0,   62,   62,   62,
   62,   62,   62,   62,   62,   62,   62,   62,   66,   66,
    0,    0,    0,    0,    0,    0,    0,   66,    0,   66,
   66,   66,   66,   66,   66,   66,   66,   66,   66,   66,
    0,    0,    0,    0,    7,    0,    0,    0,    0,    0,
    0,    0,    8,    0,    0,    0,    9,   10,   11,   12,
   13,   14,   15,   16,   17,    0,    7,   49,    0,    0,
   49,    0,    0,    0,    8,    0,    0,    0,    9,   10,
   11,   12,   13,   14,   15,   16,   17,    0,   76,    0,
    0,    0,    0,    0,    0,    0,    8,    0,    0,    0,
    9,    0,   11,   12,   13,   14,   15,   49,    0,    0,
    0,    0,    0,    0,    0,    0,   49,   49,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   49,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  144,
    0,    0,    0,    0,  154,  156,    0,  157,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   49,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  173,
};
short yycheck[] = {                                      45,
    0,  123,   40,    0,   58,   21,  123,  123,   40,  123,
   40,    5,    6,  125,   40,   21,   44,   41,   59,   18,
   58,   45,    0,   61,   47,    0,   10,   44,   58,   40,
    0,   59,  256,   40,   57,   44,   58,   40,   46,   59,
   48,   41,   59,   43,    0,   45,   54,   43,   40,   45,
   59,   58,  276,  277,   61,   41,  257,   59,   44,   59,
   60,   61,   62,   41,   43,   43,   45,   45,    0,  270,
   58,   79,   56,  276,  277,  276,  277,  125,   84,   78,
  257,   59,   60,   61,   62,   41,   59,   43,   59,   45,
    0,   41,   59,   41,   44,   42,   90,   91,  106,   59,
   47,  267,  268,   59,   60,   61,   62,   59,   58,   58,
   59,  125,    0,   59,  257,  138,  121,  122,  257,   58,
   41,  125,  263,   58,   40,  125,   59,   59,  125,   61,
  257,  257,   41,   41,   41,  257,   45,   41,    0,  256,
  256,   61,  256,  151,  256,   59,  266,  125,  125,   59,
  125,   61,   58,   41,  257,  125,  172,   41,   45,  258,
    0,   59,  258,  258,  268,   41,  182,   41,  123,  125,
  123,   59,  180,   61,  125,    0,   41,  193,  194,   59,
  125,   22,    0,   42,   13,  104,   45,   -1,   47,   25,
  175,   -1,   -1,  125,   -1,   -1,   -1,   59,   -1,   61,
   -1,   -1,   -1,   -1,   42,    0,   -1,   45,   -1,   47,
  256,  257,  258,  259,   -1,  125,  257,   -1,  256,   59,
   58,   61,  276,  277,  256,  257,  256,    0,  256,  257,
  256,   -1,  256,  257,  258,  259,   -1,  125,  276,  277,
  257,   59,   -1,   61,  276,  277,  276,  277,  257,    0,
  276,  277,  276,  277,  276,  277,  256,  257,   -1,  256,
  260,  261,  262,  125,   59,  265,   61,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  257,
   -1,  256,  260,  261,  262,  125,  256,  265,   61,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  256,  257,   -1,   -1,  260,  261,  262,  125,  256,  265,
   61,  267,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  277,   -1,   -1,  256,  257,  276,  277,  276,  277,
  125,   -1,   61,  265,   -1,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  256,  257,  257,  258,
  259,   42,  125,   -1,   45,  265,   47,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  256,
  257,  258,  259,   43,  125,   45,   -1,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
   60,   61,   62,   61,  256,  257,  125,  256,  257,  258,
  259,   -1,    0,  265,   45,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  256,  257,   -1,  257,
  258,  259,   -1,   -1,    0,  265,   -1,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  257,
   42,   -1,   -1,   45,   -1,   47,    0,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
   -1,  256,  257,   61,   60,   61,   62,   -1,    0,   -1,
  265,   -1,  267,  268,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  256,  257,   61,   -1,   -1,   -1,   -1,
    0,   -1,  265,   -1,  267,  268,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  256,  257,   61,   -1,   -1,
   -1,   -1,    0,   -1,  265,   -1,  267,  268,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  125,  257,   61,
   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,   -1,   -1,
  269,   -1,  271,  272,  273,  274,  275,   -1,   -1,  125,
   -1,   61,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   47,   -1,   -1,  256,  257,  258,  259,   -1,
   -1,  125,   -1,   61,   -1,   -1,   -1,   -1,   63,   64,
   65,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,
  260,  261,  262,  125,   -1,   -1,   -1,  265,   61,   -1,
   -1,  269,   -1,  271,  272,  273,  274,  275,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  125,  257,  258,  259,  104,
   61,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  125,  123,  124,
  125,   -1,   61,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  257,  258,  259,  256,  257,
  123,   -1,  125,   -1,  260,  261,  262,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
  256,  257,  123,   -1,   -1,   -1,   -1,   -1,   -1,  265,
   -1,  267,  268,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  256,  257,  123,   -1,   -1,   -1,   -1,   -1,
   -1,  265,   -1,  267,  268,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  256,  257,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  265,   -1,  267,  268,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  256,  257,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  265,   -1,  267,  268,  269,
  270,  271,  272,  273,  274,  275,  276,  277,  256,  257,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,  267,
  268,  269,  270,  271,  272,  273,  274,  275,  276,  277,
   -1,   -1,   -1,   -1,  257,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  265,   -1,   -1,   -1,  269,  270,  271,  272,
  273,  274,  275,  276,  277,   -1,  257,    7,   -1,   -1,
   10,   -1,   -1,   -1,  265,   -1,   -1,   -1,  269,  270,
  271,  272,  273,  274,  275,  276,  277,   -1,  257,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  265,   -1,   -1,   -1,
  269,   -1,  271,  272,  273,  274,  275,   47,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   56,   57,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   83,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  109,
   -1,   -1,   -1,   -1,  114,  115,   -1,  117,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  138,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  155,
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
"error_invocacion : ID '(' parametros_reales",
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
#line 213 "gramatica.y"

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

#line 548 "y.tab.c"
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
case 3:
#line 16 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
#line 17 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
#line 18 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
#line 21 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero declarativo y luego ejecutable ");}
break;
case 7:
#line 22 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa declarado, es primero ejecutable y luego declarativo ");}
break;
case 8:
#line 23 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque declarativo ");}
break;
case 9:
#line 24 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] el bloque de programa es solo bloque ejecutable ");}
break;
case 16:
#line 39 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 20:
#line 45 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 21:
#line 48 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 22:
#line 49 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 24:
#line 53 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 25:
#line 56 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 27:
#line 60 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 28:
#line 61 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 29:
#line 62 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque ejecutable de la funcion");}
break;
case 32:
#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 33:
#line 70 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 34:
#line 71 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 35:
#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 36:
#line 73 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 41:
#line 82 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 42:
#line 83 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 45:
#line 90 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 46:
#line 91 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 47:
#line 94 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 48:
#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 55:
#line 104 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 56:
#line 105 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 58:
#line 109 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 59:
#line 110 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 60:
#line 111 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 61:
#line 112 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 62:
#line 113 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 63:
#line 114 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 64:
#line 115 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 65:
#line 116 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
#line 117 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
#line 118 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 70:
#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=' en la asignacion");}
break;
case 71:
#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' en la asignacion");}
break;
case 72:
#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 73:
#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 76:
#line 135 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 78:
#line 139 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 79:
#line 140 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 80:
#line 150 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 81:
#line 151 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 84:
#line 156 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el factor luego de un '*' ");}
break;
case 85:
#line 157 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el factor luego de un '/' ");}
break;
case 86:
#line 158 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el termino antes de un '*' ");}
break;
case 87:
#line 159 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "falta el termino antes de un '/' ");}
break;
case 88:
#line 163 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 89:
#line 164 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 90:
#line 165 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 92:
#line 169 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);}
break;
case 93:
#line 170 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-2].sval);}
break;
case 95:
#line 174 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + "Falta EL ')' que encierra los parametros");}
break;
case 98:
#line 182 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 99:
#line 183 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 107:
#line 197 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 108:
#line 198 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 111:
#line 208 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
#line 944 "y.tab.c"
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
