package Principal;
import ArbolSintactico.ArbolSintactico;
import Assembler.Assembler;
import Parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    private static BufferedReader texto; // Se utiliza para leer texto de un flujo de entrada de caracteres.
    public static TablaSimbolos tablaDeSimbolos = new TablaSimbolos();
    public static List<String> informesSintacticos = new ArrayList<>();

    public static List<String> informesSemanticos = new ArrayList<>();

    public static List<String> erroresSintacticos = new ArrayList<>();
    public static List<String> erroresLexicos = new ArrayList<>();

    public static List<String> erroresSemanticos = new ArrayList<>();

    public static List<String> listaDeAmbitos = new ArrayList<>();


    private static StringBuilder obtenerTextoALeer(BufferedReader ubicacion) throws IOException { //Metodo para obtener el texto a leer que contiene excepciones a errores no evitables por parte del programador.

        StringBuilder buffer = new StringBuilder();

        texto = new BufferedReader(new FileReader(ubicacion.readLine()));
        String lineaActualDeLectura;

        while ((lineaActualDeLectura = texto.readLine())!= null) {
            buffer.append(lineaActualDeLectura + "\n"); //Se inserta cada linea del texto una despues de la anterior.
        }

        buffer.deleteCharAt(buffer.length()-1);
        buffer.append("$"); // Se inserta al final de la lectura, el signo '$' haciendo referencia al final del archivo en cuestion.

        return buffer;
    }

    public static void main(String[]args) throws IOException {

        //Se procede a cargar el archivo con el texto de entrada.

        InputStreamReader leer = new InputStreamReader(System.in); //Se utiliza para hacer un puente de bytes a caracteres.
        BufferedReader buffer = new BufferedReader(leer);

        System.out.print("Ingrese la ruta del archivo: ");
        String direccion = buffer.readLine();

        InputStream is = new ByteArrayInputStream(direccion.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder codigo = new StringBuilder(obtenerTextoALeer(br));

        System.out.println("Contenido del archivo: ");
        System.out.println(codigo);

        System.out.println("");

        Lexico l1 = new Lexico(codigo);

        Parser p = new Parser(l1);
        System.out.println("Corriendo Parser");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Informes Lexicos :");
        System.out.println("");
        p.run();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Informes Sintacticos :");
        System.out.println("");
        for (String s : informesSintacticos) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Informes Semanticos :");
        System.out.println("");
        for (String s : informesSemanticos) {
            System.out.println(s);
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Errores Lexicos :");
        System.out.println("");
        for (String l : erroresLexicos) {
            System.out.println(l);
        }
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Errores Sintacticos :");
        System.out.println("");
        for (String e : erroresSintacticos) {
            System.out.println(e);
        }

        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Errores Semánticos :");
        System.out.println("");
        for (String e : erroresSemanticos) {
            System.out.println(e);
        }

        if (erroresSemanticos.isEmpty() && erroresSintacticos.isEmpty() && erroresLexicos.isEmpty()) {

            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Arbol sintáctico ");
            System.out.println(p.printSyntacticTree());

            ArbolSintactico arbol = p.returnTree();
            Assembler assembler = new Assembler(arbol);
            assembler.generarCodigoAssembler();
        }
        else {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("No se puede mostrar arbol ni codigo assembler dado que se presentan errores en el texto de entrada");
        }


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Tabla de simbolos ");
        System.out.println("");
        tablaDeSimbolos.mostrarTablasimbolos();

    }

}
