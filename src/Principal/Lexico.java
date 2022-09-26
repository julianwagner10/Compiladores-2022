package Principal;

import AccionesSemanticas.*;
import Errores.*;

public class Lexico {

    private int F = 50;    // Estado final
    public static StringBuilder textoDeEntrada; // Se representa al texto de entrada como una secuencia mutable de caracteres.

    public static TablaSimbolos tablaSimbolos = new TablaSimbolos();
    public static char caracter; //es el caracter actual que se esta leyendo del texto recibido como entrada.
    public static int cursor; //referencia el indice del texto recibido como entrada.
    public static int linea; //es la linea que se esta leyendo del texto recibido como entrada.

    // PALABRAS RESERVADAS
    public static final int IF = 268;
    public static final int THEN = 269;
    public static final int ELSE = 270;
    public static final int ENDIF = 271;
    public static final int OUT = 272;
    public final static int FUN = 273;
    public final static int RETURN = 274;
    public static final int BREAK = 275;
    public static final int DISCARD = 276;
    public static final int FOR = 277;
    public static final int CONTINUE = 278;
    public static final int F32 = 279;


    //TOKEN SIN ASCII
    public static final int ID = 257;
    public static final int CTE_INT = 258;
    public static final int CTE_FLOTANTE= 259;
    public static final int MENOR_IGUAL = 260;
    public static final int MAYOR_IGUAL = 261;
    public static final int DISTINTO = 262;
    public static final int CADENA = 263;
    public static final int ASIGNACION = 264;

    // ACCIONES SEMANTICAS
    private AccionSemantica as1 = new AccionSemantica1();
    private AccionSemantica as2 = new AccionSemantica2();
    private AccionSemantica as3 = new AccionSemantica3();
    private AccionSemantica as4 = new AccionSemantica4();
    private AccionSemantica as5 = new AccionSemantica5();
    private AccionSemantica as6 = new AccionSemantica6();
    private AccionSemantica as7 = new AccionSemantica7();
    private AccionSemantica as8 = new AccionSemantica8();
    private AccionSemantica as9 = new AccionSemantica9();
    private AccionSemantica as10 = new AccionSemantica10();
    private AccionSemantica as11 = new AccionSemantica11();
    private AccionSemantica as12 = new AccionSemantica12();
    private AccionSemantica as13 = new AccionSemantica13();
    private AccionSemantica as14 = new AccionSemantica14();

    // ERRORES
    private Error1 err1 = new Error1();

    private Error2 err2 = new Error2();
    private Error3 err3 = new Error3();
    private Error4 err4 = new Error4();
    private Error5 err5 = new Error5();
    private Error6 err6 = new Error6();
    private Error7 err7 = new Error7();


    private int[][] matrizTransiciones = {
          //L,l  _  d  .   +   -  <  >  =  ‘  !  /  :  bt nl 'F' ot $
            //0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17
            {1, -1, 2, 3, F, F, 8, 10, 11, 12, F, F, F, 0, 0, 1, F, F},//0
            {1, 1, 1, F, F, F, F, F, F, F, F, F, F, F, F, 1, F, F },//1
            {F, F, 2, 4, F, F, F, F, F, F, F, F, F, F, F, F, F, F },//2
            {-1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, F},//3 todo caracter que no sea un digito es considerado como un error.
            {F, F, 4, F, F, F, F, F, F, F, F, F, F, F, F, 5, F, F},//4
            {-1, -1, 7, -1, 6, 6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, F},//5
            {-1, -1, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, F},//6 todo caracter que no sea un digito es considerado como un error.
            {F, F, 7, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},//7
            {F, F, F, F, F, F, 9, F, F, F, F, F, F, F, F, F, F, F},//8
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 0, 9, 9, F},//9
            {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F},//10
            {F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F}, //11
            {12, 12, 12, 12, 12, 12, 12, 12, 12, F, 12, 13, 12, 12, -1, 12, 12, F},//12
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1, -1, F},//13
    };

    private AccionSemantica[][] accionesEnTabla = {
            //L,l  _  d  .   +   -  <  >  =  ‘  !  /  :  bt nl 'F' ot $
            //0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17
            {as1, err1, as1, as1, as6, as6, null, null, null, as1, null, null, null, null, null, as1, as6, null},//0
            {as2, as2, as2, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3 },//1
            {as4, as4, as2, as2, as4, as4, as4, as4, as4, as4, as4, as4, as4, as4, as4, as4, as4, as4 },//2
            {err2, err2, as2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2},//3
            {as5, as5, as2, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as2, as5, as5},//4
            {err4, err4, as2, err4, as2, as2, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4},//5
            {err2, err2, as2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2},//6
            {as5, as5, as2, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5},//7
            {as8, as8, as8, as8, as8, as8, null, as8, as7, as8, as8, as8, as8, as8, as8, as8, as8, as8},//8
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},//9
            {as10, as10, as10, as10, as10, as10, as10, as10, as9, as10, as10, as10, as10, as10, as10, as10, as10, as10},//10
            {as13, as13, as13, as13, as13, as13, as13, as13, as13, as13, as12, as13, as11, as13, as13, as13, as13, as13},//11
            {as2, as2, as2, as2, as2, as2, as2, as2, as2, as14, as2, null, as2, as2, err5, as2, as2, as2},//12
            {err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, null, err6, err6, err6},//13
    };

    public Lexico(StringBuilder textoDeEntrada) {
        linea = 1;
        cursor = 0;
        this.textoDeEntrada = textoDeEntrada;

        caracter = textoDeEntrada.charAt(cursor);
        this.tablaSimbolos.setSimbolo("if",268);
        this.tablaSimbolos.setSimbolo("then",269);
        this.tablaSimbolos.setSimbolo("else",270);
        this.tablaSimbolos.setSimbolo("end-if",271);
        this.tablaSimbolos.setSimbolo("out",272);
        this.tablaSimbolos.setSimbolo("fun",273);
        this.tablaSimbolos.setSimbolo("return",274);
        this.tablaSimbolos.setSimbolo("break",275);
        this.tablaSimbolos.setSimbolo("discard",276);
        this.tablaSimbolos.setSimbolo("for",277);
        this.tablaSimbolos.setSimbolo("continue",278);
        this.tablaSimbolos.setSimbolo("f32",279);
    }



    private int obtenerColumna(char caracter) { //Queremos obtener la columna que representa el caracter ingresante a mi estado actual.

        if (caracter == 83)                         //Representacion correspondiente ASCII para letra S
            return 15;
        if ((caracter >= 65) && (caracter <= 90))   //Representacion correspondiente ASCII para letras mayusculas
            return 0;
        if ((caracter >= 97) && (caracter <= 122))  //Representacion correspondiente ASCII para letras minusculas
            return 0;
        if (caracter == 95)                         //Representacion correspondiente ASCII para guion bajo
            return 0;
        if ((caracter >= 48) && (caracter <= 57))   //Representacion correspondiente ASCII para digitos numericos.
            return 1;
        if (caracter == 46)                         //Representacion correspondiente ASCII para el .(punto)
            return 2;
        if (caracter == 43)                         //Representacion correspondiente ASCII para signo +
            return 3;
        if (caracter == 45)                         //Representacion correspondiente ASCII para signo -
            return 4;
        if (caracter == 60)                         //Representacion correspondiente ASCII para <
            return 5;
        if (caracter == 62)                         //Representacion correspondiente ASCII para >
            return 6;
        if (caracter == 61)                         //Representacion correspondiente ASCII para =
            return 7;
        if (caracter == 38)                         //Representacion correspondiente ASCII para &
            return 8;
        if (caracter == 179)                         //Representacion correspondiente ASCII para |
            return 9;
        if (caracter == 47)                         //Representacion correspondiente ASCII para /
            return 10;
        if (caracter == 58)                         //Representacion correspondiente ASCII para :
            return 11;
        if (caracter == 37)                         //Representacion correspondiente ASCII para %
            return 12;
        if ((caracter == 32) || (caracter == 9))    //Representacion correspondiente ASCII para tab = 9 y blanco = 32
            return 13;
        if (caracter == 10)                         //Representacion correspondiente ASCII para salto de linea
            return 14;
        if (caracter == 42 || caracter == 44 || caracter == 41 || caracter == 40  || caracter == 59) //Representacion correspondiente ASCII para '*' , '(' , ')' , ',' , ';'
            return 16;
        if (caracter == 36)                         //Representacion correspondiente ASCII para '$' (fin de archivo).
            return 17;

        return -1; //el caracter en cuestion no se asocia a ninguno de los presentes dentro de la tabla, se debe devolver un caracter invalido.
    }

    public Token obtenerToken() {

        Token token = null;
        int estadoActual = 0;
        int columna;

        while ((cursor < textoDeEntrada.length()) && (caracter != '$') ) { // mientras no llego al final del texto entrante
            caracter = textoDeEntrada.charAt(cursor);
            columna = obtenerColumna(caracter);
            cursor++;

            if (columna == -1) // se detecto un error ya que el caracter es invalido.
                return new Error7().ejecutarAccion();
            else
            { // Si el caracter en cuestion pertenece al lenguaje

                if (accionesEnTabla[estadoActual][columna] != null) // si hay una AS a realizar
                    token = accionesEnTabla[estadoActual][columna].ejecutarAccion(); //se ejecuta la accion semantica, sino un error.

                estadoActual = matrizTransiciones[estadoActual][columna]; // Siempre debo cambiar de estado.

                if (estadoActual == -1)
                    return token; //Retorna null y vuelve al estado 0 en la proxima iteracion.
                else
                if ((estadoActual == F) && (token != null))// En estado final siempre hay un token(distinto de null) para retornar.
                    return token;

                if (estadoActual == F)
                    estadoActual = 0;
            }

            if (caracter == '\n')
                linea++;


        }

        return new Token(0); //Principal.Token = 0 de fin de archivo
    }
}