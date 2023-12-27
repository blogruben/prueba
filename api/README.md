# Albums

# Requisitos
- Docker
- JDK 17 

# Configuracion inicial
https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.2.1&packaging=war&jvmVersion=17&groupId=com.typicode&artifactId=jsonplaceholder&name=jsonplaceholder&description=Api%20Rest&packageName=com.typicode.jsonplaceholder&dependencies=data-jpa,h2,web,devtools,cloud-feign,lombok


# Iniciar localmente
1. Descarga JDK17
En caso de necesitrlo usar el script xxx del directorio padre.
2. Compilar
gradlew build;
3. Arrancar local
gradlew bootRun;


# Desplegar en docker
1. Compilar imagen
docker build -t api . 
2. Ejecutar contenedor
docker run -dp 8080:8080 api
3. Ver logs
docker logs -f api


# Funcionalidad


# Pattern 
Usamos el patron mcv para separar en capas la diferentes partes.
Segun la regla de dependencia la capas superioresde la aplicacion dependen de la inferiores. (y no al reves)
Controler dependecia de la capa de servicio. Y esta a su vez de repository y client.
Por otro lado las excepcions y models son transversales del modelo MVC.
DEbido a que el modelo (clase Album y photo) esta compartido tanto para una API rxterna como sen la extructura de la bbdd
esta tiene dos motivos para ser modificado. Por tanto no cumpled con el prnicipio de responsabilidad unica de SOLID. 

Esto podria solucionar usando empleado la arquitectura hexagonal, en la cual la llamada al servicio exterior estaria en 
un adaptador y la comunicación con la bbdd estaria en otro adaptador en la capa de infructura,
la cual se comunica a la capa de aplicacion a través de los puertos. 
Manteniendo el modelo interno, esquema de BBDD, y la estrucutra del json de la API externa por separado.
sin embargo anadira una complejidad que facilmente lleva al a sobre ingenieria para un microservicio sencillo,
y romperia el principio KISS. 
Ademas el único objeto de la bbdd es persister los datos de la api externa, por lo que si la api externa cambiara 
el esquema de los datos en la practica deberiamos cambiar tambien la estructura de la bbdd. 

El patron repository XXXXXXXXXXXXXXXXXXX


**Controler** gestiona las peticiones de la API Rest
**Service** implementa la lógica del negocio (caso de usos)
**Repository** persistir los beans del modelo en BBDD.
**client** cliente API de REST de la API pública jsonplaceholder.
**exceptions** configuracion general de la app
**models** 



https://jsonplaceholder.typicode.com/
XXXX DIAGRAMA swagger

# BBDD
Aceder a la consola de h2 -> http://localhost:8080/h2-ui/

SELECT * FROM PHOTO;
SELECT * FROM Album;
INSERT INTO ALBUM VALUES(1, 'title',10);
INSERT INTO PHOTO VALUES(1, 1, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(2, 1, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(3, 1, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO ALBUM VALUES(2, 'title',10);
INSERT INTO PHOTO VALUES(4, 2, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(5, 2, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(6, 2, 'THUMBNAIL_URL','TITLE','URL');


# Test de integracion
1. ejecutar tests
gradlew test  
Se genera reporte en build/reports/tests/test/index.html


xxxxxxxxxxxxxxxxxx ejecutar integracion y unitarios por separad

hablar de postman

2. Ver cobertura
gradlew check
Se genera reporte en build/reports/jacoco/test/html/index.html