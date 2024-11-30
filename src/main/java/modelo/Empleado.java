// Declaración del paquete "modelo", que probablemente agrupa las clases relacionadas con la lógica de negocio o modelos de datos.
package modelo;

// Definición de la clase "Empleado", que representa un empleado con sus atributos y métodos asociados.
public class Empleado {

    // Declaración de los atributos privados de la clase "Empleado".
    private int id;                // Identificador único del empleado.
    private String nombres;        // Nombre(s) del empleado.
    private String apellidos;      // Apellido(s) del empleado.
    private String fechaIngreso;   // Fecha en la que el empleado ingresó a la organización.
    private double sueldo;         // Sueldo del empleado.
    private String especialidad;   // Especialidad del empleado

    // Método público para obtener el valor del atributo "id".
    public int getId() {
        return id;
    }

    // Método público para establecer el valor del atributo "id".
    public void setId(int id) {
        this.id = id;
    }

    // Método público para obtener el valor del atributo "nombres".
    public String getNombres() {
        return nombres;
    }

    // Método público para establecer el valor del atributo "nombres".
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Método público para obtener el valor del atributo "apellidos".
    public String getApellidos() {
        return apellidos;
    }

    // Método público para establecer el valor del atributo "apellidos".
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Método público para obtener el valor del atributo "fechaIngreso".
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    // Método público para establecer el valor del atributo "fechaIngreso".
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // Método público para obtener el valor del atributo "sueldo".
    public double getSueldo() {
        return sueldo;
    }

    // Método público para establecer el valor del atributo "sueldo".
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

}
