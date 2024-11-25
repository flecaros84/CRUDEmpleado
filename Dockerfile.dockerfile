# Usa una imagen oficial de Tomcat con Java preinstalado
FROM tomcat:10-jdk17

# Copia tu WAR al directorio webapps de Tomcat
COPY target/CRUDEmpleado-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Exponer el puerto 8080 para Tomcat
EXPOSE 8080

# Comando de inicio
CMD ["catalina.sh", "run"]