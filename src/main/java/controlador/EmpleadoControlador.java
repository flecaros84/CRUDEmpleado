// Declaración del paquete controlador que agrupa los controladores de la aplicación.
package controlador;

// Importaciones necesarias para manejar modelos, DAO y funcionalidad de servlets.
import dao.EmpleadoDAO; // DAO para manejar las operaciones de acceso a datos de empleados.
import modelo.Empleado; // Modelo que representa a un empleado.
import java.io.IOException; // Manejo de excepciones de entrada/salida.
import java.io.PrintWriter; // Permite escribir datos en la respuesta HTTP.
import jakarta.servlet.ServletException; // Manejo de excepciones de servlets.
import jakarta.servlet.http.HttpServlet; // Clase base para crear servlets.
import jakarta.servlet.http.HttpServletRequest; // Representa una solicitud HTTP.
import jakarta.servlet.http.HttpServletResponse; // Representa una respuesta HTTP.

// Clase "EmpleadoControlador" que extiende HttpServlet y actúa como controlador principal para manejar solicitudes relacionadas con empleados.
public class EmpleadoControlador extends HttpServlet {

    // Instancia del DAO para manejar las operaciones de empleados.
    private EmpleadoDAO empDao = new EmpleadoDAO();

    // Rutas a las páginas JSP para listar y agregar nuevos empleados.
    private final String pagListar = "/vista/listar.jsp"; // Página para listar empleados.
    private final String pagNuevo = "/vista/nuevo.jsp"; // Página para agregar o editar empleados.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Maneja solicitudes GET llamando a processRequest.
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Maneja solicitudes POST llamando a processRequest.
        processRequest(request, response);
    }

    // Método central para procesar todas las solicitudes HTTP (GET y POST).
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // Establece el tipo de contenido y la codificación.

        // Obtiene el parámetro "accion" para determinar qué acción realizar.
        String accion = request.getParameter("accion");

        // Switch para redirigir la solicitud a la acción correspondiente.
        switch (accion) {
            case "listar": // Acción para listar empleados.
                listar(request, response);
                break;
            case "nuevo": // Acción para mostrar el formulario de nuevo empleado.
                nuevo(request, response);
                break;
            case "guardar": // Acción para guardar un empleado (nuevo o editar).
                guardar(request, response);
                break;
            case "editar": // Acción para editar un empleado existente.
                editar(request, response);
                break;
            case "eliminar": // Acción para eliminar un empleado.
                eliminar(request, response);
                break;
            default: // Manejo de acciones no definidas.
                throw new AssertionError();
        }
    }

    // Método para listar todos los empleados y enviarlos a la vista correspondiente.
    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); // Define el tipo de contenido.
        request.setAttribute("empleados", empDao.ListarTodos()); // Agrega la lista de empleados al request.
        request.getRequestDispatcher(pagListar).forward(request, response); // Redirige a la página de listado.
    }

    // Método para mostrar el formulario de nuevo empleado.
    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleado", new Empleado()); // Crea un objeto Empleado vacío.
        request.getRequestDispatcher(pagNuevo).forward(request, response); // Redirige al formulario de nuevo empleado.
    }

    // Método para guardar un empleado (nuevo o actualizado).
    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado obj = new Empleado(); // Crea un objeto Empleado.
        // Asigna los valores obtenidos del formulario a las propiedades del objeto.
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombres(request.getParameter("nombres"));
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setFechaIngreso(request.getParameter("fechaIngreso"));
        obj.setSueldo(Double.parseDouble(request.getParameter("sueldo")));
        obj.setEspecialidad(request.getParameter("especialidad"));

        int result;

        if (obj.getId() == 0) { // Si el ID es 0, se trata de un nuevo registro.
            result = empDao.registrar(obj);
        } else { // Si el ID existe, se trata de una actualización.
            result = empDao.editar(obj);
        }

        if (result > 0) { // Si la operación fue exitosa.
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("EmpleadoControlador?accion=listar"); // Redirige al listado de empleados.
        } else { // Si la operación falló.
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("empleado", obj); // Reenvía los datos ingresados.
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    // Método para buscar y mostrar un empleado existente para editarlo.
    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Obtiene el ID del empleado.
        Empleado obj = empDao.buscarPorId(id); // Busca el empleado por ID.

        if (obj != null) { // Si el empleado existe.
            request.setAttribute("empleado", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response); // Redirige al formulario con los datos cargados.
        } else { // Si no se encuentra el empleado.
            request.getSession().setAttribute("error", "No se encontro empleado con ID");
            response.sendRedirect("EmpleadoControlador?accion=listar"); // Redirige al listado.
        }
    }

    // Método para eliminar un empleado por su ID.
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Obtiene el ID del empleado a eliminar.
        int result = empDao.eliminar(id); // Elimina el empleado y guarda el resultado.

        if (result > 0) { // Si la eliminación fue exitosa.
            request.getSession().setAttribute("success", "Empleado con id " + id + " eliminado!");
        } else { // Si la eliminación falló.
            request.getSession().setAttribute("error", "No se pudo eliminar empleado");
        }
        response.sendRedirect("EmpleadoControlador?accion=listar"); // Redirige al listado de empleados.
    }

}

