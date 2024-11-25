Para hacerlo funcionar se requiere:

1. Instalar Apache Tomcat 11. Debe ser la versión en carpeta, no con instalador.
2. En el la carpeta de tomcat/conf/tomcat-user.xml deben agregar lo siguiente:
 <tomcat-users>
    <role rolename="manager-gui"/>
    <role rolename="admin-gui"/>
    <role rolename="manager-script"/>
    <user username="admin" password="admin" roles="manager-gui,admin-gui,manager-script"/>
</tomcat-users>    

3. Instalar XAMPP con funcionalidades Apache y Mysql
4. Crear una base de datos bdempleados en Mysql: https://github.com/JoseCastro94/recursos-youtube-crud-javaweb/blob/master/1.%20SCRIPT%20BD/script.sql
5. Verificar que el archivo Source Packages/config/Conexion.java tenga las credenciales correctas de su Mysql
6. Iniciar como administrador el ApacheNetBeans cuando corran la aplicación
