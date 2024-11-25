<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Directiva de la página JSP que establece el tipo de contenido de la respuesta como "text/html" 
     y define la codificación de la página como "UTF-8", para manejar correctamente caracteres especiales. -->

<!DOCTYPE html>
<!-- Declaración del tipo de documento para definir que esta página es un documento HTML5. -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Metaetiqueta que asegura que el contenido de la página se interpretará como texto HTML 
             con codificación UTF-8, para manejar correctamente caracteres especiales. -->
        <title>Inicio</title>
        <!-- Título de la página web que aparece en la pestaña del navegador. -->
    </head>
    <body>
       <%
            // Código Java embebido en la página JSP.
            // Utiliza el objeto `response` para redirigir la solicitud HTTP a otra URL.
            response.sendRedirect("EmpleadoControlador?accion=listar");
            // Redirige al usuario al controlador "EmpleadoControlador", 
            // pasando el parámetro "accion" con el valor "listar".
            // Esto generalmente se utiliza para delegar la lógica de negocio 
            // y mostrar una lista de empleados u otra acción específica.
       %>
    </body>
</html>
