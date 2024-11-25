<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Directiva JSP que establece el tipo de contenido de la página como "text/html" 
     y define la codificación UTF-8 para manejar caracteres especiales correctamente. -->

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Declaración de la biblioteca JSTL (JavaServer Pages Standard Tag Library) con prefijo "c", 
     utilizada para manejar lógica de presentación como condiciones y eliminación de variables. -->

<!-- Bloque para mostrar un mensaje de error si existe en la sesión. -->
<c:if test="${sessionScope.error != null}">
    <!-- Condición que verifica si la variable `error` existe en el ámbito de sesión. -->
    <div class="alert alert-danger mt-1" role="alert">
        <!-- Contenedor de alerta con estilo de Bootstrap para mostrar un mensaje de error. -->
        ${sessionScope.error}
        <!-- Muestra el contenido del mensaje de error almacenado en `sessionScope.error`. -->
    </div>
    <c:remove var="error" scope="session"/>
    <!-- Elimina la variable `error` del ámbito de sesión después de mostrarla 
         para evitar que se muestre en futuras solicitudes. -->
</c:if>

<!-- Bloque para mostrar un mensaje de éxito si existe en la sesión. -->
<c:if test="${sessionScope.success != null}">
    <!-- Condición que verifica si la variable `success` existe en el ámbito de sesión. -->
    <div class="alert alert-success mt-1" role="alert">
        <!-- Contenedor de alerta con estilo de Bootstrap para mostrar un mensaje de éxito. -->
        ${sessionScope.success}
        <!-- Muestra el contenido del mensaje de éxito almacenado en `sessionScope.success`. -->
    </div>
    <c:remove var="success" scope="session"/>
    <!-- Elimina la variable `success` del ámbito de sesión después de mostrarla 
         para evitar que se muestre en futuras solicitudes. -->
</c:if>
