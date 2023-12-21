# Java WAR

Los proyectos de Java, si se compilan usnado gradlew.bat
automaticamnete de descarga el JDK8 en el directorio 
padre para usarlo localmente.
En caso de Unix, gradlew se necesitaria tener configurado el JDK.

No se modifica la variable JAVA_HOME y ni se instala nada en el SO,
se descarga y extrae el JDK8 en el este directorio.

Se compila por medio de 'gradle build'
Se ejecutan los jar con 'gradle run'
Y se levanta el servidor interno con 'gradle appStart'