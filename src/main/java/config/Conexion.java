// Paquete en el que se encuentra la clase "Conexion".
package config;

// Importación de clases necesarias para manejar conexiones a bases de datos.
import java.sql.Connection;       // Representa una conexión a la base de datos.
import java.sql.DriverManager;    // Proporciona métodos para gestionar conexiones con bases de datos.

// Declaración de la clase "Conexion", utilizada para establecer conexiones con una base de datos.
public class Conexion {

    // Declaración de constantes que contienen las credenciales y configuración de la base de datos.
    public static final String username = "root";         // Nombre de usuario para la base de datos.
    public static final String password = "";             // Contraseña para la base de datos (en este caso, vacío).
    public static final String database = "bdempleado";   // Nombre de la base de datos a la que se conecta.
    public static final String url = "jdbc:mysql://localhost:3306/" + database; 
    // URL de conexión a la base de datos. Utiliza el protocolo JDBC para MySQL, 
    // el host es localhost (servidor local), el puerto es 3306 (por defecto de MySQL), 
    // y se concatena el nombre de la base de datos.

    // Método estático que establece y retorna una conexión a la base de datos.
    public static Connection getConnection() {
        Connection cn = null;  // Inicialización de la variable de tipo Connection como nula.
        try {
            // Carga dinámica del controlador JDBC para MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            // Intenta establecer la conexión con los parámetros definidos en 'url', 'username' y 'password'.
            cn = DriverManager.getConnection(url, username, password); 
            // Si la conexión es exitosa, imprime un mensaje en la consola.
            System.out.println("Conexion establecida");
        } catch (Exception ex) {
            // En caso de que ocurra algún error, imprime la traza del error en la consola.
            ex.printStackTrace();
        }
        // Retorna el objeto de conexión (o nulo si la conexión falló).
        return cn;
    }
}

