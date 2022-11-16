#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "gramatica.y"
package Parser;
import Principal.*;
import ArbolSintactico.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

#line 14 "y.tab.c"
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
    6,    6,   28,   28,   28,   28,   28,   28,   28,   28,
    8,    8,    8,    8,    8,    8,    8,    8,    8,   30,
   30,   29,   29,   29,   29,   29,   32,   22,   22,   22,
   35,   35,   35,   35,   35,   25,   25,   36,   33,   33,
   33,   33,   38,   38,   37,   37,   37,   37,   40,   40,
   40,   40,   39,   39,   39,   39,   39,   39,   23,   23,
   23,   42,   42,   41,   41,   41,   43,   43,   43,   31,
   31,   31,   31,   31,   24,   24,   46,   46,   46,   46,
   46,   45,   45,   45,   48,   48,   48,   47,   47,   47,
   47,   34,   34,   34,   34,   49,   49,   50,   50,   50,
   51,   51,   51,   52,   52,   44,   44,   54,   54,   54,
   53,   53,   53,   53,   53,   53,   26,   26,   26,   58,
   57,   57,   57,   59,   59,   59,   59,   59,   55,   55,
   60,   60,   60,   56,   56,   61,   61,   61,   27,   27,
   62,   62,   62,
};
short yylen[] = {                                         2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    2,    2,
    4,    1,    2,    2,    2,    2,    2,    2,    3,    2,
    2,    3,    2,    2,    2,    2,    2,    4,    1,    3,
    2,    2,    2,    3,    3,    4,    2,    3,    4,    1,
    3,    4,    3,    2,    3,    2,    1,    1,    1,    3,
    3,    1,    3,    3,    3,    3,    1,    1,    3,    3,
    2,    2,    1,    1,    1,    1,    2,    2,    4,    3,
    1,    4,    3,    1,    3,    1,    2,    5,    7,    1,
    1,    1,    2,    2,    5,    1,    4,    4,    4,    4,
    5,    3,    4,    1,    4,    2,    3,    1,    3,    1,
    1,    2,    4,    2,    1,    2,    2,    3,    3,    3,
    1,    3,    1,    2,    2,    3,    1,    2,    2,    2,
    1,    1,    1,    1,    1,    1,    9,   10,    1,    4,
    2,    2,    1,    1,    2,    2,    2,    2,    3,    1,
    2,    2,    2,    3,    1,    2,    2,    2,    4,    1,
    3,    3,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    9,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   52,   51,    0,
    0,    0,    6,    8,   10,   11,    0,    0,   17,   18,
   24,    0,   29,   34,    0,    0,    0,    0,    0,    0,
   62,    0,   90,   97,  121,  136,  179,  200,    0,    0,
    0,    0,   87,    0,    0,    0,    0,   43,   48,    0,
  115,  114,    0,    0,    0,  116,    0,    0,    0,  102,
  107,  108,    0,  175,  174,  176,    0,  171,  172,  173,
    0,    0,    0,  167,    0,    0,    0,    0,    0,    0,
    0,   59,    0,   68,    0,    0,   60,    0,   26,    0,
    3,    7,   22,   21,    0,   25,   20,    0,    0,    0,
   63,   53,   70,   64,   55,   67,   56,   65,   57,   66,
   58,    0,    4,    1,    0,    0,    0,   93,    0,    0,
    0,  130,  132,  131,    0,    0,    0,    0,    0,  126,
   47,    0,   44,    0,  117,  118,  111,  112,    0,    0,
   95,  155,    0,    0,    0,    0,    0,    0,  170,    0,
    0,    0,  201,    0,  202,   50,    0,    0,   40,    0,
   69,   54,    0,    0,    0,    0,  190,    0,    0,   19,
   16,   27,   23,   32,    0,   30,    0,   92,   89,  133,
  134,    0,   41,    0,  127,  122,  119,   35,  123,  120,
    0,    0,    0,    0,    0,  154,    0,    0,   14,    0,
  103,    0,  104,    0,  109,  105,  110,  106,    0,    0,
  139,  144,    0,  140,    0,  138,  199,   37,    0,   38,
   36,  192,    0,  191,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   79,  180,  163,    0,   61,
  137,   31,   28,    0,    0,    0,    0,    0,    0,  159,
   15,   81,  158,    0,    0,    0,  150,    0,  151,    0,
    0,  135,   39,   33,  189,   82,   76,    0,   83,    0,
   77,    0,    0,   12,  164,   13,   71,   73,   74,   75,
    0,    0,    0,  195,    0,    0,   42,    0,   80,  153,
    0,  156,    0,  142,    0,   72,   84,    0,   85,  162,
    0,    0,    0,    0,    0,    0,    0,  149,  145,  143,
   86,   78,    0,  184,    0,    0,    0,  183,    0,   46,
    0,  186,  181,  187,  185,  182,  188,    0,    0,  129,
  177,    0,  178,
};
short yydgoto[] = {                                       3,
   22,    4,   23,   24,   25,   26,  240,  241,  266,   27,
   28,   29,   30,   31,   32,   33,   56,   34,   57,   58,
   59,   35,   36,   37,   38,   39,   40,   41,  246,  267,
  207,   42,   81,  151,   43,   44,   69,   70,   71,   72,
  139,   45,  140,   82,  221,   46,  268,  222,  269,  152,
  247,  248,   83,   84,  176,  293,  327,   47,  328,  177,
  294,   48,
};
short yysindex[] = {                                    -90,
  -88,  114,    0,    0,  114,  114,    0,  -31,  492,  669,
  -25,  -21,  165,   18,  -35,   52,   76,    0,    0, -207,
  757,   -6,    0,    0,    0,    0,   -4,  145,    0,    0,
    0,   39,    0,    0,  -36,   45,  -22,   26,   35,   68,
    0, -199,    0,    0,    0,    0,    0,    0,  135,  156,
  527,  351,    0,   21, -149,   60,   95,    0,    0,  -19,
    0,    0,  -98,  510,  510,    0, -103,   22,   91,    0,
    0,    0,  103,    0,    0,    0,  751,    0,    0,    0,
  603,  140,  165,    0,  151,  -34,  -63,   16,   43,  148,
   22,    0,  103,    0,  138,   64,    0,  -54,    0,  183,
    0,    0,    0,    0,  125,    0,    0,  -70,   66,  177,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  136,    0,    0,  -19, -103,   22,    0, -103,   22,
  -63,    0,    0,    0,    0,  -44,  141,  615,  -16,    0,
    0,   79,    0,  118,    0,    0,    0,    0,  202,  327,
    0,    0,  632,  650,  550,  591, -225,  -38,    0,  165,
 -225,   22,    0,  305,    0,    0,   79,   24,    0,   79,
    0,    0, -155,   92,  278,  338,    0,  379, -225,    0,
    0,    0,    0,    0,   88,    0, -164,    0,    0,    0,
    0, -130,    0,  578,    0,    0,    0,    0,    0,    0,
  116,  425,  327,    0,  222,    0,  381,  116,    0,  378,
    0,   91,    0,   91,    0,    0,    0,    0,  243,  243,
    0,    0, -193,    0,   22,    0,    0,    0,  -68,    0,
    0,    0,  200,    0,  199,  160,  207,  112,  483,  448,
    0,  398,  409,  413,  423,    0,    0,    0,  675,    0,
    0,    0,    0,  424,  157,  446,  492,  433,  397,    0,
    0,    0,    0,  327,    0,  416,    0, -103,    0,  -95,
  243,    0,    0,    0,    0,    0,    0,  439,    0,  445,
    0,   -8,  469,    0,    0,    0,    0,    0,    0,    0,
  757,  165,  447,    0,  675, -130,    0,  578,    0,    0,
  429,    0,  237,    0,  242,    0,    0,  360,    0,    0,
   22,  165,   22,  -32,  460,  479,  480,    0,    0,    0,
    0,    0,   22,    0, -114,  270,  484,    0,  -32,    0,
  578,    0,    0,    0,    0,    0,    0,  278,  491,    0,
    0,  278,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,  146,    0,    0,
    0,    0,  422,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  533,
    0,    0,    0,    0,   13,    0,    0,    0,    0,   78,
    0,    0,    0,    0,    0,    0,    0,  440,  572,    0,
    0,    0,  718,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  454,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   70,    0,  462,    0,    0,  468,
  477,    0,    0,    0,  377,    0,   72,  -15,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -29,
    0,  -12,    0,  471,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  481,    0,    0,  314,    0,    0,    0,    0,    0,    0,
    0,  596,    0,  729,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   61,    0,    0,    0,    0,    0,
    0,    0,  485,    0,    0,    0,    0,    0,    0,    0,
  355,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   17,    0,    0,  -45,    0,
    0,    0,    0,    0,  292,    0,    0,    0,    0,  472,
  517,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  452,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  648,    0,    0,    0,  531,    0,    0,    0,    0,    0,
  486,  487,  499,    0,    0,    0,   20,    0,    0,    0,
    0,    0,  503,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,
};
short yygindex[] = {                                      0,
   84,    0,   31,    0,    0,  693,  299, -152,  -81,   10,
  541,    0,    0,    0,    0,    0,   36,    0,  -53,    0,
    0, -143,   -5,  600,    0,   -9,  628,    0,    0,  428,
  -37,    0,   -7,  336,    0,    0,  291,    0,  689,    0,
    0,    0,    0,    9, -109,    0,  361,    0,    0,    0,
 -247,    0,  194,    0,  393,  298,  268,    0,    0,    0,
    0,    0,
};
#define YYTABLESIZE 1019
short yytable[] = {                                      67,
  137,   68,  223,   66,   66,   91,  165,   66,   54,   95,
  325,  169,  326,  160,   86,   66,  138,   55,   89,  150,
  144,   55,  112,   94,  197,  124,   53,  150,  168,  100,
  219,  242,    2,   21,    6,  137,  115,   20,   53,   20,
  220,  126,  129,  127,  130,   66,   66,   90,  224,   99,
  309,  226,  102,   49,  104,   89,   49,  125,   66,   66,
  128,  135,  271,   55,  153,  136,  154,  205,  210,  251,
   49,   66,  220,  167,  122,  162,   92,   66,   21,  102,
  102,  229,   20,  169,  117,  158,  284,  286,   49,   50,
  341,   96,  173,  119,  343,  242,  242,   55,   55,  174,
  195,  166,  232,  113,  175,   21,  138,  141,  233,   20,
   50,  113,  113,  272,  113,  110,  113,  142,  101,  113,
  113,  259,  113,  168,  113,   87,  121,   21,  113,   45,
  286,   20,  155,   98,   97,  143,  113,  156,  255,  242,
  102,  332,  144,  333,  334,   18,   19,   66,   66,   66,
   66,  198,  225,   21,   66,  144,  256,   20,  200,  145,
  146,  109,  136,  149,  258,  244,    1,    5,  108,  282,
  281,  149,  304,   53,   21,  187,  228,  230,   20,  231,
  161,  193,  301,  181,  192,  182,  183,  273,  108,   22,
  184,  163,  185,  166,  242,   21,  172,  297,  242,   20,
  296,   55,  178,  107,   22,  170,   64,   18,   19,   63,
  160,   65,  253,  190,  191,  102,   21,  219,  277,  111,
   20,   93,  160,  179,   51,  324,  169,  220,  164,  244,
  244,  278,   52,  114,   87,   88,  169,   85,  274,  196,
  124,   21,  316,  168,   18,   19,  136,  126,  308,  127,
    8,   66,  103,  168,   18,   19,   53,    9,   10,  123,
  317,   21,   11,   12,   13,   14,   15,   16,   17,   18,
   19,   87,  125,  244,  160,  128,  131,  132,  133,  134,
  124,  116,   21,  311,  313,   66,   66,  136,   49,   49,
  118,   18,   19,  340,    7,    8,   18,   19,   87,   18,
   19,  186,    9,   10,  323,   55,   66,   11,   12,   13,
   14,   15,   16,   17,   18,   19,  166,   21,   18,   19,
  173,    7,    8,  120,  203,  113,  166,  174,  244,    9,
   10,   14,  244,  113,   11,   12,   13,   14,   15,   16,
   17,   18,   19,  252,    8,  227,  260,   45,   45,  234,
  148,    9,   10,   14,   18,   19,   11,   12,   13,   14,
   15,   16,   17,   18,   19,  264,   21,  279,  280,    7,
    8,  257,  152,  199,  132,  133,  134,    9,   10,   52,
  180,  106,   11,   12,   13,   14,   15,   16,   17,   18,
   19,    8,   64,  171,   12,   63,  249,   65,    9,   10,
  239,  106,   22,   11,   12,   13,   14,   15,   16,   17,
   18,   19,    8,  161,  148,  276,   14,   21,  322,    9,
   10,   73,   61,   62,   11,   12,   13,   14,   15,   16,
   17,   18,   19,    8,   40,  120,   21,  250,   14,  262,
    9,   10,  292,  212,  214,   11,   12,   13,   14,   15,
   16,   17,   18,   19,  257,   21,  287,  275,  201,  133,
  134,  188,   52,   93,  189,    9,   10,  288,   21,  136,
   11,  289,   13,  202,   15,   16,   17,  161,  208,   12,
   98,  290,  295,   92,  312,    9,   10,   21,  292,  298,
   11,  299,   13,   14,   15,   16,   17,  306,   94,  201,
  133,  134,  263,  307,  319,  314,    9,   10,   21,  320,
  165,   11,   96,   13,  202,   15,   16,   17,  329,  330,
   91,  300,   21,  331,  338,  335,   88,  336,  337,  203,
  146,  342,    5,   64,  235,  123,   63,  283,   65,  130,
  302,    9,   10,  193,  197,  198,   11,  148,   14,  236,
  237,   16,  238,  318,   63,   14,   14,  196,  148,  148,
   14,  194,   14,   14,   14,   14,   14,  105,   64,  152,
   14,   63,  285,   65,  165,  141,  206,   14,   14,  254,
  270,  152,   14,  208,   14,   14,   14,   14,   14,  147,
    9,   10,  315,  310,   63,   11,  339,   13,   14,   15,
   16,   17,    0,  303,    0,  305,  128,   60,   61,   62,
  161,   12,   99,    0,   99,  321,   99,    0,   12,   12,
    0,  161,  136,   12,   16,    0,   12,   12,   12,   12,
   99,   99,   99,   99,  208,   63,  100,    0,  100,    0,
  100,    9,   10,    0,    0,  153,   11,  154,   13,   14,
   15,   16,   17,  208,  100,  100,  100,  100,  194,  136,
    9,   10,   78,   80,   79,   11,    0,   13,   14,   15,
   16,   17,  208,   64,    0,    0,   63,   98,   65,    9,
   10,  132,  133,  134,   11,  208,   13,   14,   15,   16,
   17,   64,    9,   10,   63,   94,   65,   11,    0,   13,
   14,   15,   16,   17,  235,    0,  157,  165,   77,   96,
   64,    9,   10,   63,    0,   65,   11,   91,  165,  236,
  237,   16,  238,   88,    0,  235,  203,  146,   78,   80,
   79,    0,    9,   10,   78,   80,   79,   11,    0,  235,
  236,  237,   16,  238,    0,    0,    9,   10,   60,   61,
   62,   11,  147,  148,  236,  237,   16,  238,  113,  113,
  113,    0,  113,    0,  113,   16,   73,   61,   62,  101,
  157,  101,  141,  101,  243,    0,  113,  113,  113,  113,
    0,    0,    0,  125,   61,   62,  147,  101,  101,  101,
  101,  157,   64,    0,    0,   63,    0,   65,   64,    0,
   16,   63,  245,   65,    0,  215,   73,   61,   62,    0,
   78,   80,   79,    0,    0,    0,   78,   80,   79,    0,
    0,    0,    0,    0,    0,    0,    0,   99,    0,    0,
    0,   99,   99,   99,  132,  133,  134,   99,  243,  243,
    0,  204,  209,  216,  218,    0,  217,   73,   61,   62,
    0,  100,    0,    0,    0,  100,  100,  100,  159,    0,
    0,  100,   74,   75,   76,    0,  245,  245,    0,    0,
    0,  132,  133,  134,    0,    0,    0,    0,    0,    0,
    0,    0,  243,    0,    0,    0,    0,  211,   73,   61,
   62,    0,    0,    0,    0,  209,    0,  261,    0,    0,
    0,    0,  261,  157,    0,  213,   73,   61,   62,    0,
  245,  265,  265,    0,  157,  157,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   73,   61,   62,   74,   75,
   76,  291,    0,    0,   74,   75,   76,  243,    0,    0,
    0,  243,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  261,    0,    0,    0,    0,  209,    0,  261,    0,
    0,    0,    0,  265,    0,  245,    0,    0,    0,  245,
    0,    0,    0,  113,    0,    0,    0,  113,  113,  113,
    0,    0,    0,  113,  101,    0,    0,    0,  101,  101,
  101,    0,    0,  261,  101,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   73,   61,   62,
   74,   75,   76,   73,   61,   62,   74,   75,   76,
};
short yycheck[] = {                                       9,
   54,    9,   41,    9,   10,   13,   41,   13,   40,   15,
   43,   41,   45,   59,   40,   21,   54,    8,   40,  123,
   40,   12,   59,   59,   41,   41,   58,  123,   41,   21,
  256,  175,  123,   40,  123,   89,   59,   44,   58,   44,
  266,   51,   52,   51,   52,   51,   52,   12,  158,  257,
   59,  161,   22,   41,   59,   40,   44,   41,   64,   65,
   41,   41,  256,   54,   43,   45,   45,  149,  150,  179,
   58,   77,  266,   58,  274,   83,   59,   83,   40,   49,
   50,   58,   44,   41,   59,   77,  239,  240,    5,    6,
  338,   40,  257,   59,  342,  239,  240,   88,   89,  264,
  138,   41,  258,   59,   41,   40,  144,  257,  264,   44,
   41,   42,   43,  223,   45,   32,   47,   58,  125,   42,
   43,  203,   45,   88,   47,  256,   59,   40,   59,   58,
  283,   44,   42,   58,   59,   41,   59,   47,  192,  283,
  110,  256,   40,  258,  259,  276,  277,  153,  154,  155,
  156,  142,  160,   40,  160,   40,  194,   44,   41,  258,
  259,  123,   45,  267,  202,  175,  257,  256,   44,   58,
   59,  267,  268,   58,   40,   40,  167,  168,   44,  170,
   41,   41,  264,   59,   44,  256,  257,  256,   44,   44,
  125,   41,  109,  257,  338,   40,   59,   41,  342,   44,
   44,  192,  257,   59,   59,   58,   42,  276,  277,   45,
  256,   47,  125,  258,  259,  185,   40,  256,   59,  256,
   44,  257,  268,   41,  256,  258,  256,  266,  263,  239,
  240,  237,  264,  256,  256,  257,  266,  263,  229,  256,
  256,   40,  296,  256,  276,  277,   45,  257,  257,  257,
  257,  257,  257,  266,  276,  277,   58,  264,  265,  125,
  298,   40,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  256,  256,  283,   81,  256,  256,  257,  258,  259,
  125,  256,   40,  291,  292,  291,  292,   45,  276,  277,
  256,  276,  277,  331,  256,  257,  276,  277,  256,  276,
  277,  125,  264,  265,  312,  296,  312,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  256,   40,  276,  277,
  257,  256,  257,  256,  123,  256,  266,  264,  338,  264,
  265,   40,  342,  256,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  256,  257,   41,  125,  276,  277,  258,
   59,  264,  265,   40,  276,  277,  269,  270,  271,  272,
  273,  274,  275,  276,  277,  123,   40,  256,  257,  256,
  257,  256,   59,  256,  257,  258,  259,  264,  265,  264,
  256,  257,  269,  270,  271,  272,  273,  274,  275,  276,
  277,  257,   42,  256,   40,   45,   59,   47,  264,  265,
  123,  257,  257,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  257,   59,  123,  256,  125,   40,   59,  264,
  265,  257,  258,  259,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  257,   58,   59,   40,   59,  125,   59,
  264,  265,  249,  153,  154,  269,  270,  271,  272,  273,
  274,  275,  276,  277,  256,   40,   59,  258,  257,  258,
  259,  126,  264,  257,  129,  264,  265,   59,   40,   45,
  269,   59,  271,  272,  273,  274,  275,  123,  257,  125,
   59,   59,   59,   59,  291,  264,  265,   40,  295,   44,
  269,   59,  271,  272,  273,  274,  275,   59,   59,  257,
  258,  259,  125,   59,  268,   59,  264,  265,   40,  268,
   59,  269,   59,  271,  272,  273,  274,  275,   59,   41,
   59,  125,   40,   44,   41,  256,   59,  258,  259,   59,
   59,   41,    0,   42,  257,   59,   45,  239,   47,   59,
  125,  264,  265,   59,   59,   59,  269,  256,  257,  272,
  273,  274,  275,  125,   45,  264,  265,   59,  267,  268,
  269,   59,  271,  272,  273,  274,  275,   27,   42,  256,
  257,   45,  125,   47,  123,   59,  149,  264,  265,  187,
  220,  268,  269,  257,  271,  272,  273,  274,  275,   59,
  264,  265,  295,  125,   45,  269,  329,  271,  272,  273,
  274,  275,   -1,  268,   -1,  270,  256,  257,  258,  259,
  256,  257,   41,   -1,   43,  256,   45,   -1,  264,  265,
   -1,  267,   45,  269,  274,   -1,  272,  273,  274,  275,
   59,   60,   61,   62,  257,   45,   41,   -1,   43,   -1,
   45,  264,  265,   -1,   -1,   43,  269,   45,  271,  272,
  273,  274,  275,  257,   59,   60,   61,   62,   44,   45,
  264,  265,   60,   61,   62,  269,   -1,  271,  272,  273,
  274,  275,  257,   42,   -1,   -1,   45,  256,   47,  264,
  265,  257,  258,  259,  269,  257,  271,  272,  273,  274,
  275,   42,  264,  265,   45,  256,   47,  269,   -1,  271,
  272,  273,  274,  275,  257,   -1,   59,  256,   40,  256,
   42,  264,  265,   45,   -1,   47,  269,  256,  267,  272,
  273,  274,  275,  256,   -1,  257,  256,  256,   60,   61,
   62,   -1,  264,  265,   60,   61,   62,  269,   -1,  257,
  272,  273,  274,  275,   -1,   -1,  264,  265,  257,  258,
  259,  269,   64,   65,  272,  273,  274,  275,   41,   42,
   43,   -1,   45,   -1,   47,  274,  257,  258,  259,   41,
  123,   43,  256,   45,  175,   -1,   59,   60,   61,   62,
   -1,   -1,   -1,  257,  258,  259,  256,   59,   60,   61,
   62,   41,   42,   -1,   -1,   45,   -1,   47,   42,   -1,
  274,   45,  175,   47,   -1,  256,  257,  258,  259,   -1,
   60,   61,   62,   -1,   -1,   -1,   60,   61,   62,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,   -1,
   -1,  260,  261,  262,  257,  258,  259,  266,  239,  240,
   -1,  149,  150,  155,  156,   -1,  256,  257,  258,  259,
   -1,  256,   -1,   -1,   -1,  260,  261,  262,  256,   -1,
   -1,  266,  260,  261,  262,   -1,  239,  240,   -1,   -1,
   -1,  257,  258,  259,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  283,   -1,   -1,   -1,   -1,  256,  257,  258,
  259,   -1,   -1,   -1,   -1,  203,   -1,  205,   -1,   -1,
   -1,   -1,  210,  256,   -1,  256,  257,  258,  259,   -1,
  283,  219,  220,   -1,  267,  268,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  257,  258,  259,  260,  261,
  262,  257,   -1,   -1,  260,  261,  262,  338,   -1,   -1,
   -1,  342,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  259,   -1,   -1,   -1,   -1,  264,   -1,  266,   -1,
   -1,   -1,   -1,  271,   -1,  338,   -1,   -1,   -1,  342,
   -1,   -1,   -1,  256,   -1,   -1,   -1,  260,  261,  262,
   -1,   -1,   -1,  266,  256,   -1,   -1,   -1,  260,  261,
  262,   -1,   -1,  301,  266,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,  258,  259,
  260,  261,  262,  257,  258,  259,  260,  261,  262,
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
"ejecucion : control ';'",
"ejecucion : salida ';'",
"ejecucion : BREAK ';'",
"ejecucion : CONTINUE ';'",
"ejecucion : CONTINUE ':' ID ';'",
"ejecucion : error_ejecucion",
"error_ejecucion : asignacion error",
"error_ejecucion : seleccion error",
"error_ejecucion : control error",
"error_ejecucion : salida error",
"error_ejecucion : retorno error",
"error_ejecucion : DISCARD ';'",
"error_ejecucion : DISCARD invocacion error",
"error_ejecucion : invocacion ';'",
"ejecucion_control : asignacion ';'",
"ejecucion_control : DISCARD invocacion ';'",
"ejecucion_control : seleccion ';'",
"ejecucion_control : control ';'",
"ejecucion_control : salida ';'",
"ejecucion_control : BREAK ';'",
"ejecucion_control : CONTINUE ';'",
"ejecucion_control : CONTINUE ':' ID ';'",
"ejecucion_control : error_ejecucion_control",
"break_con_retorno : BREAK factor_invocacion ';'",
"break_con_retorno : factor_invocacion ';'",
"error_ejecucion_control : BREAK error",
"error_ejecucion_control : CONTINUE error",
"error_ejecucion_control : CONTINUE ID ';'",
"error_ejecucion_control : CONTINUE ':' ';'",
"error_ejecucion_control : CONTINUE ':' ID error",
"etiqueta : ID ':'",
"asignacion : ID ASIGNACION expresion_aritmetica",
"asignacion : ID ASIGNACION control cuerpo_else",
"asignacion : error_asignacion",
"error_asignacion : ID error expresion_aritmetica",
"error_asignacion : ID error control cuerpo_else",
"error_asignacion : ID ASIGNACION error",
"error_asignacion : ASIGNACION expresion_aritmetica",
"error_asignacion : ASIGNACION control cuerpo_else",
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
"error_parametros_reales : factor_invocacion ',' factor_invocacion ',' factor_invocacion",
"error_parametros_reales : factor_invocacion ',' factor_invocacion ',' factor_invocacion ',' factor_invocacion",
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
"cuerpo_then : break_con_retorno",
"cuerpo_then : error_cuerpo_then",
"cuerpo_else : ELSE ejecucion",
"cuerpo_else : ELSE '{' bloque_ejecutable_if '}'",
"cuerpo_else : ELSE break_con_retorno",
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
"control : FOR '(' asignacion_for ';' condicion_for ';' incr_decr ')' bloque_for",
"control : etiqueta FOR '(' asignacion_for ';' condicion_for ';' incr_decr ')' bloque_for",
"control : error_control",
"error_control : FOR '(' ')' bloque_for",
"incr_decr : '+' CTE_INT",
"incr_decr : '-' CTE_INT",
"incr_decr : error_incr_decr",
"error_incr_decr : CTE_INT",
"error_incr_decr : '-' error",
"error_incr_decr : '+' error",
"error_incr_decr : '+' CTE_FLOTANTE",
"error_incr_decr : '-' CTE_FLOTANTE",
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
#line 910 "gramatica.y"

private Lexico lexico;
private ArbolSintactico arbolSintactico;
private String ambito;
private ArrayList<String> lista_variables;
private ArrayList<String> lista_parametros;
private ArrayList<String> lista_parametros_reales;
private Hashtable<String,ArrayList<Parametro>> parametrosFunciones;

public Parser(Lexico lexico)
{
  this.lexico = lexico;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
  this.lista_parametros = new ArrayList<String>();
  this.lista_parametros_reales = new ArrayList<String>();
  this.parametrosFunciones = new Hashtable<>();
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
            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una constante FLOTANTE son signo negativo -> "+flotanteNeg);
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
	else
	    System.out.println("No hay ningun arbol mostrable");
	return "";
}

public ArbolSintactico returnTree(){
	return this.arbolSintactico;
}



#line 771 "y.tab.c"
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
#line 17 "gramatica.y"
{arbolSintactico = yyvsp[-1].arbol;
                            Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-3].sval).setUso("nombrePrograma");
                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detectó un programa con un bloque encerrado entre llaves ");
                            }
break;
case 2:
#line 21 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo programa incorrecto");}
break;
case 3:
#line 24 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de programa");}
break;
case 4:
#line 25 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de apertura de bloque de programa");}
break;
case 5:
#line 26 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la llave de cierre de bloque de programa");}
break;
case 6:
#line 29 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 7:
#line 30 "gramatica.y"
{     if(yyvsp[0].arbol != null){
                                        if (yyvsp[-1].arbol !=null){
                                            AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoBloqueEjecutable(yyvsp[-1].arbol,yyvsp[0].arbol,atributos);
                                    }else{
                                         AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutable");
                                         atributos.setAmbito(ambito);
                                         yyval.arbol = new NodoBloqueEjecutable(yyvsp[0].arbol,yyvsp[-1].arbol,atributos);
                                    }
                                }
                           }
break;
case 9:
#line 45 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " no es una sentencia válida");}
break;
case 10:
#line 48 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 11:
#line 49 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 12:
#line 52 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 13:
#line 53 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableFor");
                                                               atributos.setAmbito(ambito);
                                                               yyval.arbol = new NodoBloqueEjecutable(yyvsp[-1].arbol,yyvsp[0].arbol,atributos);}
break;
case 14:
#line 58 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 15:
#line 59 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("BloqueEjecutableIf");
                                                      atributos.setAmbito(ambito);
                                                      yyval.arbol = new NodoBloqueEjecutable(yyvsp[-1].arbol,yyvsp[0].arbol,atributos);}
break;
case 16:
#line 65 "gramatica.y"
{  String tipoVar = yyvsp[-2].sval;
					                        lista_variables = (ArrayList<String>)yyvsp[-1].obj;
                                            for(String lexema : lista_variables){
                                                    String nuevoLexema = lexema + "." + ambito;
                                                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                                                        Main.tablaDeSimbolos.modificarSimbolo(lexema, nuevoLexema);
                                                        AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                                                        atributosT.setTipo(tipoVar);
                                                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                                                    } else {
                                                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea+ " la variable " + lexema + " ya fue declarada en este ambito");
                                                        Main.tablaDeSimbolos.eliminarSimbolo(lexema);
                                                        }
                                                }
                                            lista_variables.clear();
                                            }
break;
case 17:
#line 81 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 19:
#line 85 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la declaracion de variables");}
break;
case 20:
#line 86 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo de la variable en la declaracion");}
break;
case 21:
#line 87 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador de la variable en la declaracion");}
break;
case 22:
#line 90 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo el identificador -> " + yyvsp[0].sval);
                        lista_variables.add(yyvsp[0].sval);
                        Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval).setUso("Variable");
                        yyval = new ParserVal(lista_variables);
                                }
break;
case 23:
#line 95 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyo una lista de variables ");
      		                                    Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval).setUso("Variable");
                                                lista_variables = (ArrayList<String>) yyvsp[-2].obj;
                                                lista_variables.add(yyvsp[0].sval);
                                                yyval = new ParserVal(lista_variables);
                                                }
break;
case 25:
#line 104 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ',' entre identificadores de variables");}
break;
case 26:
#line 105 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador antes de la coma");}
break;
case 27:
#line 106 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador despues de la coma");}
break;
case 28:
#line 109 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se declaro una funcion de forma correcta");
								        Main.listaDeAmbitos.add(ambito);
								        yyval.arbol = yyvsp[-1].arbol;
								        if(!ambito.equals("main")){
                                        	ambito = ambito.substring(0,ambito.lastIndexOf("."));
                                        }
                            }
break;
case 30:
#line 119 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de apertura al bloque de sentencias de la funcion");}
break;
case 31:
#line 120 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta llave de cierre al bloque de sentencias de la funcion");}
break;
case 32:
#line 121 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque de sentencias de la funcion");}
break;
case 33:
#line 124 "gramatica.y"
{
                    String nuevoLexema = yyvsp[-3].sval + "." + ambito;
                    if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaDeSimbolos.modificarSimbolo(yyvsp[-3].sval, nuevoLexema);
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                        atributos.setAmbito(ambito);
                        atributos.setUso("nombreFuncion");
                        atributos.setTipo(yyvsp[0].sval);
                        atributos.setListaDeParametros(lista_parametros);
                        Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema, atributos);
                        if(!lista_parametros.isEmpty()){
                            int posicion = 1;
                            for(String parametro : lista_parametros){
                                Main.tablaDeSimbolos.getAtributosTablaS(parametro).setOrden(posicion);
                                posicion++;
                            }
                        }

                        ArrayList<Parametro> parametros_actuales = new ArrayList<>();
                        for(String p: lista_parametros){
                            String idParametro = p;
                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(p).getTipo();
                            Parametro param = new Parametro(tipoId,idParametro);
                            parametros_actuales.add(param);
                        }
                        parametrosFunciones.put(nuevoLexema,parametros_actuales);

                        Main.informesSemanticos.add("[Parser | Linea " + Lexico.linea + "] se detectó una funcion declarada con nombre "+yyvsp[-3].sval+ " en el ámbito "+ambito+", con tipo de retorno " + Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema).getTipo());
                    } else {
                        Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " la funcion "+ yyvsp[-3].sval + " ya fue declarada en este ambito");
                        }
                    ambito = ambito + "."+ yyvsp[-3].sval;
                    }
break;
case 35:
#line 160 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada fun en la declaracion");}
break;
case 36:
#line 161 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta identificador de funcion en la declaracion");}
break;
case 37:
#line 162 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta lista de parametros de funcion en la declaracion");}
break;
case 38:
#line 163 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo al tipo que devuelve la funcion en la declaracion");}
break;
case 39:
#line 164 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo que devuelve la funcion en la declaracion");}
break;
case 40:
#line 167 "gramatica.y"
{lista_parametros.clear();}
break;
case 41:
#line 168 "gramatica.y"
{lista_parametros.clear();
                                      lista_parametros.add(yyvsp[-1].sval);}
break;
case 42:
#line 170 "gramatica.y"
{lista_parametros.clear();
                                                      if(!yyvsp[-3].sval.equals(yyvsp[-1].sval)){
                                                        lista_parametros.add(yyvsp[-3].sval);
                                                        lista_parametros.add(yyvsp[-1].sval);
                                                      } else
                                                            Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea + " no puede haber dos parametros con el mismo ID");
                                                      }
break;
case 44:
#line 180 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de apertura de lista de parametros");}
break;
case 45:
#line 181 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta parentesis de cierre de lista de parametros");}
break;
case 46:
#line 182 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " el número máximo de parámetros permitidos es 2");}
break;
case 47:
#line 185 "gramatica.y"
{String nuevoAmbitoId = yyvsp[0].sval +"."+ambito;
                    Main.tablaDeSimbolos.modificarSimbolo(yyvsp[0].sval,nuevoAmbitoId);
                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(nuevoAmbitoId);
                    atributos.setTipo(yyvsp[-1].sval);
                    atributos.setUso("nombreParametro");
                    Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoAmbitoId, atributos);
                    yyval = new ParserVal(nuevoAmbitoId);}
break;
case 49:
#line 195 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador del parametro");}
break;
case 50:
#line 196 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el tipo del parametro");}
break;
case 51:
#line 199 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo INT LARGO I32");
            yyval = new ParserVal ("i32");}
break;
case 52:
#line 201 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyó un tipo FLOAT F32");
            yyval = new ParserVal ("f32");}
break;
case 53:
#line 205 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 54:
#line 206 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
	                                if(yyvsp[-1].arbol != null){
	                                    AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
	                                    lexDiscard.setAmbito(ambito);
	                                    yyval.arbol = new NodoBloqueEjecutable(yyvsp[-1].arbol,null,lexDiscard);
	                                }
	                                }
break;
case 55:
#line 213 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 56:
#line 214 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 57:
#line 215 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 58:
#line 216 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 59:
#line 217 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                        AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                        sentenciaBreak.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 60:
#line 221 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                          AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                          sentenciaContinue.setAmbito(ambito);
                        yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 61:
#line 225 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-1].sval,ambito);
                                  if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                      Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +yyvsp[-3].sval);
                                      AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                      AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                      lexEtiqueta.setAmbito(ambito);
                                      yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                              }else
                                  Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+yyvsp[-1].sval+"' en algun ambito alcanzable");
                       }
break;
case 63:
#line 238 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 64:
#line 239 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 65:
#line 240 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 66:
#line 241 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 67:
#line 242 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 68:
#line 243 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 69:
#line 244 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 70:
#line 245 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 71:
#line 248 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 72:
#line 249 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(yyvsp[-1].arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               lexDiscard.setAmbito(ambito);
                                               yyval.arbol = new NodoBloqueEjecutable(yyvsp[-1].arbol,null,lexDiscard);
                                           }
                                           }
break;
case 73:
#line 256 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;
                                  yyval.sval = yyvsp[-1].sval;}
break;
case 74:
#line 258 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 75:
#line 259 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 76:
#line 260 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              sentenciaBreak.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 77:
#line 264 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                                sentenciaContinue.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 78:
#line 268 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-1].sval,ambito);
                                        if((ambitoCheck != null) && (Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getUso().equals("nombreEtiqueta"))){
                                        Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control con etiqueta: " +yyvsp[-3].sval);
                                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                        AtributosTablaS lexEtiqueta = new AtributosTablaS("continue con etiquetado");
                                        lexEtiqueta.setAmbito(ambito);
                                        yyval.arbol = new NodoContinueBreak(new NodoHoja(lexEtiqueta),new NodoHoja(atributos),lexEtiqueta);
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite una sentencia de control etiquetada con '"+yyvsp[-1].sval+"' en algun ambito alcanzable");
                             }
break;
case 80:
#line 281 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-1].sval,ambito);
                                                String usoFactor = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-1].sval).getUso();
                                                String tipoFactor = null;
                                                AtributosTablaS retornoAsignable = null;
                                                if(ambitoCheck != null || usoFactor.equals("constante")){
                                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK acompañada de un valor de retorno");
                                                    if(ambitoCheck != null){
                                                         tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                                         retornoAsignable = new AtributosTablaS(ambitoCheck);
                                                    }
                                                    else{
                                                        tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-1].sval).getTipo();
                                                        retornoAsignable = new AtributosTablaS(yyvsp[-1].sval);
                                                    }
                                                    AtributosTablaS ats = new AtributosTablaS("break retorno");
                                                    ats.setAmbito(ambito);
                                                    ats.setTipo(tipoFactor);
                                                    retornoAsignable.setTipo(tipoFactor);
                                                    retornoAsignable.setAmbito(ambito);
                                                    yyval.arbol = new NodoContinueBreak(new NodoHoja(retornoAsignable),null,ats);
                                                    yyval.sval = tipoFactor;
                                                }
                                                else
                                                    if(ambitoCheck == null){
                                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite la variable "+ yyvsp[-1].sval +" para poder retornarla");
                                                        yyval.arbol = null;
                                                    }
                                                }
break;
case 81:
#line 309 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-1].sval,ambito);
                                         String usoFactor = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-1].sval).getUso();
                                         String tipoFactor = null;
                                         AtributosTablaS retornoAsignable = null;
                                         if(ambitoCheck != null || usoFactor.equals("constante")){
                                             Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto un valor de retorno por defecto");
                                             if(ambitoCheck != null){
                                                  tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                                  retornoAsignable = new AtributosTablaS(ambitoCheck);
                                             }
                                             else{
                                                 tipoFactor = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-1].sval).getTipo();
                                                 retornoAsignable = new AtributosTablaS(yyvsp[-1].sval);
                                             }
                                             AtributosTablaS ats = new AtributosTablaS("valor por defecto");
                                             ats.setTipo(tipoFactor);
                                             ats.setAmbito(ambito);
                                             retornoAsignable.setTipo(tipoFactor);
                                             retornoAsignable.setAmbito(ambito);
                                             yyval.arbol = new NodoContinueBreak(new NodoHoja(retornoAsignable),null,ats);
                                             yyval.sval = tipoFactor;
                                         }
                                         else
                                             if(ambitoCheck == null){
                                                 Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no exite la variable "+ yyvsp[-1].sval +" para poder retornarla");
                                                 yyval.arbol = null;
                                             }
                                         }
break;
case 82:
#line 339 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' o valor a retornar al final de la sentencia BREAK");}
break;
case 83:
#line 340 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 84:
#line 341 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 85:
#line 342 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 86:
#line 343 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 87:
#line 346 "gramatica.y"
{  String nuevoLexema = yyvsp[-1].sval + "." + ambito;
                     if(!Main.tablaDeSimbolos.existeLexema(nuevoLexema)){
                         Main.tablaDeSimbolos.modificarSimbolo(yyvsp[-1].sval, nuevoLexema);
                         AtributosTablaS atributosT = Main.tablaDeSimbolos.getAtributosTablaS(nuevoLexema);
                         atributosT.setUso("nombreEtiqueta");
                         Main.tablaDeSimbolos.setAtributosDeSimbolo(nuevoLexema,atributosT);
                         yyval = new ParserVal(nuevoLexema);
                     } else {
                         Main.erroresSemanticos.add("Error semántico: Linea " + Lexico.linea+ " la etiqueta " + yyvsp[-1].sval + " ya fue declarada en este ambito");
                         Main.tablaDeSimbolos.eliminarSimbolo(yyvsp[-1].sval);
                         }
                     }
break;
case 88:
#line 359 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-2].sval,ambito);
                                                if(ambitoCheck != null){
                                                    if (yyvsp[0].arbol!=null){
                                                        Main.tablaDeSimbolos.eliminarSimbolo(yyvsp[-2].sval);
                                                        AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                        atributosId.setAmbito(ambito);
                                                        Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                        AtributosTablaS atributos = new AtributosTablaS("Asignacion");
                                                        atributos.setAmbito(ambito);
                                                        NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),yyvsp[0].arbol,atributos);
                                                    if (nodoA.getTipo()!=null){
                                                        yyval.arbol= nodoA;
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                                    }
                                                }
                                                }else
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+yyvsp[-2].sval);
                                                }
break;
case 89:
#line 380 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-3].sval,ambito);
                                    System.out.println("arbol control "+yyvsp[-1].arbol +", arbol else: "+ yyvsp[0].arbol);
                                    if(ambitoCheck != null){
                                        if (yyvsp[-1].arbol!=null && yyvsp[0].arbol!=null){
                                           Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                           Main.tablaDeSimbolos.eliminarSimbolo(yyvsp[-3].sval);
                                           AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                           atributosId.setAmbito(ambito);
                                           Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                           AtributosTablaS atributos = new AtributosTablaS("AsignacionConControl");
                                           atributos.setAmbito(ambito);
                                           atributos.setTipo(yyvsp[-1].sval);
                                           AtributosTablaS atributos2 = new AtributosTablaS("Control con retorno");
                                           atributos2.setAmbito(ambito);
                                           atributos2.setTipo(yyvsp[-1].sval);
                                           NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),new NodoBloqueEjecutable(yyvsp[-1].arbol,yyvsp[0].arbol,atributos2),atributos);
                                           if (nodoA.getTipo()!=null){
                                               yyval.arbol= nodoA;
                                           }
                                           else{
                                               Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                           }
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+yyvsp[-3].sval);
                                   }
                                   }
break;
case 91:
#line 409 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 92:
#line 410 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 93:
#line 411 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 94:
#line 412 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 95:
#line 413 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 96:
#line 416 "gramatica.y"
{ if(Main.tablaDeSimbolos.getTipoFuncionDeRetorno(ambito,yyvsp[0].sval)){
                                            AtributosTablaS retorno = new AtributosTablaS("RETURN");
                                            retorno.setAmbito(ambito);
                                            yyval.arbol = new NodoRetorno(yyvsp[0].arbol,null,retorno);
                                        }
                                        else{
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el tipo que se quiere retornar no coincide con el de la funcion ");
                                            yyval.arbol = null;
                                        }
                                      }
break;
case 98:
#line 429 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 99:
#line 432 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;
                               yyval.sval = yyvsp[0].sval;
                               }
break;
case 100:
#line 435 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 atributos.setAmbito(ambito);
	                 	                                 yyval.arbol = new NodoSuma(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                 	                                 yyval.sval = yyvsp[0].sval;
	                 	                                 }
break;
case 101:
#line 442 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              atributos.setAmbito(ambito);
	                 	                 	              yyval.arbol = new NodoResta(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                 	                 	              yyval.sval = yyvsp[0].sval;
	                                                    }
break;
case 103:
#line 451 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 104:
#line 452 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 105:
#line 455 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoMultiplicacion(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                          yyval.sval = yyvsp[0].sval;
                             }
break;
case 106:
#line 461 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoDivision(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                          yyval.sval = yyvsp[0].sval;
	                          }
break;
case 107:
#line 467 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 109:
#line 471 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 110:
#line 472 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 111:
#line 473 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 112:
#line 474 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 113:
#line 477 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[0].sval,ambito);
              if(ambitoCheck != null){
                  AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                  Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                  String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                  atributos.setTipo(tipoId);
                  atributos.setAmbito(ambito);
                  yyval.arbol = new NodoHoja(atributos);
                  yyval.sval = tipoId;
              }
              else{
                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+yyvsp[0].sval);
                    yyval.arbol = null;
                    }
              }
break;
case 114:
#line 492 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                         yyval.sval = "f32";
                       }
break;
case 115:
#line 497 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                        atributos.setTipo("i32");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                        yyval.sval = "i32";
                        }
                   }
break;
case 116:
#line 505 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval+"."+ambito);
                      atributosId.setAmbito(ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 117:
#line 510 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                       atributos.setAmbito(ambito);
                       yyval.arbol = new NodoHoja(atributos);
                       yyval.sval = "i32";
                       }
                      }
break;
case 118:
#line 517 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                               atributos.setAmbito(ambito);
                               yyval.arbol = new NodoHoja(atributos);
                               yyval.sval = "f32";
                               }
                           }
break;
case 119:
#line 526 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-3].sval,ambito);
                                            boolean recursionCheck = Main.tablaDeSimbolos.chequearRecursionFuncion(yyvsp[-3].sval,ambito);
                                            if((ambitoCheck != null) && (recursionCheck)){
                                                if (yyvsp[-1].arbol !=null){
                                                    ArrayList<Parametro> parametros_funcion_actual = new ArrayList<>();
                                                    parametros_funcion_actual.addAll(parametrosFunciones.get(ambitoCheck));
                                                    if(parametros_funcion_actual.size() == lista_parametros_reales.size()){
                                                        int pos = 0;
                                                        int nroDeNoCoincidencias = 0;
                                                        for(String paramR : lista_parametros_reales){
                                                            String tipoParamR = Main.tablaDeSimbolos.getAtributosTablaS(paramR).getTipo();
                                                            String tipoParam = parametros_funcion_actual.get(pos).getTipo();
                                                            if(!tipoParamR.equals(tipoParam))
                                                                nroDeNoCoincidencias++;
                                                            pos++;
                                                        }
                                                        if(nroDeNoCoincidencias == 0){
                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-3].sval);
                                                            AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion");
                                                            lexInvocacion.setAmbito(ambito);
                                                            AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                            yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),yyvsp[-1].arbol,lexInvocacion);
                                                        }
                                                        else{
                                                            Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] el tipo de los parametros invocados no coinciden con los de la funcion a invocar");
                                                            yyval.arbol = null;
                                                        }
                                                    }
                                                    else{
                                                        Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] se quiere invocar a una funcion con un numero incorrecto de parametros ");
                                                        yyval.arbol = null;
                                                    }
                                                }
                                            }
                                            else
                                                Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] error de invocacion de la funcion " + yyvsp[-3].sval +  ", ya sea porque no existe o porque se esta autoinvocando ");
                                            }
break;
case 120:
#line 563 "gramatica.y"
{  String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-2].sval,ambito);
                            if(ambitoCheck != null){
                                if(lista_parametros.size() == lista_parametros_reales.size()){
                                    Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco la funcion -> " + yyvsp[-2].sval);
                                    AtributosTablaS lexInvocacion = new AtributosTablaS("Invocacion sin parametros");
                                    AtributosTablaS lexID = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-2].sval+"."+ambito);
                                    yyval.arbol = new NodoInvocacion(new NodoHoja(lexID),null,lexInvocacion);
                                }
                                else
                                    Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] flatan el/los parametros en la invocacion ");
                            }
                            else
                              Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] no existe una funcion con ese nombre en este ambito ");
                         }
break;
case 122:
#line 580 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 123:
#line 581 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 124:
#line 584 "gramatica.y"
{ if(yyvsp[0].arbol !=null){
                                            AtributosTablaS lexParam = new AtributosTablaS("Un Parametro");
                                            lista_parametros_reales.clear();
                                            lista_parametros_reales.add(yyvsp[0].sval);
                                            lexParam.setParametroEnLista(yyvsp[0].sval);
                                            yyval.arbol = new NodoParam(yyvsp[0].arbol,null,lexParam);
                                        }
                                        else
                                            yyval.arbol = null;
                                        }
break;
case 125:
#line 594 "gramatica.y"
{ if(yyvsp[-2].arbol !=null && yyvsp[0].arbol!=null){
                                                                    AtributosTablaS lexParam = new AtributosTablaS("Dos Parametros");
                                                                    lexParam.setParametroEnLista(yyvsp[-2].sval);
                                                                    lexParam.setParametroEnLista(yyvsp[0].sval);
                                                                    lista_parametros_reales.clear();
                                                                    lista_parametros_reales.add(yyvsp[-2].sval);
                                                                    lista_parametros_reales.add(yyvsp[0].sval);
                                                                    yyval.arbol = new NodoParam(yyvsp[-2].arbol,yyvsp[0].arbol,lexParam);
                                                               }else
                                                                    yyval.arbol = null;
                                                               }
break;
case 127:
#line 609 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 128:
#line 610 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 129:
#line 611 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 130:
#line 614 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[0].sval,ambito);
                      if(ambitoCheck != null){
                          AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval+"."+ambito);
                          atributos.setAmbito(ambito);
                          String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                          atributos.setTipo(tipoId);
                          Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                          yyval.arbol = new NodoHoja(atributos);
                          yyval.sval = yyvsp[0].sval;
                          }else{
                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+yyvsp[0].sval);
                            yyval.arbol = null;
                          }
                          }
break;
case 131:
#line 628 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + yyvsp[0].sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoHoja(atributos);
                                    yyval.sval = yyvsp[0].sval;
                                   }
break;
case 132:
#line 634 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + yyvsp[0].sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                                   atributos.setAmbito(ambito);
                                   yyval.arbol = new NodoHoja(atributos);
                                   yyval.sval = yyvsp[0].sval;
                               }
                               }
break;
case 133:
#line 642 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = yyvsp[0].sval;
                                            }
                                  }
break;
case 134:
#line 649 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = yyvsp[0].sval;
                                            }
                                       }
break;
case 135:
#line 657 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoIf(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
                                            yyval.sval = yyvsp[0].sval;}
break;
case 137:
#line 665 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 138:
#line 666 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 139:
#line 667 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 140:
#line 668 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 141:
#line 669 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 142:
#line 672 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoCuerpoIf(yyvsp[-1].arbol,null,atributos);
                                    yyval.sval = yyvsp[-1].sval;
                                    }
break;
case 143:
#line 677 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoIf(yyvsp[-2].arbol,yyvsp[-1].arbol,atributos);
                                                 yyval.sval = yyvsp[-1].sval;
                                                }
break;
case 145:
#line 685 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 146:
#line 686 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 147:
#line 687 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 148:
#line 691 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoCuerpoThen(yyvsp[0].arbol,null,atributos);}
break;
case 149:
#line 694 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          atributos.setAmbito(ambito);
                                          yyval.arbol = new NodoCuerpoThen(yyvsp[-1].arbol,null,atributos);}
break;
case 150:
#line 697 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                atributos.setAmbito(ambito);
                                atributos.setTipo(yyvsp[0].sval);
                                System.out.println("Tipo breakConRetorno dentro de then" + yyvsp[0].sval);
                                yyval.arbol = new NodoCuerpoThen(yyvsp[0].arbol,null,atributos);
                                yyval.sval = yyvsp[0].sval;}
break;
case 152:
#line 706 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             atributos.setAmbito(ambito);
                             yyval.arbol = new NodoCuerpoElse(yyvsp[0].arbol,null,atributos);}
break;
case 153:
#line 709 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoElse(yyvsp[-1].arbol,null,atributos);}
break;
case 154:
#line 712 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                     atributos.setAmbito(ambito);
                                     atributos.setTipo(yyvsp[0].sval);
                                     yyval.arbol = new NodoCuerpoElse(yyvsp[0].arbol,null,atributos);
                                     yyval.sval = yyvsp[0].sval;}
break;
case 156:
#line 720 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 157:
#line 721 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 158:
#line 724 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 159:
#line 725 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 160:
#line 726 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 161:
#line 729 "gramatica.y"
{ yyval.arbol = yyvsp[0].arbol;
                                System.out.println("Tipo ejecucion_control: " +yyvsp[0].sval);
                                yyval.sval = yyvsp[0].sval;}
break;
case 162:
#line 732 "gramatica.y"
{yyval.sval = yyvsp[-1].sval;
                                            System.out.println("Tipo bloque_ejecutable_for: " +yyvsp[-1].sval);
                                            yyval.arbol = yyvsp[-1].arbol;}
break;
case 164:
#line 738 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 165:
#line 739 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 166:
#line 743 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  atributos.setAmbito(ambito);
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(yyvsp[-1].sval);
                                                                  atributos2.setAmbito(ambito);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(yyvsp[-2].arbol,yyvsp[0].arbol,atributos2),null,atributos);}
break;
case 168:
#line 751 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 169:
#line 752 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 170:
#line 753 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 171:
#line 756 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 172:
#line 757 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 173:
#line 758 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 174:
#line 759 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 175:
#line 760 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 176:
#line 761 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 177:
#line 764 "gramatica.y"
{if((yyvsp[-6].arbol != null)&&(yyvsp[-4].arbol != null)&&(yyvsp[-2].arbol != null)){
                                                                                            Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                            AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                            lexSentenciaFor.setAmbito(ambito);
                                                                                            lexSentenciaFor.setTipo(yyvsp[0].sval);
                                                                                            AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                            lexCuerpoFor.setAmbito(ambito);
                                                                                            AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                            lexEncabezadoFor.setAmbito(ambito);
                                                                                            ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor(yyvsp[0].arbol,null,lexCuerpoFor);
                                                                                            String IdAIncrementar = yyvsp[-6].arbol.getHijoIzq().getLexema();
                                                                                            yyvsp[-4].arbol.getHijoIzq().setId(IdAIncrementar);
                                                                                            yyvsp[-2].arbol.setId(IdAIncrementar);
                                                                                            ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor(yyvsp[-6].arbol,yyvsp[-4].arbol,lexEncabezadoFor),yyvsp[-2].arbol,lexEncabezadoFor);
                                                                                            yyval.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                            System.out.println("Tipo bloque_for: " +yyvsp[0].sval);
                                                                                            yyval.sval = yyvsp[0].sval;
                                                                                          }
                                                                                          else
                                                                                              yyval.arbol = null;
                                                                                        }
break;
case 178:
#line 785 "gramatica.y"
{if((yyvsp[-6].arbol != null)&&(yyvsp[-4].arbol != null)&&(yyvsp[-2].arbol != null)){
                                                                                  Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control FOR");
                                                                                  AtributosTablaS lexSentenciaFor = new AtributosTablaS("Sentencia FOR");
                                                                                  lexSentenciaFor.setAmbito(ambito);
                                                                                  AtributosTablaS lexCuerpoFor = new AtributosTablaS("Cuerpo FOR");
                                                                                  lexCuerpoFor.setAmbito(ambito);
                                                                                  AtributosTablaS lexEncabezadoFor = new AtributosTablaS("Encabezado FOR");
                                                                                  lexEncabezadoFor.setAmbito(ambito);
                                                                                  ArbolSintactico nodoCuerpoFor = new NodoCuerpoFor(yyvsp[0].arbol,null,lexCuerpoFor);
                                                                                  String IdAIncrementar = yyvsp[-6].arbol.getHijoIzq().getLexema();
                                                                                  yyvsp[-6].arbol.setId(yyvsp[-9].sval);
                                                                                  yyvsp[-4].arbol.getHijoIzq().setId(IdAIncrementar);
                                                                                  yyvsp[-2].arbol.setId(IdAIncrementar);
                                                                                  ArbolSintactico encabezadoFor = new NodoEncabezadoFor(new NodoEncabezadoFor(yyvsp[-6].arbol,yyvsp[-4].arbol,lexEncabezadoFor),yyvsp[-2].arbol,lexEncabezadoFor);
                                                                                  yyval.arbol = new NodoFor(encabezadoFor,nodoCuerpoFor,lexSentenciaFor);
                                                                                }
                                                                                else
                                                                                    yyval.arbol = null;
                                                                              }
break;
case 179:
#line 804 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 180:
#line 807 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 181:
#line 810 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval)), null, atributos1);}
break;
case 182:
#line 814 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval)), null, atributos1);}
break;
case 183:
#line 818 "gramatica.y"
{ yyval.arbol = null;}
break;
case 184:
#line 821 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 185:
#line 822 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 186:
#line 823 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 187:
#line 824 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
break;
case 188:
#line 825 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
break;
case 189:
#line 828 "gramatica.y"
{ String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-2].sval,ambito);
                                        if(ambitoCheck != null){
                                            String tipoId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).getTipo();
                                            if(tipoId.equals("i32")){
                                                if (chequearRangoEnteros()==true){
                                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-2].sval+"."+ambito);
                                                    atributos.setAmbito(ambito);
                                                    Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                    AtributosTablaS atributos2 = new AtributosTablaS("Asignacion FOR");
                                                    atributos2.setAmbito(ambito);
                                                    AtributosTablaS atributos3 = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                                                    atributos3.setAmbito(ambito);
                                                    NodoAsignacionFor nodoA = new NodoAsignacionFor(new NodoHoja(atributos),new NodoHoja(atributos3),atributos2);
                                                    if (nodoA.getTipo()!=null){
                                                        yyval.arbol= nodoA;
                                                    }else{
                                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " asignacion con tipo incompatibles ");
                                                        yyval.arbol= null;
                                                    }
                                                }
                                                else{
                                                    Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero a asignar esta fuera de rango");
                                                    yyval.arbol= null;
                                                }
                                            }
                                            else{
                                                Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el tipo declarado para el id es incorrecto");
                                                yyval.arbol= null;
                                            }
                                        }
                                        else{
                                            Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+yyvsp[-2].sval);
                                            yyval.arbol= null;
                                        }
                                        }
break;
case 191:
#line 866 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 192:
#line 867 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 193:
#line 868 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 194:
#line 871 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-2].sval,ambito);
                                                   if(ambitoCheck != null){
                                                       Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                                       AtributosTablaS atributos = new AtributosTablaS("CondicionFOR");
                                                       atributos.setAmbito(ambito);
                                                       AtributosTablaS atributos2 = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                                       atributos2.setAmbito(ambito);
                                                       AtributosTablaS atributos3 = new AtributosTablaS(yyvsp[-1].sval);
                                                       atributos3.setAmbito(ambito);
                                                       yyval.arbol = new NodoCondicionFor(new NodoComparacionFor(new NodoHoja(atributos2),yyvsp[0].arbol,atributos3),null,atributos);
                                                   }
                                                   else{
                                                       Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " no existe el id "+ yyvsp[-2].sval +" en ningun ambito alcanzable. Imposible determinar rango de control");
                                                       yyval.arbol = null;
                                                   }
                                                   }
break;
case 196:
#line 890 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 197:
#line 891 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 198:
#line 892 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 199:
#line 895 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          lexSalida.setAmbito(ambito);
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-1].sval);
                          lexCadena.setAmbito(ambito);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 201:
#line 905 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 202:
#line 906 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 203:
#line 907 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
#line 2187 "y.tab.c"
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
