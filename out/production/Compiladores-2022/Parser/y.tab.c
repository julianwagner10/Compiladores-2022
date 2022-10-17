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
   36,   35,   35,   35,   35,   35,   23,   23,   23,   38,
   38,   37,   37,   37,   40,   39,   39,   39,   39,   24,
   24,   24,   43,   43,   43,   43,   43,   43,   43,   44,
   44,   44,   42,   42,   42,   45,   45,   46,   46,   41,
   41,   48,   48,   48,   47,   47,   47,   47,   47,   47,
   26,   26,   26,   51,   51,   51,   51,   49,   49,   52,
   52,   52,   50,   50,   53,   53,   53,   27,   27,   54,
   54,   54,
};
short yylen[] = {                                         2,
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
    2,    1,    1,    1,    1,    2,    4,    3,    1,    4,
    3,    1,    3,    1,    2,    1,    1,    1,    2,    7,
    9,    1,    6,    6,    6,    6,    6,    6,    7,    1,
    3,    1,    1,    3,    1,    2,    2,    2,    2,    3,
    1,    2,    2,    2,    1,    1,    1,    1,    1,    1,
   10,   10,    1,    9,    9,    9,    4,    3,    1,    2,
    2,    2,    3,    1,    2,    2,    2,    4,    1,    3,
    3,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,   52,   51,    0,    0,    0,
    0,    6,    8,   10,   11,    0,    0,   17,   18,   24,
    0,   29,   34,    0,    0,    0,    0,    0,    0,   60,
   89,   96,  119,  132,  163,  179,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   43,   48,    0,    0,  114,
  113,    0,    0,    0,  115,   94,    0,    0,  101,  106,
  107,  159,  158,  160,    0,  155,  156,  157,    0,    0,
    0,  151,    0,    0,    0,    0,    0,    0,    0,    0,
   69,    0,    0,   26,    0,    0,    3,    7,   22,   21,
    0,   25,   20,    0,    0,    0,   61,   53,   71,   62,
   55,   68,   56,   63,   58,   67,   59,    4,    1,    0,
   91,    0,   92,   88,    0,   65,    0,    0,  126,  128,
  127,    0,    0,    0,    0,    0,  124,   47,    0,   44,
   66,    0,  116,  110,  111,    0,    0,    0,    0,    0,
    0,  154,    0,    0,    0,  180,    0,  181,   50,    0,
    0,   40,    0,   70,   54,    0,    0,    0,    0,  169,
   64,    0,   19,   16,   27,   23,   32,    0,   30,   57,
  129,    0,   41,  120,  117,    0,  125,   35,  121,  118,
  102,    0,  103,    0,  108,  104,  109,  105,    0,    0,
    0,    0,    0,  178,   37,    0,   38,   36,  171,    0,
  170,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   81,  167,  142,    0,    0,   31,   28,    0,
  123,    0,    0,    0,    0,    0,  145,    0,    0,    0,
    0,   39,   33,  168,    0,    0,   82,   78,    0,   83,
    0,   79,    0,    0,   12,  146,   13,   72,   74,   76,
   77,    0,    0,    0,  174,    0,    0,   42,   14,    0,
  148,   15,  135,  136,  138,    0,  137,  134,    0,   73,
   84,    0,   85,  141,    0,    0,    0,    0,  133,    0,
  144,  139,    0,  130,   75,   86,   80,    0,    0,    0,
    0,   46,    0,    0,    0,    0,    0,    0,  131,  164,
    0,  166,    0,  165,  161,  162,
};
short yydgoto[] = {                                       3,
   21,    4,   22,   23,   24,   25,  217,  218,  235,   26,
   27,   28,   29,   30,   31,   32,   54,   33,   55,   56,
   57,   34,   35,   36,   37,   38,   39,   40,  223,   79,
   41,   42,   68,   69,   70,   71,  135,   43,  136,  137,
   80,  236,   44,  224,  225,  237,   81,   82,  169,  264,
   45,  170,  265,   46,
};
short yysindex[] = {                                   -100,
  -98,   72,    0,    0,   72,   72,    0,   35,   81,  466,
  -10,   12,  411,  -40,    4,    0,    0, -201, -211,  691,
   93,    0,    0,    0,    0,    3,   94,    0,    0,    0,
  -22,    0,    0,   52,   13,   54,   75,  112,  118,    0,
    0,    0,    0,    0,    0,    0,  115,  138,  147,  178,
   30,   76, -151,   21,   77,    0,    0,   63,   87,    0,
    0,  490,  490,  490,    0,    0,    8,   39,    0,    0,
    0,    0,    0,    0,  614,    0,    0,    0,  498,   95,
  411,    0,   99,   14, -107,  -20,   -6,   96,    8,   87,
    0,  122,   61,    0,  106,  133,    0,    0,    0,    0,
   60,    0,    0, -147,   10,  153,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   87,
    0,    8,    0,    0,    8,    0,  108, -107,    0,    0,
    0,    0,  520,   47,   66,  102,    0,    0, -152,    0,
    0,  332,    0,    0,    0,  487,  537,  395,  447,  -87,
  -39,    0,  411,  -86,    8,    0,  142,    0,    0, -152,
   16,    0, -152,    0,    0, -191,  -90,  174,  129,    0,
    0,  -81,    0,    0,    0,    0,    0,   50,    0,    0,
    0, -192,    0,    0,    0,  520,    0,    0,    0,    0,
    0,   39,    0,   39,    0,    0,    0,    0,  393,  393,
  336,    8,  393,    0,    0, -178,    0,    0,    0,  -63,
    0,  -43,  127,  -56,  386,  225,  250,    0,  144,  146,
  148,  163,    0,    0,    0,  525,  393,    0,    0,   56,
    0,  126,  445,    0,  414,  -62,    0,  -35,  361,  113,
  125,    0,    0,    0,   81, -211,    0,    0,  214,    0,
  297,    0,  -31,  273,    0,    0,    0,    0,    0,    0,
    0,  691,  411,  312,    0,  128, -192,    0,    0,  425,
    0,    0,    0,    0,    0, -153,    0,    0,  338,    0,
    0,  131,    0,    0,    8,  411,    8,  -19,    0,  358,
    0,    0,  393,    0,    0,    0,    0,    8,  379,  -28,
  -27,    0,  173,  174,  387,  174,  401,  174,    0,    0,
  174,    0,  174,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,   97,    0,    0,
    0,    0,  160,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  455,    0,    0,
    0,    0,   25,    0,    0,    0,    0,    0,  670,    0,
    0,    0,    0,    0,    0,    0,  366,  508,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  391,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  157,
    0,  404,    0,    0,  407,    0,    0,  398,    0,    0,
    0,  103,    0,   18,    0,   88,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -38,    0,  -37,    0,  409,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  553,    0,  578,    0,    0,    0,    0,    0,    0,
    0,  -34,    0,    0,    0,    0,    0,    0,    0,  405,
    0,    0,    0,    0,    0,    0,    0,  205,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  307,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  416,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -136,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  408,  412,  417,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  422,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   34,    0,  674,    0,    0,  689,  244, -184,  240,    9,
  460,    0,    0,    0,    0,    0,   19,    0,    5,    0,
    0,  518,   -4,  573,    0,   -8,  587,    0,    0,   -1,
    0,    0,   17,    0,  748,    0,    0,    0,  -99,    0,
    7,  620,    0,  494,    0,    0,  -50,    0,    0,    0,
    0,    0,    0,    0,
};
#define YYTABLESIZE 982
short yytable[] = {                                      58,
   66,  201,  153,  152,   65,   65,  150,   67,   65,   92,
   95,   89,  306,  308,  246,   65,   53,   20,   91,   87,
   53,   18,    2,  300,    6,  301,   96,  283,  153,   84,
   88,  255,  257,  181,  162,   19,  187,  160,   47,   48,
  121,  124,  127,   93,   65,   65,   18,  122,  125,   20,
  146,   87,  147,   18,  158,   94,  134,   65,   65,   65,
   53,  100,   15,   85,  106,   49,  209,   19,   49,  257,
   65,  109,  210,  206,   52,   45,   65,  242,  139,  155,
  148,  151,   49,   16,   17,  149,  231,  183,  126,   20,
  182,  134,   51,   18,   53,   53,  268,   16,   17,  267,
  105,  168,  292,  104,  161,  138,  185,   19,  175,  176,
  108,   20,  111,  293,  294,   18,  132,  140,  174,  149,
  133,  141,   63,   16,   17,   62,  142,   64,  122,   19,
  149,  149,   20,  113,  177,  154,   18,  104,  178,  156,
   22,   65,   65,   65,   65,  186,  133,  188,   65,  159,
   19,  202,  103,  163,   20,   22,    1,    5,   18,  221,
   40,  118,  192,  194,  171,  142,  180,  211,  205,  207,
  115,  208,   19,  172,  229,  263,  117,   20,  199,  203,
  165,   18,  204,   51,  227,  248,  230,  226,   63,  297,
   53,   62,   20,   64,  244,   19,   18,   50,  112,  112,
   90,  112,  258,  112,  259,  273,  260,  221,  221,  249,
   19,  286,  245,   20,  243,  112,   90,   97,   97,   63,
   50,  261,   62,   58,   64,  282,  200,  153,  152,  305,
  307,  150,  274,    7,    8,   85,  121,  279,  299,  118,
   65,    9,   10,  122,   12,  221,   11,   12,   13,   85,
   14,   15,   83,   16,   17,   16,   17,   65,   65,   99,
  285,  287,  119,  140,   20,    7,    8,   85,   86,   16,
   17,  290,  280,    9,   10,   53,  157,  179,   11,   12,
   13,   65,   14,   15,  298,   16,   17,   16,   17,   20,
   49,   16,   17,   45,   45,  221,  216,  221,   50,  221,
   49,   49,  221,   15,  221,  228,    8,  107,   15,  110,
   16,   17,   20,    9,   10,  173,  102,  166,   11,   12,
   13,  184,   14,   15,  167,   16,   17,    7,    8,   12,
  112,  128,  129,  130,  131,    9,   10,   59,   60,   61,
   11,   12,   13,  122,   14,   15,   14,   16,   17,    8,
  102,   16,   17,   22,   15,  281,    9,   10,  129,  130,
  131,   11,   12,   13,   14,   14,   15,  114,   16,   17,
  288,    8,  190,  116,  256,   20,  133,  164,    9,   10,
  277,  245,  247,   11,   12,   13,  296,   14,   15,   50,
   16,   17,  278,   19,    8,  289,  295,  284,  302,   15,
   20,    9,   10,  120,   60,   61,   11,   12,   13,    8,
   14,   15,  112,   16,   17,   97,    9,   10,   19,  304,
   15,   11,   12,   13,   93,   14,   15,  311,   16,   17,
  212,   14,   20,  123,   59,   60,   61,    9,   10,   62,
  309,  313,   11,  253,  252,  213,  214,   15,  215,   95,
   19,   15,   63,   20,    5,   62,  121,   64,  233,  254,
  140,   12,   90,  172,   20,   87,  176,  182,   12,   12,
  177,   19,  270,   12,  147,  175,   12,   12,   12,   12,
  173,  212,   19,  233,   20,  101,    0,    0,    9,   10,
    0,   62,    0,   11,    0,    0,  213,  214,   15,  215,
    0,    0,   19,    0,    0,   75,  212,   63,    0,    0,
   62,    0,   64,    9,   10,  233,    0,    0,   11,    0,
    0,  213,  214,   15,  215,   76,   78,   77,   63,  212,
    0,   62,    0,   64,   62,    0,    9,   10,  271,    0,
  146,   11,  147,    0,  213,  214,   15,  215,   98,  291,
   98,    0,   98,    0,    0,    0,    0,   76,   78,   77,
    0,    0,  143,   14,  133,    0,   98,   98,   98,   98,
   14,   14,    0,  143,  143,   14,    0,   14,   63,   14,
   14,   62,    0,   64,   76,   78,   77,  189,  129,  130,
  131,    0,  232,   99,    0,   99,    0,   99,    0,    9,
   10,  239,    0,    0,   11,    0,   13,    0,   14,   15,
    0,   99,   99,   99,   99,    0,    0,  232,  100,    0,
  100,   93,  100,    0,    9,   10,    0,    0,  275,   11,
    0,   13,    0,   14,   15,    0,  100,  100,  100,  100,
    0,  250,  251,    0,    0,    0,   95,    0,    0,  232,
  195,   59,   60,   61,  150,   63,    9,   10,   62,   90,
   64,   11,   87,   13,  182,   14,   15,   59,   60,   61,
  232,  147,    0,   76,   78,   77,    0,    9,   10,    0,
    0,  232,   11,    0,   13,  219,   14,   15,    9,   10,
    0,    0,    0,   11,   98,   13,    0,   14,   15,    0,
    0,  232,  197,   59,   60,   61,    0,    0,    9,   10,
  112,  112,  112,   11,  112,   13,  112,   14,   15,    0,
   98,   98,   59,   60,   61,   72,   73,   74,  112,  112,
  112,  112,   63,  219,  219,   62,    0,   64,    0,    0,
  220,    0,  191,   59,   60,   61,   59,   60,   61,    0,
   76,   78,   77,  152,  222,    0,    0,   72,   73,   74,
    0,    0,    0,   98,    0,    0,    0,   98,   98,   98,
    0,  219,    0,   98,    0,    0,  129,  130,  131,   98,
    0,  262,    0,    0,   72,   73,   74,    0,  220,  220,
    0,    0,  193,   59,   60,   61,    0,  310,    0,  312,
    0,  314,  222,  222,  315,    0,  316,    0,   99,  143,
  144,  145,   99,   99,   99,    0,    0,    0,   99,  238,
  240,  219,  241,  219,    0,  219,  220,    0,  219,    0,
  219,    0,    0,  100,    0,    0,    0,  100,  100,  100,
  222,    0,    0,  100,    0,    0,  266,    0,    0,    0,
    0,   98,    0,    0,    0,    0,    0,    0,  276,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   59,   60,   61,   72,   73,   74,  220,    0,  220,    0,
  220,    0,    0,  220,    0,  220,    0,  234,  234,  234,
  222,  234,  222,    0,  222,  196,  198,  222,    0,  222,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  303,    0,    0,  234,    0,    0,    0,    0,
    0,  269,    0,  272,    0,  112,    0,  234,    0,  112,
  112,  112,    0,    0,    0,  112,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   59,   60,   61,
   72,   73,   74,    0,    0,    0,    0,    0,  272,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  234,
};
short yycheck[] = {                                       8,
    9,   41,   41,   41,    9,   10,   41,    9,   13,   14,
   19,   13,   41,   41,   58,   20,    8,   40,   59,   40,
   12,   44,  123,   43,  123,   45,   20,   59,   79,   40,
   12,  216,  217,  133,   41,   58,  136,   58,    5,    6,
   49,   50,   51,   40,   49,   50,   44,   49,   50,   40,
   43,   40,   45,   44,   41,  257,   52,   62,   63,   64,
   52,   59,  274,  256,   31,   41,  258,   58,   44,  254,
   75,   59,  264,   58,   40,   58,   81,  256,   58,   81,
   42,   75,   58,  276,  277,   47,  186,   41,   59,   40,
   44,   87,   58,   44,   86,   87,   41,  276,  277,   44,
  123,   41,  256,   44,   86,  257,   41,   58,  256,  257,
   59,   40,   59,  267,  268,   44,   41,   41,   59,  256,
   45,   59,   42,  276,  277,   45,   40,   47,   41,   58,
  267,  268,   40,   59,  125,   41,   44,   44,  105,   41,
   44,  146,  147,  148,  149,   44,   45,  139,  153,  257,
   58,  153,   59,   58,   40,   59,  257,  256,   44,  168,
   58,   59,  146,  147,   59,   40,   59,  258,  160,  161,
   59,  163,   58,   41,  125,  226,   59,   40,  266,  266,
   59,   44,   41,   58,  266,   59,  182,   59,   42,   59,
  182,   45,   40,   47,  258,   58,   44,   41,   42,   43,
  257,   45,   59,   47,   59,  268,   59,  216,  217,  214,
   58,  262,  256,   40,  206,   59,  257,  125,   59,   42,
  264,   59,   45,  232,   47,  257,  266,  266,  266,  258,
  258,  266,  268,  256,  257,  256,  245,  246,  258,  125,
  245,  264,  265,  245,   40,  254,  269,  270,  271,  256,
  273,  274,  263,  276,  277,  276,  277,  262,  263,  257,
  262,  263,  125,   59,   40,  256,  257,  256,  257,  276,
  277,  267,   59,  264,  265,  267,  263,  125,  269,  270,
  271,  286,  273,  274,  286,  276,  277,  276,  277,   40,
  256,  276,  277,  276,  277,  304,  123,  306,  264,  308,
  276,  277,  311,  274,  313,  256,  257,  256,  274,  256,
  276,  277,   40,  264,  265,  256,  257,  257,  269,  270,
  271,  256,  273,  274,  264,  276,  277,  256,  257,  125,
  256,  256,  257,  258,  259,  264,  265,  257,  258,  259,
  269,  270,  271,  256,  273,  274,   40,  276,  277,  257,
  257,  276,  277,  257,  274,   59,  264,  265,  257,  258,
  259,  269,  270,  271,   58,  273,  274,  256,  276,  277,
   59,  257,   41,  256,  125,   40,   45,  256,  264,  265,
  268,  256,  256,  269,  270,  271,  256,  273,  274,  264,
  276,  277,  268,   58,  257,  268,   59,  125,   41,  274,
   40,  264,  265,  257,  258,  259,  269,  270,  271,  257,
  273,  274,  256,  276,  277,  256,  264,  265,   58,   41,
  274,  269,  270,  271,   59,  273,  274,   41,  276,  277,
  257,  125,   40,  256,  257,  258,  259,  264,  265,   45,
  268,   41,  269,   58,   59,  272,  273,  274,  275,   59,
   58,  274,   42,   40,    0,   45,   59,   47,  123,  216,
  256,  257,   59,   59,   40,   59,   59,   59,  264,  265,
   59,   58,  233,  269,   59,   59,  272,  273,  274,  275,
   59,  257,   58,  123,   40,   26,   -1,   -1,  264,  265,
   -1,   45,   -1,  269,   -1,   -1,  272,  273,  274,  275,
   -1,   -1,   58,   -1,   -1,   40,  257,   42,   -1,   -1,
   45,   -1,   47,  264,  265,  123,   -1,   -1,  269,   -1,
   -1,  272,  273,  274,  275,   60,   61,   62,   42,  257,
   -1,   45,   -1,   47,   45,   -1,  264,  265,  125,   -1,
   43,  269,   45,   -1,  272,  273,  274,  275,   41,  125,
   43,   -1,   45,   -1,   -1,   -1,   -1,   60,   61,   62,
   -1,   -1,  256,  257,   45,   -1,   59,   60,   61,   62,
  264,  265,   -1,  267,  268,  269,   -1,  271,   42,  273,
  274,   45,   -1,   47,   60,   61,   62,  256,  257,  258,
  259,   -1,  257,   41,   -1,   43,   -1,   45,   -1,  264,
  265,  266,   -1,   -1,  269,   -1,  271,   -1,  273,  274,
   -1,   59,   60,   61,   62,   -1,   -1,  257,   41,   -1,
   43,  256,   45,   -1,  264,  265,   -1,   -1,  268,  269,
   -1,  271,   -1,  273,  274,   -1,   59,   60,   61,   62,
   -1,  256,  257,   -1,   -1,   -1,  256,   -1,   -1,  257,
  256,  257,  258,  259,   41,   42,  264,  265,   45,  256,
   47,  269,  256,  271,  256,  273,  274,  257,  258,  259,
  257,  256,   -1,   60,   61,   62,   -1,  264,  265,   -1,
   -1,  257,  269,   -1,  271,  168,  273,  274,  264,  265,
   -1,   -1,   -1,  269,   21,  271,   -1,  273,  274,   -1,
   -1,  257,  256,  257,  258,  259,   -1,   -1,  264,  265,
   41,   42,   43,  269,   45,  271,   47,  273,  274,   -1,
   47,   48,  257,  258,  259,  260,  261,  262,   59,   60,
   61,   62,   42,  216,  217,   45,   -1,   47,   -1,   -1,
  168,   -1,  256,  257,  258,  259,  257,  258,  259,   -1,
   60,   61,   62,  256,  168,   -1,   -1,  260,  261,  262,
   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
   -1,  254,   -1,  266,   -1,   -1,  257,  258,  259,  106,
   -1,  257,   -1,   -1,  260,  261,  262,   -1,  216,  217,
   -1,   -1,  256,  257,  258,  259,   -1,  304,   -1,  306,
   -1,  308,  216,  217,  311,   -1,  313,   -1,  256,   62,
   63,   64,  260,  261,  262,   -1,   -1,   -1,  266,  200,
  201,  304,  203,  306,   -1,  308,  254,   -1,  311,   -1,
  313,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
  254,   -1,   -1,  266,   -1,   -1,  227,   -1,   -1,   -1,
   -1,  178,   -1,   -1,   -1,   -1,   -1,   -1,  239,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,  258,  259,  260,  261,  262,  304,   -1,  306,   -1,
  308,   -1,   -1,  311,   -1,  313,   -1,  199,  200,  201,
  304,  203,  306,   -1,  308,  148,  149,  311,   -1,  313,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  293,   -1,   -1,  227,   -1,   -1,   -1,   -1,
   -1,  233,   -1,  235,   -1,  256,   -1,  239,   -1,  260,
  261,  262,   -1,   -1,   -1,  266,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,  258,  259,
  260,  261,  262,   -1,   -1,   -1,   -1,   -1,  270,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  293,
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
"seleccion : IF '(' condicion ')' THEN bloque_if ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_if ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"error_seleccion : '(' condicion ')' THEN bloque_if ENDIF",
"error_seleccion : IF condicion ')' THEN bloque_if ENDIF",
"error_seleccion : IF '(' ')' THEN bloque_if ENDIF",
"error_seleccion : IF '(' condicion THEN bloque_if ENDIF",
"error_seleccion : IF '(' condicion ')' bloque_if ENDIF",
"error_seleccion : IF '(' condicion ')' THEN ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_if error",
"bloque_for : ejecucion_control",
"bloque_for : '{' bloque_ejecutable_for '}'",
"bloque_for : error_bloque_for",
"bloque_if : ejecucion",
"bloque_if : '{' bloque_ejecutable_if '}'",
"bloque_if : error_bloque_if",
"error_bloque_for : bloque_ejecutable_for '}'",
"error_bloque_for : '{' bloque_ejecutable_for",
"error_bloque_if : bloque_ejecutable_if '}'",
"error_bloque_if : '{' bloque_ejecutable_if",
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
#line 311 "gramatica.y"

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
    //System.out.println("Parser: " + s);
}

public void chequearNegativos(){
	String lexema = yylval.sval;
	int id = Main.tablaDeSimbolos.getIdentificador(lexema);
	if(id == Lexico.CTE_INT){
		Integer enteroNeg = -1*Integer.parseInt(lexema);
		if((enteroNeg >= (-Math.pow(2,31))) && (enteroNeg <= (Math.pow(2,31) - 1))){
		    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante ENTERA LARGA son signo negativo -> "+enteroNeg);
		    Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(enteroNeg));
		}
		else{
		    Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante ENTERA LARGA fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
		}
	}
	else if (id == Lexico.CTE_FLOTANTE) {
		Float flotanteNeg = -1*Float.parseFloat(lexema.replace('F','e'));
        if ((flotanteNeg > 1.17549435e-38 && flotanteNeg < 3.40282347e+38) || (flotanteNeg > -3.40282347e+38 && flotanteNeg < -1.17549435e-38) || (flotanteNeg == 0.0)){
            Main.tablaDeSimbolos.modificarSimbolo(lexema, String.valueOf(flotanteNeg));
            System.out.println("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
        }
        else {
            Main.erroresSintacticos.add("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante FLOTANTE fuera de rango");
            Main.tablaDeSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}

#line 680 "y.tab.c"
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
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");}
break;
case 2:
#line 13 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
#line 16 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
#line 17 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
#line 18 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 9:
#line 26 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia declarativa o ejecutable valida");}
break;
case 16:
#line 48 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variable/s");}
break;
case 19:
#line 53 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
#line 54 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
#line 55 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
#line 58 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);}
break;
case 23:
#line 59 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables con identificador -> " + yyvsp[0].sval);}
break;
case 25:
#line 63 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
#line 64 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
#line 65 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
#line 68 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");}
break;
case 30:
#line 72 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
#line 73 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
#line 74 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 35:
#line 81 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
#line 82 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
#line 83 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
#line 84 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
#line 85 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 44:
#line 94 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
#line 95 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
#line 96 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 49:
#line 103 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
#line 104 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
#line 107 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");}
break;
case 52:
#line 108 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");}
break;
case 54:
#line 112 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 57:
#line 115 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +yyvsp[-3].sval);}
break;
case 61:
#line 121 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 62:
#line 122 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 63:
#line 123 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 64:
#line 124 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta de la sentencia de control");}
break;
case 65:
#line 125 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la sentencia de control en la etiqueta");}
break;
case 66:
#line 126 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' en la etiqueta");}
break;
case 67:
#line 127 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
#line 128 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
#line 129 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
#line 130 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
#line 131 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 73:
#line 135 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");}
break;
case 75:
#line 137 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +yyvsp[-3].sval);}
break;
case 78:
#line 140 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");}
break;
case 79:
#line 141 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");}
break;
case 80:
#line 142 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia ejecutable CONTINUE con etiqueta: " +yyvsp[-1].sval);}
break;
case 82:
#line 146 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia BREAK");}
break;
case 83:
#line 147 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
#line 148 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
#line 149 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
#line 150 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 88:
#line 154 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");}
break;
case 90:
#line 158 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 91:
#line 159 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
#line 160 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 93:
#line 161 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 94:
#line 162 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 97:
#line 169 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 99:
#line 173 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 100:
#line 174 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 102:
#line 178 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 103:
#line 179 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 104:
#line 182 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 105:
#line 183 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 108:
#line 188 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 109:
#line 189 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 110:
#line 190 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 111:
#line 191 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 115:
#line 197 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");}
break;
case 116:
#line 198 "gramatica.y"
{chequearNegativos();}
break;
case 117:
#line 201 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);}
break;
case 118:
#line 202 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-2].sval);}
break;
case 120:
#line 206 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 121:
#line 207 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 125:
#line 215 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 127:
#line 219 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + yyvsp[0].sval);}
break;
case 128:
#line 220 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + yyvsp[0].sval);}
break;
case 129:
#line 221 "gramatica.y"
{chequearNegativos();}
break;
case 130:
#line 224 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");}
break;
case 131:
#line 225 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF con ELSE");}
break;
case 133:
#line 229 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 134:
#line 230 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 135:
#line 231 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 136:
#line 232 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 137:
#line 233 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada THEN de la sentencia IF ");}
break;
case 138:
#line 234 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 139:
#line 235 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 146:
#line 247 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 147:
#line 248 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 148:
#line 251 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 149:
#line 252 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 152:
#line 260 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 153:
#line 261 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 154:
#line 262 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 161:
#line 273 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 162:
#line 274 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");}
break;
case 163:
#line 275 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 164:
#line 278 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 165:
#line 279 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 166:
#line 280 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 167:
#line 281 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 170:
#line 288 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 171:
#line 289 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 172:
#line 290 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 175:
#line 297 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 176:
#line 298 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 177:
#line 299 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 178:
#line 302 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");}
break;
case 180:
#line 306 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 181:
#line 307 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 182:
#line 308 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
#line 1276 "y.tab.c"
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
