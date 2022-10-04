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
    3,    4,    4,    5,    5,    5,   10,   10,   10,    8,
    8,    8,   11,   11,   11,    9,    9,   13,   13,   13,
   12,   12,   15,   15,   15,   15,   15,   14,   14,   14,
   14,   17,   17,   17,   16,   16,   18,   18,    7,    7,
    6,    6,    6,    6,    6,    6,    6,    6,    6,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   25,   19,
   19,   27,   27,   27,   22,   22,   28,   26,   26,   26,
   26,   30,   30,   29,   29,   29,   29,   32,   32,   32,
   32,   31,   31,   31,   31,   31,   20,   20,   33,   33,
   34,   34,   34,   34,   21,   21,   21,   37,   37,   37,
   37,   37,   37,   37,   36,   36,   36,   38,   38,   35,
   39,   39,   39,   39,   39,   39,   23,   23,   23,   42,
   42,   42,   40,   40,   43,   43,   43,   41,   41,   44,
   44,   44,   24,   24,   45,   45,   45,
};
short yylen[] = {                                         2,
    4,    1,    3,    4,    3,    2,    2,    1,    1,    1,
    2,    1,    2,    3,    1,    1,    3,    2,    2,    1,
    3,    1,    2,    2,    3,    4,    1,    3,    4,    3,
    5,    1,    4,    4,    4,    4,    5,    2,    3,    5,
    1,    2,    2,    7,    2,    1,    1,    2,    1,    1,
    2,    3,    2,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    2,    2,    2,    3,    2,    3,
    1,    3,    3,    2,    2,    1,    1,    1,    3,    3,
    1,    3,    3,    3,    3,    1,    1,    3,    3,    2,
    2,    1,    1,    1,    1,    2,    4,    3,    1,    3,
    1,    1,    1,    2,    7,    9,    1,    6,    6,    6,
    6,    6,    6,    7,    1,    3,    1,    2,    2,    3,
    1,    1,    1,    1,    1,    1,   10,   10,    1,    9,
    9,    9,    3,    1,    2,    2,    2,    3,    1,    2,
    2,    2,    4,    1,    3,    3,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   50,   49,    0,    0,
    0,    0,    0,   10,   12,    0,    0,   15,   16,   22,
    0,   27,   32,    0,    0,    0,    0,    0,    0,   59,
   71,   76,  107,  129,  144,    0,    0,    0,    0,    0,
    0,    0,    0,   41,   46,    0,   94,   93,    0,    0,
    0,   95,    0,    0,   81,   86,   87,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   64,   57,    0,
   67,    0,    0,   66,   58,   24,    0,    3,    0,   11,
    0,   13,   20,   19,    0,   23,   18,    0,    0,    0,
   60,   51,   69,   61,   53,   65,   54,   62,   55,   63,
   56,    4,    1,    0,    0,   73,    0,  101,  103,  102,
    0,    0,    0,    0,    0,   45,    0,   42,    0,   96,
   90,   91,    0,    0,    0,    0,    0,    0,  125,  124,
  126,  121,  122,  123,    0,    0,  145,    0,  146,   48,
    0,    0,   38,    0,   68,   52,    0,    0,    0,  134,
    0,    0,    0,   17,   14,   25,   21,   30,    0,   28,
  104,    0,   39,   97,    0,   33,   98,   82,    0,   83,
    0,   88,   84,   89,   85,    0,    0,    0,    0,    0,
  143,   35,    0,   36,   34,  136,    0,  135,    0,    0,
    0,   29,   26,    0,  100,    0,    0,    0,    0,  117,
    0,    0,    0,    0,   37,   31,  133,    0,    0,    0,
  139,    0,    0,   40,    0,  118,  110,  111,  113,    0,
  112,  109,    0,    0,    0,    0,  108,    0,  116,  114,
    0,  105,    0,    0,    0,    0,   44,    0,    0,    0,
    0,    0,    0,  106,  130,    0,  132,    0,  131,  127,
  128,
};
short yydgoto[] = {                                       3,
   21,    4,   22,  207,   24,  208,   26,   27,   28,   29,
   30,   31,   32,   52,   33,   53,   54,   55,   34,   35,
   36,   37,   38,   39,   40,   69,   41,   42,   64,   65,
   66,   67,  124,  125,   70,  209,   43,  210,  145,  159,
  220,   44,  160,  221,   45,
};
short yysindex[] = {                                   -109,
 -102,   18,    0,    0,   18,   18,  -33,  454,   44,   17,
  -30,  454,  -48,  -46,   11,  -40,    0,    0, -215,  454,
  -62,   18,   18,    0,    0,   24,   43,    0,    0,    0,
  -35,    0,    0,  -39,   10,  -36,  -32,  -23,  104,    0,
    0,    0,    0,    0,    0,  -51,  -44,  458,  363,   20,
 -172,   32,   59,    0,    0,   65,    0,    0,  263,  263,
  263,    0,   -5,   25,    0,    0,    0,   90,  113,   69,
   70,   23, -148,  -28,    8,   57,   -5,    0,    0,   65,
    0,  130, -191,    0,    0,    0,   76,    0,  107,    0,
  126,    0,    0,    0,  418,    0,    0, -163,   -3,   -2,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   65,   -5,    0,   -5,    0,    0,    0,
    0,  263,   34,   83,   86,    0, -180,    0,  164,    0,
    0,    0,  434,  448,  173,  259, -141,  -41,    0,    0,
    0,    0,    0,    0,  454, -133,    0,   95,    0,    0,
 -180,   46,    0, -180,    0,    0, -204, -120,   80,    0,
 -126,   -1,  -24,    0,    0,    0,    0,    0, -103,    0,
    0, -230,    0,    0,  273,    0,    0,    0,   25,    0,
   25,    0,    0,    0,    0,   81,   81,   55,   -5,   81,
    0,    0, -221,    0,    0,    0, -117,    0,  478,   81,
  454,    0,    0,   35,    0,  107,   94,    0, -125,    0,
 -124,   68, -123, -122,    0,    0,    0,  426,  454,   92,
    0, -119, -230,    0,  120,    0,    0,    0,    0, -197,
    0,    0,   -5,  454,   -5,  -37,    0,  101,    0,    0,
   81,    0,   -5,  111,    7,   73,    0, -113,   81,  116,
   81,  118,   81,    0,    0,   81,    0,   81,    0,    0,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,   48,    0,    0,    0,
    0,  134,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    2,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  161,    0,    0,    0,
  -26,    0,    0,    0,    0,  153,    0,    0,    0,    0,
    0,    0,  151,  375,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  329,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    3,    0,
    4,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  143,  352,    0,  358,    0,    0,    0,
   40,    0,   58,    0,  121,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  368,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   48,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  383,    0,
  405,    0,    0,    0,    0,    0,    0,    0,  -10,    0,
    0,    0,    0,    0,    0,    0,  105,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   42,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  303,    0,    0,    0,    0,    0,
    0,    0,  106,  109,  110,    0,    0,    0,    0,    0,
    0,    0,  112,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
   19,    0,  149,  502,   12,  452,  573,  140,    0,    0,
    0,    0,    0,    6,    0,  -22,    0,    0,    0,  392,
    0,    0,    0,    0,    0,  349,    0,    0,  -21,    0,
  -16,    0,    0,    5,    9,  323,    0,    0, -166,    0,
    0,    0,    0,    0,    0,
};
#define YYTABLESIZE 796
short yytable[] = {                                     188,
    8,    9,    6,    7,   20,  245,   50,  246,   19,   75,
   79,   75,   81,    2,   47,   75,   76,   47,   85,  102,
    6,  203,  105,   46,   47,   73,  107,  123,   87,  151,
  120,   47,  219,   90,  215,  109,   20,  133,  129,  134,
   19,   86,  130,  131,  132,   17,   18,  251,  153,  100,
   83,  234,  123,  196,   17,   18,   72,   20,  240,  197,
  121,   19,   88,  149,  122,  157,  135,   19,  103,  241,
  242,  136,  158,  112,  173,  224,  138,  172,  223,  152,
  113,   12,   94,   68,  126,   60,   98,   99,   59,  127,
   61,   20,  166,  167,   20,   17,   18,   38,   98,  128,
  115,   97,   90,  193,  129,  171,   20,   20,  150,  146,
  147,  179,  181,  253,  154,   43,  161,  169,  183,  185,
   20,  168,  170,  174,  186,    8,    9,    6,    7,  175,
  137,   60,  190,   20,   59,  191,   61,  198,  199,  200,
  217,  247,  227,  228,  231,  232,   20,    1,  237,  204,
  236,  249,  202,    5,  254,  133,  256,  134,  258,   20,
    5,   99,  111,  137,  141,   95,   12,  142,  140,   19,
  138,   91,  142,  144,  143,    0,    0,  206,    0,  205,
    0,    0,    0,   48,   92,   92,    0,   92,  156,   92,
  206,    0,   77,   92,   92,   92,   92,   92,    0,   92,
  238,   92,    0,  206,  177,    0,    0,   78,  122,   74,
   80,   92,   92,   92,   92,   84,  101,   59,  226,  104,
  244,    7,   48,  106,  187,   73,   74,   73,    8,    9,
   49,   73,  108,   10,   11,   12,   13,   14,   15,   16,
   17,   18,   17,   18,  239,   17,   18,   17,   18,   47,
   47,   17,   18,    7,  201,  120,    8,    9,    6,    7,
    8,    9,   49,   73,  250,   10,   11,   12,   13,   14,
   15,   16,   17,   18,    7,   73,  118,  119,  120,   71,
   93,    8,    9,   17,   18,  148,   10,   11,   12,   13,
   14,   15,   16,   17,   18,   17,   18,  115,   12,   96,
   56,   57,   58,   59,   20,   12,   12,   59,  115,  115,
   12,  162,   12,   12,   12,   12,   12,  122,    8,    9,
  212,   17,   18,   10,  162,   12,   13,   14,   15,   16,
  252,    8,    9,   43,   43,  229,   10,  162,   12,   13,
   14,   15,   16,    0,    8,    9,   56,   57,   58,   10,
  162,   12,   13,   14,   15,   16,   63,    8,    9,  110,
   77,  119,   10,  162,   12,   13,   14,   15,   16,    0,
    8,    9,  139,  140,  141,   10,  162,   12,   13,   14,
   15,   16,  163,    8,    9,  155,    0,   75,   10,   77,
   12,   13,   14,   15,   16,   11,  115,  117,   92,   62,
   62,   17,   18,   62,   60,   82,   74,   59,   92,   61,
   72,   62,   92,   92,   92,   78,   70,   78,   92,   78,
  118,  119,  120,   79,    0,   79,  147,   79,  182,   56,
   57,   58,    0,   78,   78,   78,   78,    0,    0,   62,
   62,   79,   79,   79,   79,   80,    0,   80,    0,   80,
   62,   62,   62,   25,    0,    0,   25,   25,    0,   62,
    0,   98,    0,   80,   80,   80,   80,   60,    0,    0,
   59,    0,   61,   25,   92,   60,  165,    0,   59,    0,
   61,    0,   25,    0,    0,  142,  144,  143,    0,   60,
    0,    0,   59,  189,   61,   60,    0,    0,   59,   60,
   61,    0,   59,   23,   61,    0,   23,   23,    0,  211,
  213,    0,  214,   62,  184,   56,   57,   58,    0,   56,
   57,   58,  222,   89,   62,   62,   62,   62,    0,  118,
  119,  120,   23,    0,  230,    0,   62,  142,  144,  143,
   92,    0,    0,    0,    0,    0,    0,    0,    0,  115,
   25,    0,    0,    0,    0,    0,    0,    0,  119,    0,
    0,    0,    0,  248,    0,    0,  233,  235,    0,  119,
  119,  255,    0,  257,    0,  259,    0,    0,  260,   51,
  261,    0,  243,   51,   75,    0,    0,    0,    0,    0,
    0,    0,   62,    0,    0,    0,    0,    0,    0,    0,
   23,    0,    0,    0,    0,    0,    0,   72,    0,   62,
   62,    0,    0,   70,    0,    0,    0,    0,  116,   56,
   57,   58,   51,  147,    0,   62,    0,    0,    0,    0,
   78,    0,    0,    0,   78,   78,   78,    0,   79,    0,
   78,    0,   79,   79,   79,    0,   51,   51,   79,    0,
    0,    0,    0,    0,    0,    0,    0,   25,   92,    0,
   80,    0,    0,    0,   80,   80,   80,    0,    0,    0,
   80,    0,    0,  164,   96,    0,   92,    0,    0,    0,
    0,    0,   56,   57,   58,  139,  140,  141,    0,  178,
   56,   57,   58,    0,    0,    0,    0,    0,    0,  176,
    0,    0,    0,  180,   56,   57,   58,  225,    0,    0,
   56,   57,   58,    0,  114,   57,   58,    0,    0,    0,
    0,    0,    0,  192,  194,    0,  195,    0,    0,    0,
    0,    0,    0,    0,  218,   51,    0,  139,  140,  141,
    0,    0,    0,    0,   51,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  216,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   51,
};
short yycheck[] = {                                      41,
    0,    0,    0,    0,   40,   43,   40,   45,   44,   40,
   59,   40,   59,  123,   41,   40,   11,   44,   59,   59,
  123,  125,   59,    5,    6,  256,   59,   50,   20,   58,
   41,   58,  199,   22,  256,   59,   40,   43,   40,   45,
   44,  257,   59,   60,   61,  276,  277,   41,   41,   31,
   40,  218,   75,  258,  276,  277,   40,   40,  256,  264,
   41,   44,  125,   41,   45,  257,   42,   44,   59,  267,
  268,   47,  264,  125,   41,   41,   68,   44,   44,   74,
  125,   40,   59,   40,  257,   42,   44,  123,   45,   58,
   47,   44,  256,  257,   40,  276,  277,   58,   59,   41,
   59,   59,   91,   58,   40,  122,   59,   40,  257,   41,
   41,  133,  134,   41,   58,   58,   41,   99,  135,  136,
   40,  125,  125,   41,  266,  125,  125,  125,  125,   44,
   41,   42,  266,   40,   45,   41,   47,  258,   59,  266,
  258,   41,  268,  268,  268,  268,   40,  257,  268,  172,
   59,   41,  256,  256,  268,   43,   41,   45,   41,   40,
    0,   41,   59,   59,   59,   26,  125,   59,   59,   44,
   59,   23,   60,   61,   62,   -1,   -1,  123,   -1,  175,
   -1,   -1,   -1,   41,   42,   43,   -1,   45,   59,   47,
  123,   -1,   59,   41,   42,   43,   44,   45,   -1,   47,
  223,   59,   -1,  123,   41,   -1,   -1,  256,   45,   59,
  257,   59,   60,   61,   62,  256,  256,   45,  125,  256,
  258,  257,  256,  256,  266,  256,  257,  256,  264,  265,
  264,  256,  256,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  276,  277,  125,  276,  277,  276,  277,  276,
  277,  276,  277,  257,  256,  266,  256,  256,  256,  256,
  264,  265,  264,  256,  258,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  257,  256,  257,  258,  259,  263,
  257,  264,  265,  276,  277,  263,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  276,  277,  256,  257,  257,
  257,  258,  259,   45,  257,  264,  265,   45,  267,  268,
  269,  257,  271,  272,  273,  274,  275,   45,  264,  265,
  266,  276,  277,  269,  257,  271,  272,  273,  274,  275,
  258,  264,  265,  276,  277,  268,  269,  257,  271,  272,
  273,  274,  275,   -1,  264,  265,  257,  258,  259,  269,
  257,  271,  272,  273,  274,  275,    8,  264,  265,  256,
   12,   59,  269,  257,  271,  272,  273,  274,  275,   -1,
  264,  265,  260,  261,  262,  269,  257,  271,  272,  273,
  274,  275,  257,  264,  265,  256,   -1,   59,  269,  256,
  271,  272,  273,  274,  275,  270,   48,   49,  256,    8,
    9,  276,  277,   12,   42,   14,  256,   45,  256,   47,
   59,   20,  260,  261,  262,   41,   59,   43,  266,   45,
  257,  258,  259,   41,   -1,   43,   59,   45,  256,  257,
  258,  259,   -1,   59,   60,   61,   62,   -1,   -1,   48,
   49,   59,   60,   61,   62,   41,   -1,   43,   -1,   45,
   59,   60,   61,    2,   -1,   -1,    5,    6,   -1,   68,
   -1,   44,   -1,   59,   60,   61,   62,   42,   -1,   -1,
   45,   -1,   47,   22,   23,   42,   59,   -1,   45,   -1,
   47,   -1,   31,   -1,   -1,   60,   61,   62,   -1,   42,
   -1,   -1,   45,  145,   47,   42,   -1,   -1,   45,   42,
   47,   -1,   45,    2,   47,   -1,    5,    6,   -1,  187,
  188,   -1,  190,  122,  256,  257,  258,  259,   -1,  257,
  258,  259,  200,   22,  133,  134,  135,  136,   -1,  257,
  258,  259,   31,   -1,  212,   -1,  145,   60,   61,   62,
   89,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  201,
   99,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,
   -1,   -1,   -1,  241,   -1,   -1,  218,  219,   -1,  267,
  268,  249,   -1,  251,   -1,  253,   -1,   -1,  256,    7,
  258,   -1,  234,   11,  256,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  201,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   99,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  218,
  219,   -1,   -1,  256,   -1,   -1,   -1,   -1,  256,  257,
  258,  259,   50,  256,   -1,  234,   -1,   -1,   -1,   -1,
  256,   -1,   -1,   -1,  260,  261,  262,   -1,  256,   -1,
  266,   -1,  260,  261,  262,   -1,   74,   75,  266,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  206,  207,   -1,
  256,   -1,   -1,   -1,  260,  261,  262,   -1,   -1,   -1,
  266,   -1,   -1,  256,  257,   -1,  225,   -1,   -1,   -1,
   -1,   -1,  257,  258,  259,  260,  261,  262,   -1,  256,
  257,  258,  259,   -1,   -1,   -1,   -1,   -1,   -1,  127,
   -1,   -1,   -1,  256,  257,  258,  259,  206,   -1,   -1,
  257,  258,  259,   -1,  257,  258,  259,   -1,   -1,   -1,
   -1,   -1,   -1,  151,  152,   -1,  154,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  257,  163,   -1,  260,  261,  262,
   -1,   -1,   -1,   -1,  172,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  193,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  223,
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
"parametros_reales : factor_invocacion",
"parametros_reales : factor_invocacion ',' factor_invocacion",
"factor_invocacion : ID",
"factor_invocacion : CTE_FLOTANTE",
"factor_invocacion : CTE_INT",
"factor_invocacion : '-' factor",
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
#line 261 "gramatica.y"

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

#line 579 "y.tab.c"
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
case 14:
#line 36 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 17:
#line 41 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 18:
#line 42 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
break;
case 19:
#line 43 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
break;
case 20:
#line 46 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 21:
#line 47 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 23:
#line 51 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 24:
#line 52 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 25:
#line 53 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 26:
#line 56 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 28:
#line 60 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 29:
#line 61 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 30:
#line 62 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
break;
case 33:
#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 34:
#line 70 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 35:
#line 71 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 36:
#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 37:
#line 73 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 42:
#line 82 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 43:
#line 83 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 44:
#line 84 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
#line 91 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 48:
#line 92 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 49:
#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 50:
#line 96 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 57:
#line 105 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 58:
#line 106 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 60:
#line 110 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 61:
#line 111 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 62:
#line 112 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 63:
#line 113 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 64:
#line 114 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 65:
#line 115 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 66:
#line 116 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 67:
#line 117 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 68:
#line 118 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 69:
#line 119 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 73:
#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 74:
#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 77:
#line 135 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 79:
#line 139 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 80:
#line 140 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 82:
#line 144 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 83:
#line 145 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 84:
#line 149 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 85:
#line 150 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 88:
#line 155 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 89:
#line 156 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 90:
#line 157 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 91:
#line 158 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 92:
#line 162 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 93:
#line 163 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 94:
#line 164 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 97:
#line 169 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);}
break;
case 101:
#line 183 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 102:
#line 184 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 103:
#line 185 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 105:
#line 190 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 106:
#line 191 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 108:
#line 195 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 109:
#line 196 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
break;
case 110:
#line 197 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
break;
case 111:
#line 198 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
break;
case 112:
#line 199 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
break;
case 113:
#line 200 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
break;
case 114:
#line 201 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 118:
#line 210 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
break;
case 119:
#line 211 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
break;
case 127:
#line 225 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 128:
#line 226 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 130:
#line 230 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 131:
#line 231 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 132:
#line 232 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 135:
#line 238 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
break;
case 136:
#line 239 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
break;
case 137:
#line 240 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
break;
case 140:
#line 247 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
break;
case 141:
#line 248 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
break;
case 142:
#line 249 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}
break;
case 143:
#line 252 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 145:
#line 256 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 146:
#line 257 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
break;
case 147:
#line 258 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
#line 1087 "y.tab.c"
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
