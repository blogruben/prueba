# Albums

# Requisitos
- Docker
- JDK 17 

# Configuracion inicial
https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.2.0&packaging=war&jvmVersion=17&groupId=com.typicode&artifactId=jsonplaceholder&name=jsonplaceholder&description=Api%20Rest&packageName=com.typicode.jsonplaceholder&dependencies=data-jpa,h2,web,devtools

# Inicializar
//esto descarga JDK17 en caso de existir.
gradlew build;
gradlew bootRun;

docker build -t api .   
docker run -dp 8080:8080 api
docker logs -f api


# BBDD
Aceder a la consola de h2 -> http://localhost:8080/h2-ui/

SELECT * FROM PHOTO;
SELECT * FROM Album;
INSERT INTO ALBUM VALUES(1, 'title',10);
INSERT INTO PHOTO VALUES(2, 1, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(2, 1, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(3, 1, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO ALBUM VALUES(2, 'title',10);
INSERT INTO PHOTO VALUES(4, 2, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(5, 2, 'THUMBNAIL_URL','TITLE','URL');
INSERT INTO PHOTO VALUES(6, 2, 'THUMBNAIL_URL','TITLE','URL');


# Test de integracion
GET  http://localhost:8080/usuario/1
     {"id":1,"nombre":"email","email":"nombre","prioridad":5}

GET   http://localhost:8080/
[{"id":1,"nombre":"email","email":"nombre","prioridad":5},{"id":2,"nombre":"email","email":"nombre","prioridad":5}]

POST  localhost:8080/usuario
body-raw {"id":3,"nombre":"email","email":"nombre","prioridad":5}

