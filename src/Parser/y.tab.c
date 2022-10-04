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
   32,   31,   31,   31,   31,   31,   20,   20,   20,   34,
   34,   33,   33,   33,   36,   35,   35,   35,   35,   21,
   21,   21,   39,   39,   39,   39,   39,   39,   39,   38,
   38,   38,   40,   40,   37,   41,   41,   41,   41,   41,
   41,   23,   23,   23,   44,   44,   44,   42,   42,   45,
   45,   45,   43,   43,   46,   46,   46,   24,   24,   47,
   47,   47,
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
    2,    1,    1,    1,    1,    2,    4,    3,    1,    4,
    3,    1,    3,    1,    2,    1,    1,    1,    2,    7,
    9,    1,    6,    6,    6,    6,    6,    6,    7,    1,
    3,    1,    2,    2,    3,    1,    1,    1,    1,    1,
    1,   10,   10,    1,    9,    9,    9,    3,    1,    2,
    2,    2,    3,    1,    2,    2,    2,    4,    1,    3,
    3,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   50,   49,    0,    0,
    0,    0,    0,   10,   12,    0,    0,   15,   16,   22,
    0,   27,   32,    0,    0,    0,    0,    0,    0,   59,
   71,   76,   99,  112,  134,  149,    0,    0,    0,    0,
    0,    0,    0,    0,   41,   46,    0,   94,   93,    0,
    0,    0,   95,    0,    0,   81,   86,   87,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   64,   57,
    0,   67,    0,    0,   66,   58,   24,    0,    3,    0,
   11,    0,   13,   20,   19,    0,   23,   18,    0,    0,
    0,   60,   51,   69,   61,   53,   65,   54,   62,   55,
   63,   56,    4,    1,    0,    0,   73,    0,    0,  106,
  108,  107,    0,    0,    0,    0,    0,  104,   45,    0,
   42,    0,   96,   90,   91,    0,    0,    0,    0,    0,
    0,  130,  129,  131,  126,  127,  128,    0,    0,  150,
    0,  151,   48,    0,    0,   38,    0,   68,   52,    0,
    0,    0,  139,    0,    0,    0,   17,   14,   25,   21,
   30,    0,   28,  109,    0,   39,  100,   97,    0,  105,
   33,  101,   98,   82,    0,   83,    0,   88,   84,   89,
   85,    0,    0,    0,    0,    0,  148,   35,    0,   36,
   34,  141,    0,  140,    0,    0,    0,   29,   26,    0,
  103,    0,    0,    0,    0,  122,    0,    0,    0,    0,
   37,   31,  138,    0,    0,    0,  144,    0,    0,   40,
    0,  123,  115,  116,  118,    0,  117,  114,    0,    0,
    0,    0,  113,    0,  121,  119,    0,  110,    0,    0,
    0,    0,   44,    0,    0,    0,    0,    0,    0,  111,
  135,    0,  137,    0,  136,  132,  133,
};
short yydgoto[] = {                                       3,
   21,    4,   22,  213,   24,  214,   26,   27,   28,   29,
   30,   31,   32,   53,   33,   54,   55,   56,   34,   35,
   36,   37,   38,   39,   40,   70,   41,   42,   65,   66,
   67,   68,  126,   43,  127,  128,   71,  215,   44,  216,
  148,  162,  226,   45,  163,  227,   46,
};
short yysindex[] = {                                   -109,
 -106,   18,    0,    0,   18,   18,  -33,  449,   44,   17,
  -30,  449,  -48,  129,   12,  -46,    0,    0, -215,  449,
  -79,   18,   18,    0,    0,   87,  105,    0,    0,    0,
  -35,    0,    0,  -40,   28,  -36,  -32,  -23,  131,    0,
    0,    0,    0,    0,    0,    0,  -62,  -47,  453,  363,
   20, -167,   34,   59,    0,    0,   56,    0,    0,  302,
  302,  302,    0,   38,   13,    0,    0,    0,  164,  113,
   65,   66,   23, -148,  -28,    8,   62,   38,    0,    0,
   56,    0,  134, -219,    0,    0,    0,   69,    0,  107,
    0,  126,    0,    0,    0,  404,    0,    0, -187,   -3,
   11,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   56,   38,    0,   38, -148,    0,
    0,    0,    0,  325,   35,   25,  173,    0,    0, -174,
    0,  277,    0,    0,    0,  434,  438,  255,  286, -142,
  -41,    0,    0,    0,    0,    0,    0,  449, -141,    0,
   91,    0,    0, -174,   58,    0, -174,    0,    0, -236,
 -125,   76,    0, -129,   -1,  -24,    0,    0,    0,    0,
    0, -105,    0,    0, -205,    0,    0,    0,  325,    0,
    0,    0,    0,    0,   13,    0,   13,    0,    0,    0,
    0,   81,   81,   55,   38,   81,    0,    0, -203,    0,
    0,    0, -120,    0,  396,   81,  449,    0,    0,   36,
    0,  107,   94,    0, -128,    0, -127,   68, -126, -124,
    0,    0,    0,  427,  449,   80,    0, -123, -205,    0,
  120,    0,    0,    0,    0, -200,    0,    0,   38,  449,
   38,  -37,    0,  111,    0,    0,   81,    0,   38,  114,
    7,  102,    0, -114,   81,  116,   81,  118,   81,    0,
    0,   81,    0,   81,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,  140,    0,    0,    0,
    0,  348,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    2,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  161,    0,    0,
    0,  -26,    0,    0,    0,    0,  153,    0,    0,    0,
    0,    0,    0,  352,  375,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  369,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    3,
    0,    4,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  460,  374,    0,  403,  103,    0,
    0,    0,   46,    0,   72,    0,   52,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  414,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  140,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  384,    0,  406,    0,    0,    0,
    0,    0,    0,    0,  -10,    0,    0,    0,    0,    0,
    0,    0,  104,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  329,    0,    0,    0,    0,    0,    0,    0,  106,  109,
  110,    0,    0,    0,    0,    0,    0,    0,  112,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   19,    0,  143,  515,   21,   92,  448,  146,    0,    0,
    0,    0,    0,   10,    0,  -22,    0,    0,    0,  392,
    0,    0,    0,    0,    0,  349,    0,    0,  -19,    0,
  -27,    0,    0,    0,  -80,    0,    6,  458,    0,    0,
 -165,    0,    0,    0,    0,    0,    0,
};
#define YYTABLESIZE 727
short yytable[] = {                                     194,
    8,    9,    6,    7,   20,  251,   51,  252,   19,   76,
   80,   76,   86,    2,   47,   76,    6,   47,  103,  209,
   77,  202,  106,   47,   48,   88,  108,  203,  125,  154,
  125,   47,  133,  134,  135,  110,   20,  160,  132,  225,
   19,   87,   91,  174,  161,   89,  180,  257,  156,  101,
   74,   84,  221,  125,  138,  246,   73,   20,  240,  139,
  123,   19,  113,  152,  124,  178,  247,  248,  169,  170,
   17,   18,   17,   18,  141,  176,  230,  114,  175,  229,
  136,   12,  137,   69,  155,   61,  104,  100,   60,  129,
   62,  130,  102,   25,   20,  132,   25,   25,  211,  131,
  120,   17,   18,   38,   98,  149,  150,   20,  153,  164,
  189,  191,   91,   25,   93,  199,  185,  187,  172,  157,
   20,  171,   25,  192,  196,    8,    9,    6,    7,   43,
   19,  197,  204,   20,  205,  173,  206,  223,  242,  233,
  234,  237,  259,  238,  243,   95,   20,    1,   99,    5,
  208,  253,  210,  260,  255,  136,  262,  137,  264,   20,
    5,  101,  142,   98,  146,   92,   12,  147,  145,   19,
  143,   96,  145,  147,  146,    0,    0,  212,    0,    0,
    0,   93,    0,   20,    0,    0,    0,   82,    0,  112,
  212,   25,  159,   92,   92,   92,    0,   92,   20,   92,
    0,    0,    0,  212,  140,   61,  244,   79,   60,   85,
   62,   92,   92,   92,   92,  102,  179,  124,  232,  105,
  250,    7,   49,  107,  193,   74,   75,   74,    8,    9,
   50,   74,  109,   10,   11,   12,   13,   14,   15,   16,
   17,   18,   17,   18,  245,   17,   18,   17,   18,   47,
   47,   17,   18,    7,  207,  125,    8,    9,    6,    7,
    8,    9,   50,   74,  256,   10,   11,   12,   13,   14,
   15,   16,   17,   18,    7,  119,  120,  121,  122,   72,
  177,    8,    9,   17,   18,  151,   10,   11,   12,   13,
   14,   15,   16,   17,   18,   17,   18,  120,   12,   60,
   57,   58,   59,   25,   93,   12,   12,  102,  120,  120,
   12,  165,   12,   12,   12,   12,   12,  183,    8,    9,
  218,  124,   93,   10,  165,   12,   13,   14,   15,   16,
   60,    8,    9,   17,   18,  235,   10,  165,   12,   13,
   14,   15,   16,   94,    8,    9,   60,   43,   43,   10,
  165,   12,   13,   14,   15,   16,   64,    8,    9,  258,
   78,   97,   10,  165,   12,   13,   14,   15,   16,  124,
    8,    9,  142,  143,  144,   10,  165,   12,   13,   14,
   15,   16,  166,    8,    9,   81,  111,  124,   10,  158,
   12,   13,   14,   15,   16,   11,   20,  116,  118,   63,
   63,   17,   18,   63,   61,   83,   77,   60,   92,   62,
   74,   63,   92,   92,   92,   78,    0,   78,   92,   78,
   57,   58,   59,    0,   79,    0,   79,   75,   79,  120,
  121,  122,   72,   78,   78,   78,   78,    0,    0,    0,
   63,   63,   79,   79,   79,   79,   80,   99,   80,    0,
   80,   63,   63,   63,   52,  145,  147,  146,   52,    0,
   63,   70,  168,    0,   80,   80,   80,   80,   61,    0,
    0,   60,  152,   62,    0,   61,    0,    0,   60,   61,
   62,    0,   60,    0,   62,    0,  145,  147,  146,    0,
   61,    0,    0,   60,   61,   62,  195,   60,   52,   62,
   48,   92,   92,    0,   92,    0,   92,    0,    0,    0,
  188,   57,   58,   59,    0,    0,   23,    0,   92,   23,
   23,    0,   52,   52,    0,    0,    0,   63,   63,   63,
   63,    0,  182,  120,  121,  122,   90,    0,    0,   63,
    0,  190,   57,   58,   59,   23,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  116,    0,    0,   57,   58,
   59,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  239,  241,    0,    0,    0,  181,    0,    0,
    0,  120,  121,  122,  124,    0,    0,    0,  249,    0,
    0,    0,    0,    0,    0,  124,  124,    0,   63,    0,
    0,  198,  200,   77,  201,    0,    0,   74,    0,    0,
    0,    0,    0,   52,   23,   63,   63,    0,  117,   57,
   58,   59,   52,    0,   75,    0,    0,    0,    0,   72,
   78,   63,    0,    0,   78,   78,   78,    0,    0,   79,
   78,    0,    0,   79,   79,   79,  222,    0,    0,   79,
  217,  219,  224,  220,    0,  142,  143,  144,   70,  167,
   97,   80,    0,  228,    0,   80,   80,   80,    0,  152,
    0,   80,    0,    0,    0,  236,   52,    0,    0,    0,
    0,    0,    0,   57,   58,   59,  142,  143,  144,  184,
   57,   58,   59,  186,   57,   58,   59,    0,    0,    0,
    0,    0,    0,    0,  254,   57,   58,   59,    0,  115,
   58,   59,  261,    0,  263,   92,  265,    0,    0,  266,
    0,  267,    0,    0,    0,    0,  231,
};
short yycheck[] = {                                      41,
    0,    0,    0,    0,   40,   43,   40,   45,   44,   40,
   59,   40,   59,  123,   41,   40,  123,   44,   59,  125,
   11,  258,   59,    5,    6,   20,   59,  264,   51,   58,
   41,   58,   60,   61,   62,   59,   40,  257,   40,  205,
   44,  257,   22,  124,  264,  125,  127,   41,   41,   31,
  256,   40,  256,   76,   42,  256,   40,   40,  224,   47,
   41,   44,  125,   41,   45,   41,  267,  268,  256,  257,
  276,  277,  276,  277,   69,   41,   41,  125,   44,   44,
   43,   40,   45,   40,   75,   42,   59,  123,   45,  257,
   47,   58,   41,    2,   40,   40,    5,    6,  179,   41,
   59,  276,  277,   58,   59,   41,   41,   40,  257,   41,
  138,  139,   92,   22,   23,   58,  136,  137,  100,   58,
   40,  125,   31,  266,  266,  125,  125,  125,  125,   58,
   44,   41,  258,   40,   59,  125,  266,  258,   59,  268,
  268,  268,   41,  268,  268,   59,   40,  257,   44,  256,
  256,   41,  175,  268,   41,   43,   41,   45,   41,   40,
    0,   59,   59,   59,   59,   23,  125,   59,   59,   44,
   59,   26,   60,   61,   62,   -1,   -1,  123,   -1,   -1,
   -1,   90,   -1,   44,   -1,   -1,   -1,   59,   -1,   59,
  123,  100,   59,   41,   42,   43,   -1,   45,   59,   47,
   -1,   -1,   -1,  123,   41,   42,  229,  256,   45,  256,
   47,   59,   60,   61,   62,  256,   44,   45,  125,  256,
  258,  257,  256,  256,  266,  256,  257,  256,  264,  265,
  264,  256,  256,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  276,  277,  125,  276,  277,  276,  277,  276,
  277,  276,  277,  257,  256,  266,  256,  256,  256,  256,
  264,  265,  264,  256,  258,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  257,  256,  257,  258,  259,  263,
  256,  264,  265,  276,  277,  263,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  276,  277,  256,  257,   45,
  257,  258,  259,  212,  213,  264,  265,  256,  267,  268,
  269,  257,  271,  272,  273,  274,  275,   41,  264,  265,
  266,   45,  231,  269,  257,  271,  272,  273,  274,  275,
   45,  264,  265,  276,  277,  268,  269,  257,  271,  272,
  273,  274,  275,  257,  264,  265,   45,  276,  277,  269,
  257,  271,  272,  273,  274,  275,    8,  264,  265,  258,
   12,  257,  269,  257,  271,  272,  273,  274,  275,   45,
  264,  265,  260,  261,  262,  269,  257,  271,  272,  273,
  274,  275,  257,  264,  265,  257,  256,   59,  269,  256,
  271,  272,  273,  274,  275,  270,  257,   49,   50,    8,
    9,  276,  277,   12,   42,   14,   59,   45,  256,   47,
   59,   20,  260,  261,  262,   41,   -1,   43,  266,   45,
  257,  258,  259,   -1,   41,   -1,   43,   59,   45,  257,
  258,  259,   59,   59,   60,   61,   62,   -1,   -1,   -1,
   49,   50,   59,   60,   61,   62,   41,   44,   43,   -1,
   45,   60,   61,   62,    7,   60,   61,   62,   11,   -1,
   69,   59,   59,   -1,   59,   60,   61,   62,   42,   -1,
   -1,   45,   59,   47,   -1,   42,   -1,   -1,   45,   42,
   47,   -1,   45,   -1,   47,   -1,   60,   61,   62,   -1,
   42,   -1,   -1,   45,   42,   47,  148,   45,   51,   47,
   41,   42,   43,   -1,   45,   -1,   47,   -1,   -1,   -1,
  256,  257,  258,  259,   -1,   -1,    2,   -1,   59,    5,
    6,   -1,   75,   76,   -1,   -1,   -1,  136,  137,  138,
  139,   -1,  256,  257,  258,  259,   22,   -1,   -1,  148,
   -1,  256,  257,  258,  259,   31,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  207,   -1,   -1,  257,  258,
  259,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  224,  225,   -1,   -1,   -1,  130,   -1,   -1,
   -1,  257,  258,  259,  256,   -1,   -1,   -1,  240,   -1,
   -1,   -1,   -1,   -1,   -1,  267,  268,   -1,  207,   -1,
   -1,  154,  155,  256,  157,   -1,   -1,  256,   -1,   -1,
   -1,   -1,   -1,  166,  100,  224,  225,   -1,  256,  257,
  258,  259,  175,   -1,  256,   -1,   -1,   -1,   -1,  256,
  256,  240,   -1,   -1,  260,  261,  262,   -1,   -1,  256,
  266,   -1,   -1,  260,  261,  262,  199,   -1,   -1,  266,
  193,  194,  257,  196,   -1,  260,  261,  262,  256,  256,
  257,  256,   -1,  206,   -1,  260,  261,  262,   -1,  256,
   -1,  266,   -1,   -1,   -1,  218,  229,   -1,   -1,   -1,
   -1,   -1,   -1,  257,  258,  259,  260,  261,  262,  256,
  257,  258,  259,  256,  257,  258,  259,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  247,  257,  258,  259,   -1,  257,
  258,  259,  255,   -1,  257,  256,  259,   -1,   -1,  262,
   -1,  264,   -1,   -1,   -1,   -1,  212,
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
#line 262 "gramatica.y"

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

#line 572 "y.tab.c"
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
#line 35 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 17:
#line 40 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 18:
#line 41 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable");}
break;
case 19:
#line 42 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable");}
break;
case 20:
#line 45 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 21:
#line 46 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 23:
#line 50 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 24:
#line 51 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 25:
#line 52 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 26:
#line 55 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 28:
#line 59 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de la funcion");}
break;
case 29:
#line 60 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de la funcion");}
break;
case 30:
#line 61 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta bloque de la funcion");}
break;
case 33:
#line 68 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun");}
break;
case 34:
#line 69 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion");}
break;
case 35:
#line 70 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion");}
break;
case 36:
#line 71 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion");}
break;
case 37:
#line 72 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion");}
break;
case 42:
#line 81 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 43:
#line 82 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 44:
#line 83 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
#line 90 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 48:
#line 91 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 49:
#line 94 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 50:
#line 95 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 57:
#line 104 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 58:
#line 105 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 60:
#line 109 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 61:
#line 110 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 62:
#line 111 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del for");}
break;
case 63:
#line 112 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 64:
#line 113 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del break");}
break;
case 65:
#line 114 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 66:
#line 115 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del continue");}
break;
case 67:
#line 116 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 68:
#line 117 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 69:
#line 118 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
#line 125 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 73:
#line 126 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 74:
#line 127 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 77:
#line 134 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra return");}
break;
case 79:
#line 138 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 80:
#line 139 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 82:
#line 143 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 83:
#line 144 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 84:
#line 147 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 85:
#line 148 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 88:
#line 153 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 89:
#line 154 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 90:
#line 155 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 91:
#line 156 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 92:
#line 159 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 93:
#line 160 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 94:
#line 161 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 95:
#line 162 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 97:
#line 166 "gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);}
break;
case 100:
#line 171 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 101:
#line 173 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 105:
#line 182 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 106:
#line 185 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + yyvsp[0].sval);}
break;
case 107:
#line 186 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 108:
#line 187 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 110:
#line 191 "gramatica.y"
{System.out.println("[Parser | linea " + Lexico.linea + "] se leyó una sentencia IF");}
break;
case 111:
#line 192 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia IF con ELSE");}
break;
case 113:
#line 196 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 114:
#line 197 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' del IF ");}
break;
case 115:
#line 198 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la condicion del IF ");}
break;
case 116:
#line 199 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' del IF ");}
break;
case 117:
#line 200 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el THEN del IF ");}
break;
case 118:
#line 201 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el bloque del IF ");}
break;
case 119:
#line 202 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ENDIF ");}
break;
case 123:
#line 210 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable ");}
break;
case 124:
#line 211 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable ");}
break;
case 132:
#line 225 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 133:
#line 226 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia FOR");}
break;
case 135:
#line 230 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 136:
#line 231 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 137:
#line 232 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 140:
#line 239 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion del for ");}
break;
case 141:
#line 240 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion del for ");}
break;
case 142:
#line 241 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion del for ");}
break;
case 145:
#line 248 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion del for ");}
break;
case 146:
#line 249 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion del for ");}
break;
case 147:
#line 250 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion del for ");}
break;
case 148:
#line 253 "gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 150:
#line 257 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 151:
#line 258 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta la cadena que quiere imprimir ");}
break;
case 152:
#line 259 "gramatica.y"
{System.out.println("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
#line 1096 "y.tab.c"
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
