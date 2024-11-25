// Paquete donde se encuentra la clase DAO para manejar la lógica de acceso a datos.
package dao;

// Importación de clases necesarias.
import modelo.Empleado;        // Clase modelo que representa a un empleado.
import config.Conexion;        // Clase que proporciona la conexión a la base de datos.
import java.sql.Connection;    // Clase para manejar la conexión con la base de datos.
import java.sql.PreparedStatement; // Clase para consultas SQL parametrizadas.
import java.sql.ResultSet;     // Clase para manejar los resultados de consultas SQL.
import java.util.ArrayList;    // Clase para manejar listas dinámicas.

// Clase DAO que implementa las operaciones de acceso a datos para el modelo Empleado.
public class EmpleadoDAO {

    // Declaración de atributos necesarios para la conexión y manejo de consultas.
    private Connection cn = null;          // Objeto para manejar la conexión a la base de datos.
    private PreparedStatement ps = null;  // Objeto para preparar y ejecutar consultas SQL.
    private ResultSet rs = null;          // Objeto para manejar los resultados de las consultas.

    // Método para listar todos los empleados de la base de datos.
    public ArrayList<Empleado> ListarTodos() {
        ArrayList<Empleado> lista = new ArrayList<>(); // Lista que almacenará los empleados.

        try {
            cn = Conexion.getConnection(); // Obtiene la conexión a la base de datos.
            String sql = "select * from empleado"; // Consulta SQL para obtener todos los empleados.
            ps = cn.prepareStatement(sql); // Prepara la consulta SQL.
            rs = ps.executeQuery(); // Ejecuta la consulta y almacena el resultado.

            // Recorre los resultados obtenidos.
            while (rs.next()) {
                Empleado obj = new Empleado(); // Crea un nuevo objeto Empleado.
                obj.setId(rs.getInt("id")); // Asigna el ID del empleado.
                obj.setNombres(rs.getString("nombres")); // Asigna el nombre.
                obj.setApellidos(rs.getString("apellidos")); // Asigna el apellido.
                obj.setFechaIngreso(rs.getString("fecha_ingreso")); // Asigna la fecha de ingreso.
                obj.setSueldo(rs.getDouble("sueldo")); // Asigna el sueldo.
                lista.add(obj); // Agrega el empleado a la lista.
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Imprime la traza del error si ocurre una excepción.
        } finally {
            try {
                if (cn != null) { cn.close(); } // Cierra la conexión a la base de datos.
                if (rs != null) { rs.close(); } // Cierra el ResultSet.
                if (ps != null) { ps.close(); } // Cierra el PreparedStatement.
            } catch (Exception ex) {
                // Silenciosamente maneja cualquier excepción al cerrar los recursos.
            }
        }

        return lista; // Retorna la lista de empleados.
    }

    // Método para registrar un nuevo empleado en la base de datos.
    public int registrar(Empleado obj) {
        int result = 0; // Variable para almacenar el resultado de la operación.

        try {
            cn = Conexion.getConnection(); // Obtiene la conexión a la base de datos.
            // Consulta SQL para insertar un nuevo empleado.
            String sql = "INSERT INTO empleado(nombres,apellidos,fecha_ingreso,sueldo) VALUES(?,?,?,?)";
            ps = cn.prepareStatement(sql); // Prepara la consulta SQL.
            ps.setString(1, obj.getNombres()); // Asigna el nombre.
            ps.setString(2, obj.getApellidos()); // Asigna el apellido.
            ps.setString(3, obj.getFechaIngreso()); // Asigna la fecha de ingreso.
            ps.setDouble(4, obj.getSueldo()); // Asigna el sueldo.

            result = ps.executeUpdate(); // Ejecuta la consulta y almacena el resultado.

        } catch (Exception ex) {
            ex.printStackTrace(); // Imprime la traza del error si ocurre una excepción.
        } finally {
            try {
                if (cn != null) { cn.close(); } // Cierra la conexión.
                if (ps != null) { ps.close(); } // Cierra el PreparedStatement.
            } catch (Exception ex) {}
        }

        return result; // Retorna el resultado de la operación (número de filas afectadas).
    }

    // Método para buscar un empleado por su ID.
    public Empleado buscarPorId(int id) {
        Empleado obj = null; // Inicializa el objeto empleado como nulo.

        try {
            cn = Conexion.getConnection(); // Obtiene la conexión a la base de datos.
            String sql = "select * from empleado where id=?"; // Consulta SQL para buscar por ID.
            ps = cn.prepareStatement(sql); // Prepara la consulta.
            ps.setInt(1, id); // Asigna el valor del ID.
            rs = ps.executeQuery(); // Ejecuta la consulta y almacena los resultados.

            if (rs.next()) { // Si se encuentra un resultado.
                obj = new Empleado(); // Crea un nuevo objeto Empleado.
                obj.setId(rs.getInt("id")); // Asigna el ID.
                obj.setNombres(rs.getString("nombres")); // Asigna el nombre.
                obj.setApellidos(rs.getString("apellidos")); // Asigna el apellido.
                obj.setFechaIngreso(rs.getString("fecha_ingreso")); // Asigna la fecha de ingreso.
                obj.setSueldo(rs.getDouble("sueldo")); // Asigna el sueldo.
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Imprime la traza del error si ocurre una excepción.
        } finally {
            try {
                if (cn != null) { cn.close(); } // Cierra la conexión.
                if (rs != null) { rs.close(); } // Cierra el ResultSet.
                if (ps != null) { ps.close(); } // Cierra el PreparedStatement.
            } catch (Exception ex) {}
        }

        return obj; // Retorna el empleado encontrado o nulo si no se encuentra.
    }

    // Método para actualizar los datos de un empleado existente.
    public int editar(Empleado obj) {
        int result = 0; // Variable para almacenar el resultado de la operación.

        try {
            cn = Conexion.getConnection(); // Obtiene la conexión a la base de datos.
            // Consulta SQL para actualizar un empleado.
            String sql = "UPDATE empleado SET nombres=?, apellidos=?, fecha_ingreso=?, sueldo=? WHERE id=?";
            ps = cn.prepareStatement(sql); // Prepara la consulta.
            ps.setString(1, obj.getNombres()); // Asigna el nombre.
            ps.setString(2, obj.getApellidos()); // Asigna el apellido.
            ps.setString(3, obj.getFechaIngreso()); // Asigna la fecha de ingreso.
            ps.setDouble(4, obj.getSueldo()); // Asigna el sueldo.
            ps.setInt(5, obj.getId()); // Asigna el ID.

            result = ps.executeUpdate(); // Ejecuta la consulta y almacena el resultado.

        } catch (Exception ex) {
            ex.printStackTrace(); // Imprime la traza del error si ocurre una excepción.
        } finally {
            try {
                if (cn != null) { cn.close(); } // Cierra la conexión.
                if (ps != null) { ps.close(); } // Cierra el PreparedStatement.
            } catch (Exception ex) {}
        }

        return result; // Retorna el resultado de la operación.
    }

    // Método para eliminar un empleado de la base de datos por su ID.
    public int eliminar(int id) {
        int result = 0; // Variable para almacenar el resultado de la operación.

        try {
            cn = Conexion.getConnection(); // Obtiene la conexión a la base de datos.
            String sql = "DELETE FROM empleado WHERE id=?"; // Consulta SQL para eliminar un empleado.
            ps = cn.prepareStatement(sql); // Prepara la consulta.
            ps.setInt(1, id); // Asigna el ID del empleado.

            result = ps.executeUpdate(); // Ejecuta la consulta y almacena el resultado.

        } catch (Exception ex) {
            ex.printStackTrace(); // Imprime la traza del error si ocurre una excepción.
        } finally {
            try {
                if (cn != null) { cn.close(); } // Cierra la conexión.
                if (ps != null) { ps.close(); } // Cierra el PreparedStatement.
            } catch (Exception ex) {}
        }

        return result; // Retorna el resultado de la operación.
    }

}
