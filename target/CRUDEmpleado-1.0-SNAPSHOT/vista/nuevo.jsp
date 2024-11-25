<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Directiva que establece el tipo de contenido como "text/html" y la codificación UTF-8 
     para soportar caracteres especiales correctamente. -->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Declaración de la biblioteca JSTL (JavaServer Pages Standard Tag Library) 
     para usar etiquetas de lógica como bucles y condiciones. -->

<!DOCTYPE html>
<!-- Declaración del documento como HTML5. -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Metaetiqueta que especifica el tipo de contenido y la codificación UTF-8. -->

        <!-- Enlace al archivo CSS de Bootstrap para estilos y diseño responsivo. -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" 
              crossorigin="anonymous">

        <!-- Enlace al archivo CSS de Font Awesome para usar íconos. -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css" 
              integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ==" 
              crossorigin="anonymous" referrerpolicy="no-referrer" />

        <title>Form Empleado</title>
        <!-- Título de la página que aparece en la pestaña del navegador. -->
    </head>
    <body>
        <div class="container mt-3">
            <!-- Contenedor principal con margen superior para organizar el contenido. -->
            <div class="card">
                <!-- Tarjeta de Bootstrap para enmarcar el formulario. -->
                <div class="card-body">
                    <!-- Contenedor del contenido de la tarjeta. -->
                    <h3>${empleado.id==0 ? "Nuevo":"Editar"} Empleado</h3>
                    <!-- Muestra el título dinámico según si el empleado es nuevo (ID=0) o se está editando. -->

                    <hr />
                    <!-- Línea separadora. -->

                    <!-- Formulario para crear o editar un empleado. -->
                    <form action="EmpleadoControlador" method="post">
                        <!-- Enlace al controlador con el método POST para manejar el envío del formulario. -->

                        <div class="mb-3">
                            <!-- Grupo de formulario con margen inferior (Bootstrap). -->
                            <label>Nombres:</label>
                            <!-- Etiqueta para el campo de nombres. -->
                            <input value="${empleado.nombres}" name="nombres" type="text" maxlength="50" 
                                   class="form-control" required>
                            <!-- Campo de texto para ingresar los nombres del empleado, con validación de longitud máxima y requerido. -->
                        </div>
                        <div class="mb-3">
                            <label>Apellidos:</label>
                            <!-- Etiqueta para el campo de apellidos. -->
                            <input value="${empleado.apellidos}" name="apellidos" type="text" maxlength="50" 
                                   class="form-control" required>
                            <!-- Campo de texto para ingresar los apellidos del empleado, con validación de longitud máxima y requerido. -->
                        </div>
                        <div class="mb-3">
                            <label>Fecha Ingreso:</label>
                            <!-- Etiqueta para el campo de fecha de ingreso. -->
                            <input value="${empleado.fechaIngreso}" name="fechaIngreso" type="date" 
                                   class="form-control" required>
                            <!-- Campo de fecha para ingresar la fecha de ingreso del empleado, requerido. -->
                        </div>
                        <div class="mb-3">
                            <label>Sueldo:</label>
                            <!-- Etiqueta para el campo de sueldo. -->
                            <input value="${empleado.sueldo}" name="sueldo" type="number" 
                                   class="form-control" required>
                            <!-- Campo numérico para ingresar el sueldo del empleado, requerido. -->
                        </div>
                        <div class="mb-3">
                            <!-- Campo oculto para enviar el ID del empleado al controlador. -->
                            <input type="hidden" name="id" value="${empleado.id}">
                            <!-- Campo oculto para indicar que la acción a realizar es "guardar". -->
                            <input type="hidden" name="accion" value="guardar">

                            <!-- Botón para guardar los datos del empleado. -->
                            <button class="btn btn-primary btn-sm">
                                <i class="fa fa-save"></i> Guardar
                                <!-- Ícono y texto del botón utilizando Font Awesome. -->
                            </button>

                            <!-- Enlace para volver al listado de empleados. -->
                            <a href="EmpleadoControlador?accion=listar" class="btn btn-dark btn-sm">
                                <i class="fa fa-arrow-left"></i> Volver atrás
                                <!-- Ícono y texto del botón para regresar. -->
                            </a>
                        </div>
                    </form>
                </div> 
            </div>
        </div>
    </body>
</html>
