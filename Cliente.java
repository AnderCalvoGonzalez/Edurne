
import java.net.*;
import java.util.*;
import java.io.*;
public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Instancia BufferedReader que sirve para guardar los datos introducidos 
        //por el usuario
        BufferedReader in = new BufferedReader(InputStreamReader(System.in));

        //Declaramos un objeto socket para realizar la comunicacion(Cliente-Servidor)
        Socket socket;

        //declaramos e instanciamos un objeto de tipo BYTE
        byte[] mensaje_bytes = new byte[256];

        //Declaramos un variable de tipo String
        String mensaje = "";

        //declaramos un bloque try-catch para controlar la ejecucion del subprograma
        try {
            //intranciamos un socket la direccion del destino y
            //el puerto que vamos a utilizar para la comunicacion
            socket = new Socket("192.168.1.128",6200);

            //Declaramos e instanciamos el objeto DataOutputStream
            //que sirve para enviar datos al servidor destino
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            
            //Creamos el bucle Do-While en el que enviamos al servidor el mesanje, los datos que hemos
            //obtenido despues de ejecutar la funcion "readline" en la instancia "in"

            do {
                mensaje = in.readLine();
                //enviamos el mensaje codificado en UTF
                out.writeUTF(mensaje);

            //mientras el mensaje no se encuentre en la cadena "fin", seguiremos ejecutando el bucle
            }while(!mensaje.startsWith("fin"));

//utilizamos el catch para capturar los errores que puedan surgir 
        }catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        
    }

    private static Reader InputStreamReader(InputStream in) {
        return null;
    }
} 