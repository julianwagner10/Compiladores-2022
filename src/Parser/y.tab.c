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
    0,    0,    2,    2,    2,    1,    1,    1,    4,    3,
    3,    7,    7,    7,    7,    5,    5,    5,   12,   12,
   12,   10,   10,   10,   13,   13,   13,   11,   11,   15,
   15,   15,   14,   14,   17,   17,   17,   17,   17,   16,
   16,   16,   16,   19,   19,   19,   18,   18,   20,   20,
    9,    9,    6,    6,    6,    6,    6,    6,    6,   27,
   27,   27,   27,   27,   27,   27,   27,    8,    8,    8,
    8,    8,   28,   28,   21,   21,   21,   30,   30,   30,
   30,   30,   24,   24,   31,   29,   29,   29,   29,   33,
   33,   32,   32,   32,   32,   35,   35,   35,   35,   34,
   34,   34,   34,   34,   22,   22,   22,   37,   37,   36,
   36,   36,   39,   38,   38,   38,   38,   23,   23,   23,
   42,   42,   42,   42,   42,   42,   42,   41,   41,   41,
   41,   43,   43,   40,   44,   44,   44,   44,   44,   44,
   25,   25,   25,   47,   47,   47,   45,   45,   48,   48,
   48,   46,   46,   49,   49,   49,   26,   26,   50,   50,
   50,
};
short yylen[] = {                                         2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    1,    2,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    2,    3,    2,    2,    2,    4,
    3,    1,    2,    2,    3,    3,    1,    3,    3,    3,
    2,    2,    2,    1,    1,    1,    3,    3,    1,    3,
    3,    3,    3,    1,    1,    3,    3,    2,    2,    1,
    1,    1,    1,    2,    4,    3,    1,    4,    3,    1,
    3,    1,    2,    1,    1,    1,    2,    7,    9,    1,
    6,    6,    6,    6,    6,    6,    7,    1,    1,    3,
    1,    2,    2,    3,    1,    1,    1,    1,    1,    1,
   10,   10,    1,    9,    9,    9,    3,    1,    2,    2,
    2,    3,    1,    2,    2,    2,    4,    1,    3,    3,
    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    6,    8,   10,   11,    0,    0,   17,   18,   24,    0,
   29,   34,    0,    0,    0,    0,    0,    0,   59,   77,
   84,  107,  120,  143,  158,    0,    0,    0,    0,    0,
    0,    0,    0,   43,   48,    0,  102,  101,    0,    0,
    0,  103,   82,    0,    0,   89,   94,   95,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   65,
    0,    0,   26,    0,    3,    7,   22,   21,    0,   25,
   20,    0,    0,    0,   60,   53,   67,   61,   55,   64,
   56,   62,   57,   63,   58,    4,    1,    0,   79,    0,
   80,   76,    0,    0,  114,  116,  115,    0,    0,    0,
    0,    0,  112,   47,    0,   44,    0,  104,   98,   99,
    0,    0,    0,    0,    0,    0,  139,  138,  140,  135,
  136,  137,    0,    0,  159,    0,  160,   50,    0,    0,
   40,    0,   66,   54,    0,    0,    0,  148,    0,   19,
   16,   27,   23,   32,    0,   30,  117,    0,   41,  108,
  105,    0,  113,   35,  109,  106,   90,    0,   91,    0,
   96,   92,   97,   93,    0,    0,    0,    0,    0,  157,
   37,    0,   38,   36,  150,    0,  149,    0,    0,   31,
   28,    0,  111,    0,    0,    0,    0,    0,    0,    0,
    0,   72,    0,  131,    0,    0,    0,    0,   39,   33,
  147,    0,    0,    0,  153,    0,    0,   42,    0,    0,
   73,   68,   74,   69,    0,   12,    0,   13,  132,   14,
   15,  123,  124,  126,    0,  125,  122,    0,    0,    0,
    0,  121,    0,   71,    0,  130,  127,    0,  118,    0,
    0,    0,    0,   46,   70,    0,    0,    0,    0,    0,
    0,  119,  144,    0,  146,    0,  145,  141,  142,
};
short yydgoto[] = {                                       3,
   20,    4,   21,   22,   23,  209,  210,  211,   25,   26,
   27,   28,   29,   30,   31,   52,   32,   53,   54,   55,
   33,   34,   35,   36,   37,   38,   39,  212,   70,   40,
   41,   65,   66,   67,   68,  121,   42,  122,  123,   71,
  213,   43,  214,  143,  157,  224,   44,  158,  225,   45,
};
short yysindex[] = {                                   -102,
  -99,   47,    0,    0,   47,   47,    0,  100,   51,  563,
  -27,  -24,  592,   73,   17,    0,    0, -219,  592,   62,
    0,    0,    0,    0,   18,   57,    0,    0,    0,  -26,
    0,    0,  -44,   -5,  -39,  -31,   44,   59,    0,    0,
    0,    0,    0,    0,    0,   77,   98,  397,  337,   29,
 -193,   23,   66,    0,    0,   45,    0,    0,  320,  320,
  320,    0,    0,   90,   19,    0,    0,    0,  102,  451,
   88,  105,  -34, -186,  -21,  -19,   56,   90,   45,    0,
  110, -232,    0,  117,    0,    0,    0,    0,  162,    0,
    0, -162,    3,  116,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   45,    0,   90,
    0,    0,   90, -186,    0,    0,    0,    0,  391,   31,
   22,   86,    0,    0, -157,    0,  360,    0,    0,    0,
  579,  588,  209,  384, -125,  -38,    0,    0,    0,    0,
    0,    0,  592, -107,    0,  122,    0,    0, -157,  -50,
    0, -157,    0,    0, -235,  -94,  106,    0, -100,    0,
    0,    0,    0,    0,   25,    0,    0, -166,    0,    0,
    0,  391,    0,    0,    0,    0,    0,   19,    0,   19,
    0,    0,    0,    0,  226,  226,  184,   90,  226,    0,
    0, -164,    0,    0,    0,  -90,    0,  459,  226,    0,
    0,  104,    0,    5,  112,  114,  -47,  297,    0,  253,
    0,    0,  -97,    0,  -96,  206,  -93,  -88,    0,    0,
    0,  567,  592,  115,    0,  -87, -166,    0,   51,  -92,
    0,    0,    0,    0,  -85,    0,  273,    0,    0,    0,
    0,    0,    0,    0, -141,    0,    0,   90,  592,   90,
   13,    0,  142,    0,  125,    0,    0,  226,    0,   90,
  144,    7,   12,    0,    0,  -80,  226,  148,  226,  149,
  226,    0,    0,  226,    0,  226,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,   95,    0,    0,
    0,    0,  127,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  192,    0,    0,    0,
  -14,    0,    0,    0,    0,  540,    0,    0,    0,    0,
    0,    0,    0,  135,  443,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  138,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   41,    0,  141,
    0,    0,  190,  134,    0,    0,    0,   94,    0,   15,
    0,   27,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  350,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  490,    0,  514,
    0,    0,    0,    0,    0,    0,    0,  -32,    0,    0,
    0,    0,    0,    0,    0,  136,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  139,    0,
  159,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  132,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  137,  145,  146,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  152,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   74,    0,  494,    0,    0,  415,   -1, -132,  639,  176,
    0,    0,    0,    0,    0,   14,    0,  -17,    0,    0,
    0,   -9,    0,    0,  128,    0,    0,    0,   -7,    0,
    0,   30,    0,  -25,    0,    0,    0,  -73,    0,   -2,
  471,    0,    0, -167,    0,    0,    0,    0,    0,    0,
};
#define YYTABLESIZE 866
short yytable[] = {                                      62,
   62,   64,  187,   62,   81,   78,  147,  192,  134,   62,
  235,  234,   73,   19,   96,   76,   84,   18,   76,   99,
    2,  151,  195,    6,  155,   77,   49,  101,  196,   49,
  223,  156,  120,  128,  129,  130,  149,   83,   62,   62,
  110,  113,   19,   49,  127,  167,   18,  269,  173,   62,
   62,   62,  271,   97,  249,  262,   82,  263,  120,   62,
  133,   18,  171,  124,   19,  134,  136,  110,   18,  118,
  148,  169,   45,  119,  168,  238,   88,  241,   46,   47,
  125,   50,  100,  100,  127,  100,   19,  100,  150,   74,
   18,  219,   60,  162,  163,   59,   93,   61,  203,  100,
   92,   19,  103,   94,  241,   18,  126,  182,  184,   16,
   17,   16,   17,  152,  257,   91,   19,  105,   16,   17,
   18,   62,   62,   62,   62,  258,  259,  164,  144,  172,
  119,   80,  131,   62,  132,  188,   63,   19,   22,   50,
  185,   18,  135,   60,  228,  145,   59,  227,   61,  201,
  202,   40,  106,   22,    1,   19,    5,  159,  189,   18,
  178,  180,  190,  197,  198,  199,  165,  221,  154,  230,
  242,  243,  232,  251,  246,  109,  112,  255,   12,  247,
  252,   15,  264,  265,  267,   85,   85,  272,  274,  276,
  133,    5,  109,   81,  151,  155,   83,  128,   13,   78,
   89,  106,    0,  156,  154,   92,  237,    0,  233,  253,
  152,   95,   62,   62,  248,  250,   98,  129,    0,   62,
  161,  110,  107,   19,  100,   16,   17,  186,  146,    7,
    8,   74,   75,  134,   74,   72,   74,    9,   10,   62,
  166,  260,   11,   12,   13,   19,   14,   15,   75,   16,
   17,   16,   17,   59,   16,   17,   16,   17,    7,    8,
  229,   49,   49,   12,  268,   19,    9,   10,   49,  270,
  261,   11,   12,   13,   87,   14,   15,  170,   16,   17,
  200,    8,  110,   13,  114,  115,  116,  117,    9,   10,
   45,   45,   19,   11,   12,   13,  100,   14,   15,  102,
   16,   17,    7,    8,   16,   17,  208,   56,   57,   58,
    9,   10,   19,   90,  104,   11,   12,   13,    8,   14,
   15,    0,   16,   17,   15,    9,   10,    0,  208,   79,
   11,   12,   13,    8,   14,   15,   19,   16,   17,    0,
    9,   10,  115,  116,  117,   11,   12,   13,  208,   14,
   15,   22,   16,   17,    8,   48,  109,  254,   56,   57,
   58,    9,   10,   49,   59,  153,   11,   12,   13,  231,
   14,   15,    8,   16,   17,   16,   17,  239,   60,    9,
   10,   59,   85,   61,   11,   12,   13,  133,   14,   15,
   81,   16,   17,   83,  128,   12,   78,  256,  133,  133,
  176,   12,   12,   12,  119,  128,  128,   12,  161,   12,
   12,   12,   12,   12,  129,   13,   24,  160,   90,   24,
   24,   13,   13,   13,    0,  129,  129,   13,   59,   13,
   13,   13,   13,   13,   24,  119,    0,    0,   60,    0,
  204,   59,    0,   61,   24,   75,  205,    9,   10,  216,
    0,    0,   11,    0,   13,  206,   14,   15,  207,    0,
   24,   24,  204,    0,  181,   56,   57,   58,  205,    9,
   10,    0,    0,  244,   11,    0,   13,  206,   14,   15,
  207,    0,  204,   86,    0,   86,    0,   86,  205,    9,
   10,    0,    0,  131,   11,  132,   13,  206,   14,   15,
  207,   86,   86,   86,   86,    0,    0,   24,   24,  204,
  140,  142,  141,   86,    0,  205,    9,   10,  140,  142,
  141,   11,    0,   13,  206,   14,   15,  207,    0,  204,
   87,    0,   87,    0,   87,  205,    9,   10,    0,   86,
   86,   11,    0,   13,  206,   14,   15,  207,   87,   87,
   87,   87,    0,  204,   88,    0,   88,    0,   88,  205,
    9,   10,    0,    0,    0,   11,    0,   13,  206,   14,
   15,  207,   88,   88,   88,   88,   56,   57,   58,   24,
  100,  100,  100,    0,  100,    0,  100,   86,    0,    0,
    0,    0,  111,   56,   57,   58,    0,    0,  100,  100,
  100,  100,   69,    0,   60,  161,    0,   59,   60,   61,
   15,   59,    0,   61,    0,  175,  115,  116,  117,    0,
   60,    0,  236,   59,  240,   61,  140,  142,  141,   60,
    0,    0,   59,   60,   61,    0,   59,    0,   61,  183,
   56,   57,   58,    0,    0,    0,   51,  115,  116,  117,
   51,  240,    0,  108,   57,   58,  215,  217,   86,  218,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  226,
   15,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  245,    0,   51,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   86,    0,
    0,    0,   86,   86,   86,    0,    0,    0,   86,    0,
  137,  138,  139,   51,   51,  222,    0,    0,  137,  138,
  139,    0,    0,    0,    0,    0,    0,    0,  266,    0,
    0,    0,    0,    0,    0,    0,    0,  273,    0,  275,
    0,  277,    0,    0,  278,   87,  279,    0,    0,   87,
   87,   87,    0,    0,    0,   87,    0,    0,    0,    0,
    0,    0,    0,  174,    0,    0,    0,    0,    0,   88,
    0,    0,    0,   88,   88,   88,    0,    0,    0,   88,
    0,    0,    0,    0,    0,    0,    0,  191,  193,    0,
  194,    0,    0,    0,    0,  100,    0,    0,    0,  100,
  100,  100,    0,    0,    0,  100,   51,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   56,
   57,   58,    0,   56,   57,   58,  137,  138,  139,    0,
  220,    0,    0,    0,  177,   56,   57,   58,    0,    0,
    0,    0,    0,  179,   56,   57,   58,    0,   56,   57,
   58,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   51,
};
short yycheck[] = {                                       9,
   10,    9,   41,   13,   14,   13,   41,   58,   41,   19,
   58,   59,   40,   40,   59,   40,   19,   44,   40,   59,
  123,   41,  258,  123,  257,   12,   41,   59,  264,   44,
  198,  264,   50,   59,   60,   61,   58,  257,   48,   49,
   48,   49,   40,   58,   40,  119,   44,   41,  122,   59,
   60,   61,   41,   59,  222,   43,   40,   45,   76,   69,
   42,   44,   41,  257,   40,   47,   69,   41,   44,   41,
  257,   41,   58,   45,   44,  208,   59,  210,    5,    6,
   58,   41,   42,   43,   40,   45,   40,   47,   75,  256,
   44,  256,   42,  256,  257,   45,  123,   47,  172,   59,
   44,   40,   59,   30,  237,   44,   41,  133,  134,  276,
  277,  276,  277,   58,  256,   59,   40,   59,  276,  277,
   44,  131,  132,  133,  134,  267,  268,  125,   41,   44,
   45,   59,   43,  143,   45,  143,    9,   40,   44,   40,
  266,   44,   41,   42,   41,   41,   45,   44,   47,  125,
  168,   58,   59,   59,  257,   40,  256,   41,  266,   44,
  131,  132,   41,  258,   59,  266,   93,  258,   59,   58,
  268,  268,   59,   59,  268,   48,   49,  263,   40,  268,
  268,  274,   41,   59,   41,   59,  125,  268,   41,   41,
   59,    0,   59,   59,   59,   59,   59,   59,   40,   59,
   25,  125,   -1,   59,   59,   44,  208,   -1,  256,  227,
   59,  256,  222,  223,  222,  223,  256,   59,   -1,  229,
   59,  229,  125,   40,  256,  276,  277,  266,  263,  256,
  257,  256,  257,  266,  256,  263,  256,  264,  265,  249,
  125,  249,  269,  270,  271,   40,  273,  274,   59,  276,
  277,  276,  277,   45,  276,  277,  276,  277,  256,  257,
  256,  276,  277,  125,  258,   40,  264,  265,  264,  258,
  258,  269,  270,  271,  257,  273,  274,  256,  276,  277,
  256,  257,  256,  125,  256,  257,  258,  259,  264,  265,
  276,  277,   40,  269,  270,  271,  256,  273,  274,  256,
  276,  277,  256,  257,  276,  277,  123,  257,  258,  259,
  264,  265,   40,  257,  256,  269,  270,  271,  257,  273,
  274,   -1,  276,  277,  274,  264,  265,   -1,  123,  257,
  269,  270,  271,  257,  273,  274,   40,  276,  277,   -1,
  264,  265,  257,  258,  259,  269,  270,  271,  123,  273,
  274,  257,  276,  277,  257,  256,  229,  230,  257,  258,
  259,  264,  265,  264,   45,  256,  269,  270,  271,  256,
  273,  274,  257,  276,  277,  276,  277,  125,   42,  264,
  265,   45,  256,   47,  269,  270,  271,  256,  273,  274,
  256,  276,  277,  256,  256,  257,  256,  125,  267,  268,
   41,  263,  264,  265,   45,  267,  268,  269,   59,  271,
  272,  273,  274,  275,  256,  257,    2,  256,  257,    5,
    6,  263,  264,  265,   -1,  267,  268,  269,   45,  271,
  272,  273,  274,  275,   20,   45,   -1,   -1,   42,   -1,
  257,   45,   -1,   47,   30,  256,  263,  264,  265,  266,
   -1,   -1,  269,   -1,  271,  272,  273,  274,  275,   -1,
   46,   47,  257,   -1,  256,  257,  258,  259,  263,  264,
  265,   -1,   -1,  268,  269,   -1,  271,  272,  273,  274,
  275,   -1,  257,   41,   -1,   43,   -1,   45,  263,  264,
  265,   -1,   -1,   43,  269,   45,  271,  272,  273,  274,
  275,   59,   60,   61,   62,   -1,   -1,   93,   94,  257,
   60,   61,   62,   20,   -1,  263,  264,  265,   60,   61,
   62,  269,   -1,  271,  272,  273,  274,  275,   -1,  257,
   41,   -1,   43,   -1,   45,  263,  264,  265,   -1,   46,
   47,  269,   -1,  271,  272,  273,  274,  275,   59,   60,
   61,   62,   -1,  257,   41,   -1,   43,   -1,   45,  263,
  264,  265,   -1,   -1,   -1,  269,   -1,  271,  272,  273,
  274,  275,   59,   60,   61,   62,  257,  258,  259,  165,
   41,   42,   43,   -1,   45,   -1,   47,   94,   -1,   -1,
   -1,   -1,  256,  257,  258,  259,   -1,   -1,   59,   60,
   61,   62,   40,   -1,   42,  256,   -1,   45,   42,   47,
  274,   45,   -1,   47,   -1,  256,  257,  258,  259,   -1,
   42,   -1,  208,   45,  210,   47,   60,   61,   62,   42,
   -1,   -1,   45,   42,   47,   -1,   45,   -1,   47,  256,
  257,  258,  259,   -1,   -1,   -1,    8,  257,  258,  259,
   12,  237,   -1,  257,  258,  259,  186,  187,  165,  189,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  199,
  274,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  216,   -1,   50,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,
   -1,   -1,  260,  261,  262,   -1,   -1,   -1,  266,   -1,
  260,  261,  262,   75,   76,  257,   -1,   -1,  260,  261,
  262,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  258,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  267,   -1,  269,
   -1,  271,   -1,   -1,  274,  256,  276,   -1,   -1,  260,
  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  125,   -1,   -1,   -1,   -1,   -1,  256,
   -1,   -1,   -1,  260,  261,  262,   -1,   -1,   -1,  266,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  149,  150,   -1,
  152,   -1,   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,
  261,  262,   -1,   -1,   -1,  266,  168,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,
  258,  259,   -1,  257,  258,  259,  260,  261,  262,   -1,
  192,   -1,   -1,   -1,  256,  257,  258,  259,   -1,   -1,
   -1,   -1,   -1,  256,  257,  258,  259,   -1,  257,  258,
  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  227,
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
"ejecucion_control : CONTINUE ':' CADENA ';'",
"ejecucion_control : CADENA ':' control",
"ejecucion_control : error_ejecucion_control",
"error_ejecucion_control : BREAK error",
"error_ejecucion_control : CONTINUE error",
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
"bloque_if_for : ejecucion_control",
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
#line 293 "gramatica.y"

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

#line 614 "y.tab.c"
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
case 9:
#line 26 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " no es una sentencia declarativa o ejecutable valida");}
break;
case 16:
#line 52 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
#line 57 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
#line 58 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
break;
case 21:
#line 59 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
break;
case 22:
#line 62 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 23:
#line 63 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 25:
#line 67 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
#line 68 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
#line 72 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
#line 76 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 31:
#line 77 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 32:
#line 78 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
break;
case 35:
#line 85 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 36:
#line 86 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 37:
#line 87 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 38:
#line 88 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 39:
#line 89 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 44:
#line 98 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
#line 99 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
#line 100 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
#line 107 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
#line 108 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
#line 111 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
#line 112 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 60:
#line 124 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 61:
#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 62:
#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 63:
#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 64:
#line 128 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 65:
#line 129 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 66:
#line 130 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 67:
#line 131 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 68:
#line 134 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 69:
#line 135 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 70:
#line 136 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta " +yyvsp[-1].sval);}
break;
case 73:
#line 141 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 74:
#line 142 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 78:
#line 152 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 79:
#line 153 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 80:
#line 154 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 81:
#line 155 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 82:
#line 156 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 85:
#line 164 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 87:
#line 168 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 88:
#line 169 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 90:
#line 173 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 91:
#line 174 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 92:
#line 177 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 93:
#line 178 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 96:
#line 183 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 97:
#line 184 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 98:
#line 185 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 99:
#line 186 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 100:
#line 189 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 101:
#line 190 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 102:
#line 191 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 103:
#line 192 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 105:
#line 196 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);}
break;
case 108:
#line 201 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 109:
#line 203 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 113:
#line 212 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 114:
#line 215 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 115:
#line 216 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 116:
#line 217 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 118:
#line 221 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 119:
#line 222 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 121:
#line 226 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 122:
#line 227 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
break;
case 123:
#line 228 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
break;
case 124:
#line 229 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
break;
case 125:
#line 230 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
break;
case 126:
#line 231 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
break;
case 127:
#line 232 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 132:
#line 241 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
break;
case 133:
#line 242 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
break;
case 141:
#line 256 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 142:
#line 257 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 144:
#line 261 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 145:
#line 262 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 146:
#line 263 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 149:
#line 270 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
break;
case 150:
#line 271 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
break;
case 151:
#line 272 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
break;
case 154:
#line 279 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
break;
case 155:
#line 280 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
break;
case 156:
#line 281 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}
break;
case 157:
#line 284 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 159:
#line 288 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 160:
#line 289 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
break;
case 161:
#line 290 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
#line 1138 "y.tab.c"
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
