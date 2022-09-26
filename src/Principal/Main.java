package Principal;
import java.io.*;
public class Main{

    private static BufferedReader texto; // Se utiliza para leer texto de un flujo de entrada de caracteres.
    public static TablaSimbolos tablaDeSimbolos = new TablaSimbolos();

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

        /*Parser p = new Parser(l1);
        System.out.println("Corriendo Parser");
        System.out.println("------------------------------------------");
        p.run();*/

        System.out.println("\n TABLA DE SIMBOLOS ");
        //tablaDeSimbolos.mostrarTablasimbolos();
    }
}
