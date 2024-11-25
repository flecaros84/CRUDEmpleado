<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Directiva de página que establece el tipo de contenido como "text/html" y define la codificación UTF-8 
     para manejar caracteres especiales correctamente. -->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Declaración de la biblioteca de etiquetas JSTL (JavaServer Pages Standard Tag Library) 
     con prefijo "c", utilizada para manejar lógica de presentación, como bucles y condiciones. -->

<!DOCTYPE html>
<!-- Declaración del tipo de documento como HTML5. -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Metaetiqueta que define el tipo de contenido y la codificación como UTF-8. -->

        <!-- Enlace al archivo CSS de Bootstrap para usar componentes y estilos predefinidos. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <!-- Enlace al archivo CSS de Font Awesome para usar íconos. -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css" 
              integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ==" 
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <title>Empleados</title>
        <!-- Título de la página que aparece en la pestaña del navegador. -->
    </head>
    <body>
        <div class="container mt-3">
            <!-- Contenedor principal con margen superior para organizar el contenido. -->
            <h3>Gest. Empleados</h3>
            <!-- Encabezado principal de la página. -->
            <hr />
            <!-- Línea horizontal separadora. -->

            <!-- Botón para redirigir al formulario de nuevo empleado. -->
            <a href="EmpleadoControlador?accion=nuevo" class="btn btn-success btn-sm">
                <i class="fa fa-plus-circle"></i> Nuevo
                <!-- Ícono y texto del botón utilizando Font Awesome y estilos de Bootstrap. -->
            </a>

            <!-- Inclusión de un componente JSP que muestra mensajes (éxito o error). -->
            <jsp:include page="../components/Mensaje.jsp"/>

            <!-- Tabla para mostrar los empleados listados. -->
            <table class="table table-bordered table-striped mt-2">
                <!-- Clase de Bootstrap para bordes y estilo de la tabla. -->
                <thead>
                    <!-- Encabezado de la tabla. -->
                    <tr>
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Fecha Ingreso</th>
                        <th>Sueldo</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Bucle para iterar sobre la lista de empleados enviada desde el controlador. -->
                    <c:forEach items="${empleados}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <!-- Muestra el ID del empleado. -->
                            <td>${item.nombres}</td>
                            <!-- Muestra los nombres del empleado. -->
                            <td>${item.apellidos}</td>
                            <!-- Muestra los apellidos del empleado. -->
                            <td>${item.fechaIngreso}</td>
                            <!-- Muestra la fecha de ingreso del empleado. -->
                            <td>${item.sueldo}</td>
                            <!-- Muestra el sueldo del empleado. -->
                            <td> 
                                <!-- Botón para editar al empleado. -->
                                <a href="EmpleadoControlador?accion=editar&id=${item.id}" 
                                   class="btn btn-info btn-sm">
                                    <i class="fa fa-edit"></i>
                                    <!-- Ícono de edición. -->
                                </a>
                                <!-- Botón para eliminar al empleado con confirmación. -->
                                <a href="EmpleadoControlador?accion=eliminar&id=${item.id}"
                                   onclick="return confirm('¿Está seguro que desea eliminar el empleado con id ${item.id}?')"
                                   class="btn btn-danger btn-sm">
                                    <i class="fa fa-trash"></i>
                                    <!-- Ícono de eliminación. -->
                                </a>   
                            </td>
                        </tr>
                    </c:forEach>
                    <!-- Condición para mostrar un mensaje si la lista de empleados está vacía. -->
                    <c:if test="${empleados.size()==0}">
                        <tr>
                            <td colspan="5">No hay registros</td>
                            <!-- Mensaje que ocupa todas las columnas si no hay empleados. -->
                        </tr>
                    </c:if>    
                </tbody>            
            </table>
        </div>
    </body>
</html>
