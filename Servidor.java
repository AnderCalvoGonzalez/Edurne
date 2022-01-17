
import java.net.*;

import javax.xml.catalog.Catalog;

import java.io.*;

public class Servidor {
    public static void main(String[] args) {
        //declaramos un objeto de tipo ServerSocket
        ServerSocket socket;
        //creamos una variable de tipo boolean con el valor a false
        Boolean fin = false;

        //Declaramos un bloque try-catch para controlar la ejecucion del subprograma
        try {
            //Instanciamos un ServerSocket con la direccion del destino  el puerto
            // que vamos a utilizar
            socket = new ServerSocket(6200);

            /*Creamos un socket_cli para pasarle el contenido del objeto socket despues
            de ejecutar la funcion accept que nos permitira aceptar conexiones de clientes*/
            Socket socket_cli = socket.accept();
            /*Declaramos e instanciamos el objeto DataInputStream que nos valdrá para recibir datos del cliente*/
            DataInputStream in = new DataInputStream(socket_cli.getInputStream());

            /*Volvemos a crear un bucle Do-While en el que recogemos el mensaje que nos ha enviado el cliente y despues lo mostramos por consola*/
            do {
                String mensaje = "";
                mensaje = in.readUTF();
                System.out.println(mensaje);

            }while(1>0);
            //utilizamos el catch para capturar los errores que puedan surgir 
        }catch(Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
