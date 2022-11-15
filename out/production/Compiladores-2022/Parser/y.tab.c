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
    6,    6,    6,   29,   29,   29,   29,   29,   29,   29,
   29,    8,    8,    8,    8,    8,    8,    8,    8,    8,
    8,   28,   28,   30,   30,   30,   30,   30,   32,   22,
   22,   22,   34,   34,   34,   34,   34,   25,   25,   35,
   33,   33,   33,   33,   37,   37,   36,   36,   36,   36,
   39,   39,   39,   39,   38,   38,   38,   38,   38,   38,
   23,   23,   23,   41,   41,   40,   40,   40,   42,   42,
   42,   31,   31,   31,   31,   31,   24,   24,   45,   45,
   45,   45,   45,   44,   44,   44,   48,   48,   48,   46,
   46,   46,   46,   47,   47,   47,   47,   49,   49,   50,
   50,   50,   51,   51,   51,   52,   52,   43,   43,   54,
   54,   54,   53,   53,   53,   53,   53,   53,   26,   26,
   26,   58,   57,   57,   57,   59,   59,   59,   59,   59,
   55,   55,   60,   60,   60,   56,   56,   61,   61,   61,
   27,   27,   62,   62,   62,
};
short yylen[] = {                                         2,
    4,    1,    3,    4,    3,    1,    2,    1,    1,    1,
    1,    1,    2,    1,    2,    3,    1,    1,    3,    2,
    2,    1,    3,    1,    2,    2,    3,    4,    1,    3,
    4,    3,    5,    1,    4,    4,    4,    4,    5,    2,
    3,    5,    1,    2,    2,    7,    2,    1,    1,    2,
    1,    1,    2,    3,    2,    2,    2,    2,    2,    2,
    4,    1,    1,    2,    2,    2,    2,    2,    2,    3,
    2,    2,    3,    2,    2,    2,    1,    2,    2,    4,
    1,    3,    2,    2,    2,    3,    3,    4,    2,    3,
    3,    1,    3,    3,    3,    2,    2,    2,    1,    1,
    1,    3,    3,    1,    3,    3,    3,    3,    1,    1,
    3,    3,    2,    2,    1,    1,    1,    1,    2,    2,
    4,    3,    1,    4,    3,    1,    3,    1,    2,    5,
    7,    1,    1,    1,    2,    2,    5,    1,    4,    4,
    4,    4,    5,    3,    4,    1,    4,    2,    3,    1,
    3,    1,    1,    2,    4,    2,    1,    2,    2,    3,
    3,    3,    1,    3,    1,    2,    2,    3,    1,    2,
    2,    2,    1,    1,    1,    1,    1,    1,    9,   10,
    1,    4,    2,    2,    1,    1,    2,    2,    2,    2,
    3,    1,    2,    2,    2,    3,    1,    2,    2,    2,
    4,    1,    3,    3,    3,
};
short yydefred[] = {                                      0,
    0,    0,    0,    2,    0,    0,    9,    0,  134,  133,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   52,
   51,    0,    0,    0,    0,    6,    8,   10,   11,    0,
    0,   17,   18,   24,    0,   29,   34,    0,    0,    0,
    0,    0,    0,   62,   63,    0,    0,   92,   99,  123,
  138,  181,  202,    0,    0,    0,    0,   89,    0,    0,
    0,    0,   43,   48,    0,  117,  116,    0,    0,    0,
  118,   97,    0,    0,  104,  109,  110,    0,  177,  176,
  178,    0,  173,  174,  175,    0,    0,    0,  169,    0,
    0,    0,    0,    0,    0,    0,  132,   59,    0,    0,
   69,    0,    0,   60,    0,   26,    0,  135,  136,    3,
    7,   22,   21,    0,   25,   20,    0,    0,    0,   64,
   53,   71,   65,   55,   68,   56,   66,   57,   67,   58,
   83,    0,    4,    1,    0,   94,    0,   95,   91,    0,
    0,    0,    0,    0,    0,  128,   47,    0,   44,    0,
  119,  120,  113,  114,    0,    0,    0,    0,    0,    0,
  172,    0,    0,    0,  203,    0,  204,   50,    0,    0,
   40,    0,   82,   70,   54,    0,    0,    0,    0,  192,
    0,    0,   19,   16,   27,   23,   32,    0,   30,    0,
    0,   41,    0,  129,  124,  121,   35,  125,  122,  105,
    0,  106,    0,  111,  107,  112,  108,    0,    0,  141,
  146,    0,  142,    0,  140,  201,   37,    0,   38,   36,
  194,    0,  193,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   77,   81,  182,  165,    0,   61,
  139,   31,   28,    0,    0,    0,    0,    0,    0,    0,
   62,    0,  153,    0,    0,  137,   39,   33,  191,    0,
   84,   78,    0,   85,    0,   79,    0,    0,   12,  166,
   13,   72,   74,   75,   76,    0,    0,    0,  197,    0,
    0,   42,    0,   14,    0,  158,   15,    0,    0,    0,
  157,  144,    0,   73,   86,    0,   87,  164,    0,    0,
    0,    0,    0,    0,    0,  151,    0,    0,    0,   62,
    0,  147,  145,   88,   80,    0,  186,    0,    0,    0,
  185,    0,   46,    0,    0,  161,  160,  188,  183,  189,
  187,  184,  190,    0,    0,  131,  155,  179,    0,  180,
};
short yydgoto[] = {                                       3,
   25,    4,   26,   27,   28,   29,  229,  230,  250,   30,
   31,   32,   33,   34,   35,   36,   61,   37,   62,   63,
   64,   38,   39,   40,   41,   42,   43,   44,   45,  236,
   46,   47,   86,   48,   49,   74,   75,   76,   77,  145,
   50,  146,   87,  210,   51,  252,  290,  211,  253,  291,
  237,  238,   88,   89,  179,  278,  320,   52,  321,  180,
  279,   53,
};
short yysindex[] = {                                    -89,
  -80,  119,    0,    0,  119,  119,    0,  -22,    0,    0,
  627,  763,  -37,  -18,  900,  480,  -26,   21,  111,    0,
    0, -169,  879,  -67,  140,    0,    0,    0,    0,   -5,
   35,    0,    0,    0,   42,    0,    0,  -34,   58,  -19,
   11,   18,  124,    0,    0,   64, -159,    0,    0,    0,
    0,    0,    0,  162,  185,  648,  496,    0,   26, -130,
   73,   92,    0,    0,    8,    0,    0,  -64,  581,  581,
    0,    0,   29,   54,    0,    0,    0,  103,    0,    0,
    0,  827,    0,    0,    0,  785,  105,  900,    0,  121,
  -35,  -97,  -16,  -13,  115,   29,    0,    0,  120,  103,
    0,  131,   65,    0,  -56,    0,  167,    0,    0,    0,
    0,    0,    0,   93,    0,    0,  -59,   68,  206,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  171,    0,    0,    8,    0,   29,    0,    0,   29,
  -97,    0,   56,  276,  -21,    0,    0,  164,    0,  289,
    0,    0,    0,    0,  100,  750,  243,  334, -198,   10,
    0,  900, -198,   29,    0,  173,    0,    0,  164,  -29,
    0,  164,    0,    0,    0, -226,  -42,  516,  220,    0,
  323, -198,    0,    0,    0,    0,    0,   96,    0, -172,
  -95,    0,  603,    0,    0,    0,    0,    0,    0,    0,
   54,    0,   54,    0,    0,    0,    0,  306,  306,    0,
    0, -183,    0,   29,    0,    0,    0,  197,    0,    0,
    0,  160,    0,  239,  467,  166,  -44,  606,  542,    0,
  386,  388,  393,  409,    0,    0,    0,    0,  869,    0,
    0,    0,    0,  425,   70,  452,  -23,  562,    0,  385,
    0,  -96,    0,  -68,  306,    0,    0,    0,    0,  627,
    0,    0,  432,    0,  438,    0,  107,  584,    0,    0,
    0,    0,    0,    0,    0,  879,  900,  439,    0,  869,
  -95,    0,  603,    0,  406,    0,    0,  427,  562,  236,
    0,    0,  241,    0,    0,  145,    0,    0,   29,  900,
   29,   33,  456,  478,  483,    0,  562,    0,  447,    0,
  471,    0,    0,    0,    0,   29,    0, -102,  -70,  487,
    0,   33,    0,  603,  492,    0,    0,    0,    0,    0,
    0,    0,    0,  516,  488,    0,    0,    0,  516,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,  128,    0,    0,
    0,    0,    0,    0,  146,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  530,    0,    0,    0,    0,  -32,
    0,    0,    0,    0,   79,    0,    0,    0,    0,    0,
    0,    0,  150,  672,    0,    0,    0,  849,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  168,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   48,    0,  303,    0,    0,  304,
  477,  431,    1,  -20,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   15,    0,   24,    0,  348,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  717,    0,  857,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   39,    0,    0,    0,    0,    0,    0,
    0,  481,    0,  485,    0,    0,    0,    0,    0,  341,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    6,  485,    0,  363,    0,
    0,    0,    0,  369,  389,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  410,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   80,    0,    0,    0,    0,    0,
    0,    0,  426,    0,    0,    0,    0,    0,  490,  493,
  494,    0,    0,    0,   19,    0,    0,  249,    0,    0,
    0,    0,    0,    0,    0,  498,    0,    0,    0,    0,
    0,    0,    0,    0,  -36,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   97,    0,  758,    0,    0,  783,  314, -124, -179,    5,
  525,    0,    0,    0,    0,    0,   27,    0,  -57,    0,
    0,  726,   -7,  735,    0,  -11,  759,  742,    0,    0,
  -15,    0,   -4,    0,    0,  338,    0,  -39,    0,    0,
    0,    0,   34,  391,    0,  349,  308,    0,    0,    0,
 -209,    0,  673,    0,  376,  287,  246,    0,    0,    0,
    0,    0,
};
#define YYTABLESIZE 1159
short yytable[] = {                                      72,
   99,  143,   91,   71,   71,  167,   73,   71,   49,  102,
   96,   49,   60,  267,  266,   71,  150,   59,   60,  196,
  126,   94,  162,   94,  121,   49,  289,  171,  218,  153,
  154,  221,  101,    2,   58,   58,  143,  222,   22,  124,
   95,  169,    6,  144,  136,  139,  127,  150,   71,   71,
  212,  137,  140,  113,  289,  171,  107,  208,   45,  130,
  103,   71,   71,   60,  170,   58,  142,  209,  285,  126,
   24,  155,  255,  156,   71,  318,  128,  319,  117,  168,
   71,   23,  209,  164,  176,   22,   24,  106,   50,  115,
  115,  177,  115,  116,  115,  157,  192,   60,   60,  191,
  158,   54,   55,  269,  271,  178,  115,   23,  309,  311,
  282,   22,   24,  281,  132,  160,  122,  205,  207,  170,
  115,  115,  131,  115,  338,  115,  147,  325,  194,  340,
  148,  119,  149,  245,  144,   23,  117,  115,  159,   22,
   24,   69,  150,  271,   68,  163,   70,   71,   71,   71,
   71,  184,  197,  328,   71,  329,  330,  214,   23,  168,
   92,  165,   22,   24,  118,  297,  233,    1,  105,  104,
  288,   22,  172,  217,  219,    5,  220,  246,  173,   23,
   20,   21,  130,   22,   24,  331,   22,  332,  333,  175,
  108,  109,  187,  151,  152,   60,  185,  186,  288,  292,
  181,   23,  159,  315,  100,   22,   24,  182,   96,   99,
  190,  264,  265,  216,  188,  223,  233,  233,  263,  162,
  243,  120,  258,  304,   23,   90,   98,  166,   22,   24,
  100,  162,  260,   56,  195,  126,  123,   92,   93,   92,
   57,   57,   92,   49,   49,   23,   20,   21,  136,   22,
   24,  112,   71,   20,   21,  137,  233,   20,   21,   20,
   21,  127,   20,   21,  110,  208,  125,  305,   71,   71,
  171,  299,  301,  127,  130,  209,   45,   45,  239,  170,
  171,  141,   97,    9,   10,   60,  133,   68,   14,  170,
  317,  115,   71,   14,  168,  316,   58,    7,    8,    9,
   10,   20,   21,  115,  168,   11,   12,  154,  336,  134,
   13,   14,   15,   16,   17,   18,   19,   20,   21,  193,
   24,  176,  233,    7,    8,    9,   10,  233,  177,  199,
  189,   11,   12,   24,  115,  159,   13,   14,   15,   16,
   17,   18,   19,   20,   21,   23,  159,  159,  183,  115,
   24,  242,    8,    9,   10,  200,   78,   66,   67,   11,
   12,   93,   90,  296,   13,   14,   15,   16,   17,   18,
   19,   20,   21,   14,    7,    8,    9,   10,   68,  129,
   12,  240,   11,   12,   22,   12,  174,   13,   14,   15,
   16,   17,   18,   19,   20,   21,    8,    9,   10,  163,
  314,  100,   14,   11,   12,   96,  205,   14,   13,   14,
   15,   16,   17,   18,   19,   20,   21,  259,    8,    9,
   10,  150,  100,   98,   23,   11,   12,  148,  248,   24,
   13,   14,   15,   16,   17,   18,   19,   20,   21,   20,
   21,    8,    9,   10,  272,   23,  273,  143,   11,   12,
   24,  274,  257,   13,   14,   15,   16,   17,   18,   19,
   20,   21,    8,    9,   10,   12,   23,  275,  167,   11,
   12,   24,   20,   21,   13,   14,   15,   16,   17,   18,
   19,   20,   21,  280,  149,  150,   23,   14,   40,  122,
  294,   24,  201,  203,  260,  283,  295,  302,  204,   78,
   66,   67,   57,  312,  154,   14,   14,   14,  313,  286,
   23,   24,   14,   14,  322,   24,  154,   14,  323,   14,
   14,   14,   14,   14,   24,  262,  324,  334,  339,    5,
  306,   23,   97,    9,   10,  125,   24,   69,   98,  195,
   68,  268,   70,  132,  198,   97,    9,   10,  199,  307,
  213,  200,  198,  215,  114,   23,  196,  254,   93,   90,
   24,  293,  247,    9,   10,  244,  303,  335,    0,   11,
   12,  326,  241,    0,   13,    0,   15,   16,   17,   18,
   19,   23,    0,    0,    0,    0,   24,    0,    0,  206,
   78,   66,   67,    0,    0,  327,  163,   12,   12,   12,
    0,   23,  256,  205,   12,   12,   24,    0,    0,   12,
    0,    0,   12,   12,   12,   12,  337,    0,  150,   14,
   14,   14,    0,   23,  148,   68,   14,   14,   24,  150,
  150,   14,    0,   14,   14,   14,   14,   14,  228,    0,
    0,  247,    9,   10,  143,   23,    0,   24,   11,   12,
   24,    0,    0,   13,    0,   15,   16,   17,   18,   19,
    0,    0,  247,    9,   10,  167,  270,    0,   69,   11,
   12,   68,    0,   70,   13,    0,   15,   16,   17,   18,
   19,  149,    0,  247,    9,   10,    0,    0,    0,   69,
   11,   12,   68,    0,   70,   13,    0,   15,   16,   17,
   18,   19,    0,  247,    9,   10,    0,    0,  298,    0,
   11,   12,  101,    0,  101,   13,  101,   15,   16,   17,
   18,   19,  261,   97,    9,   10,    0,  247,    9,   10,
  101,  101,  101,  101,   11,   12,   97,    9,   10,   13,
    0,   15,   16,   17,   18,   19,    0,    0,  247,    9,
   10,  138,   65,   66,   67,   11,   12,  102,  162,  102,
   13,  102,   15,   16,   17,   18,   19,    0,    0,   18,
    0,    0,  224,    9,   10,  102,  102,  102,  102,   11,
   12,    0,  111,    0,   13,    0,    0,  225,  226,   18,
  227,   69,    0,    0,   68,    0,   70,    0,  224,    9,
   10,    0,   82,    0,   69,   11,   12,   68,    0,   70,
   13,  111,  111,  225,  226,   18,  227,    0,  247,    9,
   10,    0,   83,   85,   84,   11,   12,  155,    0,  156,
   13,    0,   15,   16,   17,   18,   19,   78,   66,   67,
  224,    9,   10,    0,   83,   85,   84,   11,   12,    0,
    0,    0,   13,    0,    0,  225,  226,   18,  227,   97,
    9,   10,  224,    9,   10,    0,    0,  159,   69,   11,
   12,   68,    0,   70,   13,    0,  111,  225,  226,   18,
  227,    0,    0,   65,   66,   67,   83,   85,   84,  115,
  115,  115,    0,  115,    0,  115,    0,  103,    0,  103,
   18,  103,    0,  231,  135,   66,   67,  115,  115,  115,
  115,  277,  232,    0,    0,  103,  103,  103,  103,  235,
   69,   18,    0,   68,    0,   70,    0,  101,   83,   85,
   84,  101,  101,  101,    0,    0,  234,  101,   83,   85,
   84,   69,    0,    0,   68,  111,   70,    0,  300,  251,
  251,    0,  277,  231,  231,    0,    0,    0,    0,    0,
    0,    0,  232,  232,    0,    0,    0,    0,    0,  235,
  235,    0,  102,    0,    0,    0,  102,  102,  102,    0,
    0,    0,  102,    0,    0,    0,  234,  234,    0,    0,
  249,  249,    0,  231,    0,    0,  251,    0,    0,    0,
    0,    0,  232,    0,    0,  202,   78,   66,   67,  235,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   78,
   66,   67,   79,   80,   81,    0,  234,    0,    0,  310,
  284,    0,  287,    0,    0,    0,    0,  249,    0,    0,
  161,    0,    0,    0,   79,   80,   81,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  231,
    0,    0,    0,    0,  231,    0,    0,  287,  232,    0,
  308,  284,    0,  232,    0,  235,    0,    0,    0,    0,
  235,    0,    0,   78,   66,   67,   79,   80,   81,  284,
    0,  287,  234,  287,    0,    0,    0,  234,    0,    0,
    0,    0,    0,    0,  115,    0,    0,  287,  115,  115,
  115,    0,  103,    0,  115,    0,  103,  103,  103,    0,
    0,    0,  103,    0,    0,  276,    0,    0,   79,   80,
   81,    0,    0,    0,    0,   78,   66,   67,   79,   80,
   81,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   78,   66,   67,
};
short yycheck[] = {                                      11,
   16,   59,   40,   11,   12,   41,   11,   15,   41,   17,
   15,   44,    8,   58,   59,   23,   40,   40,   14,   41,
   41,   40,   59,   40,   59,   58,  123,   41,   58,   69,
   70,  258,   59,  123,   58,   58,   94,  264,   44,   59,
   14,   58,  123,   59,   56,   57,   41,   40,   56,   57,
   41,   56,   57,   59,  123,   41,   23,  256,   58,   41,
   40,   69,   70,   59,   41,   58,   41,  266,  248,   59,
   45,   43,  256,   45,   82,   43,   59,   45,   44,   41,
   88,   40,  266,   88,  257,   44,   45,  257,   41,   42,
   43,  264,   45,   59,   47,   42,   41,   93,   94,   44,
   47,    5,    6,  228,  229,   41,   59,   40,  288,  289,
   41,   44,   45,   44,  274,   82,   59,  157,  158,   93,
   42,   43,   59,   45,  334,   47,  257,  307,  144,  339,
   58,   35,   41,  191,  150,   40,   44,   59,   59,   44,
   45,   42,   40,  268,   45,   41,   47,  155,  156,  157,
  158,   59,  148,  256,  162,  258,  259,  162,   40,  257,
  256,   41,   44,   45,  123,   59,  178,  257,   58,   59,
  267,   44,   58,  169,  170,  256,  172,  193,   59,   40,
  276,  277,   59,   44,   45,  256,   59,  258,  259,   59,
  258,  259,  125,  258,  259,  191,  256,  257,  267,  268,
  257,   40,  123,   59,   59,   44,   45,   41,   59,  225,
   40,  256,  257,   41,  118,  258,  228,  229,  226,  256,
  125,  256,  218,  281,   40,  263,   59,  263,   44,   45,
  257,  268,  256,  256,  256,  256,  256,  256,  257,  256,
  264,  264,  256,  276,  277,   40,  276,  277,  260,   44,
   45,  257,  260,  276,  277,  260,  268,  276,  277,  276,
  277,  256,  276,  277,  125,  256,  256,  283,  276,  277,
  256,  276,  277,  256,  256,  266,  276,  277,   59,  256,
  266,  256,  257,  258,  259,  281,  125,   45,   40,  266,
  258,  257,  300,   45,  256,  300,   58,  256,  257,  258,
  259,  276,  277,  256,  266,  264,  265,   59,  324,  125,
  269,  270,  271,  272,  273,  274,  275,  276,  277,   44,
   45,  257,  334,  256,  257,  258,  259,  339,  264,   41,
  125,  264,  265,   45,  256,  256,  269,  270,  271,  272,
  273,  274,  275,  276,  277,   40,  267,  268,  256,  257,
   45,  256,  257,  258,  259,  256,  257,  258,  259,  264,
  265,   59,   59,  257,  269,  270,  271,  272,  273,  274,
  275,  276,  277,  125,  256,  257,  258,  259,   45,  256,
   40,   59,  264,  265,  257,   45,  256,  269,  270,  271,
  272,  273,  274,  275,  276,  277,  257,  258,  259,   59,
  256,  256,   40,  264,  265,  256,   59,   45,  269,  270,
  271,  272,  273,  274,  275,  276,  277,  258,  257,  258,
  259,   59,  257,  256,   40,  264,  265,   59,  123,   45,
  269,  270,  271,  272,  273,  274,  275,  276,  277,  276,
  277,  257,  258,  259,   59,   40,   59,   59,  264,  265,
   45,   59,  256,  269,  270,  271,  272,  273,  274,  275,
  276,  277,  257,  258,  259,  125,   40,   59,   59,  264,
  265,   45,  276,  277,  269,  270,  271,  272,  273,  274,
  275,  276,  277,   59,   59,  123,   40,  125,   58,   59,
   59,   45,  155,  156,  256,   44,   59,   59,  256,  257,
  258,  259,  264,  268,  256,  257,  258,  259,  268,  125,
   40,   45,  264,  265,   59,   45,  268,  269,   41,  271,
  272,  273,  274,  275,   45,   59,   44,   41,   41,    0,
  125,   40,  257,  258,  259,   59,   45,   42,   59,   59,
   45,  228,   47,   59,  256,  257,  258,  259,   59,  123,
  160,   59,   59,  163,   30,   40,   59,  209,  256,  256,
   45,  254,  257,  258,  259,  190,  280,  322,   -1,  264,
  265,  125,  182,   -1,  269,   -1,  271,  272,  273,  274,
  275,   40,   -1,   -1,   -1,   -1,   45,   -1,   -1,  256,
  257,  258,  259,   -1,   -1,  125,  256,  257,  258,  259,
   -1,   40,  212,  256,  264,  265,   45,   -1,   -1,  269,
   -1,   -1,  272,  273,  274,  275,  125,   -1,  256,  257,
  258,  259,   -1,   40,  256,   45,  264,  265,   45,  267,
  268,  269,   -1,  271,  272,  273,  274,  275,  123,   -1,
   -1,  257,  258,  259,  256,   40,   -1,   45,  264,  265,
   45,   -1,   -1,  269,   -1,  271,  272,  273,  274,  275,
   -1,   -1,  257,  258,  259,  256,  125,   -1,   42,  264,
  265,   45,   -1,   47,  269,   -1,  271,  272,  273,  274,
  275,  256,   -1,  257,  258,  259,   -1,   -1,   -1,   42,
  264,  265,   45,   -1,   47,  269,   -1,  271,  272,  273,
  274,  275,   -1,  257,  258,  259,   -1,   -1,  125,   -1,
  264,  265,   41,   -1,   43,  269,   45,  271,  272,  273,
  274,  275,  256,  257,  258,  259,   -1,  257,  258,  259,
   59,   60,   61,   62,  264,  265,  257,  258,  259,  269,
   -1,  271,  272,  273,  274,  275,   -1,   -1,  257,  258,
  259,  256,  257,  258,  259,  264,  265,   41,   86,   43,
  269,   45,  271,  272,  273,  274,  275,   -1,   -1,  274,
   -1,   -1,  257,  258,  259,   59,   60,   61,   62,  264,
  265,   -1,   25,   -1,  269,   -1,   -1,  272,  273,  274,
  275,   42,   -1,   -1,   45,   -1,   47,   -1,  257,  258,
  259,   -1,   40,   -1,   42,  264,  265,   45,   -1,   47,
  269,   54,   55,  272,  273,  274,  275,   -1,  257,  258,
  259,   -1,   60,   61,   62,  264,  265,   43,   -1,   45,
  269,   -1,  271,  272,  273,  274,  275,  257,  258,  259,
  257,  258,  259,   -1,   60,   61,   62,  264,  265,   -1,
   -1,   -1,  269,   -1,   -1,  272,  273,  274,  275,  257,
  258,  259,  257,  258,  259,   -1,   -1,   41,   42,  264,
  265,   45,   -1,   47,  269,   -1,  119,  272,  273,  274,
  275,   -1,   -1,  257,  258,  259,   60,   61,   62,   41,
   42,   43,   -1,   45,   -1,   47,   -1,   41,   -1,   43,
  274,   45,   -1,  178,  257,  258,  259,   59,   60,   61,
   62,  239,  178,   -1,   -1,   59,   60,   61,   62,  178,
   42,  274,   -1,   45,   -1,   47,   -1,  256,   60,   61,
   62,  260,  261,  262,   -1,   -1,  178,  266,   60,   61,
   62,   42,   -1,   -1,   45,  188,   47,   -1,  276,  208,
  209,   -1,  280,  228,  229,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  228,  229,   -1,   -1,   -1,   -1,   -1,  228,
  229,   -1,  256,   -1,   -1,   -1,  260,  261,  262,   -1,
   -1,   -1,  266,   -1,   -1,   -1,  228,  229,   -1,   -1,
  208,  209,   -1,  268,   -1,   -1,  255,   -1,   -1,   -1,
   -1,   -1,  268,   -1,   -1,  256,  257,  258,  259,  268,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  257,
  258,  259,  260,  261,  262,   -1,  268,   -1,   -1,  288,
  248,   -1,  250,   -1,   -1,   -1,   -1,  255,   -1,   -1,
  256,   -1,   -1,   -1,  260,  261,  262,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  334,
   -1,   -1,   -1,   -1,  339,   -1,   -1,  285,  334,   -1,
  288,  289,   -1,  339,   -1,  334,   -1,   -1,   -1,   -1,
  339,   -1,   -1,  257,  258,  259,  260,  261,  262,  307,
   -1,  309,  334,  311,   -1,   -1,   -1,  339,   -1,   -1,
   -1,   -1,   -1,   -1,  256,   -1,   -1,  325,  260,  261,
  262,   -1,  256,   -1,  266,   -1,  260,  261,  262,   -1,
   -1,   -1,  266,   -1,   -1,  257,   -1,   -1,  260,  261,
  262,   -1,   -1,   -1,   -1,  257,  258,  259,  260,  261,
  262,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  257,  258,  259,
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
"ejecucion : break_con_retorno",
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
"ejecucion_control : break_con_retorno",
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
#line 912 "gramatica.y"

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



#line 798 "y.tab.c"
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
case 62:
#line 235 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;
                              System.out.println("Tipo BREAK_CON_RETORNO: " +yyvsp[0].sval);
                              yyval.sval = yyvsp[0].sval;}
break;
case 64:
#line 241 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la asignacion");}
break;
case 65:
#line 242 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la seleccion");}
break;
case 66:
#line 243 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia de control");}
break;
case 67:
#line 244 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la impresion");}
break;
case 68:
#line 245 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final del retorno");}
break;
case 69:
#line 246 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la invocacion despues de la palabra discard");}
break;
case 70:
#line 247 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la invocacion");}
break;
case 71:
#line 248 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra discard antes de la invocacion");}
break;
case 72:
#line 251 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 73:
#line 252 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de tipo DISCARD ");
                                           if(yyvsp[-1].arbol != null){
                                               AtributosTablaS lexDiscard = new AtributosTablaS("Discard");
                                               lexDiscard.setAmbito(ambito);
                                               yyval.arbol = new NodoBloqueEjecutable(yyvsp[-1].arbol,null,lexDiscard);
                                           }
                                           }
break;
case 74:
#line 259 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;
                                  yyval.sval = yyvsp[-1].sval;}
break;
case 75:
#line 261 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 76:
#line 262 "gramatica.y"
{yyval.arbol = yyvsp[-1].arbol;}
break;
case 77:
#line 263 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;
                                      System.out.println("Tipo BREAK_CON_RETORNO: " +yyvsp[0].sval);
                                      yyval.sval = yyvsp[0].sval;}
break;
case 78:
#line 266 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable BREAK");
                              AtributosTablaS sentenciaBreak =  new AtributosTablaS("break");
                              sentenciaBreak.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaBreak),null,sentenciaBreak);}
break;
case 79:
#line 270 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto la sentencia ejecutable CONTINUE");
                                AtributosTablaS sentenciaContinue =  new AtributosTablaS("continue");
                                sentenciaContinue.setAmbito(ambito);
                              yyval.arbol = new NodoContinueBreak(new NodoHoja(sentenciaContinue),null,sentenciaContinue);}
break;
case 80:
#line 274 "gramatica.y"
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
case 82:
#line 287 "gramatica.y"
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
case 83:
#line 315 "gramatica.y"
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
case 84:
#line 345 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' o valor a retornar al final de la sentencia BREAK");}
break;
case 85:
#line 346 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 86:
#line 347 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ':' previo a la etiqueta de la sentencia CONTINUE");}
break;
case 87:
#line 348 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la etiqueta en la sentencia CONTINUE");}
break;
case 88:
#line 349 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta ';' al final de la sentencia CONTINUE");}
break;
case 89:
#line 352 "gramatica.y"
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
case 90:
#line 365 "gramatica.y"
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
case 91:
#line 386 "gramatica.y"
{String ambitoCheck = Main.tablaDeSimbolos.chequearAmbito(yyvsp[-2].sval,ambito);
                                    if(ambitoCheck != null){
                                        if (yyvsp[0].arbol!=null){
                                           Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se detecto una sentencia de control utilizada como expresion en una asignacion ");
                                           Main.tablaDeSimbolos.eliminarSimbolo(yyvsp[-2].sval);
                                           AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck);
                                           atributosId.setAmbito(ambito);
                                           Main.tablaDeSimbolos.getAtributosTablaS(ambitoCheck).setUso("Variable");
                                           AtributosTablaS atributos = new AtributosTablaS("AsignacionConControl");
                                           atributos.setAmbito(ambito);
                                           atributos.setTipo(yyvsp[0].sval);
                                           NodoAsignacion nodoA = new NodoAsignacion(new NodoHoja(atributosId),yyvsp[0].arbol,atributos);
                                           if (nodoA.getTipo()!=null){
                                               yyval.arbol= nodoA;
                                           }
                                           else{
                                               Main.erroresSemanticos.add("[Parser | Linea " + Lexico.linea + "] asignacion con tipo incompatibles ");
                                           }
                                    }else
                                        Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " falta la declaracion de "+yyvsp[-2].sval);
                                   }
                                   }
break;
case 93:
#line 411 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 94:
#line 412 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta '=:' en la asignacion");}
break;
case 95:
#line 413 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la asignacion");}
break;
case 96:
#line 414 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 97:
#line 415 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion");}
break;
case 98:
#line 418 "gramatica.y"
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
case 100:
#line 431 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica luego de la palabra reservada RETURN");}
break;
case 101:
#line 434 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;
                               yyval.sval = yyvsp[0].sval;
                               }
break;
case 102:
#line 437 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una suma");
	                 	                                 AtributosTablaS atributos = new AtributosTablaS("+");
	                 	                                 atributos.setAmbito(ambito);
	                 	                                 yyval.arbol = new NodoSuma(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                 	                                 yyval.sval = yyvsp[0].sval;
	                 	                                 }
break;
case 103:
#line 444 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una resta");
	                 	                 	              AtributosTablaS atributos = new AtributosTablaS("-");
	                 	                 	              atributos.setAmbito(ambito);
	                 	                 	              yyval.arbol = new NodoResta(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                 	                 	              yyval.sval = yyvsp[0].sval;
	                                                    }
break;
case 105:
#line 453 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '+' ");}
break;
case 106:
#line 454 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino luego de un '-' ");}
break;
case 107:
#line 457 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");
	                          AtributosTablaS atributos = new AtributosTablaS("*");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoMultiplicacion(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                          yyval.sval = yyvsp[0].sval;
                             }
break;
case 108:
#line 463 "gramatica.y"
{ Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una division");
	                          AtributosTablaS atributos = new AtributosTablaS("/");
	                          atributos.setAmbito(ambito);
	                          yyval.arbol = new NodoDivision(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
	                          yyval.sval = yyvsp[0].sval;
	                          }
break;
case 109:
#line 469 "gramatica.y"
{yyval.arbol = yyvsp[0].arbol;}
break;
case 111:
#line 473 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '*' ");}
break;
case 112:
#line 474 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el factor luego de un '/' ");}
break;
case 113:
#line 475 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '*' ");}
break;
case 114:
#line 476 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el termino antes de un '/' ");}
break;
case 115:
#line 479 "gramatica.y"
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
case 116:
#line 494 "gramatica.y"
{AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                         yyval.sval = "f32";
                       }
break;
case 117:
#line 499 "gramatica.y"
{if (chequearRangoEnteros() == true){
                        AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                        atributos.setTipo("i32");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoHoja(atributos);
                        yyval.sval = "i32";
                        }
                   }
break;
case 118:
#line 507 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se invoco una funcion en una expresion aritmetica");
                      AtributosTablaS atributosId = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval+"."+ambito);
                      atributosId.setAmbito(ambito);
                      yyval.arbol = new NodoHoja(atributosId);
                      }
break;
case 119:
#line 512 "gramatica.y"
{if (chequearNegativos() == true){
                       AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                       atributos.setAmbito(ambito);
                       yyval.arbol = new NodoHoja(atributos);
                       yyval.sval = "i32";
                       }
                      }
break;
case 120:
#line 519 "gramatica.y"
{if (chequearNegativos() ==true){
                               AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                               atributos.setAmbito(ambito);
                               yyval.arbol = new NodoHoja(atributos);
                               yyval.sval = "f32";
                               }
                           }
break;
case 121:
#line 528 "gramatica.y"
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
case 122:
#line 565 "gramatica.y"
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
case 124:
#line 582 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 125:
#line 583 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de cierre de la invocacion ");}
break;
case 126:
#line 586 "gramatica.y"
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
case 127:
#line 596 "gramatica.y"
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
case 129:
#line 611 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una ',' entre los dos parametros reales ");}
break;
case 130:
#line 612 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 131:
#line 613 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el numero maximo de parametros soportados es de dos ");}
break;
case 132:
#line 616 "gramatica.y"
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
case 133:
#line 630 "gramatica.y"
{Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante FLOTANTE -> " + yyvsp[0].sval);
                                    AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoHoja(atributos);
                                    yyval.sval = yyvsp[0].sval;
                                   }
break;
case 134:
#line 636 "gramatica.y"
{if (chequearRangoEnteros() == true) {
                                   Main.informesSintacticos.add("[Lexico | Linea " + Lexico.linea + "] se leyó, dentro de una invocacion, la constante INT LARGA -> " + yyvsp[0].sval);
                                   AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval);
                                   atributos.setAmbito(ambito);
                                   yyval.arbol = new NodoHoja(atributos);
                                   yyval.sval = yyvsp[0].sval;
                               }
                               }
break;
case 135:
#line 644 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = yyvsp[0].sval;
                                            }
                                  }
break;
case 136:
#line 651 "gramatica.y"
{if (chequearNegativos()==true){
                                            AtributosTablaS atributos = Main.tablaDeSimbolos.getAtributosTablaS("-"+yyvsp[0].sval);
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoHoja(atributos);
                                            yyval.sval = yyvsp[0].sval;
                                            }
                                       }
break;
case 137:
#line 659 "gramatica.y"
{Main.informesSintacticos.add("[Parser | linea " + Lexico.linea + "] se leyó una sentencia de seleccion IF");
                                            AtributosTablaS atributos = new AtributosTablaS("IF");
                                            atributos.setAmbito(ambito);
                                            yyval.arbol = new NodoIf(yyvsp[-2].arbol,yyvsp[0].arbol,atributos);
                                            yyval.sval = yyvsp[0].sval;}
break;
case 139:
#line 667 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la palabra reservada IF ");}
break;
case 140:
#line 668 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' de la sentencia IF ");}
break;
case 141:
#line 669 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la condicion de la sentencia IF ");}
break;
case 142:
#line 670 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' de la sentencia IF ");}
break;
case 143:
#line 671 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el bloque ejecutable de la sentencia IF ");}
break;
case 144:
#line 674 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                    atributos.setAmbito(ambito);
                                    yyval.arbol = new NodoCuerpoIf(yyvsp[-1].arbol,null,atributos);
                                    yyval.sval = yyvsp[-1].sval;
                                    }
break;
case 145:
#line 679 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("CuerpoIf");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoIf(yyvsp[-2].arbol,yyvsp[-1].arbol,atributos);
                                                 yyval.sval = yyvsp[-1].sval;
                                                }
break;
case 147:
#line 687 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 148:
#line 688 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 149:
#line 689 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta palabra reservada ENDIF ");}
break;
case 150:
#line 693 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                        atributos.setAmbito(ambito);
                        yyval.arbol = new NodoCuerpoThen(yyvsp[0].arbol,null,atributos);}
break;
case 151:
#line 696 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                          atributos.setAmbito(ambito);
                                          yyval.arbol = new NodoCuerpoThen(yyvsp[-1].arbol,null,atributos);}
break;
case 152:
#line 699 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Then");
                                atributos.setAmbito(ambito);
                                atributos.setTipo(yyvsp[0].sval);
                                System.out.println("Tipo breakConRetorno dentro de then" + yyvsp[0].sval);
                                yyval.arbol = new NodoCuerpoThen(yyvsp[0].arbol,null,atributos);
                                yyval.sval = yyvsp[0].sval;}
break;
case 154:
#line 708 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                             atributos.setAmbito(ambito);
                             yyval.arbol = new NodoCuerpoElse(yyvsp[0].arbol,null,atributos);}
break;
case 155:
#line 711 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                                atributos.setAmbito(ambito);
                                                yyval.arbol = new NodoCuerpoElse(yyvsp[-1].arbol,null,atributos);}
break;
case 156:
#line 714 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Else");
                                     atributos.setAmbito(ambito);
                                     atributos.setTipo(yyvsp[0].sval);
                                     yyval.arbol = new NodoCuerpoThen(yyvsp[0].arbol,null,atributos);
                                     yyval.sval = yyvsp[0].sval;}
break;
case 158:
#line 722 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 159:
#line 723 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 160:
#line 726 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el la palabra reservada ELSE antes de las sentencias ejecutables ");}
break;
case 161:
#line 727 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 162:
#line 728 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 163:
#line 731 "gramatica.y"
{ yyval.arbol = yyvsp[0].arbol;
                                System.out.println("Tipo ejecucion_control: " +yyvsp[0].sval);
                                yyval.sval = yyvsp[0].sval;}
break;
case 164:
#line 734 "gramatica.y"
{yyval.sval = yyvsp[-1].sval;
                                            System.out.println("Tipo bloque_ejecutable_for: " +yyvsp[-1].sval);
                                            yyval.arbol = yyvsp[-1].arbol;}
break;
case 166:
#line 740 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '{' de apertura del bloque ejecutable de la sentencia ");}
break;
case 167:
#line 741 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '}' de cierre del bloque ejecutable de la sentencia ");}
break;
case 168:
#line 745 "gramatica.y"
{AtributosTablaS atributos = new AtributosTablaS("Condicion");
                                                                  atributos.setAmbito(ambito);
                                                                  AtributosTablaS atributos2 = new AtributosTablaS(yyvsp[-1].sval);
                                                                  atributos2.setAmbito(ambito);
                                                                  yyval.arbol = new NodoCondicionIf(new NodoExpresionLogica(yyvsp[-2].arbol,yyvsp[0].arbol,atributos2),null,atributos);}
break;
case 170:
#line 753 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 171:
#line 754 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta una expresion aritmetica en la condicion ");}
break;
case 172:
#line 755 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " condicion mal declarada ");}
break;
case 173:
#line 758 "gramatica.y"
{yyval = new ParserVal("<");}
break;
case 174:
#line 759 "gramatica.y"
{yyval = new ParserVal(">");}
break;
case 175:
#line 760 "gramatica.y"
{yyval = new ParserVal("=");}
break;
case 176:
#line 761 "gramatica.y"
{yyval = new ParserVal(">=");}
break;
case 177:
#line 762 "gramatica.y"
{yyval = new ParserVal("<=");}
break;
case 178:
#line 763 "gramatica.y"
{yyval = new ParserVal("=!");}
break;
case 179:
#line 766 "gramatica.y"
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
case 180:
#line 787 "gramatica.y"
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
case 181:
#line 806 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se leyo una sentencia de control erronea");}
break;
case 182:
#line 809 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el contenido dentro de los parentensis del for");}
break;
case 183:
#line 812 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Incremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoIncrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval)), null, atributos1);}
break;
case 184:
#line 816 "gramatica.y"
{
                          AtributosTablaS atributos1 = new AtributosTablaS("Decremento");
                          atributos1.setAmbito(ambito);
                          yyval.arbol  = new NodoDecrementoFor(new NodoHoja(Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[0].sval)), null, atributos1);}
break;
case 185:
#line 820 "gramatica.y"
{ yyval.arbol = null;}
break;
case 186:
#line 823 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el signo '+' o '-' antes de la constante");}
break;
case 187:
#line 824 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '-'");}
break;
case 188:
#line 825 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera luego del '+'");}
break;
case 189:
#line 826 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el incremento debe ser un numero entero");}
break;
case 190:
#line 827 "gramatica.y"
{Main.erroresSemanticos.add("Error semantico: Linea " + Lexico.linea + " el decremento debe ser un numero entero");}
break;
case 191:
#line 830 "gramatica.y"
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
case 193:
#line 868 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la asignacion se la sentencia FOR ");}
break;
case 194:
#line 869 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '=:' en la asignacion de la sentencia FOR ");}
break;
case 195:
#line 870 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la constante entera de la asignacion de la sentencia FOR ");}
break;
case 196:
#line 873 "gramatica.y"
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
case 198:
#line 892 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el identificador en la condicion de la sentencia FOR ");}
break;
case 199:
#line 893 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el comparador en la condicion de la sentencia FOR ");}
break;
case 200:
#line 894 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la expresion aritmetica en la condicion de la sentencia FOR ");}
break;
case 201:
#line 897 "gramatica.y"
{Main.informesSintacticos.add("[Parser | Linea " + Lexico.linea + "] se realizó una sentencia de salida OUT");
                          AtributosTablaS lexSalida = new AtributosTablaS("Sentencia de Impresion por Pantalla");
                          lexSalida.setAmbito(ambito);
                          AtributosTablaS lexCadena = Main.tablaDeSimbolos.getAtributosTablaS(yyvsp[-1].sval);
                          lexCadena.setAmbito(ambito);
                          yyval.arbol = new NodoSalida(new NodoHoja(lexCadena),null,lexSalida);
                          }
break;
case 203:
#line 907 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el '(' que encierra la cadena ");}
break;
case 204:
#line 908 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta la cadena que se quiere imprimir ");}
break;
case 205:
#line 909 "gramatica.y"
{Main.erroresSintacticos.add("Error sináctico: Linea " + Lexico.linea + " falta el ')' que encierra la cadena ");}
break;
#line 2222 "y.tab.c"
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
